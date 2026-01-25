package Exercises.collections;

import java.util.*;

public class LookAndSay {
    public static List<Long> lookAndSay(long n){
        if(n<1){
            return new ArrayList<>();
        }
        List<Long>seq=new ArrayList<>(List.of(n));
        seq.add(1L);
        for(int i=1;i<n;i++){
            String prev=seq.get(i-1).toString();
            StringBuilder sb=new StringBuilder();
            int count=1;
            for(int j=1;j<prev.length();j++){
                if(prev.charAt(j)==prev.charAt(j-1)){
                    count++;
                }else{
                    sb.append(count).append(prev.charAt(j-1));
                    count=1;
                }
            }
            sb.append(count).append(prev.charAt(prev.length()-1));
            seq.add(Long.parseLong(sb.toString()));
        }
        return seq;
    }
}