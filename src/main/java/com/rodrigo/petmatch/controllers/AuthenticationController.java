package com.rodrigo.petmatch.controllers;

import com.rodrigo.petmatch.dtos.SignUpDto;
import com.rodrigo.petmatch.dtos.SigninDTO;
import com.rodrigo.petmatch.dtos.TokenDto;
import com.rodrigo.petmatch.dtos.UserListDto;
import com.rodrigo.petmatch.entities.Usuarios;
import com.rodrigo.petmatch.repositories.PessoasRepository;
import com.rodrigo.petmatch.repositories.UserRepository;
import com.rodrigo.petmatch.services.TokenService;
import com.rodrigo.petmatch.services.UsersService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthenticationController {


    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    public TokenService tokenService;

    @Autowired
    private UsersService usersService;


    @PostMapping("/signin")
    public ResponseEntity signin(@RequestBody SigninDTO signin) {

        var usernameAndPass = new UsernamePasswordAuthenticationToken(signin.username(), signin.password());
        var auth = this.authenticationManager.authenticate(usernameAndPass);

        var token = tokenService.encode((Usuarios) auth.getPrincipal());


        return ResponseEntity.ok().body(new TokenDto(token));

    }

    @PostMapping("/signup")
    public ResponseEntity signup(@RequestBody SignUpDto signup) throws Exception {

        var user = this.usersService.create(signup);

        return ResponseEntity.ok().body(user);

    }

}
