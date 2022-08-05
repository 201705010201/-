package com.moon.rezen;

import org.springframework.stereotype.Service;


@Service
public class WhiteListProcess implements BusinessProcess {

    @Override
    public void process(ProcessContext context) {
        UserModel user = (UserModel) context.getModel();
        if ("moon".equals(user.getName())) {
            context.setNeedBreak(true);
        }
    }
}
