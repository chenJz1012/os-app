package com.orangeside.authorization.service;

import com.orangeside.authorization.model.Function;

/**
 * 工程：os-app
 * 创建人 : ChenGJ
 * 创建时间： 2015/9/4
 * 说明：
 */
public interface FunctionService {
    int insertFunction(Function function);

    int updateFunction(Function function);

    Function findFuntionById(int id);

    int deleteFunctionById(int id);
}
