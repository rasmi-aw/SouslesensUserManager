package fr.enit.industryportal.souslesensusermanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class SouslesensUserManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SouslesensUserManagerApplication.class, args);
    }

}
