package com.nttdata.desafiobecajava.domains;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String marca;
    private String ano;
    private String modelo;

    @OneToOne
    private Tipo tipo;
    private String placa;
    private String cor;


    public Veiculo(Long id, String marca, String ano, String modelo, Tipo tipo, String placa, String cor) {
        this.id = id;
        this.marca = marca;
        this.ano = ano;
        this.modelo = modelo;
        this.tipo = tipo;
        this.placa = placa;
        this.cor = cor;
    }

    public Veiculo() {
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

    @Override
    public String toString() {
        return "Veiculo{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", ano='" + ano + '\'' +
                ", modelo='" + modelo + '\'' +
                ", tipo=" + tipo +
                ", placa='" + placa + '\'' +
                ", cor='" + cor + '\'' +
                '}';
    }
}
