package com.nowcoder.community.dao;

import com.nowcoder.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author fff
 * @create 2022-2-23 14:21
 */
@Repository
@Mapper
public interface DiscussPostMapper {
    List<DiscussPost> selectDiscussPosts(int userId,int offset,int limit);
    //当要嵌入动态sql,参数列表只有一个参数时，要加上@Param注解
    int selectPostCount(@Param("userId") int userId);
}
