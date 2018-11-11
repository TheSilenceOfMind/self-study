package com.mkyong;

import java.util.Date;

import org.hibernate.*;
import com.mkyong.util.HibernateUtil;
import com.mkyong.user.DBUser;

public class App {

    private static final SessionFactory factory = HibernateUtil.getSessionFactory();

    public static void main(String[] args) {
        insertNewGeneratedRow(factory.openSession());
    }

    private static void insertNewGeneratedRow(Session session) {
        session.beginTransaction();
        DBUser user = new DBUser();

        user.setUsername("superman");
        user.setCreatedBy("system");
        user.setCreatedDate(new Date());
        session.save(user);

        session.getTransaction().commit();
    }
}