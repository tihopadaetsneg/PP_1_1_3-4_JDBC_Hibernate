package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    // Вот тут мне нужно сделать всю логику

    //Необходимо 6 строк - 6 SQL команд для передачи в Statement
    private static final String SQL_CREATE = "CREATE TABLE Users " +
            "(id BIGINT NOT NULL AUTO_INCREMENT," +
            " name VARCHAR(255)," +
            " lastName VARCHAR(255), " +
            " age TINYINT," +
            " PRIMARY KEY(id));";
    private static final String DELETE_IF_EXIST = "DROP TABLE IF EXISTS Users;";
    // нужно по 3 параметрам, потому что в методе сохранения нет параметра "id", следовательно его нужно сделать автоинкрементом
    private static final String INSERT_USER = "INSERT INTO users(name, lastName, age) VALUES (?, ?, ?);";
    private static final String DELETE_USER = "DELETE FROM Users WHERE id = ?;";
    private static final String GET_ALL_USERS = "SELECT * FROM Users;";
    private static final String DELETE_ALL_USERS = "DELETE FROM users WHERE id > 0;";
    public UserDaoJDBCImpl() {
        //Пустой конструктор по умолчанию
        // Хотя я и не ебу нахуй он нужен
        //upd Или нет
    }

    // DONE!
    public void createUsersTable() {
        try (Connection connection = Util.getConnection(); PreparedStatement stat = connection.prepareStatement(DELETE_IF_EXIST)) {
            stat.executeUpdate();
            stat.executeUpdate(SQL_CREATE);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DONE!
    public void dropUsersTable() {
        try (Connection connection = Util.getConnection(); PreparedStatement stat = connection.prepareStatement(DELETE_IF_EXIST)) {
            stat.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // DONE!
    public void saveUser(String name, String lastName, byte age) {
        try (Connection connection = Util.getConnection(); PreparedStatement stat = connection.prepareStatement(INSERT_USER)) {
            stat.setString(1, name);
            stat.setString(2, lastName);
            stat.setByte(3, age);
            stat.executeUpdate();
            System.out.println(name + " добавлен в базу данных.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //DONE!
    public void removeUserById(long id) {
        try (Connection connection = Util.getConnection(); PreparedStatement stat = connection.prepareStatement(DELETE_USER)) {
            stat.setLong(1, id);
            stat.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //DONE!
    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();
        try (Connection connection = Util.getConnection(); PreparedStatement stat = connection.prepareStatement(GET_ALL_USERS)) {
            ResultSet rs = stat.executeQuery();
            while (rs.next()){
                long id = rs.getLong("id");
                String name = rs.getString("name");
                String lastName = rs.getString("lastName");
                byte age = rs.getByte("age");
                User user = new User(name, lastName, age);
                user.setId(id);
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    //DONE!
    public void cleanUsersTable() {
        try (Connection connection = Util.getConnection(); PreparedStatement stat = connection.prepareStatement(DELETE_ALL_USERS)) {
            stat.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
