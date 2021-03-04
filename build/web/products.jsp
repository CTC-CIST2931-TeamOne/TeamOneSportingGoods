<%-- 
* Class: CIST 2931 Advanced Systems Project
* Semester: Fall 2020
* Instructor: Ronald Enz
* Description: products.jsp
* Due: 09.10.2020
* @authors Nathaene Mahire, Edrey Torres-Salas, Patricia Rivera, Ian Mashburn, Hunter Browder
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
        All Our Products || Please give us an A+
    </title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
</HEAD>

<%
    if (!(session.getAttribute("scrollposition") == null || session.getAttribute("scrollposition").equals(""))){
        String scrollvalue = (String)session.getAttribute("scrollposition");
%>
        <input type="hidden" id="scrollvalue" name="scrollvalue" value="<%=scrollvalue%>">
<%
    }
%>

<BODY onload = "scrollToPrev()">
<!--START OF OBJECT LOAD FROM SESSION-->
<%
    System.out.println("***************** IN products JSP *******************");

    // Reset scrollvalue
    String scrollvalue = (String)session.getAttribute("scrollposition");
    scrollvalue = "";
                                            // set new session scrollposition
    session.setAttribute("scrollposition",scrollvalue);

    // Checks if checkingout has been made in session
    if(session.getAttribute("checkingout") != null){
        
        //sets the session Variable back to false
        session.setAttribute("checkingout", "false");
    }
    
    //Declare and initialize the Product Filter to default 
    String productFilter = "default";
    
    //**************************************************************************
    // Create LoadProductTable object and fill from session object
    //**************************************************************************
    LoadProductTable LP1;
    //LoadProductTable LPSort;
    LP1 = (LoadProductTable)session.getAttribute("allProducts");
    //LPSort = (LoadProductTable)session.getAttribute("defaultProducts");

    //**************************************************************************
    //Sets Product Filter to default when the product Filter has not been set
    //**************************************************************************
    if(session.getAttribute("productFilter") == null){
    
        System.out.println(" >>> Initialize: set defaultProducts to LP1");
        
        session.setAttribute("defaultProducts", LP1);
        
        
    }
    
    //**************************************************************************
    //Sets Product Filter to the filter saved in session
    //**************************************************************************
    if(session.getAttribute("productFilter") != null){
        
        System.out.println(" >>> get productFilter setting from session");
    
        productFilter = (String)session.getAttribute("productFilter");
        
    }
    
    
    //**************************************************************************
    //Sorts Products by price Starting with the highest Value
    //**************************************************************************
    if(productFilter.equals("highToLow")){
      
        System.out.println(" >>> productFilter = highToLow");
        
        LP1.sortByPrice(LP1.productList, "high");
        LP1.sortByPrice(LP1.searchResult, "high");
        
    }
    //**************************************************************************
    //Sorts Products by price Starting with the lowesr Value
    //**************************************************************************    
    if(productFilter.equals("lowToHigh")){

        System.out.println(" >>> productFilter = lowToLow");
         
        LP1.sortByPrice(LP1.productList, "low");
        LP1.sortByPrice(LP1.searchResult, "low");
        
    }
     
    //**************************************************************************
    //Sorts Products back to default order
    //**************************************************************************     
    if(productFilter.equals("default")){
        
        System.out.println(" >>> productFilter = default");
       
        LP1.productList.productList.clear();
        LP1.productList.productList.addAll(LP1.defaultProductList.productList);
        
    }

    //**************************************************************************
    //Sorts Search Result back to default order
    //**************************************************************************         
    if(productFilter.equals("default") && LP1.searchResult.numberOfProducts > 0 ){
        
        System.out.println(" >>> productFilter = default AND searchResult has data");
       
        LP1.searchResult.productList.clear();
        LP1.searchResult.productList.addAll(LP1.defaultSearchResult.productList);
        
    }

%>
<!--END OF OBJECT LOAD FROM SESSION-->

<!--START OF PAGE HEADER-->
    <div class="header" oonload="myFunction()">
<!---------------------- The Navbar/Searchbar -------------------------------->
        <div class="navbar">
            <div class="logo">
                <a href="index.jsp">	
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

