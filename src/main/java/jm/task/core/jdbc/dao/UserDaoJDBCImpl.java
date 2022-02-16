package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static jm.task.core.jdbc.util.Util.*;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        try (Connection connection = Util.getMySQLConnection()) {
            connection.createStatement().execute(Util.createUserTableStatement);
        } catch (Exception e) {
            System.out.println("Hidden createUsersTable exception: " + e.getMessage());
        }
    }

    public void dropUsersTable() {
        try (Connection connection = Util.getMySQLConnection()) {
            connection.createStatement().execute(Util.dropUserTableStatement);
        } catch (Exception e) {
            System.out.println("Hidden dropUsersTable exception: " + e.getMessage());
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        try (Connection connection = Util.getMySQLConnection();
             PreparedStatement statement = connection.prepareStatement(insertUserStatement)) {

            statement.setInt(1, 0);
            statement.setString(2, name);
            statement.setString(3, lastName);
            statement.setByte(4, age);

            statement.execute();

            System.out.println("User с именем – " + name + " добавлен в базу данных");

        } catch (Exception e) {
            System.out.println("Hidden saveUser exception: " + e.getMessage());
        }
    }

    public void removeUserById(long id) {
        try (Connection connection = Util.getMySQLConnection();
             PreparedStatement statement = connection.prepareStatement(deleteUserByIDStatement)) {

            statement.setLong(1, id);
            statement.execute();

        } catch (Exception e) {
            System.out.println("Hidden removeUserById exception: " + e.getMessage());
        }
    }

    public List<User> getAllUsers() {
        List<User> result = new ArrayList<>();

        try (Connection connection = Util.getMySQLConnection();
             Statement statement = connection.createStatement()) {

            ResultSet allUsers = statement.executeQuery(selectAllUserStatement);

            while (allUsers.next()) {
                User user = new User(allUsers.getString("name"),
                        allUsers.getString("lastName"),
                        allUsers.getByte("age"));
                user.setId(allUsers.getLong("id"));
                result.add(user);
            }

        } catch (Exception e) {
            System.out.println("Hidden getAllUsers exception: " + e.getMessage());
        }

        return result;
    }

    public void cleanUsersTable() {
        try (Connection connection = Util.getMySQLConnection()) {
            connection.createStatement().execute(deleteAllUsersStatement);
        } catch (Exception e) {
            System.out.println("Hidden cleanUsersTable exception: " + e.getMessage());
        }
    }

}
