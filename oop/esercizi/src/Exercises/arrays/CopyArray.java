package Exercises.arrays;
import java.util.*;
public class CopyArray {

    public static double[] copyArray(double[] v){
        double[] n=new double[v.length];
        System.arraycopy(v,0,n,0,v.length);//ar pos iniz ar pos iniz length
        return n;
    }
    public static void main(String[] args){
        double[] v1={1,2,3};
        System.out.println(Arrays.toString(copyArray(v1)));
    }
}