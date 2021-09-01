package se.lexicon.simon;

import se.lexicon.simon.data.dao.AccountDao;
import se.lexicon.simon.data.dao.AccountDaoImpl;
import se.lexicon.simon.data.dao.CustomerDao;
import se.lexicon.simon.data.dao.CustomerDaoImpl;
import se.lexicon.simon.model.Account;
import se.lexicon.simon.service.Factory;
import se.lexicon.simon.service.FactoryImpl;
import se.lexicon.simon.service.InternalTransaction;
import se.lexicon.simon.service.Transaction;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {




        noDI();
    }

    private static void noDI() {
        AccountDao accountDao = new AccountDaoImpl();
        CustomerDao customerDao = new CustomerDaoImpl();

        accountDao.create(new Account(1230, "09sdjke9982", 100000000.0));

        Factory factory = new FactoryImpl(accountDao, customerDao);
        Transaction transaction = new InternalTransaction(accountDao, customerDao);

        factory.createAccount().ifPresent(System.out::println);

        System.out.println("find all");
        accountDao.findAll().forEach(System.out::println);
    }
}
