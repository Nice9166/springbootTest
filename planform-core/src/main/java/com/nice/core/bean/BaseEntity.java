package com.nice.core.bean;

import io.swagger.annotations.ApiParam;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

/**
 * @program: springbootTest
 * @description:
 * @author: lifuye
 * @create: 2018-09-08 10:52
 **/
@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = -2951299606163134039L;

    @Id
    @GeneratedValue
    @ApiParam("主键ID")
    protected Long id;

    @CreatedDate
    @ApiParam("创建时间")
    protected Date createTime;

    @LastModifiedDate
    @ApiParam("更新时间")
    protected Date modifyTime;


}
