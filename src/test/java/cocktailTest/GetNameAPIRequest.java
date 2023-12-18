package cocktailTest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import io.restassured.response.Response;


class cocktail {
    @Test
    public void getAllCocktail(){

        RestAssured
                .given()
                .contentType(ContentType.JSON)
                .baseUri("http://thecocktaildb.com/api/json/v1/1/search.php?s=margarita")
                .when()
                .get()
                .then()
                .assertThat()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .extract()
                .response();
        Response response = RestAssured.get("http://thecocktaildb.com/api/json/v1/1/search.php?s=margarita");

        Assert.assertTrue(response.getBody().asString().contains("drinks"));

    }
}

