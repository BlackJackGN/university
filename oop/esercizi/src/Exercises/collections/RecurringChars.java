package Exercises.collections;

import java.util.HashSet;
import java.util.Set;

public class RecurringChars {
    public static Set<Character> recurringChars(String string){
        Set<Character>dup=new HashSet<>();
        Set<Character>seen=new HashSet<>();
        for(char c:string.toCharArray()){
            if(!seen.contains(c)) {
                seen.add(c);
            }else{
                dup.add(c);
            }
        }
        return dup;
    }
}
