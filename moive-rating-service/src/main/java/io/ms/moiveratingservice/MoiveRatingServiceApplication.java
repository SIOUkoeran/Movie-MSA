package io.ms.moiveratingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MoiveRatingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MoiveRatingServiceApplication.class, args);
    }

}
