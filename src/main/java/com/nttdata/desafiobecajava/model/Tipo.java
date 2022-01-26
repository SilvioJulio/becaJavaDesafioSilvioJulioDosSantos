package com.nttdata.desafiobecajava.model;

public class Tipo {
    private long id;
    private String tipoVeiculo;
    private String descricao;


    public Tipo(long id, String tipoVeiculo, String descricao) {
        this.id = id;
        this.tipoVeiculo = tipoVeiculo;
        this.descricao = descricao;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTipoVeiculo() {
        return tipoVeiculo;
    }

    public void setTipoVeiculo(String tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
