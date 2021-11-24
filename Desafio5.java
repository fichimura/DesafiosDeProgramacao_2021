import java.util.*;

 */
/**
*@author Fábio Kiyoshi Ichimura
*@author Pedro Araújo Sousa
**/


public class Desafio5{

    static String[] fraseOriginal;
    static ArrayList<String> fraseOrdenada = new ArrayList<>();
    static Map<String, String> palavrasAbreviadas = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()){
            //"limpa" o map pra cada iteração
            palavrasAbreviadas.clear();

            //pega a frase a ser analisada
            String frase = sc.nextLine();

            //se tiver o caracter de parada sai
            if(frase.equals(".")) break;

            //separa as palavras no array fraseOriginal
            fraseOriginal = frase.split(" ");
            fraseOrdenada = new ArrayList<>(Arrays.asList(fraseOriginal));

            //ordena as palavras em ordem alfabetica
            Collections.sort(fraseOrdenada);

            while(true){
                //funcao para encontrar palavra para abreviar
                paraAbreviar(fraseOrdenada.get(0).charAt(0));

                //se fraseOrdenada contiver apenas um elemento e este tiver tamanho maior do que 2
                //adiciona em palavrasAbreviadas a chave e o valor abreviado
                if(fraseOrdenada.size() == 1 && fraseOrdenada.get(0).length() > 2){
                    palavrasAbreviadas.put(fraseOrdenada.get(0), fraseOrdenada.get(0).charAt(0) + ".");
                    break;
                }

                if(fraseOrdenada.size() == 0){
                    break;
                }

            }


            for(int i = 0; i < fraseOriginal.length; i++){
                //se a chave de palavrasAbreviadas for igual a string na posicao i de fraseOriginal
                //imprime a palavra abreviada
                if(palavrasAbreviadas.containsKey(fraseOriginal[i])){
                    System.out.print(palavrasAbreviadas.get(fraseOriginal[i]));
                }
                //se nao entao imprime a palavra normal
                else{
                    System.out.print(fraseOriginal[i]);
                }

                if((i + 1) != fraseOriginal.length) System.out.print(" ");
            }

            System.out.println();

            //para imprimir a quantidade de palavras abreviadas
            System.out.println(palavrasAbreviadas.size());

            //cria um novo Map para as palavras que foram abreviadas
            Map<String, String> palavrasComAbreviacao = new TreeMap<>(palavrasAbreviadas);


            Iterator it = palavrasComAbreviacao.entrySet().iterator();

            //iteracao para printar as abreviacoes e suas palavras correspondentes, atraves de chave e valor
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry) it.next();

                System.out.println(pair.getValue() + " = " + pair.getKey());
            }
        }
    }


    private static void paraAbreviar(char primeiraLetra) {
        int tamanho = 0;
        String palavraParaAbreviar = "";

        //enquanto as strings possuirem o mesmo caracter de inicio
        while(fraseOrdenada.get(0).charAt(0) == primeiraLetra){

            //para ver quantas ocorrencias a string possui
            int ocorrencias = achaOcorrencia(fraseOrdenada.get(0));

            //se a string possuir menos dois(pois, de resultar em 0 não devemos abreviar) multiplicado
            //pelas ocorrencias forem maiores do que o tamanho, entao a palavraParaAbreviar sera atualizada
            if((fraseOrdenada.get(0).length() - 2) * ocorrencias > tamanho){
                tamanho = (fraseOrdenada.get(0).length() - 2) * ocorrencias;

                palavraParaAbreviar = fraseOrdenada.get(0);
            }

            fraseOrdenada.remove(0);

            //se nao possuir string em fraseOrdenada sai do loop
            if(fraseOrdenada.size() == 0) break;
        }

        //se houver palavraParaAbreviar então coloca chave e valor em palavrasAbreviadas
        if(!palavraParaAbreviar.isEmpty()){
            palavrasAbreviadas.put(palavraParaAbreviar, palavraParaAbreviar.charAt(0) + ".");
        }
    }

    //conta quantas vezes a string ocorre na frase
    private static int achaOcorrencia(String praAnalizar) {
        //contador
        int cont = 0;

        //um for each para ver se a string possui quantas ocorrencias em fraseOrdenada
        for(String s: fraseOrdenada){
            if(s.equals(praAnalizar)) {
                cont++;
            }
        }

        return cont;
    }
}


/*
hoje eu visitei meus pais
tive que lavar meu cachorro pois ele estava fedendo
.
abcdef abc abc abc
abcd abc abc abc
abcd abcd abc abc abc
.
 */
