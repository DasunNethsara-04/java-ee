package util;

import entity.CustomerEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryConfiguration {
    private static FactoryConfiguration instance;
    private final SessionFactory factory;

    private FactoryConfiguration() {
        Configuration configure = new Configuration().configure()
                .addAnnotatedClass(CustomerEntity.class);
        factory = configure.buildSessionFactory();
    }

    public static FactoryConfiguration getInstance() {
        return instance == null ? instance = new FactoryConfiguration() : instance;
    }

    public Session getSession() {
        return factory.openSession();
    }
}