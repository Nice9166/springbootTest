package com.nice.demo.service;

import com.nice.demo.bean.User;
import com.nice.demo.repoistory.UserRepoistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @program: springbootTest
 * @description:
 * @author: lifuye
 * @create: 2018-09-08 14:48
 **/
@Service
public class UserService {

    @Autowired
    private UserRepoistory userRepoistory;

    public User save(User user){
        user.setCreateTime(new Date());
        return userRepoistory.save(user);
    }

    public User findByUserName(String userName){
         return userRepoistory.findByUserName(userName);
    }

    public List<User> selelctByNickName(String nickName){
        return userRepoistory.selelctByNickName(nickName);
    }
}
