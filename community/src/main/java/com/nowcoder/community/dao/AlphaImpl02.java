package com.nowcoder.community.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

/**
 * @author fff
 * @create 2022-2-20 21:02
 */
@Primary
@Repository
public class AlphaImpl02 implements Alpha {

    @Override
    public String select() {
        return "Two";
    }
}
