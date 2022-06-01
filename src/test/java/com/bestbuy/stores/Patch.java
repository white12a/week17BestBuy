package com.bestbuy.stores;

import com.bestbuy.model.StoresPojo;
import com.bestbuy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Patch extends TestBase {



    @Test
    public void update(){
        StoresPojo storesPojo=new StoresPojo();
        storesPojo.setName("putin");

        Response response= given()
                .header("Content-Type","application/json")
                .when()
                .body(storesPojo)
                .patch("/stores/4");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
