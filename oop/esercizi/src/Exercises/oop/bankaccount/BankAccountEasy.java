package Exercises.oop.bankaccount;

public class BankAccountEasy extends AbstractBankAccount{
    public BankAccountEasy(String IBAN, double balance) {
        super(IBAN, balance,0.0,0.0);
    }

    @Override
    public double withdrawal(double amount){
        if(balance>=amount){
            return super.withdrawal(amount);
        }
        return 0.0;
    }

    @Override
    public double transfer(BankAccount other,double amount){
        BankAccount.checkIBAN(other.getIBAN());
        String ccs=IBAN.substring(0,2);
        String ccd=other.getIBAN().substring(0,2);
        if(!ccs.equals(ccd)){
            throw new IllegalArgumentException("International transfer invalid");
        }
        amount=withdrawal(amount);
        other.deposit(amount);
        return amount;
    }
}