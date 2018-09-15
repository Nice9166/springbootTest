package com.nice.core.bean;

import io.swagger.annotations.ApiParam;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @program: springbootTest
 * @description: 角色
 * @author: lifuye
 * @create: 2018-09-13 15:32
 **/
@Data
@Entity
public class SysRole implements Serializable {
    private static final long serialVersionUID = -3287894627088459906L;
    @ApiParam("编号")
    @Id
    @GeneratedValue
    @Setter @Getter private Integer id;
    @ApiParam("角色标识程序中判断使用,如\"admin\",这个是唯一的")
    @Setter @Getter private String role;
    @ApiParam("角色描述,UI界面显示使用")
    @Setter @Getter private String description;
    @ApiParam("是否可用,如果不可用将不会添加给用户")
    @Setter @Getter private Boolean available = Boolean.FALSE;

    @ApiParam("角色 -- 权限关系：多对多关系;")
    @ManyToMany(fetch= FetchType.EAGER)
    @JoinTable(name="SysRolePermission",joinColumns={@JoinColumn(name="roleId")},inverseJoinColumns={@JoinColumn(name="permissionId")})
    @Setter @Getter private List<SysPermission> permissions;

    @ApiParam("用户 - 角色关系定义;")
    @ManyToMany
    @JoinTable(name="SysUserRole",joinColumns={@JoinColumn(name="roleId")},inverseJoinColumns={@JoinColumn(name="uid")})
    @Setter @Getter private List<UserInfo> userInfos;

}