<!--START OF ALL PRODUCTS CONTAINER-->
    <div class="mini-container">
        <div class="row row2">
        <%  if (LP1.searchResult.numberOfProducts > 0) { %>
                <h2>                    
                    Search Results (<%=LP1.searchResult.numberOfProducts %>)
                </h2>            
        <%  } else if (LP1.searchNotFound == true) {
        %>
                <h2>
                    Search Results (0)
                </h2>
        <%  } else {  
        %>
                <h2>
                    All Products (<%=LP1.productList.numberOfProducts %>)
                </h2>
        <%
            }
        %>

            <!-------------Product Filter----------->
            <form id="filterform" name="filterform"  action ="http://localhost:8080/TeamOneSports/ProductFilterServlet">
                <select name = "filter" onchange="submitFilterForm();" style="border: 2px solid black;">
                    <option value = "default" <% if(productFilter.equals("default")){%> Selected <%}%> >Default</option>
                    <option value = "highToLow" <% if(productFilter.equals("highToLow")){%> Selected <%}%>>Price: High to Low</option>
                    <option value = "lowToHigh" <% if(productFilter.equals("lowToHigh")){%> Selected <%}%>>Price: Low to High</option>
                </select>
            </form>
            <!-------------End of Product Filter----------->

        </div>
        <div class="row">
            <%  if (LP1.searchResult.numberOfProducts > 0){
                
            %>
            <!------------- BUILD searchResult DYNAMIC PRODUCT LIST ----------->
                <%  
                    for ( int i = 0; i < LP1.searchResult.numberOfProducts; i++ ){
                %>
                        <div class="column3">
                            <img src='<%=LP1.searchResult.productList.get(i).getProductImagePath()%>'>
                            <h4>
                                <%=LP1.searchResult.productList.get(i).getProductDesc()%>
                            </h4>
                            <p>
                                <%='$' + String.format("%10.2f", LP1.searchResult.productList.get(i).getProductCost())%>
                            </p>
                            <form class="fas fa-shopping-cart" id="AddToCart<%=i%>" name="AddToCart<%=i%>" method="post" action="http://localhost:8080/TeamOneSports/CartServlet?cartaction=add">
                                <input type="hidden" id="currentproduct" name="currentproduct" value=<%=i%>>
                                <input type="hidden" id="scrollposition" name="scrollposition" value=null>
                                <input type="submit" value="Add to Cart" onclick="addToCart(<%=i%>);"/>
                            </form>
                        </div>
                <%
                    }
                %>  <!--------- END searchResult DYNAMIC PRODUCT LIST --------->
                
                
                    <!------------- BUILD No Results Page  ADDED 11/4/2020----------->
                <%
                    
                    } else if(LP1.searchNotFound == true) {%>
                     
                    <div class="column3">
                        <h1>No Results Found</h1>
                    </div>    
                    
                        
                <% }else{
                %>
            <!-------------- BUILD productList DYNAMIC PRODUCT LIST ----------->
                <%  
                    for ( int i = 0; i < LP1.productList.numberOfProducts; i++ ){
                %>
                        <div class="column3">
                            <img src='<%=LP1.productList.productList.get(i).getProductImagePath()%>'>
                            <h4>
                                <%=LP1.productList.productList.get(i).getProductDesc()%>
                            </h4>
                            <p>
                                <%='$' + String.format("%10.2f", LP1.productList.productList.get(i).getProductCost())%>
                            </p>
                            <form class="fas fa-shopping-cart" id="AddToCart<%=i%>" name="AddToCart<%=i%>" method="post" action="http://localhost:8080/TeamOneSports/CartServlet?cartaction=add">
                                <input type="hidden" id="currentproduct" name="currentproduct" value=<%=i%>>
                                <input type="hidden" id="scrollposition" name="scrollposition" value=null>
                                <input type="submit" value="Add to Cart" onclick="addToCart(<%=i%>);"/>
                            </form>
                        </div>
                <%
                    }
                %>  <!--------- END productList DYNAMIC PRODUCT LIST ---------->
            <%
                }
            %>
        </div> 

<!--        <div class="btnpage">
            <span>1</span>
            <span>2</span>
            <span>3</span>
            <span>4</span>
            <span>&#8594;</span>
        </div> -->
    </div>
<!--END OF ALL PRODUCTS CONTAINER-->

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
