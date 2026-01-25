package Exercises.oop.phonebook;

public interface Phonebook {
    static final int MAX_PERSONS=256;
    boolean addPerson(Person p);
    boolean removePerson(Person p);
    Person[] searchByLastName(String s);
    Person[] searchByNameAndLastName(String s1, String s2);
}
