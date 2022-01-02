package com.liang.modules.sys.shiro;

//import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.mgt.WebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;

/**
 *
 * @ProjectName:
 * @Package:        com.liang.modules.sys.shiro
 * @ClassName:      ShiroConfig.java
 * @Description:
 * @Author:         Yang Liang
 * @CreateDate:     2021/12/29 9:34
 * @Version:        1.0
 */
@Configuration
public class ShiroConfig {

    /**
     * 密码校验规则 HashedCredentialsMatcher
     * 这个Bean自动装载到Spring中，当登录认证的时候自动使用这种方式对密码进行编码，因为首先密码不会在数据库中明文保存
     */
    @Bean("hashedCredentialsMatcher")
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        //指定加密方式为MD5
        credentialsMatcher.setHashAlgorithmName("MD5");
        //加密次数
        credentialsMatcher.setHashIterations(1024);
        credentialsMatcher.setStoredCredentialsHexEncoded(true);
        return credentialsMatcher;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(
            @Qualifier("defaultWebSecurityManager") WebSecurityManager securityManager
    ){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(securityManager);   // 设置安全管理器
        // 设置登录url映射
        bean.setLoginUrl("login");
        // 设置未授权时的跳转的请求
        bean.setUnauthorizedUrl("/");
        // 添加shiro的内置过滤器
        /*
            anon: 无需认证就可以登录
            authc:必须认证才能登录
            user: 必须拥有“记住我”这个功能
            perms:拥有对某个资源的权限才能访问
            role:拥有某个角色才能访问
         */
        LinkedHashMap<String, String> filterMap = new LinkedHashMap<>();    //使用LinkedHashMap可以保证顺序 以便 /** anon在最后过滤
        // 权限授权,访问url需要权限,支持通配符
        filterMap.put("/", "anon");
        filterMap.put("/user", "authc");    // authc --   认证(登录)才能使用
        filterMap.put("/editor", "roles[admin]");
        filterMap.put("/SuperAdmin", "roles[admin]");
        filterMap.put("/druid/**", "anon");
        filterMap.put("/**", "anon");
        bean.setFilterChainDefinitionMap(filterMap);
        return bean;
    }
    //2. 获取安全管理器
    @Bean(name = "defaultWebSecurityManager")
    public DefaultWebSecurityManager defaultWebSecurityManager(
            @Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);    //注入
        return securityManager;
    }
    //  1.定义userRealm进springboot组件 并配置认证加密方式
    @Bean(name="userRealm")
    public UserRealm userRealm(){
        UserRealm userRealm = new UserRealm();
        userRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        return userRealm;
    }

//    // Shiro控制ThymeLeaf界面按钮级权限控制
//    @Bean
//    public ShiroDialect getShiroDialect(){
//        return new ShiroDialect();
//    }
}
