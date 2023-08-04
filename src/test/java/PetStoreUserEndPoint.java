import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.User;

import static io.restassured.RestAssured.given;

public class PetStoreUserEndPoint {




    public Response createUser(User user) {
        return given()
                .body(user)
                .when()
                .post(Config.CREATE_USER)
                .then().extract().response();
    }

    public Response getUserByIdUsername(String username) {
        return given()
                .pathParam("username", username)
                .when()
                .get(Config.Read_User_BY_Username)
                .then().extract().response();

    }



    public Response deleteByUsername(String username) {
        return given()
                .when()
                .delete(Config.Delete_User_BY_Username, username)
                .then().extract().response();

    }

    public Response updateUser(User user) {
        return given()
                .body(user)
                .when()
                .put(Config.Read_User_BY_Username)
                .then().extract().response();
    }

    private RequestSpecification given() {
        return RestAssured.given()
                .log().uri()
                .log().body()
                .baseUri(Config.PETSTORE_BASE_URL)
                .contentType(ContentType.JSON);
    }


        static User createUserObject(String username, String firstName, String lastName, String email, String phone) {
            User user = new User();
            user.setUsername(username);
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setEmail(email);
            user.setPhone(phone);
            user.setUserStatus(1);

            return user;
        }
    }

