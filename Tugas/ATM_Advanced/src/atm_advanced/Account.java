package atm_advanced;

public class Account {
   private int accountNumber; // account number
   private int pin; // PIN for authentication
   private double availableBalance; // funds available for withdrawal
   private double totalBalance; // funds available & pending deposits
   private boolean isBlocked; //Status Nasabah

   // Account constructor initializes attributes
   public Account(int theAccountNumber, int thePIN, 
      double theAvailableBalance, double theTotalBalance, boolean status) {
      accountNumber = theAccountNumber;
      pin = thePIN;
      availableBalance = theAvailableBalance;
      totalBalance = theTotalBalance;
      isBlocked = status;
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
} 