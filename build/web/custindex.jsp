<%-- 
* Class: CIST 2931 Advanced Systems Project
* Semester: Fall 2020
* Instructor: Ronald Enz
* Description: custindex.jsp
* Due: 09.09.2020
* @authors Nathaene Mahire, Edrey Torres-Salas, Patricia Rivera, Ian Mashburn
* @version 1.0
*
* By turning in this code, I Pledge:
* 1. That I have completed the programming assignment independently.
* 2. I have not copied the code from a student or any source.
* 3. I have not given my code to any student.
--%>
<%@page import="BusinessObjects.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<HTML lang="en">

<HEAD>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>
        TeamOne Sporting Goods || Please give us an A+
    </title>
    <link rel="stylesheet" href="css/cust_style.css">
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
</HEAD>

<!--START OF SESSION OBJECT GRAB-->
<%  
    System.out.println("****************** IN custindex JSP *****************"); 
    
    //**************************************************************************
    // custObject: set session (contains orderList,cartList,paymentMethodList)
    //**************************************************************************                     
    Customer custObject;            // Get custObject from session
    custObject = (Customer)session.getAttribute("custObject");
    
    //TESTING
    custObject.show();
    
    // Checks if checkingout has been made in session
    if(session.getAttribute("checkingout") != null){
        
        //sets the session Variable back to false
        session.setAttribute("checkingout", "false");
    }
%>
<!--END OF OF SESSION OBJECT GRAB-->

<BODY>
    <div class="header">
<!---------------------- The Navbar/Searchbar -------------------------------->
        <div class="navbar">
            <div class="logo">
                <a href="custindex.jsp">	
                    <img src="images/logo.png" width="160px">
                </a>
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
                <div class="dropdown">
                    <button class="dropbtn" id="user" onclick="myFunction(this);"><%=custObject.getCustLoginID()%>
                        <i class="fa fa-caret-down"></i>
                    </button>
                    <div class="dropdown-content" id="myDropdown">
                        <a href="profile.jsp">View/Update Profile</a>
                        <a href="vieworders.jsp">View Orders</a>
                        <a href="LogoutServlet">Logout</a>
                    </div>
                </div>
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
                <a href="ProductsServlet">Products</a>
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
                </div>
                <script src="js/check_input.js"></script>
            </div>
        </div>
    </div>
<!---------------------- The Banner ------------------------------------------->
    <div class="top_banner">
        <div class="left_banner">
            <a href="products.jsp">
                $1 SHIPPING ON All ITEMS STORE WIDE!
            </a>
            <p>
                Don't let high shipping costs stop you! 
                <span style="color: #00BFFF">#Death2Amazon</span> 
            </p>
        </div>
        <div class="middle_banner">
            <p>
                |
            <p>
        </div>
        <div class="right_banner">
            <a href="CovidFAQ.jsp">
                CHECK OUR NEW COVID-19 HOURS
            </a>
            <p>
                Click here or the Covid FAQ at the bottom of this page
            </p>
        </div>
    </div>
    <!---------------------- The Carousel ------------------------------------------->
    <div class="header">
        <div class="container">
            <div class="row">
            <!-- looping add on the top of page
                <div align="center">
                        <marquee  bgcolor="#D58659" direction="left" height:="" 
                        loop="infinite" scrollamount="3" scrolldelay="2" width="100%">
                        <span style="font-size: 20px;color:#FFFFFF">
                        New Stock Every Day! Make Sure to Check Back in Daily to
                        See our Ever Increasing Inventory of High End Gear!</span></marquee>
                </div>-->
                <center class="image-slider">
                    <div class="slider-container">
                        <div class="c_image">
                            <img class="image" src="carousel_images/sports.png" alt="" onclick='window.open("#","_top")'>
                        </div>
                        
                        <div class="c_image">
                            <img class="image"  src="carousel_images/soccer.png" alt="" onclick='window.open("#","_top")'>
                        </div>
                        
                        <div class="c_image">
                            <img class="image"  src="carousel_images/baseball.png" alt="" onclick='window.open("#","_top")'>
                        </div>
                        
                        <div class="c_image">
                            <img class="image"  src="carousel_images/basketball.png" alt="" onclick='window.open("#","_top")'>
                        </div>
                        
                        <div class="c_image">
                            <img class="image"  src="carousel_images/football.png" alt="" onclick='window.open("#","_top")'>
                        </div>

                        <div class="left-arrow" onclick="manualSwitch(-1)">  <i class="fa fa-arrow-left" ></i> </div>
                        <div class="right-arrow" onclick="manualSwitch(1)"><i class="fa fa-arrow-right" ></i>  </div>
                    </div>
<!---------------------- The Carousel Dots--------------------------------------->

                    <div style="text-align:center">
                        <span class="carousel-dot" onclick="currentSlide(1)"></span>
                        <span class="carousel-dot" onclick="currentSlide(2)"></span>
                        <span class="carousel-dot" onclick="currentSlide(3)"></span>
                        <span class="carousel-dot" onclick="currentSlide(4)"></span>
                        <span class="carousel-dot" onclick="currentSlide(5)"></span>
                    </div>
                </center>
                <script src="js/carousel.js"></script>
                <script src="js/carouseldot.js"></script>
<!---------------------- Sale Banner--------------------------------------->
            </div>
        </div>
        <div class="sale_container">
            <div class="sale_banner">
                <p style="font-size: 50px; color: #494949;">LARGEST SELECTION OF SPORTS GEAR IN THE U.S.A!</p>
                <p style="font-size: 24px; color: #494949;">represent your team on game day with masks and other apparel!</p>
            </div>
        </div>
    </div>	
    <!--------------------Direct Linkst to Sports----------------------------------->
    <div class="categories">
        <div class="link_container">
            <div class="row">
                <a href="SearchServlet?search=baseball" name="search" class="column_sport">
                    <img src="images/Baseball_link.jpg">
                </a>
                <a href="SearchServlet?search=basketball" name="search" class="column_sport">
                    <img src="images/Basketball_link.jpg">
                </a>
                <a href="SearchServlet?search=football" name="search" class="column_sport">
                    <img src="images/Football_link.jpg">
                </a>
                <a href="SearchServlet?search=soccer" name="search" class="column_sport">
                    <img src="images/Soccer_link.jpg">
                </a>
            </div>
        </div>
    </div>
    <!--------------------exclusive products----------------------------------->
    <div class="header">
        <div class="sale_container">
            <div class="offer">
                <div class="row">
                    <div class="column">
                        <img src="images/image1.png" class="exclusive_image">
                    </div>
                    <div class="column">
                        <p style="font-size: 20px;">
                            Football Season is Right Around the Corner!
                        </p>
                        <h1>
                            Gear from Nike, Schutt, Under Armor, and more!
                        </h1>
                        <small>
                            This season find the edge you've been looking for! Here at TeamOne,
                            we only stock the best of the best, and your gonna need gear you can
                            trust if your gonna go for the gold. Lucky for you we're always open.
                        </small>
                        <p style="color: white;">
                            .
                        </p>
                        <a href="SearchServlet?search=football" name="search" class="btn">
                            Buy Here
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
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
	
<!--   -->	
</BODY>
</HTML>