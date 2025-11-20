package com.example;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;
    private int idade;

    public Usuario() {}

    public Usuario(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    
}
