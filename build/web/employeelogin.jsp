<%-- 
* Class: CIST 2931 Advanced Systems Project
* Semester: Fall 2020
* Instructor: Ronald Enz
* Description: employeelogin.jsp
* Due: 09.18.2020
* @authors Ian Mashburn, Patricia Rivera
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
        Employee Login || Please give us an A+
    </title>
    <link rel="stylesheet" href="css/emplogin.css">
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
    <script src="js/empLoginValidation.js"></script>  <!-- Load loginValidation JavaScript -->
</HEAD>

<!--START OF INITIALIZE SESSION OBJECTS-->
<%  
    System.out.println("*************** IN employeelogin JSP ****************"); 
%>
<!--END OF OF INITIALIZE SESSION OBJECTS-->

<BODY>
    <main>                                      <!-- Main Area of Page -->
        <div>                                   <!-- Page Header div -->
            <img class="floatLeft" src="images/logo.png" alt="TeamOne Logo" >
            <h1>Employee Login</h1>             <!-- Page Header Text -->
        </div>
        <div id="loginFormArea">                <!-- Area for Form Fields -->
            <form name="LoginForm" method="post" id="LoginForm" action="http://localhost:8080/TeamOneSports/EmpLoginServlet">
                <table>                         <!-- Table of Fields -->
                    <caption></caption>
                    <tr>
                        <td class="loginTableLabel">Login ID:</td>
                        <td class="loginTableField">
                            <input onkeydown="keyDownLogin(event)" type="text" name="loginID" id="loginID" autocomplete="off">
                        </td>	
                    </tr>
                    <tr>
                        <td class="loginTableLabel">Password:</td>
                        <td class="loginTableField">
                            <input onkeydown="keyDownLogin(event)" type="password" name="password" id="password" autocomplete="off">
                        </td>	
                    </tr>
                </table>
                <input class="buttonAttr" onclick="validateLoginData()" type="submit" value="Login">
                <input class="buttonAttr" type="reset" value="Clear">
            </form>
        </div>
    </main>
    <hr>
    <footer>                                    <!-- Page Footer -->
        <small><em>©2020 TeamOne CIST2931 Fall Chattahoochee Tech</em></small>
    </footer>
    
</BODY>
</HTML>