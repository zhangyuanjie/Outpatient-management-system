package com.zyj.hos.config.shiroConfig;

import com.zyj.hos.entity.User;
import com.zyj.hos.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;

    // 授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("user执行了授权！");
//        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//        info.addRole("user");
//        // 那倒当前登录的这个对象
//        Subject subject = SecurityUtils.getSubject();
//        User currentUser = (User)subject.getPrincipal(); // 拿到当前登录 User 对象
//        info.addStringPermission(currentUser.getUserName()); // 参数为字符串
//        return info;
//        String loginName=(String) principalCollection.fromRealm(getName()).iterator().next();
//        System.out.println(loginName + " 执行了授权");
//        User user = userService.selectUserByAccount(loginName);
        String userName = (String) principalCollection.getPrimaryPrincipal();
        System.out.println(userName);
        User user = userService.selectUserByAccount(userName);
        if( user != null){
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            info.addRole("user");
            return info;
        }
        return null;
    }

    // 认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("user执行了认证！");

        // 现在多个 realm 的方法
        // 1. userToken
        UserToken userToken = (UserToken)authenticationToken;
        // 2. 从userToken中获取username，此处 username 即登录时的 userAccount
        String userName = userToken.getUsername();
        // 3. 对登录账号进行一些判断，例如账号不存在，或者账号当前状态为被冻结
        User user = userService.selectUserByAccount(userName);
        if(user == null){
            throw new UnknownAccountException("用户不存在");
        }
        // 账号被冻结的情况，有待考虑 2-27日注释
//        else if( admin.getAdminStatus() == "冻结" ){
//            throw new LockedAccountException("账号被冻结");
//        }
        // 4.
        // 根据用户的情况，来构建AuthenticationInfo对象并返回，通常使用的实现类为SimpleAuthenticationInfo
        // 以下信息从数据库中获取
        // （1）principal：认证的实体信息，可以是username，也可以是数据表对应的用户的实体类对象
        Object principal = userName;
        // （2）credentials：密码
        Object credentials = user.getUserPwd();
        // （3）realmName：当前realm对象的name，调用父类的getName()方法即可
        String realmName = getName();
        // （4）盐值：取用户信息中唯一的字段来生成盐值，避免由于两个用户原始密码相同，加密后的密码也相同
//        ByteSource credentialsSalt = ByteSource.Util.bytes(adminCode);
        System.out.println(principal + " " + credentials + " " + realmName);
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principal,user.getUserPwd(),realmName);
        return info;
    }
}
