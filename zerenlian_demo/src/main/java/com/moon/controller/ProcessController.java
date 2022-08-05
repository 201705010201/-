package com.moon.controller;

import com.moon.rezen.BusinessProcess;
import com.moon.rezen.ProcessContext;
import com.moon.rezen.ProcessTemplate;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Data
@Component
public class ProcessController {

    /**
     * 不同的code 对应不同的责任链
     */
    private Map<String, ProcessTemplate> templateConfig = null;

    public void process(ProcessContext context) {
        String code = context.getCode();
        ProcessTemplate processTemplate = templateConfig.get(code);
        List<BusinessProcess> processList = processTemplate.getProcessList();

        for (BusinessProcess process : processList) {
            try {
                process.process(context);
                if (context.getNeedBreak()) {
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }

}
