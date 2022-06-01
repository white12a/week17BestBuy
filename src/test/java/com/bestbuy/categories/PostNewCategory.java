package com.bestbuy.categories;

import com.bestbuy.model.CategoriesPojo;
import com.bestbuy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PostNewCategory extends TestBase {

    @Test
    public void postNewCategories(){

        CategoriesPojo categoriesPojo=new CategoriesPojo();
        categoriesPojo.setName("bhav");
        categoriesPojo.setId("112");


        Response response = given()
                .header("Content-Type","application/json")
                .body(categoriesPojo)
                .when()
                .post("/categories");
        response.then().statusCode(201);
        response.prettyPrint();
    }
}
