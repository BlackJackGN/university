package Exercises.functional;
import java.util.*;
import java.util.stream.Collectors;

public class NoYYZ {
    public static List<String> noYYZ(List<String> strings){
        return strings.stream().peek(s->{if(s.startsWith("z"))System.out.println(s);}).map(s->s+"y").filter(s->!s.contains("yy")).collect(Collectors.toList());
    }
}