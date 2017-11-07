package com.project.achemei.Models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by fabio on 27/10/2017.
 */

public class ListaFullMEI {

    @SerializedName("status")
    private Boolean status;
    @SerializedName("httpCode")
    private int httpCode;
    @SerializedName("data")
    private ArrayList<FullMEI> listaFullMEIS;
    @SerializedName("error_msg")
    private String errorMsg;

    public ListaFullMEI(Boolean status, int httpCode, ArrayList<FullMEI> listaFullMEIS, String errorMsg) {
        this.status = status;
        this.httpCode = httpCode;
        this.listaFullMEIS = listaFullMEIS;
        this.errorMsg = errorMsg;
    }

    public ListaFullMEI() {
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

    public ArrayList<FullMEI> getListaFullMEIS() {
        return listaFullMEIS;
    }

    public void setListaFullMEIS(ArrayList<FullMEI> listaFullMEIS) {
        this.listaFullMEIS = listaFullMEIS;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
