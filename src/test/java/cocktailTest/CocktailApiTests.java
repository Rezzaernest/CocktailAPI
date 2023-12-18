package cocktailTest;

import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class CocktailApiTests {

    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = "https://www.thecocktaildb.com/api/json/v1/1";
    }

    @Test
    public void testSearchIngredientsByName() {
        given()
                .param("i", "vodka")
                .when()
                .get("/search.php")
                .then()
                .statusCode(200)
                .body("ingredients", notNullValue())
                .body("ingredients[0].strIngredient", equalTo("Vodka"))
                // Add more assertions based on the requirements
                .log().all(); // Log response for debugging
    }

    @Test
    public void testSearchCocktailsByName() {
        given()
                .param("s", "margarita")
                .when()
                .get("/search.php")
                .then()
                .statusCode(200)
                .body("drinks", notNullValue())
                .body("drinks[0].strDrink", equalTo("Margarita"))
                // Add more assertions based on the requirements
                .log().all(); // Log response for debugging
    }

    // Add more test cases as needed

}
