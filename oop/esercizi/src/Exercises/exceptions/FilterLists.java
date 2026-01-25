package Exercises.exceptions;
import java.text.ParseException;
import java.util.*;

public class FilterLists {
    public static List<List<String>> filterLists(List<List<String>> lists){
        ArrayList<List<String>>lst=new ArrayList<>();
        for(List<String> l:lists) {
            try{
                for(String s:l){
                    CheckString.checkString(s);
                }
                lst.add(l);
            }catch(ParseException ignored){}
        }
        return lst;
    }
}