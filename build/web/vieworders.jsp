<%-- 
* Class: CIST 2931 Advanced Systems Project
* Semester: Fall 2020
* Instructor: Ronald Enz
* Description: vieworders.jsp
* Due: 09.20.2020
* @authors edreytorres, Ian Mashburn
* @version 1.0
*
* By turning in this code, I Pledge:
* 1. That I have completed the programming assignment independently.
* 2. I have not copied the code from a student or any source.
* 3. I have not given my code to any student.
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="BusinessObjects.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<HTML lang="en">

<HEAD>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>
        View Orders || Please give us an A+
    </title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/vieworder.css">
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
</HEAD>

<BODY>
<!--START OF OBJECT LOAD FROM SESSION-->
<%
    System.out.println("**************** IN vieworders JSP ******************");

    // custObject: set session (contains orderList,cartList,paymentMethodList)                     
    Customer custObject;                    // Get custObject from session
    custObject = (Customer)session.getAttribute("custObject");

    // Checks if checkingout has been made in session
    if(session.getAttribute("checkingout") != null){
        
        //sets the session Variable back to false
        session.setAttribute("checkingout", "false");
    }
%>
<!--END OF OBJECT LOAD FROM SESSION-->

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
                <%  // if custObject is empty, display LOGIN button
                    if ((custObject.getCustNumber() == " ")|| (custObject.getCustLoginID() == "Guest")){
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
                %>
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

<!--START OF Order DATA CONTAINER-->

<!-------------
    *Merging HTML/CSS tables with JSP done by Edrey 
    *9/29/2020
-------------->

    <br>
    <br>
    <div class="tableborder" id="tablebordercolor">
        <br>
        <br>
        <h1 class="tableTitle">Your Orders</h1><br>
        <!--  Customer  Info Table -->
        <table  class="t02" cellspacing="0" cellpadding="0">
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
            <tr>
                <td><b>Recipient Phone:</b></td>
                <td><%= custObject.getCustPhone().replaceFirst("(\\d{3})(\\d{3})(\\d+)","($1) $2-$3") %></td> 
            </tr>
            <tr>
                <td><b>Recipient E-mail:</b></td>
                <td><%= custObject.getCustEmail() %></td> 
            </tr>
        </table> 
        <!--  End of Customer Info Table -->
  
        <!--  Order Table -->
        <table class="t01">
            <tr>
                <th class="th1">Order Number</th>
                <th class="th1">Product Name</th>
                <th class="th1">Product Size</th>
                <th class="th1">Product Gender</th>
                <th class="th1">Quantity</th>
                <th class="th1" style="width: 100px;">Price</th>
                <th class="th1" style="width: 100px;">Shipping Cost</th>
                <th class="th1" style="width: 100px;">Sales Tax</th>
                <th class="th1" style="width: 100px;">Total</th>
                <th class="th1">Order Status</th>
            </tr>
            <br />
            <br />
            <br />
  
        <!--     messages for null/empty data  -->
            <%  String errormessage = "N/A";
                String noDatamessage = "No Orders to View";
            %>
            <% 
                LoadProductTable LP1;
                LP1 = (LoadProductTable)session.getAttribute("allProducts");
    
                for ( int i = 0; i < custObject.orderList.numberOfOrders; i++ ){
                    String currentPnum = custObject.orderList.oArr.get(i).getProductNumber();
                    
                    
            %>
            <div>
                <tr style="width: 20%;">

                    <!----- checking for null data from DB for Only getOrderNumber,getProductNumber,getProductSize, & getProductGender  ----->
                    <!--    getOrderNumber-->
                    <% if (custObject.orderList.oArr.get(i).getOrderNumber()==null) { %>
                        <td class="td1"><%=errormessage%></td>
                    <% } else { %>
                        <td class="td1"><%=custObject.orderList.oArr.get(i).getOrderNumber()%></td>
                    <% } %>
                    <!--    getOrderNumber-->
                        <% 
                            for (Product product : LP1.productList.productList) {
                        if(product.getProductNumber().equals(currentPnum)){
                        
                        
                        %>
                    <!--    getProductName-->
                    <% if (product.getProductName()==null) { %>
                        <td class="td1"><%=errormessage%></td>
                    <% } else { %>
                        <td class="td1"><%=product.getProductName()%></td>
                    <% } %>
                    <!--    getProductName-->
   <% }
} %>
                    <!--    getProductSize-->
                    <% if (custObject.orderList.oArr.get(i).getProductSize()==null || custObject.orderList.oArr.get(i).getProductSize().equals(" ")||custObject.orderList.oArr.get(i).getProductSize().isEmpty() ) { %>
                        <td class="td1"><%=errormessage%></td>
                    <% } else { %>
                        <td class="td1"><%=custObject.orderList.oArr.get(i).getProductSize()%></td>
                    <% } %>
                    <!--    getProductSize-->
                    <!--    getProductGender-->
                    <% if (custObject.orderList.oArr.get(i).getProductGender()==null || custObject.orderList.oArr.get(i).getProductGender().equals(" ") || custObject.orderList.oArr.get(i).getProductGender().isEmpty()) { %>
                        <td class="td1"><%=errormessage%></td>
                    <% } else { %>
                        <td class="td1"><%=custObject.orderList.oArr.get(i).getProductGender()%></td>
                    <% } %>
                    <!--    getProductGender--> 

                    <td class="td1"><%=custObject.orderList.oArr.get(i).getQuantity()%></td>
                    <td class="td1"><%=String.format("$%-7.2f",custObject.orderList.oArr.get(i).getOrderAmount())%></td>
                    <td class="td1"><%=String.format("$%-7.2f",custObject.orderList.oArr.get(i).getOrderShippingCost())%></td>
                    <td class="td1"><%=String.format("$%-7.2f",custObject.orderList.oArr.get(i).getOrderSalesTax())%><br></td>
                    <td class="td1"><%=String.format("$%-7.2f",custObject.orderList.oArr.get(i).getOrderTotal())%></td>
                    <td class="td1"><%=custObject.orderList.oArr.get(i).getOrderStatus()%></td>
                </tr>
            </div>
            <%
                };          //end of for loop   
            %>
             <!--  End of Order Table -->


        </table>
        <!--     checks if the Order page has Data existing in DB for Customers orders-->
        <% if (custObject.orderList.oArr.isEmpty()) { %>
            <div style="padding: 10px; background-image: repeating-linear-gradient(-45deg,#DA6B2B 5%,black 11%); color: white;margin-bottom: 8px; text-align: center; font-size: 30px; "><i class="fas fa-exclamation-circle" ></i> <%=noDatamessage%> <i class="fas fa-exclamation-circle"></i></div>
        <% }  %>  
        <!------------>
        <br>
        <br>
        <br>
        <p style="text-align: center;">*O = Ordered *S = Shipped &nbsp;&nbsp;&nbsp;&nbsp;
        *M = Male *F = Female *K = Kid</p>
    </div>
    <br>
    <br>
    <br>
<!--END OF Order DATA CONTAINER-->

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

