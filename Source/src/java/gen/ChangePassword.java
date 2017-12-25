/*
 * This is Dharmsinh Desai University Facuty Portal Project
 * Author : Vatsal Jagani  * 
 * Guide : Prof. Sidharth Shah  * 
 * All rights are reserved. @copyright  * 
 */
package gen;

import gen.security.MyDigest;
import hibernate.HibernateUtil;
import hibernate.pojos.Users;
import java.io.IOException;
import java.io.PrintWriter;
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
public class ChangePassword extends HttpServlet {

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
        HttpSession ses = request.getSession(false);
        User user = (User)ses.getAttribute("user");
        
        String message = null;
        String curPassword = request.getParameter("cPassword");
        String newPassword = request.getParameter("nPassword");
        
        Session session=null;
        
        try {
            session=HibernateUtil.getSessionFactory().openSession();
            Transaction tr=session.beginTransaction();
            
            MyDigest md = new MyDigest();
            
            Criteria cr=session.createCriteria(Users.class);
            cr.add(Restrictions.eq("userId", user.getUserID()));
            Users u=null;
            String enCurPass = null;
            
                u=(Users) cr.list().get(0);
                enCurPass = u.getPassword();
            if(md.verifyPassword(curPassword, enCurPass))
            {
                String enPass = md.getEncryptedPassword(newPassword);
                u.setPassword(enPass);
                session.update(u);
                tr.commit();
                message = "Your password is successfully changed";
                request.setAttribute("msg", message);
                request.getRequestDispatcher("home.jsp").forward(request, response);     
            }
            else
            {
                message = "Sorry, Your current password is incorrect";
                request.setAttribute("msg", message);
                request.getRequestDispatcher("change_password.jsp").forward(request, response);
            }
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
            message = "Username not found try. again..";
            request.setAttribute("msg", message);
            request.getRequestDispatcher("change_password.jsp").forward(request, response);
        }
        finally{
            session.close();
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
