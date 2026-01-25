package Exercises.functional;

import java.util.*;

public class JustPrint {
    public static <T> void justPrintList(List<T> list){
        list.forEach(s->System.out.println("Hello "+s+"!"));
    }
    public static <K,V> void justPrintMap(Map<K, V> map){
        map.forEach((k,v)->System.out.println("k:"+k+" v:"+v));
    }

}