/*Temos um vetor de N inteiros distintos e dois inteiros I e F.
 Precisamos computar quantos pares desses inteiros do vetor somam pelo menos I e no máximo F.
 Por exemplo, se o vetor for [45, 12, 11, 7, 83, 29, 5] e I = 19 e F = 52,
 temos exatamente 8 pares cuja soma está entre 19 e 52:
 {5, 29}, {5, 45}, {7, 12}, {7, 29}, {7, 45}, {11, 12}, {11, 29} e {12, 29}.

        Entrada
        A primeira linha da entrada contém três inteiros N, I e F,
        indicando respectivamente o tamanho do vetor e o valor mínimo
        da soma e o valor máximo da soma.

        Saída
        Seu programa deve imprimir uma única linha contendo um inteiro indicando
        quantos pares de inteiros no vetor somam pelo menos I e no máximo F.

        Restrições

        • 2 ≤ N ≤ 1000

        • −2000 ≤ I, F ≤ 2000

        • O valor de cada inteiro no vetor está entre −1000 e 1000

        • Os inteiros no vetor são distintos

*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
*@author Fábio Kiyoshi Ichimura
*@author Pedro Araújo Sousa
**/

public class Desafio2 {

    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);

        //entrada das condições
        String linha = br.readLine();
        String [] separacao = linha.split(" ");
        int N = Integer.parseInt(separacao[0]);
        int I = Integer.parseInt(separacao[1]);
        int F = Integer.parseInt(separacao[2]);

        String vetor;
        String [] vetorSeparado;
        int[] a = new int[N];
        int quantidade = 0;


        if((N >= 2) && (N <= 1000) && (I >= -2000) && (F <= 2000)){
            vetor = br.readLine();
            vetorSeparado = vetor.split(" ");
            //entrada dos  valores do vetor
            for(int i = 0; i < N; i++){
                a[i] = Integer.parseInt(vetorSeparado[i]);
            }

            //será analisado o inteiro a[i], e este será comparado com os j valores restantes do vetor,
            // sendo que só será acrescido a quantidade se a soma satisfazer as condições impostas pelo
            //enunciado
            for (int i = 0; i < N; i++){
                for(int j = i; j < N; j++){
                    if(a[i] != a[j]) {
                        if ((a[i] + a[j] >= I) && (a[i] + a[j] <= F)) {
                            quantidade += 1;
                        }
                    }
                }
            }

            System.out.println(quantidade);
        }
    }
}
