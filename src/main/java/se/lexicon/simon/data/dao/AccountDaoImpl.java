package se.lexicon.simon.data.dao;

import org.springframework.stereotype.Component;
import se.lexicon.simon.model.Account;

import java.util.Collection;

import java.util.HashSet;
import java.util.Optional;

public class AccountDaoImpl implements AccountDao{

    Collection<Account> storage = null;

    public AccountDaoImpl() {
        this.storage = new HashSet<>();
    }

    @Override
    public Optional<Account> findByAccountNumber(String accountNumber) {
        return storage.stream().filter(a -> a.getAccountNumber().equals(accountNumber)).findFirst();
    }

    @Override
    public Optional<Account> create(Account account) {
               storage.add(account);
               return findById(account.getId());
    }

    @Override
    public Optional<Account> findById(Integer id) {
        return storage.stream()
                .filter(account -> account.getId() == id)
                .findFirst();
    }

    @Override
    public Collection<Account> findAll() {
        return storage;
    }

    @Override
    public boolean update(Account account) {
        storage.removeIf(a ->  a.getId() == account.getId());
        return storage.add(account);
    }

    @Override
    public boolean delete(Integer id) {
        return storage.removeIf(account -> account.getId() == id);
    }
}
