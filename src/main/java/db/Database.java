package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    // Declare the connection outside the try/catch block to allow you
    // return it after the commands have been executed.

    public static Connection DbConn() {

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://babar.db.elephantsql.com/fffevyfd",
                    "fffevyfd",
                    "X_9pAtfbrVyZUUE0R2wLY2xsDS1t2YaY");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }
}