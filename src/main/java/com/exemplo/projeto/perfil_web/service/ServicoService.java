/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exemplo.projeto.perfil_web.service;


import com.exemplo.projeto.perfil_web.model.Servico;
import com.exemplo.projeto.perfil_web.repository.ServicoRepository;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository servicoRepository;

    public List<Servico> listarTodos() {
        return servicoRepository.findAll();
    }

    public void salvar(Servico servico) {
        // validação de valor
        validarServico(servico);
        servicoRepository.save(servico);
    }

    private void validarServico(Servico servico) {
        if (servico.getValor() == null || servico.getValor().trim().isEmpty()) {
            throw new IllegalArgumentException("O valor do serviço deve ser informado.");
        }

        try {
            BigDecimal valor = new BigDecimal(servico.getValor().replace(",", "."));
            if (valor.compareTo(BigDecimal.ZERO) <= 0) {
                throw new IllegalArgumentException("O valor do serviço deve ser positivo.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("O valor informado não é numérico válido.");
        }

        // Validação de nome duplicado
        Optional<Servico> existente = servicoRepository.findByNomeIgnoreCase(servico.getNome());
        if (existente.isPresent() && !existente.get().getId().equals(servico.getId())) {
            throw new IllegalArgumentException("Já existe um serviço com este nome.");
        }
    }

    public Servico buscarPorId(Integer id) {
        return servicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Serviço não encontrado"));
    }

    public void deletar(Integer id) {
        servicoRepository.deleteById(id);
    }
}