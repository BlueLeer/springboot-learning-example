package spring.boot.core.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import spring.boot.core.domain.User;
import spring.boot.core.service.UserService;

/**
 * 用户控制层
 *
 * Created by bysocket on 18/09/2017.
 */
@Controller
@RequestMapping(value = "/users")     // 通过这里配置使下面的映射都在 /users
public class UserController {

    @Autowired
    UserService userService;          // 用户服务层

    /**
     *  获取用户分页列表
     *  处理 "/users" 的 GET 请求，用来获取用户分页列表
     *  通过 @RequestParam 传递参数，进一步实现条件查询或者分页查询
     *
     *  Pageable 支持的分页参数如下
     *  page - 当前页 从 0 开始
     *  size - 每页大小 默认值在 application.properties 配置(spring.data.web.pageable.default-page-size)
     */
    @RequestMapping(method = RequestMethod.GET)
    public String getUserPage(Pageable pageable, ModelMap modelMap,int pageNum) {
        PageRequest pageRequest = (PageRequest) pageable;
        Page<User> page = userService.findByPage(pageable);
        modelMap.addAttribute("page",page);
        return "listUsers";
    }

    /**
     *  创建用户
     *    处理 "/users" 的 POST 请求，用来获取用户列表
     *    通过 @RequestBody 绑定实体类参数
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public User postUser(User user, Model model) {
        return userService.insertByUser(user);
    }

    @RequestMapping(value = "/insert",method = RequestMethod.GET)
    public String insertUser(){
        for (int i = 1;i<50;i++){
            User user = new User();
            user.setName("张三"+i);
            user.setAge(23+i);
            user.setBirthday("2018-09-08");
            user.setId(1L+i);
            userService.insertByUser(user);
        }

        return "redirect:/users";
    }

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test(User user,String name){
        System.out.println(user);

        return "test";
    }
}