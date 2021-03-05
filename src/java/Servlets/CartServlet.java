package Servlets;

/**
* Class: CIST 2931 Advanced Systems Project
* Semester: Fall 2020
* Instructor: Ronald Enz
* Description: CartServlet.java
* Due: 10.12.2020
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

@WebServlet(name = "CartServlet", urlPatterns = {"/CartServlet"})
public class CartServlet extends HttpServlet {

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

        System.out.println("*************************** IN CartServlet *******************");
        
        String cartActionFromForm = "";
        String productIndexFromForm = "";
        String scrollposition = "";
        
        int pi = 0;
        
        cartActionFromForm = request.getParameter("cartaction");
        productIndexFromForm = request.getParameter("currentproduct");
        scrollposition = request.getParameter("scrollposition");
        
        pi = Integer.parseInt(productIndexFromForm);
                                            // get current session        
        HttpSession session = request.getSession();
        
                                            // set new session scrollposition
        session.setAttribute("scrollposition",scrollposition);
                
        try {
            Customer custObject;            // Get custObject from session
            custObject = (Customer)session.getAttribute("custObject");

            LoadProductTable LP1;           // Get products from session
            LP1 = (LoadProductTable)session.getAttribute("allProducts");
                                            // create empty Cart object
            Cart currentCartEntry;

            //******************************************************************
            //* add to cart
            //******************************************************************
            if (cartActionFromForm.equals("add")){
                // adding from allproducts or searchresult?
                if (LP1.searchResult.numberOfProducts == 0){
                                            // add from allproducts arraylist
                    currentCartEntry = new Cart(custObject.getCustNumber(),LP1.productList.productList.get(pi).getProductNumber(),1,"","");
                } else {                    // add from searchresults arraylist
                    currentCartEntry = new Cart(custObject.getCustNumber(),LP1.searchResult.productList.get(pi).getProductNumber(),1,"","");
                }

                // aggregate similar items added to cart
                int newquantity = 0;
                int prevNumberOfProducts = custObject.cartList.numberOfProducts;
                boolean alreadyincart = false;
                                            // first cart entry? write it
                if (prevNumberOfProducts == 0){
                    custObject.cartList.addCart(currentCartEntry);
                } else {                    // nope, compare for duplicate item
                    for ( int n = 0; n < prevNumberOfProducts; n++){
                        if (currentCartEntry.getProductNumber().equals(custObject.cartList.cArr.get(n).getProductNumber())){
                            newquantity = custObject.cartList.cArr.get(n).getQuantity();
                            newquantity++;  // up the quantity on item
                            custObject.cartList.cArr.get(n).setQuantity(newquantity);
                            alreadyincart = true;
                            break;
                        } else {            // otherwise, set flag for new entry
                            alreadyincart = false;
                        }
                    }                       // if item not in cart, write it
                    if (!(alreadyincart)){
                        custObject.cartList.addCart(currentCartEntry);
                    }
                }

                //custObject.cartList.addCart(currentCartEntry);
                
                session.setAttribute("custObject",custObject);

                // Is Guest or Customer logged in? Redirect accordingly
                if ((custObject.getCustLoginID().equals(" ")) || (custObject.getCustType().equals("G"))){                    
// save cart entry record to file
                                            // send back to index.jsp
                    response.sendRedirect("http://localhost:8080/TeamOneSports/products.jsp");
                } else {                    // save cart and forward to custindex.jsp
                    currentCartEntry.insertDB(currentCartEntry.getCustNumber(),currentCartEntry.getProductNumber(), currentCartEntry.getQuantity(), currentCartEntry.getProductSize(), currentCartEntry.getProductGender());
                    response.sendRedirect("http://localhost:8080/TeamOneSports/custproducts.jsp");
                }
            }
            
            //******************************************************************
            //* remove from cart
            //******************************************************************
            if (cartActionFromForm.equals("remove")){
                // Is Guest or Customer logged in? Save changes accordingly
                if ((custObject.getCustLoginID().equals(" ")) || (custObject.getCustType().equals("G"))){
// remove cart entry record from file
                } else {                    // REMOVE from CUSTOMER Cart DB
                    currentCartEntry = custObject.cartList.cArr.get(pi);
                    currentCartEntry.deleteDB();
                }
                                            // remove from custObject.cartList
                custObject.cartList.removeCart(Integer.parseInt(productIndexFromForm)); 
                                            // set new session custObject
                session.setAttribute("custObject",custObject);

                // Both Guest and Customer redirected to cart.jsp after removeFromCart
                response.sendRedirect("http://localhost:8080/TeamOneSports/cart.jsp");
            }
            
            //******************************************************************
            //* updatecart - update cart with fields in custObject
            //******************************************************************
            if (cartActionFromForm.equals("updatecart")){
                
                String genderSelectionFromForm = "";
                String sizeSelectionFromForm = "";
                genderSelectionFromForm = request.getParameter("genderSelection");
                sizeSelectionFromForm = request.getParameter("sizeSelection");
                
                // Get rid of nulls for database write
                if (genderSelectionFromForm == null){
                    genderSelectionFromForm = " ";
                }
                if (sizeSelectionFromForm == null){
                    sizeSelectionFromForm = " ";
                }
                                            // set gender for current cart product
                custObject.cartList.cArr.get(pi).setProductGender(genderSelectionFromForm);
                                            // set size for current cart product
                custObject.cartList.cArr.get(pi).setProductSize(sizeSelectionFromForm);  
                String quantity;
                
                //Retrieving the dynamic cartquantity parameter
                quantity = request.getParameter("cartquantity[" + productIndexFromForm + "]");

                //Updating current product quantity
                custObject.cartList.cArr.get(Integer.parseInt(productIndexFromForm)).setQuantity(Integer.parseInt(quantity));

                // if Customer is logged in, UPDATE cartlist data for that customer
                if (!(custObject.getCustLoginID().equals(" ")) || (custObject.getCustType().equals("G"))){
                    custObject.cartList.cArr.get(Integer.parseInt(productIndexFromForm)).updateDB();
                } else {
// update cart entry record for guest
                }
                                            // set new session custObject
                session.setAttribute("custObject",custObject);
                
                // Both Guest and Customer redirected to cart.jsp after subtotals
                response.sendRedirect("http://localhost:8080/TeamOneSports/cart.jsp");
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
