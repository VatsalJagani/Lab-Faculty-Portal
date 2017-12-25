/*
 * This is Dharmsinh Desai University Facuty Portal Project
 * Author : Vatsal Jagani  * 
 * Guide : Prof. Sidharth Shah  * 
 * All rights are reserved. @copyright  * 
 */
package lm;

import gen.User;
import hibernate.HibernateUtil;
import hibernate.pojos.BackupEmpLeaveRequest;
import hibernate.pojos.EmpLeaveRequest;
import hibernate.pojos.Employees;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author VATSAL
 */
public class MyLeaveDetails extends HttpServlet {

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
        HttpSession s=request.getSession();
        User user=(User) s.getAttribute("user");
        
        String type=request.getParameter("listType");
        Session sess=HibernateUtil.getSessionFactory().openSession();
        sess.beginTransaction();
        if(type.equalsIgnoreCase("previous")){
            Criteria cr=sess.createCriteria(BackupEmpLeaveRequest.class);
            cr.add(Restrictions.eq("userId", user.getUserID()));
            cr.add(Restrictions.like("id.year", ""+request.getParameter("year"), MatchMode.ANYWHERE));
            List<BackupEmpLeaveRequest> list = cr.list();
            request.setAttribute("year", request.getParameter("year"));
            request.setAttribute("previousList", list);
        
            /* EmpLeaveRequest is updated pojo class which is capable of giving employee name other important information */
        }else{
            Criteria cr=sess.createCriteria(EmpLeaveRequest.class);
            cr.add(Restrictions.eq("userId", user.getUserID()));
            List<EmpLeaveRequest> list = cr.list();
        /* EmpLeaveRequest is updated pojo class which is capable of giving employee name other important information */
        request.setAttribute("currentList", list);
        
        }
        request.getRequestDispatcher("my_leave.jsp").forward(request, response);
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
