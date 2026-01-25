package Exercises.exceptions;
import java.time.LocalDate;

public class CheckIntervalBetweenDates {
    public static boolean checkIntervalBetweenDates(String begin, String end){
        LocalDate d1=LocalDate.parse(begin);
        LocalDate d2=LocalDate.parse(end);
        return d1.isBefore(d2);
    }
}