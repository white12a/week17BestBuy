package com.bestbuy.products;

import com.bestbuy.model.PojoClass;
import com.bestbuy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Patch extends TestBase {

    @Test
    public void patchPrice() {
        PojoClass pojoClass = new PojoClass();
        pojoClass.setPrice(10);

        Response response = given()
                .body(pojoClass)
                .header("Content-Type","application/json")
                .when()
                .patch("/products/43900");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
