package com.rodrigo.petmatch.dtos;

import com.rodrigo.petmatch.entities.Usuarios;

import java.util.List;

public record UserListDto(int id, String username, String password, String tipo_usuario, PessoaListDto pessoa) {

    public UserListDto(Usuarios usuarios) {
        this(usuarios.getId(), usuarios.getUsername(), usuarios.getPassword(), usuarios.getTipo_usuario(), new PessoaListDto(usuarios.getPessoa()));
    }
}
