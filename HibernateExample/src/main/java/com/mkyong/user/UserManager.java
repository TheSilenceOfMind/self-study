package com.mkyong.user;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class UserManager {

    private SessionFactory factory;

    public UserManager(SessionFactory factory) {
        this.factory = factory;
    }

    public int addUser(DBUser user) {
        Session session = factory.openSession();
        Transaction tx = null;
        int ret = -1;

        try {
            tx = session.beginTransaction();
            ret = (int) session.save(user);
            tx.commit();
        } catch(HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return ret;
    }

    public List<DBUser> listUsers() {
        Session session = factory.openSession();
        Transaction tx = null;
        List<DBUser> users = null;

        try {
            tx = session.beginTransaction();
            users = session.createQuery("FROM DBUser").list();
            tx.commit();
        } catch(HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return users;
    }

    public void updateUser(int id, String newUsername) {
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            DBUser user = (DBUser) session.get(DBUser.class, id);
            user.setUsername(newUsername);
            session.update(user);
            tx.commit();
        } catch(Exception e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void removeUser(int id) {
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.delete(session.get(DBUser.class, id));
            tx.commit();
        } catch(Exception e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

}
