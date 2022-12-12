package fr.enit.industryportal.souslesensusermanager.model.entities.repose;

import fr.enit.industryportal.souslesensusermanager.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author Abdelwadoud Rasmi
 * Jpa Repo to store users in db
 */
public interface UserRepository extends JpaRepository<User, String> {

    @Query("SELECT password FROM User WHERE id = :id")
    String getUserPassword(String id);

    @Query("SELECT groups FROM User WHERE id = :id")
    String getUserGroups(String id);
}
