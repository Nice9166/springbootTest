package com.nice.core.dao.repository.admin;

import com.nice.core.bean.UserInfo;
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
public interface UserRepoistory extends JpaRepository<UserInfo,Long>, JpaSpecificationExecutor<UserInfo> {

    //符合JPA命名规则的方法定义
    UserInfo findByUserName(String UserName);

    @Query(value = "from UserInfo where nickName = ?1")
    List<UserInfo> selelctByNickName(String nickName);
    @Query(value = "SELECT * from t_user where age = ?1",nativeQuery = true)
    List<UserInfo> selelctByAge(Integer age);
}
