import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class OrdenaStrings {

    public static void main(String[] args) {
        //Métodos Default, um método dentro da interface que possui corpo
        //Ajuda a diminuir a verbosidade do código e a evoluir uma interface de modo que outras classes que já a implementem não quebrem a compatibilidade
        List<String> palavras = new ArrayList<>();
        palavras.add("Astro");
        palavras.add("Cometa");
        palavras.add("Cratera");

        Comparator<String> comparador = new ComparadorDeStringPorTamanho();
        //Método Default
        palavras.sort(comparador);
        System.out.println(palavras);

        //Forma antiga do Java 7
        for (String palavra: palavras) {
            System.out.println(palavra);
        }
        //foreach, Consumer e interfaces no java.util.functions
        Consumer<String> consumidor = new ConsumidorDeString();
        palavras.forEach(consumidor);
    }

}

class ComparadorDeStringPorTamanho implements Comparator<String> {
    public int compare(String s1, String s2) {
        if(s1.length() < s2.length())
            return -1;
        if(s1.length() > s2.length())
            return 1;
        return 0;
    }
}

class ConsumidorDeString implements Consumer<String> {
    public void accept(String s) {
        System.out.println(s);
    }
}