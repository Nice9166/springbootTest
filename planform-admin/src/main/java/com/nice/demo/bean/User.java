package com.nice.demo.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.nice.demo.util.BaseEntity;
import io.swagger.annotations.ApiParam;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @program: springbootTest
 * @description:
 * @author: lifuye
 * @create: 2018-09-07 16:54
 **/
@Data  //lombox
@Entity
@Table(name = "t_user")
//@JsonIgnoreProperties(value = {"hibernateLazyInitializer","handler","fieldHandler"},ignoreUnknown = true)
public class User extends BaseEntity {

    @ApiParam("用户名")
    @Getter @Setter private String userName;

    @ApiParam("昵称")
    @Getter @Setter private String nickName;

    @ApiParam("岗位")
    @Getter @Setter private String position;

    @ApiParam("年龄")
    @Getter @Setter private Integer age;
}
