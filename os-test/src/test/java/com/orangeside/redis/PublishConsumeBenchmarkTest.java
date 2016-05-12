package com.orangeside.redis;

import com.orangeside.BasicTest;
import com.orangeside.redis.mq.Consumer;
import com.orangeside.redis.mq.Producer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

import java.io.IOException;
import java.util.Calendar;

import javax.annotation.Resource;

import redis.clients.jedis.Jedis;

public class PublishConsumeBenchmarkTest extends BasicTest {
    @Resource(name = "jedisConnFactory")
    JedisConnectionFactory jedisConnectionFactory;
    private Jedis jedis;

    @Before
    public void setUp() throws IOException {
        jedis = (Jedis) jedisConnectionFactory.getConnection().getNativeConnection();
    }

    @After
    public void after() {
        jedis.flushAll();
        jedis.disconnect();
    }

    @Test
    public void publish() {
        final String topic = "foo";
        final String message = "hello world!";
        final int MESSAGES = 10000;
        Producer p = new Producer(jedis, topic);

        long start = Calendar.getInstance().getTimeInMillis();
        for (int n = 0; n < MESSAGES; n++) {
            p.publish(message);
        }
        long elapsed = Calendar.getInstance().getTimeInMillis() - start;
        System.out.println(((1000 * MESSAGES) / elapsed) + " ops");
    }

    @Test
    public void consume() {
        final String topic = "foo";
        final String message = "hello world!";
        final int MESSAGES = 10000;
        Producer p = new Producer(jedis, topic);
        Consumer c = new Consumer(jedis, "consumer", topic);
        for (int n = 0; n < MESSAGES; n++) {
            p.publish(message);
        }

        long start = Calendar.getInstance().getTimeInMillis();
        String m = null;
        do {
            m = c.consume();
        } while (m != null);
        long elapsed = Calendar.getInstance().getTimeInMillis() - start;

        System.out.println(((1000 * MESSAGES) / elapsed) + " ops");
    }
}
