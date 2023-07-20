package com.moon;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@SpringBootTest
public class AsyncTransactionalTest {

    @Autowired
    private User1ServiceImpl user1Service;

    @Autowired
    private User2ServiceImpl user2Service;



    @Transactional
    @Test
    public void asyncTransactional() {

        log.info("线程名称：{}", Thread.currentThread().getName());

        List<User1> user1List = new ArrayList<>(Arrays.asList(new User1("张三"), new User1("李四"), new User1("moon")));
        List<User2> user2List = new ArrayList<>(Arrays.asList(new User2("cmycmy"), new User2("222李四"), new User2("comm")));

        try {
            user1Service.async(user1List);
        } catch (Exception e) {
            log.error("erroruser1", e);
        }

        try {
            user2Service.async(user2List);
        } catch (Exception e) {
            log.error("errorUser2", e);
        }
    }
}
