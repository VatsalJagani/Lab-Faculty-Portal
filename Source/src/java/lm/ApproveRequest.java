/*
 * This is Dharmsinh Desai University Facuty Portal Project
 * Author : Vatsal Jagani  * 
 * Guide : Prof. Sidharth Shah  * 
 * All rights are reserved. @copyright  * 
 */
package lm;

import hibernate.HibernateUtil;
import hibernate.pojos.EmpLeaveInfo;
import hibernate.pojos.EmpLeaveRequest;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
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
public class ApproveRequest extends HttpServlet {

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
            EmpLeaveRequest la = (EmpLeaveRequest) s.get(EmpLeaveRequest.class,Integer.parseInt(request.getParameter("leaveid")));
            if(la!=null){
                if(task.equalsIgnoreCase("Approve")){
                    status="Approved";
                }
                else if(task.equalsIgnoreCase("Reject")){
                    status="Rejected";
                    /* if rejected then again add noOf days to available leave */
                    EmpLeaveInfo empL = (EmpLeaveInfo) s.get(EmpLeaveInfo.class, la.getUserId());
                    float taken;
                    switch (la.getLeaveType()) {
                        case 1: {
                            taken = empL.getCltaken();
                            empL.setCltaken(taken - la.getNoOfDays());
                            break;
                        }
                        case 2: {
                            taken = empL.getSltaken();
                            empL.setSltaken(taken - la.getNoOfDays());
                            break;
                        }
                        case 3: {
                            taken = empL.getDltaken();
                            empL.setDltaken(taken - la.getNoOfDays());
                            break;
                        }
                        case 4: {
                            taken = empL.getPltaken();
                            empL.setPltaken(taken - la.getNoOfDays());
                            break;
                        }
                        case 5: {
                            taken = empL.getDltaken();
                            empL.setMltaken(taken - la.getNoOfDays());
                            break;
                        }
                        default :{
                            System.out.println("Leave type not found..");
                        }
                    }
                    s.saveOrUpdate(empL);
                }
                else{
                    throw new Exception("Task not found..");
                }
                la.setStatus(status);
                la.setHodRemark(request.getParameter("remark"));
                la.setApproveDate(Calendar.getInstance().getTime());
                s.saveOrUpdate(la);
                tr.commit();
                request.setAttribute("msg", "Leave Request "+status+"..");
                request.getRequestDispatcher("LeaveRequests").forward(request, response);
            }
            else{
                request.setAttribute("msg", "Request not found try again later..");
                request.getRequestDispatcher("LeaveRequests").forward(request, response);
            }
        }
        catch(Exception e){
            e.printStackTrace();
            request.setAttribute("msg", "Internal error found, try again..");
            request.getRequestDispatcher("LeaveRequests").forward(request, response);
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
