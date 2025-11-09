/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exemplo.projeto.perfil_web.service;

import com.exemplo.projeto.perfil_web.model.Atendimento;
import com.exemplo.projeto.perfil_web.repository.AtendimentoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AtendimentoService {

    @Autowired
    private AtendimentoRepository atendimentoRepository;

    public List<Atendimento> listarTodos() {
        return atendimentoRepository.findAll();
    }

    public Atendimento salvar(Atendimento atendimento) {
        return atendimentoRepository.save(atendimento);
    }

    public Atendimento buscarPorId(Long id) {
        return atendimentoRepository.findById(id).orElse(null);
    }
    
    public List<Atendimento> filtrarAtendimentos(Long servicoId, Long clienteId, Long colaboradorId) {
        // Caso 1: Todos os filtros estão vazios - retorna tudo
        if (servicoId == null && clienteId == null && colaboradorId == null) {
            return atendimentoRepository.findAll();
        }
        
        // Caso 2: Apenas um filtro preenchido
        if (servicoId != null && clienteId == null && colaboradorId == null) {
            return atendimentoRepository.findByServicoId(servicoId);
        }
        if (servicoId == null && clienteId != null && colaboradorId == null) {
            return atendimentoRepository.findByClienteId(clienteId);
        }
        if (servicoId == null && clienteId == null && colaboradorId != null) {
            return atendimentoRepository.findByColaboradorId(colaboradorId);
        }
        
        // Caso 3: Dois filtros preenchidos
        if (servicoId != null && clienteId != null && colaboradorId == null) {
            return atendimentoRepository.findByServicoIdAndClienteId(servicoId, clienteId);
        }
        if (servicoId != null && clienteId == null && colaboradorId != null) {
            return atendimentoRepository.findByServicoIdAndColaboradorId(servicoId, colaboradorId);
        }
        if (servicoId == null && clienteId != null && colaboradorId != null) {
            return atendimentoRepository.findByClienteIdAndColaboradorId(clienteId, colaboradorId);
        }
        
        // Caso 4: Todos os filtros preenchidos
        if (servicoId != null && clienteId != null && colaboradorId != null) {
            return atendimentoRepository.findByServicoIdAndClienteIdAndColaboradorId(servicoId, clienteId, colaboradorId);
        }
        
        // Fallback - nunca deve chegar aqui
        return atendimentoRepository.findAll();
    }

    public void deletar(Long id) {
        atendimentoRepository.deleteById(id);
    }
}

