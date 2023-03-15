package com.moon;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.moon.mapper.User2Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


//@AllArgsConstructor
@Service
public class User2ServiceImpl {

//    private final User2Mapper user2Mapper;
    @Autowired
    private User2Mapper user2Mapper;

    @Transactional(propagation = Propagation.REQUIRED)
    public void addRequired(User2 user){
        user2Mapper.insert(user);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void addRequiredException(User2 user){
        user2Mapper.insert(user);
        throw new RuntimeException();
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void addSupportsException(User2 user){
        user2Mapper.insert(user);
        throw new RuntimeException();
    }


    @Transactional(propagation = Propagation.SUPPORTS)
    public void addSupports(User2 user){
        user2Mapper.insert(user);
    }





    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void addNotSupported(User2 user){
        user2Mapper.insert(user);
    }
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void addNotSupportedException(User2 user){
        user2Mapper.insert(user);
        throw new RuntimeException();
    }






    @Transactional(propagation = Propagation.MANDATORY)
    public void addMandatory(User2 user){
        user2Mapper.insert(user);
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public void addMandatoryException(User2 user){
        user2Mapper.insert(user);
        throw new RuntimeException();
    }



    @Transactional(propagation = Propagation.NEVER)
    public void addNever(User2 user){
        user2Mapper.insert(user);
    }

    @Transactional(propagation = Propagation.NEVER)
    public void addNeverException(User2 user){
        user2Mapper.insert(user);
        throw new RuntimeException();
    }


}
