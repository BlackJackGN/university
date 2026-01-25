package Exercises.oop.bankaccount;

import java.util.*;

public interface BankAccount {
    String getIBAN();
    void setIBAN(String IBAN);
    double getBalance();
    void setBalance(double balance);
    double getOperationFee();
    void setOperationFee(double operationFee);
    double getInterestRate();
    void setInterestRate(double interestRate);
    void deposit(double amount);
    double withdrawal(double amount);
    double transfer(BankAccount other, double amount);
    void addInterest();
    void applyFee();
    static void checkIBAN(String IBAN){
        if(IBAN.length()<8||IBAN.length()>34){
            throw new IllegalArgumentException("Invalid length");
        }
        if(((int)IBAN.charAt(0)<65||(int)IBAN.charAt(0)>90)||((int)IBAN.charAt(1)<65||(int)IBAN.charAt(1)>90)){
            throw new IllegalArgumentException("Invalid country code");
        }
    }
}
