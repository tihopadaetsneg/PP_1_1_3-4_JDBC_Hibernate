package jm.task.core.jdbc;

// А как импортировать все классы в поддиректориях?
import jm.task.core.jdbc.model.*;
import jm.task.core.jdbc.service.UserServiceImpl;


import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*
            1. Создание таблицы.
            2. Создание 4-х экземпляров класса User
            3. Добавление экземпляров.
            4. Получение всех Юзеров и вывод на консоль через цикл ниже
            5. Очистка таблицы.
            6. Удаление таблицы.
         */
        UserServiceImpl userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Леонардо", "Сплинтерович", (byte)15);
        userService.saveUser("Рафаэль", "Сплинтерович", (byte)15);
        userService.saveUser("Донателло", "Сплинтерович", (byte)15);
        userService.saveUser("Миккиланджело", "Сплинтерович", (byte)15);
        List<User> list = userService.getAllUsers();
        for (User l: list
        ) {
            System.out.println(l);
        }

        userService.cleanUsersTable();
        userService.dropUsersTable();





    }
}
