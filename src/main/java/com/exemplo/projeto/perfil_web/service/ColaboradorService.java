/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exemplo.projeto.perfil_web.service;

import com.exemplo.projeto.perfil_web.model.Colaborador;
import com.exemplo.projeto.perfil_web.repository.ColaboradorRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ColaboradorService {

    @Autowired
    private ColaboradorRepository colaboradorRepository;

    public List<Colaborador> listarTodos() {
        return colaboradorRepository.findAll();
    }

    public Colaborador salvar(Colaborador colaborador) {
        return colaboradorRepository.save(colaborador);
    }

    public void deletar(Integer id) {
        colaboradorRepository.deleteById(id);
    }

    public Colaborador buscarPorId(Integer id) {
        return colaboradorRepository.findById(id).orElse(null);
    }
}
