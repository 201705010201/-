package com.moon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private StringRedisTemplate redisTemplate;


    @Cacheable(cacheNames ="user_cache", key = "#id")
    public List<Department> getUserById(Integer id){
        List<Department> departments = Arrays.asList(new Department(id), new Department(333));
        return departments;
    }

    public Object get(Integer uid) {
        String key = "user_cache::" + uid;
        Object o = redisTemplate.opsForValue().get(key);

        System.out.println(o);
        return o;
    }
}
