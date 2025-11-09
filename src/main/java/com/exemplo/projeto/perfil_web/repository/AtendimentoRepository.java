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

public interface AtendimentoRepository extends JpaRepository<Atendimento, Long>{
    
    // Busca por atributos existentes
    List<Atendimento> findByCliente(Cliente cliente);
    List<Atendimento> findByColaborador(Colaborador colaborador);
    List<Atendimento> findByServico(Servico servico);
    List<Atendimento> findByDataAtendimento(String data);
    
    // Busca por id de chave estrangeira
    List<Atendimento> findByServicoId(Long servicoId);
    List<Atendimento> findByClienteId(Long clienteId);
    List<Atendimento> findByColaboradorId(Long colaboradorId);
    
    // Combinações de dois filtros
    List<Atendimento> findByServicoIdAndClienteId(Long servicoId, Long clienteId);
    List<Atendimento> findByServicoIdAndColaboradorId(Long servicoId, Long colaboradorId);
    List<Atendimento> findByClienteIdAndColaboradorId(Long clienteId, Long colaboradorId);
    
    // Combinação de três filtros
    List<Atendimento> findByServicoIdAndClienteIdAndColaboradorId(Long servicoId, Long clienteId, Long colaboradorId);
    
}
