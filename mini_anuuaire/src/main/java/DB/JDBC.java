package DB;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class JDBC {
    //private String dbName;
    //private String userName;
    //private String passWord;
    
    static Connection connectionObject;
    
   /* public JDBC(String dbName,String userName,String passWord){
        this.dbName = dbName;
        this.userName = userName;
        this.passWord = passWord;


    }*/
    public static void connect() throws ClassNotFoundException {

        //Class.forName("com.mysql.jdbc.Driver");
        try {
            // Establish connection if not already connected
            if (connectionObject == null || connectionObject.isClosed()) {
                connectionObject = DriverManager.getConnection("jdbc:mysql://localhost:3306/miniannuaire", "root", "");
            }
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database:");
            e.printStackTrace();
        }
    }


    public static ResultSet select(String query) throws SQLException{
        try {
            connect();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        Statement statement = JDBC.connectionObject.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        return resultSet;
       
    }
    
    public static Integer execut(String query) throws SQLException{
        try {
            connect();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        PreparedStatement ps = JDBC.connectionObject.prepareStatement(query);
        return ps.executeUpdate();        
    }

    public static void disconnect() throws SQLException {
        if (connectionObject != null && !connectionObject.isClosed()) {
            connectionObject.close();
        }
    }
    
}
