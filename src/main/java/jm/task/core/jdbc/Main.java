package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {

    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();

        //Создание таблицы User(ов)
        userService.createUsersTable();

        // Добавление 4 User(ов) в таблицу с данными на свой выбор.
        // После каждого добавления должен быть вывод в консоль ( User с именем – name добавлен в базу данных )
        userService.saveUser("Ivan", "Ivansov", (byte)10);
        userService.saveUser("Marat", "Shatunof", (byte)12);
        userService.saveUser("Sidor", "Balabsov", (byte)56);
        userService.saveUser("Nikolay", "Krevtsov", (byte)19);

        //Получение всех User из базы и вывод в консоль ( должен быть переопределен toString в классе User)
        userService.getAllUsers().forEach(System.out::println);

        //Очистка таблицы User(ов)
        userService.getAllUsers().forEach(u -> userService.removeUserById(u.getId()));

        //Удаление таблицы
        userService.dropUsersTable();

    }
}
