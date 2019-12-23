package demo.springboot.service.impl;

import demo.springboot.domain.Book;
import demo.springboot.domain.BookRepository;
import demo.springboot.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Book 业务层实现
 * <p>
 * Created by bysocket on 30/09/2017.
 * <p>
 * 详细见:https://www.cnblogs.com/nfcm/p/7833032.html
 */
@Service
@CacheConfig(cacheNames = "books")
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book insertByBook(Book book) {
        return bookRepository.save(book);
    }

    /**
     * @param book {@link Book}
     * @return #p0 : 表示参数索引,这里p0表示book,#p0.id表示book.id
     * @CachePut: 表明Spring应该讲方法的返回值放到缓存中.在方法调用前并不会检查缓存, 方法始终都会被调用
     */
    @CachePut(key = "#p0.id")
    @Override
    public Book update(Book book) {

        System.out.println(" call update method ");
        return bookRepository.save(book);
    }

    /**
     * @param id 编号
     * @return
     * @CacheEvict: 表明Spring应该在缓存中清除一个或多个条目
     */
    @CacheEvict(key = "#p0")
    @Override
    public Book delete(Long id) {
        System.out.println(" call delete method ");
        Book book = bookRepository.findById(id).get();
        bookRepository.delete(book);
        return book;
    }

    /**
     * @param id 编号
     * @return
     * @Cacheable: 表明Spring在调用方法之前, 首先应该在缓存中查找方法的返回值, 如果这个值能够被找到, 就会返回缓存的值.否则的话,
     * 这个方法就会被调用,返回值会放在缓存之中
     */
    @Cacheable(key = "#p0")
    @Override
    public Book findById(Long id) {
        // 如果下面没有被调用,说明缓存使用成功了
        System.out.println(" call findById method ");
        return bookRepository.findById(id).get();


    }
}
