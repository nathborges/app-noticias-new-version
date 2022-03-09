package com.ibm.newsapp;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Article implements Parcelable {

    @SerializedName("source")
    @Expose
    private Source source;

    @SerializedName("author")
    @Expose
    private String autor;

    @SerializedName("title")
    @Expose
    private String titulo;

    @SerializedName("description")
    @Expose
    private String descricao;

    @SerializedName("url")
    @Expose
    private String url;

    @SerializedName("urlToImage")
    @Expose
    private String urlImagem;

    @SerializedName("publishedAt")
    @Expose
    private String dataDePublicacao;

    @SerializedName("content")
    @Expose
    private String conteudo;

    public Source getSource() {
        return source;
    }

    public String getAutor() {
        return autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getUrl() {
        return url;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public String getDataDePublicacao() {
        return dataDePublicacao;
    }

    public String getConteudo() {
        return conteudo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

    }
}
