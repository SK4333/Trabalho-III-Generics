# Trabalho III — Generics em Java
## Parte II — Aplicação prática

Projeto prático do sistema de depósitos. O projeto não utiliza Maven.

### Estrutura
Os arquivos Java estão em:
`src/main/java/com/mycompany/trabalhogenerics/`

Classes:
- `Produto`: classe abstrata base.
- `Eletronico`, `Alimento` e `Vestuario`: categorias de produtos.
- `Deposito<T extends Produto>`: armazena produtos com segurança de tipos.
- `OperacoesDeposito`: transferência com PECS e listagem com wildcard.
- `Main`: demonstra as operações.

### Funcionalidades demonstradas
- `adicionar(T item)` adiciona um produto compatível com o tipo do depósito.
- `retirar()` devolve `Optional<T>` e retorna `Optional.empty()` quando não há itens.
- `buscarPorNome(String nome)` procura um item e devolve `Optional<T>`.
- `transferir(...)` utiliza `? extends T` na origem e `? super T` no destino. Cada chamada transfere um item.
- `listarConteudo(Deposito<?> deposito)` percorre depósitos sem depender do tipo específico.

### Requisito
JDK 17 ou superior. O comando `javac` deve estar disponível no PATH.

### Compilar e executar no Windows PowerShell
Abra o PowerShell na pasta `Trabalho_III_Generics_Parte_II` e execute:

```powershell
New-Item -ItemType Directory -Force out
javac -encoding UTF-8 --release 17 -Xlint:all -d out src/main/java/com/mycompany/trabalhogenerics/*.java
java -cp out com.mycompany.trabalhogenerics.Main
```

### Segurança de tipos
Na classe `Main`, há uma linha comentada que tenta inserir `Alimento` em `Deposito<Eletronico>`. Se ela for descomentada, o compilador deve rejeitar a operação, pois `Alimento` não pode ser convertido em `Eletronico`.
