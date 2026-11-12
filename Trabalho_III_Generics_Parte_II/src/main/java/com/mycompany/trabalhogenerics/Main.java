package com.mycompany.trabalhogenerics;

public class Main {
    public static void main(String[] args) {
        Deposito<Eletronico> depositoEletronicos = new Deposito<>();
        Deposito<Alimento> depositoAlimentos = new Deposito<>();
        Deposito<Vestuario> depositoVestuario = new Deposito<>();
        Deposito<Produto> depositoGeral = new Deposito<>();

        depositoEletronicos.adicionar(new Eletronico("Smartphone"));
        depositoEletronicos.adicionar(new Eletronico("Notebook"));

        depositoAlimentos.adicionar(new Alimento("Feijão", 8.50));
        depositoAlimentos.adicionar(new Alimento("Arroz", 6.90));

        depositoVestuario.adicionar(new Vestuario("Camiseta"));

        // Esta linha não compila, pois Alimento não é Eletronico:
        // depositoEletronicos.adicionar(new Alimento("Feijão", 8.50));

        System.out.println("RETIRADA DE ELETRÔNICO");
        depositoEletronicos.retirar().ifPresentOrElse(
                item -> System.out.println("Retirado: " + item),
                () -> System.out.println("Depósito vazio."));

        System.out.println("\nBUSCA POR NOME");
        depositoAlimentos.buscarPorNome("Arroz").ifPresentOrElse(
                item -> System.out.println("Encontrado: " + item),
                () -> System.out.println("Produto não encontrado."));

        System.out.println("\nLISTAGEM DOS DEPÓSITOS");
        System.out.println("Alimentos:");
        OperacoesDeposito.listarConteudo(depositoAlimentos);
        System.out.println("Vestuário:");
        OperacoesDeposito.listarConteudo(depositoVestuario);

        System.out.println("\nTRANSFERÊNCIA COM PECS");
        OperacoesDeposito.transferir(depositoEletronicos, depositoGeral);
        System.out.println("Depósito geral após receber um item:");
        OperacoesDeposito.listarConteudo(depositoGeral);

        System.out.println("\nTESTE DE DEPÓSITO VAZIO");
        Deposito<Eletronico> depositoVazio = new Deposito<>();
        System.out.println("Retirada disponível? " + depositoVazio.retirar().isPresent());
    }
}
