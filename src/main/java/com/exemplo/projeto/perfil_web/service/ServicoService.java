/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exemplo.projeto.perfil_web.service;


import com.exemplo.projeto.perfil_web.model.Servico;
import com.exemplo.projeto.perfil_web.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository servicoRepository;

    public List<Servico> listarTodos() {
        return servicoRepository.findAll();
    }

    public void salvar(Servico servico) {
        servicoRepository.save(servico);
    }

    public Servico buscarPorId(Integer id) {
        return servicoRepository.findById(id).orElseThrow(() -> new RuntimeException("Serviço não encontrado"));
    }

    public void deletar(Integer id) {
        servicoRepository.deleteById(id);
    }
}