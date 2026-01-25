package Exercises.functional;

import java.util.*;
import java.util.function.*;

public class JustPrintParametrized {
    public static <T> void justPrintList(List<T>list, Consumer<T>consumer){
        list.forEach(consumer);
    }
    public static <K,V> void justPrintMap(Map<K,V>map,BiConsumer<K,V>biconsumer){
        map.forEach(biconsumer);
    }
}