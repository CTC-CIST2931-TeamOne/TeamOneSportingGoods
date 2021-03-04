/*
* Class: CIST 2931 Advanced Systems Project
* Semester: Fall 2020
* Instructor: Ronald Enz
* Description: empLoginValidation.js
* Due: 09.18.2020
* @author Ian Mashburn, Patricia Rivera
* @version 1.0
*
* By turning in this code, I Pledge:
* 1. That I have completed the programming assignment independently.
* 2. I have not copied the code from a student or any source.
* 3. I have not given my code to any student.
 */

/*******************************************************************************
*    Function:  validateLoginData()
* Calling JSP:  employeelogin.jsp
* Description:  Validates ID and password entered to log into Employee Portal 
*    If valid:  continues with action on LoginForm --> EmpLoginServlet
*  If invalid:  prevents action, clears LoginForm, sets focus to loginID field
*******************************************************************************/
function validateLoginData() {
/*******************************************************************************
 * Declare and assign variables to fields in LoginForm of login.jsp 
*******************************************************************************/
    var a = document.getElementById("loginID").value;
    var b = document.getElementById("password").value;
    
/*******************************************************************************
* Validate fields 
*******************************************************************************/
    if ((a==="") || (b==="")) {                     /** field left blank? */
        alert("You must enter a valid Login ID and Password");
        event.preventDefault();
        document.forms["LoginForm"].reset();
        document.LoginForm.loginID.focus();
    }
}

/*******************************************************************************
 * 
 * Author: Patricia
 * Date: October 1, 2020
 * 
 ******************************************************************************/

// Checks Space and Enter
function keyDown(e) { 
  var e = window.event || e;
  var key = e.keyCode;
   //space pressed
   if (key === 32) { //space
    e.preventDefault();
   }
  
   // Enter Pressed
   if (key === 13){
        if (confirm("Do you Confirm Changes?")) {
            alert("Update confirmed");
            return true;
        } 
        else {
            alert("Update cancelled");
            e.preventDefault();
            return false;
        }
    }
         
}

// Only checks Space
function keyDownLogin(e){
  var e = window.event || e;
  var key = e.keyCode;
   //space pressed
   if (key === 32) { //space
    e.preventDefault();
   }
}
