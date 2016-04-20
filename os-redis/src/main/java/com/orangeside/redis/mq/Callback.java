package com.orangeside.redis.mq;

public interface Callback {
    public void onMessage(String message);
}
