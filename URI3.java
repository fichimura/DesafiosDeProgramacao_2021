import java.util.Arrays;
import java.util.Scanner;
import java.util.*;

public class URI3 {
    public static int qtd(String a) {
        int count = 0;
        for(int i = 0; i < a.length(); i++) {
            if(a.charAt(i) != ' ')
                count++;
        }
        return count;
    }
    public static void main(String[] args) {
        //Scanners e funções para a leitura da entrada
        Scanner sc = new Scanner(System.in);
        String entrada = sc.nextLine();
//       String[] palavras = entrada.split(" ");
        while(!entrada.equals(".")){
            String[] palavras = entrada.split(" ");
            LinkedList<Character> abrev = new LinkedList<Character>();
            LinkedList<String> nomes = new LinkedList<String>();
            LinkedList<Integer> tam = new LinkedList<Integer>();

            int i;
            for (i=0 ; i<palavras.length; i++){
                int tamanho = qtd(palavras[i]);
                char inicial = palavras[i].charAt(0);
                abrev.add(inicial);
                nomes.add(palavras[i]);
                tam.add(tamanho);
            }
            int z;
            for (z = 0; z <abrev.size() ;z++){
                if (z < abrev.size() - 1){
                    int x;
                    for (x = z+1; x <abrev.size() ;x++){
                        //char compara = abrev.get(x);
                        if (abrev.get(z).equals( abrev.get(x))){
                            int a = tam.get(z);
                            int b = tam.get(x);
                            if(a>b){
                                tam.set(x,-1);
                            }
                            if(a<b){
                                tam.set(z,-1);
                            }
                            if(a==b){
                                if(nomes.get(z).equals( nomes.get(x))){
                                    tam.set(z,-2);
                                }
                            }

                        }
                    }
                }

            }
            System.out.println("\nLigada " + abrev);
            System.out.println("\nLigada " + nomes);
            System.out.println("\nLigada " + tam);
            entrada = sc.nextLine();

        }

    }
}