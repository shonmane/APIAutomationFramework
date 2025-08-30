package com.api.models.test.authservice;

import com.api.base.AuthService;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ForgotPasswordTest {

    @Test(description = "Verify forgot password function")
    public void verifyForgotPassword(){

        AuthService authService = new AuthService();
        Response response = authService.forgotPassword("sagarhonmane71@gmail.com");

        System.out.println(response.asPrettyString());
        Assert.assertEquals(response.getStatusCode(), 200);
    }
}
