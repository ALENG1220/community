package com.nowcoder.community.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;

/**
 * @author fff
 * @create 2022-2-20 21:32
 */
@Configuration
public class AlphaConfig {
    @Bean
    public SimpleDateFormat simpleDateFormat(){

        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }
}
