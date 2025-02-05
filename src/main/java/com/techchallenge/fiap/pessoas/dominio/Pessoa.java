package com.techchallenge.fiap.pessoas.dominio;

import com.techchallenge.fiap.pessoas.controller.dto.PessoaRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import static org.springframework.beans.BeanUtils.copyProperties;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pessoas")
public class Pessoa {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @Column(name = "sexo")
    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    public static Pessoa of(PessoaRequest request) {
        var response = new Pessoa();
        copyProperties(request, response);
        return response;
    }
}
