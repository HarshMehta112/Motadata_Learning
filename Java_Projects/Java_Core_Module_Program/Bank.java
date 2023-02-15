import javax.xml.namespace.QName;
import java.util.Scanner;

public abstract class Bank {
    abstract int withdraw();
    abstract int credit();
    abstract int balanceinfo();
    abstract void enterAccountDetails();
    abstract void accountInfoShow();

}

class Operations extends Bank{
    public int balance;
    public String name;
    public String email;
    public String mobile_no;

    Operations()
    {
        this.balance = balance;
        this.name = name;
        this.email = email;
        this.mobile_no = mobile_no;
    }

    Scanner sc = new Scanner(System.in);

    public int withdraw()
    {
        System.out.println("Your current balance is "+balance);
        System.out.println("Enter the amount to withdraw");
        int withdraw_amount = sc.nextInt();
        if(withdraw_amount>balance)
        {
            System.out.println("Insuffiecient Balance");
        }
        else
        {
            balance-=withdraw_amount;
        }
        System.out.println(balance);
        return balance;
    }

    public int credit()
    {
        System.out.println("Enter the amount to credit");
        int credit_amount = sc.nextInt();
        balance+=credit_amount;
        System.out.println(balance);
        return balance;
    }

    public int balanceinfo()
    {
        System.out.println("Your current balance is "+balance);
        return balance;
    }

    public void enterAccountDetails()
    {
        System.out.println("Enter the account type");
        System.out.println("1. Current Account");
        System.out.println("2. Saving Account");
        System.out.println("3. Salary Account");

        int x = sc.nextInt();

        switch(x)
        {
            case 1,2,3:
                System.out.println("Enter Full name");
                sc.nextLine();
                name = sc.nextLine();
                System.out.println("Enter Email Adress");
                email = sc.nextLine();
                System.out.println("Enter the mobile number");
                mobile_no = sc.nextLine();
        }

    }

    public void accountInfoShow()
    {
        System.out.println("Your Full name is "+ name);
        System.out.println("Your Email Adress is "+ email);
        System.out.println("Your the mobile number is "+ mobile_no);
        System.out.println("Your Current Balance is "+ balance);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Operations account = new Operations();
        while(true) {
            System.out.println();
            System.out.println("Enter the Operation you want to do");
            System.out.println("1. Withdraw Money");
            System.out.println("2. Credit money");
            System.out.println("3. Information about curent balance");
            System.out.println("4. New Account Opening");
            System.out.println("5. Show the Account Details");
            System.out.println();
            int n = sc.nextInt();
            switch (n) {
                case 1: {
                    account.withdraw();
                    break;
                }
                case 2: {
                    account.credit();
                    break;
                }
                case 3: {
                    account.balanceinfo();
                    break;
                }
                case 4:{
                    account.enterAccountDetails();
                    break;
                }
                case 5:{
                    account.accountInfoShow();
                    break;
                }
            }
        }
    }

}