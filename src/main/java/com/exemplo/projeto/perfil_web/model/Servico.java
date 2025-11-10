/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exemplo.projeto.perfil_web.model;

import jakarta.persistence.*;

@Entity
@Table(name = "servicos")
public class Servico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idServico")
    private Integer id;
    
    private String nome;
    private String valor;
    
    // Construtor vazio obrigatório pelo JPA
    public Servico(){
    }
    
    // Construtor completo
    public Servico(Integer id, String nome, String valor) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
    }
    
    // Getters e Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
    
    public String toString(){
        return nome + " ( " + valor + " ) ";
    }
}
