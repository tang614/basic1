package com.tang.xmltest.dao.impl;

import com.tang.xmltest.dao.HelloDao;

import java.util.Arrays;
import java.util.List;

public class HelloDaoImpl implements HelloDao {

    @Override
    public List<String> getAll() {
        return Arrays.asList("1","2","3");
    }
}
