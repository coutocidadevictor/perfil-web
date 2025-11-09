/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exemplo.projeto.perfil_web.controller;

import com.exemplo.projeto.perfil_web.model.Servico;
import com.exemplo.projeto.perfil_web.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/servicos")
public class ServicoController {

    @Autowired
    private ServicoService servicoService;

    @GetMapping
    public String listarServicos(Model model) {
        model.addAttribute("servicos", servicoService.listarTodos());
        model.addAttribute("novoServico", new Servico());
        return "servicos";
    }

    @PostMapping("/salvar")
    public String salvarServico(@ModelAttribute("novoServico") Servico servico) {
        servicoService.salvar(servico);
        return "redirect:/servicos";
    }

    @GetMapping("/editar/{id}")
    public String editarServico(@PathVariable Long id, Model model) {
        Servico servico = servicoService.buscarPorId(id);
        model.addAttribute("novoServico", servico);
        model.addAttribute("servicos", servicoService.listarTodos());
        return "servicos";
    }

    @GetMapping("/deletar/{id}")
    public String deletarServico(@PathVariable Long id) {
        servicoService.deletar(id);
        return "redirect:/servicos";
    }
}