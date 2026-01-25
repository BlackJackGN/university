package Exercises.collections;
import java.util.*;
public class Union {
    public static Set<Integer> union(Set<Integer> first, Set<Integer> second){
        Set<Integer> union=new HashSet<>(first);
        for(Integer item:second){
            union.add(item);
        }
        return union;
    }
    public static Set<Integer> unionAddAll(Set<Integer> first, Set<Integer> second){
        Set<Integer> set=new HashSet<>(first);
        set.addAll(second);
        return set;
    }
}