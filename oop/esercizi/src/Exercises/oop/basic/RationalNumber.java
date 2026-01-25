package Exercises.oop.basic;
import java.util.Objects;
/**
 * Write a class named RationalNumber representing a rational number. RationalNumbers are immutable objects, indeed they cannot be changed after creation. Internally, the class represents numerator and denominator as int values. RationalNumbers must support equality with other RationalNumbers (see Object.equals(), Object.hashCode()) The class provides the following methods:
 * public RationalNumber(int numerator, int denominator) creating the rational number. Before creating the object, numerator and denominator have to be simplified (i.e., divided by their greatest common divisor).
 * public int getNumerator() returning the numerator.
 * public int getDenominator() returning the denominator.
 * public RationalNumber add(RationalNumber o) returning a RationalNumber object representing the sum of the current number and another number.
 * public RationalNumber multiply(RationalNumber o) returning a RationalNumber object representing the multiplication of the current number and another number.
 * public String toString().
 */
public class RationalNumber {
    private final int numerator;
    private final int denominator;

    public RationalNumber(int numerator,int denominator){
        int min=greatestCommonDivisor(numerator,denominator);
        this.numerator=numerator/min;
        this.denominator=denominator/min;
    }

    public static int greatestCommonDivisor(int a, int b) {
        int max = Math.max(Math.abs(a), Math.abs(b));
        int min = Math.min(Math.abs(a), Math.abs(b));

        int rest = max % min;
        if (max % min == 0) {
            return min;
        } else {
            return greatestCommonDivisor(min, rest);
        }
    }

    public static int leastCommonMultiple(int a, int b) {
        return Math.abs(a * b) / greatestCommonDivisor(a, b);
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public RationalNumber add(RationalNumber o){
        int lcm=leastCommonMultiple(denominator,o.getDenominator());
        int num=numerator*(lcm/denominator)+o.getNumerator()*(lcm/o.getDenominator());
        return new RationalNumber(num,lcm);
    }

    public RationalNumber multiply(RationalNumber o){
        int num=numerator*o.getNumerator();
        int den=denominator*o.getDenominator();
        return new RationalNumber(num,den);
    }

    @Override
    public String toString() {
        return "RationalNumber: {Numerator: "+numerator+" Denominator: "+denominator+" }";
    }

    @Override
    public int hashCode() {
        return Objects.hash(numerator,denominator);
    }

    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(o==null||getClass()!=o.getClass()){
            return false;
        }
        RationalNumber num=(RationalNumber)o;
        return numerator==num.getNumerator() && denominator==num.getDenominator();
    }
}