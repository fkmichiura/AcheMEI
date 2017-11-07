package com.project.achemei.Activities.Controllers;

import com.project.achemei.Models.Employee;
import com.project.achemei.Models.ListaAtividades;
import com.project.achemei.Models.ListaFullMEI;
import com.project.achemei.Models.ListaMEIS;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface APIService {

    String BASE_URL = "http://beta.fivesdevelopment.com/achemei/";

    //--------------- MainActivity - Listagem das Atividades ---------------//
    @FormUrlEncoded
    @POST("index.php/atividade/getAtividade")
    Call<ListaAtividades> getAtividade(
            @Field("inicio") String init,
            @Field("nome") String name,
            @Field("maximo") String max,
            @Field("dispositivo") String device,
            @Field("latitude") String latitude,
            @Field("longitude") String longitude
    );

    //--------------- CompanyListActivity - Listagem dos dados dos MEIS ---------------//
    @FormUrlEncoded
    @POST("index.php/mei/getMeiAtividade/")
    Call<ListaMEIS> getMEIS(
            @Field("inicio") String init,
            @Field("nome") String name,
            @Field("maximo") String max,
            @Field("dispositivo") String device,
            @Field("latitude") String latitude,
            @Field("longitude") String longitude,
            @Field("idAtividade") String id
    );

    //--------------- TeamFragment - Listagem dos dados completo dos MEIS ---------------//
    @FormUrlEncoded
    @POST("index.php/mei/getMei/")
    Call<ListaFullMEI> getFullMEIS(
            @Field("idMei") String id,
            @Field("dispositivo") String device,
            @Field("latitude") String latitude,
            @Field("longitude") String longitude
    );

    //--------------- LoginActivity - Validação de Login ---------------//
    @FormUrlEncoded
    @POST("index.php/mei/validarLoginMei/")
    Call<ListaFullMEI> loginValidation(
            @Field("dispositivo") String device,
            @Field("latitude") String latitude,
            @Field("longitude") String longitude,
            @Field("login") String login,
            @Field("senha") String password
    );

    //--------------- RegisterActivity - Cadastro de MEI ---------------//
    @FormUrlEncoded
    @POST("index.php/mei/setMei/")
    Call<ListaFullMEI> registerMEI(
            @Field("nome") String name,
            @Field("cnpj") String cnpj,
            @Field("idAtividade") String id,
            @Field("endereco") String address,
            @Field("telefone") String phone,
            @Field("email") String email,
            @Field("senha") String pass,
            @Field("latitude") String latitude,
            @Field("longitude") String longitude
    );

    //--------------- TeamFragment - Cadastro de Funcionário ---------------//
    @FormUrlEncoded
    @POST("")
    Call<Employee> registerEmployee(
            @Field("nome") String name,
            @Field("especialidade") String function,
            @Field("rg") String rg,
            @Field("idMei") String idMei,
            @Field("id") String idEmployee,
            @Field("file") String imagem
    );

    //--------------- TeamFragment - Edição de dados do Funcionário ---------------//
    @FormUrlEncoded
    @POST("")
    Call<Employee> editEmployee(
            @Field("nome") String name,
            @Field("especialidade") String function,
            @Field("rg") String rg,
            @Field("idMei") String idMei,
            @Field("id") String idEmployee,
            @Field("file") String imagem
    );
}
