package models.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties("ignoreUnknown = true")
public class CreateUserResponse {

    /**
     * @JsonProperty("id")
     *     public Integer id;
     *     @JsonProperty("username")
     *     public String username;
     *     @JsonProperty("firstName")
     *     public String firstname;
     *     @JsonProperty("lastName")
     *     public String lastName;
     *     @JsonProperty("email")
     *     public String email;
     *     @JsonProperty("password")
     *     public String password;
     *     @JsonProperty("phone")
     *     public Integer phone;
     *     @JsonProperty("userStatus")
     *     public String userStatus;
     */
    @JsonProperty("code")
    public String code;
    @JsonProperty("type")
    public String type;
    @JsonProperty("message")
    public String message;


}
