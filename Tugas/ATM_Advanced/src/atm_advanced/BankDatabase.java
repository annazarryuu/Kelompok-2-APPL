package atm_advanced;

public class BankDatabase {
   private Account[] accounts; // array of Accounts
   private int maxAccountCount = 50;
   public BankDatabase() {
      accounts = new Account[maxAccountCount]; // just 2 accounts for testing
      accounts[0] = new Account(12345, 54321, 1000.0, 1200.0);
      accounts[1] = new Account(8765, 5678, 200.0, 200.0);
      accounts[2] = new Account(00000, 00000, 0.0, 0.0);
   }
   
   private Account getAccount(int accountNumber) {
      int i;
      for (i = 0; i < maxAccountCount; i++) {
          if (accounts[i].getAccountNumber() == accountNumber) {
              if (accounts[i].getIsBlocked() == true ){
                  System.out.println("Your account is blocked !");
                  return null;
              }
              return accounts[i];
          }
      } 
      return null; // if no matching account was found, return null
   } 

   public boolean authenticateUser(int userAccountNumber, int userPIN) {
      // attempt to retrieve the account with the account number
      Account userAccount = getAccount(userAccountNumber);

      // if account exists, return result of Account method validatePIN
      if (userAccount != null) {
         return userAccount.validatePIN(userPIN);
      }
      else {
         return false; // account number not found, so return false
      }
   } 

   public double getAvailableBalance(int userAccountNumber) {
      return getAccount(userAccountNumber).getAvailableBalance();
   } 

   public double getTotalBalance(int userAccountNumber) {
      return getAccount(userAccountNumber).getTotalBalance();
   } 

   public void credit(int userAccountNumber, double amount) {
      getAccount(userAccountNumber).credit(amount);
   }

   public void debit(int userAccountNumber, double amount) {
      getAccount(userAccountNumber).debit(amount);
   } 
} 