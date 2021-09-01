package se.lexicon.simon.data.dao;

import se.lexicon.simon.model.Account;

import java.util.Optional;

public interface AccountDao extends GenericDao<Account, Integer>{

    Optional<Account> findByAccountNumber(String accountNumber);

}
