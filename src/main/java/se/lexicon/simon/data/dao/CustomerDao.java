package se.lexicon.simon.data.dao;

import se.lexicon.simon.model.Customer;

import java.util.Optional;

public interface CustomerDao extends GenericDao<Customer, Integer>{

    Optional<Customer> findByName(String name);

}
