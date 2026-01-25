package Exercises.exceptions;
import java.time.DateTimeException;
import java.time.LocalDate;

public class CheckIntervalBetweenDatesAlt {
    public static boolean checkIntervalBetweenDatesAlt(String begin, String end){
        try{
            LocalDate d1=LocalDate.parse(begin);
            LocalDate d2=LocalDate.parse(end);
            return d1.isBefore(d2);
        }catch (DateTimeException DTEx){
            return false;
        }
    }
}