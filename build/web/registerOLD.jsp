<%-- 
    Document   : register.jsp
    Created on : Sep 15, 2020, 4:51:42 PM
    Author     : Patricia A. Rivera, Wes Plyler
--%>
<%@page import="BusinessObjects.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
<!--<meta name="viewport" content="width=device-width, initial-scale=1.0">-->
    <title>
        Registration || Please give us an A+
    </title>
    <link rel="stylesheet" href="css/register_style.css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
</head>

<body>
        
    <!--START OF INITIALIZE SESSION OBJECTS-->
    
    <%
        System.out.println("**************** IN register.jsp ****************");
        
        boolean usernameExists = false;
    
        // Checks if checkingout has been made in session
        if(session.getAttribute("checkingout") != null){

            //sets the session Variable back to false
            session.setAttribute("checkingout", "false");
        }

        // Checks if usernameExists has been made in session
        if(session.getAttribute("usernameExists") != null){

            //get the usernameExists session Variable
            usernameExists =  Boolean.valueOf((String)session.getAttribute("usernameExists"));
            //sets the session Variable back to false
            session.setAttribute("usernameExists", "false");
        }
        
        // custObject: set session (contains orderList,cartList,paymentMethodList)                     
        Customer custObject; 

        // Checks if usernameExists has been made in session
        if(session.getAttribute("tempCustObject") != null){
            custObject = (Customer)session.getAttribute("tempCustObject");
        } else {
            custObject = (Customer)session.getAttribute("custObject");
        }
    %>
    
    <!--END OF OF INITIALIZE SESSION OBJECTS-->
    
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
                <button id="login_btn" class="log_btn">
                    Login
                </button>
                <a href="index.jsp">Home</a>
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
                        <input class="margin box" type=text onkeydown="nospace(event)" placeholder="Username" name="user" id="user" />
                        <br />
                        <input class="margin box" onkeydown="nospace(event)" type=text placeholder="Password" name="pass" id="pass" />
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

    <!--START OF REGISTER INFORMATION-->
