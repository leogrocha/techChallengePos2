package com.techchallenge.fiap.pessoas.dominio;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "grupo_familiares")
public class GrupoFamiliar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToMany(mappedBy = "grupoFamiliar", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RelacaoFamiliar> membros = new ArrayList<>();
}
