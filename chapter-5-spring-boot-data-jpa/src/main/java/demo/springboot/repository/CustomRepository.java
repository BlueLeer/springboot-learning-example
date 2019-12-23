package demo.springboot.repository;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;

/**
 * @author WangLe
 * @date 2018/12/18 10:53
 * @description 自定义Repository接口;实现了PagingAndSortingRepository接口,所以具备了分页和排序的能力
 */

@NoRepositoryBean // 指明当前的类不是我们领域类的接口,不会在容器中创建bean
public interface CustomRepository<T, ID extends Serializable> extends PagingAndSortingRepository<T, ID> {
//    void insert(T t);
}
