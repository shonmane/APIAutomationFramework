package com.api.base;

import io.restassured.response.Response;

public class UserProfileManagementService extends BaseService{

    private static final String BASE_PATH = "/api/users/";

    public Response userProfile(String token){
        setAuthToken(token);
        return getRequest(BASE_PATH+"profile");
    }

    public Response updateUserProfile(String token, Object payload){
        setAuthToken(token);
        return putRequest(payload, BASE_PATH+"profile");
    }


}
