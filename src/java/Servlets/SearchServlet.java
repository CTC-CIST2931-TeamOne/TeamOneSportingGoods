package Servlets;

/**
* Class: CIST 2931 Advanced Systems Project
* Semester: Fall 2020
* Instructor: Ronald Enz
* Description: SearchServlet.java
* Due: 09.18.2020
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

@WebServlet(name = "SearchServlet", urlPatterns = {"/SearchServlet"})
public class SearchServlet extends HttpServlet {

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

        System.out.println("*************************** IN SearchServlet *******************");
        
        String searchFromForm = "";
        boolean performCatSearch = false;
        
        searchFromForm = request.getParameter("search");
        
        //FOR TESTING
        System.out.println("searchFromForm: " + searchFromForm);
                                                // get current session        
        HttpSession session = request.getSession();
        
        try {
            Customer custObject;                // Get custObject from session
            custObject = (Customer)session.getAttribute("custObject");
            
            LoadProductTable LP1;
            LP1 = (LoadProductTable)session.getAttribute("allProducts");
            
            if ((searchFromForm.length() == 8) && (searchFromForm.equalsIgnoreCase("football"))){
                performCatSearch = true;
            } else if ((searchFromForm.length() == 8) && (searchFromForm.equalsIgnoreCase("baseball"))){
                performCatSearch = true;
            } else if ((searchFromForm.length() == 10) && (searchFromForm.equalsIgnoreCase("basketball"))){
                performCatSearch = true;
            } else if ((searchFromForm.length() == 6) && (searchFromForm.equalsIgnoreCase("soccer"))){
                performCatSearch = true;
            } else {
                performCatSearch = false;
            }
            
            if (performCatSearch){
                                                // reset list counter
                LP1.searchResult.numberOfProducts = 0;
                                                // perform CATEGORY search
                LP1.searchProductCategory(searchFromForm);
                System.out.println("CATEGORY SEARCH: " + searchFromForm);
            } else {
                                                // reset list counter
                LP1.searchResult.numberOfProducts = 0;
                                                // perform PRODUCTNAME search
                LP1.searchProductName(searchFromForm);
                System.out.println("PRODUCTNAME SEARCH: " + searchFromForm);
            }
            
            LP1.copySearchResult(LP1.searchResult);
                                                // update allProducts in session
                                                //  >> now has searchResult data
            session.setAttribute("allProducts",LP1);

            // Is Guest or Customer logged in? Redirect accordingly
            if ((custObject.getCustLoginID().equals(" ")) || (custObject.getCustType().equals("G"))){
                                                // send back to index.jsp
                response.sendRedirect("http://localhost:8080/TeamOneSports/products.jsp");
            } else {                            // forward to custindex.jsp
                response.sendRedirect("http://localhost:8080/TeamOneSports/custproducts.jsp");
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
