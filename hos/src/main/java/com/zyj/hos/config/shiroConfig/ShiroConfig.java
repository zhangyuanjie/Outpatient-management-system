package com.zyj.hos.config.shiroConfig;

import org.apache.shiro.authc.pam.AtLeastOneSuccessfulStrategy;
import org.apache.shiro.authc.pam.FirstSuccessfulStrategy;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class ShiroConfig {
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") SecurityManager securityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        // 设置安全管理器
        bean.setSecurityManager(securityManager);
        // 添加 Shiro 的内置过滤器
        /*
            anon: 无需认证就能访问
            authc: 必须认证了才能访问
            user: 必须拥有 记住我 功能才能用
            role: 拥有某个角色权限才能访问
         */
        // 拦截
        Map<String, String> filterMap = new LinkedHashMap<>();
//        filterMap.put("/user/add","authc");
//        filterMap.put("/user/update","authc");

        // 授权
//        filterMap.put("/user/add","perms[user:add]");
        // 拦截
        filterMap.put("/user/login","anon");
        filterMap.put("/doctor/login","anon");
        filterMap.put("/admin/login","anon");

        filterMap.put("/user/**","roles[user]");
        filterMap.put("/doctor/**","roles[doctor]");
        filterMap.put("/admin/**","roles[admin]");

        // 退出
        filterMap.put("/logout","logout");
        bean.setFilterChainDefinitionMap(filterMap);
        // 设置登录的请求
        bean.setLoginUrl("/tologin");


        // 设置未授权的请求
        bean.setUnauthorizedUrl("/noauth");
        return bean;
    }
//
//    // 2、DefaultWebSecurityManager
//    @Bean(name = "securityManager")
//    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
//        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
//        // 关联 UserRealm
//        securityManager.setRealm(userRealm);
//        return securityManager;
//    }
//
//    // 1、创建 realm 对象， 需要自定义类
//    @Bean
//    public UserRealm userRealm(){
//        return new UserRealm();
//    }

    // 2、DefaultWebSecurityManager
    @Bean("securityManager")
    public SecurityManager securityManager(){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 设置 realm
        securityManager.setAuthenticator(modularRealmAuthenticator());

//        ModularRealmAuthenticator modularRealmAuthenticator = new ModularRealmAuthenticator();
//        modularRealmAuthenticator.setAuthenticationStrategy(new FirstSuccessfulStrategy());
//        securityManager.setAuthenticator(modularRealmAuthenticator);

        List<Realm> realms = new ArrayList<>();
        //添加多个Realm
        realms.add(adminRealm());
        realms.add(doctorRealm());
        realms.add(userRealm());
        securityManager.setRealms(realms);
//        // 自定义缓存实现 使用redis
//        securityManager.setCacheManager(cacheManager())
//        // 自定义session管理 使用redis
//        securityManager.setSessionManager(sessionManager())
//        //注入记住我管理器;
//        securityManager.setRememberMeManager(rememberMeManager())
        return securityManager;
    }

    /**
     * 系统自带的Realm管理，主要针对多realm
     * */
    @Bean
    public ModularRealmAuthenticator modularRealmAuthenticator(){
        //自己重写的ModularRealmAuthenticator
        UserModularRealmAuthenticator modularRealmAuthenticator = new UserModularRealmAuthenticator();
        modularRealmAuthenticator.setAuthenticationStrategy(new AtLeastOneSuccessfulStrategy());
        return modularRealmAuthenticator;
    }

    // 1、设置 realm
    @Bean
    public AdminRealm adminRealm() {
        AdminRealm adminRealm = new AdminRealm();
//        adminShiroRealm.setCredentialsMatcher(hashedCredentialsMatcher())//设置解密规则
        return adminRealm;
    }

    @Bean
    public DoctorRealm doctorRealm() {
        DoctorRealm doctorRealm = new DoctorRealm();
//        studentShiroRealm.setCredentialsMatcher(hashedCredentialsMatcher())//设置解密规则
        return doctorRealm;
    }

    @Bean
    public UserRealm userRealm() {
        UserRealm userRealm = new UserRealm();
//        teacherShiroRealm.setCredentialsMatcher(hashedCredentialsMatcher())//设置解密规则
        return userRealm;
    }
}
