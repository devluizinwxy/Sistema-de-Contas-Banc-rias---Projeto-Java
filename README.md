# Sistema de Contas Bancárias - Projeto Java

Este projeto é um exemplo de sistema bancário em Java que permite criar contas, realizar depósitos e saques, com validações completas de entrada de dados.


## Funcionalidades

* Criar contas com número, nome do titular, saldo inicial e limite de saque.
* Realizar depósitos e saques com validação de valores.
* Tratamento de exceções e entradas inválidas.
* Entrada de dados via console utilizando `Scanner` com métodos utilitários (`LeituraUtil`).

---

## Como Rodar

1. Clone o repositório:

```bash
git clone https://github.com/seu-usuario/seu-repositorio.git
```

2. Compile as classes Java:

```bash
javac src/main/java/br/com/suaempresa/banco/*.java
```

3. Execute o programa:

```bash
java -cp src/main/java br.com.suaempresa.banco.Main
```

---

## Exceções Customizadas

O projeto utiliza exceções personalizadas para validação:

* `NomeInvalido` – dispara quando o nome do titular é inválido.
* `SaldoInvalido` – dispara quando o saldo informado é nulo ou negativo.
* `LimiteInvalido` – dispara quando o limite de saque é inválido.
* `DepositoInvalido` – dispara quando o valor do depósito é inválido.

---

## Boas Práticas

* Separação de responsabilidades: `ContaService` gerencia regras de negócio, `Main` lida com interface de usuário.
* Validações consistentes antes de alterar o estado do objeto `Conta`.
* Tratamento de entradas do usuário com loops e exceções para evitar erros de execução.

---

## Autor

Luis de Jesus Fernandes
