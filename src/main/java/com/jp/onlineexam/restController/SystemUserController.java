package com.jp.onlineexam.restController;

import com.jp.onlineexam.service.sys.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO:
 *
 * @author <a href="mailto:zhangtylord@gmail.com>张俊鹏</a>
 * @see
 * @since 5/22/2018
 */
@RestController
@RequestMapping("api-sys")
public class SystemUserController {

    @Autowired
    private UserService userService;

//    @PostMapping("createUser")
//    public
}
