package demo.springboot.domain;

import demo.springboot.repository.CustomRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


/**
 * Book 数据持久层操作接口
 * <p>
 * Created by bysocket on 09/10/2017.
 * 使用自定义的 Repository
 */
public interface BookRepository extends CustomRepository<Book, Long>, JpaSpecificationExecutor<Book> {

    Long countById(Long id);

    @Modifying
    @Query("update Book b set b.name = ?2 where b.id = ?1")
    int setName(Long id, String name);

//    // 分页查询
//    @Override
//    Page<Book> findAll(Pageable pageable);

    // 使用排序

    @Override
    List<Book> findAll(Sort sort);
}

