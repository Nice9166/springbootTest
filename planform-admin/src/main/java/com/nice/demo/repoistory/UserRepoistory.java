package com.nice.demo.repoistory;

import com.nice.demo.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @program: springbootTest
 * @description:
 * @author: lifuye
 * @create: 2018-09-08 14:33
 **/
public interface UserRepoistory extends JpaRepository<User,Long>, JpaSpecificationExecutor<User> {

    //符合JPA命名规则的方法定义
    User findByUserName(String UserName);

    @Query(value = "from User where nickName = ?1")
    List<User> selelctByNickName(String nickName);
    @Query(value = "SELECT * from t_user where age = ?1",nativeQuery = true)
    List<User> selelctByAge(Integer age);
}
