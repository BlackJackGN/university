package Exercises.arrays;
import java.util.*;
import java.util.random.RandomGenerator;

public class FillArray {
    public static double[] fillArray(int l,double value, boolean addNoise){
        double[] ris=new double[l];
        Arrays.fill(ris,value);
        RandomGenerator rng= RandomGenerator.getDefault();
        for(int i=0;i<l;i++){
            ris[i]=rng.nextDouble();
        }
        return ris;
    }
    public static void main(String[] args){
        System.out.println(Arrays.toString(fillArray(5,10,true)));
    }
}