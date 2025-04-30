/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.concursotalentos2025;

/**
 *
 * @author Thunder
 */
public class Candidato extends Pessoa {
    private String pais;
    private String generoMusical;
    
    public Candidato(String nome, String idade, String sexo, String pais, String generoMusical) {
        super(nome, idade, sexo);
        this.pais = pais;
        this.generoMusical = generoMusical;
    }
    
    public String getPais() {
        return pais;
    }
    
    public void setPais(String pais) {
        this.pais = pais;
    }
    
    public String getGeneroMusical() {
        return generoMusical;
    }
    
    public void setGeneroMusical(String generoMusical) {
        this.generoMusical = generoMusical;
    }
    
    @Override
    public String toString() {
        return "Nome: " + getNome() + 
               ", Idade: " + getIdade() + 
               ", Sexo: " + getSexo() + 
               ", País: " + pais + 
               ", Gênero Musical: " + generoMusical;
    }
}
