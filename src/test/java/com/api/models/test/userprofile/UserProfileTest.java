package com.api.models.test.userprofile;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.models.requests.LoginRequest;
import com.api.models.response.LoginResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserProfileTest {

    @Test(description = "Test user profile API working....")
    public void verifyUserProfileTest(){
        AuthService authService = new AuthService();
        Response response = authService.login(new LoginRequest("sagar71", "sagar123@"));
        LoginResponse loginResponse = response.as(LoginResponse.class);

        UserProfileManagementService userProfileManagementService = new UserProfileManagementService();

        Response response1 = userProfileManagementService.userProfile(loginResponse.getToken());

        System.out.println(response1.asPrettyString());

        Assert.assertEquals(response1.getStatusCode(), 200);
    }
}
