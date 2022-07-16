package jm.task.core.jdbc;


import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;


import java.util.List;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь

        UserServiceImpl userService = new UserServiceImpl();


        /*
            1. Создание таблицы.
            2. Создание 4-х экземпляров класса User
            3. Добавление экземпляров.
            4. Получение всех Юзеров и вывод на консоль через цикл ниже
            5. Очистка таблицы.
            6. Удаление таблицы.
         */
        userService.createUsersTable();
        userService.saveUser("Leonardo", "Blue", (byte)15);
        userService.saveUser("Rafael", "Red", (byte)15);
        userService.saveUser("Donatello", "Purple", (byte)15);
        userService.saveUser("Mikelangelo", "Orange", (byte)15);
        List<User> list = userService.getAllUsers();
        for (User l: list
        ) {
            System.out.println(l);
        }

        userService.cleanUsersTable();
        userService.dropUsersTable();





    }
}
