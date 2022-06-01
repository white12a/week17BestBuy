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

public class Extraction {
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
    //Extract the limit
    @Test
    public void limit(){
        int lim=response.extract().path("limit");
        System.out.println(lim);
        Assert.assertEquals(10,lim);
    }
    //Extract the total
    @Test
    public void total(){
        int tot=response.extract().path("total");
        System.out.println(tot);
        Assert.assertEquals(1561,tot);
    }
    //Extract the name of 5th store
    @Test
    public void name(){
        String nam =response.extract().path("data[4].name");
        System.out.println(nam);
        Assert.assertEquals("St Cloud",nam);
    }
    //Extract the names of all the store
    @Test
    public void allStoreName(){
        List<String>nam= response.extract().path("data.name");
        System.out.println(nam);
    }
    //Extract the storeId of all the store
    @Test
    public void allStoreId(){
        List<Integer>id=response.extract().path("data.id");
        System.out.println(id);
    }
    //Print the size of the data list
    @Test
    public void PrintTheSizeOfTheDataList(){
        List<Integer> e = response.extract().path("data");
        int dataSize=e.size();
        System.out.println(dataSize);
    }
    //Get all the value of the store where store name = St Cloud
    @Test
    public void allValueNameWhereStoreNameIsStCloud(){
        List<HashMap<String,?>> allData=response.extract().path("data.findAll{it.name=='St Cloud'}");
        System.out.println(allData);
    }
    //Get the address of the store where store name = Rochester
    @Test
    public void address(){
        List<String> address = response.extract().path("data.findAll{it.name=='Rochester'}.address");
        System.out.println("8) Address of Rochester : " + address);
    }
    //Get all the services of 8th store
    @Test
    public void services(){
        List<HashMap<String,?>>names=response.extract().path("data[8].services");
        for(HashMap<String,?> nam:names){
            System.out.println(nam.entrySet());
        }
    }
    //Get storeservices of the store where service name = Windows Store
    @Test
    public void storeServices(){
       List<List<HashMap<String,?>>> nam= response.extract().path("data.find{it.services}.services.findAll{it.name='Windows Store'}.storeservices");
        System.out.println(nam);
        }
    //Get all the storeId of all the store
    @Test
    public void getStoreIdOfAllTheStore(){
        List<Integer> allStoreId = response.extract().path("data.services.storeservices.storeId");
        System.out.println(allStoreId);
    }
    //Get id of all the store
    @Test
    public void idOfAllStore(){
    ArrayList<Integer> id=response.extract().path("data.id");
        System.out.println(id);
    }
    //Find the store names Where state = ND
    @Test
    public void storeName(){
        List<String>nam=response.extract().path("data.findAll{it.state=='ND'}.name");
        System.out.println(nam);
    }
    // Find the Total number of services for the store where store name = Rochester
       @Test
        public void totalServices() {
            List<Integer> services = response.extract().path("data.find{it.name=='Rochester'}.services");
            System.out.println(services.size());
        }
     // Find the createdAt for all services whose name = “Windows Store”
       @Test
        public void createdAt() {
            String createdat = response.extract().path("data.find{it.service.name=='Windows Store'}.createdAt");
            System.out.println( createdat);
        }
    //Find the zip of all the store
    @Test
    public void findAllZip() {
        List<Integer> zip = response.extract().path("data.findAll{it}.zip");
        System.out.println(zip);
    }
   // Find the zip of store name = Roseville
    @Test
    public void findZipFromStoreName() {
        String zipOfStore = response.extract().path("data.find{it.name=='Roseville'}.zip");
        System.out.println( zipOfStore);
    }
   // Find the storeservices details of the service name = Magnolia Home Theater
    @Test
    public void findStoreServicesOfStore() {
        List<HashMap<String,?>> storeServiceDetail = response.extract().path("data.findAll{it.services=='Magnolia Home Theater'}.storeservices");
        System.out.println( storeServiceDetail);
    }
   // Find the lat of all the store
    @Test
    public void findLat(){
        List<Float> lat = response.extract().path("data.findAll{it}.lat") ;
        System.out.println( lat);
    }







    }

