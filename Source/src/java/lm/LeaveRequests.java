/*
 * This is Dharmsinh Desai University Facuty Portal Project
 * Author : Vatsal Jagani  * 
 * Guide : Prof. Sidharth Shah  * 
 * All rights are reserved. @copyright  * 
 */
package lm;

import gen.User;
import hibernate.HibernateUtil;
import hibernate.pojos.EmpLeaveRequest;
import hibernate.pojos.Employees;
import hibernate.pojos.LoadArrangement;
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
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author VATSAL
 */
public class LeaveRequests extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        HttpSession s=request.getSession();
        User user=(User) s.getAttribute("user");
        List<EmpLeaveRequest> list=new ArrayList<EmpLeaveRequest>();
        /* check all load arrangement for perticular leave if that all are approved then show that */
        Session sess=HibernateUtil.getSessionFactory().openSession();
        sess.beginTransaction();
        Criteria cr=sess.createCriteria(EmpLeaveRequest.class);
        cr.add(Restrictions.eq("status", "Pending"));
        List<EmpLeaveRequest> list0 = cr.list();
        /* EmpLeaveRequest is updated pojo class which is capable of giving employee name other important information */
        for(EmpLeaveRequest l:list0){
            Criteria cr2=sess.createCriteria(Employees.class);
            cr2.add(Restrictions.eq("id", l.getUserId()));
            cr2.add(Restrictions.eq("depId", user.getDepID()));
            List list2 = cr2.list();
            Criteria cr3=sess.createCriteria(LoadArrangement.class);
            cr3.add(Restrictions.eq("id.empLeaveId", l.getEmpLeaveId()));
            List<LoadArrangement> list3 = cr3.list();
            boolean flag=true;
            for(LoadArrangement la:list3){
                if(la.getStatus().equalsIgnoreCase("Pending") || la.getStatus().equalsIgnoreCase("Rejected")){
                    flag=false;
                    break;
                }
            }
            if(!list2.isEmpty() && flag){
                list.add(l);
            }
        }
        
        request.setAttribute("allRequests", list);
        request.getRequestDispatcher("pending_requests.jsp").forward(request, response);
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
