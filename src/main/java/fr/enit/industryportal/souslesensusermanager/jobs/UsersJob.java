package fr.enit.industryportal.souslesensusermanager.jobs;


import fr.enit.industryportal.souslesensusermanager.helpers.UserHelper;
import fr.enit.industryportal.souslesensusermanager.model.entities.User;
import fr.enit.industryportal.souslesensusermanager.model.entities.repose.UserRepository;
import fr.enit.industryportal.souslesensusermanager.model.requests.PortalUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * @author Abdelwadoud Rasmi
 * A job to update users from ontoportal
 */
@Component
public class UsersJob implements Job {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserHelper userHelper;

    @Override
    @Scheduled(fixedDelay = HOUR)
    public void execute() {
        //Execute this code every Hour
        System.out.println("Update at: '" + new Date() + "'");
        update(userHelper, userRepository);
    }

    public static void update(UserHelper userHelper, UserRepository userRepository) {
        try {
            //Fetch portal users with an HTTP call
            List<PortalUser> portalUsers = userHelper.getUsers();
            portalUsers.forEach(puser -> {
                String password = userRepository.getUserPassword(puser.getId());
                User user = User.from(puser);
                //prevent password changing
                if (password != null)
                    user.setPassword(password);
                // case of a new user
                userRepository.save(user);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}