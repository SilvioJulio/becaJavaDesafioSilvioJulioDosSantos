package com.nttdata.desafiobecakjava.model;

import java.util.ArrayList;
import java.util.List;

public class Veiculo {
    public long id;
    public String marca;
    public String ano;
    public String modelo;
    public Tipo tipo;
    public String placa;
    public String cor;

    final List<Veiculo> carros = new ArrayList<>();

    public Veiculo(long id, String marca, String ano, String modelo, Tipo tipo, String placa, String cor) {
        this.id = id;
        this.marca = marca;
        this.ano = ano;
        this.modelo = modelo;
        this.tipo = tipo;
        this.placa = placa;
        this.cor = cor;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public Tipo getTio() {
        return tipo;
    }

    public void setTio(Tipo tio) {
        this.tipo = tio;
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

    public void adicionarCarro(Veiculo carro) {
        if (carros.contains(carro.id)) {
            System.out.println("Carro já está adicinoado ao sistema");
        } else {
            this.carros.add(new Veiculo(id, marca, ano, modelo, tipo, placa, cor));
            System.out.println("Carro adicionado ao sistema com sucesso!!!");
        }

    }

    public void pesquisarCarro() {

    }

    public void eiditarCarro() {

    }

    public void excluirCarro() {

    }

}
