package models.lombok;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class SingleUsersResponseContainer {

    private SingleUserResponse data;
    private Support support;

    @Data
    public static class SingleUserResponse {

        private Integer id;

        private String email;

        @JsonProperty("first_name")
        private String firstName;

        @JsonProperty("last_name")
        private String lastName;

        private String avatar;
    }

    @Data
    public static class Support {
        private String url;
        private String text;
    }
}
