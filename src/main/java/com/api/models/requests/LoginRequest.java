package com.api.models.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginRequest {

    @JsonProperty("username")  // not "userName"
    private String username;

    @JsonProperty("password")
    private String password;

    public LoginRequest(String username, String password){
        super();
        this.username=username;
        this.password=password;
    }

    public void setUserName(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "LoginRequest{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public static class Builder{
        private String username;
        private String password;

        public Builder username(String username){
            this.username=username;
            return this;
        }

        public Builder password(String password){
            this.password=password;
            return this;
        }

        public LoginRequest build(){
            LoginRequest loginRequest = new LoginRequest(username, password);
            return loginRequest;
        }

    }
}
