package com.moon.rezen;

import java.util.List;

/**
 * 业务责任链模板
 */
public class ProcessTemplate {

    private List<BusinessProcess> processList;

    public List<BusinessProcess> getProcessList() {
        return processList;
    }

    public void setProcessList(List<BusinessProcess> processList) {
        this.processList = processList;
    }
}
