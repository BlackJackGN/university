import InsString.*;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("\nInserire una parola: ");
        String p=s.nextLine();
        String q=InsString.insStringa("nProva di funzione, inserisci qualcosa: ");
        System.out.println("\nParola 1: "+p+", Parola 2: "+q);
    }
}