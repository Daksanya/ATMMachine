import java.util.Scanner;

class Account {
   private double balance;
   public void setBalance(double amount){
       this.balance=amount;
   }
   public double getBalance(){
       return this.balance;
   }

    public void deposit(double amount) throws InvalidAmountException{
        if(amount<=0){
            throw new InvalidAmountException("Please Enter a valid Amount");
        }

        balance+=amount;
        System.out.println("Deposit successful, New Balance is:"+balance);
    }
    public void withdraw(double amount)  throws InsufficientFundsException,InvalidAmountException{
        if(amount>balance){
            throw new InsufficientFundsException("Insufficient bank balance");
    }
        if(amount<=0){
            throw new InvalidAmountException("Please Enter a valid Amount");
        }
        balance-=amount;
        System.out.println("Withdraw successful, New Balance is:"+balance);

}}
class InsufficientFundsException extends Exception{
    public InsufficientFundsException(String errorMessage){
        super(errorMessage);
    }
}
class InvalidAmountException extends Exception{
    public InvalidAmountException(String errorMessage){
        super(errorMessage);
    }
}
public class Main {
    public static void main(String[] args) {
        Account acc = new Account();
        acc.setBalance(1000.0);
        double amount;
        Scanner sc = new Scanner(System.in);
        boolean t = true;
        while(t){
            System.out.println("Enter 1 to Deposit Amount");
            System.out.println("Enter 2 to Withdraw Amount");
            System.out.println("Enter 3 to Check Account Balance");
            System.out.println("Enter 4 to Exit");
            int option=sc.nextInt();
        switch (option){
            case 1:
                System.out.println("Enter Amount to Deposit:");
                amount=sc.nextDouble();
                try{
                    acc.deposit(amount);
                }catch(InvalidAmountException exception) {
                    System.out.println(exception.getMessage());
                }break;
            case 2:
                System.out.println("Enter Amount to Withdraw");
                amount=sc.nextDouble();
                try{
                    acc.withdraw(amount);
                }catch(InvalidAmountException exception){
                    System.out.println(exception.getMessage());
                }
                catch (InsufficientFundsException exception){
                    System.out.println(exception.getMessage());
                }
                break;
            case 3:
                System.out.println("Your Account Balance is:"+acc.getBalance());
                break;
            case 4:
                t=false;
                break;
            default:
                System.out.println("Enter a valid option");

        }}


    }}


