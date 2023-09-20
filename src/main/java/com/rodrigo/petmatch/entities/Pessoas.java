package com.rodrigo.petmatch.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "pessoas")
public class Pessoas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String sobrenome;
    private LocalDate data_nascimento;
    private String cpf;
    private String rg;

    @OneToMany(mappedBy = "pessoa")
    private List<Usuarios> usuarios = new ArrayList<>();

    @OneToMany(mappedBy = "pessoa")
    private List<Contatos> contatos = new ArrayList<>();

    @OneToMany(mappedBy = "pessoa")
    private List<Enderecos> enderecos = new ArrayList<>();
}
