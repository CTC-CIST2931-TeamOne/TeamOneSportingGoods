package Servlets;

import BusinessObjects.Customer;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/***********************************
*   Document   : RegisterServlet.java
*   Created on : Sep 15, 2020, 4:51:42 PM
*   Author     : Patricia A. Rivera
***********************************/

@WebServlet(name = "RegisterServlet", urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        System.out.println("*************** IN RegisterServlet **************");
        
                                                // get current session        
        HttpSession session = request.getSession();
        
        /********** Get The Info from the TextBoxes *****************/
        String loginID = "", pass = "", firstName = "", midAn = "", lastName = "",
                address1 = "", address2 = "", city = "", state = "", zip = "",
                phone = "", email = "";
        
        Double startBalance = 0.0; // Default for Customer
        
        String custType = "A"; // Default for Customer
        
        String custNum = ""; // For the CustNumber
        
        String usernameExists = "false"; // set usernameExists to false

        /********** Set the info *****************/
        loginID = request.getParameter("loginID");
        pass = request.getParameter("custpass");
        firstName = request.getParameter("fname");
        midAn = request.getParameter("midinitial");
        lastName = request.getParameter("lname");
        address1 = request.getParameter("address1");
        address2 = request.getParameter("address2");
        city = request.getParameter("city");
        state = request.getParameter("state");
        zip = request.getParameter("zip");
        phone = request.getParameter("phoneNum");
        email = request.getParameter("email");

        // allow midinitial and address2 to be empty during registration
        // cannot put null in these database fields so make blank
        if ((midAn.isEmpty()) || (midAn.equals("null"))){
            midAn = " ";
        }
        if ((address2.isEmpty()) || (address2.equals("null"))){
            address2 = " ";
        }
        
        // make sure that state abbr. if uppercase before insert
        String stateUC = state.toUpperCase();
        
        /********** Get Customer Object *************/
        Customer custObj = new Customer();
        
        /******** Generate Customer ID *************/
        custObj.generateCustNumber();
        
        /******** Get New Customer Number *************/
        custNum = custObj.getCustNumber();
        
        /******** Check for duplicate username in database *********/
        try {                                   // create Customer Object
            Customer tempCustObject = new Customer();
                                                // check DB for loginID
            tempCustObject.checkDupUsername(loginID);

            if (tempCustObject.usernameExists){ // duplicate username
                                                // reset object flag usernameExists
                tempCustObject.usernameExists = false;
                
                // set properties for current object to new passed values
                tempCustObject.setCustLoginID("");
                tempCustObject.setCustPassword("");
                tempCustObject.setCustFirstName(firstName);
                tempCustObject.setCustMidInitial(midAn);
                tempCustObject.setCustLastName(lastName);
                tempCustObject.setCustAddrLine1(address1);
                tempCustObject.setCustAddrLine2(address2);
                tempCustObject.setCustCity(city);
                tempCustObject.setCustState(state);
                tempCustObject.setCustZip(zip);
                tempCustObject.setCustPhone(phone);
                tempCustObject.setCustEmail(email);

                /******** Set New Customer Object into session *************/
                session.setAttribute("tempCustObject", tempCustObject); 

                /******** set usernameExists in session **********/
                usernameExists = "true";
                session.setAttribute("usernameExists",usernameExists);
        
                /******** Route back to register.jsp *************/
                response.sendRedirect("http://localhost:8080/TeamOneSports/register.jsp");
            } else {                            // registration successful

                /******** Write New Customer record *************/
                custObj.insertDB(custNum, custType, loginID, pass, firstName, midAn, lastName, address1, address2, city, stateUC, zip, phone, email, startBalance);

                /******** Set New Customer Object into session *************/
                session.setAttribute("custObject", custObj); 

                /******** set usernameExists in session **********/
                usernameExists = "false";
                session.setAttribute("usernameExists",usernameExists);
                
                /******** Route New Customer to custindex.jsp *************/
                response.sendRedirect("http://localhost:8080/TeamOneSports/custindex.jsp");
            }
        }
        catch(Exception e){
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
