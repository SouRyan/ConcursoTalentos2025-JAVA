/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.concursotalentos2025;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

/**
 *
 * @author Thunder
 */
public class ConcursoTalentos2025 extends JFrame {
    
    // Estruturas de dados para armazenar os candidatos
    private Stack<Candidato> pilhaMulheres = new Stack<>();
    private Queue<Candidato> filaHomens = new LinkedList<>();
    private List<Candidato> todosCandidatos = new ArrayList<>();
    
    // Componentes da interface
    private JTextField txtNome, txtIdade, txtSexo, txtPais, txtGeneroMusical, txtGeneroFiltro;
    private JTextArea txtAreaResultado;
    private JButton btnCadastrar, btnListar, btnMediaGeral, btnCandidataMaisJovem;
    private JButton btnMostrarPilha, btnMostrarFila, btnRetirarPilha, btnRetirarFila;
    private JButton btnFiltrarGenero, btnAutores;
    
    public ConcursoTalentos2025() {
        setTitle("Concurso de Talentos 2025");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 700);
        setLocationRelativeTo(null);
        
        // Estruturas de dados para armazenar os candidatos
        pilhaMulheres = new Stack<>();
        filaHomens = new LinkedList<>();
        todosCandidatos = new ArrayList<>();
        
        // Adicionando candidatos de exemplo
        Candidato c1 = new Candidato("Anne Beckman", "22", "F", "Austrália", "pop");
        Candidato c2 = new Candidato("Luis Peres", "23", "M", "Brasil", "pop");
        Candidato c3 = new Candidato("Peter Jones", "18", "M", "USA", "rock");
        Candidato c4 = new Candidato("Santiago Lopez", "19", "M", "Espanha", "rock");
        Candidato c5 = new Candidato("Caio", "26", "M", "Brasil", "samba");
        Candidato c6 = new Candidato("Luoise Cherac", "18", "F", "França", "pop");
        Candidato c7 = new Candidato("Leonor Perez", "32", "F", "México", "salsa");
        
        // Adicionando à estrutura apropriada
        pilhaMulheres.push(c1);
        filaHomens.offer(c2);
        filaHomens.offer(c3);
        filaHomens.offer(c4);
        filaHomens.offer(c5);
        pilhaMulheres.push(c6);
        pilhaMulheres.push(c7);
        
        // Adicionando à lista de todos os candidatos
        todosCandidatos.add(c1);
        todosCandidatos.add(c2);
        todosCandidatos.add(c3);
        todosCandidatos.add(c4);
        todosCandidatos.add(c5);
        todosCandidatos.add(c6);
        todosCandidatos.add(c7);
        
        // Painel principal
        JPanel mainPanel = new JPanel(new BorderLayout());
        
        // Painel de entrada de dados
        JPanel inputPanel = new JPanel(new GridLayout(5, 2, 5, 5));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Dados do Candidato"));
        
        inputPanel.add(new JLabel("Nome:"));
        txtNome = new JTextField();
        inputPanel.add(txtNome);
        
        inputPanel.add(new JLabel("Idade:"));
        txtIdade = new JTextField();
        inputPanel.add(txtIdade);
        
        inputPanel.add(new JLabel("Sexo (F/M):"));
        txtSexo = new JTextField();
        inputPanel.add(txtSexo);
        
        inputPanel.add(new JLabel("País:"));
        txtPais = new JTextField();
        inputPanel.add(txtPais);
        
        inputPanel.add(new JLabel("Gênero Musical:"));
        txtGeneroMusical = new JTextField();
        inputPanel.add(txtGeneroMusical);
        
        // Painel de botões
        JPanel buttonPanel = new JPanel(new GridLayout(2, 4, 5, 5));
        buttonPanel.setBorder(BorderFactory.createTitledBorder("Operações"));
        
        btnCadastrar = new JButton("Cadastrar");
        btnListar = new JButton("Listar Todos");
        btnMediaGeral = new JButton("Média Geral");
        btnCandidataMaisJovem = new JButton("Candidata Mais Jovem");
        
        btnMostrarPilha = new JButton("Mostrar Pilha");
        btnMostrarFila = new JButton("Mostrar Fila");
        btnRetirarPilha = new JButton("Retirar da Pilha");
        btnRetirarFila = new JButton("Retirar da Fila");
        
        buttonPanel.add(btnCadastrar);
        buttonPanel.add(btnListar);
        buttonPanel.add(btnMediaGeral);
        buttonPanel.add(btnCandidataMaisJovem);
        buttonPanel.add(btnMostrarPilha);
        buttonPanel.add(btnMostrarFila);
        buttonPanel.add(btnRetirarPilha);
        buttonPanel.add(btnRetirarFila);
        
        // Painel de filtro por gênero
        JPanel filterPanel = new JPanel(new FlowLayout());
        filterPanel.setBorder(BorderFactory.createTitledBorder("Filtrar por Gênero Musical"));
        
