package com.moon;

import com.moon.User1;
import com.moon.User1ServiceImpl;
import com.moon.User2;
import com.moon.User2ServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class SpringTest {

    @Autowired
    private User1ServiceImpl user1Service;

    @Autowired
    private User2ServiceImpl user2Service;



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



}