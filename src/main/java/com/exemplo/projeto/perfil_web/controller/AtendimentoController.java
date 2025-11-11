/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exemplo.projeto.perfil_web.controller;

import com.exemplo.projeto.perfil_web.model.Atendimento;
import com.exemplo.projeto.perfil_web.model.Cliente;
import com.exemplo.projeto.perfil_web.model.Colaborador;
import com.exemplo.projeto.perfil_web.model.Servico;
import com.exemplo.projeto.perfil_web.service.AtendimentoService;
import com.exemplo.projeto.perfil_web.service.ClienteService;
import com.exemplo.projeto.perfil_web.service.ColaboradorService;
import com.exemplo.projeto.perfil_web.service.ServicoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/atendimentos")
public class AtendimentoController {

    @Autowired
    private AtendimentoService atendimentoService;

    @Autowired
    private ServicoService servicoService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ColaboradorService colaboradorService;

    @GetMapping
    public String listarAtendimentos(Model model) {
        model.addAttribute("atendimentos", atendimentoService.listarTodos());
        model.addAttribute("novoAtendimento", new Atendimento());
        model.addAttribute("servicos", servicoService.listarTodos());
        model.addAttribute("clientes", clienteService.listarTodos());
        model.addAttribute("colaboradores", colaboradorService.listarTodos());
        return "atendimentos";
    }

    @GetMapping("/relatorios")
    public String relatorioAtendimentos(@RequestParam(required = false) Integer servicoId,
            @RequestParam(required = false) Integer clienteId,
            @RequestParam(required = false) Integer colaboradorId,
            Model model) {

        List<Atendimento> atendimentos;

        if (servicoId != null || clienteId != null || colaboradorId != null) {
            // Filtro personalizado no service
            atendimentos = atendimentoService.filtrarAtendimentos(servicoId, clienteId, colaboradorId);
        } else {
            atendimentos = atendimentoService.listarTodos();
        }

        model.addAttribute("atendimentos", atendimentos);
        model.addAttribute("servicos", servicoService.listarTodos());
        model.addAttribute("clientes", clienteService.listarTodos());
        model.addAttribute("colaboradores", colaboradorService.listarTodos());

        return "relatorios";
    }

    @PostMapping("/salvar")
    public String salvarAtendimento(@ModelAttribute("novoAtendimento") Atendimento atendimento, Model model) {
        try {
            Servico servico = servicoService.buscarPorId(atendimento.getServico().getId());
            Cliente cliente = clienteService.buscarPorId(atendimento.getCliente().getId());
            Colaborador colaborador = colaboradorService.buscarPorId(atendimento.getColaborador().getId());

            atendimento.setServico(servico);
            atendimento.setCliente(cliente);
            atendimento.setColaborador(colaborador);

            atendimentoService.salvar(atendimento);
            return "redirect:/atendimentos";
        } catch (IllegalArgumentException e) {
            model.addAttribute("erroData", e.getMessage());
            model.addAttribute("atendimentos", atendimentoService.listarTodos());
            model.addAttribute("novoAtendimento", atendimento);
            model.addAttribute("servicos", servicoService.listarTodos());
            model.addAttribute("clientes", clienteService.listarTodos());
            model.addAttribute("colaboradores", colaboradorService.listarTodos());
            return "atendimentos";
        }
    }

    @GetMapping("/editar/{id}")
    public String editarAtendimento(@PathVariable Integer id, Model model) {
        Atendimento atendimento = atendimentoService.buscarPorId(id);
        model.addAttribute("novoAtendimento", atendimento);
        model.addAttribute("atendimentos", atendimentoService.listarTodos());
        model.addAttribute("servicos", servicoService.listarTodos());
        model.addAttribute("clientes", clienteService.listarTodos());
        model.addAttribute("colaboradores", colaboradorService.listarTodos());

        return "atendimentos";
    }

    @GetMapping("/deletar/{id}")
    public String deletarAtendimento(@PathVariable Integer id) {
        atendimentoService.deletar(id);
        return "redirect:/atendimentos";
    }
}
