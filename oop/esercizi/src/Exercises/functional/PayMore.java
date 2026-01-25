package Exercises.functional;

import java.util.*;

public class PayMore {
    public static void payMore(Map<String, Double> fees, String numberFamily, double costDelta){
        fees.replaceAll((s,d)->s.startsWith(numberFamily)?d+costDelta:d);
    }
}