/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registrationform;
import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ahmetduser
 */
public class DataBaseConnection {
    Connection connection;
    
    public DataBaseConnection(){
    }
    
    public DataBaseConnection(Connection connection){
        this.connection = connection;
    }
    
    public static Connection getConnection(){
        Connection connection = null;

        String dbUrl = "jdbc:mysql://127.0.0.1:3306/LoginForm"; // hostname:localhost, portNumber:3306, database: LoginForm
        String user = "";       //enter sql connection user name
        String pass = "";       // enter sql connection password 
        try {
            //driver setup for database
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(dbUrl, user, pass);
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Cannot find the driver in the classpath!", e);
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
        return connection;
    }
}
