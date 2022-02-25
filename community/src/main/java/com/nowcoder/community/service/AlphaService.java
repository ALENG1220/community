package com.nowcoder.community.service;

import com.nowcoder.community.dao.Alpha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author fff
 * @create 2022-2-20 21:18
 */
@Service
//更改为多对象模式
//@Scope("prototype")
public class AlphaService {
    public AlphaService(){
        System.out.println("AlphaService 实例化");
    }
    @Autowired
    private Alpha alphaDao;
    @PostConstruct
    public void init(){
        System.out.println("AlphaService init");
    }
    @PreDestroy
    public void destory(){
        System.out.println("AlphaService 销毁");
    }
    public String find(){
        return alphaDao.select();
    }
}
