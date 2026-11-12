package com.mycompany.trabalhogenerics;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Depósito que armazena somente objetos do tipo T, que deve ser Produto.
 */
public class Deposito<T extends Produto> {
    private final List<T> itens = new ArrayList<>();

    public void adicionar(T item) {
        if (item == null) {
            throw new IllegalArgumentException("O produto não pode ser nulo.");
        }
        itens.add(item);
    }

    public Optional<T> retirar() {
        if (itens.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(itens.remove(0));
    }

    public Optional<T> buscarPorNome(String nome) {
        if (nome == null) {
            return Optional.empty();
        }

        return itens.stream()
                .filter(item -> item.getNome().equalsIgnoreCase(nome))
                .findFirst();
    }

    public List<T> listarItens() {
        return new ArrayList<>(itens);
    }
}
