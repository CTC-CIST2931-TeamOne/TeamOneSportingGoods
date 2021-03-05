/***********************************
*   Document   : check_input.js
*   Created on : August 30, 2020
*   Author     : Patricia A. Rivera
***********************************/

// Get the modal
var modal = document.getElementById("myModal");

// Get the button that opens the modal
var btn = document.getElementById("login_btn");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// When the user clicks the button, open the modal 
btn.onclick = function() {
  modal.style.display = "block";
};

// When the user clicks on <span> (x), close the modal
span.onclick = function() {
  modal.style.display = "none";
};

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
  if (event.target === modal) {
    modal.style.display = "none";
  }
};

// scroll to previous position after servlet call
// USED IN: products.jsp, custproducts.jsp, cart.jsp, profile.jsp
function scrollToPrev(){
    var scrollvalue = document.getElementById("scrollvalue").value;   
    //window.scrollBy(0, scrollvalue);
    window.scrollBy({
        top: scrollvalue,
        behavior: 'smooth'
    });
}

// get scroll position for auto page scrolling
// USED IN: addToCart(),removeFromCart(),updateCart()
function getYPosition(e){
    var scrollnumber  = document.documentElement.scrollTop || document.body.scrollTop;
    return scrollnumber;
}

/**************** Check Input boxes ***************/

// LOGIN check
function check(){
	// Make a variable for the two textboxes
	var userName = document.getElementById("user");
	var passWord = document.getElementById("pass");
	
        // If userName is empty
	if (userName.value === ""){
            userName.setCustomValidity("Enter Username!"); // setsCustomValidity
	}
        else{
            userName.setCustomValidity(""); // else emptyCustomValidity
        }
        
        // If passWord is empty
	if(passWord.value === ""){
            passWord.setCustomValidity("Enter Password!"); // setsCustomValidity
	}
        else{
            passWord.setCustomValidity(""); // else emptyCustomValidity
        }
}

// Invalids for register.jsp
// Used: register.jsp

// Invalid Login
function loginIdInvalid(){
    var loginID = document.getElementById("loginID");//loginID variable
    
    loginID.style.border = "2px solid red"; // Change border color
    loginID.setCustomValidity("Please input a username"); // custom validity
    
    // Set title
    document.getElementById("loginID").title = "Please input a username";
    
    return false;    
}

// Invalid password
function passInvalid(){
    var pass = document.getElementById("custPass");//pass variable
    
    pass.style.border = "2px solid red"; // Change border color
    pass.setCustomValidity("Please input a password"); // custom validity
    
    // Set title
    document.getElementById("custPass").title = "Please input a password";
    
    return false;    
}

// Invalid firstName
function firstNameInvalid(){
    var firstName = document.getElementById("fname");//fname variable
    
    firstName.style.border = "2px solid red"; // Change border color
    firstName.setCustomValidity("Please input your first name"); // custom validity
    
    // Set title
    document.getElementById("fname").title = "Please input your first name";
    
    return false; 
}

// Invalid lastName
function lastNameInvalid(){
    var lastName = document.getElementById("lname");//lastname variable
    
    lastName.style.border = "2px solid red"; // Change border color
    lastName.setCustomValidity("Please input your last name"); // custom validity

    // Set title
    document.getElementById("lname").title = "Please input your last name";
    
    return false; 
}

// Invalid city
function cityInvalid(){
    var city = document.getElementById("city");//city variable
    
    city.style.border = "2px solid red"; // Change border color
    city.setCustomValidity("Please input your city"); // custom validity

    // Set title
    document.getElementById("city").title = "Please input your city";
    
    return false; 
}

// Invalid state
function stateInvalid(){
    var state = document.getElementById("state");//state variable
    
    state.style.border = "2px solid red"; // Change border color
    state.setCustomValidity("Please input your state annitials : GA"); // custom validity
    
    // Set title
    document.getElementById("state").title = "Please input your state annitials : GA";
    
    return false; 
}

// Invalid zip
function zipInvalid(){
    var zip = document.getElementById("zip");//zip variable
    
    zip.style.border = "2px solid red"; // Change border color
    zip.setCustomValidity("Your zip should be 5 numbers"); // custom validity
    
    // Set title
    document.getElementById("zip").title = "You zip should be 5 numbers";

    return false; 
}

// Invalid email
function emailInvalid(){
    var email = document.getElementById("email");//email variable
    
    email.style.border = "2px solid red"; // Change border color
    email.setCustomValidity("Please Input a valid email"); // custom validity

    // Set title
    document.getElementById("email").title = "Please Input a valid email";    
    
    return false;  
}

