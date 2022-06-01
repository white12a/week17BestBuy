package com.bestbuy.stores;

import com.bestbuy.model.StoresPojo;
import com.bestbuy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class Post extends TestBase {

    @Test
    public void postUser(){

        List<String>services1=new ArrayList<>();
        services1.add("clean");
        services1.add("polish");

        StoresPojo storesPojo=new StoresPojo();
        storesPojo.setName("mit");
        storesPojo.setType("gay");
        storesPojo.setAddress("soho");
        storesPojo.setAddress2("central");
        storesPojo.setCity("london");
        storesPojo.setState("middlesex");
        storesPojo.setZip("23456");
        storesPojo.setLat((int) 68.564836);
        storesPojo.setLng((int) -67.453627);
        storesPojo.setHours("Mon: 10-7");
        storesPojo.setServices(services1);

        Response response=given()
                .header("Content-Type","application/json")
                .body(storesPojo)
                .when()
                .post("/stores");
        response.then().statusCode(201);
        response.prettyPrint();

    }
}
