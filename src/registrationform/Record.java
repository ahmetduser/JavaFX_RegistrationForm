/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registrationform;

import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author ahmetduser
 */
public class Record {

    private String userName;
    private String mail;
    private String pass;
    private String country;
    private String city;

    public Record() {

    }

    public Record(String userName, String mail, String pass, String country, String city) {
        this.userName = userName;
        this.mail = mail;
        this.pass = pass;
        this.country = country;
        this.city = city;
    }

    public void usersTable() {

        try (Connection conn = DataBaseConnection.getConnection()) {

            // The mysql insert statement for table users_table
            String query = " insert into users_table (User_Name, Date)"
                    + " values (?, ?)";

            // Create a sql date object so we can use it in our INSERT statement
            java.sql.Date sqlDate = new java.sql.Date(System.currentTimeMillis());

            // Create the mysql insert prepared statement
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, userName);
            preparedStmt.setDate(2, sqlDate);

            // Execute the preparedstatement
            preparedStmt.execute();

            conn.close();
        } catch (SQLException e) {
            System.out.println("Cannot connect the database!" + e.getMessage());
        }
        System.out.println("Data has been sent to users_table");
    }

    public void loginInfoTable() {
        try (Connection conn = DataBaseConnection.getConnection()) {

            // The mysql insert statement for table users_table
            String query = " insert into login_info (User_Name, Mail, Password, Country, City, Date)"
                    + " values (?, ?, ?, ?, ?, ?)";

            // Create a sql date object so we can use it in our INSERT statement
            java.sql.Date sqlDate = new java.sql.Date(System.currentTimeMillis());

            // Create the mysql insert prepared statement
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, userName);
            preparedStmt.setString(2, mail);
            preparedStmt.setString(3, pass);
            preparedStmt.setString(4, country);
            preparedStmt.setString(5, city);
            preparedStmt.setDate(6, sqlDate);

            // Execute the preparedstatement
            preparedStmt.execute();

            conn.close();
        } catch (SQLException e) {
            System.out.println("Cannot connect the database!" + e.getMessage());
        }
        System.out.println("Data has been sent to login_info");
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}
