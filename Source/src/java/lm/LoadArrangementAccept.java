/*
 * This is Dharmsinh Desai University Facuty Portal Project
 * Author : Vatsal Jagani  * 
 * Guide : Prof. Sidharth Shah  * 
 * All rights are reserved. @copyright  * 
 */
package lm;

import hibernate.HibernateUtil;
import hibernate.pojos.LoadArrangement;
import hibernate.pojos.LoadArrangementId;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author VATSAL
 */
public class LoadArrangementAccept extends HttpServlet {

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
        try {
            /* TODO output your page here. You may use following sample code. */
            
            String task=request.getParameter("task");
            String status=null;
            Session s=HibernateUtil.getSessionFactory().openSession();
            Transaction tr = s.beginTransaction();
            LoadArrangementId l=new LoadArrangementId();
            l.setEmpLeaveId(Integer.parseInt(request.getParameter("leaveid")));
            DateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
            l.setDate(formatter1.parse(request.getParameter("date")));
            l.setTime(request.getParameter("time"));
            LoadArrangement la = (LoadArrangement) s.get(LoadArrangement.class,l);
            if(la!=null){
                if(task.equalsIgnoreCase("approve")){
                    status="Approved";
                }
                else if(task.equalsIgnoreCase("reject")){
                    status="Rejected";
                }
                else{
                    throw new Exception("Task not found..");
                }
                la.setStatus(status);
                la.setApproveDate(Calendar.getInstance().getTime());
                s.saveOrUpdate(la);
                tr.commit();
                request.setAttribute("msg", "Request "+status+"..");
                request.getRequestDispatcher("RequestsOfLoadArrangement").forward(request, response);
            }
            else{
                request.setAttribute("msg", "Request not found try again later..");
                request.getRequestDispatcher("RequestsOfLoadArrangement").forward(request, response);
            }
        }
        catch(Exception e){
            e.printStackTrace();
            request.setAttribute("msg", "Internal error found, try again..");
            request.getRequestDispatcher("RequestsOfLoadArrangement").forward(request, response);
        } finally {
            out.close();
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
