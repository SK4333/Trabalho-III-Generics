package com.mycompany.trabalhogenerics;

public class Alimento extends Produto {
    private final double preco;

    public Alimento(String nome, double preco) {
        super(nome);
        if (preco < 0) {
            throw new IllegalArgumentException("O preço não pode ser negativo.");
        }
        this.preco = preco;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return getNome() + " (R$ " + String.format("%.2f", preco) + ")";
    }
}
