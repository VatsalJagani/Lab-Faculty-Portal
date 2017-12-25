/*
 * This is Dharmsinh Desai University Facuty Portal Project
 * Author : Vatsal Jagani  * 
 * Guide : Prof. Sidharth Shah  * 
 * All rights are reserved. @copyright  * 
 */
package sp;

import gen.User;
import hibernate.HibernateUtil;
import hibernate.pojos.SubjectPreferenceSettings;
import java.io.IOException;
import java.io.PrintWriter;
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
public class EnablePreferencesModule extends HttpServlet {

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
        HttpSession session=request.getSession();
        User u=(User) session.getAttribute("user");
        if(u.getUserType().equalsIgnoreCase("admin_sp")){
            String param=request.getParameter("preference");
            String set=null;
            if(param!=null){
            if(param.equalsIgnoreCase("closed")){
                set="null";
            }
            else if(param.equalsIgnoreCase("odd")){
                set="odd";
            }
            else if(param.equalsIgnoreCase("even")){
                set="even";
            }
            else{
                set=null;
            }
            if(set!=null){
                Session sess=HibernateUtil.getSessionFactory().openSession();
                Transaction tr = sess.beginTransaction();
                SubjectPreferenceSettings s = (SubjectPreferenceSettings) sess.get(SubjectPreferenceSettings.class, u.getDepID());
                s.setSemType(set);
                sess.saveOrUpdate(s);
                tr.commit();
                sess.close();
                request.setAttribute("msg", "Preference Setting Apply Successful...");
                request.getRequestDispatcher("enable_preferences.jsp").forward(request, response);
            }
            else{
                request.setAttribute("msg", "Some Error occured please Retry!!");
                request.getRequestDispatcher("enable_preferences.jsp").forward(request, response);
            }
            }else{
                request.setAttribute("msg", "Please select any one option!!");
                request.getRequestDispatcher("enable_preferences.jsp").forward(request, response);
            }
        }
        else{
            request.setAttribute("msg", "You are not allowed to access this module.");
                request.getRequestDispatcher("home.jsp").forward(request, response);
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
