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

    public static class UserBuilder{
        private String firstName; // required
        private String lastName; // required
        private String birthday; // required
        private String phone = ""; // default value is a empty String
        private String address; // default value is null
    }
}
