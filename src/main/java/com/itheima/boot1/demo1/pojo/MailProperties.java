package com.itheima.boot1.demo1.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
//@ConfigurationProperties:配置属性文件中的前缀
//@PropertySource :配置加载属性文件的位置
//@Componet:加载此类加入spring容器中管理
@ConfigurationProperties(prefix = "mail")
@PropertySource(value = "classpath:mail.properties")
@Component
public class MailProperties {
    private  String host;
    private  String port;
    private  String username;
    private  String password;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
