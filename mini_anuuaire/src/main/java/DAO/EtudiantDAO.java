/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DB.JDBC;
import Entity.Departement;
import Entity.Filiere;
import Entity.Etudiant;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 *
 */
public class EtudiantDAO {

    public EtudiantDAO() {
    }
    
    public ArrayList<Etudiant> getAll() throws SQLException{  
        ResultSet resultSet = JDBC.select("select * from etudiants"); 
        return this.transformResultSetToEtudiantsArrayList(resultSet);
    }
    
    public ArrayList<Etudiant> getEtudiantsByHint(String hint,String filiere,String departement) throws SQLException{  
        ResultSet resultSet = JDBC.select("select * from etudiants where ( CNE like '%"+hint+"%' or nom like '%"+hint+
                "%' or prenom like '%"+hint+"%' or telephone like '%"+hint+"%' ) and (filiere like '%"+filiere+
                "%' and departement like '%"+departement+"%');");
        return this.transformResultSetToEtudiantsArrayList(resultSet);
    }
    
    public Etudiant getOneById(Integer cne) throws SQLException{
        ResultSet resultSet = JDBC.select("select * from etudiants where CNE='"+cne+"'");
        Etudiant etudiant = new Etudiant();
        while(resultSet.next()){
            Integer CNE = resultSet.getInt("CNE");
            String nom = resultSet.getString("nom");
            String prenom = resultSet.getString("prenom");
            String filiereLabel = resultSet.getString("filiere");
            String departementLabel = resultSet.getString("departement");
            String telephone = resultSet.getString("telephone");
            
            Departement departement = new Departement(departementLabel);
            Filiere filiere = new Filiere(filiereLabel,departement);
            etudiant.setCNE(CNE);
            etudiant.setNom(nom);
            etudiant.setPrenom(prenom);
            etudiant.setFiliere(filiere);
            etudiant.setDepartement(departement);
            etudiant.setTelephone(telephone);           
        }
        return etudiant;
    }
    
    public Integer save(Etudiant etudiant) throws SQLException{  
        return JDBC.execut("insert into etudiants(CNE,nom,prenom,filiere,departement,telephone) values('"+
                etudiant.getCNE()+"','"+etudiant.getNom()+"','"+etudiant.getPrenom()+"','"+
                etudiant.getFiliere().getLabel()+"','"+etudiant.getDepartement().getLabel()+"','"
                +etudiant.getTelephone()+"')");
    }
    
    public Integer destroy(Etudiant etudiant) throws SQLException{  
        return JDBC.execut("delete from etudiants where CNE='"+etudiant.getCNE()+"'");
    }
    
    public Integer updateEtudiant(Etudiant etudiant) throws SQLException{  
        return JDBC.execut("update etudiants set nom='"+etudiant.getNom()+"' and prenom='"+etudiant.getPrenom()+
                "' and filiere='"+etudiant.getFiliere().getLabel()+"' and departement='"+
                etudiant.getDepartement().getLabel()+"' and telephone='"+etudiant.getTelephone()+
                "' where CNE='"+etudiant.getCNE()+"'");
    }
    
    public ArrayList<Etudiant> transformResultSetToEtudiantsArrayList(ResultSet resultSet) throws SQLException{
        ArrayList<Etudiant> etudiants = new ArrayList<>();
        while(resultSet.next()){
            Integer CNE = resultSet.getInt("CNE");
            String nom = resultSet.getString("nom");
            String prenom = resultSet.getString("prenom");
            String filiereLabel = resultSet.getString("filiere");
            String departementLabel = resultSet.getString("departement");
            String telephone = resultSet.getString("telephone");
            
            Departement departement = new Departement(departementLabel);
            Filiere filiere = new Filiere(filiereLabel,departement);
            Etudiant etudiant = new Etudiant(CNE, nom, prenom, filiere, departement, telephone);
            etudiants.add(etudiant);
        }
        return etudiants;
    }
}
