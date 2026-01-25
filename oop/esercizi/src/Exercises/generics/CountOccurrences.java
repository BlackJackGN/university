package Exercises.generics;
import java.util.*;

public class CountOccurrences {
    public static <T> int countOccurrencesPlain(T[] src, T item){
        int i=0;
        if(item==null){
            for(T src_i:src){
                if(src_i==null){
                    i++;
                }
            }
        }
        for(T src_i:src){
            assert item != null;
            if(item.equals(src_i)){
                i++;
            }
        }
        return i;
    }
    public static <T> int countOccurrencesObjects(T[] src, T item){
        int i=0;
        for(T src_i:src){
            if(Objects.equals(item, src_i)){
                i++;
            }
        }
        return i;
    }
}