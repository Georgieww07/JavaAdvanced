package DefiningClasses.P3BankAccount;

public class BankAccount {
    private int id;
    private double balance;
    private final static double DEFAULT_INTEREST_RATE = 0.02d;
    private static double interestRate = DEFAULT_INTEREST_RATE;
    private static int bankAccountCount = 1;


    public BankAccount(){
        this.id = bankAccountCount++;
    }

    public static void setInterestRate(double interestRate){
        BankAccount.interestRate = interestRate;
    }

    public void deposit(double amount){
        this.balance += amount;
    }

    public double getInterest(int years){
        return BankAccount.interestRate * years * this.balance;
    }


    public int getId(){
        return this.id;
    }


}
