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
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author VATSAL
 */
public class ArrangeLoad extends HttpServlet {

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
        Session sess=HibernateUtil.getSessionFactory().openSession();
        Transaction tr=sess.beginTransaction();
        try{
            int slots=Integer.parseInt(request.getParameter("slots"));
            for(int i=1;i<=slots;i++){
                LoadArrangement leave=new LoadArrangement();
                LoadArrangementId ld=new LoadArrangementId();
                ld.setEmpLeaveId(Integer.parseInt(request.getParameter("leaveId")));
                // set this both date and time 
                String date=request.getParameter("time["+i+"]").substring(0,10);
                DateFormat formatter=new SimpleDateFormat("MM/dd/yyyy");
                Date p = formatter.parse(date);
                String time=request.getParameter("time["+i+"]").substring(11);
                ld.setDate(p);
                ld.setTime(time);
                leave.setId(ld);
                leave.setAssignedFaculty(Integer.parseInt(request.getParameter("faculty["+i+"]")));
                leave.setDivBatch(request.getParameter("div["+i+"]"));
                leave.setRoomNo(Integer.parseInt(request.getParameter("roomno["+i+"]")));
                leave.setSemester(Integer.parseInt(request.getParameter("sem["+i+"]").trim()));
                leave.setSubjectName(request.getParameter("sub["+i+"]"));
                leave.setStatus("Pending");
                sess.saveOrUpdate(leave);
            }
            tr.commit();
            request.setAttribute("msg", "Your leave request has been successfully submitted..!");
            request.getRequestDispatcher("my_leave.jsp").forward(request, response);
        }catch(Exception e){
            // error occured....
            e.printStackTrace();
            System.out.println("Some internal error encountered.., Make sure your details are valid!!");
            request.setAttribute("msg", "Your request has some problem to complete try again latter..!");
            request.getRequestDispatcher("load_arrange.jsp").forward(request, response);
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
