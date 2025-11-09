/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exemplo.projeto.perfil_web.model;

import jakarta.persistence.*;

@Entity
@Table(name = "atendimentos")
public class Atendimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idClientes")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "idServico")
    private Servico servico;

    @ManyToOne
    @JoinColumn(name = "idColaboradores")
    private Colaborador colaborador;

    private String dataAtendimento;

    // Construtor vazio obrigatório pelo JPA
    public Atendimento() {
    }

    // Construtor completo
    public Atendimento(Long id, Cliente cliente, Servico servico, Colaborador colaborador, String dataAtendimento) {
        this.id = id;
        this.cliente = cliente;
        this.servico = servico;
        this.colaborador = colaborador;
        this.dataAtendimento = dataAtendimento;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public Colaborador getColaborador() {
        return colaborador;
    }

    public void setColaborador(Colaborador colaborador) {
        this.colaborador = colaborador;
    }

    public String getDataAtendimento() {
        return dataAtendimento;
    }

    public void setDataAtendimento(String dataAtendimento) {
        this.dataAtendimento = dataAtendimento;
    }
    
}
