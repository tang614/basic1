package com.tang.impl;

import com.tang.bean.Address;
import com.tang.inter.UserAddress;

public class UserAddressImpl implements UserAddress {
    public Address getAddress() {
        return new Address("安徽",340);
    }
}
