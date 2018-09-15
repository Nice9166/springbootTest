package com.nice.demo.core.shiro;

import com.nice.core.bean.UserInfo;
import com.nice.demo.core.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @program: springbootTest
 * @description:自定义授权
 * @author: lifuye
 * @create: 2018-09-15 17:03
 **/
public class ShiroRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String userName = (String)authenticationToken.getPrincipal();//用户名
        String passWord = new String((char[])authenticationToken.getCredentials());
        authenticationToken.getCredentials();
        UserInfo user = userService.findByUserName(userName);

        /**检测是否有此用户 **/
        if(user == null){
            throw new UnknownAccountException();//没有找到账号异常
        }
        /**检验账号是否被锁定 **/
        if(Boolean.TRUE.equals(user.getLocked())){
            throw new LockedAccountException();//抛出账号锁定异常
        }
        /**AuthenticatingRealm使用CredentialsMatcher进行密码匹配**/
        if(null != userName && null != passWord){
            return new SimpleAuthenticationInfo(userName, passWord, getName());
        }else{
            return null;
        }
    }


}
