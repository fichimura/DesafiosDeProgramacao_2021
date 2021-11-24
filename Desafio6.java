import java.util.Scanner;


/**
*@author Fábio Kiyoshi Ichimura
*@author Pedro Araújo Sousa
**/


public class Desafio6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            //numero de corredores
            int n = sc.nextInt();
            //arrays com o inicio e o final das posicoes dos corredores
            int[] runnersStart = new int[n];
            int[] runnersFinish = new int[n];

            //para insercao das posicoes
            for (int i = 0; i < n; i++) {
                runnersStart[i] = sc.nextInt();
            }

            //para insercao das posicoes
            for (int i = 0; i < n; i++) {
                runnersFinish[i] = sc.nextInt();
            }

            //chama a funcao countOvertakes, que irá contar quantas ultrapasssagens ocorreram
            System.out.println(countOvertakes(runnersStart, runnersFinish));

        }
    }

    //funcao para contar quantas ultrapasagens ocorreram, passando os arrays de posicoes iniciais e finais
    public static int countOvertakes(int[] runnersStart, int[] runnersFinish) {
        int count = 0;
        //faz-se um loop for para ir comparando do final para o inicio
        for (int i = runnersStart.length - 1; i > 0; i--) {
            //inteiro que é o indice do numero da iteracao no array runnersFinish
            int compareStart = findPositionFinal(runnersStart[i], runnersFinish);
            //este loop for comeca de i-1, pois vamos comparar com o elemento que está na frente em runnerStart
            for (int j = i - 1; j >= 0; j--) {
                //inteiro que é o indice do numero da iteracao no array runnersFinish
                int compareFinish = findPositionFinal(runnersStart[j], runnersFinish);

                //se o na lista finais de posicao, as pocicoes se alteraram de acordo com a condicao, entao aumenta o contador
                if(compareFinish > compareStart) count++;
            }
        }
        return count;
    }

    //funcao para achar o indice de um numero no array de posicoes final
    public static int findPositionFinal(int x, int[] runnersFinal) {
        //percorre o array inteiro
        for (int i = 0; i < runnersFinal.length; i++) {
            //se achar retorna o índice i
            if (runnersFinal[i] == x) {
                return i;
            }
        }
        //se não achar retorna -1
        return -1;
    }
}
