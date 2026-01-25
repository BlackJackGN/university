package Exercises.generics;
import java.util.*;
import java.util.Map;

public class MapToPairs {
    public static <K, V> List<Pair<K, V>> mapToPairs(Map<K, V> src) {
        List<Pair<K, V>> lst = new ArrayList<>();
        for (Map.Entry<K, V> entry : src.entrySet()) {
            lst.add(new Pair<>(entry.getKey(), entry.getValue()));
        }
        return lst;
    }
}