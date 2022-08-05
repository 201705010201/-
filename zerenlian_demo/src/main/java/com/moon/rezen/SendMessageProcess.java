package com.moon.rezen;

import org.springframework.stereotype.Service;

@Service
public class SendMessageProcess implements BusinessProcess {

    @Override
    public void process(ProcessContext context) {
        UserModel user = (UserModel) context.getModel();
        System.out.println("给" + user.getName() + "发消息");
    }
}
