package fr.enit.industryportal.souslesensusermanager;

import fr.enit.industryportal.souslesensusermanager.helpers.UserHelper;
import fr.enit.industryportal.souslesensusermanager.jobs.UsersJob;
import fr.enit.industryportal.souslesensusermanager.model.entities.repose.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableFeignClients
@SpringBootApplication
@EnableScheduling
public class SouslesensUserManagerApplication implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserHelper userHelper;

    public static void main(String[] args) {
        SpringApplication.run(SouslesensUserManagerApplication.class, args);
    }

    @Override
    public void run(String... args) {
        //
        UsersJob.update(userHelper, userRepository);
    }

}
