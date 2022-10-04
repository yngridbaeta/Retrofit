package com.example.apiretrofit;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Dog implements Serializable {

    @SerializedName("id")
    private String id;
    @SerializedName("nome")
    private String nome;
    @SerializedName("raca")
    private String raca;
    @SerializedName("image")
    private String image;

    public Dog(String id, String nome, String raca, String image){
        this.id = id;
        this.nome = nome;
        this.raca = raca;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


}
