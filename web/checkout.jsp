<%-- 
* Class: CIST 2931 Advanced Systems Project
* Semester: Fall 2020
* Instructor: Ronald Enz
* Description: checkout.jsp
* Due: 10.18.2020
* @authors Ian Mashburn
* @version 1.0
*
* By turning in this code, I Pledge:
* 1. That I have completed the programming assignment independently.
* 2. I have not copied the code from a student or any source.
* 3. I have not given my code to any student.
--%>
<%@page import="java.math.RoundingMode"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="BusinessObjects.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<HTML lang="en">

<HEAD>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>
        Customer Checkout || Please give us an A+
    </title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/vieworder.css">
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
</HEAD>

<!--START OF OBJECT LOAD FROM SESSION-->
<%
    System.out.println("***************** IN checkout JSP *******************");

    boolean selectsFoundInCart = false;
    
    //**************************************************************************
    // custObject: get session (contains orderList,cartList,paymentMethodList)
    //**************************************************************************                   
    Customer custObject;                    // Get custObject from session
    custObject = (Customer)session.getAttribute("custObject");

    //******************************************************************
    //* Loop through cartList
    //*     validate size and gender selection
    //*     return to cart if any are showing as 'Select' as values
    //*     else continue processing checkout
    //******************************************************************
    for ( int i = 0; i < custObject.cartList.numberOfProducts; i++){
        if ((custObject.cartList.cArr.get(i).getProductSize().equals("Select")) || (custObject.cartList.cArr.get(i).getProductGender().equals("Select"))){
            selectsFoundInCart = true;
        }
    }

    if (selectsFoundInCart){
%>
            <script>alert("Make all Size and Gender selections before proceeding to Checkout."); window.location.href = "http://localhost:8080/TeamOneSports/cart.jsp";</script>
<%        
    } else {
        String checkingout = "true";            // set checkingout to true
                                                // set checkingout in session
        session.setAttribute("checkingout",checkingout);

        // generate behind-the-scenes account# for Guest and fill critical fields
        if ((custObject.getCustLoginID().equals(" ")) || (custObject.getCustType().equals("G"))){
            // don't generate if already a Guest, else generate
            if (!(custObject.getCustLoginID().equals("Guest"))){
                custObject.generateCustNumber();
                custObject.setCustType("G");
                custObject.setCustLoginID("Guest");
                                                    // write customer record to DB Table
                custObject.insertDB(custObject.getCustNumber(), custObject.getCustType(), custObject.getCustLoginID(), " ", " ", " ", " ", " ", " ", " ", "  ", "     ", "          ", " ", 0.0);
            }
        }
    }
%>
<!--END OF OBJECT LOAD FROM SESSION-->

<%  // if custObject.getFirstName() is empty,
    //        don't display addr and payment info
    if (custObject.getCustFirstName() == " ") {
%>
<BODY onload = "gotoProfile(event)">
<%
    } else {
%>
<BODY>
<%
    }
%>

<!--START OF PAGE HEADER-->
    <div class="header">
