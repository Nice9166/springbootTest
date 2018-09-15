package com.nice.demo.core.service;

import com.nice.core.bean.UserInfo;
import com.nice.core.dao.repository.admin.UserRepoistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public UserInfo save(UserInfo userInfo){
        userInfo.setCreateTime(new Date());
        return userRepoistory.save(userInfo);
    }

    public UserInfo findByUserName(String userName){
         return userRepoistory.findByUserName(userName);
    }

    public List<UserInfo> selelctByNickName(String nickName){
        return userRepoistory.selelctByNickName(nickName);
    }
}
