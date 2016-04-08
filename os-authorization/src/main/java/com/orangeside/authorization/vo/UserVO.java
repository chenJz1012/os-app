package com.orangeside.authorization.vo;

import com.orangeside.authorization.model.User;

/**
 * Created by cgj on 2015/10/30.
 */
public class UserVO extends User {
    @Override
    public String getPassword() {
        return "";
    }
}
