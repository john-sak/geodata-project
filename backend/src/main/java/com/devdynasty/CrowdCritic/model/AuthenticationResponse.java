package com.devdynasty.CrowdCritic.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;




public class AuthenticationResponse {


    private String accessToken;

    public AuthenticationResponse(String accessToken) {
        this.accessToken = accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAccessToken() {
        return accessToken;
    }


}
