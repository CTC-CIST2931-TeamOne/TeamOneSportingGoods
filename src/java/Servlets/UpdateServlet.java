package Servlets;

/**
* Class: CIST 2931 Advanced Systems Project
* Semester: Fall 2020
* Instructor: Ronald Enz
* Description: UpdateServlet.java
* Due: 09.28.2020
* @authors William G. Weldy, Ian Mashburn
* @version 1.0
*
* By turning in this code, I Pledge:
* 1. That I have completed the programming assignment independently.
* 2. I have not copied the code from a student or any source.
* 3. I have not given my code to any student.
 */

import BusinessObjects.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "UpdateServlet", urlPatterns = {"/UpdateServlet"})
public class UpdateServlet extends HttpServlet {

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

        System.out.println("************** IN UpdateServlet ***************"); 
            
        try (PrintWriter out = response.getWriter()) {
            Employee empObject = (Employee)request.getSession().getAttribute("empObject");
            
            Order order;
            String OrderNum;
            String CustNum;
            String ProductNum;
            String Quantity;
            String Date;
            String Time;
            String Status;
            String Amount;
            String Balance ;
            String Tax;
            String Shipping;
            String Total;
            String Size;
            String Gender;
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Maintain Customer Orders || Attributes updated</title>");            
            out.println("</head>");
            out.println("<body>");
            
            for ( int i = 0; i < empObject.orderList.oArr.size(); i++ ) {
                order = empObject.orderList.oArr.get(i);
                
                //Retrieving the parameters
                 OrderNum = request.getParameter("OrderNumTxt[" + i + "]");
                 CustNum = request.getParameter("CustNumTxt[" + i + "]");
                 ProductNum = request.getParameter("ProductNumTxt[" + i + "]");
                 Quantity = request.getParameter("QuantityTxt[" + i + "]");
                 Date = request.getParameter("DateTxt[" + i + "]");
                 Time = request.getParameter("TimeTxt[" + i + "]");
                 Status = request.getParameter("StatusTxt[" + i + "]");
                 Amount = request.getParameter("AmountTxt[" + i + "]");
                 Balance = request.getParameter("BalanceTxt[" + i + "]");
                 Tax = request.getParameter("TaxTxt[" + i + "]");
                 Shipping = request.getParameter("ShippingTxt[" + i + "]");
                 Total = request.getParameter("TotalTxt[" + i + "]");
                 Size = request.getParameter("SizeTxt[" + i + "]");
                 Gender = request.getParameter("GenderTxt[" + i + "]");

                //Change everything
                order.setOrderNumber(OrderNum);
                order.setCustNumber(CustNum);
                order.setProductNumber(ProductNum);
                order.setQuantity(Integer.parseInt(Quantity));
                order.setOrderDate(Date);
                order.setOrderTime(Time);
                order.setOrderStatus(Status);
                order.setOrderAmount(Double.parseDouble(Amount));
                order.setOrderBalance(Double.parseDouble(Balance));
                order.setOrderSalesTax(Double.parseDouble(Tax));
                order.setOrderShippingCost(Double.parseDouble(Shipping));
                order.setOrderTotal(Double.parseDouble(Total));
                order.setProductSize(Size);
                order.setProductGender(Gender);

                //and then update
                order.updateDB();
            }
            
            HttpSession session = request.getSession();
            session.setAttribute("empObject", empObject);
            
            response.sendRedirect("http://localhost:8080/TeamOneSports/maintorders.jsp");

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
