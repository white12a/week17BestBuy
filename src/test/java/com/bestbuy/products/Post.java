package com.bestbuy.products;

import com.bestbuy.model.PojoClass;
import com.bestbuy.testbase.TestBase;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Post extends TestBase {
static ValidatableResponse response;
int num;

    @Test
    public void createPost(){
        PojoClass pojoClass=new PojoClass();
        pojoClass.setName("Q7");
        pojoClass.setType("car");
        pojoClass.setPrice(4000);
        pojoClass.setShipping(500);
        pojoClass.setUpc("By air");
        pojoClass.setDescription("sports car");
        pojoClass.setManufacturer("noida");
        pojoClass.setModel("Q7D");
        pojoClass.setUrl("www.Q7.com");
        pojoClass.setImage("img");

        Response response= given()
                .header("Content-Type","application/json")
                .body(pojoClass)
                .when()
                .post("/products");
        response.then().statusCode(201);
        response.prettyPrint();


         /*response=given()
                .header("Content-Type","application/json")
                .body(pojoClass)
                .when()
                .post("/products")
        .then().statusCode(201);
         response.log().all();
         num=response.extract().path("id");
        System.out.println(num);
*/

    }



}
