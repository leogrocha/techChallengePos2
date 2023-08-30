package com.techchallenge.fiap.eletrodomesticos.dominio;

import com.techchallenge.fiap.pessoas.dominio.Pessoa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "eletrodomestico_pessoa")
public class EletrodomesticoPessoa {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_eletrodomestico")
    private Eletrodomestico eletrodomestico;

    @ManyToOne
    @JoinColumn(name = "id_pessoa")
    private Pessoa pessoa;
    
}
