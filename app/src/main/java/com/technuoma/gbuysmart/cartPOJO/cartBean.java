package com.technuoma.gbuysmart.cartPOJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class cartBean {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("total")
    @Expose
    private String total;
    @SerializedName("items")
    @Expose
    private String items;
    @SerializedName("totalgstamount")
    @Expose
    private String totalgstamount;
    @SerializedName("totalgreenamount")
    @Expose
    private String totalgreenamount;
    @SerializedName("totalgoldamount")
    @Expose
    private String totalgoldamount;
    @SerializedName("totalplatinumamount")
    @Expose
    private String totalplatinumamount;
    @SerializedName("data")
    @Expose
    private List<Datum> data = null;

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

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public String getTotalgstamount() {
        return totalgstamount;
    }

    public void setTotalgstamount(String totalgstamount) {
        this.totalgstamount = totalgstamount;
    }

    public String getTotalgreenamount() {
        return totalgreenamount;
    }

    public void setTotalgreenamount(String totalgreenamount) {
        this.totalgreenamount = totalgreenamount;
    }

    public String getTotalgoldamount() {
        return totalgoldamount;
    }

    public void setTotalgoldamount(String totalgoldamount) {
        this.totalgoldamount = totalgoldamount;
    }

    public String getTotalplatinumamount() {
        return totalplatinumamount;
    }

    public void setTotalplatinumamount(String totalplatinumamount) {
        this.totalplatinumamount = totalplatinumamount;
    }

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }
}
