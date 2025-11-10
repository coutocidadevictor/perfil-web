/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exemplo.projeto.perfil_web.repository;

import com.exemplo.projeto.perfil_web.model.Atendimento;
import com.exemplo.projeto.perfil_web.model.Cliente;
import com.exemplo.projeto.perfil_web.model.Colaborador;
import com.exemplo.projeto.perfil_web.model.Servico;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AtendimentoRepository extends JpaRepository<Atendimento, Integer>{
    
    // Busca por atributos existentes
    List<Atendimento> findByCliente(Cliente cliente);
    List<Atendimento> findByColaborador(Colaborador colaborador);
    List<Atendimento> findByServico(Servico servico);
    List<Atendimento> findByDataAtendimento(String data);
    
    // Busca por id de chave estrangeira
    List<Atendimento> findByServicoId(Integer servicoId);
    List<Atendimento> findByClienteId(Integer clienteId);
    List<Atendimento> findByColaboradorId(Integer colaboradorId);
    
    // Combinações de dois filtros
    List<Atendimento> findByServicoIdAndClienteId(Integer servicoId, Integer clienteId);
    List<Atendimento> findByServicoIdAndColaboradorId(Integer servicoId, Integer colaboradorId);
    List<Atendimento> findByClienteIdAndColaboradorId(Integer clienteId, Integer colaboradorId);
    
    // Combinação de três filtros
    List<Atendimento> findByServicoIdAndClienteIdAndColaboradorId(Integer servicoId, Integer clienteId, Integer colaboradorId);
    
}
