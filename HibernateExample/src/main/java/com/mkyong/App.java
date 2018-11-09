package com.mkyong;

import java.util.Date;
import java.util.Optional;

import org.hibernate.*;
import com.mkyong.util.HibernateUtil;
import com.mkyong.user.DBUser;

public class App {

    private static int id = -1;
    private static final SessionFactory factory = HibernateUtil.getSessionFactory();
    private static final String GET_MAX_ID_QUERY = "SELECT MAX(USER_ID) FROM DBUSER";

    public static void main(String[] args) {
        insertNewGeneratedRow(factory.openSession());
    }

    private static void insertNewGeneratedRow(Session session) {
        if (id < 0) {
            Object o = session.createSQLQuery(GET_MAX_ID_QUERY).uniqueResult();
            if (o != null)
                id = Integer.valueOf(o.toString());
        }

        session.beginTransaction();
        DBUser user = new DBUser();

        user.setUserId(++id);
        user.setUsername("superman");
        user.setCreatedBy("system");
        user.setCreatedDate(new Date());

        session.save(user);
        session.getTransaction().commit();

    }
}