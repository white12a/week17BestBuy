package com.bestbuy.products;

import com.bestbuy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Delete extends TestBase {
    @Test
    public void deleteId() {
        Post post=new Post();

        Response response = given()
                .when()
                .delete("/products/43900");
        response.then().statusCode(200);
        response.prettyPrint();
    }

}