<!---------------------- The Navbar/Searchbar -------------------------------->
        <div class="navbar">
            <div class="logo">
                <!-- START LOGO HOME LINK -->
                <%  // if custObject is empty, link goes to index.jsp
                    if ((custObject.getCustNumber() == " ")|| (custObject.getCustLoginID() == "Guest")){
                %>
                    <a href="index.jsp">	
                        <img src="images/logo.png" width="160px">
                    </a>
                <%  // else, link goes to custindex.jsp : customer logged in
                    } else {
                %>
                    <a href="custindex.jsp">	
                        <img src="images/logo.png" width="160px">
                    </a>
                <%
                        }
                %> <!-- END LOGO HOME LINK -->
            </div>
            <div class="search-container">
                <!--<form action="/action_page.php">-->
                <form name="SearchForm" method="post" id="SearchForm" action="http://localhost:8080/TeamOneSports/SearchServlet">
                    <input type="text" placeholder="Search" name="search">
                    <button type="submit">
                        <i class="fa fa-search">
                        </i>
                    </button>
                </form>
            </div>
            <nav class="nav-bar"><!--altered by eadry-->
                <a href="cart.jsp">
                    <img class="cartlogo" src="images/imagecart.png" width="35px" height="35">
                </a>
                <!-- BEGIN LOGIN or MYACCOUNT MENU ITEM -->
                <%  // if custObject is empty or Guest, display LOGIN button
                    if ((custObject.getCustNumber() == " ") || (custObject.getCustLoginID()== "Guest")) {
                %>
                        <button id="login_btn" class="log_btn">
                            Login
                        </button>
                        <a href="index.jsp">Home</a>
                <%  // else, display My Account drop-down
                    } else {
                %>
                    <div class="dropdown">
                        <button class="dropbtn" onclick="myFunction(this);"><%=custObject.getCustLoginID()%>
                            <i class="fa fa-caret-down"></i>
                        </button>
                        <div class="dropdown-content" id="myDropdown">
                            <a href="profile.jsp">View/Update Profile</a>
                            <a href="vieworders.jsp">View Orders</a>
                            <a href="LogoutServlet">Logout</a>
                        </div>
                    </div>
                    <a href="custindex.jsp">Home</a>
                <%
                    }
                %> <!-- END LOGIN or MYACCOUNT MENU ITEM -->
                
                <div class="dropdown">
                    <button class="dropbtn" onclick="myFunction(this);">Shop Sports
                        <i class="fa fa-caret-down"></i>
                    </button>
                    <div class="dropdown-content" id="myDropdown">
                        <a href="SearchServlet?search=basketball" name="search">Basketball</a>
                        <a href="SearchServlet?search=soccer" name="search">Soccer</a>
                        <a href="SearchServlet?search=baseball" name="search">Baseball</a>
                        <a href="SearchServlet?search=football" name="search">Football</a>
                    </div>
                </div>
                <a href="ProductsServlet">All Products</a>
            </nav>
            <script src="js/dropdown-navbar.js"></script>
<!---------------------- The Modal --------------------------------------------->
            <div id="myModal" class="modal">
                <!-- Modal content -->
                <div class="modal-content">
                    <span class="close"><i class="far fa-times-circle"></i></span>
                    <strong><p>	Login	<p /><strong />
                    <form name="LoginForm" method="post" id="LoginForm" action="http://localhost:8080/TeamOneSports/LoginServlet">
                        <input class="margin box" onkeydown="nospace(event)" type=text placeholder="Username" name="user" id="user" autocomplete="off"/>
                        <br />
                        <input class="margin box" onkeydown="nospace(event)" type=text placeholder="Password" name="pass" id="pass" autocomplete="off"/>
                        <br />
                        <input class="margin" type="submit" onclick="check();" value="Login" />
                    </form>
                    <form name="RegisterForm" method="post" id="RegisterForm" action="http://localhost:8080/TeamOneSports/register.jsp" >
                        <br />
                        <p>Don't Have An Account? </p> 
                        <input class="margin" type="submit" value="Register" />
                    </form>
                </div>
                <script src="js/check_input.js"></script>
            </div>
        </div>
    </div>
<!--END OF PAGE HEADER-->

