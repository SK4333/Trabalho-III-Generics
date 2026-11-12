package com.mycompany.trabalhogenerics;

/**
 * Classe base dos produtos armazenados nos depósitos.
 */
public abstract class Produto {
    private final String nome;

    public Produto(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O nome do produto não pode ser vazio.");
        }
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return nome;
    }
}
