package com.rodrigo.petmatch.entities;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "contatos")
public class Contatos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String celular_primario;
    private String celular_secundario;
    private String email;

    @ManyToOne
    @JoinColumn(name = "pessoas_id")
    private Pessoas pessoa;

}
