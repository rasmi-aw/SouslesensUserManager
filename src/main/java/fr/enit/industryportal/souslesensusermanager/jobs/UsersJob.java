package fr.enit.industryportal.souslesensusermanager.jobs;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import fr.enit.industryportal.souslesensusermanager.config.Config;
import fr.enit.industryportal.souslesensusermanager.helpers.UserHelper;
import fr.enit.industryportal.souslesensusermanager.model.requests.PortalUser;
import fr.enit.industryportal.souslesensusermanager.model.storage.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

/**
 * @author Abdelwadoud Rasmi
 * A job to update users from ontoportal
 */
public class UsersJob implements Job {

    @Autowired
    private UserHelper userHelper;

    @Override
    @Scheduled(cron = EVERY_DAY_MIDNIGHT)
    public void execute() {

    }

    public static void updateFile(UserHelper userHelper) {
        Gson gson = new Gson();
        ObjectMapper mapper = new ObjectMapper();
        try {
            //Reading users from the users.json file
            String json = new String(Files.readAllBytes(new File(Config.USERS_FILE).toPath()));
            JsonObject jo = new JsonParser().parse(json).getAsJsonObject();
            // getting users from the portal through an http call
            List<PortalUser> portalUsers = userHelper.getUsers();
            portalUsers.forEach(puser -> {
                User user = User.from(puser);
                // case of a new user
                if (!json.contains(user.getName())) {
                    try {
                        jo.add(user.getId(), new JsonParser().parse(mapper.writeValueAsString(user)).getAsJsonObject());
                    } catch (JsonProcessingException e) {
                       e.printStackTrace();
                    }
                }

            });
            //
            System.out.println(jo.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}