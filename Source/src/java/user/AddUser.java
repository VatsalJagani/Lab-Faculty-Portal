/*
 * This is Dharmsinh Desai University Facuty Portal Project
 * Author : Vatsal Jagani  * 
 * Guide : Prof. Sidharth Shah  * 
 * All rights are reserved. @copyright  * 
 */
package user;

import gen.User;
import gen.security.MyDigest;
import java.util.Date;
import hibernate.HibernateUtil;
import hibernate.pojos.Departments;
import hibernate.pojos.Employees;
import hibernate.pojos.Users;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author VATSAL
 */
public class AddUser extends HttpServlet {

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
        HttpSession sess=request.getSession();
        User hod=(User) sess.getAttribute("user");
        try{
            
        /* check all value first from parameter */
        String firstName=request.getParameter("first");
        String middleName=request.getParameter("middle");
        String lastName=request.getParameter("last");
        String initial=((Character)firstName.toUpperCase().charAt(0)).toString()+((Character)middleName.toUpperCase().charAt(0)).toString()+((Character)lastName.toUpperCase().charAt(0)).toString();
        String salutation=request.getParameter("salutation");
        String usertype=null;
        if(request.getParameter("usertype").equalsIgnoreCase("non-tech")){
            usertype="nontech";
        }
        else{
            usertype="normal";
        }
        String gender=null;
        if(request.getParameter("gender").equalsIgnoreCase("M")){
            gender="M";
        }
        else{
            gender="F";
        }
        String designation=null;
        if(request.getParameter("designation").trim().equalsIgnoreCase("P")){
            designation="Professor";
        }
        else if(request.getParameter("designation").trim().equalsIgnoreCase("A")){
            designation="Assistant Professor";
        }
        else if(request.getParameter("designation").trim().equalsIgnoreCase("N")){
            designation="Non-Technical Staff";
        }
        else if(request.getParameter("designation").trim().equalsIgnoreCase("H")){
            designation="HOD";
        }
        String category=null;
        if(request.getParameter("category").trim().equalsIgnoreCase("g")){
            category="GIA";
        }
        else{
            category="SFI";
        }
        String type=null;
        if(request.getParameter("type").equalsIgnoreCase("p")){
            type="Permanent";
        }
        else if(request.getParameter("type").equalsIgnoreCase("v")){
            type="Visiting";
        }
        
        System.out.println(request.getParameter("birth-date"));
        /* convert string to date */
        SimpleDateFormat d=new SimpleDateFormat("dd/MM/yyyy");
        Date birthdate=d.parse(request.getParameter("birth-date"));
        Date joindate=d.parse(request.getParameter("join-date"));
        
        if(firstName!=null && middleName!=null && lastName!=null && initial!=null && usertype!=null && type!=null && designation!=null && category!=null && gender!=null && birthdate!=null && joindate!=null){
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tr = session.beginTransaction();
         
            Employees e=new Employees();
            Users u=new Users();
            
            /* new userid 
            u.setUserId(xxx);
            e.setId(xxx); */
            u.setInitials(initial);
            String dep = ((Departments)session.get(Departments.class, hod.getDepID())).getShortName();
            u.setUserName(dep.toLowerCase()+initial.toLowerCase());
            MyDigest md=new MyDigest();
            u.setPassword(md.getEncryptedPassword(dep.toLowerCase()+initial.toLowerCase()));
            u.setUserType(usertype.toLowerCase());
            
            e.setFirstName(firstName);
            e.setLastName(lastName);
            e.setMiddleName(middleName);
            e.setBirthDate(birthdate);
            e.setCategory(category);
            e.setDepId(hod.getDepID());
            e.setDesignation(designation);
            e.setGender(gender);
            e.setJoinDate(joindate);
            e.setType(type);
            e.setSalutation(salutation);
            session.save(e);
            tr.commit();
            tr=session.beginTransaction();
            u.setUserId(e.getId());
            session.save(u);
            tr.commit();
            request.setAttribute("msg", "User added successfully..!!");
        }
        else{
            request.setAttribute("msg", "Please set all values properly..!!");
            System.out.println(firstName+ middleName+ lastName+ initial+ usertype+ type+ designation+category+ gender+ birthdate +joindate);
        }
        }catch(Exception e){
            e.printStackTrace();
            request.setAttribute("msg", "Internal error encountered..!!");
        }
        request.getRequestDispatcher("add_user.jsp").forward(request, response);
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
