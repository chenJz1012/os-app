package com.orangeside.sample.dao;

import com.orangeside.dao.basedao.BaseMapper;
import com.orangeside.sample.model.LoggingEvent;

import java.util.List;
import java.util.Map;

public interface LoggingEventMapper extends BaseMapper<LoggingEvent> {
    List<LoggingEvent> selectByQueryModel(Map argMap);
}