        txtGeneroFiltro = new JTextField(15);
        btnFiltrarGenero = new JButton("Filtrar");
        btnAutores = new JButton("Autores");
        
        filterPanel.add(new JLabel("Gênero:"));
        filterPanel.add(txtGeneroFiltro);
        filterPanel.add(btnFiltrarGenero);
        filterPanel.add(btnAutores);
        
        // Área de resultado - Aumentando o tamanho
        txtAreaResultado = new JTextArea();
        txtAreaResultado.setEditable(false);
        txtAreaResultado.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(txtAreaResultado);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Resultados"));
        scrollPane.setPreferredSize(new Dimension(800, 300));
        
        // Adicionando os painéis ao painel principal
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(inputPanel, BorderLayout.CENTER);
        topPanel.add(buttonPanel, BorderLayout.SOUTH);
        
        // Painel para os painéis superiores
        JPanel upperPanel = new JPanel(new BorderLayout());
        upperPanel.add(topPanel, BorderLayout.CENTER);
        upperPanel.add(filterPanel, BorderLayout.SOUTH);
        
        mainPanel.add(upperPanel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        
        // Adicionando o painel principal à janela
        add(mainPanel);
        
        // Adicionando os listeners aos botões
        btnCadastrar.addActionListener(e -> cadastrarCandidato());
        btnListar.addActionListener(e -> listarCandidatos());
        btnMediaGeral.addActionListener(e -> calcularMediaGeral());
        btnCandidataMaisJovem.addActionListener(e -> encontrarCandidataMaisJovem());
        btnMostrarPilha.addActionListener(e -> mostrarPilha());
        btnMostrarFila.addActionListener(e -> mostrarFila());
        btnRetirarPilha.addActionListener(e -> retirarDaPilha());
        btnRetirarFila.addActionListener(e -> retirarDaFila());
        btnFiltrarGenero.addActionListener(e -> filtrarPorGenero());
        btnAutores.addActionListener(e -> mostrarAutores());
    }
    
