package com.lee.springbootleeactivemq.controller;

import com.lee.springbootleeactivemq.service.MsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * @author WangLe
 * @date 2018/12/21 15:05
 * @description
 */
@Controller
public class MessageController {
    @Autowired
    private MsgService msgService;


    /**
     * 误区:void方法不定义HttpServletResponse类型的入参，Spring MVC会认为@RequestMapping注解中指定的路径就是要返回的视图name
     */
    @GetMapping("/send")
    @ResponseBody
    public void sendMessage(HttpServletResponse response) {
        msgService.sendMessage();
        try {
            response.getWriter().write("success!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
