package com.example.apiretrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface Service {

    //retorna a lista de todos os animais
    @GET("/api/dog/get")
    Call<List<Dog>> getDog(); //retorna uma lista

    //retorna um animal
    @GET("/api/dog/getNome/{nome}")
    Call<Dog>selecionarNome(@Path("nome") String nome); //retorna um animal com seu nome

    //inclui um novo animal
    @POST("/api/dog/post")
    Call<Dog>incluirDog(@Body Dog dog);

    //alterar dados de um animal
    @PUT("/api/dog/put/{id}")
    Call<Dog>alterarDog(@Path("id") String id, @Body Dog dog);

    //deletar um animal
    @GET("/api/dog/delete/{id}")
    Call<Dog>excluirDog(@Path("id") String id);
}
