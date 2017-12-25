/*
 * This is Dharmsinh Desai University Facuty Portal Project
 * Author : Vatsal Jagani  * 
 * Guide : Prof. Sidharth Shah  * 
 * All rights are reserved. @copyright  * 
 */
package lm;

import gen.User;
import hibernate.HibernateUtil;
import hibernate.pojos.EmpLeaveInfo;
import hibernate.pojos.EmpLeaveRequest;
import hibernate.pojos.Employees;
import hibernate.pojos.LeaveInfo;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.joda.time.DateTimeComparator;
import sp.SubjectsGetter;

/**
 *
 * @author VATSAL
 */
public class InsertLeave extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    User user;
    EmpLeaveInfo eml;
    Date currentDate, toDate, fromDate;
    String addr, reason, remark;
    int slots, type;
    float noOfDays;
    Session sess;
    HttpServletRequest request;
    HttpServletResponse response;
    HttpSession session;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        this.request = request;
        this.response=response;
        session = request.getSession();
        user = (User) session.getAttribute("user");
        sess = HibernateUtil.getSessionFactory().openSession();
        eml = (EmpLeaveInfo) sess.get(EmpLeaveInfo.class, user.getUserID());
        
        String type = request.getParameter("type");
        String ddate = request.getParameter("ddate");
        String from = request.getParameter("from");
        String to = request.getParameter("to");
        reason = request.getParameter("reason");
        remark = request.getParameter("remark");
        addr = request.getParameter("addr");
        String slots = request.getParameter("slots");
        boolean flag = false;
        if (type.isEmpty() || reason.isEmpty() || remark.isEmpty() || addr.isEmpty() || slots.isEmpty()) {
            request.setAttribute("msg", "Please enter all data properly...");
            request.getRequestDispatcher("GetLeaveDetails").forward(request, response);
        } else {
            if (type.equals("hcl")) {
                if (ddate.isEmpty()) {
                    request.setAttribute("msg", "Date should not empty please enter date..");
                    request.getRequestDispatcher("GetLeaveDetails").forward(request, response);
                } else {
                    Date dDate = null;
                    try {
                        java.util.Date utilDate = new java.util.Date();
                        currentDate = new java.sql.Date(utilDate.getTime());
                        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                        dDate = formatter.parse(ddate);
                        fromDate = dDate;
                        toDate = dDate;
                        this.slots = Integer.parseInt(slots);
                        if(this.slots<0){
                            throw new Exception("slots can not be negative..");
                        }
                        noOfDays = (float) 0.5;
                        all(type);
                    } catch (Exception e) {
                        e.printStackTrace();
                        error("Please enter numbers and dates correctly in half causal leave.");
                    }
                }
            } else {
                if (from.isEmpty() || to.isEmpty()) {
                    request.setAttribute("msg", "Please fill up dates properly..");
                    request.getRequestDispatcher("GetLeaveDetails").forward(request, response);
                } else {
                    
                    try {
                        java.util.Date utilDate = new java.util.Date();
                        currentDate = new java.sql.Date(utilDate.getTime());
                        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                        fromDate = formatter.parse(from);
                        toDate = formatter.parse(to);
                        this.slots = Integer.parseInt(slots);
                        if(this.slots<0){
                            throw new Exception("slots can not be negative..");
                        }
                        noOfDays = (float) differenceInDays(fromDate, toDate);
                        all(type);
                    } catch (Exception e) {
                        e.printStackTrace();
                        error("Please enter numbers and dates correctly");
                    }
                }
            }
            request.getRequestDispatcher("load_arrange.jsp").forward(request, response);
        }
        
    }
    
    public final static long MILLISECONDS_IN_DAY = 24 * 60 * 60 * 1000;
    
    public static int differenceInDays(Date from, Date to) {
        return (int) ((to.getTime() - from.getTime()) / MILLISECONDS_IN_DAY);
    }
    
    private boolean check(String leaveType) {
        
        float available = -99;
        float taken = 0;
        Transaction tr = sess.beginTransaction();
        Criteria cr = sess.createCriteria(LeaveInfo.class);
        if (leaveType.equalsIgnoreCase("hcl")) {
            cr.add(Restrictions.eq("leaveShortName", "CL"));
        } else {
            cr.add(Restrictions.eq("leaveShortName", leaveType.toUpperCase()));
        }
        List<LeaveInfo> list1 = cr.list();
        LeaveInfo l = list1.get(0);
        if (l != null) {
            this.type = l.getLid();
            switch (type) {
                case 1: {
                    available = eml.getClAvailable();
                    break;
                }
                case 2: {
                    available = eml.getSlAvailable();
                    break;
                }
                case 3: {
                    available = eml.getDlAvailable();
                    break;
                }
                case 4: {
                    available = eml.getPlAvailable();
                    break;
                }
                case 5: {
                    available = eml.getMlAvailable();
                    break;
                }
                default: {
                    System.out.println("No leave type match");
                    return false;
                }
            }
        } else {
            System.out.println("leaveinfo is null found");
            return false;
        }
        System.out.println("values : available:"+available+" noOfDays:"+noOfDays);
        int compare1 = DateTimeComparator.getDateOnlyInstance().compare(fromDate, toDate);
        int compare2 = DateTimeComparator.getDateOnlyInstance().compare(fromDate, currentDate);
        System.out.println("Date comparision : "+compare1+" "+compare2);
        if (compare1<=0 && compare2>=0){            
            if (available != -99 || available > noOfDays) {
                EmpLeaveRequest leave = new EmpLeaveRequest();
                leave.setAddressDuringLeave(addr);
                leave.setApplyDate(currentDate);
                leave.setEndDate(toDate);
                leave.setLeaveType(l.getLid());        //l.getLid();
                leave.setNoOfDays(noOfDays);
                leave.setReason(reason);
                leave.setStartDate(fromDate);
                leave.setStatus("Pending");
                leave.setUserId(user.getUserID());
                leave.setHodRemark("");
                leave.setRemark(remark);
                /* insert leave into EmpLeaveRequest */
                
                EmpLeaveInfo empL = (EmpLeaveInfo) sess.get(EmpLeaveInfo.class, user.getUserID());
                if (empL != null) {
                    switch (type) {
                        case 1: {
                            taken = eml.getCltaken();
                            empL.setCltaken(taken + noOfDays);
                            break;
                        }
                        case 2: {
                            taken = eml.getSltaken();
                            empL.setSltaken(taken + noOfDays);
                            break;
                        }
                        case 3: {
                            taken = eml.getDltaken();
                            empL.setDltaken(taken + noOfDays);
                            break;
                        }
                        case 4: {
                            taken = eml.getPltaken();
                            empL.setPltaken(taken + noOfDays);
                            break;
                        }
                        case 5: {
                            taken = eml.getMltaken();
                            empL.setMltaken(taken + noOfDays);
                            break;
                        }
                    }
                } else {
                    System.out.println("leave type not selected");
                    return false;
                }
                sess.saveOrUpdate(empL);
                sess.saveOrUpdate(leave);
                tr.commit();
                
                session.setAttribute("leaveid", leave.getEmpLeaveId());
                session.setAttribute("slots", slots);
                return true;
            }
        }
        System.out.println("Date is wrong..");
        return false;
        
    }
    
    private void all(String type) throws ServletException, IOException {
        if (check(type)) {
            sess.beginTransaction();
            Criteria cr1 = sess.createCriteria(Employees.class);
            cr1.add(Restrictions.eq("depId", user.getDepID()));
            List<Employees> list = cr1.list();
            SubjectsGetter g = new SubjectsGetter(getServletContext());
            session.setAttribute("subjects", g.getAllSubjects(user.getDepID()));
            session.setAttribute("faculties", list);
        }
        else{
            System.out.println("not here");
            error("Please enter dates correctly..");
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

    private void error(String msg) throws ServletException, IOException {
        request.setAttribute("msg", msg);
        request.getRequestDispatcher("GetLeaveDetails").forward(request, response);
    }

}
