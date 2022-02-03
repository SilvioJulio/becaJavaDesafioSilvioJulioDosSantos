package com.nttdata.desafiobecajava.dtos.responses;

import com.nttdata.desafiobecajava.domains.Tipo;

public class PostVeiculoDtoResponse {
    private Long codigo;
    private String mensagem;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
