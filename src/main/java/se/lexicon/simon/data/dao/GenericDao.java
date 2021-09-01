package se.lexicon.simon.data.dao;


import java.util.Collection;
import java.util.Optional;

public interface GenericDao <T,ID> {

    Optional<T> create(T t);
    Optional<T> findById(ID id);
    Collection<T> findAll();
    boolean update(T t);
    boolean delete(ID id);

}
