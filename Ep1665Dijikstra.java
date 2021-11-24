import java.util.Scanner;

public class Ep1665Dijikstra {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()){
            int n = sc.nextInt();
            if(n == 0) continue;
            int m = sc.nextInt();

            //probabilidade aqui é uma matriz que associa a probabilidade de cada aresta
            double probabilidade[][] = new double[n][n];

            /* Para lembrar que o java faz isso automaticamente,
            mas que para o nosso caso precisamos de valores zerados para as comparações futuras*/
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    probabilidade[i][j] = 0;
                }
            }

            for(int j = 0; j < m; j++){//O(n)
                //a e b são os pontos finais de uma rua
                int a = sc.nextInt();
                int b = sc.nextInt();
                //probabilidade de passar pela rua sem ser pego
                int p = sc.nextInt();

                //como o probabilidade é representado em uma matriz das probabilidades, portanto
                //para cada rua os dois pontos finais são atribuidos as respectivas probabilidades
                probabilidade[a-1][b-1] = p * 0.01;
                probabilidade[b-1][a-1] = p * 0.01;
            }
            dijkstraAdaptado(probabilidade, 0);

        }
    }

    public static void dijkstraAdaptado(double grafo[][], int src) {
        double dist[] = new double[grafo.length]; // The output array. dist[i] will hold
        // the shortest distance from src to i

        // sptSet[i] will true if vertex i is included in shortest
        // path tree or shortest distance from src to i is finalized
        Boolean sptSet[] = new Boolean[grafo.length];

        // Initialize all distances as INFINITE and stpSet[] as false
        for (int i = 0; i < grafo.length; i++) {
            dist[i] = grafo[0][i];
            sptSet[i] = false;
        }

        // Distance of source vertex from itself is always 0
        //dist[src] = 0;

        // Find shortest path for all vertices
        for (int count = 0; count < grafo.length - 1 ; count++) {
            if(count > 1){
                for (int i = 0; i < grafo.length; i++) {
                    dist[i] = grafo[count][i];
                    sptSet[i] = false;
                }
            }
            // Pick the minimum distance vertex from the set of vertices
            // not yet processed. u is always equal to src in first
            // iteration.
            int u = maxDistance(dist, sptSet, grafo.length);

            // Mark the picked vertex as processed
            sptSet[u] = true;

            // Update dist value of the adjacent vertices of the
            // picked vertex.
            for (int v = 0; v < grafo.length; v++)

                // Update dist[v] only if is not in sptSet, there is an
                // edge from u to v, and total weight of path from src to
                // v through u is smaller than current value of dist[v]
                if (!sptSet[v] && dist[u] * grafo[u][v] > dist[v])
                    dist[v] = dist[u] * grafo[u][v];
        }
        // print the constructed distance array
        printSolution(dist, grafo.length);
    }

    public static int maxDistance(double dist[], Boolean sptSet[], int n) {
        // Initialize min value
        double max = 0;
        int max_index = -1;

        for (int v = 0; v < n; v++) {
            if (sptSet[v] == false && dist[v] >= max) {
                max = dist[v];
                max_index = v;
            }
        }

        return max_index;
    }


    // A utility function to print the constructed distance array
    public static void printSolution(double dist[], int n) {
        double result = 1;
        for (int i = 0; i < n; i++){
            result *= dist[i];
        }
        System.out.format("\n%.6f percent", result);
    }
}
