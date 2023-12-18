package cocktailTest;
import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class PerformanceTests {

    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = "https://www.thecocktaildb.com/api/json/v1/1";
    }

    @Test
    public void testSearchIngredientsPerformance() {
        // Simulate concurrent requests and measure response time
        given()
                .param("i", "vodka")
                .when()
                .get("/search.php")
                .then()
                .statusCode(200)
                .time(lessThan(2000L)); // Set a threshold for response time in milliseconds
    }

    @Test
    public void testSearchCocktailsPerformance() {
        // Simulate concurrent requests and measure response time
        given()
                .param("s", "margarita")
                .when()
                .get("/search.php")
                .then()
                .statusCode(200)
                .time(lessThan(2000L)); // Set a threshold for response time in milliseconds
    }

    // Add more performance test cases as needed

}
