package fr.enit.industryportal.souslesensusermanager.model.entities;

import fr.enit.industryportal.souslesensusermanager.model.requests.PortalUser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Abdelwadoud Rasmi
 * To be stored on db
 */
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    @Getter
    @Setter
    @Id
    private String id;

    @Getter
    @Setter
    private String login;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String password;

    @Getter
    @Setter
    private String _type;

    @Getter
    @Setter
    private String rolesInPortal;

    @Getter
    @Setter
    private String groups;

    @Getter
    @Setter
    private String source;

    public static User from(PortalUser user) {

        if (user == null)
            return null;
        return new User(user.getId(),
                user.getUsername(),
                user.getUsername(),
                user.getEmail(),
                "_user",
                user.getRoles().stream().map(s -> s.trim()).collect(Collectors.joining(",")),
                "ontoportal_users",
                "database");
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", _type='" + _type + '\'' +
                ", rolesInPortal='" + rolesInPortal + '\'' +
                ", groups='" + groups + '\'' +
                ", source='" + source + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        return obj != null &&
                (obj instanceof User) &&
                (login.equals(((User) obj).getLogin()));
    }
}
