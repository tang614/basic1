package com.tang.impl;

import com.tang.bean.Address;
import com.tang.bean.Info;
import com.tang.inter.UserAddress;
import com.tang.inter.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserinfoImpl implements UserInfo {

    @Autowired
    UserAddress userAddress;

    public Info getInfo() {
        Address address = userAddress.getAddress();
        System.out.println(address);
        Info info = new Info("tom", "10068");
        return info;
    }
}
