package com.tang.impl;

import com.tang.bean.Address;
import com.tang.inter.UserAddress;
import org.springframework.stereotype.Service;

/**
 * 引入依赖
 * 配置文件
 */
public class UserAddressImpl implements UserAddress {
    public Address getAddress() {
        Address address = new Address("安徽", 34);
        return address;
    }
}
