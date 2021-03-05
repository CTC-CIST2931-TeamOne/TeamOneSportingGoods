
/**
* Team one Sporting Goods
* Semester: Fall 2020
* Description: SearchServlet.java
* Due: 09.18.2020
* @authors Hunter Browder, Ian Mashburn
* @version 1.0
*
 */

package Servlets;

import BusinessObjects.Customer;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author H_Browder
 */
@WebServlet(name = "ProfileServlet", urlPatterns = {"/ProfileServlet"})
public class ProfileServlet extends HttpServlet {

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
        
        System.out.println("*************************** IN ProfileServlet *******************");
        
        //Declare empty variables
        String login = "";
        String password = "";
        String confpass = "";
        String fNameNew = "";
        String middleINew = "";
        String lNameNew = "";
        String address1 = "";
        String address2 = "";
        String city = "";
        String state = "";
        String zip = "";
        String phone = "";
        String email = "";
        
        String submitValue = "";
        
        String updated = "";
        String pwmismatch = "";
        
        //Fill variables with updated profile information
        login = request.getParameter("user");
        password = request.getParameter("pass");
        confpass = request.getParameter("confirmPass");
        fNameNew = request.getParameter("firstName");   
        middleINew = request.getParameter("midInitial");
        lNameNew = request.getParameter("lastName");
        address1 = request.getParameter("address1");
        address2 = request.getParameter("address2");
        city = request.getParameter("city");
        state = request.getParameter("state");
        zip = request.getParameter("zip");
        phone = request.getParameter("phone");
        email = request.getParameter("email");
        submitValue = request.getParameter("submit");
    
        if ((middleINew.isEmpty()) || (middleINew.equals("null"))){
            middleINew = " ";
        }
        if ((address2.isEmpty()) || (address2.equals("null"))){
            address2 = " ";
        }  
                    
        boolean performUpdate = false;
        
        //Retrieve current session
        HttpSession session = request.getSession();
        
        try{
            
            //Retrieve customer object from session   
            Customer custObject;
            custObject = (Customer)session.getAttribute("custObject");

            
            //Checks if customer is saving profile
            if((submitValue.equals("Save")) || (submitValue.equals("Continue to Checkout"))){
            
                custObject.setCustFirstName(fNameNew);
                custObject.setCustMidInitial(middleINew);
                custObject.setCustLastName(lNameNew);
                custObject.setCustAddrLine1(address1);
                custObject.setCustAddrLine2(address2);
                custObject.setCustCity(city);
                custObject.setCustState(state.toUpperCase());
                custObject.setCustZip(zip);
                custObject.setCustPhone(phone);
                custObject.setCustEmail(email);

                //print Updated Customer Object
                System.out.println("_________________________________________________________");
                System.out.println("Updated Profile");
                custObject.show();
                
                performUpdate = true;
            }
            
            //Checks if customer is updating login
            else if(submitValue.equals("Update")){
            
                //TESTING
                System.out.println("********************* changing login and password ********************");
                System.out.println("          login: " + login);
                System.out.println("       password: " + password);
                System.out.println("confirmpassword: " + confpass);
                System.out.println("********************* changing login and password ********************");
                
                // check if password matches confpassword during change
                if ( password.equals(confpass)) {
                    System.out.println("PASSWORDS MATCH");
                    custObject.setCustLoginID(login);
                    custObject.setCustPassword(password);
                    performUpdate = true;
                    pwmismatch = "false";

                    //print Updated Customer Object
                    System.out.println("_________________________________________________________");
                    System.out.println("Updated Profile");
                    custObject.show();
                } else {
                    System.out.println("PASSWORDS DO NOT MATCH");
                    performUpdate = false;
                    pwmismatch = "true";
                    updated = "false";
                }
            }
                        
            System.out.println("flags before update: performUpdate: " + performUpdate + " pwmismatch: " + pwmismatch + " updated: " + updated);
            
            if (performUpdate){
                //Update Customer Info in Database
                custObject.updateDB();

                if(submitValue.equals("Continue to Checkout")){
                    updated = "false"; 
                } else {
                    updated = "true";                   
                }

            }
            //Set Current info in Session
            session.setAttribute("custObject", custObject);
            session.setAttribute("updated", updated);
            session.setAttribute("pwmismatch", pwmismatch);
            
            if(submitValue.equals("Continue to Checkout")){
                //Send to checkout page
                response.sendRedirect("http://localhost:8080/TeamOneSports/checkout.jsp");                
            } else {
                //Send back to profile page
                response.sendRedirect("http://localhost:8080/TeamOneSports/profile.jsp");
            }
        }
        
        catch(IOException e){
        
        System.out.println(e);
        
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
