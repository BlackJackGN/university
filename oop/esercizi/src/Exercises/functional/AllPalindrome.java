package Exercises.functional;
import java.util.*;
public class AllPalindrome {
    public static boolean allPalindrome(List<String> strings){
        return strings.stream().allMatch(s->s.equals(new StringBuilder(s).reverse().toString()));
    }
}