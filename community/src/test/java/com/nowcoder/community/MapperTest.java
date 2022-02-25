package com.nowcoder.community;

import com.nowcoder.community.dao.DiscussPostMapper;
import com.nowcoder.community.dao.UserMapper;
import com.nowcoder.community.entity.DiscussPost;
import com.nowcoder.community.entity.User;
import com.nowcoder.community.service.DiscussPostService;
import com.nowcoder.community.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author fff
 * @create 2022-2-22 19:50
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)//得到配置类
public class MapperTest {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private DiscussPostMapper discussPostMapper;
    @Autowired
    private UserService userService;
    @Autowired
    private DiscussPostService discussPostService;
    @Test
    public void selectTest(){
        List<DiscussPost> discussPosts = discussPostMapper.selectDiscussPosts(0, 0, 10);
        for(DiscussPost post:discussPosts){
            System.out.println(post.getId());
        }
    }
    @Test
    public void  insertTest(){
       User user = new User();
       user.setUserName("test");
       user.setPassword("123456");
       user.setHeaderUrl("http://www.nowcoder.com/101.png");
       user.setEmail("test.qq.com");

        int res = userMapper.insertUser(user);
        System.out.println(res);
        System.out.println(user.getId());

    }
    @Test
    public void testUpdate(){
        userMapper.updateHeader(150,"http://www.nowcoder.com.102.png");
        userMapper.updatePassword(150,"123321");
        userMapper.updateStatus(150,1);

    }
    @Test
    public  void deleteTest(){
        int row = userMapper.deleteById(151);
        System.out.println(row);
    }
    @Test
    public void selectPostTest(){
        List<DiscussPost> discussPosts
                = discussPostMapper.selectDiscussPosts(0, 0, 10);
        for(DiscussPost post:discussPosts){
            System.out.println(post);
        }
        int rows = discussPostMapper.selectPostCount(0);
        System.out.println(rows);


    }
}
