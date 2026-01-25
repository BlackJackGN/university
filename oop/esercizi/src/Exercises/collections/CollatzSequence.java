package Exercises.collections;

import java.util.*;

public class CollatzSequence {
    public static List<Long> collatzSequence(long n){
        if(n<1){
            return new ArrayList<>();
        }
        List<Long>seq=new ArrayList<>(List.of(n));
        while(n!=1){
            if(n%2==0){
                n/=2;
            }else{
                n=n*3+1;
            }
            seq.add(n);
        }
        return seq;
    }
}