package projeto;

/**
 * Sistema de Cadastro e Análise de Alunos
 *
 * Agora vamos juntar os conceitos estudados em um pequeno sistema.
 *
 * O objetivo não é criar um sistema profissional, mas construir um programa que
 * obrigue você a utilizar os conceitos fundamentais de lógica de programação.
 *
 * 🎯 Objetivo
 *
 * Criar um sistema de cadastro e análise de alunos executado pelo terminal.
 *
 * O programa deverá apresentar um menu principal:
 *
 * =================================
 *      SISTEMA DE ALUNOS
 * =================================
 *
 * 1 - Cadastrar alunos
 * 2 - Exibir alunos
 * 3 - Exibir médias
 * 4 - Exibir maior média
 * 5 - Exibir menor média
 * 6 - Exibir aprovados
 * 7 - Exibir reprovados
 * 8 - Estatísticas da turma
 * 9 - Sair
 *
 * Escolha uma opção:
 *
 * 1 — Cadastro de alunos
 *
 * O programa deverá permitir cadastrar uma quantidade definida de alunos.
 *
 * Para cada aluno, armazene:
 *
 *     Nome
 *     Idade
 *     Três notas
 *
 * Uma possível estrutura:
 *
 * nomes[]
 * idades[]
 * notas[][]
 *
 * Por exemplo:
 *
 * nomes[0] = "João"
 * idades[0] = 20
 *
 * notas[0][0] = 8
 * notas[0][1] = 7
 * notas[0][2] = 9
 *
 * 2 — Exibir alunos
 *
 * Apresente todos os alunos cadastrados.
 * Exemplo
 *
 * Aluno 1
 * Nome: João
 * Idade: 20
 *
 * Aluno 2
 * Nome: Maria
 * Idade: 22
 *
 * 3 — Exibir médias
 *
 * Calcule a média das três notas de cada aluno.
 * Exemplo
 *
 * João
 * Notas: 8, 7, 9
 * Média: 8.0
 *
 * Maria
 * Notas: 6, 5, 7
 * Média: 6.0
 *
 * 4 — Exibir maior média
 *
 * Identifique qual aluno possui a maior média.
 * Exemplo
 *
 * Maior média:
 *
 * Aluno: João
 * Média: 9.2
 *
 * 5 — Exibir menor média
 *
 * Identifique qual aluno possui a menor média.
 * Exemplo
 *
 * Menor média:
 *
 * Aluno: Pedro
 * Média: 4.8
 *
 * 6 — Exibir aprovados
 *
 * Considere:
 *
 * Média >= 7 → Aprovado
 *
 * Liste todos os alunos aprovados.
 * Exemplo
 *
 * ===== APROVADOS =====
 *
 * João - Média: 8.3
 * Maria - Média: 7.5
 *
 * 7 — Exibir reprovados
 *
 * Considere:
 *
 * Média < 5 → Reprovado
 *
 * Liste todos os alunos reprovados.
 * Exemplo
 *
 * ===== REPROVADOS =====
 *
 * Pedro - Média: 4.2
 * Carlos - Média: 3.8
 *
 * 8 — Estatísticas da turma
 *
 * Apresente informações gerais sobre a turma.
 *
 * O programa deverá calcular:
 *
 *     Quantidade de alunos.
 *     Média geral da turma.
 *     Maior média.
 *     Menor média.
 *     Quantidade de aprovados.
 *     Quantidade de reprovados.
 *
 * Exemplo
 *
 * ===== ESTATÍSTICAS =====
 *
 * Alunos: 10
 *
 * Média da turma: 7.2
 *
 * Maior média: 9.5
 * Menor média: 4.1
 *
 * Aprovados: 7
 * Reprovados: 3
 *
 * 9 — Sair
 *
 * Ao selecionar 9, o programa deverá finalizar.
 *
 * Exiba uma mensagem:
 *
 * Programa encerrado.
 * Até a próxima!
 *
 * Desafios extras
 *
 * Depois de concluir o projeto principal, tente implementar os seguintes recursos.
 * Desafio 1 — Recuperação
 *
 * Crie uma situação intermediária:
 *
 * Média >= 7 → Aprovado
 * Média >= 5 → Recuperação
 * Média < 5  → Reprovado
 *
 * Desafio 2 — Maior nota individual
 *
 * Descubra a maior nota de toda a turma.
 *
 * Informe:
 *
 * Aluno
 * Nota
 *
 * Desafio 3 — Menor nota individual
 *
 * Descubra a menor nota de toda a turma.
 * Desafio 4 — Acima da média da turma
 *
 * Calcule a média geral da turma.
 *
 * Depois informe quais alunos possuem média acima da média da turma.
 * Desafio 5 — Validação
 *
 * Não permita que o usuário informe notas menores que 0 ou maiores que 10.
 * Desafio 6 — Menu persistente
 *
 * Depois de executar qualquer operação, o programa deverá retornar ao menu principal.
 * Desafio 7 — Quantidade dinâmica
 *
 * Pergunte ao usuário quantos alunos serão cadastrados.
 *
 * Por exemplo:
 *
 * Quantos alunos deseja cadastrar? 10
 *
 * Depois crie os arrays com esse tamanho.
 */

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
                case 12:
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
                case 13:
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