package Exercises.oop.phonebook;

import java.util.ArrayList;

public class PhonebookList implements Phonebook{
    private final ArrayList<Person> phonebook;

    public PhonebookList() {
        this.phonebook = new ArrayList<>();
    }

    @Override
    public boolean addPerson(Person p){
        if(phonebook.contains(p)||phonebook.size()>=MAX_PERSONS){
            return false;
        }
        phonebook.add(p);
        return true;
    }

    @Override
    public boolean removePerson(Person p){
        if(phonebook.isEmpty() ||!phonebook.contains(p)){
            return false;
        }
        phonebook.remove(p);
        return true;
    }

    @Override
    public Person[] searchByLastName(String s) {
        ArrayList<Person> tmp = new ArrayList<>();
        for(Person p:phonebook){
            if(p.getLastName().equals(s)){
                tmp.add(p);
            }
        }
        return tmp.toArray(new Person[]{});
    }

    @Override
    public Person[] searchByNameAndLastName(String s1, String s2){
        ArrayList<Person> tmp = new ArrayList<>();
        for(Person p:phonebook){
            if(p.getLastName().equals(s2)&&p.getName().equals(s1)){
                tmp.add(p);
            }
        }
        return tmp.toArray(new Person[]{});
    }
}
