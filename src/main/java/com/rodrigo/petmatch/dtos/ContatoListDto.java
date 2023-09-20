package com.rodrigo.petmatch.dtos;

import com.rodrigo.petmatch.entities.Contatos;

public record ContatoListDto(int id, String celular_primario, String celular_secundario, String email) {

    public ContatoListDto(Contatos contatos){
        this(contatos.getId(), contatos.getCelular_primario(), contatos.getCelular_secundario(), contatos.getEmail());
    }
}
