package Servlets;

/**
* Class: CIST 2931 Advanced Systems Project
* Semester: Fall 2020
* Instructor: Ronald Enz
* Description: EmpLoginServlet.java
* Due: 09.19.2020
* @authors Ian Mashburn
* @version 1.0
*
* By turning in this code, I Pledge:
* 1. That I have completed the programming assignment independently.
* 2. I have not copied the code from a student or any source.
* 3. I have not given my code to any student.
 */

import BusinessObjects.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/EmpLoginServlet"})
public class EmpLoginServlet extends HttpServlet {

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

        System.out.println("************** IN EmpLoginServlet ***************"); 
  
        String idFromForm = "", passFromForm = "";
        boolean grantAccess = false;
        
        System.out.println("*************** REQUEST FROM LOGIN FORM *********");
        idFromForm = request.getParameter("loginID");
        passFromForm = request.getParameter("password");
        System.out.println("loginID: " + idFromForm);
        System.out.println("password: " + passFromForm);        
        System.out.println("*************** REQUESTED FROM LOGIN FORM *******");
        
        HttpSession session = request.getSession();
                   
        try {
            Employee empObect = new Employee(); // create Employee Object
                                                // check DB for loginID
            empObect.loginDB(idFromForm,passFromForm);

            if (empObect.empNotFound){
                System.out.println("Caught a bad login");
                empObect.empNotFound = false;   // reset flag empNotFound
                grantAccess = false;            // set grantAccess flag
            } else {                            // grantAccess
                                                // verify against Object Data
                grantAccess = (idFromForm.equals(empObect.getEmpLoginID()) && (passFromForm.equals(empObect.getEmpPassword())));
            }

            // put Employee Object into session and forward to maintorders.jsp
            if (grantAccess){
                System.out.println("Access Granted");
                session.setAttribute("empObject", empObect); 
                System.out.println("------------------------------------------------------------------------");
                System.out.println("EmpLoginServlet:Employee empObect ADDED to session");
                empObect.show();
                System.out.println("------------------------------------------------------------------------");
                                                // send to maintorders.jsp
                response.sendRedirect("http://localhost:8080/TeamOneSports/maintorders.jsp");
            } else {                            // ELSE send back to employeelogin.jsp
                System.out.println("Access NOT Granted");
                response.sendRedirect("http://localhost:8080/TeamOneSports/employeelogin.jsp");
            }
        }
        catch(IOException e){
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
