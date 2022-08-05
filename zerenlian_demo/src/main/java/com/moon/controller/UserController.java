package com.moon.controller;

import com.moon.rezen.ProcessContext;
import com.moon.rezen.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private ProcessController processController;

    @RequestMapping("/send")
    public void send(String userName) {
        // 构建上下文
        ProcessContext processContext = new ProcessContext();

        UserModel userModel = new UserModel();
        userModel.setAge("24");
        userModel.setName(userName);
        processContext.setModel(userModel);

        processContext.setCode("sendMessage");

        processController.process(processContext);
    }
}
