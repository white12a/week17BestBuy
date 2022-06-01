package com.bestbuy.assertion;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class Verifying {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        response = given()
                .when()
                .get("/stores")
                .then().statusCode(200);

    }

    //1. Verify the if the total is equal to 1561
    @Test
    public void Test001() {
        int totalNo=response.extract().path("total");
        System.out.println("The total is equal to :"+ totalNo);
        Assert.assertEquals(1561,totalNo);

    }
    //Verify the if the stores of limit is equal to 10
    @Test
    public void Test002(){
        int totaLimit=response.extract().path("limit");
        System.out.println("The total limit  is equal to :"+ totaLimit);
        Assert.assertEquals(10,totaLimit);
    }
    //Check the single ‘Name’ in the Array list (Inver Grove Heights)
    @Test
    public void Test003(){
       List<HashMap<String,?>> val= response.extract().path("data.findAll{it.name='Inver Grove Heights'}");
        System.out.println(val.size());
        int val1= val.size();
        Assert.assertEquals(10,val1);
    }
    //Check the multiple ‘Names’ in the ArrayList (Roseville, Burnsville, Maplewood)
    @Test
    public void verifyMultipleName(){
        List<String>nam=response.extract().path("data.name");
       // System.out.println(nam);
        List<String>names=new ArrayList<>();
        names.add("Roseville");
        names.add("Burnsville");
        names.add("Maplewood");
            if(nam.containsAll(names)){
                Assert.assertTrue(true);
            }
        }
    //Verify the storied=7 inside storeservices of the third store of second services
    @Test
    public void verify7InsideStoreServicesOfTheThirdStoreOfSecondServices(){
        int iD=response.extract().path("data[2].services[3].storeservices.serviceId");
        System.out.println(iD);
        Assert.assertEquals(7,iD);
    }
    //Check hash map values ‘createdAt’ inside storeservices map where store name = Roseville
    @Test
    public void createdAT(){
        HashMap<String,String>createdAt=response.extract().path("data.findAll{it.name='Roseville'}.storeservices.createdAt");
        System.out.println(createdAt.keySet());
        HashMap<String,String>names=new HashMap<>();
    }
    //7. Verify the state = MN of forth store
    @Test
    public void verifyTheState(){
        String nam=response.extract().path("data[3].state");
        Assert.assertEquals("MN",nam);
    }
    //Verify the store name = Rochester of 6th store
    @Test
    public void VerifyTheStoreName(){
        String storeName=response.extract().path("data[6].name");
        Assert.assertEquals("Rochester",storeName);
    }
    //Verify the storeId = 11 for the 3rd store
    @Test
    public void verifyStoreIdOf3rdStore(){
        int storeId=response.extract().path("data[3].id");
        Assert.assertEquals(11,storeId);
    }
    //Verify the serviceId = 4 for the 7th store of forth service
    @Test
    public void verifyServiceId(){
        int serviceId=response.extract().path("data[6].services[3].id");
        Assert.assertEquals(7,serviceId);
    }

    }


