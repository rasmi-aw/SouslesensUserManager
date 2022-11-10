package fr.enit.industryportal.souslesensusermanager.model.storage;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

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
    private String id = login;

    @Getter
    @Setter
    private String password;

    @Getter
    @Setter
    @JsonProperty("_type")
    private String type;

    @Getter
    @Setter
    private List<String> rolesInPortal;

    @Getter
    @Setter
    private List<String> groups;

    @Getter
    @Setter
    private String source;

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", type='" + type + '\'' +
                ", rolesInPortal=" + rolesInPortal +
                ", groups=" + groups +
                ", source='" + source + '\'' +
                '}';
    }
}
