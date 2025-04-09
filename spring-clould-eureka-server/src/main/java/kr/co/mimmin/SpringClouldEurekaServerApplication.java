package kr.co.mimmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class SpringClouldEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringClouldEurekaServerApplication.class, args);
    }

}
