package com.technuoma.gbuysmart;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class getMembershipBean {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("current_membership")
    @Expose
    private String currentMembership;
    @SerializedName("expires_on")
    @Expose
    private String expiresOn;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCurrentMembership() {
        return currentMembership;
    }

    public void setCurrentMembership(String currentMembership) {
        this.currentMembership = currentMembership;
    }

    public String getExpiresOn() {
        return expiresOn;
    }

    public void setExpiresOn(String expiresOn) {
        this.expiresOn = expiresOn;
    }

}
