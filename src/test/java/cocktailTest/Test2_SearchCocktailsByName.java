package cocktailTest;
import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.Matchers.*;

public class Test2_SearchCocktailsByName {

    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = "https://www.thecocktaildb.com/api/json/v1/1";
    }

    @Test
    public void CocktailsByName() {
        given()
                .param("s", "margarita")
                .when()
                .get("/search.php")
                .then() //Assertions
                .statusCode(200)
                .body("drinks", notNullValue())
                .body("drinks[0].strDrink", equalTo("Margarita"))
                .body("drinks[0].strTags", anyOf(equalTo(null), notNullValue())) // Tags can be null
                .body("drinks[0].strCategory", notNullValue())
                .body("drinks[0].strIBA", anyOf(equalTo(null), notNullValue())) // IBA can be null
                .body("drinks[0].strAlcoholic", notNullValue())
                .body("drinks[0].strGlass", notNullValue())
                .body("drinks[0].strInstructions", notNullValue())
                .body("drinks[0].strDrinkThumb", anyOf(equalTo(null), notNullValue())) // Drink thumb can be null
                .body("drinks[0].strIngredient1", notNullValue())
                .body("drinks[0].strMeasure1", notNullValue())
                .body("drinks[0].strImageSource", anyOf(equalTo(null), notNullValue())) // Image source can be null
                .body("drinks[0].strImageAttribution", anyOf(equalTo(null), notNullValue())) // Image attribution can be null
                .body("drinks[0].strCreativeCommonsConfirmed", notNullValue())
                .body("drinks[0].dateModified", notNullValue());
    }

    @Test
    public void testAlphaNumericSearch() {
        given()
                .param("i", "AbC12345")
                .when()
                .get("/search.php")
                .then()
                .statusCode(200)
                .body("ingredients", nullValue()); // Assuming the API returns an empty array for numeric searches
    }

}
