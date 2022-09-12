package com.ming.springcloud.service;


import com.ming.springcloud.pojo.Dept;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory {
    @Override
    public DeptClientService create(Throwable cause) {
        return new DeptClientService() {
            @Override
            public Dept queryByID(Long id) {
                Dept dept = new Dept();
                dept.setDeptno(id);
                dept.setDname("id=>"+id+"没有对应信息，客户端提供了降级的信息，这个服务现在已经被关闭");
                dept.setDb_source("no Database");
                return dept;
            }

            @Override
            public List<Dept> queryAll() {
                return null;
            }

            @Override
            public boolean addDept(Dept dept) {
                return false;
            }
        };
    }
}
