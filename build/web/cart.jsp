<%-- 
* Class: CIST 2931 Advanced Systems Project
* Semester: Fall 2020
* Instructor: Ronald Enz
* Description: cart.jsp
* Due: 09.19.2020
* @authors Ian Mashburn
* @version 1.0
*
* By turning in this code, I Pledge:
* 1. That I have completed the programming assignment independently.
* 2. I have not copied the code from a student or any source.
* 3. I have not given my code to any student.
--%>
<%@page import="java.math.BigDecimal"%>
<%@page import="BusinessObjects.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<HTML lang="en">

<HEAD>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>
        Customer Cart || Please give us an A+
    </title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
</HEAD>

<BODY>
<!--START OF OBJECT LOAD FROM SESSION-->
<%
    System.out.println("***************** IN cart JSP *******************");

    //**************************************************************************
    // custObject: get session (contains orderList,cartList,paymentMethodList)
    //**************************************************************************                   
    Customer custObject;                    // Get custObject from session
    custObject = (Customer)session.getAttribute("custObject");

    //**************************************************************************
    // allProducts : session objects (contains all products)
    //**************************************************************************
    LoadProductTable LP1;
    LP1 = (LoadProductTable)session.getAttribute("allProducts");

    final double CONST_TAX_RATE = 0.06;

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
                    <a href="">
                    <img class="cartlogo" src="images/imagecart.png" width="35px" height="35">
                </a>
                <!-- BEGIN LOGIN or MYACCOUNT MENU ITEM -->
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

