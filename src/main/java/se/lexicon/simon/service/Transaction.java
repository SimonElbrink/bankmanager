package se.lexicon.simon.service;


public interface Transaction {

    boolean verifyAccount(Integer authorizeUserID);
    boolean transfer(Integer authorizedUserID, double amount, String fromAccountNumber, String toAccountNumber);



}
