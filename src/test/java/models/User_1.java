package models;

public class User_1 {
    public static final String USER_FIRST_NAME = "first name";
    public static final String USER_LAST_NAME = "last name";
    public static final String USER_EMAIL = "email.com";
    public static final String USER_PASSWORD = "password";
    public static final String USER_PHONE = "123-123-123";
    public static final int USER_STATUS = 0;
    public int id;
    private String username;
    public String firstName;
    public String lastName;
    public String email;
    public String password;
    public String phone;
    public int userStatus;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(int userStatus) {
        this.userStatus = userStatus;
    }
    public static User_1 createUserAsClass(int id, String name) {

        User_1 user = new User_1();
        user.setUsername(name);
        user.setId(id);
        user.setFirstName(USER_FIRST_NAME);
        user.setLastName(USER_LAST_NAME);
        user.setEmail(USER_EMAIL);
        user.setPassword(USER_PASSWORD);
        user.setPhone(USER_PHONE);
        user.setUserStatus(USER_STATUS);

        return user;
    }
}
