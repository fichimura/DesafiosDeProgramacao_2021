import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Scanner;


public class Ep1655 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean reiterate = sc.hasNext();
        while(reiterate){
            //recebe os parametros n e m pelo scanner
            //n é o numero de interseccoes
            int n = sc.nextInt();
            if(n == 0) break;
            //m sao as m linha seguintes que contem as informaçoes das ruas, tambem sao as arestas do grafo
            int m = sc.nextInt();

            //probabilidade aqui é uma matriz que associa a probabilidade de cada aresta
            double probabilidade[][] = new double[n][n];

            /* Para lembrar que o java faz isso automaticamente,
            mas que para o nosso caso precisamos de valores zerados para as comparações futuras*/
            for(int i = 0; i < n; i++){//O(n)
                for(int j = 0; j < n; j++){
                    probabilidade[i][j] = 0;
                }
            }

            for(int j = 0; j < m; j++){//O(n)
                //a e b são os pontos finais de uma rua
                int a = sc.nextInt();
                if(a == 0)break;
                int b = sc.nextInt();
                //probabilidade de passar pela rua sem ser pego
                int p = sc.nextInt();

                //como o probabilidade é representado em uma matriz das probabilidades, portanto
                //para cada rua os dois pontos finais são atribuidos as respectivas probabilidades
                probabilidade[a-1][b-1] = p / 100.00;
                probabilidade[b-1][a-1] = p / 100.00;
            }
            //chama a funcao para achar o caminho mais seguro, ou seja aquele com maior
            // probabilidade de escaparem
            floydWarshallAdaptado(probabilidade);

            //printa a probabilidade com 6 casas decimais, como o enunciado pede
            double resultado = probabilidade[0][n-1] * 100;
            //usa o formato dos EUA, pois usa o ponto nos decimais como o enunciado pede
            DecimalFormat df = new DecimalFormat("#0.000000",
                    DecimalFormatSymbols.getInstance(Locale.US));
            reiterate = sc.hasNext();
            System.out.printf(df.format(resultado)+" percent" + (reiterate ?"\n":""), resultado);

        }
        sc.close();
    }

    public static void floydWarshallAdaptado(double matriz[][]){//O(n^3)
        for(int iteracao = 0; iteracao < matriz.length; iteracao++){//(O(n))
            for(int linha = 0; linha < matriz.length; linha++){//O(n)
                for(int coluna = 0; coluna < matriz.length; coluna++){//O(n)
                    //usa-se Math.max parar obter a maior probablidade associada
                    //no caso aqui é multiplicada matriz[linha][iteracao] * matriz[iteracao][coluna],
                    // pois precisamos operar sobre as probabilidades
                    matriz[linha][coluna] = Math.max(matriz[linha][coluna],
                            matriz[linha][iteracao] * matriz[iteracao][coluna]);
                    //como e sempre de 1 até n, podemos colcoar a condicao de parada
                    if((iteracao == matriz.length)&&(linha > 0)) break;
                }
            }
        }
    }

}
