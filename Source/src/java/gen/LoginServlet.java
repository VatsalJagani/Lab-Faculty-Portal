/*
 * This is Dharmsinh Desai University Facuty Portal Project
 * Author : Vatsal Jagani  * 
 * Guide : Prof. Sidharth Shah  * 
 * All rights are reserved. @copyright  * 
 */
package gen;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author VATSAL
 */
public class LoginServlet extends HttpServlet {

    User user;
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
        user=new User();
        HttpSession session = request.getSession();
        try 
        { 
            String uname=request.getParameter("username");  
            String password=request.getParameter("password");  
          
           if(user.verify(uname,password))
           {  
                session.setAttribute("user", user);
                System.out.println("new Login : UserID :"+user.getUserID()+" :: DepId:"+user.getDepID()+" :: UserType:"+user.getUserType()+" :: UserName:"+user.getUserName());
                request.getRequestDispatcher("home.jsp").forward(request, response); 
            }
            else 
            {  
                //Below if condition is added by me so check if it is working correctly always
                if(session.getAttribute("user")==null )
                {
                    request.setAttribute("msg", "Sorry, username or password is incorrect, Retry!!");
                }
            /*    else
                {
                    request.setAttribute("message", "Sorry, you are already logged in!");
          
                }*/
                //out.print("sorry, username or password is incoorect!");  
                request.getRequestDispatcher("login.jsp").forward(request, response);  
            }  
        }
        catch(Exception e)
        {
            e.printStackTrace();
            request.setAttribute("msg", "Internal error occured, we will fix it very soon!");
            request.getRequestDispatcher("login.jsp").forward(request, response);  
        }
        finally
        {
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
