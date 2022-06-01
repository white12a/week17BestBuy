package com.bestbuy.products;

import com.bestbuy.testbase.TestBase;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get extends TestBase {

    @Test
    public void getUser(){

        Response response=given()
                .when()
                .get("/products");
        response.then().statusCode(200);
        response.prettyPrint();
    }
    @Test
    public void getUser1(){
        ValidatableResponse validatableResponse=given()
                .when()
                .get()
                .then();
        validatableResponse.statusCode(200);


    }


}
