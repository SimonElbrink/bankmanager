package se.lexicon.simon.service;


import se.lexicon.simon.data.dao.AccountDao;
import se.lexicon.simon.data.dao.CustomerDao;
import se.lexicon.simon.model.Account;

import java.util.NoSuchElementException;


public class InternalTransaction implements Transaction {

    private AccountDao accountDao;
    private CustomerDao customerDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }


    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public boolean verifyCustomer(Integer authorizeUserID) {
        return customerDao.findById(authorizeUserID).isPresent();
    }

    @Override
    public boolean transfer(Integer authorizedUserID, double amount, String fromAccountNumber, String toAccountNumber) {

        boolean verified = verifyCustomer(authorizedUserID);

        Account from = accountDao.findByAccountNumber(fromAccountNumber).orElseThrow(NoSuchElementException::new);

        Account to = accountDao.findByAccountNumber(toAccountNumber).orElseThrow(NoSuchElementException::new);

        if (verified) {
            if (from.getBalance() >= amount) {
                from.setBalance(from.getBalance() - amount);
                to.setBalance(to.getBalance() + amount);

                boolean fromUpdated = accountDao.update(from);
                boolean toUpdated = accountDao.update(to);

                return fromUpdated & toUpdated;
            }

        }

        return false;
    }
}

