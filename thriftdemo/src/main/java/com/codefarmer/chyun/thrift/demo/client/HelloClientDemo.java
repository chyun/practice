/*
 */
package com.codefarmer.chyun.thrift.demo.client;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

import com.codefarmer.chyun.thrift.demo.HelloWorldService;

/**
 * 类HelloClientDemo.java的实现描述：TODO 类实现描述 
 * @author chyun 3 Dec, 2015 9:44:31 am
 */
public class HelloClientDemo {
    public static final String SERVER_IP = "localhost";
    public static final int SERVER_PORT = 8090;
    public static final int TIMEOUT = 30000;

    public void startClient(String userName) {
        TTransport transport = null;
        try {
            transport = new TSocket(SERVER_IP, SERVER_PORT, TIMEOUT);
            // 协议要和服务端一致
            TProtocol protocol = new TBinaryProtocol(transport);
            // TProtocol protocol = new TCompactProtocol(transport);
            // TProtocol protocol = new TJSONProtocol(transport);
            HelloWorldService.Client client = new HelloWorldService.Client(
                    protocol);
            transport.open();
            String result = client.sayHello(userName);
            System.out.println("Thrify client result =: " + result);
        } catch (TTransportException e) {
            e.printStackTrace();
        } catch (TException e) {
            e.printStackTrace();
        } finally {
            if (null != transport) {
                transport.close();
            }
        }
    }
    public static void main(String[] args) {
        HelloClientDemo client = new HelloClientDemo();
        client.startClient("Dantin");
    }

}
