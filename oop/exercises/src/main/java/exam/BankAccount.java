package exam;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
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

        public void setAmount(double amount) {
            this.amount = amount;
        }

        public double getInterestRate() {
            return interestRate;
        }

        public void setInterestRate(double interestRate) {
            this.interestRate = interestRate;
        }

        public LocalDateTime getDuePayment() {
            return duePayment;
        }

        public void setDuePayment(LocalDateTime duePayment) {
            this.duePayment = duePayment;
        }

        public void applyInterest() {
            amount += amount * interestRate;
        }

    }
    public static List<Account> applyInterest(List<Account> accounts){
        return accounts.stream().filter(a->a.getDuePayment().isBefore(LocalDateTime.now()))
                .peek(Account::applyInterest).sorted((a1,a2)->(int)a2.getAmount()-(int)a1.getAmount()).collect(Collectors.toList());
    }
}