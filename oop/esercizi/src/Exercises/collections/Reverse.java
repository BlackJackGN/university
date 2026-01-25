package Exercises.collections;

import java.util.*;

public class Reverse {
    public static void reverse(List<String> sentence){
        Deque<String>dq=new LinkedList<>();
        while(!sentence.isEmpty()){
            dq.push(sentence.removeFirst());
        }
        while(!dq.isEmpty()){
            sentence.addLast(dq.poll());
        }
    }
}