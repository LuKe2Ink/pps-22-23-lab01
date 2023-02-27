package lab01.example.model;

public class SimpleBankAccountWithAtm implements BankAccount{

    private static final double FEE=1;
    private double balance;
    private final AccountHolder holder;

    public SimpleBankAccountWithAtm(AccountHolder holder, double amount){
        this.holder = holder;
        this.balance = amount;
    }


    @Override
    public AccountHolder getHolder() {
        return this.holder;
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    @Override
    public void deposit(int userID, double amount) {
        if(checkUserID(userID)){
            this.balance = (this.balance+amount)-FEE;
        }
    }

    @Override
    public void withdraw(int userID, double amount) {
        if(checkUserID(userID) && checkWithdrawPermission(amount)){
            this.balance = (this.balance-amount)-FEE;
        }
    }

    private boolean checkUserID(int userID){return this.holder.getId() == userID;}
    private boolean checkWithdrawPermission(double amount){
        double check = this.balance - amount;
        return check >= 0;
    }
}
