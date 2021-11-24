/*Pedrinho está implementando o sistema de controle de pagamentos parcelados de uma grande empresa de
 cartão de crédito digital. Os clientes podem parcelar as compras sem juros no cartão, em até 18 vezes.
 Quando o valor V da compra é divisível pelo número P de parcelas que o cliente escolhe, todas as parcelas
 terão o mesmo valor. Por exemplo, se o cliente comprar um livro de V = 30 reais em P = 6 vezes, então as parcelas
 terão valores: 5, 5, 5, 5, 5 e 5. Mas se o valor da compra não for divisível pelo número de parcelas será preciso
 fazer um ajuste, pois a empresa quer que todas as parcelas tenham sempre um valor inteiro e somem no total
 , claro, o valor exato da compra. O que Pedrinho decidiu foi distribuir o resto da divisão de V por P igualmente
  entre as parcelas iniciais. Por exemplo, se a compra for de V = 45 e o número de parcelas for P = 7,
  então as parcelas terão valores: 7, 7, 7, 6, 6, 6 e 6. Quer dizer, como o resto da divisão de 45 por 7 é 3
 , então as 3 parcelas iniciais devem ter valor um real maior do que as 4 parcelas finais. Você precisa ajudar
 Pedrinho e escrever um programa que, dado o valor da compra e o número de parcelas, imprima os valores de cada
 parcela.

        Entrada
        A primeira linha da entrada contém um inteiro V , representando o valor da compra.
        A segunda linha da entrada contém um inteiro P, indicando o número de parcelas.

        Saída
        Seu programa deve imprimir P linhas, cada uma contendo um inteiro representando o valor de uma parcela.
         A i-ésima linha deve conter o valor da i-ésima parcela, para 1 ≤ i ≤ P, de acordo com o que
         Pedrinho decidiu.

        Restrições

        • 10 ≤ V ≤ 1000

        • 2 ≤ P ≤ 18

 */
/**
*@author Fábio Kiyoshi Ichimura
*@author Pedro Araújo Sousa
**/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class Desafio1 {
    public static void main(String[] args) throws IOException {
        //entrada de dados do sistema
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);

        int V, P;
        V = Integer.parseInt(br.readLine());
        P = Integer.parseInt(br.readLine());

        //verifica as restrições do enunciado, após verifica-se o valor dividido pelas parcelas
        // resulta em parcelas iguais, ou em diferentes. Se forem iguais so faz um loop for pra printar as parcelasiguais
        //caso contrário será acrescido em 1 unidade as (V % P) primeiras parcelas
        if ((V >= 10) && (V <= 1000) && (P >= 2) && (P <= 18)) {
            if (V % P == 0) {
                int valor_final = V / P;
                for (int i = 0; i < P; i++) {
                    System.out.println(valor_final);
                }
            } else {
                int valor_sem_incremento = V / P;
                int valor_com_incremento = valor_sem_incremento + 1;
                int modulo = V % P;
                for (int i = 0; i < modulo; i++) {
                    System.out.println(valor_com_incremento);
                }
                for (int i = 0; i < P - modulo; i++) {
                    System.out.println(valor_sem_incremento);
                }

            }

        }
    }
}
