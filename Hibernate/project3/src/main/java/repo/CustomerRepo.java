package repo;

import entity.CustomerEntity;
import org.hibernate.Session;

public class CustomerRepo {
    public CustomerEntity saveCustomer(Session session, CustomerEntity customer) {
        try {
            session.save(customer);
            return customer;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
