import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.User_1;

public class PetStoreUserEndPoint_1 {



    public Response getUserByName(String name) {
        return given()
                .pathParam("username", name)
                .when()
                .get(Config.USER_BY_NAME)
                .then().extract().response();
    }

    public Response createUser(User_1 user) {
        return given()
                .body(user)
                .when()
                .post(Config.CREATE_USER)
                .then().extract().response();
    }
    public Response updateUser(User_1 user, String name) {
        return given()
                .body(user)
                .when()
                .put(Config.USER_BY_NAME, name)
                .then().extract().response();
    }

    public Response deleteByUserName(String name) {
        return given()
                .when()
                .delete(Config.USER_BY_NAME, name)
                .then().extract().response();
    }
    private RequestSpecification given() {
        return RestAssured.given()
                .log().uri()
                .log().body()
                .baseUri(Config.PETSTORE_BASE_URL)
                .contentType(ContentType.JSON);
    }
}