// Invalid phone
function phoneInvalid(){
    var phone = document.getElementById("phone");//email variable
    
    phone.style.border = "2px solid red"; // Change border color
    phone.setCustomValidity("Please input a proper phone number"); // custom validity

    // Set title
    document.getElementById("phone").title = "Please input a proper phone number";    
    
    return false;      
}

// Registration check
function registerCheck(){
    // Make a variable for the inputs
    var loginID = document.getElementById("loginID");
    var pass = document.getElementById("custPass"); 
    var firstName = document.getElementById("fname");
    var lastName = document.getElementById("lname");
    var city = document.getElementById("city");
    var state = document.getElementById("state");
    var zip = document.getElementById("zip");
    var email = document.getElementById("email");
    var phone = document.getElementById("phone");
    
    // Checks if var empty or Not if it is call oninvalid
    loginID.oninvalid = function() {loginIdInvalid();};
    pass.oninvalid = function() {passInvalid();};
    firstName.oninvalid = function() {firstNameInvalid();};
    lastName.oninvalid = function() {lastNameInvalid();};
    city.oninvalid = function() {cityInvalid();};
    state.oninvalid = function() {stateInvalid();};
    zip.oninvalid = function() {zipInvalid();};
    email.oninvalid = function() {emailInvalid();};
    phone.oninvalid = function() {phoneInvalid();};
    
    // Else turn all the inputs back to the color
    // loginID
    loginID.style.border = "1px solid black"; // Turns border back to black
    loginID.setCustomValidity(""); // empties CustomValidity
    document.getElementById("loginID").title = ""; // empty title
    
    // pass
    pass.style.border = "1px solid black"; // Turns border back to black
    pass.setCustomValidity(""); // empties CustomValidity
    document.getElementById("custPass").title = ""; // empty title

    // firstName
    firstName.style.border = "1px solid black"; // Turns border back to black
    firstName.setCustomValidity(""); // empties CustomValidity
    document.getElementById("fname").title = ""; // empty title  

    // lastName
    lastName.style.border = "1px solid black"; // Turns border back to black
    lastName.setCustomValidity(""); // empties CustomValidity
    document.getElementById("lname").title = ""; // empty title
    
    // city
    city.style.border = "1px solid black"; // Turns border back to black
    city.setCustomValidity(""); // empties CustomValidity
    document.getElementById("city").title = ""; // empty title
    
    // state
    state.style.border = "1px solid black"; // Turns border back to black
    state.setCustomValidity(""); // empties CustomValidity
    document.getElementById("state").title = ""; // empty title

    // zip
    zip.style.border = "1px solid black"; // Turns border back to black
    zip.setCustomValidity(""); // empties CustomValidity
    document.getElementById("zip").title = ""; // empty title
    
    // email
    email.style.border = "1px solid black"; // Turns border back to grey
    email.setCustomValidity(""); // empties CustomValidity
    document.getElementById("email").title = ""; // empty title
    
    // phone
    phone.style.border = "1px solid black"; // Turns border back to grey
    phone.setCustomValidity(""); // empties CustomValidity
    document.getElementById("phone").title = ""; // empty title
    
    // Check address1 if its empty (Not pattern so manual)
    var address1 = document.getElementById("address1");
    
    // address1
    if (address1.value === ""){
        var address1 = document.getElementById("address1"); // phone var
        
        address1.style.border = "2px solid red"; // Turns border red
        address1.setCustomValidity("Please Input your address"); // Set customValidity
        
        // Set title
        document.getElementById("address1").title = "Please Input your address";
        
        return false;
    }
    else if (address1.value !== ""){
        var address1 = document.getElementById("address1"); // phone var
        
        address1.style.border = "1px solid black"; // Turns border red
        address1.setCustomValidity(""); // setsCustomValidity
        
        // Set title
        document.getElementById("address1").title = "";
        
        return true;
    }
        
    return true;
}

// Change Phone Number for Database
function changePhoneNum(id){
    var newPhoneNum = document.getElementById(id).value;
    newPhoneNum = newPhoneNum.replace(/[^\d]/g,'');
    
    var newPhoneNum = document.getElementById(id).value = newPhoneNum;
}


// Color maintorders.jsp page
function check_product(i){
    var product = document.getElementById("product" + i + "");
    
    product.style.border = "2px solid #00FF00"; // Change border color
    product.style.backgroundColor = "#A2FA5C"; // Change background color
}

