package fr.enit.industryportal.souslesensusermanager.helpers;

import fr.enit.industryportal.souslesensusermanager.config.Config;
import fr.enit.industryportal.souslesensusermanager.model.requests.PortalUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

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
    @GetMapping("/users?apikey=" + Config.API_KEY)
    List<PortalUser> getUsers();
}
