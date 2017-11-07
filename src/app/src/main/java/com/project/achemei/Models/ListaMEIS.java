package com.project.achemei.Models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by fabio on 26/10/2017.
 */

public class ListaMEIS {

    @SerializedName("status")
    private Boolean status;
    @SerializedName("httpCode")
    private int httpCode;
    @SerializedName("data")
    private ArrayList<MEIS> meis;
    @SerializedName("error_msg")
    private String errorMsg;

    public ListaMEIS(Boolean status, int httpCode, ArrayList<MEIS> meis, String errorMsg) {
        this.status = status;
        this.httpCode = httpCode;
        this.meis = meis;
        this.errorMsg = errorMsg;
    }

    public ListaMEIS() {
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public int getHttpCode() {
        return httpCode;
    }

    public void setHttpCode(int httpCode) {
        this.httpCode = httpCode;
    }

    public ArrayList<MEIS> getMeis() {
        return meis;
    }

    public void setMeis(ArrayList<MEIS> meis) {
        this.meis = meis;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
