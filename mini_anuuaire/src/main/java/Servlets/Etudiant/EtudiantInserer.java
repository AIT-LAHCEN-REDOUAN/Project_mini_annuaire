/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets.Etudiant;

import DAO.DepartementsDAO;
import DAO.EtudiantDAO;
import DAO.FiliereDAO;
import Entity.Departement;
import Entity.Etudiant;
import Entity.Filiere;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 *
 */
@WebServlet(name = "EtudiantInserer", urlPatterns = {"/Etudiants/Insertion"})
public class EtudiantInserer extends HttpServlet {

        private DepartementsDAO departementsDAO = new DepartementsDAO();
        private EtudiantDAO etudiantDAO = new EtudiantDAO();

    
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
                ArrayList<Departement> departements = this.departementsDAO.getAll();
                request.setAttribute("departements",departements);
                this.getServletContext().getRequestDispatcher("/webapp/MenuAdministration/InsererEtudiant.jsp").forward(request,response);

            } catch (SQLException ex) {
            System.out.println(ex.getStackTrace());
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
        Departement departement = new Departement(request.getParameter("departementLabel"));
        Filiere filiere = new Filiere(request.getParameter("filieresLabel"),departement);
        Etudiant etudiant = new Etudiant(parseInt(request.getParameter("CNE")),request.getParameter("nom"),
        request.getParameter("prenom"),filiere,departement,request.getParameter("telephone"));
        try {
            this.etudiantDAO.save(etudiant);
            request.getSession().setAttribute("success","l'Etudiant avec CNE "+request.getParameter("CNE")+" a ete ajoute avec success !");;
            response.sendRedirect("/mini_annuaire/Etudiants");
        } catch (SQLException ex) {
            request.getSession().setAttribute("error","erreur dans l'insertion log: "+ex.getMessage());
            response.sendRedirect("/mini_annuaire/Etudiants/Insertion");        }
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
