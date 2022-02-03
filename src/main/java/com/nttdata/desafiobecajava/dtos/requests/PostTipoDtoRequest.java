package com.nttdata.desafiobecajava.dtos.requests;

public class PostTipoDtoRequest {

    private String tipoVeiculo;
    private String descricao;


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
