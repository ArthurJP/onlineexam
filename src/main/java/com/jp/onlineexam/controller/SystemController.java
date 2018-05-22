package com.jp.onlineexam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * TODO:
 *
 * @author <a href="mailto:zhangtylord@gmail.com>张俊鹏</a>
 * @see
 * @since 5/17/2018
 */
@Controller
@RequestMapping("sys")
public class SystemController {

    @GetMapping("index")
    public String index(){
        return "system/index/index";
    }

}
