package singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by sczerwinski on 2016-01-15.
 */
public class DbSingleton {

    //Lazy loading
    public static DbSingleton instance = null;
    private Connection conn = null;

    private DbSingleton (){
        try{
            DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static DbSingleton getInstance(){
        if (instance == null){
            //Thread safe
            synchronized (DbSingleton.class){
                //lazy loading
                if (instance == null){
                    instance = new DbSingleton();
                }
            }
        }
        return instance;
    }

    public Connection getConnection(){
        if(conn == null) {
            synchronized (DbSingleton.class){
                if(conn == null){
                    try{
                        String dbUrl = "jdbc:derby:memory:codejava/webdb;create=true";
                        conn = DriverManager.getConnection(dbUrl);
                    }catch (SQLException e){
                        e.printStackTrace();
                    }
                }
            }
        }
        return conn;
    }
}
