package com.orangeside.sample.model;

import javax.persistence.*;

@Table(name = "logging_event")
public class LoggingEvent {
    @Id
    @Column(name = "event_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventId;

    private Long timestmp;

    @Column(name = "logger_name")
    private String loggerName;

    @Column(name = "level_string")
    private String levelString;

    @Column(name = "thread_name")
    private String threadName;

    @Column(name = "reference_flag")
    private Short referenceFlag;

    private String arg0;

    private String arg1;

    private String arg2;

    private String arg3;

    @Column(name = "caller_filename")
    private String callerFilename;

    @Column(name = "caller_class")
    private String callerClass;

    @Column(name = "caller_method")
    private String callerMethod;

    @Column(name = "caller_line")
    private String callerLine;

    @Column(name = "formatted_message")
    private String formattedMessage;

    /**
     * @return event_id
     */
    public Long getEventId() {
        return eventId;
    }

    /**
     * @param eventId
     */
    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    /**
     * @return timestmp
     */
    public Long getTimestmp() {
        return timestmp;
    }

    /**
     * @param timestmp
     */
    public void setTimestmp(Long timestmp) {
        this.timestmp = timestmp;
    }

    /**
     * @return logger_name
     */
    public String getLoggerName() {
        return loggerName;
    }

    /**
     * @param loggerName
     */
    public void setLoggerName(String loggerName) {
        this.loggerName = loggerName;
    }

    /**
     * @return level_string
     */
    public String getLevelString() {
        return levelString;
    }

    /**
     * @param levelString
     */
    public void setLevelString(String levelString) {
        this.levelString = levelString;
    }

    /**
     * @return thread_name
     */
    public String getThreadName() {
        return threadName;
    }

    /**
     * @param threadName
     */
    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }

    /**
     * @return reference_flag
     */
    public Short getReferenceFlag() {
        return referenceFlag;
    }

    /**
     * @param referenceFlag
     */
    public void setReferenceFlag(Short referenceFlag) {
        this.referenceFlag = referenceFlag;
    }

    /**
     * @return arg0
     */
    public String getArg0() {
        return arg0;
    }

    /**
     * @param arg0
     */
    public void setArg0(String arg0) {
        this.arg0 = arg0;
    }

    /**
     * @return arg1
     */
    public String getArg1() {
        return arg1;
    }

    /**
     * @param arg1
     */
    public void setArg1(String arg1) {
        this.arg1 = arg1;
    }

    /**
     * @return arg2
     */
    public String getArg2() {
        return arg2;
    }

    /**
     * @param arg2
     */
    public void setArg2(String arg2) {
        this.arg2 = arg2;
    }

    /**
     * @return arg3
     */
    public String getArg3() {
        return arg3;
    }

    /**
     * @param arg3
     */
    public void setArg3(String arg3) {
        this.arg3 = arg3;
    }

    /**
     * @return caller_filename
     */
    public String getCallerFilename() {
        return callerFilename;
    }

    /**
     * @param callerFilename
     */
    public void setCallerFilename(String callerFilename) {
        this.callerFilename = callerFilename;
    }

    /**
     * @return caller_class
     */
    public String getCallerClass() {
        return callerClass;
    }

    /**
     * @param callerClass
     */
    public void setCallerClass(String callerClass) {
        this.callerClass = callerClass;
    }

    /**
     * @return caller_method
     */
    public String getCallerMethod() {
        return callerMethod;
    }

    /**
     * @param callerMethod
     */
    public void setCallerMethod(String callerMethod) {
        this.callerMethod = callerMethod;
    }

    /**
     * @return caller_line
     */
    public String getCallerLine() {
        return callerLine;
    }

    /**
     * @param callerLine
     */
    public void setCallerLine(String callerLine) {
        this.callerLine = callerLine;
    }

    /**
     * @return formatted_message
     */
    public String getFormattedMessage() {
        return formattedMessage;
    }

    /**
     * @param formattedMessage
     */
    public void setFormattedMessage(String formattedMessage) {
        this.formattedMessage = formattedMessage;
    }
}
