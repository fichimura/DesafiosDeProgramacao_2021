 */
/**
*@author Fábio Kiyoshi Ichimura
*@author Pedro Araújo Sousa
**/
import java.util.Scanner;
import java.util.LinkedList;
import java.io.*;
import java.util.*;

public class Desafio3 {
    public static LinkedList<String> readFromStdin() {
        LinkedList<String> total = new LinkedList<String>();

        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            total.add(sc.nextLine());
        }
        sc.close();

        return total;
    }

    public static boolean parenthesisBalance(String operacao){
        //cria uma pilha que irá armazenar todos os caracteres da operação de entrada
        Stack<Character> pilhaDeCaracteres = new Stack<Character>();

        //perccorre todos os carcteres da operacao
        for(int i = 0; i < operacao.length(); i++){
            //caractere que esta sendo iterado
            char elemento = operacao.charAt(i);

            //se o elemento for uma chave aberta coloca na pilhaDeCaracteres
            if(elemento == '('){
                pilhaDeCaracteres.push(elemento);
            }

            //se o elemento for ')' então será analisado se a pilha não está vazia.
            //Se não estiver vazia, retira o último elemento da pilha
            //Caso contrário, se estiver vazia coloca o ')'
            if(elemento == ')'){
                if(!pilhaDeCaracteres.isEmpty()){
                    pilhaDeCaracteres.pop();
                }else{
                    pilhaDeCaracteres.push(elemento);
                }
            }


        }
        //se ao final estiver vazia quer dizer que a condição de retorno é verdadeira
        // e que todos os '(' possuem um')' correspondente
        return pilhaDeCaracteres.isEmpty();
    }

    public static void main(String[] args) {
        LinkedList<String> linhas = readFromStdin();
        for (String l : linhas) {
            //verifica se a condição dos parenteses poropsta é satisfeita
            if(parenthesisBalance(l)){
                System.out.println("correct");
            }else{
                System.out.println("incorrect");
            }
        }


    }

}