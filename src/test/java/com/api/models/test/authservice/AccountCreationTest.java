package com.api.models.test.authservice;

import com.api.base.AuthService;
import com.api.models.requests.SignUpRequest;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class AccountCreationTest {

    @Test(description="Verify Account Creation test")
    public void creatAccountTest(){

       SignUpRequest signUpRequest = new SignUpRequest.Builder()
               .username("saga123")
               .password("saga1234@")
               .firstName("Sagar")
               .lastName("Mane")
               .email("sagarhonmane71234@gmail.com")
               .mobileNumber("9988776655")
               .build();

        AuthService authService = new AuthService();
        Response response = authService.signUp(signUpRequest);

        System.out.println(response.asPrettyString());


    }
}
