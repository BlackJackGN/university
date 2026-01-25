package Exercises.functional;

import java.util.*;
import java.util.stream.Collectors;

public class OneTen {
    public static List<Integer> oneTen(List<Integer> nums){
        return nums.stream().map(n-> (n+1)*10).collect(Collectors.toList());
    }
}