package spring.boot.core.web;

import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import spring.boot.core.domain.User;

import javax.validation.Valid;

@Controller
@RequestMapping("/lee")
public class LeeController {

    @RequestMapping("/getUser")
    public String getUser(Model model) {
        User user = new User();
        user.setName("wangle");
        user.setAge(18);

        model.addAttribute("user", user);

        return "leeThymeleaf";
    }

    @RequestMapping("/addUser")
    public String addUser(@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            System.out.println(result.getAllErrors().get(0));
            return "leeThymeleaf";
        }

        System.out.println(user);
        return "leeThymeleaf";
    }
}
