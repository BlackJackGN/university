package Exercises.generics;
import java.util.*;

public class MinMax {
    public static <T> T max(List<T> list, Comparator<? super T> cmp){
        return getValue(list,cmp,'<');
    }
    public static <T> T min(List<T> list, Comparator<? super T> cmp){
        return getValue(list,cmp,'>');
    }
    private static <T> T getValue(List<T> list, Comparator<? super T> cmp,char p){
        T c=list.getFirst();
        for(T next: list){
            if(p=='<'){
                if(cmp.compare(c,next)<0){
                    c=next;
                }
            }else{
                if(cmp.compare(c,next)>0){
                    c=next;
                }
            }
        }
        return c;
    }
    /*
     * public static <T> T max(List<T> list, Comparator<? super T> cmp) {
     *         T candidate = list.get(0);
     *         for (T next : list) {
     *             if (cmp.compare(candidate, next) < 0) {
     *                 candidate = next;
     *             }
     *         }
     *         return candidate;
     *     }
     *
     *     public static <T> T min(List<T> list, Comparator<? super T> cmp) {
     *         T candidate = list.get(0);
     *         for (T next : list) {
     *             if (cmp.compare(candidate, next) > 0) {
     *                 candidate = next;
     *             }
     *         }
     *         return candidate;
     *     }
     */
}