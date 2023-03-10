package com.moon;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class CacheableController {

    @Resource
    private DepartmentService departmentService;

    @RequestMapping("cacheable/{id}")
    public List<Department> getUserDetailsByUid(@PathVariable("id") Integer uid) {
        return departmentService.getUserById(uid);
    }

    @RequestMapping("get/{id}")
    public Object get(@PathVariable("id") Integer uid) {
        return departmentService.get(uid);
    }

}
