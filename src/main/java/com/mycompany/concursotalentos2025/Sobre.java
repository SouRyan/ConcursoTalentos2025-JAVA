/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.concursotalentos2025;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Thunder
 */
public class Sobre extends JFrame {
    
    public Sobre() {
        setTitle("Sobre o Projeto");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null);
        
        // Painel principal
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // Título
        JLabel titulo = new JLabel("Concurso de Talentos 2025", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        titulo.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
        
        // Painel para informações dos autores
        JPanel autoresPanel = new JPanel(new GridLayout(3, 1, 10, 20));
        autoresPanel.setBorder(BorderFactory.createTitledBorder("Autores do Projeto"));
        
        // Informações do primeiro autor
        JPanel autor1Panel = new JPanel(new BorderLayout(10, 10));
        autor1Panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        JLabel nomeAutor1 = new JLabel("Nome: Ryan Brayan Franca Souza");
        JLabel rgmAutor1 = new JLabel("RGM: 38085321");
        
        nomeAutor1.setFont(new Font("Arial", Font.BOLD, 14));
        rgmAutor1.setFont(new Font("Arial", Font.PLAIN, 14));
        
        autor1Panel.add(nomeAutor1, BorderLayout.NORTH);
        autor1Panel.add(rgmAutor1, BorderLayout.CENTER);
        
        // Informações do segundo autor
        JPanel autor2Panel = new JPanel(new BorderLayout(10, 10));
        autor2Panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        JLabel nomeAutor2 = new JLabel("Nome: Eduardo Vinycios Santos Mendes");
        JLabel rgmAutor2 = new JLabel("RGM: 039256961");
        
        nomeAutor2.setFont(new Font("Arial", Font.BOLD, 14));
        rgmAutor2.setFont(new Font("Arial", Font.PLAIN, 14));
        
        autor2Panel.add(nomeAutor2, BorderLayout.NORTH);
        autor2Panel.add(rgmAutor2, BorderLayout.CENTER);
        
        // Informações do terceiro autor
        JPanel autor3Panel = new JPanel(new BorderLayout(10, 10));
        autor3Panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        JLabel nomeAutor3 = new JLabel("Nome: Gustavo Silva de Oliveira");
        JLabel rgmAutor3 = new JLabel("RGM: 37742884");
        
        nomeAutor3.setFont(new Font("Arial", Font.BOLD, 14));
        rgmAutor3.setFont(new Font("Arial", Font.PLAIN, 14));
        
        autor3Panel.add(nomeAutor3, BorderLayout.NORTH);
        autor3Panel.add(rgmAutor3, BorderLayout.CENTER);
        
        autoresPanel.add(autor1Panel);
        autoresPanel.add(autor2Panel);
        autoresPanel.add(autor3Panel);
        
        // Adicionando os componentes ao painel principal
        mainPanel.add(titulo, BorderLayout.NORTH);
        mainPanel.add(autoresPanel, BorderLayout.CENTER);
        
        // Adicionando o painel principal à janela
        add(mainPanel);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Sobre().setVisible(true);
        });
    }
} 