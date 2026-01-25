package Exercises.arrays;
import java.lang.*;
import java.util.Arrays;

public class Splitter {
    public static int[] splitter(int numero){
        String sup=""+numero;
        String[] svet=sup.split((""));
        int[] ris=new int[svet.length];
        for(int i=0;i<svet.length;i++){
            ris[i]=Integer.parseInt(svet[i]);
        }
        return ris;
    }
    public static void main(String[] args){
        int num=3213;
        System.out.println(Arrays.toString(splitter(num)));
    }
}
