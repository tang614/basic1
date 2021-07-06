package org.example;

import org.apache.shiro.crypto.hash.Md5Hash;

public class MD5Test {
    public static void main(String[] args) {
        //使用MD5
        Md5Hash md5Hash = new Md5Hash("123");
        System.out.println(md5Hash);
        System.out.println(md5Hash.toHex());

        //使用MD5+salt
        Md5Hash md5Hash1 = new Md5Hash("123", "#445.");
        System.out.println(md5Hash1);

        //使用MD5+salt+散列100次
        Md5Hash md5Hash2 = new Md5Hash("123", "#445.", 100);
        System.out.println(md5Hash2);
    }
}
