package Exercises.generics;
import java.util.*;
public class Reverse {
    public static <T> void reverse(List<T> list){
        //list.reversed();
        ArrayList<T> tmp=new ArrayList<T>();
        tmp.addAll(list);
        list.clear();
        for(int i=tmp.size()-1;i>=0;i--){
            list.add(tmp.get(i));
        }
    }
}