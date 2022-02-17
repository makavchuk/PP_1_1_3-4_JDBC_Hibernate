package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
//import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import java.util.List;

public class UserServiceImpl implements UserService {

//    UserDaoJDBCImpl userImpl = new UserDaoJDBCImpl();
    UserDaoHibernateImpl userImpl = new UserDaoHibernateImpl();

    public void createUsersTable() {
        userImpl.createUsersTable();
    }

    public void dropUsersTable() {
        userImpl.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        userImpl.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) {
        userImpl.removeUserById(id);
    }

    public List<User> getAllUsers() {
        return userImpl.getAllUsers();
    }

    public void cleanUsersTable() {
        userImpl.cleanUsersTable();
    }
}
