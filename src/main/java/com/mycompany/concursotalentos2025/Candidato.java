/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.concursotalentos2025;

/**
 * Classe derivada
 */
public class Candidato extends Pessoa {
    // Dados específicos
    private String pais;
    private String generoMusical;
    
    // Construtor derivado
    public Candidato(String nome, String idade, String sexo, String pais, String generoMusical) {
        super(nome, idade, sexo);
        this.pais = pais;
        this.generoMusical = generoMusical;
    }
    
    // Getters específicos
    public String getPais() {
        return pais;
    }
    
    public String getGeneroMusical() {
        return generoMusical;
    }
    
    // Setters específicos
    public void setPais(String pais) {
        this.pais = pais;
    }
    
    public void setGeneroMusical(String generoMusical) {
        this.generoMusical = generoMusical;
    }
    
    @Override
    public String toString() {
        return super.toString() + "\n" +
               "País: " + pais + "\n" +
               "Gênero Musical: " + generoMusical;
    }
}
