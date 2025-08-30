package com.api.models.test.authservice;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginAPITest {

    @Test(description = "Verify login API is working...")
    public void loginTest(){

        RequestSpecification x = given().baseUri("http://64.227.160.186:8080")
                .header("content-type", "application/json")
                .body("{\"username\": \"sagar71\",\"password\": \"sagar123@\"}");
        Response response = x.post("/api/auth/login");


        System.out.println(response.asPrettyString()+ response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(), 200);
    }


}
