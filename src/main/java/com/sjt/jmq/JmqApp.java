package com.sjt.jmq;

import com.sjt.jmq.listener.ApplicationStartup;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JmqApp {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(JmqApp.class);
        application.addListeners(new ApplicationStartup());
        application.run(args);

    }
}
