package Exercises.functional;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class BankAccount {
    public static class Account {
        double amount;
        double interestRate;
        LocalDateTime duePayment;

        public Account(double amount, double interestRate, LocalDateTime duePayment) {
            this.amount = amount;
            this.interestRate = interestRate;
            this.duePayment = duePayment;
        }

        public double getAmount() {
            return amount;
        }

        public double getInterestRate() {
            return interestRate;
        }

        public LocalDateTime getDuePayment() {
            return duePayment;
        }

        public void applyInterest() {
            amount += amount * interestRate;
        }
    }
    public static List<Account> applyInterest(List<Account> accounts){
        return accounts.stream().filter(a->a.getDuePayment().isBefore(LocalDateTime.now())).peek(Account::applyInterest).sorted((a1, a2) -> Double.compare(a2.getAmount(), a1.getAmount())).collect(Collectors.toList());
    }
}