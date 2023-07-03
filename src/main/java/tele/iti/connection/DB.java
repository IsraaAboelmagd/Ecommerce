/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tele.iti.connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author omoor
 */
public class DB {
        
        private static Connection connection = null;
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
        if(connection == null){
            Class.forName("org.postgresql.Driver");
            connection =DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
            "postgres", "15987");
            System.out.print("connected");
        }
        return connection;
    }
}

    

