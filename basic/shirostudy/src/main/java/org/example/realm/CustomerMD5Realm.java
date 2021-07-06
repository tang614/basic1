package org.example.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

public class CustomerMD5Realm extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String principal = (String) token.getPrincipal();//获取用户名

        if ("tom".equals(principal)){
            //参数：用户名，MD5+散列后的密码，随机盐，realm名
            SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(principal, "13dd99b73b843b151529ff18ea9ae38d", ByteSource.Util.bytes("#445."),this.getName());
            return authenticationInfo;
        }

        return null;
    }
}
