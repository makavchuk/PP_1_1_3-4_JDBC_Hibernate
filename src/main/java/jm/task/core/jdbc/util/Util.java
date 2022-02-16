package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

    public static String createUserTableStatement = "create table kata.user (id int auto_increment, name text, lastname text, age tinyint, primary key (id)) ;";
    public static String selectAllUserStatement = "select * from kata.user";
    public static String insertUserStatement = "insert into kata.user (id, name, lastname, age) values (?, ?, ?, ?)";
    public static String deleteUserByIDStatement = "delete from kata.user where id = ?";
    public static String deleteAllUsersStatement = "delete from kata.user";
    public static String dropUserTableStatement = "drop table kata.user";

    public static Connection getMySQLConnection() throws SQLException, ClassNotFoundException {
        String hostName = "localhost";
        String dbName = "kata";
        String userName = "user";
        String password = "password";

        String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;

        Connection conn = DriverManager.getConnection(connectionURL, userName, password);
        return conn;
    }

}
