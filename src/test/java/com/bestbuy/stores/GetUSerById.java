package com.bestbuy.stores;

import com.bestbuy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetUSerById extends TestBase {

    @Test
    public void getUSerByIdNumber(){
        Response response= given()
                .when()
                .get("stores/6");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
