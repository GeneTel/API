import io.restassured.response.Response;
import models.User;
import org.assertj.core.api.SoftAssertions;
import org.junit.BeforeClass;
import org.junit.Test;

public class UserCrudTests {

    @BeforeClass
    public static void cleanUp() {

    }

    @Test
    public void createUser() {
        // Given
        User newUser = PetStoreUserEndPoint.createUserObject("api", "Gene", "Telepov", "gene@ukr.net", "513513513");

        // When
        Response createUserResponse = new PetStoreUserEndPoint().createUser(newUser);

        // Then
        User createdUser = createUserResponse.body().as(User.class);

        SoftAssertions assertions = new SoftAssertions();
        assertions.assertThat(createdUser.getUsername()).isEqualTo(newUser.getUsername());
        assertions.assertThat(createdUser.getFirstName()).isEqualTo(newUser.getFirstName());
        assertions.assertThat(createdUser.getLastName()).isEqualTo(newUser.getLastName());
        assertions.assertThat(createdUser.getEmail()).isEqualTo(newUser.getEmail());
        assertions.assertThat(createdUser.getPhone()).isEqualTo(newUser.getPhone());
        assertions.assertAll();
    }

    @Test
    public void readUser() {
        // Given
        User newUser = PetStoreUserEndPoint.createUserObject("testuser", "John", "Doe", "john@example.com", "1234567890");
        Response createUserResponse = new PetStoreUserEndPoint().createUser(newUser);
        String createdUsername = createUserResponse.body().as(User.class).getUsername();

        // When
        Response readUserResponse = new PetStoreUserEndPoint().getUserByIdUsername(createdUsername);

        // Then
        User readUser = readUserResponse.body().as(User.class);
        SoftAssertions assertions = new SoftAssertions();
        assertions.assertThat(readUser.getUsername()).isEqualTo(newUser.getUsername());
        assertions.assertThat(readUser.getFirstName()).isEqualTo(newUser.getFirstName());
        assertions.assertThat(readUser.getLastName()).isEqualTo(newUser.getLastName());
        assertions.assertThat(readUser.getEmail()).isEqualTo(newUser.getEmail());
        assertions.assertThat(readUser.getPhone()).isEqualTo(newUser.getPhone());
        assertions.assertAll();
    }

    @Test
    public void updateUser() {
        // Given
        User newUser = PetStoreUserEndPoint.createUserObject("username", "Gene", "Telepov", "gene@ukr.net", "513513513");
        Response createUserResponse = new PetStoreUserEndPoint().createUser(newUser);
        User updatedUser = new User();
        updatedUser.setUsername(newUser.getUsername());
        updatedUser.setFirstName("UpdatedFirstName");
        updatedUser.setLastName("UpdatedLastName");

        // When
        Response updateUserResponse = new PetStoreUserEndPoint().updateUser(updatedUser);

        // Then
        User updatedUserResponse = updateUserResponse.body().as(User.class);
        SoftAssertions assertions = new SoftAssertions();
        assertions.assertThat(updatedUserResponse.getUsername()).isEqualTo(updatedUser.getUsername());
        assertions.assertThat(updatedUserResponse.getFirstName()).isEqualTo(updatedUser.getFirstName());
        assertions.assertThat(updatedUserResponse.getLastName()).isEqualTo(updatedUser.getLastName());
        assertions.assertAll();
    }

    @Test
    public void deleteUser() {
        // Given
        User newUser = PetStoreUserEndPoint.createUserObject("username", "Gene", "Telepov", "gene@ukr.net", "513513513");
        Response createUserResponse = new PetStoreUserEndPoint().createUser(newUser);
        String createdUsername = createUserResponse.body().as(User.class).getUsername();

        // When
        Response deleteUserResponse = new PetStoreUserEndPoint().deleteByUsername(createdUsername);

        // Then
        SoftAssertions assertions = new SoftAssertions();
        assertions.assertThat(deleteUserResponse.getStatusCode()).isEqualTo(200);
        assertions.assertAll();
    }
}
