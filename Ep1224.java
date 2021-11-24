import java.io.BufferedInputStream;
import java.util.*;

public class Ep1224 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));

        while (sc.hasNext()) {
            int n = sc.nextInt();
            List<Long> cards = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                cards.add(sc.nextLong());
            }

            find4Numbers(cards, cards.size(), 2157100026L);

            //pares são o alberto impares sao o wanderley
            int turns = 0;
            //soma do quanto o alberto conseguiu
            long sum = 0;
            while(!cards.isEmpty()){
                if(turns % 2 == 0 ){
                    sum = indexOfAlberto(cards, sum);
                    //System.out.println(cards);
                    turns++;
                    continue;
                }
                indexOfWanderlay(cards);
                //System.out.println(cards);
                turns++;
            }
            //System.out.println(cards);
            //System.out.println(sum);
        }

    }

    public static boolean tipIsGreater(List cards){
        if(!cards.isEmpty()) {
            if (cards.size() >= 2) {
                if((long)cards.get(0) > (long) cards.get(1) && (long) cards.get(0) > (long)cards.get(cards.size() - 2)){
                    return true;
                }else if((long)cards.get(cards.size() - 1) > (long)cards.get(cards.size() - 2) && (long)cards.get(cards.size() - 1) > (long)cards.get(1)){
                    return true;
                }else{
                    return false;
                }
            }else return cards.size() == 1;
        }else{
            return false;
        }
    }

    public static int indexOfNextLastGreater (List cards){
        if(cards.size() - 1 > 0) {
            if ((long) cards.get(1) > (long) cards.get(0)) return 1;
            else if((long) cards.get(cards.size() - 2) > (long) cards.get(cards.size() - 1) ) return cards.size() - 2;
        }
        return -1;
    }

    public static int indexOfThreeLast(List cards){
        if(cards.size() == 3){
            if((long)cards.get(0) > (long) cards.get(cards.size() - 1)){
                return 0;
            }else
                return cards.size() - 1;
        }
        return -1;
    }


    public static long indexOfAlberto(List cards, long sum){
        if(!cards.isEmpty()) {
            if (tipIsGreater(cards)) {
                if (cards.size() != 3) {
                    if ((long) cards.get(0) > (long) cards.get(cards.size() - 1)) {
                        //System.out.println("b");
                        sum += (long) cards.get(0);
                        cards.remove(0);
                        return sum;
                    } else if ((long) cards.get(0) < (long) cards.get(cards.size() - 1)) {
                        sum += (long) cards.get(cards.size() - 1);
                        cards.remove(cards.size() - 1);
                        return sum;
                    } else {
                        //System.out.println("c");
                        sum += (long) cards.get(0);
                        cards.remove(0);
                        return sum;
                    }
                } else if(cards.size() == 3){
                    //System.out.println("a");
                    int remove = indexOfThreeLast(cards);
                    sum += (long) cards.get(remove);
                    cards.remove(remove);
                    return sum;
                }else if(cards.size() == 1){
                    //System.out.println("d");
                    sum += (long) cards.get(0);
                    cards.remove(0);
                    return sum;
                }
            } else {
                if (cards.size() != 3) {
                    if (indexOfNextLastGreater(cards) == 1) {
                        sum += (long) cards.get(cards.size() - 1);
                        cards.remove(cards.size() - 1);
                        return sum;
                    } else if (indexOfNextLastGreater(cards) == cards.size() - 2) {
                        //System.out.println("e");
                        sum += (long) cards.get(0);
                        cards.remove(0);
                        return sum;
                    }
                } else if(cards.size() == 3) {
                    int remove = indexOfThreeLast(cards);
                    sum += (long) cards.get(remove);
                    cards.remove(remove);
                    return sum;
                }

                if(cards.size() == 1){
                    //System.out.println("f");
                    sum += (long) cards.get(0);
                    cards.remove(0);
                    return sum;
                }

            }
            return sum;
        }
        return sum;
    }

    public static void indexOfWanderlay(List cards){
        if(!cards.isEmpty()) {
            if (tipIsGreater(cards)) {
                if ((long) cards.get(0) > (long) cards.get(cards.size() - 1)) {
                    cards.remove(0);
                } else {
                    cards.remove(cards.size() - 1);
                }
            } else {
                if (cards.size() != 3) {
                    if (indexOfNextLastGreater(cards) == 1) {
                        cards.remove(cards.size() - 1);
                    } else if (indexOfNextLastGreater(cards) == cards.size() - 1) {
                        cards.remove(0);
                    }
                } else {
                    int remove = indexOfThreeLast(cards);
                    cards.remove(remove);
                }
            }
        }
    }




    public static void find4Numbers(List A, int n, long X) {
        int l, r;

        // Sort the array in increasing order, using library
        // function for quick sort
        Collections.sort(A);

        /* Now fix the first 2 elements one by one and find
           the other two elements */
        for (int i = 0; i < n - 3; i++)
        {
            for (int j = i + 1; j < n - 2; j++)
            {
                // Initialize two variables as indexes of the first and last
                // elements in the remaining elements
                l = j + 1;
                r = n - 1;

                // To find the remaining two elements, move the index
                // variables (l & r) toward each other.
                while (l < r)
                {
                    if ((long)A.get(i) + (long)A.get(j) + (long)A.get(l) + (long)A.get(r) == X)
                    {
                        System.out.println((long)A.get(i)+" "+(long)A.get(j) +" "+(long)A.get(l)+" "+(long)A.get(r));
                        l++;
                        r--;
                    }
                    else if ((long)A.get(i) + (long)A.get(j) + (long)A.get(l) + (long)A.get(r) < X)
                        l++;
                    else // A[i] + A[j] + A[l] + A[r] > X
                        r--;
                } // end of while
            } // end of inner for loop
        } // end of outer for loop
    }

}
