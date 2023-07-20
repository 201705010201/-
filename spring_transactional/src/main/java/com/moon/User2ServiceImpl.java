package com.moon;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.moon.mapper.User2Mapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;
import java.util.Objects;


@Slf4j
//@AllArgsConstructor
@Service
public class User2ServiceImpl {

//    private final User2Mapper user2Mapper;
    @Autowired
    private User2Mapper user2Mapper;

    @Transactional(propagation = Propagation.NESTED)
    public void addNestedException(User2 user){
        user2Mapper.insert(user);
        throw new RuntimeException();
    }




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


    @Autowired
    private TransactionTemplate transactionTemplate;

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    public void async(List<User2> user1List) {

        try {
            for (User2 user1 : user1List) {
                QueryWrapper<User2> queryWrapper = new QueryWrapper<>();
                queryWrapper.lambda().eq(User2::getName, user1.getName());
                User2 selectOne = user2Mapper.selectOne(queryWrapper);
                if (Objects.nonNull(selectOne)) {
                    if (Objects.equals(user1.getName(), selectOne.getName())) {
                        selectOne.setName(user1.getName());
                        user2Mapper.updateById(selectOne);
                    }
                } else {
                    user2Mapper.insert(user1);
                }
            }

        } catch (Exception e) {
            log.error("errorUser2", e);
            throw new RuntimeException(e);
        }
    }
}
