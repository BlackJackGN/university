package Exercises.oop.basic;
import java.util.*;
/**
 * Class representing a bank account
 */
public class BankAccount {
    private double balance;

    public BankAccount() {
        this.balance=0;
    }

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount){
        if(amount > 0){
            balance+=amount;
        }
    }
    public void withdrawal(double amount){
        if(amount >= 0){
            if(balance >= amount){
                balance-=amount;
            }
        }
    }
}
