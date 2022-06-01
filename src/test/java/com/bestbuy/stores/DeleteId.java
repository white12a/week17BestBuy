package com.bestbuy.stores;

import com.bestbuy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class DeleteId extends TestBase {

    @Test
    public void deleteId(){

        Response response= given()
                .header("Content-Type","application/json")
                .when()
                .delete("/stores/6");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
