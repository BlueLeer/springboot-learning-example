package demo.springboot.service.impl;

import demo.springboot.domain.Book;
import demo.springboot.domain.BookRepository;
import demo.springboot.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static demo.springboot.domain.CustomerSpecs.*;

import java.util.List;

/**
 * Book 业务层实现
 * <p>
 * Created by bysocket on 30/09/2017.
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    // 分页查询
    @Override
    public List<Book> findAll() {
        PageRequest pageRequest = PageRequest.of(0, 1);
        Page<Book> result = bookRepository.findAll(pageRequest);
        return result.getContent();
    }

    @Override
    public Book insertByBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book update(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book delete(Long id) {
        Book book = bookRepository.findById(id).get();
        bookRepository.delete(book);
        return book;
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findOne(bookSpecificationById(id)).get();
//        return bookRepository.findById(id).get();
    }

    @Override
    public Long countBooks() {
        Long count = bookRepository.countById(1L);
        return count;
    }

    @Override
    @Transactional
    public Integer updateBook(String name, Long id) {
        bookRepository.setName(id, name);
        return null;
    }
}
