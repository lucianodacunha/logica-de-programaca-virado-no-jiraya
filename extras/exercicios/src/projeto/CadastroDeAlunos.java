package projeto;

import java.util.Scanner;

public class CadastroDeAlunos {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("------------------------------------------");
        System.out.println("BEM VINDO AO SISTEMA DE CADASTRO DE ALUNOS");
        System.out.println("------------------------------------------");
        System.out.printf("%nQuantos alunos deseja configurar para cadastro: ");
        int quantidadeLimiteDeAlunos = entrada.nextInt();

        int opcao;
        double mediaGeral = 0.0;
        double maiorMedia = 0.0;
        double menorMedia = 0.0;
        double maiorNotaIndividual = 0;
        double menorNotaIndividual = 0;
        int[][] indiceDaMenorNotaIndividual = new int[1][2];
        int[][] indiceDaMaiorNotaIndividual = new int[1][2];
        int indiceMaiorMedia = 0;
        int indiceMenorMedia = 0;
        int quantidadeDeAprovados = 0;
        int quantidadeDeReprovados = 0;
        int quantidadeDeRecuperacao = 0;
        int quantidadeDeAlunosCadastrados = 0;

        int quantidadeLimiteDeNotas = 3;
        String[] nomes = new String[quantidadeLimiteDeAlunos];
        int[] idades = new int[quantidadeLimiteDeAlunos];
        double[][] notas = new double[quantidadeLimiteDeAlunos][quantidadeLimiteDeNotas];
        double[] medias = new double[notas.length];

