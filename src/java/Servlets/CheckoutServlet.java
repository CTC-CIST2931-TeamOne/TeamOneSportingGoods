package Servlets;

/**
* Class: CIST 2931 Advanced Systems Project
* Semester: Fall 2020
* Instructor: Ronald Enz
* Description: CheckoutServlet.java
* Due: 10.27.2020
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
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "CheckoutServlet", urlPatterns = {"/CheckoutServlet"})
public class CheckoutServlet extends HttpServlet {

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

        System.out.println("*************************** IN CheckoutServlet *******************");
        
                                            // get current session        
        HttpSession session = request.getSession();
                
        try {
            Customer custObject;            // Get custObject from session
            custObject = (Customer)session.getAttribute("custObject");

            LoadProductTable LP1;           // Get products from session
            LP1 = (LoadProductTable)session.getAttribute("allProducts");
                                            // create empty Order object
            Order currentOrder = new Order();
            
            //******************************************************************
            //* Loop through cartList
            //*     generate orderNumber (per product)
            //*     Add product info to orderList of custObject
            //*     Add order ro ORDERDATA table (per product)  
            //******************************************************************

            // message for EMAIL receipt
            String message = "TeamOne Sporting Goods is now processing the following orders:<br />";
           
            // Using BigDecimal variables for cost aggregates
            final double CONST_TAX_RATE = 0.06;
            final double SHIPPING_COST_PER_ITEM = 1.00;
            
            BigDecimal cart_subtotal = new BigDecimal(0.0);
            BigDecimal total_taxes = new BigDecimal(0.0);
            BigDecimal total_shipping = new BigDecimal(0.0);
            BigDecimal cart_total = new BigDecimal(0.0);

            int numberOfProducts = custObject.cartList.numberOfProducts;

            for(int i = 0; i < numberOfProducts; i++){ 

                String productNum = custObject.cartList.cArr.get(i).getProductNumber();

                for (Product product : LP1.productList.productList) { 

                    if (product.getProductNumber().equals(productNum)) {

                        // SET CURRENT ORDER INFO (on a per-product basis)
                        currentOrder.setCustNumber(custObject.getCustNumber());
                        currentOrder.generateOrderNumber();
                        currentOrder.setProductNumber(custObject.cartList.cArr.get(i).getProductNumber());
                        currentOrder.setQuantity(custObject.cartList.cArr.get(i).getQuantity());
                        // generate datestamp
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
                        String date = dateFormat.format(new Date());
                        currentOrder.setOrderDate(date);
                        //generate timestamp
                        SimpleDateFormat timeFormat = new SimpleDateFormat("hhmmss");
                        Calendar calendar = Calendar.getInstance();
                        String time = timeFormat.format(calendar.getTime());
                        currentOrder.setOrderTime(time);
                        currentOrder.setOrderStatus("O");
                        // calc current product_cost ( item cost * quantity )
                        BigDecimal product_cost = new BigDecimal(product.getProductCost() * custObject.cartList.cArr.get(i).getQuantity());                        
                        product_cost = product_cost.setScale(2,RoundingMode.HALF_EVEN);
                        currentOrder.setOrderAmount(product_cost.doubleValue());
                        // calc current product_tax ( (item cost * quantity) * CONST_TAX_RATE )
                        BigDecimal product_tax = new BigDecimal( (product.getProductCost() * custObject.cartList.cArr.get(i).getQuantity()) * CONST_TAX_RATE);                        
                        product_tax = product_tax.setScale(2,RoundingMode.HALF_EVEN);
                        currentOrder.setOrderSalesTax(product_tax.doubleValue());
                        // aggregate tax for total
                        total_taxes = total_taxes.add(product_tax);
                        total_taxes = total_taxes.setScale(2,RoundingMode.HALF_EVEN);
                        // calc current product_shipping_cost ( quantity * SHIPPING_COST_PER_ITEM )
                        BigDecimal product_shipping_cost = new BigDecimal( custObject.cartList.cArr.get(i).getQuantity() * SHIPPING_COST_PER_ITEM);                        
                        product_shipping_cost = product_shipping_cost.setScale(2,RoundingMode.HALF_EVEN);
                        currentOrder.setOrderShippingCost(product_shipping_cost.doubleValue());
                        // aggregate shipping for total
                        total_shipping = total_shipping.add(product_shipping_cost);
                        total_shipping = total_shipping.setScale(2,RoundingMode.HALF_EVEN);
                        // calc current product_order_total ( product_cost +  product_tax + product_shipping_cost )
                        BigDecimal product_order_total = (product_cost).add(product_tax).add(product_shipping_cost);
                        product_order_total = product_order_total.setScale(2,RoundingMode.HALF_EVEN);
                        currentOrder.setOrderTotal(product_order_total.doubleValue());
                        currentOrder.setOrderBalance(product_order_total.doubleValue());

                        currentOrder.setProductSize(custObject.cartList.cArr.get(i).getProductSize());
                        currentOrder.setProductGender(custObject.cartList.cArr.get(i).getProductGender());
                        
                        // write order to ORDERDATA table
                        currentOrder.insertDB(currentOrder.getCustNumber(), currentOrder.getOrderNumber(), currentOrder.getProductNumber(), currentOrder.getQuantity(), currentOrder.getOrderDate(), currentOrder.getOrderTime(), currentOrder.getOrderStatus(), currentOrder.getOrderAmount(), currentOrder.getOrderSalesTax(), currentOrder.getOrderShippingCost(), currentOrder.getOrderTotal(), currentOrder.getOrderBalance(),currentOrder.getProductSize(),currentOrder.getProductGender());
                         
                        // aggregate cost of all products in cart for custObect balance
                        cart_subtotal = cart_subtotal.add(product_cost);
                        
                        // append order numbers to email message
                        message = message.concat(" " + currentOrder.getOrderNumber() + "<br />");
                    }
                }
                
            }
            // TOTALS
            cart_subtotal = cart_subtotal.setScale(2,RoundingMode.HALF_EVEN);
            cart_total = (cart_subtotal).add(total_taxes).add(total_shipping);
            
            // add to current customer balance and update custObject in DB
            custObject.setCustBalance(custObject.getCustBalance() + cart_total.doubleValue());
            custObject.updateDB();
            
            // remove cart records from DB
            for ( int i = 0; i < custObject.cartList.numberOfProducts; i++){
                custObject.cartList.cArr.get(i).deleteDB();
            }

            // clear cartList in custObject
            custObject.cartList.cArr.clear();
            custObject.cartList.numberOfProducts = 0;
         
            //refresh orders in custObject with new orders in ORDERS table
            custObject.orderList.oArr.clear();
            custObject.orderList.numberOfOrders = 0;
            custObject.getOrders();

            //******************************************************************
            //* Exit Order Placement
            //*     set custObject in session
            //*     send Customer/Guest to vieworders.jsp page  
            //******************************************************************            
                                        // set new session custObject
            session.setAttribute("custObject",custObject);
                                        // set new session message
            session.setAttribute("message",message);                
                                        // forward to MailDispatcherServlet
            RequestDispatcher rd = request.getRequestDispatcher("MailDispatcherServlet");
            rd.forward(request,response);

            // Both Guest and Customer redirected to vieworders.jsp after order placed
            //response.sendRedirect("http://localhost:8080/TeamOneSports/vieworders.jsp");
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
