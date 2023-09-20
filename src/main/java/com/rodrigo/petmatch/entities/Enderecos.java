package com.rodrigo.petmatch.entities;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "enderecos")
public class Enderecos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String cep;
    private String logradouro;
    private int numero;
    private String bairro;
    private String cidade;
    private String uf;
    private String complemento;

    @ManyToOne
    @JoinColumn(name = "pessoas_id")
    private Pessoas pessoa;
}
