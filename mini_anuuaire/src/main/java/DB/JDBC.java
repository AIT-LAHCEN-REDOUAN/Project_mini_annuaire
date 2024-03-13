package DB;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author KAOUTAR
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
    
    static Connection connectionObject = null;
    
   /* public JDBC(String dbName,String userName,String passWord){
        this.dbName = dbName;
        this.userName = userName;
        this.passWord = passWord;
    }*/
        
    public static void connect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/miniannuaire","root","");
                               
            JDBC.connectionObject = connection;
        }
        catch(Exception e){
            e.printStackTrace();    
        }
               
    }
    
    public static ResultSet select(String query) throws SQLException{
        if(JDBC.connectionObject == null){
            JDBC.connect();
        }    
        Statement statement = JDBC.connectionObject.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        return resultSet;
       
    }
    
    public static Integer execut(String query) throws SQLException{
        if(JDBC.connectionObject == null){
            JDBC.connect();
        }        
        PreparedStatement ps = JDBC.connectionObject.prepareStatement(query);
        return ps.executeUpdate();        
    }
    
    public static void desconnect() throws SQLException{
        JDBC.connectionObject.close();
        JDBC.connectionObject = null ;
    }
    
}
