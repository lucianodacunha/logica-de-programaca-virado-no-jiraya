package exercicio18;

/**
 * Crie uma matriz 5x5 de numeros inteiros.
 *
 * Preencha a matriz e apresente:
 *
 *     A matriz completa.
 *     Maior valor.
 *     Menor valor.
 *     Soma de todos os elementos.
 *     Média.
 *     Quantidade de numeros pares.
 *     Quantidade de numeros impares.
 *     Soma da diagonal principal.
 *     Soma da diagonal secundaria.
 *
 * Desafio
 *
 * Informe tambem:
 *
 *     A posição do maior valor.
 *     A posição do menor valor.
 *
 * Objetivo
 *
 * Este exercicio reune praticamente todos os conceitos estudados sobre arrays multidimensionais.
 */
public class MatrizEEstatisticas {
    public static void main(String[] args) {
        //declaracao
        int[][] matriz = new int[][]{
                                        { 1,  2,  3,  4,  5},
                                        { 7,  8,  9, 10, 11},
                                        {12, 13, 14, 15, 16},
                                        {17, 18, 19, 20, 21},
                                        {21, 22, 23, 24, 25},
                                    };
        int somaDosElementos = 0;
        int quantidadeDeElementos = 0;
        double media;
        int quantidadePares = 0;
        int quantidadeImpares = 0;
        int somaDiagonalPrincipal = 0;
        int somaDiagonalSegundaria = 0;
        int menorValor = matriz[0][0];
        int maiorValor = matriz[0][0];
        int[][] posicaoMaiorValor = new int[][]{{1, 1}};
        int[][] posicaoMenorValor = new int[][]{{1, 1}};

        // processamento
        for(int linha = 0; linha < matriz.length; linha++){
            for(int coluna = 0; coluna < matriz[linha].length; coluna++){
                // menor valor
                if(matriz[linha][coluna] < menorValor){
                    menorValor = matriz[linha][coluna];
                    posicaoMenorValor[0][0] = linha;
                    posicaoMenorValor[0][1] = coluna;
                }

                // maior valor
                if(matriz[linha][coluna] > maiorValor){
                    maiorValor = matriz[linha][coluna];
                    posicaoMaiorValor[0][0] = linha;
                    posicaoMaiorValor[0][1] = coluna;
                }

                // soma dos elementos
                somaDosElementos += matriz[linha][coluna];
                // contagem dos elementos
                quantidadeDeElementos++;

                // pares
                if(matriz[linha][coluna] % 2 == 0){
                    quantidadePares++;
                }

                // impares
                if(matriz[linha][coluna] % 2 != 0){
                    quantidadeImpares++;
                }

                // diagonal principal
                if(linha == coluna){
                    somaDiagonalPrincipal += matriz[linha][coluna];
                }

                // diagonal secundaria
                if(linha == matriz.length - coluna - 1){
                    somaDiagonalSegundaria += matriz[linha][coluna];
                }

            }
        }

        //media
        media = (double) somaDosElementos / quantidadeDeElementos;

        // apresentacao
        System.out.println("1. Matriz Completa");
        for(int linha = 0; linha < matriz.length; linha++){
            for(int coluna = 0; coluna < matriz[linha].length; coluna++){
                System.out.printf("%2d   ", matriz[linha][coluna]);
            }
            System.out.printf("%n");
        }
        System.out.printf("%n2. Maior valor: %d", maiorValor);
        System.out.printf("%n3. Menor valor: %d", menorValor);
        System.out.printf("%n4. Soma de todos os elementos: %d",
                somaDosElementos);
        System.out.printf("%n5. Media: %.2f", media);
        System.out.printf("%n6. Quantidade de numeros pares: %d",
                quantidadePares);
        System.out.printf("%n7. Quantidade de numeros impares: %d",
                quantidadeImpares);
        System.out.printf("%n8. Soma da diagonal principal: %d",
                somaDiagonalPrincipal);
        System.out.printf("%n9. Soma da diagonal secundaria: %d",
                somaDiagonalSegundaria);
        System.out.printf("%n10. Posicao do maior valor: %d, %d",
                posicaoMaiorValor[0][0], posicaoMaiorValor[0][1]);
        System.out.printf("%n11. Posicao do menor valor: %d, %d",
                posicaoMenorValor[0][0], posicaoMenorValor[0][1]);

        System.out.printf("%n");
    }
}
