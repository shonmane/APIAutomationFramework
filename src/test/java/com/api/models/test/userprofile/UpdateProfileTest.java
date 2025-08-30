package com.api.models.test.userprofile;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.models.requests.LoginRequest;
import com.api.models.requests.ProfileRequest;
import com.api.models.response.LoginResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UpdateProfileTest {

    @Test(description = "Test update profile API working....")
    public void verifyUpdateProfileTest(){
        AuthService authService = new AuthService();
        Response response = authService.login(new LoginRequest("sagar71", "sagar123@"));
        LoginResponse loginResponse = response.as(LoginResponse.class);

        UserProfileManagementService userProfileManagementService = new UserProfileManagementService();

        ProfileRequest profileRequest = new ProfileRequest.Builder()
                .username("saga123")
                .password("saga1234@")
                .firstName("Sagar")
                .lastName("Mane2")
                .email("sagarhonmane712378@gmail.com")
                .mobileNumber("9988776633")
                .build();

        response = userProfileManagementService.updateUserProfile(loginResponse.getToken(), profileRequest);

        System.out.println(response.asPrettyString());

        Assert.assertEquals(response.getStatusCode(), 200);


    }
}
