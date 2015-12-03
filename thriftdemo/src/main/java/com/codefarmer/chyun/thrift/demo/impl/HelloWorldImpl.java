/*
 */
package com.codefarmer.chyun.thrift.demo.impl;

import org.apache.thrift.TException;

import com.codefarmer.chyun.thrift.demo.*;
/**
 * 类HelloWorldImpl.java的实现描述：TODO 类实现描述 
 * @author chyun 3 Dec, 2015 12:37:04 am
 */
public class HelloWorldImpl implements HelloWorldService.Iface {

    @Override
    public String sayHello(String username) throws TException {
        return "Hi," + username + " welcome to my thrift demo";
    }

}