function check_quantity(i){
    var quantity = document.getElementById("quantity" + i + "");
    
    quantity.style.border = "2px solid #A2FA5C"; // Change border color
    quantity.style.backgroundColor = "#A2FA5C"; // Change background color
}
function check_orderStatus(i){
    var orderStatus = document.getElementById("orderStatus" + i + "");
    
    orderStatus.style.border = "2px solid #A2FA5C"; // Change border color
    orderStatus.style.backgroundColor = "#A2FA5C"; // Change background color
}
function check_orderAmount(i){
    var orderAmount = document.getElementById("orderAmount" + i + "");
    
    orderAmount.style.border = "2px solid #A2FA5C"; // Change border color
    orderAmount.style.backgroundColor = "#A2FA5C"; // Change background color
}
function check_orderBalance(i){
    var orderBalance = document.getElementById("orderBalance" + i + "");
    
    orderBalance.style.border = "2px solid #A2FA5C"; // Change border color
    orderBalance.style.backgroundColor = "#A2FA5C"; // Change background color
}
function check_orderTax(i){
    var orderTax = document.getElementById("orderTax" + i + "");
    
    orderTax.style.border = "2px solid #A2FA5C"; // Change border color
    orderTax.style.backgroundColor = "#A2FA5C"; // Change background color
}
function check_orderShip(i){
    var orderShip = document.getElementById("orderShip" + i + "");
    
    orderShip.style.border = "2px solid #A2FA5C"; // Change border color
    orderShip.style.backgroundColor = "#A2FA5C"; // Change background color
}
function check_orderTotal(i){
    var orderTotal = document.getElementById("orderTotal" + i + "");
    
    orderTotal.style.border = "2px solid #A2FA5C"; // Change border color
    orderTotal.style.backgroundColor = "#A2FA5C"; // Change background color
}
function check_prodSize(i){
    var prodSize = document.getElementById("prodSize" + i + "");
    
    prodSize.style.border = "2px solid #A2FA5C"; // Change border color
    prodSize.style.backgroundColor = "#A2FA5C"; // Change background color
}
function check_prodGender(i){
    var prodGender = document.getElementById("prodGender" + i + "");
    
    prodGender.style.border = "2px solid #A2FA5C"; // Change border color
    prodGender.style.backgroundColor = "#A2FA5C"; // Change background color
}

