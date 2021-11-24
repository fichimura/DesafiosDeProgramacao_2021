import java.util.Arrays;
import java.util.Scanner;
public class Ep2969 {
    private final int Infinity = 100000;
    int vertices;
    int edges;
    Planet[] planets;
    Order[] coldest;
    Order[] hottest;
    int[][] distance;

    private static class Planet implements Comparable<Planet> {
        //Os planetas vao ser ordenados pela temperatura portanto vamos guardar os índices
        //originais
        int index;
        int temperatures;

        //Construtor
        Planet(int index, int temperatures) {
            this.index = index;
            this.temperatures = temperatures;
        }

        //Comparar planetas para ordenação
        public int compareTo(Planet p2) {
            return this.temperatures - p2.temperatures;
        }
    }

    private static class Order implements Comparable<Order> {
        //Os pedidos vão ser separados e ordenados portanto vamos guardar
        // os índices originais
        int index;
        int start;
        int end;
        int k;  //As primeiras ord temperaturas
        int type;   //type == 0, primeiras mais frias, type == 1, primeiras mais quentes

        //Construtor
        Order(int index, int start, int end, int k, int type) {
            this.index = index;
            this.start = start;
            this.end = end;
            this.k = k;
            this.type = type;
        }

        //Comparar planetas para ordenação
        @Override
        public int compareTo(Order o2) {
            return this.k - o2.k;
        }
    }

    private void init(Scanner sc) {
        //Grava as temperaturas de cada um dos planetas
        planets = new Planet[vertices];
        for (int i = 0; i < vertices; i++) planets[i] = new Planet(i, sc.nextInt());

        //Grava as distâncias dos planetas em uma matriz de adjacências
        distance = new int[vertices][vertices];
        for (int[] d : distance) Arrays.fill(d, Infinity);
        for (int i = 0; i < vertices; i++) distance[i][i] = 0;
        for (int i = 0; i < edges; i++) {
            int start = sc.nextInt() - 1, end = sc.nextInt() - 1, d = sc.nextInt();
            distance[start][end] = d;
            distance[end][start] = d;
        }
        //Grava os pedidos em ordem
        int nOrders = sc.nextInt();
        Order[] c = new Order[nOrders];
        Order[] h = new Order[nOrders];
        int indC = 0, indH = 0;
        //Separando os pedidos entre os 2 tipos
        for (int i = 0; i < nOrders; i++) {
            int start = sc.nextInt() - 1, end = sc.nextInt() - 1, k = sc.nextInt(), type = sc.nextInt();
            if (type == 0) {
                c[indC] = new Order(i, start, end, k, type);
                indC++;
            } else {
                h[indH] = new Order(i, start, end, k, type);
                indH++;
            }
        }
        coldest = new Order[indC];
        hottest = new Order[indH];
        System.arraycopy(c, 0, coldest, 0, indC);
        System.arraycopy(h, 0, hottest, 0, indH);
        //Primeiro ordenando os planetas em funcao da temperatura e testando o tipo = 0
        //TimSort realiza uma ordenação com O(n(log(n))
        Arrays.sort(planets);
        //Ordenando os pedidos pela restrição de planetas, do maior até a menor, de cada um dos pedidos
        Arrays.sort(hottest);
        Arrays.sort(coldest);

    }
}
