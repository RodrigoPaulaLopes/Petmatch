package com.rodrigo.petmatch.dtos;

import com.rodrigo.petmatch.entities.Pessoas;

import java.util.List;

public record PessoaListDto(int id, String nome, String sobrenome, String cpf, String rg, List<ContatoListDto> contatos, List<EnderecoListDto> enderecos) {
    public PessoaListDto(Pessoas pessoa) {
        this(pessoa.getId(), pessoa.getNome(), pessoa.getSobrenome(), pessoa.getCpf(), pessoa.getRg(), pessoa.getContatos().stream().map(ContatoListDto::new).toList(), pessoa.getEnderecos().stream().map(EnderecoListDto::new).toList());
    }
}
