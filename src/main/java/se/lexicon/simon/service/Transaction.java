package se.lexicon.simon.service;


public interface Transaction {

    boolean verifyCustomer(Integer authorizeUserID);
    boolean transfer(Integer authorizedUserID, double amount, String fromAccountNumber, String toAccountNumber);



}
