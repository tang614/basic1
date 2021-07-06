package org.example.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

//继承AuthorizingRealm，对授权和认证方法自定义，代替了shiro.ini，此时用户信息可以来自数据库和其他地方
public class CustomerRealm extends AuthorizingRealm {
    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    //认证：从token中拿到用户名，查询数据库是否有该用户，有的话把数据库中的密码和token中拿到的用户名组成info返回，交由其父类AuthenticatingRealm完成剩下的工作
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //在token中获取用户名
        String principal = (String)token.getPrincipal();
        System.out.println(principal);

        //根据用户名查询数据库,返回密码等信息，把username和password作为返回的认证信息AuthenticationInfo给AuthenticatingRealm，AuthenticatingRealm拿到
        //认证信息后开始进行密码的比较即AuthenticatingRealm中206行this.assertCredentialsMatch(token, info);
        if("tom".equals(principal)){
            //数据库的名字、密码、this.name
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(principal,"123",this.getName());
            return simpleAuthenticationInfo;
        }

        return null;
    }
}
