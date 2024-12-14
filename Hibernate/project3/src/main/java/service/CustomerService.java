package service;

import dto.CustomerDTO;
import entity.CustomerEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import repo.CustomerRepo;
import util.FactoryConfiguration;

public class CustomerService {
    private final CustomerRepo customerRepo;

    public CustomerService() {
        this.customerRepo = new CustomerRepo();
    }

    public CustomerDTO saveCustomer(CustomerDTO customer) {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setId(customer.getId());
        customerEntity.setName(customer.getName());
        customerEntity.setCity(customer.getCity());
        Session session = null;
        Transaction transaction = null;
        
        try {
            session = FactoryConfiguration.getInstance().getSession();
            transaction = session.beginTransaction();
            customerRepo.saveCustomer(session, customerEntity);
            transaction.commit();
            return customer;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }
        return null;
    }
}
