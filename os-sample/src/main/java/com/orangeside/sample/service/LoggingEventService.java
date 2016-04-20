package com.orangeside.sample.service;

import com.orangeside.dao.service.IService;
import com.orangeside.sample.model.LoggingEvent;

import java.util.List;
import java.util.Map;

/**
 * Created by cgj on 2016/4/9.
 */
public interface LoggingEventService extends IService<LoggingEvent> {
    public List<LoggingEvent> listByQueryModel(Map argMap);
}
