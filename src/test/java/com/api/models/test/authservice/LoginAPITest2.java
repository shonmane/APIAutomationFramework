package com.api.models.test.authservice;

import com.api.base.AuthService;
import com.api.models.requests.LoginRequest;
import com.api.models.response.LoginResponse;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
@Listeners(com.api.listeners.TestListners.class)
public class LoginAPITest2 {

    @Test(description = "Verify login API is working...")
    public void loginTest2(){

        //LoginRequest loginRequest = new LoginRequest("sagar71", "sagar123@");
        LoginRequest loginRequest = new LoginRequest.Builder()
                .username("sagar71")
                .password("sagar123@")
                .build();
        AuthService authService = new AuthService();
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        Response response = authService.login(loginRequest);
        System.out.println(response.asPrettyString()+ " Status Code: "+response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(), 200);

        LoginResponse loginResponse = response.as(LoginResponse.class);
        System.out.println(loginResponse.getUsername());
        System.out.println(loginResponse.getEmail());
        System.out.println(loginResponse.getRoles());
        System.out.println(loginResponse.getType());

        Assert.assertEquals(loginResponse.getEmail(), "sagarhonmane71@gmail.com");

    }


}
