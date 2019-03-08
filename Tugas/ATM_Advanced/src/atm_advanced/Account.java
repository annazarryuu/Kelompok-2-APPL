package atm_advanced;

public class Account {
   private static final int ADMIN = 0;
   private static final int SISWA = 1;
   private static final int MASADEPAN = 2;
   private static final int BISNIS = 3;
   private int accountNumber; // account number
   private int pin; // PIN for authentication
   double availableBalance; // funds available for withdrawal
   private double totalBalance; // funds available & pending deposits
   private boolean isBlocked; //Status Nasabah
   private double withdrawLimit; //Batasan tarik tunai akun
   private double transferLimit; //Batasan transfer akun
   private int accType; //Tipe akun pengguna 0 admin 1 siswa 2 bisnis 3 masa depan

   // Account constructor initializes attributes
   public Account(int theAccountNumber, int thePIN, 
      double theAvailableBalance, double theTotalBalance, boolean status, int accType) {
      accountNumber = theAccountNumber;
      pin = thePIN;
      availableBalance = theAvailableBalance;
      totalBalance = theTotalBalance;
      isBlocked = status;
      this.accType = accType;
      setLimit();
   }

   // determines whether a user-specified PIN matches PIN in Account
   public boolean validatePIN(int userPIN) {
      if (userPIN == pin) {
         return true;
      }
      else {
         return false;
        }
   };

   // returns available balance
   public double getAvailableBalance() {
      return availableBalance;
   } 

   public void setIsBlocked(boolean newStatus){
       isBlocked = newStatus ;
   }
   public boolean getIsBlocked(){
       return isBlocked;
   }
   
   // returns the total balance
   public double getTotalBalance() {
      return totalBalance;
   } 
   
   public void setAvailableBalance(double availableBalance) {
       this.availableBalance = availableBalance;
   }

   public void credit(double amount) {
       totalBalance += amount;
   }

   public void debit(double amount) {
       availableBalance -= amount;
       totalBalance -= amount;
   }

   public int getAccountNumber() {
      return accountNumber;  
   }
   
   private void setLimit() {
       switch (accType) {
           case ADMIN:
               withdrawLimit = 0;
               transferLimit = 0;
               break;
           case SISWA:
               withdrawLimit = 20;
               transferLimit = 0;
               break;
           case MASADEPAN:
               withdrawLimit = 100;
               transferLimit = 500;
               break;
           case BISNIS:
               withdrawLimit = 1000;
               transferLimit = 10000;
               break;
           default:
               System.out.print("\nAccount type unavailable.\n");
               break;
       }
   }
   
   public boolean decTransferLimit(double inc) {
       if ( inc > transferLimit ) {
           System.out.print("\nTransfer amount exceeded daily transfer limit.");
           System.out.print("\nYour available transfer is up to $" + transferLimit + ".");
           return false;
       } else {
           transferLimit -= inc;
           return true;
       }
   }
   
   public boolean decWithdrawLimit(double inc) {
       if ( inc > withdrawLimit ) {
           System.out.print("\nWithdraw amount exceeded daily withdraw limit.");
           System.out.print("\nYour available withdraw amount is up to $" + withdrawLimit + ".");
           return false;
       } else {
           withdrawLimit -= inc;
           return true;
       }
   }
   
   public void resetLimit() {
       switch (accType) {
           case ADMIN:
               withdrawLimit = 0;
               transferLimit = 0;
               break;
           case SISWA:
               withdrawLimit = 20;
               transferLimit = 0;
               break;
           case MASADEPAN:
               withdrawLimit = 100;
               transferLimit = 500;
               break;
           case BISNIS:
               withdrawLimit = 1000;
               transferLimit = 10000;
               break;
           default:
               System.out.print("\nAccount type unavailable.\n");
               break;
       }
   }
   
   public int getAccType() {
       return accType;
   }
} 
/*
-> diwaktu luang belajar
-> di kampus ujian

minggu depan targetnya,
testnya ; 


*/