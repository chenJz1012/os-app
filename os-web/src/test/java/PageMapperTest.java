/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014 abel533@gmail.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.orangeside.authorization.service.RoleService;
import com.orangeside.sample.model.LoggingEvent;
import com.orangeside.sample.service.LoggingEventService;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liuzh on 2015/3/7.
 */
public class PageMapperTest extends BasicTest {

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
        System.out.println(pageInfo.getTotal());


        PageHelper.startPage(1, 10);
        Map argMap = new HashMap();
        List<LoggingEvent> all = loggingEventService.listByQueryModel(argMap);
        PageInfo<LoggingEvent> pageInfo2 = new PageInfo<LoggingEvent>(all);
        System.out.println(pageInfo2.getList().size());
    }
    @Test public void test2() {
        List<Map> list = roleService.findRoleMatchUpFunctions();
        System.out.println(list.size());
    }
}