<!--START OF main CONTAINER-->
    <div>
        <br>
        <br>
        <br>
        <br>
        <br>
        <h1 class="tableTitle">Checkout </h1>
        <div class="tableborder" id="tablebordercolor">
            <br>
            <br>

            <h3 class="tableTitle">Your Shipping Information  </h3><br>
            <!--  Shipping Information Table -Only Displaying info-->

            <table  class="t02" border="3">
                <tr>
                    <td><b>Recipient&nbspName:</b></td>
                    <td><%= custObject.getCustFirstName()  %>&nbsp<%= custObject.getCustLastName()  %></td> 
                </tr>
                <tr>
                    <td><b>Recipient Address:</b></td>
                    <td>
                        <!--     message for Missing address 1 & 2 data  -->
                        <%! String addressError = "N/A"; %>
                        <!--    getCustAddrLine1-->
                        <% if (custObject.getCustAddrLine1()==null) { %>
                            <%= addressError%>
                        <% } else { %>
                            <%=custObject.getCustAddrLine1()%>
                        <% } %>
                        <!--    getCustAddrLine1-->
                        <!--    getCustAddrLine2-->
                        <%  String addrline2 = custObject.getCustAddrLine2();
                            // don't display if addrline2 is null or has whitespace
                            if (!(addrline2 == null || addrline2.trim().length() == 0)) { %>
                                <br>
                                <%=custObject.getCustAddrLine2()%>
                        <%  } %>
                        <!--    getCustAddrLine2-->
                        <!--    City, State, Zip-->
                        <br>
                        <%= custObject.getCustCity() %>,&nbsp<%= custObject.getCustState() %>&nbsp<%= custObject.getCustZip() %>
                        <!--    City, State, Zip-->
                    </td>
                </tr>
                <tr border="none">
                    <td></td> 
                    <td style="text-align: left; "><a href="http://localhost:8080/TeamOneSports/profile.jsp"><span style="font-size: 16px; ">Update Info</span></a></td>
                </tr>
            </table> 
            <br>
            <br>
            <!--  End of Shipping Information Table -->

            <!--   Payment Info Form starts-->
            <form method="post"  action="">

                <!-- Choosing your Billing Card -->
                <div class="billingoption" >
                    <select name="payment" id="payment">
                        <option selected disabled>Choose Your Payment method:</option>
                <%
                        int numberOfPaymentMethods = custObject.paymentMethodList.numberOfPaymentMethods;
                        for(int i = 0; i < numberOfPaymentMethods; i++){ 

                            String cardNumber = custObject.paymentMethodList.pmArr.get(i).getCardNumber();                                   
                            String Cardtype = custObject.paymentMethodList.pmArr.get(i).getCardType();
                %>  
                            <option value=<%= cardNumber %>><%= Cardtype%> ending in <%= cardNumber.substring(cardNumber.length() - 4)%></option>
                <%      } %>
                    </select>
                <%  if (custObject.paymentMethodList.numberOfPaymentMethods == 0) {
                %>
                        <a href="http://localhost:8080/TeamOneSports/profile.jsp"> Add Payment Method </a>
                <%  } else {    %>
                        <a href="http://localhost:8080/TeamOneSports/profile.jsp"> Update Billing Info</a>
                <%  }   %>
                    <br>
                    <br>
                </div>
                <br>
            </form>

            <!--  Payment Info Form Ends-->  
            <!-- process cartlist objects--> 
            <h3 class="tableTitle">Your items: </h3><br>
            <table class="t02" border="3">
                <tr>
                    <th style="text-align: left;"> </th>
                    <th style="text-align: left;">Product Name: </th>
                    <th style="text-align: left;">Product #: </th>
                    <th style="text-align: left;">Price </th>
                    <th style="text-align: left;">Quantity: </th>

                </tr>
            <%
                // getting session products
                LoadProductTable LP1;
                LP1 = (LoadProductTable)session.getAttribute("allProducts");

                //    Using BigDecimal variables for Payment summary section
                final double CONST_TAX_RATE = 0.06;
                final double SHIPPING_COST_PER_ITEM = 1.00;
                BigDecimal cart_subtotal = new BigDecimal(0.0);
                BigDecimal tax_rate = new BigDecimal(CONST_TAX_RATE);
                BigDecimal cart_tax = new BigDecimal(0.0);
                BigDecimal cart_shipping_total = new BigDecimal(0.0);
                BigDecimal cart_total = new BigDecimal(0.0);

                int numberOfProducts = custObject.cartList.numberOfProducts;

                for(int i = 0; i < numberOfProducts; i++){ 

                    String productNum = custObject.cartList.cArr.get(i).getProductNumber();

                    for (Product product : LP1.productList.productList) { 

                        if (product.getProductNumber().equals(productNum)) {

                            //  aggregates for TOTALS display
                            double productCost =product.getProductCost();
                            String productName = product.getProductName();
                            String productNumber = product.getProductNumber();
                            int productQuantity = custObject.cartList.cArr.get(i).getQuantity();
            %>  
                            <tr>
                                <td ><img src="<%= product.getProductImagePath() %>"   height=100 width=100></img></td>
                                <td name="productName" style="text-align: left;"><%=productName%></td>
                                <td name="productNum" style="text-align: left;"><%=productNumber%></td>
                                <td name="productCost" style="text-align: left;"><%=productCost%></td>
                                <td name="productQuantity" style="text-align: left;"><%=productQuantity%></td>
                            </tr>
            <%              // aggregate cost of all products in cart
                            BigDecimal product_cost = new BigDecimal(product.getProductCost() * custObject.cartList.cArr.get(i).getQuantity());
                            product_cost = product_cost.setScale(2,RoundingMode.HALF_EVEN);
                            cart_subtotal = cart_subtotal.add(product_cost);
                            BigDecimal product_quantity = new BigDecimal(productQuantity * SHIPPING_COST_PER_ITEM);
                            product_quantity = product_quantity.setScale(2,RoundingMode.HALF_EVEN);
                            cart_shipping_total = cart_shipping_total.add(product_quantity);
                        }
                    }
                }
            %> 
            </table>
             <!-- End of test cartlist objects-->
            <br>
            <br>
    <!--    Payment Summary table starts-->
    <% 
            if ((custObject.cartList.numberOfProducts) > 0){
                cart_tax = cart_subtotal.multiply(tax_rate);
                cart_total = cart_subtotal.add(cart_tax);
                cart_total = cart_total.add(cart_shipping_total);
            %>
                <h3 class="tableTitle">Order Summary: </h3><br>
                <table class="t02" border="3">
                    <tr>
                        <td>Subtotal:</td>
                        <td name="Subtotal"><%='$' + String.format("%,.2f", cart_subtotal)%></td>
                    </tr>
                    <tr>
                        <td>Tax:</td>
                        <td name="totalTax"><%='$' + String.format("%,.2f", cart_tax)%></td>
                    </tr>
                    <tr>
                        <td>Shipping ($1.00 per item)</td>
                        <td name="totalShipping"><%='$' + String.format("%,.2f", cart_shipping_total)%></td>
                    </tr>
                    <tr>
                        <td>Total:</td>
                        <td name="total"><%='$' + String.format("%,.2f", cart_total)%></td>
                    </tr>
                </table>
                <!--Payment Summary table Ends-->
    <%      } %>
            <br>
            <br>
   
            <!-- Confirm Order Placement and forward to CheckoutServlet.java  -->
            <form name="placeorder" method="post" id="placeorder" action="http://localhost:8080/TeamOneSports/CheckoutServlet">
                <input class ="save" type="submit" name="submit" value="Place your order" onclick="placeOrder(event);" style="height:50px;width:200px"> 
            </form>
            <br>
            <br>
        </div>                     
        <br>
        <br>
        <br>
        <br>
        <br>
    </div>
    <br>
