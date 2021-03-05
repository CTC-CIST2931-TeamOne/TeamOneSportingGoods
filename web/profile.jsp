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
        View/Update Profile || Please give us an A+
    </title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
    <link rel="stylesheet" href="css/profileF.css">
    <script src="js/check_input.js"></script>
</HEAD>

<BODY>
<!--START OF OBJECT LOAD FROM SESSION-->
<%
    System.out.println("***************** IN profile JSP *******************");

    // custObject: set session (contains orderList,cartList,paymentMethodList)                     
    Customer custObject; 
    
    // init booleans for confirming update to profile and checkingout
    boolean updated = false;
    boolean pwmismatch = false;
    boolean checkingout = false;
    boolean nopaymentmethod = false;
    
    // Get custObject from session
    custObject = (Customer)session.getAttribute("custObject"); 
   
    int numberOfPaymentMethods = custObject.paymentMethodList.numberOfPaymentMethods;

    // Checks if checkingout has been made in session
    if(session.getAttribute("checkingout") != null){
        
        //sets checkingout boolean to true if checkingout
        checkingout =  Boolean.valueOf((String)session.getAttribute("checkingout"));
        
        //sets the session Variable back to false
        //session.setAttribute("checkingout", "false");
    }
    
    // Checks if update has been made in session
    if(session.getAttribute("updated") != null){
    
        //sets update boolean to true if update has been made
        updated = Boolean.valueOf((String)session.getAttribute("updated"));

        //sets the session Variable back to false
        session.setAttribute("updated", "false");
    }

    // Checks if pwmismatch has been made in session
    if(session.getAttribute("pwmismatch") != null){
    
        //sets pwmismatch boolean to true if pwmismatch has been made
        pwmismatch = Boolean.valueOf((String)session.getAttribute("pwmismatch"));

        //sets the session Variable back to false
        session.setAttribute("pwmismatch", "false");
    }

    // Checks if nopaymentmethod has been made in session
    if(session.getAttribute("nopaymentmethod") != null){
    
        //sets nopaymentmethod boolean to true if nopaymentmethod has been made
        nopaymentmethod = Boolean.valueOf((String)session.getAttribute("nopaymentmethod"));

        //sets the session Variable back to false
        session.setAttribute("nopaymentmethod", "false");
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

<!--START OF PROFILE DATA CONTAINER-->
<%  if(updated == true){%>
    <div class="alert success">
        <span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span>
        Customer Profile Updated.
    </div>
<% }%>          

<% if(pwmismatch == true){%>
    <div class="alert failed">
        <span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span>
        Password and Confirm Password Must Match for Password Changes.
    </div>
<%}%>

<% if(nopaymentmethod == true){%>
    <div class="alert failed">
        <span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span>
        Must select a Payment Method to edit.
    </div>
<%}%>

<%  // if not checkingout, display ID and Password form
    if (!(checkingout)){
%>
<!--------------------------- Login Form *Updated By. Hunter Browder(10/5/2020) *Updated By. Patricia Rivera(11/3/2020) --------------------------->
        <div class="row row2">
            <form method="post" class="login" id="profileForm" action="http://localhost:8080/TeamOneSports/ProfileServlet">
                <fieldSet id="profileField">
                <legend><h2>Login</h2></legend>
                    <div class="row center">
                        <div class ="center">
                            <label  for="login">Username</label>
                        </div>
                    </div>     

                    <div class="row center"> 
                        <div class ="center">
                            <input type="text" class="profile"  onkeydown="noenterorspace(event)" name="user" id="user" placeholder="Login.."  required value = <%= custObject.getCustLoginID().trim()%>>
                        </div>
                    </div>     

                    <div class="row center">
                       <div class ="center">
                            <label  for="pass">Password</label>
                        </div>         
                    </div>    

                    <div class="row center"> 
                        <div class ="center">
                            <input type="text" class="profile" onkeydown="noenterorspace(event)" name="pass" id="pass" placeholder="password.."  required value = <%= custObject.getCustPassword().trim() %>>
                        </div>
                    </div>     

                    <div class="row center"> 
                        <div class ="center">
                            <label  for="confirmPass">Confirm Password</label>
                        </div>
                    </div>     
                    <div class="row center"> 
                        <div class ="center">
                            <input type="text" class="profile" onkeydown="noenterorspace(event)" name="confirmPass" id="confirmPass" placeholder="Confirm Password.."  required value = <%= custObject.getCustPassword() %>>
                        </div>
                    </div>     

                    <div class="row">    
                        <input class ="save" type="submit" onclick="confirmUpdate(event)" name="submit" value="Update">     
                    </div>           
                </fieldset>            
            </form>                 
        </div>
<!-- End of login form -->      
<%
    }
%>
<!--------------------------- Payment Form --------------------------->
        <div class="row row2">
            <form method="post"  id="profileForm" action="http://localhost:8080/TeamOneSports/payment.jsp">
            <fieldSet id="profileField">
                <legend><h2>Billing Information</h2></legend>

                <table class = "payment">

                    <tr class="border">

                        <th id="emptyBorderBottomRight"></th>
                        <th id="emptyBorderleft" class = "alignLeft">Card Ending in</th>
                        <th class="border alignCenter">Name on Card</th>
                        <th class="border">Date</th>

                    </tr>

                    <!-- Retrieve  and display all payment methods -->
                    <%for(int i = 0; i < numberOfPaymentMethods; i++){ 

                       String cardNumber = custObject.paymentMethodList.pmArr.get(i).getCardNumber();         
                       String date = custObject.paymentMethodList.pmArr.get(i).getCardExpDate();
                       String firstName = custObject.paymentMethodList.pmArr.get(i).getBillFirstName();
                       String lastName = custObject.paymentMethodList.pmArr.get(i).getBillLastName();
                       String fullName = firstName + " " + lastName;
                       String endingIn = "************" + cardNumber.substring(12);
                    %>
                     <tr>

                        <td id="emptyBorderTopRight"><input type="radio" id="PayementRadio" name="paymentMethod" value="<%= i %>"></td>
                        <td id="emptyBorderLeft"><%= endingIn%></td>
                        <td class="border"><%= fullName%></td>
                        <td class="border"><%= date%></td>

                    </tr>

                    <%} %> 

                </table>

                <div class="row">


                    <div class="left" > 

                        <input class ="save" type="submit" name = "submit" value="Add">


                    </div>

                    <div class="right" > 
                        <input class ="save" type="submit" name = "submit" value="Edit">
                    </div>

                </div>  
            </fieldset>             
            </form>   
        </div>
<!-- End of Payment Form --> 
<!--------------------------- Profile Form --------------------------->              
        <div class="row row2">
            <form method="post"  id="shippingForm" name="shippingForm" action="http://localhost:8080/TeamOneSports/ProfileServlet">
                <fieldSet id="profileField">
                    <legend><h2>Shipping Information</h2></legend>

                    <div class="formInput">

                        <div class="row">

                            <div class ="col-25"> 
                                <label  for="fname"> First Name </label>
                            </div>
                            <div class ="col-25"> 
                                <input type="text" class="profile" onkeydown="noenterorspace(event)" id="fname" name="firstName" placeholder="First Name.." required value = "<%= custObject.getCustFirstName().trim()%>">
                            </div>

                             <div class ="col-5  middle"> 
                                <label for="mname"> Middle Initial </label>
                            </div>
                            <div class ="col-5"> 
                                <input type="text" class="profile" onkeydown="noenterorspace(event)" pattern="[A-Za-z]{1}" title="Only put your first letter." id="mname" maxlength="1" size="4" name="midInitial" placeholder="" value = "<%= custObject.getCustMidInitial().trim()%>">
                            </div>

                            <div class ="col-10"> 
                                <label for="lname"> Last Name </label>
                            </div>
                            <div class ="col-20"> 
                                <input type="text" class="profile" onkeydown="noenterorspace(event)" id="lname" name="lastName" placeholder="Last Name.."  required value = "<%= custObject.getCustLastName().trim()%>">
                            </div>

                        </div>


                        <div class="row">
                            <div class ="col-25"> 
                                <label for="addres1"> Address 1 </label>
                            </div>

                            <input type="text" class="profile" onkeydown="noenter(event)" id="address1" name="address1" placeholder="Address 1.." required value = "<%= custObject.getCustAddrLine1().trim()%>">
                        </div>



                        <div class="row">

                            <div class ="col-25"> 
                                <label for="addres2"> Address 2 </label>
                            </div>

                            <input type="text" class="profile" onkeydown="noenter(event)" id="address2" name="address2" placeholder="Address 2.." value = "<%= custObject.getCustAddrLine2().trim()%>">                                   

                        </div>
                        <div class="row">

                            <div class ="col-25"> 
                                <label  for="city"> City </label>
                            </div>

                            <input type="text" class="profile" onkeydown="noenterorspace(event)" id="city" name="city" placeholder="City.." required value = "<%= custObject.getCustCity().trim()%>">

                             <div class ="col-5  middle"> 
                                <label for="state"> State </label>
                            </div>

                            <div class ="col-5"> 
                                <input type="text" class="profile" onkeydown="noenterorspace(event)" id="state" maxlength="2" size="4" pattern="[a-zA-Z]{2}" title="Only put State Abbrev." name="state" placeholder="" required value = "<%= custObject.getCustState().trim()%>">
                            </div>

                            <div class ="col-10 right"> 
                                <label for="zip"> Zip Code </label>
                            </div>
                            <div class ="col-20"> 
                                <input type="text" class="profile" onkeydown="noenterorspace(event)" id="zip" maxlength="5" name="zip" pattern="\d{5}([\-]\d{4})?" title="The zip has to be 5 numbers" placeholder="Zip.."  required value = "<%= custObject.getCustZip().trim()%>">
                            </div>

                        </div>

                        <div class="row">

                            <div class ="col-25"> 
                                <label for="phone"> Phone </label>
                            </div>

                            <input type="text" class="profile" onkeydown="noenterorspace(event)" id="phone" name="phone" placeholder="Phone.." title="Please Input your Phone Number" pattern="[0-9]{10}$" oninvalid="phoneInvalid()" onchange="changePhoneNum('phone')" required value = "<%= custObject.getCustPhone().trim()%>">                                   

                        </div> 

                        <div class="row">

                            <div class ="col-25"> 
                                <label for="email"> Email </label>
                            </div>

                            <input type="text" class="profile" onkeydown="noenterorspace(event)" id="email" name="email" title="Please input a proper email" pattern="[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-z]{2,3}$" placeholder="Email.." required value = "<%= custObject.getCustEmail().trim()%>">                                   

                        </div> 

                        <div class="row right">

                            <div class="right" >
                                <input class ="save" type="reset" value="Reset">
                            <%  // if not checkingout, display ID and Password form
                                if (checkingout){
                            %>
                                <input class ="save" id="submit" type="submit" onclick="chkProfileInfo(event)"name="submit" value="Continue to Checkout" > 
                            <%  } else {  %>
                                <input class ="save" id="submit" type="submit" onclick="confirmUpdate(event)" name="submit" value="Save">
                            <%  }   %>
                            </div>

                        </div>    
                    </div>
                </fieldset>
            </form>              
            
         </div>
<!-- End of profile Form --> 

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

