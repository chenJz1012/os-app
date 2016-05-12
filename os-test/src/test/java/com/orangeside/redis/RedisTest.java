package com.orangeside.redis;

import com.orangeside.BasicTest;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Set;
import java.util.TreeSet;

import javax.annotation.Resource;

/**
 * Created by cgj on 2016/4/12.
 */
public class RedisTest extends BasicTest {
    @Resource(name = "redisTemplate")
    private RedisTemplate<String, UserDetails> template;
    @Resource(name = "redisTemplate")
    private RedisTemplate<String, String> template1;
    @Resource(name = "redisTemplate")
    private ListOperations<String, String> listOps;

    @Test
    public void test() {
        UserDetails userDetails = (UserDetails) template.opsForValue().get(
                "os_user_cache_admin");
        Assert.assertEquals(userDetails.getUsername(), "admin");
    }

    @Test
    public void test2() {
        // template.opsForValue().set("os_user_cache_admin",null);
        // System.out.println(template1.opsForValue().get("user"));
        template1.opsForValue().set("user1", "user1");
        template1.opsForValue().set("user2", "user2");
        Set<String> set = template1.keys("user*");
        Set<String> treeSet = new TreeSet<String>(set);
        for (String s : treeSet) {
            System.out.println(s);
        }


    }
}
