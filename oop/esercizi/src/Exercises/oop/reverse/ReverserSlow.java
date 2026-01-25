package Exercises.oop.reverse;

public class ReverserSlow implements Reverser{
    @Override
    public String reverse(String s) {
        char[] c =new char[s.length()];
        for(int i=c.length,j=0;i>0;i--,j++){
            c[j]=s.charAt(i);
        }
        return c.toString();
    }
}
