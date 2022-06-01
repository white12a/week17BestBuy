package com.bestbuy.categories;

import com.bestbuy.model.CategoriesPojo;
import com.bestbuy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PatchName extends TestBase {

    @Test
    public void UpdateName(){
        CategoriesPojo categoriesPojo= new CategoriesPojo();
        categoriesPojo.setName("avbh");

        Response response= given()
                .header("Content-Type","application/json")
                .body(categoriesPojo)
                .when()
                .patch("/categories/112");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
