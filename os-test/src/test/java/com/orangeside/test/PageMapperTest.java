package com.orangeside.test;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.orangeside.authorization.service.RoleService;
import com.orangeside.sample.model.LoggingEvent;
import com.orangeside.sample.service.LoggingEventService;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PageMapperTest extends BasicTest {
    private static final Logger logger = LoggerFactory.getLogger(PageMapperTest.class);
    //    @Autowired
    //    private CountryMapper countryMapper;

    @Autowired private SqlSession sqlSession;
    @Autowired private RoleService roleService;
    @Autowired private LoggingEventService loggingEventService;


    @Test public void test() {
        Example example = new Example(LoggingEvent.class);
        PageHelper.startPage(2, 10);
        List<LoggingEvent> loggingEvents = loggingEventService.selectByExample(example);
        PageInfo<LoggingEvent> pageInfo = new PageInfo<LoggingEvent>(loggingEvents);
        logger.info("{}", pageInfo.getTotal());


        PageHelper.startPage(1, 10);
        Map argMap = new HashMap();
        List<LoggingEvent> all = loggingEventService.listByQueryModel(argMap);
        PageInfo<LoggingEvent> pageInfo2 = new PageInfo<LoggingEvent>(all);
        logger.info("{}", pageInfo2.getList().size());
    }

    @Test public void test2() {
        List<Map> list = roleService.findRoleMatchUpFunctions();
        logger.info("{}", list.size());
    }
}
