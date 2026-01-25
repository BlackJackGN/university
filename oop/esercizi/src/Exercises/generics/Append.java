package Exercises.generics;
import java.util.*;

public class Append {
    public static <T> void append(List<T> dst, List<T> src){
        dst.addAll(src);
    }
    public static <T> void appendBounded(List<T> dst, List<? extends T> src) {
        dst.addAll(src);
    }
}