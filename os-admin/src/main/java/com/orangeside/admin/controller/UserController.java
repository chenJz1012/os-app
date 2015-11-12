package com.orangeside.admin.controller;

import com.orangeside.common.utils.PageConvertUtil;
import com.orangeside.urf.model.User;
import com.orangeside.urf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 工程：os-app
 * 创建人 : ChenGJ
 * 创建时间： 2015/9/21
 * 说明：
 */
@Controller @RequestMapping("/adminUser") public class UserController {
    @Autowired UserService userService;

    @RequestMapping("/users") @ResponseBody public Object users(User user,
        @RequestParam(value = "pageNum", required = false) Integer pageNum,
        @RequestParam(value = "pageSize", required = false) Integer pageSize) {
        return PageConvertUtil.grid(userService.findUserList(pageNum, pageSize, user));
    }

    @RequestMapping("/users/{userId}") @ResponseBody Object selectUser(
        @PathVariable(value = "userId") Integer userId) {
        return userService.findUserById(userId);
    }
}
