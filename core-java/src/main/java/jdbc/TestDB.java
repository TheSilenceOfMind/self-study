package jdbc;

import java.sql.*;
import java.util.*;

public class TestDB {
    public static void main(String... args) throws SQLException {
        TestDB app = new TestDB();
        if (!app.loadClass("org.postgresql.Driver")) return;

        Optional<Connection> c = app.getConnection();
        if (!c.isPresent()) {
            System.out.println("No connection");
            return;
        }
        Connection con = c.get();

        app.printDataBaseInfo(con);
        con.createStatement();
    }

    private void printDataBaseInfo(Connection con) {
        try {
            DatabaseMetaData metaData = con.getMetaData();
            System.out.print("DBMS info: ");
            System.out.println(metaData.getDatabaseProductName() + " " + metaData.getDatabaseProductVersion());
        } catch (SQLException e) {
            System.err.println("can't get metadata!");
        }
    }

    boolean loadClass(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException e) {
            System.err.println("driver isn't registered");
            return false;
        }
    }

    Optional<Connection> getConnection() {
        try {
            return Optional.of(DriverManager.getConnection("jdbc:postgresql://localhost:5432/TestDB",
                    "postgres",
                    "root"));
        } catch (SQLException e) {
            System.err.println("can't get connection.");
            return Optional.empty();
        }
    }
}
