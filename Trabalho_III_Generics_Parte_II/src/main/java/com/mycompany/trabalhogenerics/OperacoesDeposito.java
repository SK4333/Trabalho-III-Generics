package com.mycompany.trabalhogenerics;

public class OperacoesDeposito {

    /**
     * Transfere um item por chamada, aplicando a regra PECS.
     */
    public static <T extends Produto> void transferir(
            Deposito<? extends T> origem,
            Deposito<? super T> destino) {
        origem.retirar().ifPresent(destino::adicionar);
    }

    /**
     * Lista os produtos sem precisar conhecer o tipo específico do depósito.
     */
    public static void listarConteudo(Deposito<?> deposito) {
        for (Produto produto : deposito.listarItens()) {
            System.out.println("- " + produto);
        }
    }
}
