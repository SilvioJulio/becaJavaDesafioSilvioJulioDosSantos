package com.nttdata.desafiobecajava.dtos.responses;

import com.nttdata.desafiobecajava.domains.Tipo;

public class GetVeiculoResponse {

    private String marca;
    private String ano;
    private String modelo;
    private Tipo tipo;
    private String placa;
    private String cor;
    private String mensagenResponse;

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getMensagenResponse() {
        return mensagenResponse;
    }

    public void setMensagenResponse(String mensagenResponse) {
        this.mensagenResponse = mensagenResponse;
    }
}
