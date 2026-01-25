package Exercises.functional;
import java.util.*;
import java.util.stream.*;

public class ToString {
    public static <T> String toString(Stream<T> stream, int n){
        return stream.limit(n).map(String::valueOf).collect(Collectors.joining(","));
    }
}