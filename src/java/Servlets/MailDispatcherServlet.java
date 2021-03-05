package Servlets;

/**
* Class: CIST 2931 Advanced Systems Project
* Semester: Fall 2020
* Instructor: Ronald Enz
* Description: MailDispatcherServlet.java
* Due: 10.31.2020
* @authors Ian Mashburn
* @version 1.0
*
* By turning in this code, I Pledge:
* 1. That I have completed the programming assignment independently.
* 2. I have not copied the code from a student or any source.
* 3. I have not given my code to any student.
 */


import Beans.MailSenderBean;
import BusinessObjects.*;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/MailDispatcherServlet"})
public class MailDispatcherServlet extends HttpServlet {

    
    @EJB
    private MailSenderBean mailSender;

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

        System.out.println("*************************** IN MailDispatcherServlet *******************");
        
                                        // get current session        
        HttpSession session = request.getSession();        
        
        Customer custObject;            // Get custObject from session
        custObject = (Customer)session.getAttribute("custObject");
        
        // setup message properties
        String toEmail = custObject.getCustEmail(); 
        String subject = "Your Recent TeamOneSportingGoods Order.";
        String message = (String)session.getAttribute("message");
        //setup gmail login info
        String fromEmail = "teamonesportinggoods@gmail.com";
        String username = "teamonesportinggoods";
        String password = "teamone01";
        
        try {
            
            // Call to mail sender bean
            mailSender.sendEmail(fromEmail, username, password, toEmail, subject, message);
            
            // Both Guest and Customer redirected to vieworders.jsp after order 
            // is placed and email is sent
            response.sendRedirect("http://localhost:8080/TeamOneSports/vieworders.jsp");
        }
        catch (Exception e) {
            System.out.println("PP: " + e);            
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