    private void cadastrarCandidato() {
        try {
            String nome = txtNome.getText().trim();
            String idadeStr = txtIdade.getText().trim();
            String sexo = txtSexo.getText().trim().toUpperCase();
            String pais = txtPais.getText().trim();
            String generoMusical = txtGeneroMusical.getText().trim();
            
            // Validação dos campos
            if (nome.isEmpty() || idadeStr.isEmpty() || sexo.isEmpty() || pais.isEmpty() || generoMusical.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Todos os campos são obrigatórios!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // Validação da idade
            int idade;
            try {
                idade = Integer.parseInt(idadeStr);
                if (idade <= 0 || idade > 120) {
                    JOptionPane.showMessageDialog(this, "Idade inválida! Deve estar entre 1 e 120 anos.", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Idade deve ser um número válido!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // Validação do sexo
            if (!sexo.equals("F") && !sexo.equals("M")) {
                JOptionPane.showMessageDialog(this, "Sexo deve ser F ou M!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // Criando o candidato
            Candidato candidato = new Candidato(nome, idadeStr, sexo, pais, generoMusical);
            
            // Adicionando à estrutura apropriada
            if (sexo.equals("F")) {
                pilhaMulheres.push(candidato);
            } else {
                filaHomens.offer(candidato);
            }
            
            // Adicionando à lista de todos os candidatos
            todosCandidatos.add(candidato);
            
            // Limpando os campos
            txtNome.setText("");
            txtIdade.setText("");
            txtSexo.setText("");
            txtPais.setText("");
            txtGeneroMusical.setText("");
            
            JOptionPane.showMessageDialog(this, "Candidato cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar candidato: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void listarCandidatos() {
        if (todosCandidatos.isEmpty()) {
            txtAreaResultado.setText("Nenhum candidato cadastrado.");
            return;
        }
        
        // Separando homens e mulheres
        List<Candidato> mulheres = new ArrayList<>();
        List<Candidato> homens = new ArrayList<>();
        
        for (Candidato c : todosCandidatos) {
            if (c.getSexo().equals("F")) {
                mulheres.add(c);
            } else {
                homens.add(c);
            }
        }
        
        // Ordenando por nome (Bubble Sort)
        ordenarPorNome(mulheres);
        ordenarPorNome(homens);
        
        // Construindo o resultado
        StringBuilder resultado = new StringBuilder();
        resultado.append("=== CANDIDATAS (ORDEM ALFABÉTICA) ===\n\n");
        
        if (mulheres.isEmpty()) {
            resultado.append("Nenhuma candidata cadastrada.\n");
        } else {
            for (Candidato c : mulheres) {
                resultado.append(c.toString()).append("\n");
            }
        }
        
        resultado.append("\n=== CANDIDATOS (ORDEM ALFABÉTICA) ===\n\n");
        
        if (homens.isEmpty()) {
            resultado.append("Nenhum candidato cadastrado.\n");
        } else {
            for (Candidato c : homens) {
                resultado.append(c.toString()).append("\n");
            }
        }
        
        txtAreaResultado.setText(resultado.toString());
    }
    
    private void ordenarPorNome(List<Candidato> lista) {
        int n = lista.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (lista.get(j).getNome().compareToIgnoreCase(lista.get(j + 1).getNome()) > 0) {
                    // Troca
                    Candidato temp = lista.get(j);
                    lista.set(j, lista.get(j + 1));
                    lista.set(j + 1, temp);
                }
            }
        }
    }
    
    private void calcularMediaGeral() {
        if (todosCandidatos.isEmpty()) {
            txtAreaResultado.setText("Nenhum candidato cadastrado para calcular a média.");
            return;
        }
        
        int somaIdades = 0;
        for (Candidato c : todosCandidatos) {
            somaIdades += Integer.parseInt(c.getIdade());
        }
        
        double media = (double) somaIdades / todosCandidatos.size();
        
        txtAreaResultado.setText(String.format("Média geral de idade: %.2f anos", media));
    }
    
    private void encontrarCandidataMaisJovem() {
        if (pilhaMulheres.isEmpty()) {
            txtAreaResultado.setText("Não há candidatas cadastradas.");
            return;
        }
        
        Candidato maisJovem = null;
        int idadeMaisJovem = Integer.MAX_VALUE;
        
        for (Candidato c : pilhaMulheres) {
            int idade = Integer.parseInt(c.getIdade());
            if (idade < idadeMaisJovem) {
                idadeMaisJovem = idade;
                maisJovem = c;
            }
        }
        
        if (maisJovem != null) {
            txtAreaResultado.setText("Candidata mais jovem:\n\n" + maisJovem.toString());
        } else {
            txtAreaResultado.setText("Não foi possível encontrar a candidata mais jovem.");
        }
    }
    
    private void mostrarPilha() {
        if (pilhaMulheres.isEmpty()) {
            txtAreaResultado.setText("A pilha de mulheres está vazia.");
            return;
        }
        
        StringBuilder resultado = new StringBuilder();
        resultado.append("=== PILHA DE MULHERES ===\n\n");
        
        for (Candidato c : pilhaMulheres) {
            resultado.append(c.toString()).append("\n");
        }
        
        txtAreaResultado.setText(resultado.toString());
    }
    
    private void mostrarFila() {
        if (filaHomens.isEmpty()) {
            txtAreaResultado.setText("A fila de homens está vazia.");
            return;
        }
        
        StringBuilder resultado = new StringBuilder();
        resultado.append("=== FILA DE HOMENS ===\n\n");
        
        for (Candidato c : filaHomens) {
            resultado.append(c.toString()).append("\n");
        }
        
        txtAreaResultado.setText(resultado.toString());
    }
    
    private void retirarDaPilha() {
        if (pilhaMulheres.isEmpty()) {
            txtAreaResultado.setText("A pilha de mulheres está vazia.");
            return;
        }
        
        Candidato removido = pilhaMulheres.pop();
        todosCandidatos.remove(removido);
        
        txtAreaResultado.setText("Candidata removida da pilha:\n\n" + removido.toString());
    }
    
    private void retirarDaFila() {
        if (filaHomens.isEmpty()) {
            txtAreaResultado.setText("A fila de homens está vazia.");
            return;
        }
        
        Candidato removido = filaHomens.poll();
        todosCandidatos.remove(removido);
        
        txtAreaResultado.setText("Candidato removido da fila:\n\n" + removido.toString());
    }
    
    private void filtrarPorGenero() {
        String generoFiltro = txtGeneroFiltro.getText().trim();
        
        if (generoFiltro.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, informe um gênero musical para filtrar.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        List<Candidato> candidatosFiltrados = new ArrayList<>();
        
        for (Candidato c : todosCandidatos) {
            if (c.getGeneroMusical().equalsIgnoreCase(generoFiltro)) {
                candidatosFiltrados.add(c);
            }
        }
        
        if (candidatosFiltrados.isEmpty()) {
            txtAreaResultado.setText("Nenhum candidato encontrado para o gênero musical: " + generoFiltro);
            return;
        }
        
        StringBuilder resultado = new StringBuilder();
        resultado.append("=== CANDIDATOS DO GÊNERO: ").append(generoFiltro.toUpperCase()).append(" ===\n\n");
        
        for (Candidato c : candidatosFiltrados) {
            resultado.append(c.toString()).append("\n");
        }
        
        txtAreaResultado.setText(resultado.toString());
    }
    
    private void mostrarAutores() {
        Sobre sobre = new Sobre();
        sobre.setVisible(true);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ConcursoTalentos2025().setVisible(true);
        });
    }
}
