package se.lexicon.simon.service;


import se.lexicon.simon.data.dao.AccountDao;
import se.lexicon.simon.data.dao.CustomerDao;
import se.lexicon.simon.model.Account;
import se.lexicon.simon.model.Customer;

import java.util.Optional;

import java.util.UUID;

public class FactoryImpl implements Factory {

    private AccountDao accountDao;
    private CustomerDao customerDao;

    public FactoryImpl(AccountDao accountDao, CustomerDao customerDao) {
        this.accountDao = accountDao;
        this.customerDao = customerDao;
    }

    @Override
    public Optional<Account> createAccount() {
        return accountDao.create(new Account(0, UUID.randomUUID().toString(), 0));
    }

    @Override
    public Optional<Account> createAccount(int id) {
        return accountDao.create(new Account(id, UUID.randomUUID().toString(), 0));
    }

    @Override
    public Optional<Customer> createCustomer(String name) {
        return customerDao.create(new Customer(0,name));
    }

    @Override
    public Optional<Customer> createCustomer(int id, String name) {
        return customerDao.create(new Customer(id,name));
    }
}
