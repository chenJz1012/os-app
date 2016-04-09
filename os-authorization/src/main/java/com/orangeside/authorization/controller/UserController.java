package com.orangeside.authorization.controller;

import com.github.pagehelper.PageInfo;
import com.orangeside.authorization.model.User;
import com.orangeside.authorization.service.UserService;
import com.orangeside.authorization.vo.UserVO;
import com.orangeside.common.utils.PageConvertUtil;
import com.orangeside.common.utils.ResponseUtil;
import com.orangeside.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by cgj on 2016/4/9.
 */
@Controller @RequestMapping("/u") public class UserController {
    @Autowired private UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @ResponseBody
    public Result users(User user,
        @RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
        @RequestParam(value = "pageSize", required = false, defaultValue = "15") int pageSize) {
        PageInfo<User> pageInfo = userService.findUserList(pageNum, pageSize, user);
        return ResponseUtil.success(PageConvertUtil.grid(pageInfo));
    }

    @RequestMapping(value = "/user_insert", method = RequestMethod.POST)
    @ResponseBody
    public Result insertUser(User user) {
        userService.insertUser(user);
        return ResponseUtil.success();
    }

    @RequestMapping(value = "/user_update", method = RequestMethod.POST) @ResponseBody
    public Result updateUser(User user) {
        userService.updateNotNull(user);
        return ResponseUtil.success();
    }

    @RequestMapping(value = "/user_load", method = RequestMethod.GET)
    @ResponseBody
    public Result loadUser(@RequestParam(value = "id", required = true) int userId) {
        User user = userService.findUserById(userId);
        return ResponseUtil.success(user);
    }

    @RequestMapping(value = "/user_del", method = RequestMethod.POST)
    @ResponseBody
    public Result delUser(@RequestParam(value = "id", required = true) int userId) {
        userService.delete(userId);
        return ResponseUtil.success();
    }
}
