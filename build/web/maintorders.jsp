<%-- 
* Class: CIST 2931 Advanced Systems Project
* Semester: Fall 2020
* Instructor: Ronald Enz
* Description: maintorders.jsp
* Due: 09.18.2020
* @authors Edrey Torres, Patricia Rivera, Ian Mashburn & William G. Weldy
* @version 1.0
* 
* By turning in this code, I Pledge:
* 1. That I have completed the programming assignment independently.
* 2. I have not copied the code from a student or any source.
* 3. I have not given my code to any student.
--%>
<%@page import="BusinessObjects.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<HTML lang="en">

<HEAD>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>
        Maintain Customer Orders || Please give us an A+
    </title>
	<!--<link rel="stylesheet" href="css/style.css">-->
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
    <link rel="stylesheet" href="css/maintorders.css">
    <!--<script src="js/empLoginValidation.js"></script>  <!-- Load loginValidation JavaScript -->
    <script src="https://code.jquery.com/jquery-3.5.0.js"></script>
    <script src="js/check_input.js"></script>
</HEAD>

<!--START OF INITIALIZE SESSION OBJECTS-->
<%  
    System.out.println("**************** IN maintorders JSP *****************"); 
    
    //**************************************************************************
    // get empObject from session (includes ArrayList of all orders in DB)
    //**************************************************************************
    Employee empObject = new Employee();
    empObject = (Employee)session.getAttribute("empObject");
    
    empObject.show();
    //empObject.getOrders();
