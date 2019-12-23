package demo.springboot.repository;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 * @author WangLe
 * @date 2018/12/18 10:56
 * @description 自定义Repository, 可以替换掉 JPARepository,继承了SimpleJpaRepository,实现了和JpaRepository一样的功能
 */
// 继承SimpleJpaRepository 就可以使用其提供的一些基础方法,例如findAll()方法
public class CustomRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements CustomRepository<T, ID> {

    // 数据操作中可以使用entityManager,例如下面的entityManager.persist(t);
    private final EntityManager entityManager;

    public CustomRepositoryImpl(Class<T> domainClass, EntityManager entityManager) {
        super(domainClass, entityManager);
        this.entityManager = entityManager;
    }

//    @Override
//    public void insert(T t) {
//        entityManager.persist(t);
//    }
}
