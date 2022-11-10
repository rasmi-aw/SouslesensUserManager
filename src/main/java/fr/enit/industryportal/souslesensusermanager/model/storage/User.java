package fr.enit.industryportal.souslesensusermanager.model.storage;

import fr.enit.industryportal.souslesensusermanager.model.requests.PortalUser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Abdelwadoud Rasmi
 * To be stored on db
 */
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Getter
    @Setter
    private String login;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String id;

    @Getter
    @Setter
    private String password;

    @Getter
    @Setter
    private String _type;

    @Getter
    @Setter
    private List<String> rolesInPortal;

    @Getter
    @Setter
    private List<String> groups;

    @Getter
    @Setter
    private String source;

    public static User from(PortalUser user) {
        if (user == null)
            return null;
        return new User(user.getUsername(),
                user.getUsername(),
                user.getId(),
                user.getEmail(),
                "_user",
                user.getRoles(),
                Arrays.asList(new String[]{"ontoportal_users"}),
                "json");
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", type='" + _type + '\'' +
                ", rolesInPortal=" + rolesInPortal +
                ", groups=" + groups +
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
