package atm_advanced;

public class ATM {
   private boolean userAuthenticated; // whether user is authenticated
   private int currentAccountNumber; // current user's account number
   private Screen screen; // ATM's screen
   private Keypad keypad; // ATM's keypad
   private CashDispenser cashDispenser; // ATM's cash dispenser
   private DepositSlot depositSlot;

   private BankDatabase bankDatabase; // account information database
   private boolean isAdmin = false;
   
   // constants corresponding to main menu options
   private static final int BALANCE_INQUIRY = 1;
   private static final int WITHDRAWAL = 2;
   private static final int DEPOSIT = 3;
   private static final int CHANGEPIN = 4;
   private static final int TRANSFER = 5;
   private static final int EXIT = 6;
   
   private static final int UNBLOCK_NASABAH = 1;
   private static final int CHECK_DISPENSER_MONEY = 2;
   private static final int ADD_DISPENSER_MONEY = 3;
   private static final int ADD_NASABAH = 4;
   private static final int DEPOSIT_VALIDATION = 5;
   private static final int EXITADMIN = 6;

   // no-argument ATM constructor initializes instance variables
   public ATM() {
      userAuthenticated = false; // user is not authenticated to start
      currentAccountNumber = 0; // no current account number to start
      screen = new Screen(); // create screen
      keypad = new Keypad(); // create keypad 
      cashDispenser = new CashDispenser(); // create cash dispenser
      bankDatabase = new BankDatabase(); // create acct info database
   }

   // start ATM 
   public void run() {
      // welcome and authenticate user; perform transactions
      while (true) {
         // loop while user is not yet authenticated
         
         while (!userAuthenticated) {
             
            screen.displayMessageLine("\nWelcome!");       
            authenticateUser(); // authenticate user
         }
         
         if(!isAdmin){
             performTransactions(); // user is now authenticated         
         } else {
             performTransactionsAdmin(); // admin is now authenticated                      
         } // user is now authenticated
         userAuthenticated = false; // reset before next ATM session
         currentAccountNumber = 0; // reset before next ATM session
         screen.displayMessageLine("\nThank you! Goodbye!");
        }
   }
   
   // attempts to authenticate user against database
   private void authenticateUser() {
       int count = 0;
       
       while(!userAuthenticated && count < 3)
       {
            screen.displayMessage("\nPlease enter your account number: ");
            int accountNumber = keypad.getInput(); // input account number
            screen.displayMessage("\nEnter your PIN: "); // prompt for PIN
            int pin = keypad.getInput(); // input PIN
            
            if(currentAccountNumber != accountNumber)
            {
                currentAccountNumber = accountNumber;
                count = 0;
            }
            
            // set userAuthenticated to boolean value returned by database
            userAuthenticated = 
               bankDatabase.authenticateUser(accountNumber, pin);

            // check whether authentication succeeded
            if (userAuthenticated) {
               isAdmin = isAdmin(accountNumber, pin);
               currentAccountNumber = accountNumber; // save user's account #
            } 
            else { 
               screen.displayMessageLine(
                  "Invalid account number or PIN. Please try again.");
               count++;
            }
       }
       
       if(count == 3 && !userAuthenticated && currentAccountNumber != 00000 ) // admin tidak akan di block
       {
           bankDatabase.blockStatus(currentAccountNumber);
           screen.displayMessageLine("You tried 3 times, Your account is blocked!");
       }
   } 

     private boolean isAdmin(int userAccountNumber, int userPIN) {
      // set userAuthenticated to boolean value returned by database
      if(userAccountNumber == 00000){
          return true;
      } else {
          return false;
      }
   } 
     
   // display the main menu and perform transactions
   private void performTransactions() {
      // local variable to store transaction currently being processed
      Transaction currentTransaction = null;
      
      boolean userExited = false; // user has not chosen to exit

      // loop while user has not chosen option to exit system
      while (!userExited) {
         // show main menu and get user selection
         int mainMenuSelection = displayMainMenu();

         // decide how to proceed based on user's menu selection
         switch (mainMenuSelection) {
            // user chose to perform one of three transaction types
            case BALANCE_INQUIRY:         

               // initialize as new object of chosen type
               currentTransaction = 
                  createTransaction(mainMenuSelection);

               currentTransaction.execute(); // execute transaction
               break;
            case WITHDRAWAL:
                currentTransaction =
                        createTransaction(mainMenuSelection);
                
                currentTransaction.execute();
                break;
            case DEPOSIT:
                currentTransaction =
                        createTransaction(mainMenuSelection);
                
                currentTransaction.execute();
                break;
            case CHANGEPIN:
                bankDatabase = new BankDatabase();
                bankDatabase.changePIN(currentAccountNumber);
                break;
            case TRANSFER:
                currentTransaction =
                        createTransaction(mainMenuSelection);
                currentTransaction.execute();
                break;
            case EXIT: // user chose to terminate session
               screen.displayMessageLine("\nExiting the system...");
               userExited = true; // this ATM session should end
               break;
            default: // 
               screen.displayMessageLine(
                  "\nYou did not enter a valid selection. Try again.");
               break;
         }
      } 
   } 
   
   

