package fr.enit.industryportal.souslesensusermanager.model.storage;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @author Abdelwadoud Rasmi
 * Request model
 */
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Getter
    @Setter
    @JsonProperty("login")
    private String username;

    @Getter
    @Setter
    @JsonProperty("id")
    private String id = username;

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
                "username='" + username + '\'' +
                ", id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", rolesInPortal=" + rolesInPortal +
                ", groups=" + groups +
                ", source='" + source + '\'' +
                '}';
    }
}
