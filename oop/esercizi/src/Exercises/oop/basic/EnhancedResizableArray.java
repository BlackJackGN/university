package Exercises.oop.basic;
import java.util.*;
/**
 * Class representing Enhanced Resizable Array
 */
public class EnhancedResizableArray {
    private static final int DEFAULT_CAPACITY=4;
    private int[] v;

    public EnhancedResizableArray() {
        this.v=new int[DEFAULT_CAPACITY];
    }

    public int get(int index){
        return v[index];
    }

    public void set(int index, int value){
        if(index>=v.length){
            int[] tmp =new int[index*2];
            System.arraycopy(v,0,tmp,0,v.length);
            v=tmp;
        }
        v[index]=value;
    }

    public boolean contains(int value){
        for (int j : v) {
            if (j == value) {
                return true;
            }
        }
        return false;
    }

    public void fill(int value){
        Arrays.fill(v,value);
    }

    public int length(){
        return v.length;
    }

    public int[] toArray(){
        return Arrays.copyOf(v,v.length);
    }
}
