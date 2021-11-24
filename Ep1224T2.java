import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ep1224T2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(new BufferedInputStream(System.in));

        while (sc.hasNext()) {
            int n = sc.nextInt();
            List<Integer> cards = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                cards.add(sc.nextInt());
            }

            //pares são o alberto impares sao o wanderley
            int turns = 0;
            //soma do quanto o alberto conseguiu
            int sum = 0;
            while(!cards.isEmpty()){
                if(turns % 2 == 0 ){
                    if(ultimoMaior(cards)){
                        if(cards.get(0) > cards.get(cards.size() - 1)) {
                            int remove = indexUltimoMaiorEsquerda(cards);
                            sum += cards.get(remove);
                            cards.remove(remove);
                        }else{
                            int remove = indexUltimoMaiorDireita(cards);
                            sum += cards.get(remove);
                            cards.remove(remove);
                        }
                    }
                    if(penultimoMaior(cards)){
                        if(cards.get(1) > cards.get(cards.size() - 2)) {
                            int remove = indexPenultimoMaiorEsquerda(cards);
                            sum += cards.get(remove);
                            cards.remove(remove);
                        }else{
                            int remove = indexPenultimoMaiorDireita(cards);
                            sum += cards.get(remove);
                            cards.remove(remove);
                        }
                    }
                    turns++;
                    continue;
                }
                if(ultimoMaior(cards)){
                    if(cards.get(0) > cards.get(cards.size() - 1)) {
                        int remove = indexUltimoMaiorEsquerda(cards);
                        sum += cards.get(remove);
                        cards.remove(remove);
                    }else{
                        int remove = indexUltimoMaiorDireita(cards);
                        sum += cards.get(remove);
                        cards.remove(remove);
                    }
                }
                if(penultimoMaior(cards)){
                    if(cards.get(1) > cards.get(cards.size() - 2)) {
                        int remove = indexPenultimoMaiorEsquerda(cards);
                        sum += cards.get(remove);
                        cards.remove(remove);
                    }else{
                        int remove = indexPenultimoMaiorDireita(cards);
                        sum += cards.get(remove);
                        cards.remove(remove);
                    }
                }

                turns++;
            }
            System.out.println(sum);
        }
    }

    public static boolean ultimoMaior(List cards) {
        if (!cards.isEmpty()) {
            if ((Integer) cards.get(1) < (Integer) cards.get(0)) {
                return true;
            }
        }
        if((cards.size() - 2 > 0 ) && (cards.size() - 1 > 0)) {
            if ((Integer) cards.get(cards.size() - 2) < (Integer) cards.get(cards.size() - 1)) {
                return true;
            }
        }
        return false;
    }

    public static int indexUltimoMaiorDireita(List cards) {
        if((cards.size() - 2 > 0) && (cards.size() - 1 > 0)) {
            if ((Integer) cards.get(cards.size() - 2) < (Integer) cards.get(cards.size() - 1)) {
                return cards.size() - 1;
            }
        }
        return -1;
    }

    public static int indexUltimoMaiorEsquerda(List cards) {
        if (cards.size() > 2) {
            if ((Integer) cards.get(1) < (Integer) cards.get(0)) {
                return 0;
            }
        }
        return -1;
    }

    public static boolean penultimoMaior(List cards) {
        if (cards.size() > 2) {
            if ((Integer) cards.get(1) > (Integer) cards.get(0)) {
                return true;
            }
            if((cards.size() - 2 > 0) && (cards.size() - 1 > 0)) {
                if ((Integer) cards.get(cards.size() - 2) > (Integer) cards.get(cards.size() - 1)) {
                    return true;
                }
            }
        }
        return false;
    }


    public static int indexPenultimoMaiorEsquerda(List cards) {
        if (cards.size() > 2) {
            if ((Integer) cards.get(1) > (Integer) cards.get(0)) {
                return 1;
            }
        }
        return -1;
    }

    public static int indexPenultimoMaiorDireita(List cards) {
        if((cards.size() - 2 > 0) && (cards.size() - 1 > 0)) {
            if ((Integer) cards.get(cards.size() - 2) > (Integer) cards.get(cards.size() - 1)) {
                return cards.size() - 2;
            }
        }
        return -1;
    }


}
