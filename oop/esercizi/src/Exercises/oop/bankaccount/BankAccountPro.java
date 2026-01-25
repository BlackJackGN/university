package Exercises.oop.bankaccount;

public class BankAccountPro extends AbstractBankAccount{
    public BankAccountPro(String IBAN, double balance) {
        super(IBAN, balance, 1, 0.02);
    }

    @Override
    public void deposit(double amount){
        super.deposit(amount);
        applyFee();
    }

    @Override
    public double withdrawal(double amount){
        amount=super.withdrawal(amount);
        applyFee();
        return amount;
    }
}