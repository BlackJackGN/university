package ProveDiCodice.ProgrammazioneFunzionale;

public class PF {
    /**
     * questa interfaccia funzionale prende in ingresso un tipo_p T e restituisce un K
     * @param <T>
     * @param <K>
     */
    @FunctionalInterface
    public interface Funzione_Apply<T,K>{
        K apply(T t);
    }
    public void application_of_FI(){
        Funzione_Apply<Integer,Integer> sum = x -> x+1;
        System.out.println(sum.apply(3));
    }

    @FunctionalInterface
    public interface tester<T>{
        boolean test(T t,T q);
    }
    public static void application_of_tester(Boolean q, Boolean z){
        tester<Boolean> prova = (x, y) -> x&&y;
        System.out.println(prova.test(q, z));
    }
    public static void main(String args[]){
        application_of_tester(true,true);

    }
}