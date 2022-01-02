package com.liang.modules.sys.shiro;

import com.liang.modules.sys.entity.VO.UserVOEntity;
import com.liang.modules.sys.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @ProjectName:
 * @Package:        com.liang.modules.sys.shiro
 * @ClassName:      UserRealm.java
 * @Description:
 * @Author:         Yang Liang
 * @CreateDate:     2021/12/29 9:34
 * @Version:        1.0
 */

public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken userToken = (UsernamePasswordToken) authenticationToken;
        UserVOEntity user = userService.findByPhone(userToken.getUsername());
        System.out.println(user);
        if (user==null){
            throw new UnknownAccountException("该手机号不存在!");
        } else {
            // 以手机号作为盐值进行MD5加盐
            ByteSource salt = ByteSource.Util.bytes(user.getPhone());
            System.out.println(user.getPassword());
            return new SimpleAuthenticationInfo(user, user.getPassword(), salt, this.getName());
        }
    }
}
