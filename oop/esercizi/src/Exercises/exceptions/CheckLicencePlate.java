package Exercises.exceptions;

public class CheckLicencePlate {
    public static void checkLicencePlate(String licence){
        if(licence==null){
            throw new IllegalArgumentException("Error: licence is null");
        }
        if(licence.length()!=7){
            throw new IllegalArgumentException("Error: in licence length"+licence);
        }
        for(int i=0;i<licence.length();i++){
            if(i>=2&&i<=4){
                if(!Character.isDigit(licence.charAt(i))){
                    throw new IllegalArgumentException("Character passed not a digit"+licence.charAt(i));
                }
            }else{
                if(!Character.isLetter(licence.charAt(i))){
                    throw new IllegalArgumentException("Character passed not a letter"+licence.charAt(i));
                }
            }
        }
    }
}