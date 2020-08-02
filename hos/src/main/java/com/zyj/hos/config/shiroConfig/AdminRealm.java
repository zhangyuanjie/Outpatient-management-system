package com.zyj.hos.config.shiroConfig;

import com.zyj.hos.entity.Admin;
import com.zyj.hos.service.AdminService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

public class AdminRealm extends AuthorizingRealm {
    @Resource
    private AdminService adminService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("admin执行了授权！");
//        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//        info.addRole("admin");
//        // 那倒当前登录的这个对象
//        Subject subject = SecurityUtils.getSubject();
//        Admin currentAdmin = (Admin)subject.getPrincipal(); // 拿到当前登录 admin 对象
//        info.addStringPermission(currentAdmin.getAdminName()); // 参数为字符串
//        return info;
//        if (principalCollection.fromRealm(getName()).iterator().next() == null){
//            System.out.println("loginName 不存在");
//            return null;
//        }
//        String loginName=(String) principalCollection.fromRealm(this.getClass().getName()).iterator().next();
//        System.out.println(loginName + " 执行了授权");
//        Admin admin = adminService.selectAdminByAccount(loginName);
        String adminName = (String) principalCollection.getPrimaryPrincipal();
        System.out.println(adminName);
        Admin admin = adminService.selectAdminByAccount(adminName);
//        Set<String> roles = new HashSet<>();
        if( admin != null){
//            roles.add("admin");
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            info.addRole("admin");
            return info;
        }
        return null;

        // 1、从 principalCollection 中来获取登录用户的信息

        // 2、利用登录的用户的信息来获取当前用户的角色或者权限

        // 3、创建 SimpleAuthorizationInfo，并设置其 reles 属性

    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("admin执行了认证！");
        // 以前单个 realm 的方法
        // 通过数据库获取用户
//        UsernamePasswordToken userToken = (UsernamePasswordToken)authenticationToken;
//        Admin admin = adminService.selectAdminByAccount(userToken.getUsername());
//        if (admin == null){
//            return null;
//        }
//        return new SimpleAuthenticationInfo("",admin.getAdminPwd(),"");

        // 现在多个 realm 的方法
        // 1. userToken
        UserToken userToken = (UserToken)authenticationToken;
        // 2. 从userToken中获取username，此处 username 即登录时的 userAccount
        String adminName = userToken.getUsername();
        // 3. 对登录账号进行一些判断，例如账号不存在，或者账号当前状态为被冻结
        Admin admin = adminService.selectAdminByAccount(adminName);
        if(admin == null){
            throw new UnknownAccountException("用户不存在");
        }
        // 账号被冻结的情况，有待考虑 2-27
//        else if( admin.getAdminStatus() == "冻结" ){
//            throw new LockedAccountException("账号被冻结");
//        }
        // 4.
        // 根据用户的情况，来构建AuthenticationInfo对象并返回，通常使用的实现类为SimpleAuthenticationInfo
        // 以下信息从数据库中获取
        // （1）principal：认证的实体信息，可以是username，也可以是数据表对应的用户的实体类对象
        Object principal = adminName;
        // （2）credentials：密码
        Object credentials = admin.getAdminPwd();
        // （3）realmName：当前realm对象的name，调用父类的getName()方法即可
        String realmName = getName();
        System.out.println(principal + " " + credentials + " " + realmName);
        // （4）盐值：取用户信息中唯一的字段来生成盐值，避免由于两个用户原始密码相同，加密后的密码也相同
//        ByteSource credentialsSalt = ByteSource.Util.bytes(adminCode);
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principal,admin.getAdminPwd(),realmName);
        return info;
    }
}
