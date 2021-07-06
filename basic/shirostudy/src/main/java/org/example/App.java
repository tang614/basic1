package org.example;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;
import org.example.realm.CustomerMD5Realm;
import org.example.realm.CustomerRealm;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        //创建安全管理器对象
        DefaultSecurityManager securityManager = new DefaultSecurityManager();

        //1、给安全管理器设置realm,realm是权限管理和用户信息的一些数据，通常来自数据库，初始学习时可以在shiro.ini中设置
        securityManager.setRealm(new IniRealm("classpath:shiro.ini"));

        //2、使用自定义的类CustomerRealm
        //securityManager.setRealm(new CustomerRealm());

        //3、创建比较器，并将比较器的算法设置为MD5,并将散列次数设置为1024次
        //HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        //credentialsMatcher.setHashAlgorithmName("md5");
        //credentialsMatcher.setHashIterations(100);
        //创建CustomerMD5Realm对象，此类继承AuthenticatingRealm，所以有setCredentialsMatcher(),用来设置比较器
        //CustomerMD5Realm realm = new CustomerMD5Realm();
        //认证realm中就有getCredentialsMatcher、setCredentialsMatcher，为什么子类设置了比较器，父类可以用
        //realm.setCredentialsMatcher(credentialsMatcher);
        //securityManager.setRealm(realm);

        //给全局安全工具类设置安全管理器
        SecurityUtils.setSecurityManager(securityManager);

        //subject主体
        Subject subject = SecurityUtils.getSubject();

        //创建令牌
        UsernamePasswordToken token = new UsernamePasswordToken("tom","123");

        //用户带着令牌进入，即用户认证
        try {
            System.out.println("认证状态" + subject.isAuthenticated());
            subject.login(token);
            System.out.println("认证状态" + subject.isAuthenticated());
        }catch (IncorrectCredentialsException e){
            e.printStackTrace();
            System.out.println("密码错误");
        }catch (UnknownAccountException e){
            e.printStackTrace();
            System.out.println("用户名不存在");
        }


    }
}
