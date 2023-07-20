package com.moon;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.moon.User1;
import com.moon.User1ServiceImpl;
import com.moon.User2;
import com.moon.User2ServiceImpl;
import com.moon.mapper.User1Mapper;
import com.moon.mapper.User2Mapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
public class SpringTest {

    @Autowired
    private User1ServiceImpl user1Service;

    @Autowired
    private User2ServiceImpl user2Service;

    @Test
    @Transactional
    public void transaction_nested_nested_exception_try(){
        User1 user1=new User1();
        user1.setName("张三");
        user1Service.addNested(user1);

        User2 user2=new User2();
        user2.setName("李四");
        try {
            user2Service.addNestedException(user2);
        } catch (Exception e) {
            System.out.println("方法回滚");
        }

//        getUser();

    }

    @Test
    public void getUser() {
        LambdaQueryWrapper<User1> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User1::getName, "张三");
        User1 user11 = user1Mapper.selectOne(wrapper);


        LambdaQueryWrapper<User2> wrapper2 = new LambdaQueryWrapper<>();
        wrapper2.eq(User2::getName, "李四");
        User2 user22 = user2Mapper.selectOne(wrapper2);
        System.out.println("user1:" + user11.toString());
        System.out.println("user2:" + user22.toString());
    }


    @Test
    public void notransaction_exception_required_notSuppored(){
        User1 user1=new User1();
        user1.setName("张三");
        user1Service.addRequired(user1);

        User2 user2=new User2();
        user2.setName("李四");
        user2Service.addNotSupported(user2);
        throw new RuntimeException();
    }
    @Test
    public void notransaction_required_notSuppored_exception(){
        User1 user1=new User1();
        user1.setName("张三");
        user1Service.addRequired(user1);

        User2 user2=new User2();
        user2.setName("李四");
        user2Service.addNotSupportedException(user2);
    }





    @Test
    @Transactional
    public void transaction_exception_required_notSuppored(){
        User1 user1=new User1();
        user1.setName("张三");
        user1Service.addRequired(user1);

        User2 user2=new User2();
        user2.setName("李四");
        user2Service.addNotSupported(user2);
        throw new RuntimeException();
    }
    @Test
    @Transactional
    public void transaction_required_notSuppored_exception(){
        User1 user1=new User1();
        user1.setName("张三");
        user1Service.addRequired(user1);

        User2 user2=new User2();
        user2.setName("李四");
        user2Service.addNotSupportedException(user2);
    }
    @Test
    @Transactional
    public void transaction_required_notSuppored_try_exception(){
        User1 user1=new User1();
        user1.setName("张三");
        user1Service.addRequired(user1);

        User2 user2=new User2();
        user2.setName("李四");
        try {
            user2Service.addNotSupportedException(user2);
        } catch (Exception e) {
            System.out.println("方法回滚");
        }
    }





    @Test
    public void notransaction_exception_never_never(){
        User1 user1=new User1();
        user1.setName("张三");
        user1Service.addNever(user1);

        User2 user2=new User2();
        user2.setName("李四");
        user2Service.addNever(user2);
        throw new RuntimeException();
    }

    @Test
    public void notransaction_never_never_exception(){
        User1 user1=new User1();
        user1.setName("张三");
        user1Service.addNever(user1);

        User2 user2=new User2();
        user2.setName("李四");
        user2Service.addNeverException(user2);
    }

    @Test
    @Transactional
    public void transaction_never(){
        User1 user1=new User1();
        user1.setName("张三");
        user1Service.addNever(user1);
    }









    @Test
    public void notransaction_supports_supports_exception(){
        User1 user1=new User1();
        user1.setName("张三");
        user1Service.addSupports(user1);

        User2 user2=new User2();
        user2.setName("李四");
        user2Service.addSupportsException(user2);
    }

    @Test
    public void notransaction_exception_supports_supports(){
        User1 user1=new User1();
        user1.setName("张三");
        user1Service.addSupports(user1);

        User2 user2=new User2();
        user2.setName("李四");
        user2Service.addSupports(user2);
        throw new RuntimeException();

    }



    /**  开启事务 */
    @Test
    @Transactional(propagation = Propagation.REQUIRED)
    public void transaction_supports_supports_exception(){
        User1 user1=new User1();
        user1.setName("张三");
        user1Service.addSupports(user1);

        User2 user2=new User2();
        user2.setName("李四");
        user2Service.addSupportsException(user2);
    }


    @Test
    @Transactional(propagation = Propagation.REQUIRED)
    public void transaction_exception_supports_supports(){
        User1 user1=new User1();
        user1.setName("张三");
        user1Service.addSupports(user1);

        User2 user2=new User2();
        user2.setName("李四");
        user2Service.addSupports(user2);

        throw new RuntimeException();
    }

    @Test
    @Transactional(propagation = Propagation.REQUIRED)
    public void transaction_supports_supports_try_exception(){
        User1 user1=new User1();
        user1.setName("张三");
        user1Service.addSupports(user1);

        User2 user2=new User2();
        user2.setName("李四");
        try {
            user2Service.addSupportsException(user2);
        } catch (Exception e) {
            System.out.println("方法回滚");
        }
    }














    @Transactional(propagation = Propagation.REQUIRED)
    @Test
    void test3() {
        User1 user1 = new User1();
        user1.setName("张三");
        user1Service.addRequired(user1);

        User2 user2 = new User2();
        user2.setName("李四");
        user2Service.addRequired(user2);

        throw new RuntimeException();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Test
    void test4() {
        User1 user1=new User1();
        user1.setName("张三");
        user1Service.addRequired(user1);

        User2 user2=new User2();
        user2.setName("李四");
        user2Service.addRequiredException(user2);
    }

    @Test
    @Transactional
    public void transaction_required_required_exception_try(){
        User1 user1=new User1();
        user1.setName("张三");
        user1Service.addRequired(user1);

        User2 user2=new User2();
        user2.setName("李四");
        try {
            user2Service.addRequiredException(user2);
        } catch (Exception e) {
            System.out.println("方法回滚");
        }
    }

    @Autowired
    private User1Mapper user1Mapper;

    @Autowired
    private User2Mapper user2Mapper;

    @Test
    public void testttt() {
        LambdaQueryWrapper<User1> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.in(User1::getName, "moon", "cmy");
        List<User1> user1s = user1Mapper.selectList(queryWrapper);

    }


}