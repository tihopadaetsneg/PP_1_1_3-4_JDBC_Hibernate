package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    /*
        1. Благодаря тому, что драйвер указан в POM.xml - мне нет необходимости закидывать jar драйвера,
            добавлять его в структуру проекта и регистрировать здесь.
        2. В методе getConnection программа пытается из зарегистрированных драйверов найти тот,
            котороый подходит по URL
        3. Дальше уже у самого MySQL есть реализцаии различных методов из jdbc
     */
    private static final String URL = "jdbc:mysql://localhost:3306/schemapp";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    
    public static Connection getConnection(){
        Connection connection = null;
        try{
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
