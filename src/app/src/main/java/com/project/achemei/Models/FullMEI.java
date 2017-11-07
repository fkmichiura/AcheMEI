package com.project.achemei.Models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by fabio on 27/10/2017.
 */

public class FullMEI {

    @SerializedName("id")
    private int id;
    @SerializedName("Nome")
    private String name;
    @SerializedName("CNPJ")
    private String cnpj;
    @SerializedName("Sobre")
    private String description;
    @SerializedName("Endereco")
    private String address;
    @SerializedName("Telefone")
    private String phoneNumber;
    @SerializedName("Email")
    private String email;
    @SerializedName("Status")
    private Boolean status;
    @SerializedName("ATIVIDADE_id")
    private int idActivity;
    @SerializedName("USUARIO_id")
    private int idUser;
    @SerializedName("latitude")
    private String latitude;
    @SerializedName("longitude")
    private String longitude;
    @SerializedName("logo")
    private String imageLogo;
    @SerializedName("capa")
    private String imageBackground;
    @SerializedName("galeria")
    private ArrayList<ImageGallery> imageGallery;
    @SerializedName("funcionarios")
    private ArrayList<Employee> employeeList;

    public FullMEI(int id, String name, String cnpj, String description, String address, String phoneNumber, String email, Boolean status, int idActivity, int idUser, String latitude, String longitude, String imageLogo, String imageBackground, ArrayList<ImageGallery> imageGallery, ArrayList<Employee> employeeList) {
        this.id = id;
        this.name = name;
        this.cnpj = cnpj;
        this.description = description;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.status = status;
        this.idActivity = idActivity;
        this.idUser = idUser;
        this.latitude = latitude;
        this.longitude = longitude;
        this.imageLogo = imageLogo;
        this.imageBackground = imageBackground;
        this.imageGallery = imageGallery;
        this.employeeList = employeeList;
    }

    public FullMEI() {
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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public int getIdActivity() {
        return idActivity;
    }

    public void setIdActivity(int idActivity) {
        this.idActivity = idActivity;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getImageLogo() {
        return imageLogo;
    }

    public void setImageLogo(String imageLogo) {
        this.imageLogo = imageLogo;
    }

    public String getImageBackground() {
        return imageBackground;
    }

    public void setImageBackground(String imageBackground) {
        this.imageBackground = imageBackground;
    }

    public ArrayList<ImageGallery> getImageGallery() {
        return imageGallery;
    }

    public void setImageGallery(ArrayList<ImageGallery> imageGallery) {
        this.imageGallery = imageGallery;
    }

    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(ArrayList<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
