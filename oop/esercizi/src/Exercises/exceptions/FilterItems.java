package Exercises.exceptions;
import java.text.ParseException;
import java.util.*;


public class FilterItems {
    public static List<String> filterItems(List<String> strings){
        ArrayList<String>lst=new ArrayList<>();
        for(String s:strings){
            try{
                CheckString.checkString(s);
                lst.add(s);
            }catch(ParseException ignored){}
        }
        return lst;
    }
}