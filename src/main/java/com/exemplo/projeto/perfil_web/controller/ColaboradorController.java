/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exemplo.projeto.perfil_web.controller;

import com.exemplo.projeto.perfil_web.model.Cliente;
import com.exemplo.projeto.perfil_web.model.Colaborador;
import com.exemplo.projeto.perfil_web.service.ColaboradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/colaboradores")
public class ColaboradorController {
    
    @Autowired
    private ColaboradorService colaboradorService;

    @GetMapping
    public String listarColaboradores(Model model) {
        model.addAttribute("colaboradores", colaboradorService.listarTodos());
        model.addAttribute("novoColaborador", new Colaborador());
        return "colaboradores";
    }

    @PostMapping("/salvar")
    public String salvarColaborador(@ModelAttribute("novoColaborador") Colaborador colaborador) {
        colaboradorService.salvar(colaborador);
        return "redirect:/colaboradores";
    }

    @GetMapping("/editar/{id}")
    public String editarColaborador(@PathVariable Long id, Model model) {
        Colaborador colaborador = colaboradorService.buscarPorId(id);
        model.addAttribute("novoColaborador", colaborador);
        model.addAttribute("colaborador", colaboradorService.listarTodos());
        return "colaboradores";
    }

    @GetMapping("/deletar/{id}")
    public String deletarColaborador(@PathVariable Long id) {
        colaboradorService.deletar(id);
        return "redirect:/colaboradores";
    }
}