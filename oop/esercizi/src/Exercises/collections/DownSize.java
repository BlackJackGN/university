package Exercises.collections;

import java.util.*;

public class DownSize {
    public static void downsize(List<String> list, int n){
        int i=1;
        for(Iterator<String>it= list.iterator(); it.hasNext();){
            it.next();
            if((i+1)%n==0){
                it.remove();
            }
        }
    }
}