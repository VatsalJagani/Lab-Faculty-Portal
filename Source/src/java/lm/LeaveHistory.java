/*
 * This is Dharmsinh Desai University Facuty Portal Project
 * Author : Vatsal Jagani  * 
 * Guide : Prof. Sidharth Shah  * 
 * All rights are reserved. @copyright  * 
 */
package lm;

import hibernate.HibernateUtil;
import hibernate.pojos.EmpLeaveRequest;
import hibernate.pojos.Users;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author VATSAL
 */
public class LeaveHistory extends HttpServlet {

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
        Session sess = HibernateUtil.getSessionFactory().openSession();
        sess.beginTransaction();
        Criteria cr1 = sess.createCriteria(Users.class);
        cr1.add(Restrictions.eq("initials", request.getParameter("initials")));
        List<Users> list1 = cr1.list();
        if (list1.isEmpty()) {
            request.setAttribute("msg", "Faculty Not found : " + request.getParameter("initials"));
            request.getRequestDispatcher("leave_history.jsp").forward(request, response);
        } else {
            Users u = list1.get(0);
            if (u == null) {
                request.setAttribute("msg", "Faculty Not found : " + request.getParameter("initials"));
                request.getRequestDispatcher("leave_history.jsp").forward(request, response);

            } else {

                Criteria cr = sess.createCriteria(EmpLeaveRequest.class);
                cr.add(Restrictions.eq("userId", u.getUserId()));
                List<EmpLeaveRequest> list = cr.list();
                /* EmpLeaveRequest is updated pojo class which is capable of giving employee name other important information */

                
                request.setAttribute("facultyname", request.getParameter("initials").toUpperCase());
                request.setAttribute("list", list);
                request.getRequestDispatcher("leave_history.jsp").forward(request, response);
            }
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
