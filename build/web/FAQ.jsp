<%-- 
    Document   : FAQ
    Created on : Oct 7, 2020, 1:33:21 PM
    Author     : Patricia Rivera
    I certify I wrote this code.
--%>
<%@page import="BusinessObjects.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>FAQ page</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="js/FAQjquery.js"></script>
        <link rel="stylesheet" href="css/FAQStyle.css">
    </head>
    <body>
    <!--START OF OBJECT LOAD FROM SESSION-->
    <%
        System.out.println("***************** IN profile JSP *******************");

        // custObject: set session (contains orderList,cartList,paymentMethodList)                     
        Customer custObject; 

        // Get custObject from session
        custObject = (Customer)session.getAttribute("custObject"); 

    %>
    <!--END OF OBJECT LOAD FROM SESSION-->
        <h1 class='pageTitle'>FAQ</h1>
        
        <h2 id='note'> Click the question for an answer </h2>
        
        <h3 class='pageTitle'>Q&A</h3>
        
        <table id='table1'>
            <tr class='questions'>
                <td>
                    <p>How do you login?</p>
                </td>
            </tr>
            <tr class='answers'>
                <td colspan="1">
                    <p>Look at the top of the page. On the top right there will 
                    be a dark green Login button.</p>
                </td>
            </tr>
            <tr class='questions'>
                <td>
                    <p>How do you register?</p>
                </td>
            </tr>
            <tr class='answers'>
                <td colspan="1">
                    <p>Click the Login button on the top right of the page,
                    on the bottom of that box will be a register button.</p>
                </td>
            </tr>
            <tr class='questions'>
                <td>
                    <p>How do you search for an item?</p>
                </td>
            </tr>
            <tr class='answers'>
                <td colspan="1">
                    <p>At the top of the home page their is a search bar, type what
                    you are looking for and press Enter or click the magnifying 
                    glass.</p>
                </td>
            </tr>
            <tr class='questions'>
                <td>
                    <p>How do you add items to the cart?</p>
                </td>
            </tr>
            <tr class='answers'>
                <td colspan="1">
                    <p>Go to the product you would like, click the cart icon on 
                        the bottom of the product and it will be added to cart.</p>
                </td>
            </tr>
            <tr class='questions'>
                <td>
                    <p>Can you change your username? If you can, how?</p>
                </td>
            </tr>
            <tr class='answers'>
                <td colspan="1">
                    <p>You can change your username. To change it, you need to login
                    to your account and click your account on the top right, then  
                    click View/Update Profile.</p>
                </td>
            </tr>
            <tr class='questions'>
                <td>
                    <p>Can you Search a product by Price?</p>
                </td>
            </tr>
            <tr class='answers'>
                <td colspan="1">
                    <p>Yes on the All Products page or if you search specific 
                        items on the middle right of the page, just click the 
                        dropdown menu and click the price option.</p>
                </td>
            </tr>
            <tr class='questions'>
                <td>
                    <p>How do you Logout?</p>
                </td>
            </tr>
            <tr class='answers'>
                <td colspan="1">
                    <p>Click on your name when you are logged in, a drop down menu
                    will show up. Click logout.</p>
                </td>
            </tr>
            <tr class='questions'>
                <td>
                    <p>Do you have a Covid FAQ?</p>
                </td>
            </tr>
            <tr class='answers'>
                <td colspan="1">
                    <p>Yes just go to the bottom of the home page and click on Covid Hours for
                    our FAQ for Covid.</p>
                </td>
            </tr>
            <tr class='questions'>
                <td>
                    <p>Can you search for items by Sport?</p>
                </td>
            </tr>
            <tr class='answers'>
                <td colspan="1">
                    <p>Their are 3 ways to do this. 
                    1) You can click the drop down list on the top of the page "Shop By Sport"
                    2) Scroll the first page to the middle and click one of the sports
                    3) Simply type the sport name in the search bar and perform a search</p>
                </td>
            </tr>
            <tr class='questions'>
                <td>
                    <p>How do you check your cart?</p>
                </td>
            </tr>
            <tr class='answers'>
                <td colspan="1">
                    <p>Click the cart icon, on the top right of the page</p>
                </td>
            </tr>
            <tr class='questions'>
                <td>
                    <p>How do I check my orders ?</p>
                </td>
            </tr>
            <tr class='answers'>
                <td colspan="1">
                    <p>When you login, click your name on the top right, a drop down menu
                    should pop up. Click View Orders.</p>
                </td>
            </tr>
        </table>
        
        <br />
        <div class="button">
        <%  // if custObject is empty, link goes to index.jsp
            if ((custObject.getCustNumber() == " ")|| (custObject.getCustLoginID() == "Guest")){
        %>
            <form action="index.jsp">
                <input type="submit" value="Go Back?" />
            </form>
        <%  // else, link goes to custindex.jsp : customer logged in
            } else {
        %>
            <form action="custindex.jsp">
                <input type="submit" value="Go Back?" />
            </form>
        <%
                }
        %>
        </div>
    </body>
</html>
