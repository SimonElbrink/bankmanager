package se.lexicon.simon;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import se.lexicon.simon.config.MyBeanCreator;
import se.lexicon.simon.config.MyComponentScan;
import se.lexicon.simon.data.dao.AccountDao;
import se.lexicon.simon.data.dao.AccountDaoImpl;
import se.lexicon.simon.data.dao.CustomerDao;
import se.lexicon.simon.data.dao.CustomerDaoImpl;
import se.lexicon.simon.model.Account;
import se.lexicon.simon.service.Factory;
import se.lexicon.simon.service.FactoryImpl;
import se.lexicon.simon.service.InternalTransaction;

public class App 
{
    public static void main( String[] args )
    {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyBeanCreator.class);

        AccountDao accountDao = context.getBean("accountDaoImpl", AccountDao.class);

        Factory factory = context.getBean("factoryImpl", Factory.class);

        factory.createAccount();

        accountDao.findAll().forEach(System.out::println);

//        noDI();
    }

    private static void noDI() {
        AccountDao accountDao = new AccountDaoImpl();
        CustomerDao customerDao = new CustomerDaoImpl();

        accountDao.create(new Account(1230, "09sdjke9982", 100000000.0));

        Factory factory = new FactoryImpl(accountDao, customerDao);

        InternalTransaction transaction = new InternalTransaction();
        transaction.setCustomerDao(customerDao);
        transaction.setAccountDao(accountDao);

        factory.createAccount().ifPresent(System.out::println);

        System.out.println("find all");
        accountDao.findAll().forEach(System.out::println);
    }
}