        do {
            System.out.print(
                    "\n=================================\n" +
                    "     SISTEMA DE ALUNOS\n" +
                    "=================================\n" +
                    "\n" +
                    " 1 - Cadastrar alunos\n" +
                    " 2 - Exibir alunos\n" +
                    " 3 - Exibir médias\n" +
                    " 4 - Exibir maior média\n" +
                    " 5 - Exibir menor média\n" +
                    " 6 - Exibir aprovados\n" +
                    " 7 - Exibir recuperacao\n" +
                    " 8 - Exibir reprovados\n" +
                    " 9 - Maior nota individual\n" +
                    "10 - Menor nota individual\n" +
                    "11 - Alunos com media acima da media\n" +
                    "12 - Estatísticas da turma\n" +
                    "13 - Sair\n" +
                    "\n" +
                    "Escolha uma opção: "
            );
            opcao = entrada.nextInt();
            switch (opcao){
                case 1:
                    quantidadeLimiteDeAlunos = 2;
                    if (quantidadeDeAlunosCadastrados < quantidadeLimiteDeAlunos) {
                        for (; quantidadeDeAlunosCadastrados < quantidadeLimiteDeAlunos; quantidadeDeAlunosCadastrados++) {
                            System.out.printf("%nCADASTRAR ALUNO %d%n", quantidadeDeAlunosCadastrados + 1);
                            System.out.print("Nome: ");
                            nomes[quantidadeDeAlunosCadastrados] = entrada.next();
                            System.out.print("Idade: ");
                            idades[quantidadeDeAlunosCadastrados] = entrada.nextInt();
                            System.out.printf("Notas:%n");
                            int i = 0;
                            for (; i < notas[quantidadeDeAlunosCadastrados].length; i++) {
                                boolean notaInvalida;
                                do {
                                    notaInvalida = false;
                                    System.out.printf("%7s %d [0-10]: ", "Nota", i + 1);
                                    notas[quantidadeDeAlunosCadastrados][i] = entrada.nextDouble();
                                    if (notas[quantidadeDeAlunosCadastrados][i] < 0 ||
                                            notas[quantidadeDeAlunosCadastrados][i] > 10){
                                        notaInvalida = true;
                                        System.out.println("Nota invalida, digite novamente.");
                                    }
                                } while(notaInvalida);
                            }
                        }
                    } else {
                        System.out.println("Quantidade limite de alunos atingida!");
                    }

                    // estatisticas
                    double somaDasMedias = 0.0;
                    for (int aluno = 0; aluno < quantidadeDeAlunosCadastrados; aluno++) {
                        double somaDasNotas = 0.0;
                        for(int nota = 0; nota < notas[aluno].length; nota++) {
                            somaDasNotas += notas[aluno][nota];
                            if (aluno == 0 && nota == 0) {
                                indiceDaMaiorNotaIndividual[0][0] = aluno;
                                indiceDaMaiorNotaIndividual[0][1] = nota;
                                maiorNotaIndividual = notas[aluno][nota];

                                indiceDaMenorNotaIndividual[0][0] = aluno;
                                indiceDaMenorNotaIndividual[0][1] = nota;
                                menorNotaIndividual = notas[aluno][nota];

                            }
                            if (notas[aluno][nota] > maiorNotaIndividual){
                                indiceDaMaiorNotaIndividual[0][0] = aluno;
                                indiceDaMaiorNotaIndividual[0][1] = nota;
                                maiorNotaIndividual = notas[aluno][nota];
                            }

                            if (notas[aluno][nota] < menorNotaIndividual){
                                indiceDaMenorNotaIndividual[0][0] = aluno;
                                indiceDaMenorNotaIndividual[0][1] = nota;
                                menorNotaIndividual = notas[aluno][nota];
                            }
                        }

                        medias[aluno] = somaDasNotas / notas[aluno].length;

                        if(medias[aluno] >= 7){
                            quantidadeDeAprovados++;
                        } else if (medias[aluno] >= 5){
                            quantidadeDeRecuperacao++;
                        } else {
                            quantidadeDeReprovados++;
                        }

                        if(aluno == 0){
                            maiorMedia = medias[aluno];
                            menorMedia = medias[aluno];
                            indiceMaiorMedia = aluno;
                            indiceMenorMedia = aluno;
                        }

                        if (medias[aluno] > maiorMedia){
                            maiorMedia = medias[aluno];
                            indiceMaiorMedia = aluno;
                        }

                        if (medias[aluno] < menorMedia){
                            menorMedia = medias[aluno];
                            indiceMenorMedia = aluno;
                        }

                        somaDasMedias += medias[aluno];
                    }
                    mediaGeral = somaDasMedias / medias.length;
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
                        for (int aluno = 0;aluno < quantidadeDeAlunosCadastrados; aluno++) {
                            System.out.printf("%nAluno: %d", aluno + 1);
                            System.out.printf("%nNome: %s", nomes[aluno]);
                            System.out.printf("%nNotas: ");
                            for(int nota = 0; nota < notas[aluno].length; nota++) {
                                System.out.printf("%.2f ", notas[aluno][nota]);
                            }
                            System.out.printf("%nMedia: %.2f%n", medias[aluno]);
                        }
                    } else {
                        System.out.println("Nenhum aluno cadastrado!");
                    }
                    break;
                case 4:
                    if (quantidadeDeAlunosCadastrados > 0) {
                        System.out.printf("%nEXIBINDO MAIOR MEDIA");
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
                        System.out.printf(
                                "%nAluno: %s%nMedia: %.2f%n",
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
                        System.out.printf("%n===== RECUPERACAO =====");
                        for (int indiceAtual = 0; indiceAtual < quantidadeDeAlunosCadastrados; indiceAtual++) {
                            if(medias[indiceAtual] >= 5 && medias[indiceAtual] < 7){
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
                    if (quantidadeDeAlunosCadastrados > 0) {
                        System.out.printf("%n===== REPROVADOS =====");
                        for (int indiceAtual = 0; indiceAtual < quantidadeDeAlunosCadastrados; indiceAtual++) {
                            if(medias[indiceAtual] < 5){
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
                case 9:
                    if (quantidadeDeAlunosCadastrados > 0) {
                        System.out.printf("%n===== MAIOR NOTA INDIVIDUAL =====");
                        System.out.printf(
                                "%nAluno: %s%nNota: %.2f",
                                nomes[indiceDaMaiorNotaIndividual[0][0]],
                                notas[indiceDaMaiorNotaIndividual[0][0]][indiceDaMaiorNotaIndividual[0][1]]
                        );
                        System.out.printf("%n");
                    } else {
                        System.out.println("Nenhum aluno cadastrado!");
                    }
                    break;
                case 10:
                    if (quantidadeDeAlunosCadastrados > 0) {
                        System.out.printf("%n===== MENOR NOTA INDIVIDUAL =====");
                        System.out.printf(
                                "%nAluno: %s%nNota: %.2f",
                                nomes[indiceDaMenorNotaIndividual[0][0]],
                                notas[indiceDaMenorNotaIndividual[0][0]][indiceDaMenorNotaIndividual[0][1]]
                        );
                        System.out.printf("%n");
                    } else {
                        System.out.println("Nenhum aluno cadastrado!");
                    }
                    break;
                case 11:
                    if (quantidadeDeAlunosCadastrados > 0) {
                        System.out.printf("%n===== ALUNOS COM MEDIA ACIMA DA MEDIA =====");
                        boolean mediaAcimaDaMedia = false;
                        System.out.printf("%nMedia geral: %.2f", mediaGeral);
                        System.out.printf("%nAlunos: ");
                        for(int media = 0; media < medias.length; media++){
                            if (medias[media] > mediaGeral){
                                System.out.printf("%s ", nomes[media]);
                            }
                        }
                        System.out.printf("%n");
                    } else {
                        System.out.println("Nenhum aluno cadastrado!");
                    }
                    break;
                case 13:
                    if(quantidadeDeAlunosCadastrados > 0) {
                        System.out.printf(
                                "%n===== ESTATÍSTICAS =====%n" +
                                        "Quantidade de alunos: %d%n" +
                                        "Média geral da turma: %.2f%n" +
                                        "Maior média: %.2f%n" +
                                        "Menor média: %.2f%n" +
                                        "Aprovados: %d%n" +
                                        "Recuperacao: %d%n" +
                                        "Reprovados: %d%n",
                                quantidadeDeAlunosCadastrados,
                                mediaGeral,
                                maiorMedia,
                                menorMedia,
                                quantidadeDeAprovados,
                                quantidadeDeRecuperacao,
                                quantidadeDeReprovados
                        );
                    } else {
                        System.out.println("Nenhum aluno cadastrado!");
                    }
                    break;
                case 20:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opcao invalida");

                    System.out.printf("%n");
            }
        }while (opcao != 13);

        entrada.close();
    }
}