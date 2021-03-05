/**
* Team one Sporting Goods
* Semester: Fall 2020
* Description: PaymentServlet.java
* Due: 09.18.2020
* @authors Hunter Browder
* @version 1.0
*
 */
package Servlets;

import BusinessObjects.Customer;
import BusinessObjects.PaymentMethod;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "PaymentServlet", urlPatterns = {"/PaymentServlet"})
public class PaymentServlet extends HttpServlet {

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
        
        System.out.println("*************************** IN PaymentServlet *******************");
        
        //Declare empty variables
        
        int currentPayMethod;
        
        String currentCustNum = "";
        String currentCardNum = "";
        
        String firstName = "";
        String midInitial = "";
        String lastName = "";
        
        String custNumber = "";
        String cardNumber =  "";
        String cvv =  "";
        String expDate = "";
        String cardType =  "";
        String billAddress1 =  "";
        String billAddress2 =  "";
        String city =  "";
        String state =  "";
        String zip =  "";
        String phone = "";
        String email = "";
        
        String beingedited = "";
        
        PaymentMethod payMethodObject = new PaymentMethod();

        
        
         //Fill variable With Picked Radio Payment 
         
        beingedited = request.getParameter("beingedited");

        if (beingedited.equals("true")){
            firstName = request.getParameter("firstNameEdited");
            midInitial = request.getParameter("midInitialEdited");
            lastName = request.getParameter("lastNameEdited");
            cardNumber =  request.getParameter("cardNumberEdited");
            cvv =  request.getParameter("cvvEdited");
            expDate = request.getParameter("expDateEdited");
            cardType =  request.getParameter("cardTypeEdited");
            billAddress1 =  request.getParameter("addressEdited");
            billAddress2 =  request.getParameter("address2Edited");
            city =  request.getParameter("cityEdited");
            state =  request.getParameter("stateEdited");
            zip =  request.getParameter("zipEdited");
            phone = request.getParameter("phoneEdited");
            email = request.getParameter("emailEdited");            
        } else {
            firstName = request.getParameter("firstName");
            midInitial = request.getParameter("midInitial");
            lastName = request.getParameter("lastName");
            cardNumber =  request.getParameter("cardNumber");
            cvv =  request.getParameter("cvv");
            expDate = request.getParameter("expDate");
            cardType =  request.getParameter("cardType");
            billAddress1 =  request.getParameter("address");
            billAddress2 =  request.getParameter("address2");
            city =  request.getParameter("city");
            state =  request.getParameter("state");
            zip =  request.getParameter("zip");
            phone = request.getParameter("phone");
            email = request.getParameter("email");
        }

        if ((midInitial.isEmpty()) || (midInitial.equals("null"))){
            midInitial = " ";
        }
        if ((billAddress2.equals("null"))){
            billAddress2 = " ";
        }
        
        //Retrieve current session
        HttpSession session = request.getSession();
        
        
        try (PrintWriter out = response.getWriter()) {
            
            
            //Retrieve customer object from session   
            Customer custObject;
            custObject = (Customer)session.getAttribute("custObject");
            
            //Retrieve Current customer number from Object   
            custNumber = custObject.getCustNumber();
            
            System.out.println(request.getParameter("submit"));
            
            if(request.getParameter("submit").equals("Save")){
            
                
                payMethodObject.setCustNumber(custNumber);
                payMethodObject.setBillFirstName(firstName);
                payMethodObject.setBillMidInitial(midInitial);
                payMethodObject.setBillLastName(lastName);
                payMethodObject.setCardType(cardType);
                payMethodObject.setCardNumber(cardNumber);
                payMethodObject.setCardCVV(cvv);
                payMethodObject.setCardExpDate(expDate);
                payMethodObject.setBillAddrLine1(billAddress1);
                payMethodObject.setBillAddrLine2(billAddress2);
                payMethodObject.setBillCity(city);
                payMethodObject.setBillState(state.toUpperCase());
                payMethodObject.setBillZip(zip);
                payMethodObject.setBillPhone(phone);
                payMethodObject.setBillEmail(email);
                
                payMethodObject.show();
                payMethodObject.updateDB();
                
                
               
                
                
                
                
                
            }
            
            else if(request.getParameter("submit").equals("Add")){
                      
               payMethodObject.insertDB(custNumber, cardNumber, cardType, expDate, cvv, firstName, midInitial, lastName, billAddress1, billAddress2, city, state.toUpperCase(), zip, phone, email);
          
               payMethodObject.show(); 
                
            
            }
            
            
            else if(request.getParameter("submit").equals("Delete")){
            
               currentPayMethod = Integer.parseInt(request.getParameter("payMethod"));
                
               currentCustNum = custObject.paymentMethodList.pmArr.get(currentPayMethod).getCustNumber();
               currentCardNum = custObject.paymentMethodList.pmArr.get(currentPayMethod).getCardNumber();
               
               
               payMethodObject.setCardNumber(currentCardNum);
               payMethodObject.setCustNumber(currentCustNum);
               
            
               payMethodObject.show(); 
               
               payMethodObject.deleteDB();
                
            
            }
            
        
            //Rest Payment Methods list
            custObject.paymentMethodList.pmArr.clear();
            custObject.paymentMethodList.numberOfPaymentMethods = 0;
            
            //Retrieve and Create Updated payment Method list
            custObject.getPaymentMethods();
            
            
            //Updates Customer Object in session
            session.setAttribute("custObject", custObject);

            boolean checkingout = false;
            // Checks if checkingout has been made in session
            if(session.getAttribute("checkingout") != null){

                //sets checkingout boolean to true if checkingout
                checkingout =  Boolean.valueOf((String)session.getAttribute("checkingout"));

                //sets the session Variable back to false
                //session.setAttribute("checkingout", "false");
            }
  
            //Redirect Back to Profile page
            response.sendRedirect("http://localhost:8080/TeamOneSports/profile.jsp");
            
            
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
