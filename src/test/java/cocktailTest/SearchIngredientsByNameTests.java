package cocktailTest;
import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class SearchIngredientsByNameTests {

    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = "https://www.thecocktaildb.com/api/json/v1/1";
    }

    @Test
    public void IngredientsByName() {
        given()
                .param("i", "vodka")
                .when()
                .get("/search.php")
                .then() //Assertions
                .statusCode(200)
                .body("ingredients", notNullValue())
                .body("ingredients[0].idIngredient", notNullValue())
                .body("ingredients[0].strIngredient", equalTo("Vodka"))
                .body("ingredients[0].strDescription", notNullValue())
                .body("ingredients[0].strType", notNullValue())
                .body("ingredients[0].strAlcohol", notNullValue())
                .body("ingredients[0].strABV", anyOf(equalTo(null), notNullValue())) // ABV should be null or not null based on alcohol content
                .log().all(); // Log response
    }
    @Test
    public void testEmptySearch() {
        given()
                .param("i", "")
                .when()
                .get("/search.php")
                .then()
                .statusCode(200)
                .body("ingredients", nullValue()) // Assuming the API returns null for empty searches
                .log().all(); // Log response for debugging
    }


}

