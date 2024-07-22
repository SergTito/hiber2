package com.sergTito;

import com.sergTito.entity.UserssEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Configuration configuration = new Configuration();
//        configuration.addAnnotatedClass(UserssEntity.class);
//        configuration.setPhysicalNamingStrategy(new CamelCaseToUnderscoresNamingStrategy());
        configuration.configure();


        try (SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            UserssEntity user = UserssEntity.builder()
                    .username("SergeyTito@gmail.com")
                    .firstname("Sergey")
                    .lastname("Tito")
                    .birthdate(LocalDate.of(1995,6,1))
                    .age(29)
                    .build();

            session.persist(user);
            session.getTransaction().commit();

        }
    }
}
