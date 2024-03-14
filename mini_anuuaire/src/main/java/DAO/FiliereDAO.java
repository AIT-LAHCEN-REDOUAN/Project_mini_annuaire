/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DB.JDBC;
import Entity.Departement;
import Entity.Filiere;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *

 */
public class FiliereDAO {
    public ArrayList<Filiere> getAll() throws SQLException{  
        ResultSet resultSet = JDBC.select("select * from filieres");
        return this.transformResultSetToFilieresArrayList(resultSet);
    }
    
    public ArrayList<Filiere> getFiliereByLabel(String filLabel) throws SQLException{  
        ResultSet resultSet = JDBC.select("select * from filieres  where label like '%"+filLabel+"%' ");
        return this.transformResultSetToFilieresArrayList(resultSet);
    }
       
    
    public ArrayList<Filiere> getFiliereByDepartement(String depLabel) throws SQLException{  
        ResultSet resultSet = JDBC.select("select * from filieres  where departement like '%"+depLabel+"%' ");
        return this.transformResultSetToFilieresArrayList(resultSet);
    }
    
    public ArrayList<Filiere> getFiliereByHint(String hint,String departement) throws SQLException{  
        ResultSet resultSet = JDBC.select("select * from filieres where ( label like '%"+hint+"%') and (departement like '%"+departement+"%');");
        return this.transformResultSetToFilieresArrayList(resultSet);
    }
    
    public Integer getCount() throws SQLException{
        ResultSet resultSet = JDBC.select("select count(*) from filieres");
        resultSet.next();
        return resultSet.getInt(1);
    }
    
    public Integer save(Filiere filiere) throws SQLException{  
        return JDBC.execut("insert into filieres(label,departement) values('"+filiere.getLabel()+"','"+
                filiere.getDepartement().getLabel()+"')");
    }
    
    public Integer destroy(Filiere filiere) throws SQLException{  
        return JDBC.execut("delete from filieres where label='"+filiere.getLabel()+"'");
    }
    
    public ArrayList<Filiere> transformResultSetToFilieresArrayList(ResultSet resultSet) throws SQLException{
        ArrayList<Filiere> filieres = new ArrayList<>();
        while(resultSet.next()){
            String label = resultSet.getString("label");   
            String departementLabel = resultSet.getString("departement");
            Departement departement = new Departement(departementLabel);
            Filiere filiere = new Filiere(label,departement);
            filieres.add(filiere);
        }
        return filieres;
    }
    
    /*public Integer updateDepartement(Filiere filiere) throws SQLException{  
        return JDBC.execut("update filieres set label='"+filiere.getLabel()+"' and departement='"+filiere.getDepartement().getLabel()+"' where label='"+filiere.getLabel()+"'");
    }*/
}
