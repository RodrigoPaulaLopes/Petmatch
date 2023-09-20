package com.rodrigo.petmatch.services;

import com.rodrigo.petmatch.dtos.ContatoListDto;
import com.rodrigo.petmatch.dtos.EnderecoListDto;
import com.rodrigo.petmatch.dtos.PessoaListDto;
import com.rodrigo.petmatch.dtos.UserListDto;
import com.rodrigo.petmatch.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UsersService {
    @Autowired
    private UserRepository repository;

    public List<UserListDto> findAll() {
        return repository.findAll().stream().map(UserListDto::new).toList();
    }
}
