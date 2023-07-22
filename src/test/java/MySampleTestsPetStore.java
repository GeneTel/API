import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class MySampleTestsPetStore {

    @Test
    public void verifyStatusCode() {
        new PetStorePetEndPoint()
                .getPetByStatus("available")
                .then()
                .log().status()
                .statusCode(200);
    }

    @Test
    public void verifyBodyUseParam() {
        new PetStorePetEndPoint()
                .getPetByStatus("available")
                .then()
                .assertThat()
                .log().status()
                .body(Matchers.notNullValue());
    }

    @Test
    public void verifyNotExistingPet() {
        new PetStorePetEndPoint()
                .getPetById("0")
                .then()
                .log().body()
                .statusCode(404);
    }

    @Test
    public void verifyNotExistingPetReturn404() {
        new PetStorePetEndPoint()
                .getPetById("123456789012345")
                .then()
                .log().body()
                .statusCode(404);
    }

}
