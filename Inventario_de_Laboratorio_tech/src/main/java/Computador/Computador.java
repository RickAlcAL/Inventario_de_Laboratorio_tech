package Computador;

import Enums.Execoes;
import Equipamentos.Equipamentos;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Computador extends Equipamentos {
    private String processador;
    private String quantidadeMemoria;
    //Criando o apontamento do arquivo direto


    //OBS : Caso queria fazer um teste geral cria na sua area de trabalho e coloque os nomes exatos dos arquivos de sua preferencia
    private String path = "C:\\Users\\ADM\\Teste\\entrada_inventario.txt";
    private String pathE = "C:\\Users\\ADM\\Teste\\relatorio_valido_equipamentos.txt";
    private String pathC = "C:\\Users\\ADM\\Teste\\relatorio_valido_componentes.txt";
    private String pathX = "C:\\Users\\ADM\\Teste\\log_erros.txt";
    //Criando 4 instanciação do File diferente para cada apontamento
    private File arquivo = new File(path);
    private File arquivoE = new File(pathE);
    private File arquivoC = new File(pathC);
    private File arquivoX = new File(pathX);
    //Lsta de objetos que receberão os valores para o doc
    private List<Computador> componentes = new ArrayList<>();
    private List<Equipamentos> equipamento = new ArrayList<>();

    //Construtor padrão
    public Computador(String idPeca, String marcaPeca, String processador, String quantidadeMemoria) {
        super(idPeca, marcaPeca);
        this.processador = processador;
        this.quantidadeMemoria = quantidadeMemoria;
    }

    public Computador(String idPeca, String marcaPeca) {
        super(idPeca, marcaPeca);
    }

    public Computador() {
        super();
    }

    public Computador(String[] dados) {
    }
    public void leitorTXT () {
        //Lendo o doc inicial
        try (BufferedReader bw = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            //Verificando se a linha não for null
            while ((linha = bw.readLine()) != null){
                linha = linha.trim();
                if (linha.isEmpty()){
                    continue;
                }
                try {
                    //Colocando a linha toda em caixa alta e vendo se ela começa com E
                    if (linha.toUpperCase().startsWith("E")){
                        //Separando "linha" do doc com ; para separar os valores
                        String[] dadosE = linha.split(";");
                        System.out.println(String.join(" ", dadosE));
                        Equipamentos novoEquipamento = new Equipamentos(dadosE);
                        equipamento.add(novoEquipamento);
                        //Criando o documento novo
                        try (BufferedWriter bwE = new BufferedWriter(new FileWriter(arquivoE,true))){
                            bwE.write(linha);
                            bwE.newLine();
                        }
                        //Colocando a linha toda em caixa alta e vendo se ela começa com C
                    } else if (linha.toUpperCase().startsWith("C")) {
                        //Separando "linha" do doc com ; para separar os valores
                        String[] dadosC = linha.split(";");
                        System.out.println(String.join(" ", dadosC));
                        Computador novoComponente = new Computador(dadosC);
                        componentes.add(novoComponente);
                        //Criando o documento novo
                        try (BufferedWriter bwC = new BufferedWriter(new FileWriter(arquivoC,true))){
                            bwC.write(linha);
                            bwC.newLine();
                        }
                    } else {
                        //Criando o documento novo se nenhuma das opções acima foi concedida
                        try (BufferedWriter bwX = new BufferedWriter(new FileWriter(arquivoX,true))){
                            bwX.write(linha);
                            bwX.newLine();
                        }
                    }
                }catch (RuntimeException e){
                    //Mensagem de erro explicando o erro
                    System.out.println(e.getMessage());
                    System.out.println(Execoes.ERRO.getMensagemUsuarioFinal());
                }
            }

        } catch (IOException e){
            //Mensagem de erro final
            e.printStackTrace();
            System.out.println(Execoes.ERRO.getMensagemUsuarioFinal());
        }
    }
}
