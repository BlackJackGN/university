package Exercises.collections;
import java.util.*;
public class Intersection {
    public static Set<Integer> intersection(Set<Integer> first, Set<Integer> second){
        Set<Integer>itr=new HashSet<>();
        for(int item:first){
            if(second.contains(item)){
                itr.add(item);
            }
        }
        return itr;
    }
    public static Set<Integer> intersectionRetainAll(Set<Integer> first, Set<Integer> second){
        Set<Integer>itr=new HashSet<>(first);
        itr.retainAll(second);
        return itr;
    }
}