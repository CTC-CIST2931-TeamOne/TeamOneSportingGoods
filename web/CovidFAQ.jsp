<%-- 
    Document   : CovidFAQ
    Created on : Oct 31, 2020, 2:47:26 PM
    Author     : Patricia Rivera
    I certify I wrote this code.
--%>
<%@page import="BusinessObjects.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Covid FAQ</title>
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
        <h1 class='pageTitle'>Covid FAQ</h1>
        
        <h2 id='note'> Click the question for an answer </h2>
               
        <h3 class='pageTitle'>*** Due to Covid, your shipment may be delayed for 7 days or more. ***</h3>
        
        <table id='table1'>
            <tr class='questions'>
                <td>
                    <p>What are your opening hours due to Covid?</p>
                </td>
            </tr>
            <tr class='answers'>
                <td colspan="1">
                    <p>Due to Covid our stores won't stay open long. 
                        From Monday - Friday we will open from 12:00 pm to 5:00 pm EST
                        From Saturday - Sunday we will open from 10:00 am to 6:00 pm EST</p>
                </td>
            </tr>
            <tr class='questions'>
                <td>
                    <p>Do we have to wear a mask when we go to the store?</p>
                </td>
            </tr>
            <tr class='answers'>
                <td colspan="1">
                    <p>Due to Covid, you are required to wear a mask. If you don't
                    or if you take it off in the store, we will be forced to ask you
                    to leave.</p>
                </td>
            </tr>
            <tr class='questions'>
                <td>
                    <p>How sanitary is your store?</p>
                </td>
            </tr>
            <tr class='answers'>
                <td colspan="1">
                    <p>Due to Covid, we have a clean up crew come and clean our store
                    every week.</p>
                </td>
            </tr>
            <tr class='questions'>
                <td>
                    <p>Do you have to get appointment to show up at your store</p>
                </td>
            </tr>
            <tr class='answers'>
                <td colspan="1">
                    <p>You do not need to make an appointment to come to our store.
                    We do, however, have a person limit of 20 in our store at a time.</p>
                </td>
            </tr>
            <tr class='questions'>
                <td>
                    <p>Are the employees tested?</p>
                </td>
            </tr>
            <tr class='answers'>
                <td colspan="1">
                    <p>Due to Covid, all our employees are tested. If they
                    refuse or if they test positive, they can't come back to work 
                    until they are cleared. All our employees are required to 
                    wash their hands and put on masks before returning to work.</p>
                </td>
            </tr>
            <tr class='questions'>
                <td>
                    <p>Are you allowed to stay outside the store if it reaches its max 20 people?</p>
                </td>
            </tr>
            <tr class='answers'>
                <td colspan="1">
                    <p>Yes you are allowed to line up outside, our employees will
                    let you know when you can come in. Their will be stickers 
                    6 ft. apart from each other to tell you where to stand.</p>
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
