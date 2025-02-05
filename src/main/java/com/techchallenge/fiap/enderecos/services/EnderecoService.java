package com.techchallenge.fiap.enderecos.services;

import com.techchallenge.fiap.common.exception.NotFoundException;
import com.techchallenge.fiap.enderecos.controller.dto.EnderecoFilters;
import com.techchallenge.fiap.enderecos.controller.dto.EnderecoRequest;
import com.techchallenge.fiap.enderecos.controller.dto.EnderecoResponse;
import com.techchallenge.fiap.enderecos.dominio.Endereco;
import com.techchallenge.fiap.enderecos.repository.EnderecoRepository;
import com.techchallenge.fiap.enderecos.specifications.EnderecoFilterApplier;
import com.techchallenge.fiap.pessoas.services.PessoaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.springframework.beans.BeanUtils.copyProperties;

@Service
@RequiredArgsConstructor
public class EnderecoService {

    private final EnderecoRepository repository;
    private final EnderecoFilterApplier filterApplier;
    private final PessoaService pessoaService;

    @Transactional
    public EnderecoResponse save(EnderecoRequest request) {
        var endereco = Endereco.of(request);

        endereco.setPessoa(pessoaService.findPessoaById(request.getPessoaId()));
        repository.save(endereco);

        return convertToResponse(endereco);
    }

    public List<EnderecoResponse> findAll(EnderecoFilters filters) {
        return repository
                .findAll(filterApplier.apply(filters))
                .stream()
                .map(this::convertToResponse)
                .toList();
    }

    public Optional<EnderecoResponse> findById(Long id) {
        return Optional.of(convertToResponse(findEnderecoById(id)));
    }

    @Transactional
    public EnderecoResponse update(Long id, EnderecoRequest request) {
        var existingEndereco = findEnderecoById(id);

        updateEnderecoFromRequest(request, existingEndereco);
        repository.save(existingEndereco);

        return convertToResponse(existingEndereco);
    }

    @Transactional
    public String deleteById(Long id) {
        repository.deleteById(findEnderecoById(id).getId());
        return "Endereço de ID " + id + " foi deletado com sucesso.";
    }

    private Endereco findEnderecoById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Endereco não encontrado com ID: " + id));
    }

    private void updateEnderecoFromRequest(EnderecoRequest request, Endereco endereco) {
        copyProperties(request, endereco, "id");
        endereco.setPessoa(pessoaService.findPessoaById(request.getPessoaId()));
    }

    private EnderecoResponse convertToResponse(Endereco endereco) {
        return EnderecoResponse.of(endereco);
    }
}
