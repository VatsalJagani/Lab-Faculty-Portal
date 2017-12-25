/*
 * This is Dharmsinh Desai University Facuty Portal Project
 * Author : Vatsal Jagani  * 
 * Guide : Prof. Sidharth Shah  * 
 * All rights are reserved. @copyright  * 
 */
package lm;

import hibernate.HibernateUtil;
import hibernate.pojos.*;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author VATSAL
 */
public class Backup extends HttpServlet {

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
        
        /*
        Backup following tables ( year , semester(even/odd) )
            emp_leave_info
            emp_leave_request
            load_arrangement
        */
        Session sess=HibernateUtil.getSessionFactory().openSession();
        Transaction tr = sess.beginTransaction();
        String type="even";
        Calendar cal = Calendar.getInstance();
        
        if(cal.get(Calendar.MONTH)>6 && cal.get(Calendar.MONTH)<12){
            type="odd";
        }
        
        Criteria cr = sess.createCriteria(EmpLeaveInfo.class);
        List<EmpLeaveInfo> li = cr.list();
        for(EmpLeaveInfo emp:li){
            BackupEmpLeaveInfoId id=new BackupEmpLeaveInfoId(cal.get(Calendar.YEAR)+"-"+type,emp.getUserId());
            BackupEmpLeaveInfo b=new BackupEmpLeaveInfo(id,emp.getSltaken(),emp.getCltaken(),emp.getDltaken(),emp.getPltaken(),emp.getMltaken());
            sess.saveOrUpdate(b);
        }
        Query q = sess.createQuery("delete from EmpLeaveInfo");
        q.executeUpdate();
        
        Criteria cr2 = sess.createCriteria(EmpLeaveRequest.class);
        List<EmpLeaveRequest> li2 = cr2.list();
        for(EmpLeaveRequest s:li2){
            BackupEmpLeaveRequestId id=new BackupEmpLeaveRequestId(cal.get(Calendar.YEAR)+"-"+type,s.getEmpLeaveId());
            BackupEmpLeaveRequest b=new BackupEmpLeaveRequest(id,s.getUserId(),s.getLeaveType(),s.getApplyDate(),s.getStartDate(),s.getEndDate(),s.getApproveDate(),s.getNoOfDays(),s.getReason(),s.getAddressDuringLeave(),s.getRemark(),s.getHodRemark(),s.getStatus());
            sess.saveOrUpdate(b);
        }
        Query q2 = sess.createQuery("delete from EmpLeaveRequest");
        q2.executeUpdate();
        
        Criteria cr3 = sess.createCriteria(LoadArrangement.class);
        List<LoadArrangement> li3 = cr3.list();
        for(LoadArrangement e:li3){
            BackupLoadArrangementId id=new BackupLoadArrangementId(cal.get(Calendar.YEAR)+"-"+type,e.getId().getEmpLeaveId(),e.getId().getDate(),e.getId().getTime());
            BackupLoadArrangement b=new BackupLoadArrangement(id,e.getSemester(),e.getDivBatch(),e.getRoomNo(),e.getSubjectName(),e.getAssignedFaculty(),e.getStatus(),e.getApproveDate());
            sess.saveOrUpdate(b);
        }
        Query q3 = sess.createQuery("delete from LoadArrangement");
        q3.executeUpdate();
        
        tr.commit();
        sess.close();
        sess=HibernateUtil.getSessionFactory().openSession();
        tr=sess.beginTransaction();
        
        /* add all new rows with defaults values in EmpLeaveInfo */
        Criteria cr4 = sess.createCriteria(Users.class);
        List<Users> li4 = cr4.list();
        for(Users u:li4){
            EmpLeaveInfo e=new EmpLeaveInfo(u.getUserId(),0,0,0,0,(float)0);
            if(!u.getUserType().equalsIgnoreCase("nontech")){
                e.setPltaken(30);
            }
            sess.saveOrUpdate(e);
        }
        
        
        tr.commit();
        
        request.setAttribute("msg", "Leave information backup successfully completed..!!");
        request.getRequestDispatcher("../../home.jsp").forward(request, response);
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
