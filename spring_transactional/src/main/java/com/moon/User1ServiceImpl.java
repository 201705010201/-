package com.moon;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.moon.mapper.User1Mapper;
import lombok.extern.slf4j.Slf4j;
import org.omg.CORBA.OBJECT_NOT_EXIST;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.Future;

@Slf4j
//@AllArgsConstructor
@Service
public class User1ServiceImpl {

//    private final User1Mapper user1Mapper;
    @Autowired
    private User1Mapper user1Mapper;


    @Transactional(propagation = Propagation.NESTED)
    public void addNested(User1 user){
        user1Mapper.insert(user);
    }





    @Transactional(propagation = Propagation.REQUIRED)
    public void addRequired(User1 user){
        user1Mapper.insert(user);
    }


    @Transactional(propagation = Propagation.SUPPORTS)
    public void addSupports(User1 user){
        user1Mapper.insert(user);
    }





    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void addNotSupported(User1 user){
        user1Mapper.insert(user);
    }
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void addNotSupportedException(User1 user){
        user1Mapper.insert(user);
        throw new RuntimeException();
    }
    @Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly=true)
    public User1 getNotSupported(Integer id){
        return user1Mapper.selectById(id);
    }


    @Transactional(propagation = Propagation.NEVER)
    public void addNever(User1 user){
        user1Mapper.insert(user);
    }

    @Transactional(propagation = Propagation.NEVER)
    public void addNeverException(User1 user){
        user1Mapper.insert(user);
        throw new RuntimeException();
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public void addMandatory(User1 user){
        user1Mapper.insert(user);
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public void addMandatoryException(User1 user){
        user1Mapper.insert(user);
        throw new RuntimeException();
    }


    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    public void async(List<User1> user1List) {
        try {
            for (User1 user1 : user1List) {
                QueryWrapper<User1> queryWrapper = new QueryWrapper<>();
                queryWrapper.lambda().eq(User1::getName, user1.getName());
//                int i = 1/0;
                User1 selectOne = user1Mapper.selectOne(queryWrapper);
                if (Objects.nonNull(selectOne)) {
                    if (Objects.equals(user1.getName(), selectOne.getName())) {
                        selectOne.setName(user1.getName());
                        int i = 1/0;
                        user1Mapper.updateById(selectOne);

                    }
                } else {
                    user1Mapper.insert(user1);
                }
            }

        } catch (Exception e) {
            log.error("erroruser1", e);
            throw new RuntimeException(e);
        }
    }
}
