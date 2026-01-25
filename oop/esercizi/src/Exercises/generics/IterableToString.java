package Exercises.generics;

public class IterableToString {
    public static <E> String iteralbleToString(Iterable<E> src){
        StringBuilder s=new StringBuilder();
        for(E src_i: src){
            s.append(src_i).append(", ");
        }
        return s.toString();
    }
}