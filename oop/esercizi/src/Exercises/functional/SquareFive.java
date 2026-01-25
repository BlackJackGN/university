package Exercises.functional;

import java.util.*;
import java.util.stream.Collectors;

public class SquareFive {
    public static long squareFive(List<Integer> nums){
        return nums.stream().map(n->(n*n)+10).filter(n->n%10!=5).count();
    }
}