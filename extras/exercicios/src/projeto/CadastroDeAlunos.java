package projeto;

import java.util.Scanner;

public class CadastroDeAlunos {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int opcao;
        int quantidadeLimiteDeAlunos = 2;
        int quantidadeLimiteDeNotas = 3;
        int indiceNotas = 0;
        double mediaGeral = 0.0;
        double maiorMedia = 0.0;
        double menorMedia = 0.0;
        int quantidadeDeAprovados = 0;
        int quantidadeDeReprovados = 0;
        String[] nomes = new String[quantidadeLimiteDeAlunos];
        int[] idades = new int[quantidadeLimiteDeAlunos];
        double[][] notas = new double[quantidadeLimiteDeAlunos][quantidadeLimiteDeNotas];
        int quantidadeDeAlunosCadastrados = 0;
        double[] medias = new double[notas.length];
        // Mock
        // String[] nomes = new String[]{"Pedro", "Paulo"};
        // int[] idades = new int[]{20, 30};
        // double[][] notas = new double[][]{{8,7,6},{4,5,4}};
        // int quantidadeDeAlunosCadastrados = 2;

        do {
            System.out.print(
                    "\n=================================\n" +
                    "     SISTEMA DE ALUNOS\n" +
                    "=================================\n" +
                    "\n" +
                    "1 - Cadastrar alunos\n" +
                    "2 - Exibir alunos\n" +
                    "3 - Exibir médias\n" +
                    "4 - Exibir maior média\n" +
                    "5 - Exibir menor média\n" +
                    "6 - Exibir aprovados\n" +
                    "7 - Exibir reprovados\n" +
                    "8 - Estatísticas da turma\n" +
                    "9 - Sair\n" +
                    "\n" +
                    "Escolha uma opção: "
            );
            opcao = entrada.nextInt();
            switch (opcao){
                case 1:
                    if (quantidadeDeAlunosCadastrados < quantidadeLimiteDeAlunos) {
                        for (; quantidadeDeAlunosCadastrados < quantidadeLimiteDeAlunos; quantidadeDeAlunosCadastrados++) {
                            System.out.printf("%nCADASTRAR ALUNO %d%n", quantidadeDeAlunosCadastrados + 1);
                            System.out.print("Nome: ");
                            nomes[quantidadeDeAlunosCadastrados] = entrada.next();
                            System.out.print("Idade: ");
                            idades[quantidadeDeAlunosCadastrados] = entrada.nextInt();
                            System.out.printf("Notas:%n");
                            for (int i = 0; i < notas[quantidadeDeAlunosCadastrados].length; i++) {
                                System.out.printf("%7s %d: ", "Nota", i + 1);
                                notas[quantidadeDeAlunosCadastrados][i] = entrada.nextDouble();
                            }
                        }
                    } else {
                        System.out.println("Quantidade limite de alunos atingida!");
                    }
                    break;
                case 2:
                    if (quantidadeDeAlunosCadastrados > 0) {
                        System.out.printf("%nEXIBINDO ALUNOS");
                        for (int i = 0; i < quantidadeDeAlunosCadastrados; i++) {
                            System.out.printf("%nAluno: %d", i + 1);
                            System.out.printf("%nNome: %s", nomes[i]);
                            System.out.printf("%nIdade: %d", idades[i]);
                            System.out.printf("%n");
                        }
                    } else {
                        System.out.println("Nenhum aluno cadastrado!");
                    }
                    break;
                case 3:
                    if (quantidadeDeAlunosCadastrados > 0) {
                        System.out.printf("%nEXIBINDO MEDIAS");
                        double somaDasMedias = 0.0;
                        for (int aluno = 0;aluno < quantidadeDeAlunosCadastrados; aluno++) {
                            double somaDasNotas = 0.0;
                            System.out.printf("%nAluno: %d", aluno + 1);
                            System.out.printf("%nNome: %s", nomes[aluno]);
                            System.out.printf("%nNotas: ");
                            for(int j = 0; j < notas[aluno].length; j++) {
                                System.out.printf("%.2f ", notas[aluno][j]);
                                somaDasNotas += notas[aluno][j];
                            }
                            medias[aluno] = somaDasNotas / notas[aluno].length;
                            somaDasMedias += medias[aluno];

                            System.out.printf("%nMedia: %.2f%n", medias[aluno]);
                        }
                        mediaGeral = somaDasMedias / medias.length;
                    } else {
                        System.out.println("Nenhum aluno cadastrado!");
                    }
                    break;
                case 4:
                    if (quantidadeDeAlunosCadastrados > 0) {
                        System.out.printf("%nEXIBINDO MAIOR MEDIA");
                        int indiceMaiorMedia = 0;
                        maiorMedia = medias[indiceMaiorMedia];
                        for (int indiceAtual = 1; indiceAtual < quantidadeDeAlunosCadastrados; indiceAtual++) {
                            if(medias[indiceAtual] > maiorMedia){
                                maiorMedia = medias[indiceAtual];
                                indiceMaiorMedia = indiceAtual;
                            }
                        }
                        System.out.printf(
                                "%nAluno: %s" +
                                "%nMedia: %.2f%n",
                                nomes[indiceMaiorMedia], medias[indiceMaiorMedia]
                        );
                    } else {
                        System.out.println("Nenhum aluno cadastrado!");
                    }
                    break;
                case 5:
                    if (quantidadeDeAlunosCadastrados > 0) {
                        System.out.printf("%nEXIBINDO MENOR MEDIA");
                        int indiceMenorMedia = 0;
                        menorMedia = medias[indiceMenorMedia];
                        for (int indiceAtual = 1; indiceAtual < quantidadeDeAlunosCadastrados; indiceAtual++) {
                            if(medias[indiceAtual] < menorMedia){
                                menorMedia = medias[indiceAtual];
                                indiceMenorMedia = indiceAtual;
                            }
                        }
                        System.out.printf(
                                "%nAluno: %s" +
                                        "%nMedia: %.2f%n",
                                nomes[indiceMenorMedia], medias[indiceMenorMedia]
                        );
                    } else {
                        System.out.println("Nenhum aluno cadastrado!");
                    }
                    break;
                case 6:
                    if (quantidadeDeAlunosCadastrados > 0) {
                        System.out.printf("%n===== APROVADOS =====");
                        for (int indiceAtual = 0; indiceAtual < quantidadeDeAlunosCadastrados; indiceAtual++) {
                            if(medias[indiceAtual] >= 7){
                                quantidadeDeAprovados++;
                                System.out.printf(
                                        "%n%s - Media: %.2f",
                                        nomes[indiceAtual], medias[indiceAtual]
                                );
                            }
                        }
                        System.out.printf("%n");
                    } else {
                        System.out.println("Nenhum aluno cadastrado!");
                    }
                    break;
                case 7:
                    if (quantidadeDeAlunosCadastrados > 0) {
                        System.out.printf("%n===== REPROVADOS =====");
                        for (int indiceAtual = 0; indiceAtual < quantidadeDeAlunosCadastrados; indiceAtual++) {
                            if(medias[indiceAtual] < 5){
                                quantidadeDeReprovados++;
                                System.out.printf(
                                        "%n%s - Media: %.2f",
                                        nomes[indiceAtual], medias[indiceAtual]
                                );
                            }
                        }
                        System.out.printf("%n");
                    } else {
                        System.out.println("Nenhum aluno cadastrado!");
                    }
                    break;
                case 8:
                    System.out.printf(
                        "%n===== ESTATÍSTICAS =====%n" +
                        "Quantidade de alunos: %d%n" +
                        "Média geral da turma: %.2f%n" +
                        "Maior média: %.2f%n" +
                        "Menor média: %.2f%n" +
                        "Aprovados: %d%n" +
                        "Reprovados: %d%n",
                            quantidadeDeAlunosCadastrados,
                            mediaGeral,
                            maiorMedia,
                            menorMedia,
                            quantidadeDeAprovados,
                            quantidadeDeReprovados
                    );
                    break;
                case 9:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opcao invalida");

                    System.out.printf("%n");
            }
        }while (opcao != 9);

        entrada.close();
    }
}