package com.nice.demo;

import com.nice.demo.bean.User;
import com.nice.demo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
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
            User user = new User();
            user.setUserName("haha"+i);
            user.setAge(i);
            user.setNickName("暴风");
            user.setPosition("中国");
            user.setModifyTime(new Date());
            User save = userService.save(user);
        }
    }
    @Test
    public void selectByAge(){
        List<User> users = userService.selelctByNickName("暴风");
        System.out.print(users);
    }



}
