package com.nowcoder.community.controller;

import com.nowcoder.community.dao.UserMapper;
import com.nowcoder.community.entity.DiscussPost;
import com.nowcoder.community.entity.Page;
import com.nowcoder.community.entity.User;
import com.nowcoder.community.service.DiscussPostService;
import com.nowcoder.community.service.UserService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author fff
 * @create 2022-2-23 15:21
 */
@Controller
public class HomeController {
    @Autowired
    private UserService userService;
    @Autowired
    private DiscussPostService discussPostService;
    @RequestMapping(path="/index",method = RequestMethod.GET)
    public String getIndex(Model model, Page page){
        //在方法调用之前springMVC会自动注入model和page,并将page添加到model里
        //所以，在themleaf可以直接访问page的对象
        page.setPath("/index");
        page.setRows(discussPostService.findCountPosts(0));
        List<DiscussPost> list = discussPostService.findDiscussPosts(0,page.getOffset(),page.getLimit());
        List<Map<String,Object>> discussPosts = new ArrayList<>();

        if(list!=null){
            for(DiscussPost post:list){
                Map<String,Object> map = new HashMap<>();
                map.put("post",post);
                User user= userService.findUserById(post.getUserId());

                map.put("user",user);
                discussPosts.add(map);
            }

        }
        model.addAttribute("discussPosts",discussPosts);
        return "/index";
    }
}
