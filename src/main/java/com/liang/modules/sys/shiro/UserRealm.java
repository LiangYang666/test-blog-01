package com.liang.modules.sys.shiro;

import com.liang.modules.sys.entity.PermissionEntity;
import com.liang.modules.sys.entity.VO.RoleVOEntity;
import com.liang.modules.sys.entity.VO.UserVOEntity;
import com.liang.modules.sys.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
    
     /**
      * @method  授权方法
      * @description 
      * @date: 2022/1/16 18:47
      * @author: Yang Liang
      * @param null
      * @return 
      */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取用户(前期认证已经加入进去了)
        UserVOEntity user = (UserVOEntity) SecurityUtils.getSubject().getPrincipal();
        Set<RoleVOEntity> roles = user.getRoles();
        List<String> roleNameList = new ArrayList<>();
        List<String> permissionList = new ArrayList<>();
        for (RoleVOEntity role :
                roles) {
            roleNameList.add(role.getRoleName());   // 添加角色名称
            for (PermissionEntity permission:
                 role.getPermissionSet()) {
                permissionList.add(permission.getPermissionName()); // 添加权限名称
            }
        }
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();     // 授权
        info.addStringPermissions(permissionList);
        info.addRoles(roleNameList);
        return info;
    }
     /**
      * @method  认证方法
      * @description 
      * @date: 2022/1/16 18:46
      * @author: Yang Liang
      * @param null
      * @return 
      */
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
