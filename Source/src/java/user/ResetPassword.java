/*
 * This is Dharmsinh Desai University Facuty Portal Project
 * Author : Vatsal Jagani  * 
 * Guide : Prof. Sidharth Shah  * 
 * All rights are reserved. @copyright  * 
 */
package user;

import gen.User;
import gen.security.MyDigest;
import hibernate.HibernateUtil;
import hibernate.pojos.Employees;
import hibernate.pojos.Users;
import java.io.IOException;
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

/**
 *
 * @author VATSAL
 */
public class ResetPassword extends HttpServlet {

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
        String type=request.getParameter("type");
        HttpSession sess=request.getSession();
        User admin=(User) sess.getAttribute("user");
        Session session;
        if(type.equalsIgnoreCase("single")){
            session=HibernateUtil.getSessionFactory().openSession();
            Transaction beginTransaction = session.beginTransaction();
            Criteria cr=session.createCriteria(Users.class);
            cr.add(Restrictions.eq("userName", request.getParameter("username")));
            Users u=null;
            try{
                u=(Users) cr.list().get(0);
            }
            catch(Exception e){
                // no user found
            }
            
            if(u!=null){
                MyDigest md = new MyDigest();
                u.setPassword(md.getEncryptedPassword(request.getParameter("password")));
                session.update(u);
                beginTransaction.commit();
                request.setAttribute("msg", "Password for specified user has been updated..");
            }
            else{
                request.setAttribute("msg", "User not found on username specified..");
            }
        }
        else if(type.equalsIgnoreCase("all")){
            session=HibernateUtil.getSessionFactory().openSession();
            Transaction beginTransaction = session.beginTransaction();
            Criteria cr=session.createCriteria(Users.class);
            List<Users> list = cr.list();
            int count=0;
            
            if(list!=null){
                MyDigest md = new MyDigest();
                String encrypted=md.getEncryptedPassword(request.getParameter("password"));
                for(Users u:list){
                    Employees e = (Employees) session.get(Employees.class, u.getUserId());
                    
                    if(e!=null){
                        if(e.getDepId()==admin.getDepID()){
                            u.setPassword(encrypted);
                            session.update(u);
                            count++;
                        }
                    }   
                    
                }
                beginTransaction.commit();
                request.setAttribute("msg", "Password has been resetted for all users (Total:"+count+")");
            }
            else{
                request.setAttribute("msg", "Problem with database..!!");
            }
        }
        else{
            request.setAttribute("msg", "Please select proper type..!!");
        }
        request.getRequestDispatcher("reset_password.jsp").forward(request, response);
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
