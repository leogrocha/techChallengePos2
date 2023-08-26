package com.techchallenge.fiap.pessoas.services;

import com.techchallenge.fiap.pessoas.dominio.GrupoFamiliar;
import com.techchallenge.fiap.pessoas.dominio.Parentesco;
import com.techchallenge.fiap.pessoas.dominio.Pessoa;
import com.techchallenge.fiap.pessoas.dominio.RelacaoFamiliar;
import com.techchallenge.fiap.pessoas.repository.RelacaoFamiliarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RelacaoFamiliarService {

    private final RelacaoFamiliarRepository repository;

    public void establishRelationships(Pessoa pessoa, GrupoFamiliar grupo) {
        // Aqui, você teria a lógica para identificar os relacionamentos da pessoa.
        // Como exemplo, vou assumir que estamos adicionando uma relação de pai/mãe
        // e criando automaticamente a relação de filho para a outra pessoa.
        // A lógica real dependeria dos detalhes do seu domínio.

        var parentesco = identifyParentesco(pessoa); // Ex: identifica se é PAI ou MÃE
        if (parentesco == Parentesco.PAI || parentesco == Parentesco.MAE) {
            createChildRelationship(pessoa, parentesco); // Cria relação de FILHO automaticamente
        }

        // Salva o relacionamento na base de dados
        var relacao = new RelacaoFamiliar();
        relacao.setPessoa(pessoa);
        relacao.setParentesco(parentesco);
        relacao.setGrupoFamiliar(grupo);
        repository.save(relacao);
    }

    private Parentesco identifyParentesco(Pessoa pessoa) {
        // Lógica para identificar o parentesco da pessoa
        return Parentesco.PAI; // Retorno fictício
    }

    private void createChildRelationship(Pessoa pessoa, Parentesco parentesco) {
        // Lógica para criar um relacionamento de FILHO baseado no relacionamento de PAI/MÃE
        // Aqui, você pode criar um novo objeto RelacaoFamiliar e configurá-lo para representar a relação filho.
        // Também é possível salvar no repositório, conforme necessário.
    }
}
