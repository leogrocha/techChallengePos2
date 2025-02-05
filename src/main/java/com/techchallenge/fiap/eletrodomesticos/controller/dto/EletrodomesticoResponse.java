package com.techchallenge.fiap.eletrodomesticos.controller.dto;

import com.techchallenge.fiap.eletrodomesticos.dominio.Eletrodomestico;
import com.techchallenge.fiap.eletrodomesticos.dominio.Tensao;
import com.techchallenge.fiap.pessoas.controller.dto.PessoaResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static org.springframework.beans.BeanUtils.copyProperties;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EletrodomesticoResponse {

    private Long id;
    private String nome;
    private String modelo;
    private String marca;
    private Tensao tensao;
    private Integer potencia;
    private Double tempoDeUso;
    private PessoaResponse pessoa;

    public static EletrodomesticoResponse of(Eletrodomestico request) {
        var response = new EletrodomesticoResponse();
        response.setPessoa(PessoaResponse.of(request.getPessoa()));
        copyProperties(request, response);
        return response;
    }
}
