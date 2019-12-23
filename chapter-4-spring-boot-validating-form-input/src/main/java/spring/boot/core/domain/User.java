package spring.boot.core.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * 用户实体类
 * <p>
 * Created by bysocket on 21/07/2017.
 */
@Entity
public class User implements Serializable {

    /**
     * 编号
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * 名称
     */
    @NotEmpty(message = "{user.name.notEmpty}")
    @Size(min = 2, max = 8, message = "{user.name.size}")
    private String name;

    /**
     * 年龄
     */
    @NotNull(message = "{user.age.notEmpty}")
    @Min(value = 0, message = "{user.age.min}")
    @Max(value = 300, message = "{user.age.max}")
    private Integer age;

    /**
     * 出生时间
     */
    @NotEmpty(message = "{user.birthday.notEmpty}")
    private String birthday;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }
}
