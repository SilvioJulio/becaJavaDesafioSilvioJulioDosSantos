package com.nttdata.desafiobecajava.dtos.responses;

public class GetTipoResponse {

    private String mensagenResponse;
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

    public String getMensagenResponse() {
        return mensagenResponse;
    }

    public void setMensagenResponse(String mensagenResponse) {
        this.mensagenResponse = mensagenResponse;
    }
}
