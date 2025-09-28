class InsufficientFundsException extends Exception{
    public InsufficientFundsException(String message){
        super(message);
    }
}


public class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double balance){
        this.accountNumber=accountNumber;
        this.balance=balance;
    }

    public void deposit(double amount){
        if(amount<=0){
            throw new IllegalArgumentException("Deposit must be greater than 0");
        }
        balance+=amount;
        System.out.println("Deposited " + amount + ". Current balance = " + balance);
    }

    public void withdraw(double amount) throws InsufficientFundsException{
        if (amount<=0){
            throw new IllegalArgumentException("Amount should be greater than 0");
        }

        if(amount>balance){
            throw new InsufficientFundsException
                    ("Insufficient funds! Tried to withdraw " + amount + ", but balance = " + balance);
        }
        balance-=amount;
        System.out.println("Withdrew " + amount + ". Current balance = " + balance);


    }

    //Get Balance
    public double getBalance(){
        return balance;
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount("12345",800);
        try{
            account.deposit(500);
            account.withdraw(200);
            account.withdraw(400);

        } catch (InsufficientFundsException e) {
            System.out.println("Error: "+e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: "+e.getMessage());
        } finally {
            System.out.println("Final Balance = " + account.getBalance());
        }
    }
}
