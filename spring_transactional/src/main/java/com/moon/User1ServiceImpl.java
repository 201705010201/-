package com.moon;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.moon.mapper.User1Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


//@AllArgsConstructor
@Service
public class User1ServiceImpl {

//    private final User1Mapper user1Mapper;
    @Autowired
    private User1Mapper user1Mapper;

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

}
