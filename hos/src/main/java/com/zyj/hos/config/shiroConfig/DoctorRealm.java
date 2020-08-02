package com.zyj.hos.config.shiroConfig;

import com.zyj.hos.entity.Doctor;
import com.zyj.hos.service.DoctorService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;

public class DoctorRealm extends AuthorizingRealm {
    @Resource
    private DoctorService doctorService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("doctor执行了授权");
//        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//        info.addRole("doctor");
//        Subject subject = SecurityUtils.getSubject();
//        Doctor currentDoctor = (Doctor)subject.getPrincipal(); // 拿到当前登录 User 对象
//        info.addStringPermission(currentDoctor.getDoctorName()); // 参数为字符串
//
//        return info;
//        String loginName=(String) principalCollection.fromRealm(getName()).iterator().next();
//        System.out.println(loginName + " 执行了授权");
//        Doctor doctor = doctorService.selectDoctorByAccount(loginName);
        String doctorName = (String) principalCollection.getPrimaryPrincipal();
        System.out.println(doctorName);
        Doctor doctor = doctorService.selectDoctorByAccount(doctorName);
        if( doctor != null){
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            info.addRole("doctor");
            return info;
        }
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("doctor执行了认证");
        // 2、通过数据库获取用户
//        UsernamePasswordToken userToken = (UsernamePasswordToken)authenticationToken;
//        // 连接真实的数据库
//        Doctor doctor = doctorService.selectDoctorByAccount(userToken.getUsername());
//        if(doctor==null){ // 没有这个人
//            return null;
//        }
//        // 加密方式：MD5：sa1ds1d5a4    MD5盐值加密：sa1ds1d5a4username
//        // 密码认证，可以加密
//        return new SimpleAuthenticationInfo("",doctor.getDoctorPwd(),"");
        // 现在多个 realm 的方法
        // 1. userToken
        UserToken userToken = (UserToken)authenticationToken;
        // 2. 从userToken中获取username，此处 username 即登录时的 userAccount
        String doctorName = userToken.getUsername();
        // 3. 对登录账号进行一些判断，例如账号不存在，或者账号当前状态为被冻结
        Doctor doctor = doctorService.selectDoctorByAccount(doctorName);
        if(doctor == null){
            throw new UnknownAccountException("用户不存在");
        }
        // 账号被冻结的情况，有待考虑 2-27
//        else if( doctor.getAdminStatus() == "冻结" ){
//            throw new LockedAccountException("账号被冻结");
//        }
        // 4.
        // 根据用户的情况，来构建AuthenticationInfo对象并返回，通常使用的实现类为SimpleAuthenticationInfo
        // 以下信息从数据库中获取
        // （1）principal：认证的实体信息，可以是username，也可以是数据表对应的用户的实体类对象
        Object principal = doctorName;
        // （2）credentials：密码
        Object credentials = doctor.getDoctorPwd();
        // （3）realmName：当前realm对象的name，调用父类的getName()方法即可
        String realmName = getName();
        // （4）盐值：取用户信息中唯一的字段来生成盐值，避免由于两个用户原始密码相同，加密后的密码也相同
//        ByteSource credentialsSalt = ByteSource.Util.bytes(doctorCode);
        System.out.println(principal + " " + credentials + " " + realmName);
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principal,doctor.getDoctorPwd(),realmName);
        return info;
    }
}
