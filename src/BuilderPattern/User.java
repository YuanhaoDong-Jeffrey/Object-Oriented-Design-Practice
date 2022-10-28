package BuilderPattern;

public class User {
    private final String firstName; // required, and immutable
    private final String lastName; // required, and immutable
    private final String birthday; // required, and immutable
    private String phone; // optional and mutable
    private String address; // optional and mutable

    private User(UserBuilder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.birthday = builder.birthday;
        this.phone = builder.phone;
        this.address = builder.address;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getBirthday() {
        return this.birthday;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getAddress() {
        return this.address;
    }

    public static class UserBuilder{
        private String firstName; // required
        private String lastName; // required
        private String birthday; // required
        private String phone = ""; // default value is a empty String
        private String address; // default value is null

        public UserBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public UserBuilder birthday(String birthday) {
            this.birthday = birthday;
            return this;
        }

        public UserBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public UserBuilder address(String address) {
            this.address = address;
            return this;
        }

        public User build() {
            if (this.firstName == null || this.lastName == null) {
                throw new IllegalArgumentException("Required fields are not set");
            }

            return new User(this);
        }
    }
}

class Test {
    public static void main(String[] args) {
        User.UserBuilder builder =  new User.UserBuilder();
        User cur = builder
                .firstName("Yuanhao")
                .lastName("Dong").build();

        System.out.println(cur.getFirstName());
    }
}
