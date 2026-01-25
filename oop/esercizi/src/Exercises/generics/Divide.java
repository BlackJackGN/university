package Exercises.generics;
import java.lang.Number;
public class Divide {
    public static <T extends Number> double divide(T a,T b){
        if(b.doubleValue()==0){
            throw new IllegalArgumentException("Division by 0 impossible");
        }
        return a.doubleValue()/b.doubleValue();
    }
}