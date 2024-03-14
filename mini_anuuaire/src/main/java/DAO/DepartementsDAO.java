/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DB.JDBC;
import Entity.Departement;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *

 */
public class DepartementsDAO {
    public ArrayList<Departement> getAll() throws SQLException{  
        ResultSet resultSet = JDBC.select("select * from departements");
        return this.transformResultSetToDepartementsArrayList(resultSet);
    }
    
    public ArrayList<Departement> getDepartementByLabel(String depLabel) throws SQLException{  
        ResultSet resultSet = JDBC.select("select * from departements  where label like '%"+depLabel+"%' ");
        return this.transformResultSetToDepartementsArrayList(resultSet);
    }
    
    public Integer getCount() throws SQLException{
        ResultSet resultSet = JDBC.select("select count(*) from departements");
        resultSet.next();
        return resultSet.getInt(1);    }
    
    public Integer save(Departement departement) throws SQLException{  
        return JDBC.execut("insert into departements(label) values('"+departement.getLabel()+"')");
    }
    
    public Integer destroy(Departement departement) throws SQLException{  
        return JDBC.execut("delete from departements where label='"+departement.getLabel()+"'");
    }
    
     public ArrayList<Departement> transformResultSetToDepartementsArrayList(ResultSet resultSet) throws SQLException{
        ArrayList<Departement> departements = new ArrayList<>();
        while(resultSet.next()){
            String label = resultSet.getString("label");          
            Departement departement = new Departement(label);
            departements.add(departement);
        }
        return departements;
    }
    
    /*public Integer updateDepartement(Departement departement) throws SQLException{  
        return JDBC.execut("update departements set label='"+departement.getLabel()+"' where label='"+departement.getLabel()+"'");
    }*/

}


