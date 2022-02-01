package com.nttdata.desafiobecajava.dtos;

import com.nttdata.desafiobecajava.domains.Tipo;
import com.nttdata.desafiobecajava.domains.Veiculo;

import java.io.Serializable;


public class VeiculoDTO implements Serializable {

    private static final long serialVersionUID=1l;

    private Long id;
    private String marca;
    private String ano;
    private String modelo;
    private Tipo tipo;
    private String placa;
    private String cor;

    public VeiculoDTO() {

    }

    public VeiculoDTO(Veiculo veiculo) {

        this.id = veiculo.getId();
        this.marca = veiculo.getMarca();
        this.ano = veiculo.getAno();
        this.modelo = veiculo.getModelo();
        this.tipo = veiculo.getTipo();
        this.placa = veiculo.getPlaca();
        this.cor = veiculo.getCor();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
}
