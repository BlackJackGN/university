package Exercises.exceptions;

public class DivisionSquared {
    public static int divisionSquared(int a, int b){
        try{
            return (a/b)*(a/b);
        }catch (ArithmeticException AEx){
            return 0;
        }
    }
}