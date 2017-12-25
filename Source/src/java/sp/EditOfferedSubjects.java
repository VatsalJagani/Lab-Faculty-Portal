/*
 * This is Dharmsinh Desai University Facuty Portal Project
 * Author : Vatsal Jagani  * 
 * Guide : Prof. Sidharth Shah  * 
 * All rights are reserved. @copyright  * 
 */
package sp;

import gen.Subject;
import hibernate.HibernateUtil;
import hibernate.pojos.SemesterWiseSubjects;
import hibernate.pojos.SemesterWiseSubjectsId;
import hibernate.pojos.SubjectsMaster;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author VATSAL
 */
public class EditOfferedSubjects extends HttpServlet {

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
        Session session = HibernateUtil.getSessionFactory().openSession();
        ArrayList<Integer> offered = new ArrayList<Integer>();
        for (String sub : request.getParameterValues("subjects")) {
            try {
                int subId = Integer.parseInt(sub);
                offered.add(subId);
            } catch (Exception e) {
                System.out.println("Error in subject Ids : " + e.getMessage());
            }
        }
        String whichSem = request.getParameter("semType");
        int remainder;
        try {
            if (whichSem.equalsIgnoreCase("odd")) {
                remainder = 1;
            } else if (whichSem.equalsIgnoreCase("even")) {
                remainder = 0;
            } else {
                /* don't go ahead */
                remainder = 9;
            }
            if (remainder != 9) {
                Transaction tr = session.beginTransaction();
                Query query = session.createQuery("From SemesterWiseSubjects where semNo % 2 = :rem");
                query.setParameter("rem", remainder);
                List<SemesterWiseSubjects> list = query.list();
                for (SemesterWiseSubjects rs : list) {
                    if (offered.contains(rs.getId().getSubId())) {
                        rs.setOffered(1);
                    } else {
                        rs.setOffered(0);
                    }
                    session.update(rs);
                }
                tr.commit();
                request.setAttribute("msg", "Offered subjects saved successfully");
                request.getRequestDispatcher("../offered_subjects.jsp").forward(request, response);
            } else {
                request.setAttribute("msg", "There is error in semester-type, Please specify properly.");
                request.getRequestDispatcher("../offered_subjects.jsp").forward(request, response);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
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
        processRequest(request, response);
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
