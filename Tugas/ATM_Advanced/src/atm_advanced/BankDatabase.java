package atm_advanced;

public class BankDatabase {
   private Account[] accounts; // array of Accounts
    Keypad keypad = new Keypad();
    Screen screen = new Screen();
    
   public BankDatabase() {
      accounts = new Account[5]; // just 2 accounts for testing
      accounts[0] = new Account(12345, 54321, 1000.0, 1200.0, false);
      accounts[1] = new Account(8765, 5678, 200.0, 200.0, false); 
      accounts[2] = new Account(00000, 00000, 0.0, 0.0, false);
   }
   
   public void changePIN(int userAccountNumber){
       
       System.out.print("\nInsert Old PIN : ");
       int oldPin = keypad.getInput();
       if(!authenticateUser(userAccountNumber, oldPin)){
            System.out.println("You Insert the Wrong Old PIN Number");
           changePIN(userAccountNumber);
       }
         
       int[] newPIN = new int[2];
       
       for (int i = 0;i<2;i++){
           System.out.print("Insert New PIN : ");
           newPIN[i] = keypad.getInput();
       }
       
       if (newPIN[0] == newPIN[1]){
           getAccount(userAccountNumber).changeThePIN(newPIN[1]);
           System.out.println("Your PIN has been Changed");
       }else{
           System.out.println("You Insert the Wrong New PIN Number");
           changePIN(userAccountNumber);
       }
           
   }
   
   public void blockStatus( int accountNumber){
       
       Account acc = getAccount(accountNumber);
       if(acc != null)
        acc.setIsBlocked(true);
   }
   
   private Account getAccount(int accountNumber) {
      int i;
      for (i = 0; i < 5; i++) {
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