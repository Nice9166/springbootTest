package com.nice.core.bean;

import io.swagger.annotations.ApiParam;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

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
public class UserInfo extends BaseEntity {

    private static final long serialVersionUID = -4492441728123311332L;


    @ApiParam("帐号")
    @Column(unique =true)
    @Getter @Setter private String username;
    @ApiParam("名称（昵称或者真实姓名，不同系统不同定义）")
    @Getter @Setter private String name;
    @ApiParam("密码")
    @Getter @Setter private String password;
    @ApiParam("加密密码的盐")
    @Getter @Setter private String salt;
    @ApiParam("用户状态,0:创建未认证（比如没有激活，没有输入验证码等等）--等待验证的用户 , 1:正常状态,2：用户被锁定.")
    @Getter @Setter private byte state;
    @ApiParam("账号是否被锁定")
    @Getter @Setter private Boolean locked = Boolean.FALSE;
    @ApiParam("立即从数据库中进行加载数据,一个用户具有多个角色")
    @ManyToMany(fetch= FetchType.EAGER)
    @JoinTable(name = "SysUserRole", joinColumns = { @JoinColumn(name = "uid") }, inverseJoinColumns ={@JoinColumn(name = "roleId") })
    @Getter @Setter private List<SysRole> roleList;//
}
