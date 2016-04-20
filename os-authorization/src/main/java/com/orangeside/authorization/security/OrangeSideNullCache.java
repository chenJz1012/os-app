package com.orangeside.authorization.security;

import com.orangeside.common.cache.BasicCache;

/**
 * Created by cgj on 2016/4/13.
 */
public class OrangeSideNullCache<K, V> implements BasicCache<K, V> {
    @Override
    public void set(K key, V value) {
    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public void del(K key) {

    }
}
