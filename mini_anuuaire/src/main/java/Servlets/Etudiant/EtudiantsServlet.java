/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets.Etudiant;

import DAO.DepartementsDAO;
import DAO.EtudiantDAO;
import Entity.Departement;
import Entity.Etudiant;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 *
 */
@WebServlet(name = "EtudiantsServlet", urlPatterns = {"/Etudiants"})
public class EtudiantsServlet extends HttpServlet {
    
    private EtudiantDAO etudiantDAO = new EtudiantDAO();
    private DepartementsDAO departementsDAO = new DepartementsDAO();

   /* public void init(EtudiantDAO etudiantDAO){
        this.etudiantDAO = etudiantDAO;
    }*/
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            
            ArrayList<Etudiant> etudiants = this.etudiantDAO.getAll();
            ArrayList<Departement> departements = this.departementsDAO.getAll();
            request.setAttribute("departements",departements);
            request.setAttribute("etudiants",etudiants);
            this.getServletContext().getRequestDispatcher("/webapp/MenuUtilisation/EtudiantsList.jsp").forward(request,response);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }


    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
