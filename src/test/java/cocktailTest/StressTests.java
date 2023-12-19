package cocktailTest;
import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class StressTests {

    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = "https://www.thecocktaildb.com/api/json/v1/1";
    }

    @Test
    public void testSearchIngredientsStress() {
        // Simulate a high load by sending a large number of requests
        int numberOfRequests = 10;

        for (int i = 0; i < numberOfRequests; i++) {
            given()
                    .param("i", "vodka")
                    .when()
                    .get("/search.php")
                    .then()
                    .statusCode(200)
                    .time(lessThan(1000L)) // Set a threshold for response time in milliseconds
                    .log().ifError(); // Log response for debugging

        }
    }

    @Test
    public void testSearchCocktailsStress() {
        // Simulate a high load by sending a large number of requests
        int numberOfRequests = 10;

        for (int i = 0; i < numberOfRequests; i++) {
            given()
                    .param("s", "margarita")
                    .when()
                    .get("/search.php")
                    .then()
                    .statusCode(200)
                    .time(lessThan(1000L)) // Set a threshold for response time in milliseconds
                    .log().ifError(); // Log response for debugging

        }
    }

}
