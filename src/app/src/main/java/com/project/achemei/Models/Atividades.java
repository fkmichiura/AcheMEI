package com.project.achemei.Models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by fabio on 26/10/2017.
 */

public class Atividades {

    @SerializedName("id")
    private int id;
    @SerializedName("Nome")
    private String nome;
    @SerializedName("Status")
    private String status;

    public Atividades(int id, String nome, String status) {
        this.id = id;
        this.nome = nome;
        this.status = status;
    }

    public Atividades(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
