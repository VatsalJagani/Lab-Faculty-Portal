/*
 * This is Dharmsinh Desai University Facuty Portal Project
 * Author : Vatsal Jagani  * 
 * Guide : Prof. Sidharth Shah  * 
 * All rights are reserved. @copyright  * 
 */
package lm;

import gen.User;
import hibernate.HibernateUtil;
import hibernate.pojos.LoadArrangement;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author VATSAL
 */
public class RequestsOfLoadArrangement extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session=request.getSession();
        User user=(User) session.getAttribute("user");
        Session sess=HibernateUtil.getSessionFactory().openSession();
        Criteria cr=sess.createCriteria(LoadArrangement.class);
        cr.add(Restrictions.eq("assignedFaculty", user.getUserID()));
        List<LoadArrangement> list = cr.list();
        
        List<LoadArrangementRequest> requests=new ArrayList<LoadArrangementRequest>();
        for(LoadArrangement load:list){
            /* only add those which date larger than currnt date */
            LoadArrangementRequest r=new LoadArrangementRequest(load,sess);
            requests.add(r);
        }
        
        if(requests!=null){
            request.setAttribute("allRequests", requests);
            request.getRequestDispatcher("requests_of_load_arrangement.jsp").forward(request, response);
        }
        else{
            request.setAttribute("msg", "Leave Info for you is not available right now.. Retry later!!");
            request.getRequestDispatcher("home.jsp").forward(request, response);
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

