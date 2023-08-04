import io.restassured.RestAssured;
import io.restassured.response.Response;
import models.UserSimpleEntity;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class UserTests {

    public static final String PETSTORE_BASE_URL = "https://petstore.swagger.io/v2";
    public static final String Read_User_BY_Username = "/user/{username}";
    public static final String Delete_User_BY_Username = "/user/{username}";


    @Test
    public void testReadUser() {
        String username = "api";

        Response response = RestAssured.given()
                .baseUri(PETSTORE_BASE_URL)
                .pathParam("username", username)
                .get(Read_User_BY_Username);

        assertEquals(200, response.getStatusCode());

        UserSimpleEntity user = response.as(UserSimpleEntity.class);
        assertNotNull(user.id);
    }

    @Test
    public void testDeleteUser() {
        String username = "api";

        Response response = RestAssured.given()
                .baseUri(PETSTORE_BASE_URL)
                .pathParam("username", username)
                .delete(Delete_User_BY_Username);

        assertEquals(200, response.getStatusCode());
    }

    @Test
    public void testReadDeletedUser() {
        String username = "api";

        Response response = RestAssured.given()
                .baseUri(PETSTORE_BASE_URL)
                .pathParam("username", username)
                .get(Read_User_BY_Username);

        assertEquals(404, response.getStatusCode());
    }


}
