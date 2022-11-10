package fr.enit.industryportal.souslesensusermanager.helpers;

import fr.enit.industryportal.souslesensusermanager.config.Config;
import fr.enit.industryportal.souslesensusermanager.model.requests.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author Abdelwadoud Rasmi
 * This is the main entrypoint of the app
 */
@FeignClient(name = "userClient", url = Config.API_URL)

public interface UserHelper {

    /**
     * Queries the portal api to check of this user exist
     */
    @GetMapping("/users/{username}")
    List<User> getUser(@PathVariable String username,
                       @RequestParam String apikey);
}
