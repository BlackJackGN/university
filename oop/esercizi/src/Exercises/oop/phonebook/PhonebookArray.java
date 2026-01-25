package Exercises.oop.phonebook;
import com.sun.source.tree.ArrayAccessTree;

import java.util.*;

/**
 * Class which implements phonebook via arrays
 */
public class PhonebookArray implements Phonebook{
    private final Person[] phonebook;

    public PhonebookArray() {
        phonebook=new Person[MAX_PERSONS];
    }

    @Override
    public boolean addPerson(Person p){
        for(int i=0;i<MAX_PERSONS;i++){
            if(phonebook[i]!=null&&phonebook[i].equals(p)){
                return false;
            }
        }
        for(int i=0;i<MAX_PERSONS;i++){
            if(phonebook[i]!=null){
                phonebook[i]=p;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean removePerson(Person p){
        for(int i=0;i<MAX_PERSONS;i++){
            if(phonebook[i].equals(p)){
                phonebook[i]=null;
                return true;
            }
        }
        return false;
    }

    @Override
    public Person[] searchByLastName(String s) {
        int k=0;
        Person v[]=new Person[MAX_PERSONS];
        for(int i=0;i<MAX_PERSONS;i++){
            if(phonebook[i].getLastName().equals(s)){
                v[k++]=phonebook[i];
            }
        }
        return Arrays.copyOf(v,k);
    }

    @Override
    public Person[] searchByNameAndLastName(String name, String lastName) {
        int k = 0;
        Person[] tmp = new Person[MAX_PERSONS];
        for (int i = 0; i < MAX_PERSONS; i++) {
            if (phonebook[i] != null && phonebook[i].getName().equals(name) && phonebook[i].getLastName().equals(lastName)) {
                tmp[k++] = phonebook[i];
            }
        }
        return Arrays.copyOf(tmp, k);
    }
}
