/*
 * This is Dharmsinh Desai University Facuty Portal Project
 * Author : Vatsal Jagani  * 
 * Guide : Prof. Sidharth Shah  * 
 * All rights are reserved. @copyright  * 
 */
package sp;

import hibernate.HibernateUtil;
import hibernate.pojos.BackupSlotPreference;
import hibernate.pojos.BackupSlotPreferenceId;
import hibernate.pojos.BackupSubjectPreferences;
import hibernate.pojos.BackupSubjectPreferencesId;
import hibernate.pojos.SlotPreference;
import hibernate.pojos.SubjectPreferences;
import java.io.IOException;
import java.io.PrintWriter;
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
public class SpBackup extends HttpServlet {

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
        Transaction tr = sess.beginTransaction();
        String type="even";
        Calendar cal = Calendar.getInstance();
        
        if(cal.get(Calendar.MONTH)>6 && cal.get(Calendar.MONTH)<12){
            type="odd";
        }
        
        Criteria cr = sess.createCriteria(SlotPreference.class);
        List<SlotPreference> li = cr.list();
        for(SlotPreference s:li){
            BackupSlotPreferenceId id=new BackupSlotPreferenceId(cal.get(Calendar.YEAR)+"-"+type,s.getUserId());
            BackupSlotPreference b=new BackupSlotPreference(id,s.getSlot());
            sess.saveOrUpdate(b);
        }
        Query q = sess.createQuery("delete from SlotPreference");
        q.executeUpdate();
        
        Criteria cr2 = sess.createCriteria(SubjectPreferences.class);
        List<SubjectPreferences> li2 = cr2.list();
        for(SubjectPreferences s:li2){
            BackupSubjectPreferencesId id=new BackupSubjectPreferencesId(cal.get(Calendar.YEAR)+"-"+type,s.getId().getUserId(),s.getId().getSubId());
            BackupSubjectPreferences b=new BackupSubjectPreferences(id);
            sess.saveOrUpdate(b);
        }
        Query q2 = sess.createQuery("delete from SubjectPreferences");
        q2.executeUpdate();
        
        
        tr.commit();
        
        request.setAttribute("msg", "Backup Successful..!!");
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
