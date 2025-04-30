/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.concursotalentos2025;

/**
 * Classe base
 */
public class Pessoa {
    // Dados básicos
    private String nome;
    private String idade;
    private String sexo;
    
    // Construtor base
    public Pessoa(String nome, String idade, String sexo) {
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
    }
    
    // Getters básicos
    public String getNome() {
        return nome;
    }
    
    public String getIdade() {
        return idade;
    }
    
    public String getSexo() {
        return sexo;
    }
    
    // Setters básicos
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setIdade(String idade) {
        this.idade = idade;
    }
    
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    @Override
    public String toString() {
        return "Nome: " + nome + "\n" +
               "Idade: " + idade + "\n" +
               "Sexo: " + sexo;
    }
}
