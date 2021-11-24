import java.io.BufferedInputStream;
import java.util.Scanner;
import java.io.IOException;
import java.util.Scanner;

public class Desafio10 {



    public static class Main {
        static boolean escada(int matriz[][],int i, int j){
            for(int x = 0; i > x;x++){
                for (int y =0;j>y;y++){
                    if(matriz[x][y] != 0){
                        if(x > 0){
                            boolean zerou = false;
                            for(int l = x-1;l>=0;l--){
                                boolean linha_zerada = true;
                                for (int u =0;j>u;u++){
                                    if(matriz[l][u]!=0){
                                        linha_zerada = false;
                                    }
                                }
                                if(linha_zerada == true){
                                    zerou = true;
                                    break;
                                }
                            }
                            if(zerou == true){
                                System.out.println("N");
                                return false;
                            }
                            if(x+1<i && zerou == false){
                                for(int z = x+1; i > z;z++){
                                    if(matriz[z][y] != 0){
                                        System.out.println("N");
                                        return false;
                                    }
                                }
                                x++;
                            }
                        }
                    }
                }
            }
            System.out.println("S");
            return true;
        }
        public static void main(String[] args) throws IOException {
            Scanner sc = new Scanner(System.in);
            int i = sc.nextInt();
            int j = sc.nextInt();
            int matriz[][]= new int[i][j];
            for(int x = 0; i > x;x++){
                for (int y =0;j>y;y++){
                    matriz[x][y] = sc.nextInt();
                }
            }
            escada(matriz,i,j);
        }

    }



}
