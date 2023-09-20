package com.rodrigo.petmatch.dtos;

import com.rodrigo.petmatch.entities.Enderecos;

public record EnderecoListDto (int id, String cep, String logradouro, int numero, String bairro, String cidade, String uf, String complemento){

    public EnderecoListDto (Enderecos enderecos){
        this(enderecos.getId(), enderecos.getCep(), enderecos.getLogradouro(), enderecos.getNumero(), enderecos.getBairro(), enderecos.getCidade(), enderecos.getUf(), enderecos.getComplemento());
    }
}
