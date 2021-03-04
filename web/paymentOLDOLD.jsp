<%-- 
* Class: CIST 2931 Advanced Systems Project
* Semester: Fall 2020
* Instructor: Ronald Enz
* Description: profile.jsp
* Due: 09.19.2020
* @authors Ian Mashburn, Hunter Browder 
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
        Add/Update Payment || Please give us an A+
    </title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
    <link rel="stylesheet" href="css/payment.css">
</HEAD>

<BODY>
<!--START OF OBJECT LOAD FROM SESSION-->
<%
    System.out.println("***************** IN profile JSP *******************");

    // custObject: set session (contains orderList,cartList,paymentMethodList)                     
    Customer custObject; 
    
  
    // Get custObject from session
    custObject = (Customer)session.getAttribute("custObject"); 

    // Checks if checkingout has been made in session
    if(session.getAttribute("checkingout") != null){
        
        //sets the session Variable back to false
        //session.setAttribute("checkingout", "false");
    }
    
    //Checks if Customer is Editing Payment option
    System.out.println(request.getParameter("paymentMethod"));
    System.out.println(request.getParameter("submit"));

    String nopaymentmethod = "";
    //test for no payment method selected.. send back to profile.jsp 
    if ((!(request.getParameter("submit").equals("Add"))) && (request.getParameter("paymentMethod") == null)) {
        nopaymentmethod = "true";
        session.setAttribute("nopaymentmethod", nopaymentmethod);
        response.sendRedirect("http://localhost:8080/TeamOneSports/profile.jsp");        
    } else {
        nopaymentmethod = "false";
        session.setAttribute("nopaymentmethod", nopaymentmethod);        
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
                        <input class="margin box" type=text placeholder="Username" name="user" id="user" />
                        <br />
                        <input class="margin box" onKeyDown="javascript: var keycode = keyPressed(event); if(keycode===32){ return false; }" type=text placeholder="Password" name="pass" id="pass" />
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

<!--START OF Payment DATA CONTAINER-->
       
        <div class="row row2">

            <div class="left" > 

                 <a href="profile.jsp"><button class ="save"> Back</button></a>       

            </div>
            
            <form method="post"  id="paymentForm" action="http://localhost:8080/TeamOneSports/PaymentServlet">
            <fieldSet id="paymentField">
                <legend><h2>Payment</h2></legend>
                
                <!--Presents Current Payment method if Customer has clicked edit button-->
                <%if(request.getParameter("submit").equals("Edit") && request.getParameter("paymentMethod") != null){
                    
                    
                    System.out.println(request.getParameter("paymentMethod"));
                    
                    int payMethod = Integer.parseInt(request.getParameter("paymentMethod"));
                    
                    String firstName = custObject.paymentMethodList.pmArr.get(payMethod).getBillFirstName();
                    String midInitial = custObject.paymentMethodList.pmArr.get(payMethod).getBillMidInitial();
                    String lastName = custObject.paymentMethodList.pmArr.get(payMethod).getBillLastName();
                    String cardNumber = custObject.paymentMethodList.pmArr.get(payMethod).getCardNumber();
                    String cvv = custObject.paymentMethodList.pmArr.get(payMethod).getCardCVV();
                    String expDate = custObject.paymentMethodList.pmArr.get(payMethod).getCardExpDate();
                    String cardType = custObject.paymentMethodList.pmArr.get(payMethod).getCardType();
                    String billAddress1 = custObject.paymentMethodList.pmArr.get(payMethod).getBillAddrLine1();
                    String billAddress2 = custObject.paymentMethodList.pmArr.get(payMethod).getBillAddrLine2();
                    String city = custObject.paymentMethodList.pmArr.get(payMethod).getBillCity();
                    String state = custObject.paymentMethodList.pmArr.get(payMethod).getBillState();
                    String zip = custObject.paymentMethodList.pmArr.get(payMethod).getBillZip();
                    String phone = custObject.paymentMethodList.pmArr.get(payMethod).getBillPhone();
                    String email = custObject.paymentMethodList.pmArr.get(payMethod).getBillEmail();
                    
                    
                    
                %>
  
                <div class="formInput">
                       
                       
                <div class="row">
                    
                    <input type="hidden" name="payMethod" value = "<%= payMethod %>" >
                    
                    <div class ="col-25"> 
                        <label  for="cardNumber">Card Number</label>
                    </div>
                    <div class ="col-25"> 
                        <input type="text" class="profile" id="cardNumber" name="cardNumber" placeholder="Card Number.."  required value = "<%= cardNumber %>" >
                    </div>
                    
                     <div class ="col-5  middle"> 
                        <label for="cvv">CVV</label>
                    </div>
                    <div class ="col-10"> 
                        <input type="text" class="profile" id="cvv" maxlength="3" size="3"  name="cvv" placeholder="CVV" required value = "<%= cvv %>">
                    </div>
                    
                    <div class ="col-10"> 
                        <label for="expDate">Expiration</label>
                    </div>
                    <div class ="col-20"> 
                        <input type="text" class="profile"  id="expDate" name="expDate"  size="4" placeholder="Date.."  required value = "<%= expDate%>">
                    </div>
                                        
                </div>
                <div class="row">
                    <div class ="col-25"> 
                        <label  for="fname"> First Name </label>
                    </div>
                    <div class ="col-25"> 
                        <input type="text" class="profile" id="fname" name="firstName" placeholder="First Name.."  required value = "<%= firstName %>">
                    </div>
                    
                     <div class ="col-5  middle"> 
                        <label for="mname"> Middle Initial </label>
                    </div>
                    <div class ="col-10"> 
                        <input type="text" class="profile" id="mname" maxlength="1" size="4" name="midInitial" placeholder="" value = "<%= midInitial %>">
                    </div>
                    
                    <div class ="col-10 right"> 
                        <label for="lname"> Last Name </label>
                    </div>
                    <div class ="col-20"> 
                        <input type="text" class="profile"  id="lname" name="lastName" placeholder="Last Name.."  required value = "<%= lastName%>">
                    </div>
                                        
                </div>
                
                
                   <div class="row">
                    <div class ="col-25"> 
                        <label for="cardType">Card Type </label>
                    </div>
                     
                        <input type="text" class="profile" id="cardType" name="cardType" placeholder="Card Type.." required value = "<%= cardType %>">
                   </div>
                   
                
                        
                <div class="row">
                    
                    <div class ="col-25"> 
                        <label for="address"> Billing Address</label>
                    </div>
                    <div class ="col-75">                      
                        <input type="text" class="profile" id="address" name="address" placeholder="Biiling address.." required value = "<%= billAddress1%>">                                   
                    </div>
                </div>
                <div class="row">
                    
                    <div class ="col-25"> 
                        <label for="address2"> Billing Address 2</label>
                    </div>
                    <div class ="col-75">                      
                        <input type="text" class="profile" id="address2" name="address2" placeholder="Biiling address 2.." value = "<%= billAddress2 %>">                                   
                    </div>
                </div>    
                <div class="row">
                    <div class ="col-25"> 
                        <label  for="city"> City </label>
                    </div>
                    <div class ="col-25"> 
                        <input type="text" class="profile" id="city" name="city" placeholder="City.." required value = "<%= city %>">
                    </div>
                    
                     <div class ="col-5  middle2"> 
                        <label for="state"> State </label>
                    </div>
                    <div class ="col-10 left"> 
                        <input type="text" class="profile" id="state" maxlength="2" size="2" name="state" placeholder="" required value = "<%= state%>">
                    </div>
                    
                    
                    <div class ="col-10 right "> 
                        <label for="zip"> Zip Code </label>
                    </div>
                    <div class ="col-20"> 
                        <input type="text" class="profile"  id="zip" name="zip" placeholder="Zip.."  size="5" required value = "<%= zip%>">
                    </div>
                          
                </div>
                <div class="row">
                    
                    <div class ="col-25"> 
                        <label for="phone"> Phone </label>
                    </div>
                    <div class ="col-75">                      
                        <input type="text" class="profile" id="phone" name="phone" placeholder="Phone.." required value = "<%= phone %>">                                   
                    </div>
                </div> 
                <div class="row">
                    
                    <div class ="col-25"> 
                        <label for="email"> Email </label>
                    </div>
                    <div class ="col-75">                      
                        <input type="text" class="profile" id="email" name="email" placeholder="Email.." required value = "<%= email%>">                                   
                    </div>
                </div> 
                    
                    
                    <div class="left" > 
                        
                        <input class ="save" type="submit" name = "submit" value="Delete">
                            
                      
                    </div>
                        
                    
                    <div class="right" > 
                        <input class ="save" type="submit" name="submit" value="Save">
                    </div>

                </div>    
                    
                    
                </div>
                    
                    
                <%}else{%>
                <div class="formInput">
                       
                <div class="row">
                    <div class ="col-25"> 
                        <label  for="cardNumber">Card Number</label>
                    </div>
                    <div class ="col-25"> 
                        <input type="text" class="profile" id="cardNumber" name="cardNumber" placeholder="Card Number.."  required>
                    </div>
                    
                     <div class ="col-5  middle"> 
                        <label for="cvv">CVV</label>
                    </div>
                    <div class ="col-10"> 
                        <input type="text" class="profile" id="cvv" maxlength="3" minlength="3" size="3"  name="cvv" placeholder="CVV" required>
                    </div>
                    
                    <div class ="col-10"> 
                        <label for="expDate">Expiration</label>
                    </div>
                    <div class ="col-20"> 
                        <input type="text" class="profile"  id="expDate" name="expDate"  size="4" placeholder="Date.."  required>
                    </div>
                                        
                </div>
                
                
                   <div class="row">
                    <div class ="col-25"> 
                        <label for="cardType">Card Type </label>
                    </div>
                     
                        <input type="text" class="profile" id="cardType" name="cardType" placeholder="Card Type.." required>
                   </div>
                    
                   <div class="row">
                    <div class ="col-25"> 
                        <label  for="fname"> First Name </label>
                    </div>
                    <div class ="col-25"> 
                        <input type="text" class="profile" id="fname" name="firstName" placeholder="First Name.."  required value = <%= custObject.getCustFirstName()%>>
                    </div>
                    
                     <div class ="col-5  middle"> 
                        <label for="mname"> Middle Initial </label>
                    </div>
                    <div class ="col-10"> 
                        <input type="text" class="profile" id="mname" maxlength="1" size="4" name="midInitial" placeholder="" value = "<%= custObject.getCustMidInitial()%>">
                    </div>
                    
                    <div class ="col-10 right"> 
                        <label for="lname"> Last Name </label>
                    </div>
                    <div class ="col-20"> 
                        <input type="text" class="profile"  id="lname" name="lastName" placeholder="Last Name.."  required value = "<%= custObject.getCustLastName()%>">
                    </div>
                                        
                </div> 
                   
                
                        
                <div class="row">
                    
                    <div class ="col-25"> 
                        <label for="address"> Billing Address</label>
                    </div>
                    <div class ="col-75">                      
                        <input type="text" class="profile" id="address" name="address" placeholder="Biiling address.." required>                                   
                    </div>
                </div>
                <div class="row">
                    
                    <div class ="col-25"> 
                        <label for="address2"> Billing Address 2</label>
                    </div>
                    <div class ="col-75">                      
                        <input type="text" class="profile" id="address2" name="address2" placeholder="Biiling address 2..">                                   
                    </div>
                </div>    
                <div class="row">
                    <div class ="col-25"> 
                        <label  for="city"> City </label>
                    </div>
                    <div class ="col-25"> 
                        <input type="text" class="profile" id="city" name="city" placeholder="City.." required>
                    </div>
                    
                     <div class ="col-5  middle2"> 
                        <label for="state"> State </label>
                    </div>
                    <div class ="col-10 left"> 
                        <input type="text" class="profile" id="state" maxlength="2" size="2" name="state" placeholder="" required>
                    </div>
                    
                    
                    <div class ="col-10 right "> 
                        <label for="zip"> Zip Code </label>
                    </div>
                    <div class ="col-20"> 
                        <input type="text" class="profile"  id="zip" name="zip" placeholder="Zip.."  size="5" required>
                    </div>
                          
                </div>
                <div class="row">
                    
                    <div class ="col-25"> 
                        <label for="phone"> Phone </label>
                    </div>
                    <div class ="col-75">                      
                        <input type="text" class="profile" id="phone" name="phone" placeholder="Phone.." required>                                   
                    </div>
                </div> 
                <div class="row">
                    
                    <div class ="col-25"> 
                        <label for="email"> Email </label>
                    </div>
                    <div class ="col-75">                      
                        <input type="text" class="profile" id="email" name="email" placeholder="Email.." required>                                   
                    </div>
                </div> 
                    
                    <div class="row right">
                        
                       
                    
                    <div class="right" > 
                        <input class ="save" type="submit" name="submit" value="Add">
                    </div>
                   
                </div>    
                    
                    
                </div>
                 <%}%>   
            </fieldset>
            
            </form>    
            
         
            
            
        
            
    </div>
                   
 
<!--END OF PROFILE DATA CONTAINER-->

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

