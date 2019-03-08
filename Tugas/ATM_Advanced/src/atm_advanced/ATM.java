package atm_advanced;
import java.util.HashMap; // import the HashMap class

public class ATM {
//<<<<<<< HEAD
    private boolean userAuthenticated; // whether user is authenticated
    private int currentAccountNumber; // current user's account number
    private Screen screen; // ATM's screen
    private Keypad keypad; // ATM's keypad
    private CashDispenser cashDispenser; // ATM's cash dispenser
    private DepositSlot depositSlot;

    private BankDatabase bankDatabase; // account information database

    private boolean isAdmin = false;
    // constants corresponding to main menu options
    private Menu[] menuPilihan;
    
    private static final int BALANCE_INQUIRY = 1;
    private static final int WITHDRAWAL = 2;
    private static final int DEPOSIT = 3;
    private static final int TRANSFER = 4;
    private static final int UNBLOCK_NASABAH = 5;
    private static final int CHECK_DISPENSER_MONEY = 6;
    private static final int ADD_DISPENSER_MONEY = 7;
    private static final int ADD_NASABAH = 8;
    private static final int DEPOSIT_VALIDATION = 9;
    private static final int SET_DATE = 10;
    private static final int EXIT = 11;

    private static final int EXITADMIN = 6;

    private static final int JUMLAH_PILIHAN = 11;
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
        initiatePilihan();
        while (true) {
        // loop while user is not yet authenticated
            while (!userAuthenticated) {
                screen.displayMessageLine("\nWelcome!");       
                authenticateUser(); // authenticate user
            }
//            if(!isAdmin){
                performTransactions(); // user is now authenticated         
//            } else {
//                performTransactionsAdmin(); // user is now authenticated                      
//            }
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
           userAuthenticated = bankDatabase.authenticateUser(accountNumber, pin);
           // check whether authentication succeeded
           if (userAuthenticated) {
//               isAdmin = isAdmin(accountNumber, pin);
               currentAccountNumber = accountNumber; // save user's account #
           } else {
              screen.displayMessageLine("Invalid account number or PIN. Please try again.");
               count++;              
           }
       }
       if(count == 3 && !userAuthenticated && currentAccountNumber != 0) //admin gak diblock
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
               screen.displayMessageLine("\nYou did not enter a valid selection. Try again.");
               break;
         }
      } 
   } 
    // display the main menu and return an input selection
    private int displayMainMenu() {
        String[] arrayPilihan = new String[JUMLAH_PILIHAN];
        int[] arrayNoPilihan = new int[JUMLAH_PILIHAN];
        int j = 0;
        Account tempAccount = bankDatabase.getAccount(currentAccountNumber);
        for(int i = 0; i < JUMLAH_PILIHAN; i++){
            if(tempAccount.getAccType() == 0){
                if(menuPilihan[i].getForAdmin() == true){
                    arrayPilihan[j] = menuPilihan[i].getketeranganPilihan();
                    arrayNoPilihan[i] = i;
                    j++;
                }
            } else if(tempAccount.getAccType() == 1){
                if(menuPilihan[i].getForSiswa() == true){
                    arrayPilihan[j] = menuPilihan[i].getketeranganPilihan();
                    arrayNoPilihan[i] = i;
                    j++;
                }                
            } else if(tempAccount.getAccType() == 2){
                if(menuPilihan[i].getForBisnis() == true){
                    arrayPilihan[j] = menuPilihan[i].getketeranganPilihan();
                    arrayNoPilihan[i] = i;
                    j++;
                }                
            } else if(tempAccount.getAccType() == 3){
                if(menuPilihan[i].getForBisnis() == true){
                    arrayPilihan[j] = menuPilihan[i].getketeranganPilihan();
                    arrayNoPilihan[i] = i;
                    j++;
                }                
            }
        }
        for(int i = 0; i < j; i++){
            screen.displayMessage(String.valueOf(menuPilihan[arrayNoPilihan[i]].getNoPilihan()));
            screen.displayMessage(". ");
            screen.displayMessage(menuPilihan[arrayNoPilihan[i]].getketeranganPilihan() + "\n");
        }
        screen.displayMessage("Enter a choice: ");
        int userInput =  keypad.getInput(); // return user's selection
        
        return 0;
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
              temp = new UnblockAccount(currentAccountNumber, screen, bankDatabase);
              break;
           case CHECK_DISPENSER_MONEY:
              temp = new seeAvailableCashDispenser(currentAccountNumber, screen, bankDatabase, cashDispenser);
              break;
           case ADD_DISPENSER_MONEY:
              temp = new depositCashDispenser(currentAccountNumber, screen, bankDatabase, cashDispenser);
              break;
           case ADD_NASABAH:
              temp = new AddAccount(currentAccountNumber, screen, bankDatabase);
              break;
           case DEPOSIT_VALIDATION:
              temp = new ValidateDeposit(currentAccountNumber, screen, bankDatabase, keypad, depositSlot);
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
//            case EXITADMIN: // user chose to terminate session
//               screen.displayMessageLine("\nExiting the system...");
//               userExited = true; // this ATM session should end
//               break;
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

    private void initiatePilihan(){
        menuPilihan = new Menu[JUMLAH_PILIHAN];
        menuPilihan[0] = new Menu(BALANCE_INQUIRY, "View my balance", false, true, true, true);
        menuPilihan[1] = new Menu(WITHDRAWAL, "Withdraw cash", false, true, true, true);
        menuPilihan[2] = new Menu(DEPOSIT, "Deposit funds", false, true, true, true);
        menuPilihan[3] = new Menu(TRANSFER, "Transfer", false, true, true, true);
        menuPilihan[4] = new Menu(UNBLOCK_NASABAH, "Unblock account", true, false, false, false);
        menuPilihan[5] = new Menu(CHECK_DISPENSER_MONEY, "Check amout of cash in dispenser", true, false, false, false);
        menuPilihan[6] = new Menu(ADD_DISPENSER_MONEY, "Add amount of cash in dispenser", true, false, false, false);
        menuPilihan[7] = new Menu(ADD_NASABAH, "Add account to Bank Database", true, false, false, false);
        menuPilihan[8] = new Menu(DEPOSIT_VALIDATION, "Deposit Validation", true, false, false, false);
        menuPilihan[9] = new Menu(SET_DATE, "Set Date", true, false, false, false);
        menuPilihan[10] = new Menu(EXIT, "Exit\n", true, true, true, true);
    }

}
//bikin array A
//loop dari array menuPilihan, kalo true, masukin array A
