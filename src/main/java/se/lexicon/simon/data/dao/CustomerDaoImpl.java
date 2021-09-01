package se.lexicon.simon.data.dao;

import org.springframework.stereotype.Component;
import se.lexicon.simon.model.Customer;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;

public class CustomerDaoImpl implements CustomerDao{


    Collection<Customer> storage = null;

    public CustomerDaoImpl() {
        this.storage = new HashSet<>();
    }

    @Override
    public Optional<Customer> findByName(String name) {
        return storage.stream()
                .filter(customer -> customer.getName().equalsIgnoreCase(name))
                .findFirst();
    }

    @Override
    public Optional<Customer> create(Customer customer) {
        storage.add(customer);
        return findById(customer.getId());
    }

    @Override
    public Optional<Customer> findById(Integer id) {
        return storage.stream()
                .filter(customer -> customer.getId() == id)
                .findFirst();
    }

    @Override
    public Collection<Customer> findAll() {
        return storage;
    }

    @Override
    public boolean update(Customer customer) {
        storage.removeIf(c -> c.getId() == customer.getId());
        return storage.add(customer);
    }

    @Override
    public boolean delete(Integer id) {
        return storage.removeIf(customer -> customer.getId() == id);
    }
}
