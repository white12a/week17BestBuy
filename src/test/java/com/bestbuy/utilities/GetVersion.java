package com.bestbuy.utilities;

import com.bestbuy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetVersion extends TestBase {

    @Test
            public void getVersion() {
        Response response = given()
                .when()
                .get("/version");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
