package com.project.achemei.Models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by fabio on 26/10/2017.
 */

public class MEIS {

    @SerializedName("Distancia")
    private String distancia;
    @SerializedName("Nome")
    private String nome;
    @SerializedName("id")
    private int id;
    @SerializedName("logo")
    private String logo;

    public MEIS(String distancia, String nome, int id, String logo) {
        this.distancia = distancia;
        this.nome = nome;
        this.id = id;
        this.logo = logo;
    }

    public MEIS() {
    }

    public String getDistancia() {
        return distancia;
    }

    public void setDistancia(String distancia) {
        this.distancia = distancia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
