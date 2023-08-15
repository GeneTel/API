import io.restassured.response.Response;
import models.User_1;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.junit.Before;
import org.junit.Test;


public class CrudTestUser_1 {

    @Before
    public  void cleanUp(){
        new PetStoreUserEndPoint_1()
                .deleteByUserName("apiTest");
        System.out.println();
    }

    @Test
    public void createUser() {

        User_1 newUser = User_1.createUserAsClass(123130, "apiTest");

       new PetStoreUserEndPoint_1()
                .createUser(newUser);

       String createdUserName = newUser
                .getUsername();

        User_1 userCreatedFromService = new PetStoreUserEndPoint_1()
                .getUserByName(createdUserName)
                .as(User_1.class);

        SoftAssertions assertions = new SoftAssertions();
        assertions.assertThat(userCreatedFromService.getUsername()).as("username").isEqualTo(newUser.getUsername());
        assertions.assertAll();
    }

    @Test
    public void readUser() {

        User_1 newUser = User_1.createUserAsClass(123131, "apiTest");

        new PetStoreUserEndPoint_1()
                .createUser(newUser);

        String createdUserName = newUser
                .getUsername();

        User_1 userCreatedFromService = new PetStoreUserEndPoint_1()
                .getUserByName(createdUserName)
                .as(User_1.class);

        SoftAssertions assertions = new SoftAssertions();
        assertions.assertThat(userCreatedFromService.getUsername()).as("username").isEqualTo(newUser.getUsername());
        assertions.assertThat(userCreatedFromService.getId()).as("id").isEqualTo(newUser.getId());
        assertions.assertThat(userCreatedFromService.getFirstName()).as("firstName").isEqualTo(newUser.getFirstName());
        assertions.assertThat(userCreatedFromService.getLastName()).as("lastName").isEqualTo(newUser.getLastName());
        assertions.assertThat(userCreatedFromService.getEmail()).as("email").isEqualTo(newUser.getEmail());
        assertions.assertThat(userCreatedFromService.getPassword()).as("password").isEqualTo(newUser.getPassword());
        assertions.assertThat(userCreatedFromService.getPhone()).as("phone").isEqualTo(newUser.getPhone());
        assertions.assertThat(userCreatedFromService.getUserStatus()).as("userStatus").isEqualTo(newUser.getUserStatus());
        assertions.assertAll();
    }
    @Test
    public void updateUser() {

        User_1 newUser = User_1.createUserAsClass(123132, "apiTest");
        new PetStoreUserEndPoint_1()
                .createUser(newUser);
        String createdUserName = newUser
                .getUsername();

        newUser.setEmail("new email");
        newUser.setPassword("new password");
        new PetStoreUserEndPoint_1()
                .updateUser(newUser,createdUserName);

        User_1 userCreatedFromService = new PetStoreUserEndPoint_1()
                .getUserByName(createdUserName).body().as(User_1.class);

        SoftAssertions assertions = new SoftAssertions();
        assertions.assertThat(userCreatedFromService.getUsername()).as("username").isEqualTo(newUser.getUsername());
        assertions.assertThat(userCreatedFromService.getId()).as("id").isEqualTo(newUser.getId());
        assertions.assertThat(userCreatedFromService.getPassword()).as("password").isEqualTo(newUser.getPassword());
        assertions.assertThat(userCreatedFromService.getEmail()).as("email").isEqualTo(newUser.getEmail());
        assertions.assertAll();

    }
    @Test
    public void deletePet() {
        User_1 newUser = User_1.createUserAsClass(123133, "apiTestUser");

        new PetStoreUserEndPoint_1()
                .createUser(newUser);
        String createdUserName = newUser
                .getUsername();
        new PetStoreUserEndPoint_1()
                .deleteByUserName(createdUserName);

        Response userByName = new PetStoreUserEndPoint_1().getUserByName(createdUserName);
        Assertions.assertThat(userByName.statusCode()).isEqualTo(404);

    }
}
