package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {

    /// JDBC

    public static String createUserTableStatement = "create table kata.user (id int auto_increment, name text, lastname text, age tinyint, primary key (id))";
    public static String selectAllUserStatement = "select * from kata.user";
    public static String insertUserStatement = "insert into kata.user (id, name, lastname, age) values (?, ?, ?, ?)";
    public static String deleteUserByIDStatement = "delete from kata.user where id = ?";
    public static String deleteAllUsersStatement = "delete from kata.user";
    public static String dropUserTableStatement = "drop table kata.user";

    public static Connection getMySQLConnection() throws SQLException {
        String hostName = "localhost";
        String dbName = "kata";
        String userName = "user";
        String password = "password";

        String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;

        return DriverManager.getConnection(connectionURL, userName, password);
    }

    //// Hibernate

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Properties properties = new Properties();

                properties.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
                properties.put(Environment.URL, "jdbc:mysql://localhost:3306/kata");
                properties.put(Environment.USER, "user");
                properties.put(Environment.PASS, "password");
                properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
                properties.put(Environment.SHOW_SQL, "false");

                sessionFactory = new Configuration().setProperties(properties)
                                                    .addAnnotatedClass(User.class)
                                                    .buildSessionFactory();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}