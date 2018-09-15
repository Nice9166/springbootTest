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
 * @description: 权限信息
 * @author: lifuye
 * @create: 2018-09-13 15:47
 **/
@Data
@Entity
public class SysPermission implements Serializable {
    private static final long serialVersionUID = -9048290838124529734L;

    @ApiParam("主键")
    @Id
    @GeneratedValue
    @Setter @Getter private Integer id;
    @ApiParam("名称")
    @Setter @Getter private String name;
    @ApiParam("资源类型，[menu|button]")
    @Column(columnDefinition="enum('menu','button')")
    @Setter @Getter private String resourceType;
    @ApiParam("资源路径")
    @Setter @Getter private String url;
    @ApiParam("权限字符串,menu例子：role:*，button例子：role:create,role:update,role:delete,role:view")
    @Setter @Getter private String permission;
    @ApiParam("父编号")
    @Setter @Getter private Long parentId;
    @ApiParam("父编号列表")
    @Setter @Getter private String parentIds;
    @ApiParam("是否有效")
    @Setter @Getter private Boolean available = Boolean.FALSE;
    @ApiParam("关联角色")
    @ManyToMany
    @JoinTable(name="SysRolePermission",joinColumns={@JoinColumn(name="permissionId")},inverseJoinColumns={@JoinColumn(name="roleId")})
    @Setter @Getter private List<SysRole> roles;
}
