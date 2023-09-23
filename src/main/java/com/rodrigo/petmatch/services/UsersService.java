package com.rodrigo.petmatch.services;

import com.rodrigo.petmatch.dtos.*;
import com.rodrigo.petmatch.entities.Usuarios;
import com.rodrigo.petmatch.repositories.PessoasRepository;
import com.rodrigo.petmatch.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UsersService implements UserDetailsService {
    @Autowired
    private UserRepository repository;

    @Autowired
    private PessoasRepository pessoasRepository;

    public List<UserListDto> findAll() {
        return repository.findAll().stream().map(UserListDto::new).toList();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByUsername(username);
    }

    public UserListDto create(SignUpDto signup) {

        if (this.repository.findByUsername(signup.username()) != null) throw new EntityNotFoundException("User already exists");

        var encriptedPass = new BCryptPasswordEncoder().encode(signup.password());


        var pessoas = this.pessoasRepository.getReferenceById(signup.pessoa_id());
        if (pessoas == null) throw new EntityNotFoundException("People already exists ");
        var user = new Usuarios(signup.username(), encriptedPass, signup.tipo_usuario(), pessoas);
        var newUser = this.repository.save(user);
        return new UserListDto(newUser);

    }
}
