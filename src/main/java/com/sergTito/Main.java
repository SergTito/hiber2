package com.sergTito;

import com.sergTito.converter.BirthdayConverter;
import com.sergTito.entity.*;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        CompanyEntity company = CompanyEntity.builder()
                .name("Google")
                .build();

        Configuration configuration = new Configuration();
//        configuration.addAnnotatedClass(UserssEntity.class);
//        configuration.setPhysicalNamingStrategy(new CamelCaseToUnderscoresNamingStrategy());
//        configuration.addAttributeConverter(new BirthdayConverter(),true);
//        configuration.addAnnotatedClass(CompanyEntity.class); //либо в конфиге
        configuration.configure();

        UserssEntity user = UserssEntity.builder()
                .username("Sergeytitanyan@gmail.com")
                .role(Role.ADMIN)
                .personalInfo(PersonalInfo.builder()
                        .lastname("Titanyan")
                        .firstname("Sergey")
                        .birthDate(new Birthday(LocalDate.of(1995, 1, 6)))
                        .build())
                .company(company)
                .build();


        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
            Session session = sessionFactory.openSession();
            try (session) {
                Transaction transaction = session.beginTransaction();

                UserssEntity user1 = session.get(UserssEntity.class, 1L);
//                CompanyEntity company1 = user1.getCompany();
//                String name = company1.getName();
//                Object object = Hibernate.unproxy(company1);
                session.evict(user);

//                session.save(company);
//                session.save(user);

                session.getTransaction().commit();

            }
        }
    }
}