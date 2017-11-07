package com.project.achemei.Models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by fabio on 27/10/2017.
 */

public class Employee {

    @SerializedName("id")
    private int id;
    @SerializedName("Nome")
    private String name;
    @SerializedName("RG")
    private String rg;
    @SerializedName("Especialidade")
    private String specialty;
    @SerializedName("Foto")
    private String pictureLink;

    public Employee(int id, String name, String rg, String specialty, String pictureLink) {
        this.id = id;
        this.name = name;
        this.rg = rg;
        this.specialty = specialty;
        this.pictureLink = pictureLink;
    }

    public Employee() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getPictureLink() {
        return pictureLink;
    }

    public void setPictureLink(String pictureLink) {
        this.pictureLink = pictureLink;
    }
}
