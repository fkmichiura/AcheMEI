package com.project.achemei.Models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ListaAtividades {

    @SerializedName("status")
    private Boolean status;
    @SerializedName("httpCode")
    private int codigoHttp;
    @SerializedName("data")
    private ArrayList<Atividades> dados;
    @SerializedName("error_msg")
    private String errorMsg;

    public ListaAtividades() {
    }

    public ListaAtividades(Boolean status, int codigoHttp, ArrayList<Atividades> dados, String errorMsg) {
        this.status = status;
        this.codigoHttp = codigoHttp;
        this.dados = dados;
        this.errorMsg = errorMsg;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public int getCodigoHttp() {
        return codigoHttp;
    }

    public void setCodigoHttp(int codigoHttp) {
        this.codigoHttp = codigoHttp;
    }

    public ArrayList<Atividades> getDados() {
        return dados;
    }

    public void setDados(ArrayList<Atividades> dados) {
        this.dados = dados;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
