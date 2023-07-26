import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static io.restassured.RestAssured.given;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MySampleTestsPetStore {

    @Test
    public void bverifyStatusCode() {
        new PetStorePetEndPoint()
                .getPetByStatus("available")
                .then()
                .log().status()
                .statusCode(200);
    }

    @Test
    public void averifyBodyUseParam() {
        new PetStorePetEndPoint()
                .getPetByStatus("available")
                .then()
                .assertThat()
                .log().status()
                .body(Matchers.notNullValue());
    }

    @Test
    public void cverifyNotExistingPet() {
        new PetStorePetEndPoint()
                .getPetById("0")
                .then()
                .log().body()
                .statusCode(404);
    }

    @Test
    public void dverifyNotExistingPetReturn404() {
        new PetStorePetEndPoint()
                .getPetById("123456789012345")
                .then()
                .log().body()
                .statusCode(404);
    }

}