   // display the main menu and return an input selection
   private int displayMainMenu() {
      screen.displayMessageLine("\nMain menu:");
      screen.displayMessageLine("1 - View my balance");
      screen.displayMessageLine("2 - Withdraw cash");
      screen.displayMessageLine("3 - Deposit funds");
      screen.displayMessageLine("4 - Change Password");
      screen.displayMessageLine("5 - Transfer");
      screen.displayMessageLine("6 - Exit\n");
      screen.displayMessage("Enter a choice: ");
      return keypad.getInput(); // return user's selection
   } 
         
   private Transaction createTransaction(int type) {
      Transaction temp = null; 
      
      if(!isAdmin){
      switch (type) {
         case BALANCE_INQUIRY: 
            temp = new BalanceInquiry(
               currentAccountNumber, screen, bankDatabase);
            break;
         case WITHDRAWAL:
            temp = new Withdrawal(currentAccountNumber, screen, bankDatabase, keypad, cashDispenser);
            break;
         case DEPOSIT:
            temp = new Deposit(currentAccountNumber, screen, bankDatabase, keypad, depositSlot);
            break;
         case TRANSFER:
             temp = new Transfer(currentAccountNumber, screen, keypad, bankDatabase );
            break;
                 
      }
      } else {
                 switch (type) {
           case UNBLOCK_NASABAH: 
//              temp = new ManageClient(
//                 currentAccountNumber, screen, bankDatabase);
              break;
           case CHECK_DISPENSER_MONEY:
//              temp = new ManageDispenser(
//                 currentAccountNumber, screen, bankDatabase);
              break;
           case ADD_DISPENSER_MONEY:
//              temp = new ManageDispenser(
//                 currentAccountNumber, screen, bankDatabase);
              break;
           case ADD_NASABAH:
//              temp = new ManageClient(
//                 currentAccountNumber, screen, bankDatabase);
              break;
           case DEPOSIT_VALIDATION:
//              temp = new ValidateDeposit(currentAccountNumber, screen, bankDatabase, keypad, depositSlot);
              break;
        }  
      }

      return temp;
   } 
   
       private void performTransactionsAdmin() {
      Transaction currentTransaction = null;
      
      boolean userExited = false; // user has not chosen to exit

      // loop while user has not chosen option to exit system
      while (!userExited) {
         // show main menu and get user selection
         int mainMenuSelection = displayMainMenuAdmin();

         // decide how to proceed based on user's menu selection
         switch (mainMenuSelection) {
            // user chose to perform one of three transaction types
            case UNBLOCK_NASABAH:         

               // initialize as new object of chosen type
               currentTransaction = 
                  createTransaction(mainMenuSelection);

               currentTransaction.execute(); // execute transaction
               break;
            case CHECK_DISPENSER_MONEY:
                currentTransaction =
                        createTransaction(mainMenuSelection);
                
                currentTransaction.execute();
                break;
            case ADD_DISPENSER_MONEY:
                currentTransaction =
                        createTransaction(mainMenuSelection);
                
                currentTransaction.execute();
                break;
            case ADD_NASABAH:
                currentTransaction =
                        createTransaction(mainMenuSelection);
                
                currentTransaction.execute();
                break;
            case DEPOSIT_VALIDATION:
                currentTransaction =
                        createTransaction(mainMenuSelection);
                
                currentTransaction.execute();
                break;
            case EXITADMIN: // user chose to terminate session
               screen.displayMessageLine("\nExiting the system...");
               userExited = true; // this ATM session should end
               break;
            default: // 
               screen.displayMessageLine(
                  "\nYou did not enter a valid selection. Try again.");
               break;
         }
      } 

        }

    private int displayMainMenuAdmin() {
      screen.displayMessageLine("\nMain menu:");
      screen.displayMessageLine("1 - Unblock Nasabah");
      screen.displayMessageLine("2 - Lihat uang di dispenser");
      screen.displayMessageLine("3 - Tambah uang di dispenser");
      screen.displayMessageLine("4 - Tambah nasabah");
      screen.displayMessageLine("5 - Validasi deposit");
      screen.displayMessageLine("6 - Exit\n");
      screen.displayMessage("Enter a choice: ");
      return keypad.getInput(); // return user's selection
    }
    
}