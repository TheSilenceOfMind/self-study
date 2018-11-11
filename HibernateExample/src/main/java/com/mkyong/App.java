package com.mkyong;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import com.mkyong.user.UserManager;
import org.hibernate.*;
import com.mkyong.util.HibernateUtil;
import com.mkyong.user.DBUser;

public class App {

    private static final SessionFactory factory = HibernateUtil.getSessionFactory();

    public static void main(String[] args) {
        UserManager manager = new UserManager(factory);

        List<Integer> ids = manager.listUsers().stream()
                .map(DBUser::getUserId)
                .collect(Collectors.toList());
        for (int i = 0; i < 3; i++) {
            ids.add(
                    manager.addUser(
                            new DBUser("u" + i,
                                    "c" + i,
                                    new Date(new Random().nextInt()))
                    )
            );
        }
        System.out.println(manager.listUsers());

        manager.updateUser(ids.get(new Random().nextInt(ids.size())), "newUsername!!!");
        System.out.println(manager.listUsers());

        manager.removeUser(ids.get(new Random().nextInt(ids.size())));
        System.out.println(manager.listUsers());
    }
}