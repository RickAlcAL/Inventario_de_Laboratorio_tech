# Sistema de Gerenciamento de Inventário - Java I/O

Este é um sistema de inventário desenvolvido em Java que automatiza a leitura, validação e organização de componentes tecnológicos a partir de arquivos de texto. O projeto foi estruturado utilizando conceitos avançados de Orientação a Objetos e manipulação eficiente de fluxos de entrada/saída (I/O).

## 🚀 Tecnologias e Conceitos Utilizados

* **Java 25** (OpenJDK Temurin)
* **Programação Orientada a Objetos Avançada:** Uso de Herança (`Computador extends Equipamentos`), Polimorfismo e Encapsulamento.
* **Java I/O (Input/Output):** Manipulação de arquivos utilizando exclusivamente `BufferedReader`, `FileReader`, `BufferedWriter` e `FileWriter` (com modo *append*).
* **Tratamento de Exceções Robusto:** Captura de falhas em tempo de execução (`RuntimeException`) para evitar a interrupção do sistema ao encontrar dados corrompidos.
* **Enums:** Padronização de mensagens de erro e confirmação para o usuário final.

## 📦 Como o Sistema Funciona

O sistema lê um arquivo principal chamado `entrada_inventario.txt`. A partir daí, ele processa cada linha com base em sua tag inicial:

1.  **Tag `E` (Equipamentos):** Instancia um objeto `Equipamentos`, adiciona à lista na memória e grava a linha no arquivo `relatorio_valido_equipamentos.txt`.
2.  **Tag `C` (Computadores):** Instancia um objeto `Computador` (herdando propriedades de Equipamentos), adiciona à lista e grava no arquivo `relatorio_valido_componentes.txt`.
3.  **Outras Tags / Linhas Inválidas:** O sistema isola o erro, grava a linha inválida no arquivo `log_erros.txt` e continua a leitura do documento sem travar a execução.

## 📁 Estrutura de Arquivos Gerados

Após a execução do método `leitorTXT()`, o sistema organiza os dados na pasta configurada:
* `relatorio_valido_equipamentos.txt` -> Apenas linhas validadas de Equipamentos.
* `relatorio_valido_componentes.txt` -> Apenas linhas validadas de Computadores.
* `log_erros.txt` -> Histórico de linhas que falharam na validação (Ex: cabeçalhos ou dados corrompidos).

## 🛠️ Como Executar o Projeto

1. Certifique-se de ter o diretório `C:\Users\ADM\Teste\` criado no seu ambiente Windows (ou altere as variáveis `path` no topo da classe `Computador` para o caminho de sua preferência).
2. Coloque o seu arquivo de entrada com o nome `entrada_inventario.txt` dentro da pasta.
3. Instancie a classe `Computador` na sua classe `Main` e chame o método `leitorTXT()`:

```java
Computador sistema = new Computador();
sistema.leitorTXT(); // Processa e divide o inventário
sistema.lendoAquivoC(); // Opcional: exibe os computadores processados no console