<!--END OF CART LIST CONTAINER-->

<!--START OF PAGE FOOTER-->
<!------------------------Bottom Footer------------------------------------>
    <div class="footer">
        <div class="sale_container">
            <div class="row">
                <div class="columnfoot">
                    <h3>
                        Download Our App
                    </h3>
                    <p>
                        Download our App for Android and IOS.
                    </p>
                    <div class="imageapp">
                        <img src="images/imageplaystore.png">
                        <img src="images/imageapplestore.png">
                    </div>
                </div>
                <div class="columnfoot2">
                    <img src="images/logo.png" alt="">
                    <p>
                        We at TeamOne Strive to Make Your Sporting
                        Experience the best it can possibly be.
                    </p>
                </div>
                <div class="columnfoot3">
                    <h3>
                        Useful Links
                    </h3>
                    <ul>
                        <li>
                            <a href="CovidFAQ.jsp">
                                Covid FAQs and Hours
                            </a>
                        </li>
                        <li>
                            <a href="FAQ.jsp">
                                General FAQs
                            </a>
                        </li>
                        <li>
                            Coupon Codes
                        </li>
                        <li>
                            Company Posts
                        </li>
                        <li>
                            Return Policy
                        </li>
                        <li>
                            Join our Team
                        </li>
                    </ul>
                </div>
                <div class="columnfoot4">
                    <h3>
                        Follow Us on Social Media!
                    </h3>
                    <ul>
                        <li>
                            Facebook
                        </li>
                        <li>
                            Twitter
                        </li>
                        <li>
                            Instagram
                        </li>
                        <li>
                            Youtube
                        </li>
                    </ul>
                </div>
            </div>
            <hr>
            <p class="copyright">
                ©2020 TeamOne CIST2931 Fall Chattahoochee Tech
            </p>
        </div>
    </div>
<!--END OF PAGE FOOTER-->

</BODY>
</HTML>
