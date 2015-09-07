package com.orangeside.urf.service.impl;

import com.orangeside.urf.dao.FunctionMapper;
import com.orangeside.urf.model.Function;
import com.orangeside.urf.service.FunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 工程：os-app
 * 创建人 : ChenGJ
 * 创建时间： 2015/9/4
 * 说明：
 */
@Service
public class FunctionServiceImpl implements FunctionService{
    @Autowired
    FunctionMapper functionMapper;
    @Override
    public int insertFunction(Function function) {
        return functionMapper.insert(function);
    }

    @Override
    public int updateFunction(Function function) {
        return functionMapper.updateByPrimaryKey(function);
    }

    @Override
    public Function findFuntionById(int id) {
        return functionMapper.selectByPrimaryKey(id);
    }

    @Override
    public int deleteFunctionById(int id) {
        return functionMapper.deleteByPrimaryKey(id);
    }
}
