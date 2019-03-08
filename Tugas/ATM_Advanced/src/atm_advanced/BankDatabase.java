package atm_advanced;

public class BankDatabase {
   private Account[] accounts; // array of Accounts
   private int maxAccountCount = 50;
   private int INITIAL_ACCOUNT_COUNT = 3; //pertama-tama, hanya ada 3 akun di database
   private int current_account_count;
   public BankDatabase() {
      accounts = new Account[maxAccountCount]; // just 2 accounts for testing
      accounts[0] = new Account(12345, 54321, 1000.0, 1200.0, false);
      accounts[1] = new Account(8765, 5678, 200.0, 200.0, false);
      accounts[2] = new Account(00000, 00000, 0.0, 0.0, false);
      current_account_count = INITIAL_ACCOUNT_COUNT; //jumlah akun pertama-tama diisi INITITAL_ACCOUNT_COUNT
   }
   
   public void blockStatus(int accountNumber){
       
       Account acc = getAccount(accountNumber);
       if(acc != null)
        acc.setIsBlocked(true);
   }
   
   private Account getAccount(int accountNumber) {
      int i;
      for (i = 0; i < current_account_count; i++) {
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
   
   private Account getAccountByAdmin(int accountNumber) {
      int i;
      for (i = 0; i < current_account_count; i++) {
          if (accounts[i].getAccountNumber() == accountNumber) {
              return accounts[i];
          }
      } 
      return null; // if no matching account was found, return null
   } 
   
   public boolean validateAccount(int accountNumber) {
      int i;
      for (i = 0; i < current_account_count; i++) {
          if (accounts[i].getAccountNumber() == accountNumber) {
              return true;
          }
      } 
      return false; // if no matching account was found, return null
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
   
   public boolean depositValidated(int userAccountNumber) {
       Account userAccount = getAccount(userAccountNumber);
       
       if(userAccount != null) {
           userAccount.setAvailableBalance(userAccount.getTotalBalance());
           return true;
       } else {
           return false;
       }
   }

   public double getAvailableBalance(int userAccountNumber) {
      return getAccount(userAccountNumber).getAvailableBalance();
   } 

   public double getTotalBalance(int userAccountNumber) {
      return getAccount(userAccountNumber).getTotalBalance();
   } 
   
   public double getTransferTax(int userAccountNumber)
   {
       return getAccount(userAccountNumber).getTransferTax();
   }

   public void credit(int userAccountNumber, double amount) {
      getAccount(userAccountNumber).credit(amount);
   }

   public void debit(int userAccountNumber, double amount) {
      getAccount(userAccountNumber).debit(amount);
   } 
   public void unblockAccount(int userAccountNumber){
       System.out.println("masuk");
      getAccountByAdmin(userAccountNumber).setIsBlocked(false);
   }
   public void addAccount(int userAccountNumber, int userPIN) {
        if(current_account_count > maxAccountCount-1){ //maksimal 50 akun
            System.out.println("You can`t add new account because the database is full.");
        } else {
           System.out.println("Account successfully created.");
           accounts[current_account_count] = new Account(userAccountNumber, userPIN, 0, 0, false);        
           current_account_count++;
        }
   }
   
   public void monthlyPayment()
   {
       for (int i = 0; i < current_account_count; i++)
       {
	   accounts[i].monthlyPayment();
       }
   }
} 