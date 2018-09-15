package com.nice.demo;

import com.nice.core.bean.UserInfo;
import com.nice.demo.core.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    public void contextLoads() {
        for (int i = 0; i < 10; i++) {
            UserInfo userInfo = new UserInfo();
            userInfo.setModifyTime(new Date());
            UserInfo save = userService.save(userInfo);
        }
    }
    @Test
    public void selectByAge(){
        List<UserInfo> userInfos = userService.selelctByNickName("暴风");
        System.out.print(userInfos);
    }



}
