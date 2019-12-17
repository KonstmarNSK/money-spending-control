package com.kostya.moneycontrol.data.repos.impl;

import com.kostya.moneycontrol.data.MonthId;
import com.kostya.moneycontrol.data.model.MonthInfo;
import com.kostya.moneycontrol.data.repos.IMonthRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManagerFactory;

@Repository
public class MonthRepository implements IMonthRepository {
    private SessionFactory sessionFactory;

    @Autowired
    public MonthRepository(EntityManagerFactory emFactory) {
        sessionFactory = emFactory.unwrap(SessionFactory.class);
        if (sessionFactory == null) {
            throw new IllegalStateException("No hibernate session factory in the context");
        }
    }

    @Override
    public MonthInfo getMonthInfo(long monthId) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(MonthInfo.class, monthId);
    }

    @Override
    public long saveMonthInfo(MonthInfo monthInfo) {
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();

        session.save(monthInfo);

        tx.commit();

        return monthInfo.getId();
    }
}
