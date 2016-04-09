package com.orangeside.sample.service.impl;

import com.orangeside.dao.service.impl.BaseService;
import com.orangeside.sample.dao.LoggingEventMapper;
import com.orangeside.sample.model.LoggingEvent;
import com.orangeside.sample.service.LoggingEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by cgj on 2016/4/9.
 */
@Service("loggingEventService") public class LoggingEventServiceImpl
    extends BaseService<LoggingEvent> implements LoggingEventService {

    @Autowired LoggingEventMapper loggingEventMapper;

    @Override public List<LoggingEvent> listByQueryModel(Map argMap) {
        return loggingEventMapper.selectByQueryModel(argMap);
    }
}
