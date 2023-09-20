package com.rodrigo.petmatch.controllers;

import com.rodrigo.petmatch.dtos.UserListDto;
import com.rodrigo.petmatch.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UsersService usersService;

    @GetMapping
    public ResponseEntity<List<UserListDto>> findAll() {
        return ResponseEntity.ok().body(usersService.findAll());
    }
}
