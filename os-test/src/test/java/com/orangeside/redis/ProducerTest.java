package com.orangeside.redis;

import com.orangeside.BasicTest;
import com.orangeside.redis.mq.Callback;
import com.orangeside.redis.mq.Consumer;
import com.orangeside.redis.mq.Producer;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

import redis.clients.jedis.Jedis;

import javax.annotation.Resource;

import java.io.IOException;

public class ProducerTest extends BasicTest {
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
    public void publishAndConsume() {
        Producer p = new Producer(jedis, "foo");
        Consumer c = new Consumer(jedis, "a subscriber", "foo");

        p.publish("hello world!");
        assertEquals("hello world!", c.consume());
    }

    @Test
    public void publishAndRead() {
        Producer p = new Producer(jedis, "foo");
        Consumer c = new Consumer(jedis, "a subscriber", "foo");

        p.publish("hello world!");
        assertEquals("hello world!", c.read());
        assertEquals("hello world!", c.read());
    }

    @Test
    public void unreadMessages() {
        Producer p = new Producer(jedis, "foo");
        Consumer c = new Consumer(jedis, "a subscriber", "foo");

        assertEquals(0, c.unreadMessages());
        p.publish("hello world!");
        assertEquals(1, c.unreadMessages());
        p.publish("hello world!");
        assertEquals(2, c.unreadMessages());
        c.consume();
        assertEquals(1, c.unreadMessages());
    }

    @Test
    public void raceConditionsWhenPublishing() throws InterruptedException {
        Producer slow = new SlowProducer(jedis, "foo");
        Consumer c = new Consumer(jedis, "a subscriber", "foo");

        slow.publish("a");
        Thread t = new Thread(new Runnable() {
            public void run() {
                Producer fast = new Producer(jedis, "foo");
                fast.publish("b");
            }
        });
        t.start();
        t.join();

        assertEquals("a", c.consume());
        assertEquals("b", c.consume());
    }

    @Test
    public void eraseOldMessages() {
        Producer p = new Producer(jedis, "foo");
        Consumer c = new Consumer(jedis, "a subscriber", "foo");

        p.publish("a");
        p.publish("b");

        assertEquals("a", c.consume());

        p.clean();

        Consumer nc = new Consumer(jedis, "new subscriber", "foo");

        assertEquals("b", c.consume());
        assertEquals("b", nc.consume());
        assertNull(c.consume());
        assertNull(nc.consume());
    }

    class SlowProducer extends Producer {
        private long sleep;

        public SlowProducer(Jedis jedis, String topic) {
            this(jedis, topic, 500L);
        }

        public SlowProducer(Jedis jedis, String topic, long sleep) {
            super(jedis, topic);
            this.sleep = sleep;
        }

        protected Integer getNextMessageId() {
            Integer nextMessageId = super.getNextMessageId();
            sleep(sleep);
            return nextMessageId;
        }
    }


    class SlowConsumer extends Consumer {
        private long sleep;

        public SlowConsumer(Jedis jedis, String id, String topic) {
            this(jedis, id, topic, 500L);
        }

        public SlowConsumer(Jedis jedis, String id, String topic, long sleep) {
            super(jedis, id, topic);
            this.sleep = sleep;
        }

        @Override
        public String consume() {
            sleep(sleep);
            return super.consume();
        }

        @Override
        public void consume(Callback callback) {
            sleep(sleep);
            super.consume(callback);
        }
    }

    @Test
    public void expiredMessages() throws InterruptedException {
        Consumer c = new SlowConsumer(jedis, "a consumer", "foo", 2000L);
        Producer p = new Producer(jedis, "foo");
        p.publish("un mensaje", 1);
        assertNull(c.consume());
    }

    private void sleep(long sleep) {
        try {
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
        }
    }

    @Test
    public void firstMessageExpired() throws InterruptedException {
        Consumer c = new SlowConsumer(jedis, "a consumer", "foo", 2000L);
        Producer p = new Producer(jedis, "foo");
        p.publish("1", 1);
        p.publish("2", 0);

        assertEquals("2", c.consume());
    }
}
