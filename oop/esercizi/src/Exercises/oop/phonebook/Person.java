package Exercises.oop.phonebook;

import java.util.*;

public class Person {
    private String name;
    private String lastName;
    private String phone;

    public Person(String name, String lastName, String phone) {
        this.name = name;
        this.lastName = lastName;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o){
        if(this==o){
            return true;
        }
        if(o==null||getClass()!=o.getClass()){
            return false;
        }
        Person p=(Person)o;
        return name.equals(p.getName())&&lastName.equals((p.getLastName()))&&phone.equals(p.getPhone());
    }

    @Override
    public int hashCode(){
        return Objects.hash(name,lastName,phone);
    }

    @Override
    public String toString(){
        return "Person data: {Name: "+name+" LastName: "+lastName+" Phone: "+phone+" }";
    }
}