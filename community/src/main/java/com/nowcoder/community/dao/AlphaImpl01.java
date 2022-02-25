package com.nowcoder.community.dao;

import org.springframework.stereotype.Repository;

/**
 * @author fff
 * @create 2022-2-20 14:59
 */
@Repository("one")//添加注解 spring才可以扫描到这个bean
public class AlphaImpl01 implements Alpha {
    @Override
    public String select() {
        return "One";
    }
}
