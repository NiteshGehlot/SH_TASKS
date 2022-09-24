//DATABASE CONNECTION CLASS
//ONLY CONNECTION COMMANDS ARE WRITTEN IN THIS CLASS

package com.database;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {
    public static Connection getDBConnection() {

        Connection conn = null;

        try {

            FileReader reader = new FileReader("database.properties");

            Properties prop = new Properties();

            prop.load(reader);

            String url = prop.getProperty("url");

            String username = prop.getProperty("username");

            String password = prop.getProperty("password");

            conn = DriverManager.getConnection(url,username,password);

        }  catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return conn;

    }
}
