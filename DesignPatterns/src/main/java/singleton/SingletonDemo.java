package singleton;

import singleton.DbSingleton;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by sczerwinski on 2016-01-15.
 */
public class SingletonDemo {
    public static void main (String[]args){
        long timeBefore = 0;
        long timeAfter = 0;

        DbSingleton instance = DbSingleton.getInstance();
        timeBefore = System.currentTimeMillis();
        Connection conn = instance.getConnection();
        timeAfter = System.currentTimeMillis();

        System.out.println( timeAfter = timeBefore);

        Statement statement;
        try{
            statement = conn.createStatement();
            int count = statement.executeUpdate("CREATE TABLE Address (ID INT, StreetName VARCHAR(20), CITY VARCHAR(20))");
            System.out.println("Table created");
            statement.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
//        System.out.println(instance);
//        singleton.DbSingleton anotherInstance = singleton.DbSingleton.getInstance();
//        System.out.println(anotherInstance);

        timeBefore = System.currentTimeMillis();
        conn = instance.getConnection();
        timeAfter = System.currentTimeMillis();
        System.out.println( timeAfter = timeBefore);

    }
}
