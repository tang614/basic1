package com.tang;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class ConnectionUtil {
    public static Connection getConnection() {
        ConnectionFactory factory = new ConnectionFactory();
        // 设置工厂信息
        factory.setHost("localhost");
        factory.setPort(5672);
        factory.setVirtualHost("/tang");
        factory.setUsername("test");
        factory.setPassword("123456");
        Connection connection = null;
        try {
            connection = factory.newConnection();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
