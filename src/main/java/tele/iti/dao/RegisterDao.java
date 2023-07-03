/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tele.iti.dao;
//db connection***************************

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import tele.iti.data.User;


public class RegisterDao {

    public int registerUser(User user) throws ClassNotFoundException, SQLException {
        String INSERT_USERS_SQL = "INSERT INTO test1" +
            "  (username,email,password,phone,birthday) VALUES " +
            " (?,?,?,?,?);";

        int result = 0;

//        Class.forName("com.mysql.jdbc.Driver");
            DriverManager.registerDriver(new org.postgresql.Driver());

        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1/ecommerce","postgres","15987");

            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);){
            

            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getPhone());
            preparedStatement.setString(5, user.getBirthday());

           result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
        
            printSQLException(e);
        }



        return result;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}

    
    
    
   
