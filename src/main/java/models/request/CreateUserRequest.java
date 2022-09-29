package models.request;

public class CreateUserRequest {

    public Integer id;
    public String username;
    public String firstname;
    public String lastName;
    public String email;
    public String password;
    public Integer phone;
    public String userStatus;

    private CreateUserRequest(Builder builder) {
        id = builder.id;
        username = builder.username;
        firstname = builder.firstname;
        lastName = builder.lastName;
        email = builder.email;
        password = builder.password;
        phone = builder.phone;
        userStatus = builder.userStatus;
    }

    public static Builder builder() {
        return new Builder();
    }


    public static final class Builder {
        private Integer id;
        private String username;
        private String firstname;
        private String lastName;
        private String email;
        private String password;
        private Integer phone;
        private String userStatus;

        private Builder() {
        }

        public Builder id(Integer val) {
            id = val;
            return this;
        }

        public Builder username(String val) {
            username = val;
            return this;
        }

        public Builder firstname(String val) {
            firstname = val;
            return this;
        }

        public Builder lastName(String val) {
            lastName = val;
            return this;
        }

        public Builder email(String val) {
            email = val;
            return this;
        }

        public Builder password(String val) {
            password = val;
            return this;
        }

        public Builder phone(Integer val) {
            phone = val;
            return this;
        }

        public Builder userStatus(String val) {
            userStatus = val;
            return this;
        }

        public CreateUserRequest build() {
            return new CreateUserRequest(this);
        }
    }
}