%>
<!--END OF OF INITIALIZE SESSION OBJECTS-->
<BODY>

    <!-- PAGE LAYOUT GOES HERE -->
    <div class="adminnav"><center ><h1><span class="truck"><i class="fas fa-shipping-fast"></i></span> View/Change Customer Order Information<span class="truck"> <i class="fas fa-shipping-fast"></i></span></h1>
        <span style="color: black;"> Click on the text box and type in any valid data value in order to change any one of the attributes. Then click Submit to commit those changes.</span> <br><br></center>
    </div>
    <%  
        Order order;

        for ( int i = 0; i < empObject.orderList.oArr.size(); i++ ) {
            order = empObject.orderList.oArr.get(i);
    %>
    <form id="form<%=i%>" class="demo-flex" action="http://localhost:8080/TeamOneSports/UpdateServlet" method="post">
        <table class="test" border="3">
        <%
            out.println("<tr>");		
                out.println("<td>Customer Number</td>");
                out.println("<td><input class=\"infoBox\" id=\"custNum" + i + "\" type=\"text\" name=\"CustNumTxt[" + i + "]\" value=\"" + order.getCustNumber() + "\" readonly/></td>");
            out.println("</tr>");
            out.println("<tr>");
                out.println("<td>Order Number</td>");
                out.println("<td><input class=\"infoBox\" id=\"orderNum" + i + "\" type=\"text\" name=\"OrderNumTxt[" + i + "]\" value=\"" + order.getOrderNumber() + "\" readonly/></td>");
            out.println("</tr>");
            out.println("<tr>");
                out.println("<td>Product Number</td>");
                out.println("<td><input class=\"infoBox\" id=\"product" + i + "\" type=\"text\" name=\"ProductNumTxt[" + i + "]\" value=\"" + order.getProductNumber() + "\" readonly/></td>");
            out.println("</tr>");
            out.println("<tr>");
                out.println("<td>Quantity</td>");
                out.println("<td><input class=\"infoBox\" placeholder=\"" + order.getQuantity() + "\" id=\"quantity" + i + "\" pattern=\"^[0-9]{1,4}$\" oninvalid=\"quantityInvalid(" + i + ")\" oninput=\"quantityValid(" + i + ")\" onkeydown=\"nospace(event)\" type=\"text\" name=\"QuantityTxt[" + i + "]\" value=\"" + order.getQuantity() + "\"/></td>");
                out.println("<td><input type=\"button\" value=\"Reset\" onclick=\"resetInfoQuantity(" + i + ")\" /></td>");
            out.println("</tr>");
            out.println("<tr>");
                out.println("<td>Order Date</td>");
                out.println("<td><input class=\"infoBox\" placeholder=\"" + order.getOrderDate() + "\" id=\"orderDate" + i + "\" type=\"text\" name=\"DateTxt[" + i + "]\" value=\"" + order.getOrderDate() + "\" readonly/></td>");
            out.println("</tr>");
            out.println("<tr>");
                out.println("<td>Order Time</td>");
                out.println("<td><input class=\"infoBox\" placeholder=\"" + order.getOrderTime() + "\" id=\"orderTime" + i + "\" type=\"text\" name=\"TimeTxt[" + i + "]\" value=\"" + order.getOrderTime() + "\" readonly/></td>");
            out.println("</tr>");
            out.println("<tr>");
                out.println("<td>Order Status</td>");
                out.println("<td><input class=\"infoBox\" placeholder=\"" + order.getOrderStatus() + "\" id=\"orderStatus" + i + "\" pattern=\"^[A-Z]{1}$\" oninvalid=\"orderStatusInvalid(" + i + ")\" oninput=\"orderStatusValid(" + i + ")\" maxlength=\"1\" onkeydown=\"nospace(event)\" type=\"text\" name=\"StatusTxt[" + i + "]\" value=\"" + order.getOrderStatus() + "\"/ required></td>");
                out.println("<td><input type=\"button\" value=\"Reset\" onclick=\"resetInfoStatus(" + i + ")\" /></td>");
            out.println("</tr>");
            out.println("<tr>");
                out.println("<td>Order Amount</td>");
                out.println("<td><input class=\"infoBox\" placeholder=\"" + order.getOrderAmount() + "\" id=\"orderAmount" + i + "\" pattern=\"^[0-9.]{12}*$\" oninvalid=\"orderAmountInvalid(" + i + ")\" oninput=\"orderAmountValid(" + i + ")\" onkeydown=\"nospace(event)\" type=\"text\" name=\"AmountTxt[" + i + "]\" value=\"" + String.format("%-10.2f",order.getOrderAmount()) + "\"/ required></td>");
                out.println("<td><input type=\"button\" value=\"Reset\" onclick=\"resetInfoAmount(" + i + ")\" /></td>");
            out.println("</tr>");
            out.println("<tr>");
                out.println("<td>Balance</td>");
                out.println("<td><input class=\"infoBox\" placeholder=\"" + order.getOrderBalance() + "\" id=\"orderBalance" + i + "\" pattern=\"^[0-9.]{12}*$\" oninvalid=\"orderBalanceInvalid(" + i + ")\" oninput=\"orderBalanceValid(" + i + ")\" onkeydown=\"nospace(event)\" type=\"text\" name=\"BalanceTxt[" + i + "]\" value=\"" + String.format("%-10.2f",order.getOrderBalance()) + "\"/></td>");
                out.println("<td><input type=\"button\" value=\"Reset\" onclick=\"resetInfoBalance(" + i + ")\" /></td>");
            out.println("</tr>");
            out.println("<tr>");
                out.println("<td>Sales Tax</td>");
                out.println("<td><input class=\"infoBox\" placeholder=\"" + order.getOrderSalesTax() + "\" id=\"orderTax" + i + "\" pattern=\"^[0-9.]{12}*$\" oninvalid=\"orderTaxInvalid(" + i + ")\" oninput=\"orderTaxValid(" + i + ")\" onkeydown=\"nospace(event)\" type=\"text\" name=\"TaxTxt[" + i + "]\" value=\"" + String.format("%-10.2f",order.getOrderSalesTax()) + "\"/></td>");
                out.println("<td><input type=\"button\" value=\"Reset\" onclick=\"resetInfoTax(" + i + ")\" /></td>");
            out.println("</tr>");
            out.println("<tr>");
                out.println("<td>Order Shipping</td>");
                out.println("<td><input class=\"infoBox\" placeholder=\"" + order.getOrderShippingCost() + "\" id=\"orderShip" + i + "\" pattern=\"^[0-9.]{12}*$\" oninvalid=\"orderShipInvalid(" + i + ")\" oninput=\"orderShipValid(" + i + ")\" onkeydown=\"nospace(event)\" type=\"text\" name=\"ShippingTxt[" + i + "]\" value=\"" + String.format("%-10.2f",order.getOrderShippingCost()) + "\"/></td>");
                out.println("<td><input type=\"button\" value=\"Reset\" onclick=\"resetInfoShipping(" + i + ")\" /></td>");
            out.println("</tr>");
            out.println("<tr>");
                out.println("<td>Order Total</td>");
                out.println("<td><input class=\"infoBox\" placeholder=\"" + order.getOrderTotal() + "\" id=\"orderTotal" + i + "\" pattern=\"^[0-9.]{12}*$\" oninvalid=\"orderTotalInvalid(" + i + ")\" oninput=\"orderTotalValid(" + i + ")\" onkeydown=\"nospace(event)\" type=\"text\" name=\"TotalTxt[" + i + "]\" value=\"" + String.format("%-10.2f",order.getOrderTotal()) + "\"/></td>");
                out.println("<td><input type=\"button\" value=\"Reset\" onclick=\"resetInfoTotal(" + i + ")\" /></td>");
            out.println("</tr>");
            out.println("<tr>");
                out.println("<td>Product Size</td>");
                // check for null in optional size field
                if ((order.getProductSize() == null) || (order.getProductSize().isEmpty())){
                    order.setProductSize(" ");
                }
                out.println("<td><input class=\"infoBox\" placeholder=\"" + order.getProductSize() + "\" id=\"prodSize" + i + "\" pattern=\"^[0-9.]{4}*$\" oninvalid=\"prodSizeInvalid(" + i + ")\" oninput=\"prodSizeValid(" + i + ")\" maxlength=\"5\" onkeydown=\"nospace(event)\" type=\"text\" name=\"SizeTxt[" + i + "]\" value=\"" + order.getProductSize() + "\"/></td>");
                out.println("<td><input type=\"button\" value=\"Reset\" onclick=\"resetInfoSize(" + i + ")\" /></td>");
            out.println("</tr>");
            out.println("<tr>");
                out.println("<td>Product Gender</td>");
                // check for null in optional gender field
                if ((order.getProductGender() == null) || (order.getProductGender().isEmpty())){
                    order.setProductGender(" ");
                }
                out.println("<td><input class=\"infoBox\" placeholder=\"" + order.getProductGender() + "\" id=\"prodGender" + i + "\" pattern=\"^[A-Z]{1}*$\" oninvalid=\"prodGenderInvalid(" + i + ")\" oninput=\"prodGenderValid(" + i + ")\" maxlength=\"1\" onkeydown=\"nospace(event)\" type=\"text\" name=\"GenderTxt[" + i + "]\" value=\"" + order.getProductGender() + "\"/></td>");
                out.println("<td><input type=\"button\" value=\"Reset\" onclick=\"resetInfoGender(" + i + ")\" /></td>");
            out.println("</tr>");
            out.println("<tr>");
                out.println("<td>Reset Forum</td>");
                out.println("<td><input type=\"button\" value=\"Reset Forum\" onclick=\"resetForum(" + i + ")\" /></td>");
            out.println("</tr>");
        %>
        </table>
        <%
            }
        %>
        <div class="inputAndbutton"> <button class="button"type="button" name="backbtn" onclick="location.href='http://localhost:8080/TeamOneSports/index.jsp';"><< Go To Home Page</button>
            <input class="button" type="Submit" onclick="confirmUpdate(event)" value="* Submit Changes *" />
        </div>
    </form>
    
    <hr>
    <footer> <!-- Page Footer -->
        <small><em>©2020 TeamOne CIST2931 Fall Chattahoochee Tech</em></small>
    </footer>
    
</BODY>
</HTML>
