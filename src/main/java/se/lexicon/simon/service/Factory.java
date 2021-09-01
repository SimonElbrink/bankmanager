package se.lexicon.simon.service;

import org.springframework.stereotype.Component;
import se.lexicon.simon.model.Account;
import se.lexicon.simon.model.Customer;

import java.util.Optional;


public interface Factory {

    Optional<Account> createAccount();
    Optional<Account> createAccount(int id);
    Optional<Customer> createCustomer(String name);
    Optional<Customer> createCustomer(int id, String name);

}
