package demo.springboot.domain;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * @author WangLe
 * @date 2018/12/18 9:44
 * @description JPA提供了基于准则查询方式, 即Criteria查询.而Spring Data JPA 提供了一个Specification(规范)接口让我们更方便的构建准则查询
 */
public class CustomerSpecs {
    public static Specification<Book> bookSpecificationById(Long id) {
        return new Specification<Book>() {
            @Override
            public Predicate toPredicate(Root<Book> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                // 使用Root来获取查询的属性,通过CriteriaBuilder来构造查询条件
                // 查询出id为1L的图书
                return criteriaBuilder.equal(root.get("id"), id);
            }
        };
    }

}
