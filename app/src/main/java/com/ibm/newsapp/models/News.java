package com.ibm.newsapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class News {
    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("totalResults")
    @Expose
    private int todosOsResultados;

    @SerializedName("articles")
    @Expose
    private List<Article> article;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTodosOsResultados() {
        return todosOsResultados;
    }

    public void setTodosOsResultados(int todosOsResultados) {
        this.todosOsResultados = todosOsResultados;
    }

    public List<Article> getArticle() { return article;
    }

    public void setArticle(List<Article> article) {
        this.article = article;
    }
}