// Do not allow spacebar and ask for confirmation if enter key press
// USED IN: maintorders.jsp
function keyDownLogin(e){
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

//******************** START of maintorders.jsp FORM RESET ********************
//USED IN: maintorders.jsp
function resetInfoProduct(i){
    var product = document.getElementById("product" + i + ""); // product input

    product.value = product.placeholder;

    product.style.border = "2px solid grey"; // Change border color
    product.style.backgroundColor = "white"; // Change background color

}

function resetInfoQuantity(i){
    var quantity = document.getElementById("quantity" + i + ""); // quantity input
    
    quantity.value = quantity.placeholder; // Turns the info back
    
    quantity.style.border = "2px solid grey"; // Change border color
    quantity.style.backgroundColor = "white"; // Change background color
}

function resetInfoOrder(i){
    var date = document.getElementById("orderDate" + i + ""); // orderDate input
    
    date.value = date.placeholder; // Turns the info back
    
    date.style.border = "2px solid grey"; // Change border color
    date.style.backgroundColor = "white"; // Change background color
}

function resetInfoTime(i){
    var time = document.getElementById("orderTime" + i + ""); // orderTime input
    
    time.value = time.placeholder; // Turns the info back
    
    time.style.border = "2px solid grey"; // Change border color
    time.style.backgroundColor = "white"; // Change background color 
}

function resetInfoStatus(i){
    var status = document.getElementById("orderStatus" + i + ""); // Info input
    
    status.value = status.placeholder; // Turns the info back
    
    status.style.border = "2px solid grey"; // Change border color
    status.style.backgroundColor = "white"; // Change background color 
}

function resetInfoAmount(i){
    var amount = document.getElementById("orderAmount" + i + ""); // orderAmount input
    
    amount.value = amount.placeholder; // Turns the info back
    
    amount.style.border = "2px solid grey"; // Change border color
    amount.style.backgroundColor = "white"; // Change background color    
}

function resetInfoBalance(i){
    var balance = document.getElementById("orderBalance" + i + ""); // balance input
    
    balance.value = balance.placeholder; // Turns the info back
    
    balance.style.border = "2px solid grey"; // Change border color
    balance.style.backgroundColor = "white"; // Change background color     
}

function resetInfoTax(i){
    var tax = document.getElementById("orderTax" + i + ""); // tax input
    
    tax.value = tax.placeholder; // Turns the info back
    
    tax.style.border = "2px solid grey"; // Change border color
    tax.style.backgroundColor = "white"; // Change background color      
}

function resetInfoShipping(i){
    var ship = document.getElementById("orderShip" + i + ""); // ship input
    
    ship.value = ship.placeholder; // Turns the info back
    
    ship.style.border = "2px solid grey"; // Change border color
    ship.style.backgroundColor = "white"; // Change background color      
}

function resetInfoTotal(i){
    var total = document.getElementById("orderTotal" + i + ""); // total info
    
    total.value = total.placeholder; // Turns the info back
    
    total.style.border = "2px solid grey"; // Change border color
    total.style.backgroundColor = "white"; // Change background color         
}

function resetInfoSize(i){
    var size = document.getElementById("prodSize" + i + ""); // siz input
    
    size.value = size.placeholder;
    
    size.style.border = "2px solid grey"; // Change border color
    size.style.backgroundColor = "white"; // Change background color    
}

function resetInfoGender(i){
    var gender = document.getElementById("prodGender" + i + ""); // gender input
    
    gender.value = gender.placeholder; // Turns the info back
    
    gender.style.border = "2px solid grey"; // Change border color
    gender.style.backgroundColor = "white"; // Change background color      
}

// Reset the entire Forum
function resetForum(i){
    
    // All inputs
    var product = document.getElementById("product" + i + ""); // product input
    var quantity = document.getElementById("quantity" + i + ""); // quantity input
    var date = document.getElementById("orderDate" + i + ""); // orderDate input
    var time = document.getElementById("orderTime" + i + ""); // orderTime input
    var status = document.getElementById("orderStatus" + i + ""); // Info input
    var amount = document.getElementById("orderAmount" + i + ""); // orderAmount input
    var balance = document.getElementById("orderBalance" + i + ""); // balance input
    var tax = document.getElementById("orderTax" + i + ""); // tax input
    var ship = document.getElementById("orderShip" + i + ""); // ship input
    var total = document.getElementById("orderTotal" + i + ""); // total info
    var size = document.getElementById("prodSize" + i + ""); // siz input
    var gender = document.getElementById("prodGender" + i + ""); // gender input
    
    // Change all of them back to default colors
    product.style.border = "2px solid grey"; // Change border color
    product.style.backgroundColor = "white"; // Change background color     

    product.value = product.placeholder; // Change value
    
    quantity.style.border = "2px solid grey"; // Change border color
    quantity.style.backgroundColor = "white"; // Change background color  
    
    quantity.value = quantity.placeholder; // Change value
    
    date.style.border = "2px solid grey"; // Change border color
    date.style.backgroundColor = "white"; // Change background color
    
    date.value = date.placeholder; // Change value
    
    time.style.border = "2px solid grey"; // Change border color
    time.style.backgroundColor = "white"; // Change background color
    
    time.value = time.placeholder; // Change value
    
    status.style.border = "2px solid grey"; // Change border color
    status.style.backgroundColor = "white"; // Change background color   
    
    status.value = status.placeholder; // Change value
    
    amount.style.border = "2px solid grey"; // Change border color
    amount.style.backgroundColor = "white"; // Change background color 
    
    amount.value = amount.placeholder; // Change value
    
    balance.style.border = "2px solid grey"; // Change border color
    balance.style.backgroundColor = "white"; // Change background color 
    
    balance.value = balance.placeholder; // Change value
    
    tax.style.border = "2px solid grey"; // Change border color
    tax.style.backgroundColor = "white"; // Change background color 
    
    tax.value = tax.placeholder; // Change value
    
    ship.style.border = "2px solid grey"; // Change border color
    ship.style.backgroundColor = "white"; // Change background color
    
    ship.value = ship.placeholder; // Change value
    
    total.style.border = "2px solid grey"; // Change border color
    total.style.backgroundColor = "white"; // Change background color
    
    total.value = total.placeholder; // Change value
    
    size.style.border = "2px solid grey"; // Change border color
    size.style.backgroundColor = "white"; // Change background color
    
    size.value = size.placeholder; // Change value
    
    gender.style.border = "2px solid grey"; // Change border color
    gender.style.backgroundColor = "white"; // Change background color
    
    gender.value = gender.placeholder; // Change value
}
//********************* END of maintorders.jsp FORM RESET *********************


// Do not allow spacebar
// USED IN: profile.jsp - profile info update section
//          index.jsp - login modal
//          product.jsp - login modal
//          cart.jsp - login modal
function nospace(e) {
    e = e || window.event;
    var key = e.keyCode || e.charCode;
    if (key === 32) { //space
        e.preventDefault();
    }
}

// Only allows numeric key strokes
// USED IN: cart.jsp
function numonly(e) {
	e = e || window.event;
    var key = e.keyCode || e.charCode;
    if (key < 48 || key > 57) { //top row keys only
        e.preventDefault();
    }
	if (key < 96 || key > 105) { //number pad keys only
        e.preventDefault();
    }
}

// Do not allow spacebar or enter key
// USED IN: profile.jsp - logon/password update section
function noenterorspace(e) {
    e = e || window.event;
    var key = e.keyCode || e.charCode;
    if (key === 32) { //space
        e.preventDefault();
    }
    if (key === 13) { //enter
        e.preventDefault();
    }
}

// Do not allow enter key
// USED IN: profile.jsp - profile info update section
function noenter(e) {
    e = e || window.event;
    var key = e.keyCode || e.charCode;
    if (key === 13) { //enter
        e.preventDefault();
    }
}

// Error Functions
// Used In: confirmUpdate() function in the profile.jsp page
function zipInvalid(){
    var zip = document.getElementById("zip"); //zip variable
    
    zip.style.border = "2px solid red"; // Change border color
    zip.setCustomValidity("The zip has to be 5 numbers"); // custom validity
    
    return false;
}

function stateInvalid(){
    var state = document.getElementById("state"); //zip variable
    
    state.style.border = "2px solid red"; // Change border color
    state.setCustomValidity("Only put State Abbrev."); // custom validity
    
    return false;
}

function mnameInvalid(){
    var mname = document.getElementById("mname"); //zip variable
    
    mname.style.border = "2px solid red"; // Change border color
    mname.setCustomValidity("Only put your first letter."); // custom validity
    
    return false;
}

function emailInvalid(){
    var email = document.getElementById("email"); //zip variable
    
    email.style.border = "2px solid red"; // Change border color
    email.setCustomValidity("Please Input a proper email"); // custom validity
    
    return false;
}

// Check for confirmation if enter key pressed
// USED IN: profile.jsp - logon/password update section
//                      - profile info update section
function confirmUpdate(e){  
    // Variables
    var zip = document.getElementById("zip");
    var state = document.getElementById("state");
    var mname = document.getElementById("mname");
    var email = document.getElementById("email");
    
    // If Variable oninvalid then it will call that function
    zip.oninvalid = function() {zipInvalid();};
    state.oninvalid = function() {stateInvalid();};
    mname.oninvalid = function() {mnameInvalid();};
    email.oninvalid = function() {emailInvalid();};
    
    // else back to normal
    zip.style.border = "1px solid black"; // Change border color
    zip.setCustomValidity("");
    
    state.style.border = "1px solid black"; // Change border color
    state.setCustomValidity("");
    
    mname.style.border = "1px solid black"; // Change border color
    mname.setCustomValidity(""); // custom validity
    
    email.style.border = "1px solid black"; // Change border color
    email.setCustomValidity(""); // custom validity
    
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

// Check for confirmation of addToCart
// USED IN: products.jsp and custproducts.jsp
function addToCart(e){
    
    var formID = "AddToCart" + e;
    var currentFormID = document.getElementById(formID);
    var scrollnumber = getYPosition(e);
    
    currentFormID.scrollposition.value = scrollnumber;

    if (confirm("Add item to Cart?")) {
        return true;
    } 
    else {
        e.preventDefault();
        return false;
    }
}

// Check for confirmation of removeFromCart
// USED IN: cart.jsp
function removeFromCart(e){
    if (confirm("Remove item from Cart?")) {
        return true;
    } 
    else {
        e.preventDefault();
        return false;
    }
}

// Submit cart to CartServlet using correct product form entry
// USED IN: cart.jsp
function updateCart(i){
    document.getElementById("formsubtotals" + i + "").submit();
}

// Submit cart to CartServlet using correct product form entry
// USED IN: cart.jsp
function updateCartQuantity(i){
    
    var quantityIDfromForm = "cartquantity" + i;   
    var quantityID = document.getElementById(quantityIDfromForm);
		
    if(quantityID.value < 1 || quantityID.value > 25 ) {
        quantityID.style.border = "2px solid red"; // Turns border back to red
        quantityID.setCustomValidity("Enter an item quantity between 1 and 25."); // setsCustomValidity
        quantityID.value = 1;
        return false;
    }
    else {
        quantityID.style.border = "2px solid grey"; // Turns border back to grey
        quantityID.setCustomValidity(""); // empties CustomValidity
        document.getElementById("formsubtotals" + i + "").submit();
    }

}

// Submit filterform to ProductFilterServlet using correct product form entry
// USED IN: products.jsp, custProducts.jsp
function submitFilterForm(){
    document.getElementById("filterform").submit();
}

// goto profile.jsp onload of checkout.jsp if this is a Guest
// USED IN: checkout.jsp
function gotoProfile(e){
    window.location.href = "http://localhost:8080/TeamOneSports/profile.jsp";
}

// check all fields necessary for an Order object write
// display alert if fields left blank
// USED IN: profile.jsp 
function chkProfileInfo(e){

    //possible checks here for profile page

}

// check all fields necessary for an Order object write
// Check for confirmation if Placing Order
// USED IN: checkout.jsp 
function placeOrder(e){
    
    // check if payment method has been selected
    var index = document.getElementById("payment").selectedIndex;
    if (index < 1){
        alert("Select or Add a payment method.");
        e.preventDefault();
        return false;
    }
    
    // confirming order placement
    if (confirm("Place Your Order?")) {
        alert("Order Confirmed");
        return true;
    } 
    else {
        alert("Order Placement Cancelled");
        e.preventDefault();
        return false;
    }
}  

// Invalid Functions for inputs in payment.jsp
function cardNumInvalid(){
    var cardNum = document.getElementById("cardNumber"); //zip variable
    
    cardNum.style.border = "2px solid red"; // Change border color
    cardNum.setCustomValidity("Your Card should have 15 numbers"); // custom validity
    
    return false;
}

function ccvInvalid(){
    var ccv = document.getElementById("ccv"); //zip variable
    
    ccv.style.border = "2px solid red"; // Change border color
    ccv.setCustomValidity("Should be 3 characters"); // custom validity
    
    return false;
}

function expDateInvalid(){
    // Check expDate is expired or not
    var expDate = document.getElementById("expDate");
    
    var today = new Date();

    var date = (today.getMonth()+1)+'/'+today.getFullYear().toString().substr(-2);
    
    alert(date);

    expDate.setCustomValidity("Your Card is Expired / Format: MM/YY"); // custom validity

    if (expDate.value < date){
        alert("Expired");
        // Change the title
        document.getElementById("expDate").title = "Your Card is Expired / Make Sure you put MM/YY";
                        
        expDate.style.border = "2px solid red"; // Change border color
        expDate.setCustomValidity("Your Card is Expired / Format: MM/YY"); // custom validity
        return false;
    }
    else{
        alert("Not Expired");
        return false;
    }
}

// Verify all inputs in payment.jsp page
//          USED IN: payment.jsp
function checkPayment(){
    // Variables from payment.jsp inputs
    var cardNum = document.getElementById("cardNumber");
    var ccv = document.getElementById("ccv");
    var expDate = document.getElementById("expDate");
    
    // If Variable oninvalid then it will call that function
    cardNum.oninvalid = function() {cardNumInvalid();};
    ccv.oninvalid = function() {ccvInvalid();};
        // Check expDate is expired or not
    var expDate = document.getElementById("expDate");
    
    var today = new Date();

    var date = (today.getMonth()+1)+'/'+today.getFullYear().toString().substr(-2);
    
    alert(date);

    expDate.setCustomValidity("Your Card is Expired / Format: MM/YY"); // custom validity

    if (expDate.value < date){
        alert("Expired");
        // Change the title
        document.getElementById("expDate").title = "Your Card is Expired / Make Sure you put MM/YY";
                        
        expDate.style.border = "2px solid red"; // Change border color
        expDate.setCustomValidity("Your Card is Expired / Format: MM/YY"); // custom validity
        return false;
    }
    else{
        alert("Not Expired");
        return false;
    }
        
    // else back to normal
    cardNum.style.border = "1px solid black"; // Change border color
    cardNum.setCustomValidity("");
    
    ccv.style.border = "1px solid black"; // Change border color
    ccv.setCustomValidity("");
    
    expDate.style.border = "1px solid black"; // Change border color
    expDate.setCustomValidity("");
    
    return true;
}