<%  if (usernameExists){ %>
        <script type="text/javascript"> alert("Username Exists. Create another.")</script>
        <div class="info">
            <h1>Register</h1>
            <br />      
            <form name="RegisterForm" method="post" id="RegisterForm" action="http://localhost:8080/TeamOneSports/RegisterServlet" autocomplete="on">            
                <!-- CUSTLOGINID -->
                <input class="input" type="text" maxlength="30" placeholder="Username" pattern="^[A-Za-z0-9]*$" name="loginID" id="loginID" autocomplete="off" required autofocus/>

                <br />

                <!-- CUSTPASSWORD -->
                <input class="input" onkeydown="keyDown(event)" type="text" maxlength="20" pattern="^[A-Za-z0-9]*$" placeholder="Password" name="pass" id="pass" autocomplete="off" required/>

                <br />

                <!-- CUSTFIRSTNAME -->
                <input class="input" onkeydown="keyDown(event)" type="text" maxlength="30" pattern="^[A-Za-z]*$" value="<%=custObject.getCustFirstName()%>" name="fname" id="fname" required/>

                <br />

                <!-- CUSTMIDINITIAL -->
                <input class="input" onkeydown="keyDown(event)" type="text" maxlength="1" pattern="^[A-Za-z]{1}*$" value="<%=custObject.getCustMidInitial()%>" name="midinitial" id="midinitial"/>

                <br />

                <!-- CUSTLASTNAME -->
                <input class="input" onkeydown="keyDown(event)" type="text" maxlength="30" pattern="^[A-Za-z]*$" value="<%=custObject.getCustLastName()%>" name="lname" id="lname" required/>

                <br />

                <!-- CUSTADDRLINE1 -->
                <input class="input" type="text" maxlength="30" value="<%=custObject.getCustAddrLine1()%>" name="address1" id="address1" required/>

                <br />

                <!-- CUSTADDRLINE2 -->
                <!-- This can be empty (Not everyone has a 2nd address -->
                <input class="input" type="text" maxlength="30" value="<%=custObject.getCustAddrLine2()%>" name="address2" id="address2" />

                <br />

                <!-- CUSTCITY -->
                <input class="input" type="text" maxlength="30" value="<%=custObject.getCustCity()%>" name="city" id="city" pattern="^[A-Za-z ]*$" required/>

                <br />

                <!-- CUSTSTATE -->
                <input class="input" onkeydown="keyDown(event)" type="text" maxlength="2" pattern="[A-Za-z]{2}" value="<%=custObject.getCustState()%>" name="state" id="state" required/>

                <br />

                <!-- CUSTZIP -->
                <input class="input" onkeydown="keyDown(event)" type="text" maxlength="5" pattern="[0-9]{5}" value="<%=custObject.getCustZip()%>" name="zip" id="zip" required/>

                <br />

                <!-- CUSTPHONE -->
                <input class="input" onkeydown="keyDown(event)" type="text" maxlength="14" value="<%=custObject.getCustPhone()%>" pattern="[0-9]{10}$" onchange="changePhoneNum()" name="phoneNum" id="phoneNum" required/>

                <br />

                <!-- CUSTEMAIL -->
                <input class="input" onkeydown="keyDown(event)" type="email" maxlength="30" pattern="[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-z]{2,3}$" value="<%=custObject.getCustEmail()%>" name="email" id="email" required/>

                <br />

                <input class="btn" type="submit" value="Register" onclick="registerCheck()" />
            </form>
        </div>
<%  } else { %>
        <div class="info">
            <h1>Register</h1>
            <br />      
            <form name="RegisterForm" method="post" id="RegisterForm" action="http://localhost:8080/TeamOneSports/RegisterServlet" autocomplete="on">            
                <!-- CUSTLOGINID -->
                <input class="input" type="text" maxlength="30" placeholder="Username" pattern="^[A-Za-z0-9]*$" name="loginID" id="loginID" autocomplete="off" required/>

                <br />

                <!-- CUSTPASSWORD -->
                <input class="input" onkeydown="keyDown(event)" type="text" maxlength="20" pattern="^[A-Za-z0-9]*$" placeholder="Password" name="pass" id="pass" autocomplete="off" required/>

                <br />

                <!-- CUSTFIRSTNAME -->
                <input class="input" onkeydown="keyDown(event)" type="text" maxlength="30" pattern="^[A-Za-z]*$" placeholder="First Name" name="fname" id="fname" required/>

                <br />

                <!-- CUSTMIDINITIAL -->
                <input class="input" onkeydown="keyDown(event)" type="text" maxlength="1" attern="^[A-Za-z]{1}*$" placeholder="Middle Initial" name="midinitial" id="midinitial"/>

                <br />

                <!-- CUSTLASTNAME -->
                <input class="input" onkeydown="keyDown(event)" type="text" maxlength="30" pattern="^[A-Za-z]*$" placeholder="Last Name" name="lname" id="lname" required/>

                <br />

                <!-- CUSTADDRLINE1 -->
                <input class="input" type="text" maxlength="30" placeholder="Address 1" name="address1" id="address1" required/>

                <br />

                <!-- CUSTADDRLINE2 -->
                <!-- This can be empty (Not everyone has a 2nd address -->
                <input class="input" type="text" maxlength="30" placeholder="Address 2" name="address2" id="address2" />

                <br />

                <!-- CUSTCITY -->
                <input class="input" type="text" maxlength="30" placeholder="City" name="city" id="city" pattern="^[A-Za-z ]*$" required/>

                <br />

                <!-- CUSTSTATE -->
                <input class="input" onkeydown="keyDown(event)" type="text" maxlength="2" pattern="[A-Za-z]{2}" placeholder="State" name="state" id="state" required/>

                <br />

                <!-- CUSTZIP -->
                <input class="input" onkeydown="keyDown(event)" type="text" maxlength="5" pattern="[0-9]{5}" placeholder="Zip Code" name="zip" id="zip" required/>

                <br />

                <!-- CUSTPHONE -->
                <input class="input" onkeydown="keyDown(event)" type="text" maxlength="14" placeholder="Phone Number" pattern="[0-9]{10}$" onchange="changePhoneNum()" name="phoneNum" id="phoneNum" required/>

                <br />

                <!-- CUSTEMAIL -->
                <input class="input" onkeydown="keyDown(event)" type="email" maxlength="30" pattern="[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-z]{2,3}$" placeholder="Email" name="email" id="email" required/>

                <br />

                <input class="btn" type="submit" value="Register" onclick="registerCheck()" />
            </form>
        </div>
<%  } %>
    <!-- Get Script -->
    <script src="js/check_input.js"></script>

    <!--END OF REGISTER INFORMATION-->

    <!--START OF PAGE FOOTER-->
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
</body>