<!--START OF CART LIST CONTAINER-->
    <div class="mini-container cart-page">
        <table>
            <tr>
                <th>Product</th>
                <th>Gender</th>
                <th>Size</th>
                <th>Quantity</th>
                <th>Subtotal</th>
            </tr>

             <!---------------- BUILD DYNAMIC CART LIST -------------->
            <%  // ***** CALCULATE TOTALS *****
                BigDecimal cart_subtotal = new BigDecimal(0.0);
                BigDecimal tax_rate = new BigDecimal(CONST_TAX_RATE);
                BigDecimal cart_tax = new BigDecimal(0.0);
                BigDecimal cart_total = new BigDecimal(0.0);
            
                for ( int i = 0; i < custObject.cartList.numberOfProducts; i++ ){

                    String currentItem = custObject.cartList.cArr.get(i).getProductNumber();
                    for (Product product : LP1.productList.productList) {
                        if (product.getProductNumber().equals(currentItem)) {
            %>
                            <tr>
                                <td>
                                    <div class="cart-info">
                                        <img src='<%=product.getProductImagePath()%>'>
                                        <div>
                                            <p><%=product.getProductName()%></p>
                                            <small><%=custObject.cartList.cArr.get(i).getProductNumber()%></small>
                                            <br>
                                            <form name="RemoveFromCart" method="post" action="http://localhost:8080/TeamOneSports/CartServlet?cartaction=remove">
                                                <input type="hidden" id="currentproduct" name="currentproduct" value=<%=i%>>
                                                <button type="submit" value="Remove" onclick="removeFromCart(event)"/>
                                                    <i class="fas fa-trash"></i>
                                                </button>
                                                <span class="tooltiptext">remove</span>
                                                <style>
                                                    button[type="submit"]{
                                                        border: 1px solid #fff;
                                                        background: none;
                                                        color: #888;
                                                        padding: 3px;
                                                        font-size:17px;
                                                        cursor:pointer;
                                                    }
                                                    .tooltiptext {
                                                        visibility: hidden;
                                                        width: 55px;
                                                        background-color: black;
                                                        color: #fff;
                                                        text-align: center;
                                                        border-radius: 6px;
                                                        padding: 3px 0;
                                                        font-size: 13px;
                                                        position: absolute;
                                                        z-index: 1;
                                                    }
                                                    .cart-info:hover .tooltiptext {
                                                        visibility: visible;
                                                    }
                                                </style>
                                            </form>
                                        </div>
                                    </div>
                                </td>
                                <form id="formsubtotals<%=i%>" name="formsubtotals<%=i%>" method="post" action="http://localhost:8080/TeamOneSports/CartServlet?cartaction=updatecart">
                                    <input type="hidden" id="currentproduct" name="currentproduct" value=<%=i%>>
                                    
            <%                      // replace empty/null/spaced DB entries with the word Select 
                                    if ((custObject.cartList.cArr.get(i).getProductGender() == null) || (custObject.cartList.cArr.get(i).getProductGender() == " ") || (custObject.cartList.cArr.get(i).getProductGender().length() == 0)){
                                        custObject.cartList.cArr.get(i).setProductGender("Select");
                                    }
                                    if ((custObject.cartList.cArr.get(i).getProductSize() == null) || (custObject.cartList.cArr.get(i).getProductSize() == " ") || (custObject.cartList.cArr.get(i).getProductSize().length() == 0)){
                                        custObject.cartList.cArr.get(i).setProductSize("Select");
                                    }
                                                                        
                                    // Display Gender field if product has Gender Option
                                    if (product.getProductGender()){ %>
                                        <td>
                                            <select id="genderSelection" name="genderSelection" style="border: none" oninput="updateCart(<%=i%>)">
                                                <option><%=custObject.cartList.cArr.get(i).getProductGender()%></option>
                                                <option>F</option>
                                                <option>M</option>
                                                <option>Kid</option>
                                            </select>
                                        </td>   
            <%                      } else { 
                                        custObject.cartList.cArr.get(i).setProductGender(" ");%>
                                        <td><input type="text" style="border: none" value="N/A" readOnly=”true”/></td>
            <%                      } %>

            <%                      // Display Size field if product has Size Option
                                    if (product.getProductSize()){                                        
                                        // display SHOE sizes
                                        if (product.getProductSizeType().equals("shoe")) { %>
                                            <td>
                                                <select id="sizeSelection" name="sizeSelection" style="border: none" oninput="updateCart(<%=i%>)">
                                                    <option><%=custObject.cartList.cArr.get(i).getProductSize()%></option>
            <%                                      for ( double n = 4; n <= 12.5; n = n + 0.5){ %>
                                                        <option><%=n%></option>
            <%                                      } %>
            <%                                      for ( double n = 13; n <= 22; n++){ %>
                                                        <option><%=n%></option>
            <%                                      } %>        
                                                </select>                                                
                                            </td>
            <%                          // display GLOVE sizes
                                        } else if (product.getProductSizeType().equals("glove")) { %>
                                            <td>
                                                <select id="sizeSelection" name="sizeSelection" style="border: none" oninput="updateCart(<%=i%>)">
                                                    <option><%=custObject.cartList.cArr.get(i).getProductSize()%></option>
                                                    <option>XS</option>
                                                    <option>S</option>
                                                    <option>M</option>
                                                    <option>L</option>
                                                    <option>2XL</option>
                                                    <option>3XL</option>
                                                </select>                                                
                                            </td>                                        
            <%                          // display HEAD sizes
                                        } else if (product.getProductSizeType().equals("head")) { %>
                                            <td>
                                                <select id="sizeSelection" name="sizeSelection" style="border: none" oninput="updateCart(<%=i%>)">
                                                    <option><%=custObject.cartList.cArr.get(i).getProductSize()%></option>
                                                    <option>3XS</option>
                                                    <option>2XS</option>
                                                    <option>XS</option>
                                                    <option>S</option>
                                                    <option>M</option>
                                                    <option>L</option>
                                                    <option>XL</option>
                                                    <option>2XL</option>
                                                    <option>3XL</option>
                                                    <option>4XL</option>
                                                </select>                                                
                                            </td>                                          
            <%                          // display TOP sizes
                                        } else if (product.getProductSizeType().equals("top")) { %>
                                            <td>
                                                <select id="sizeSelection" name="sizeSelection" style="border: none" oninput="updateCart(<%=i%>)">
                                                    <option><%=custObject.cartList.cArr.get(i).getProductSize()%></option>
                                                    <option>2XS</option>
                                                    <option>XS</option>
                                                    <option>S</option>
                                                    <option>M</option>
                                                    <option>L</option>
                                                    <option>XL</option>
                                                    <option>2XL</option>
                                                    <option>3XL</option>
                                                    <option>4XL</option>
                                                    <option>5XL</option>
                                                </select>                                                
                                            </td>    
            <%                          // display BOTTOM sizes
                                        } else if (product.getProductSizeType().equals("bottom")) { %>
                                            <td>
                                                <select id="sizeSelection" name="sizeSelection" style="border: none" oninput="updateCart(<%=i%>)">
                                                    <option><%=custObject.cartList.cArr.get(i).getProductSize()%></option>
            <%                                      for ( int n = 20; n <= 60; n++){ %>
                                                        <option><%=n%>"w</option>
            <%                                      } %>
                                                </select>                                                
                                            </td>                              
            <%                          } %>                                        

            <%                      } else { 
                                        custObject.cartList.cArr.get(i).setProductSize(" ");%>
                                        <td><input type="text" style="border: none" value="N/A" readOnly=”true”/></td>
            <%                      } %>
                                        
                                    <!-- specific scroll button style for cart Quantity -->
                                    <style>
                                    input[type=number]::-webkit-inner-spin-button {
                                        opacity: 1
                                        }
                                    </style>
            <%
                                    out.println("<td><input id=\"cartquantity" + i + "\" onchange=\"updateCartQuantity(" + i + ")\" onkeydown=\"numonly(event)\" style=\"border: none\" type=\"number\" name=\"cartquantity[" + i + "]\" size=\"5\" min=\"1\" max=\"25\" value=\"" + custObject.cartList.cArr.get(i).getQuantity() + "\"/></td>");
                                    BigDecimal product_cost = new BigDecimal(product.getProductCost() * custObject.cartList.cArr.get(i).getQuantity());
            %>
                                    <input type="submit" style="visibility: hidden;" value="" readOnly=”true”/>
                                </form>
                                <td><input class=cart-totals id="producttotal" name="producttotal" type="text" style="border: none" value="<%='$' + String.format("%,.2f", product_cost)%>" readOnly=”true”</td>
                            </tr>                      
            <%                       
                            cart_subtotal = cart_subtotal.add(product_cost);
                        }
                    }
                }
            %>  <!------------ END DYNAMIC CART LIST ------------->           
        </table>
        
 <!-- BEGIN TOTALS ----------------------------------------------------------->
        <%
            if ((custObject.cartList.numberOfProducts) > 0){
                
                cart_tax = cart_subtotal.multiply(tax_rate);
                cart_total = cart_subtotal.add(cart_tax);
        %>
            <div class="total-price">
                <table>
                    <tr>
                        <td>Subtotal</td>
                        <td><%='$' + String.format("%,.2f", cart_subtotal)%></td>
                    </tr>
                    <tr>
                        <td>Tax</td>
                        <td><%='$' + String.format("%,.2f", cart_tax)%></td>
                    </tr>
                    <tr>
                        <td>Total</td>
                        <td><%='$' + String.format("%,.2f", cart_total)%></td>
                    </tr>
                    <tr>
                        <td>
                            <!-- START CHECKOUT BUTTON -->
                            <%  // if custObject.cartList has items, show checkout button
                                if ((custObject.cartList.numberOfProducts) > 0){ %>
                                    <button class="button" type="button" name="checkoutbtn" onclick="location.href='http://localhost:8080/TeamOneSports/checkout.jsp';" style="height:50px;width:200px">CHECKOUT</button>
                            <%  } %>
                            <!-- END CHECKOUT BUTTON -->                          
                        </td>
                    </tr>
                </table>
            </div>

        <%
            } else {
        %>
            <br>
            <div>
                NO PRODUCTS IN CART
            </div>
        <%
            }
        %>
    </div>
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
