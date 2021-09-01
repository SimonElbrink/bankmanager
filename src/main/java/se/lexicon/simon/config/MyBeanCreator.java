package se.lexicon.simon.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import se.lexicon.simon.data.dao.AccountDao;
import se.lexicon.simon.data.dao.AccountDaoImpl;
import se.lexicon.simon.data.dao.CustomerDao;
import se.lexicon.simon.data.dao.CustomerDaoImpl;
import se.lexicon.simon.service.Factory;
import se.lexicon.simon.service.FactoryImpl;
import se.lexicon.simon.service.InternalTransaction;
import se.lexicon.simon.service.Transaction;

@Configuration
public class MyBeanCreator {

    @Bean
    public CustomerDao customerDao(){
        CustomerDao customerDao = new CustomerDaoImpl();
        return customerDao;
    }

    @Bean
    public AccountDao accountDao(){
        return new AccountDaoImpl();
    }

    @Bean
    public Factory factory(){
        return new FactoryImpl(accountDao(), customerDao());
    }

    @Bean
    public Transaction transaction(){
        InternalTransaction internalTransaction = new InternalTransaction();
        internalTransaction.setAccountDao(accountDao());
        internalTransaction.setCustomerDao(customerDao());
        return internalTransaction;
    }
}
