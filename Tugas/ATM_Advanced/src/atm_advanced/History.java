/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm_advanced;

import java.util.ArrayList;

/**
 *
 * @author Annazar
 */
public class History {
    private int loginAccountNumber;
    static private ArrayList accountNumber;
    static private ArrayList transactionType;
    static private ArrayList transaction;
    static private int dataSize;

    public History(int theLoginAccountNumber) {
        loginAccountNumber = theLoginAccountNumber;
        
        if(accountNumber == null)
            accountNumber = new ArrayList<>();

        if(transactionType == null)
            transactionType = new ArrayList<>();

        if(transaction == null)
            transaction = new ArrayList<>();
    }
    
    public void addTransaction(int theAccountNumber, int theTransactionType, Transaction theTransaction)
    {
        String transactionTypeStr;
        
        
        accountNumber.add(theAccountNumber);
        transactionType.add(theTransactionType);
        transaction.add(theTransaction);
        dataSize += 1;
    }
    
    public void printHistory()
    {
        for(int i = 0; i < dataSize; i++)
        {
            System.out.println("pew pew pew");
            System.out.println("Account Number : " + accountNumber.get(i));
            System.out.println("Jenis Transaksi : " + transactionType.get(i));
            System.out.println();
        }
    }
}
