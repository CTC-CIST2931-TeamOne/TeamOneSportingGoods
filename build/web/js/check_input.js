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

//***************************** Invalids/Valid in register.jsp ****************************
// Used: register.jsp

// Invalid/Valid Login
function loginIdInvalid(){
    var loginID = document.getElementById("loginID");//loginID variable
    
    loginID.style.border = "2px solid red"; // Change border color
    loginID.setCustomValidity("Please input a username"); // custom validity
    
    // Set title
    document.getElementById("loginID").title = "Please input a username";
    
    return false;    
}

function loginIdValid(){
    var loginID = document.getElementById("loginID");//loginID variable
    
    loginID.style.border = "1px solid black"; // Change border color
    loginID.setCustomValidity(""); // custom validity
    
    // Set title
    document.getElementById("loginID").title = "";
    
    return true; 
}

// Invalid/Valid password
function passInvalid(){
    var pass = document.getElementById("custpass");//pass variable
    
    pass.style.border = "2px solid red"; // Change border color
    pass.setCustomValidity("Please input a password"); // custom validity
    
    // Set title
    document.getElementById("custpass").title = "Please input a password";
    
    return false;    
}

function passValid(){
    var pass = document.getElementById("custpass");//pass variable

    pass.style.border = "1px solid black"; // Change border color
    pass.setCustomValidity(""); // custom validity

    // Set title
    document.getElementById("custpass").title = "";

    return true; 
}

// Invalid/Valid firstName
function firstNameInvalid(){
    var firstName = document.getElementById("fname");//fname variable
    
    firstName.style.border = "2px solid red"; // Change border color
    firstName.setCustomValidity("Please input your first name"); // custom validity
    
    // Set title
    document.getElementById("fname").title = "Please input your first name";
    
    return false; 
}
function firstNameValid(){
    var firstName = document.getElementById("fname");//fname variable
    
    firstName.style.border = "1px solid black"; // Change border color
    firstName.setCustomValidity(""); // custom validity
    
    // Set title
    document.getElementById("fname").title = "";
    
    return true; 
}

// Invalid/Valid midinitial
function midAnInvalid(){
    var firstName = document.getElementById("midinitial");//fname variable
    
    firstName.style.border = "2px solid red"; // Change border color
    firstName.setCustomValidity("Please input your first name"); // custom validity
    
    // Set title
    document.getElementById("midinitial").title = "Please input your Middle Annitial : A";
    
    return false; 
}

function midAnValid(){
    var firstName = document.getElementById("midinitial");//fname variable
    
    firstName.style.border = "1px solid black"; // Change border color
    firstName.setCustomValidity(""); // custom validity
    
    // Set title
    document.getElementById("midinitial").title = "";
    
    return true;    
}

// Invalid/Valid lastName
function lastNameInvalid(){
    var lastName = document.getElementById("lname");//lastname variable
    
    lastName.style.border = "2px solid red"; // Change border color
    lastName.setCustomValidity("Please input your last name"); // custom validity

    // Set title
    document.getElementById("lname").title = "Please input your last name";
    
    return false; 
}

function lastNameValid(){
    var lastName = document.getElementById("lname");//lastname variable
    
    lastName.style.border = "1px solid black"; // Change border color
    lastName.setCustomValidity(""); // custom validity

    // Set title
    document.getElementById("lname").title = "";
    
    return true; 
}

// Invalid/Valid address1
function address1Invalid(){
    var address1 = document.getElementById("address1");//address1 variable
    
    address1.style.border = "2px solid red"; // Change border color
    address1.setCustomValidity("Please input a valid address : No Special Characters"); // custom validity

    // Set title
    document.getElementById("address1").title = "Please input a valid address : No Special Characters";
    
    return false;   
}

function address1Valid(){
    var address1 = document.getElementById("address1");//address1 variable
    
    address1.style.border = "1px solid black"; // Change border color
    address1.setCustomValidity(""); // custom validity

    // Set title
    document.getElementById("address1").title = "";
    
    return true;    
}

// Invalid/Valid address2 (Not needed but if the user inputs it makes sure they don't input anything but characters and ints)
function address2Invalid(){
    var address2 = document.getElementById("address2");//address1 variable
    
    address2.style.border = "2px solid red"; // Change border color
    address2.setCustomValidity("Please input a valid address : No Special Characters"); // custom validity

    // Set title
    document.getElementById("address2").title = "Please input a valid address : No Special Characters";
    
    return false;      
}

function address2Valid(){
    var address2 = document.getElementById("address2");//address1 variable
    
    address2.style.border = "1px solid black"; // Change border color
    address2.setCustomValidity(""); // custom validity

    // Set title
    document.getElementById("address2").title = "";
    
    return true; 
}

// Invalid/Valid city
function cityInvalid(){
    var city = document.getElementById("city");//city variable
    
    city.style.border = "2px solid red"; // Change border color
    city.setCustomValidity("Please input your city"); // custom validity

    // Set title
    document.getElementById("city").title = "Please input your city";
    
    return false; 
}

function cityValid(){
    var city = document.getElementById("city");//city variable
    
    city.style.border = "1px solid black"; // Change border color
    city.setCustomValidity(""); // custom validity

    // Set title
    document.getElementById("city").title = "";
    
    return true;    
}

// Invalid/Valid state
function stateInvalid(){
    var state = document.getElementById("state");//state variable
    
    state.style.border = "2px solid red"; // Change border color
    state.setCustomValidity("Please input your state annitials : GA"); // custom validity
    
    // Set title
    document.getElementById("state").title = "Please input your state annitials : GA";
    
    return false; 
}

function stateValid(){
    var state = document.getElementById("state");//state variable
    
    state.style.border = "1px solid black"; // Change border color
    state.setCustomValidity(""); // custom validity
    
    // Set title
    document.getElementById("state").title = "";
    
    return true; 
}

// Invalid/Valid zip
function zipInvalid(){
    var zip = document.getElementById("zip");//zip variable
    
    zip.style.border = "2px solid red"; // Change border color
    zip.setCustomValidity("Your zip should be 5 numbers"); // custom validity
    
    // Set title
    document.getElementById("zip").title = "You zip should be 5 numbers";

    return false; 
}

function zipValid(){
    var zip = document.getElementById("zip");//zip variable
    
    zip.style.border = "1px solid black"; // Change border color
    zip.setCustomValidity(""); // custom validity
    
    // Set title
    document.getElementById("zip").title = "";

    return true;
}

// Invalid/Valid phoneNum
function phoneInvalid(){
    var phoneNum = document.getElementById("phoneNum");//zip variable
    
    phoneNum.style.border = "2px solid red"; // Change border color
    phoneNum.setCustomValidity("Please enter a valid phone number"); // custom validity
    
    // Set title
    document.getElementById("phoneNum").title = "Please enter a valid phone number";

    return false;    
}

// Invalid/Valid email
function emailInvalid(){
    var email = document.getElementById("email");//email variable
    
    email.style.border = "2px solid red"; // Change border color
    email.setCustomValidity("Please Input a valid email"); // custom validity

    // Set title
    document.getElementById("email").title = "Please Input a valid email";    
    
    return false;  
}

function emailValid(){
    var email = document.getElementById("email");//email variable
    
    email.style.border = "1px solid black"; // Change border color
    email.setCustomValidity(""); // custom validity

    // Set title
    document.getElementById("email").title = "";    
    
    return true;     
}

//***************************** End Of register.jsp ****************************
// Change Phone Number for Database
// Used in register.jsp and payment.jsp
function changePhoneNum(id){
    var newPhoneNum = document.getElementById(id).value;
        
    var phoneNum2 = document.getElementById(id); // For style
    
    newPhoneNum = newPhoneNum.replace(/[^\d]/g,'');
    
    var newPhoneNum = document.getElementById(id).value = newPhoneNum;
    
    if(phoneNum2.value.length === 10){
        phoneNum2.style.border = "1px solid black"; // Change border color
        phoneNum2.setCustomValidity(""); // custom validity

        return true;  
    }
    else {
        phoneNum2.style.border = "2px solid red"; // Change border color
        phoneNum2.setCustomValidity("Please enter a valid Phone number : 10 digits"); // custom validity

        document.getElementById(id).title = "Please enter a valid Phone number : 10 digits";    

        return false;
    }
}
//****************************** Check maintorders page ************************

// quantity Invalid/Valid
function quantityValid(i){
    var quantity = document.getElementById("quantity" + i + ""); // var quantity
    
    if (quantity.value < 1 || quantity.value > 25 || isNaN(quantity.value)){
        var quantity = document.getElementById("quantity" + i + ""); // var quantity
        quantity.style.border = '2px solid red'; // set border
        quantity.setCustomValidity('Please enter a valid state Abbrev : No special digits'); // set validity
        document.getElementById("quantity" + i + "").title = "Please enter a number between 1-25"; // set title
        return false;
    }
    else {
        quantity.style.border = '2px solid green'; // set border
        quantity.setCustomValidity(''); // set validity
        document.getElementById("quantity" + i + "").title = ""; // set title
        return true; 
    }
}

function quantityInvalid(i){
    var quantity = document.getElementById("quantity" + i + ""); // var quantity
    quantity.style.border = '2px solid red'; // set border
    quantity.setCustomValidity('Please enter a valid quantity : 4 digits'); // set validity
    document.getElementById("quantity" + i + "").title = "Please enter a valid quantity : 4 digits"; // set title
    return false;
}

// orderStatus Invalid/Valid
function orderStatusValid(i){
    var orderStatus = document.getElementById("orderStatus" + i + ""); // var orderStatus
    
    if (orderStatus.value === "O" || orderStatus.value === "S"){
        orderStatus.style.border = '2px solid green'; // set border
        orderStatus.setCustomValidity(''); // set validity
        document.getElementById("orderStatus" + i + "").title = ""; // set title
        return true; 
    }
    else{
        var orderStatus = document.getElementById("orderStatus" + i + ""); // var orderStatus
        orderStatus.style.border = '2px solid red'; // set border
        orderStatus.setCustomValidity('Please enter a valid order status : O or S'); // set validity
        document.getElementById("orderStatus" + i + "").title = "Please enter a valid order status : O or S"; // set title
        return false;
    }
}

function orderStatusInvalid(i){
    var orderStatus = document.getElementById("orderStatus" + i + ""); // var orderStatus
    orderStatus.style.border = '2px solid red'; // set border
    orderStatus.setCustomValidity('Please enter a valid order status : O or S'); // set validity
    document.getElementById("orderStatus" + i + "").title = "Please enter a valid order status : O or S"; // set title
    return false;
}

// orderAmount Invalid/Valid
function orderAmountValid(i){
    var orderAmount = document.getElementById("orderAmount" + i + "");
    
    if(orderAmount.value < 1.00 || orderAmount.value > 3000000.00 || isNaN(orderAmount.value)){
        var orderAmount = document.getElementById("orderAmount" + i + ""); // var orderAmount
        orderAmount.style.border = '2px solid red'; // set border
        orderAmount.setCustomValidity('Please enter a valid amount : 1 - 3000000'); // set validity
        document.getElementById("orderAmount" + i + "").title = "Please enter a valid amount : 1.00 - 3000000.00 : no commas"; // set title
        return false;
    }
    else {
        orderAmount.style.border = "2px solid green"; // Change border color
        orderAmount.setCustomValidity(''); // set validity
        document.getElementById("orderAmount" + i + "").title = ""; // set title
        return true;
    }
}

function orderAmountInvalid(i){
    var orderAmount = document.getElementById("orderAmount" + i + ""); // var orderAmount
    orderAmount.style.border = '2px solid red'; // set border
    orderAmount.setCustomValidity('Please enter a valid amount : 1 - 3000000'); // set validity
    document.getElementById("orderAmount" + i + "").title = "Please enter a valid amount : 1 - 3000000"; // set title
    return false;
}

// orderBalance Invalid/Valid
function orderBalanceValid(i){
    var orderBalance = document.getElementById("orderBalance" + i + "");
    
    if(orderBalance.value < 1.00 || orderBalance.value > 3000000.00 || isNaN(orderBalance.value)){
        var orderBalance = document.getElementById("orderBalance" + i + ""); // var orderBalance
        orderBalance.style.border = '2px solid red'; // set border
        orderBalance.setCustomValidity('Please enter a valid amount : 1 - 3000000'); // set validity
        document.getElementById("orderBalance" + i + "").title = "Please enter a valid amount : 1.00 - 3000000.00 : no commas"; // set title
        return false;
    }
    else {
        orderBalance.style.border = "2px solid green"; // Change border color
        orderBalance.setCustomValidity(''); // set validity
        document.getElementById("orderBalance" + i + "").title = ""; // set title
        return true;
    }
}

function orderBalanceInvalid(i){
    var orderBalance = document.getElementById("orderBalance" + i + ""); // var orderBalance
    orderBalance.style.border = '2px solid red'; // set border
    orderBalance.setCustomValidity('Please enter a valid amount : 1 - 3000000'); // set validity
    document.getElementById("orderBalance" + i + "").title = "Please enter a valid amount : 1 - 3000000"; // set title
    return false;
}

// orderTax Invalid/Valid
function orderTaxValid(i){
    var orderTax = document.getElementById("orderTax" + i + "");
    
    if(orderTax.value < 1.00 || orderTax.value > 3000000.00 || isNaN(orderTax.value)){
        var orderTax = document.getElementById("orderTax" + i + ""); // var orderTax
        orderTax.style.border = '2px solid red'; // set border
        orderTax.setCustomValidity('Please enter a valid amount : 1 - 3000000'); // set validity
        document.getElementById("orderTax" + i + "").title = "Please enter a valid amount : 1.00 - 3000000.00 : no commas"; // set title
        return false;
    }
    else {
        orderTax.style.border = "2px solid green"; // Change border color
        orderTax.setCustomValidity(''); // set validity
        document.getElementById("orderTax" + i + "").title = ""; // set title
        return true;
    }
}

function orderTaxInvalid(i){
    var orderTax = document.getElementById("orderTax" + i + ""); // var orderTax
    orderTax.style.border = '2px solid red'; // set border
    orderTax.setCustomValidity('Please enter a valid amount : 1 - 3000000'); // set validity
    document.getElementById("orderTax" + i + "").title = "Please enter a valid amount : 1 - 3000000"; // set title
    return false;
}


// orderShip Invalid/Valid
function orderShipValid(i){
    var orderShip = document.getElementById("orderShip" + i + "");
    
    if(orderShip.value < 1.00 || orderShip.value > 3000000.00 || isNaN(orderShip.value)){
        var orderShip = document.getElementById("orderShip" + i + ""); // var orderShip
        orderShip.style.border = '2px solid red'; // set border
        orderShip.setCustomValidity('Please enter a valid amount : 1 - 3000000'); // set validity
        document.getElementById("orderShip" + i + "").title = "Please enter a valid amount : 1.00 - 3000000.00 : no commas"; // set title
        return false;
    }
    else {
        orderShip.style.border = "2px solid green"; // Change border color
        orderShip.setCustomValidity(''); // set validity
        document.getElementById("orderShip" + i + "").title = ""; // set title
        return true;
    }
}

function orderShipInvalid(i){
    var orderShip = document.getElementById("orderShip" + i + ""); // var orderShip
    orderShip.style.border = '2px solid red'; // set border
    orderShip.setCustomValidity('Please enter a valid amount : 1 - 3000000'); // set validity
    document.getElementById("orderShip" + i + "").title = "Please enter a valid amount : 1 - 3000000"; // set title
    return false;
}

// orderTotal Invalid/Valid
function orderTotalValid(i){
    var orderTotal = document.getElementById("orderTotal" + i + "");
    
    if(orderTotal.value < 1.00 || orderTotal.value > 3000000.00 || isNaN(orderTotal.value)){
        var orderTotal = document.getElementById("orderTotal" + i + ""); // var orderTotal
        orderTotal.style.border = '2px solid red'; // set border
        orderTotal.setCustomValidity('Please enter a valid amount : 1 - 3000000'); // set validity
        document.getElementById("orderTotal" + i + "").title = "Please enter a valid amount : 1.00 - 3000000.00 : no commas"; // set title
        return false;
    }
    else {
        orderTotal.style.border = "2px solid green"; // Change border color
        orderTotal.setCustomValidity(''); // set validity
        document.getElementById("orderTotal" + i + "").title = ""; // set title
        return true;
    }
}

function orderTotalInvalid(i){
    var orderTotal = document.getElementById("orderTotal" + i + ""); // var orderTotal
    orderTotal.style.border = '2px solid red'; // set border
    orderTotal.setCustomValidity('Please enter a valid amount : 1 - 3000000'); // set validity
    document.getElementById("orderTotal" + i + "").title = "Please enter a valid amount : 1 - 3000000"; // set title
    return false;
}

// prodSize Invalid/Valid
function prodSizeValid(i){
    var prodSize = document.getElementById("prodSize" + i + "");
    
    if(prodSize.value < 1 || prodSize.value > 120.0 || isNaN(prodSize.value)){
        var prodSize = document.getElementById("prodSize" + i + ""); // var prodSize
        prodSize.style.border = '2px solid red'; // set border
        prodSize.setCustomValidity('Please enter a valid size : 1.0 - 120.0'); // set validity
        document.getElementById("prodSize" + i + "").title = "Please enter a valid amount : 1.0 - 120.0"; // set title
        return false;
    }
    else{
        prodSize.style.border = "2px solid green"; // Change border color
        prodSize.setCustomValidity(''); // set validity
        document.getElementById("prodSize" + i + "").title = ""; // set title
        return true;
    }
}
function prodSizeInvalid(i){
    var prodSize = document.getElementById("prodSize" + i + ""); // var prodSize
    prodSize.style.border = '2px solid red'; // set border
    prodSize.setCustomValidity('Please enter a valid amount : 1.0 - 120.0'); // set validity
    document.getElementById("prodSize" + i + "").title = "Please enter a valid amount : 1.0 - 120.0"; // set title
    return false;
}

// prodGender Invalid/Valid
function prodGenderValid(i){
    var prodGender = document.getElementById("prodGender" + i + "");
    
    if(prodGender.value === "M" || prodGender.value === "F" || prodGender.value === "K"){
        prodGender.style.border = "2px solid green"; // Change border color
        prodGender.setCustomValidity(''); // set validity
        document.getElementById("prodGender" + i + "").title = ""; // set title
        return true;
    }
    else{
        var prodGender = document.getElementById("prodGender" + i + ""); // var prodGender
        prodGender.style.border = '2px solid red'; // set border
        prodGender.setCustomValidity('Please enter a valid gender : M(Male) F(Female) K(Kid)'); // set validity
        document.getElementById("prodGender" + i + "").title = "Please enter a valid gender : M(Male) F(Female) K(Kid)"; // set title
        return false;
    }
}

function prodGenderInvalid(i){
    var prodGender = document.getElementById("prodGender" + i + ""); // var prodSize
    prodGender.style.border = '2px solid red'; // set border
    prodGender.setCustomValidity('Please enter a valid gender : M(Male) F(Female) K(Kid)'); // set validity
    document.getElementById("prodGender" + i + "").title = "Please enter a valid gender : M(Male) F(Female) K(Kid)"; // set title
    return false;
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

function resetInfoQuantity(i){
    var quantity = document.getElementById("quantity" + i + ""); // quantity input
    
    quantity.value = quantity.placeholder; // Turns the info back
    
    quantity.style.border = "2px solid grey"; // Change border color
    quantity.style.backgroundColor = "white"; // Change background color
    document.getElementById("quantity" + i + "").title = ""; // set title
}

function resetInfoStatus(i){
    var status = document.getElementById("orderStatus" + i + ""); // Info input
    
    status.value = status.placeholder; // Turns the info back
    
    status.style.border = "2px solid grey"; // Change border color
    status.style.backgroundColor = "white"; // Change background color 
    document.getElementById("orderStatus" + i + "").title = ""; // set title
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
    var quantity = document.getElementById("quantity" + i + ""); // quantity input
    var status = document.getElementById("orderStatus" + i + ""); // Info input
    var amount = document.getElementById("orderAmount" + i + ""); // orderAmount input
    var balance = document.getElementById("orderBalance" + i + ""); // balance input
    var tax = document.getElementById("orderTax" + i + ""); // tax input
    var ship = document.getElementById("orderShip" + i + ""); // ship input
    var total = document.getElementById("orderTotal" + i + ""); // total info
    var size = document.getElementById("prodSize" + i + ""); // siz input
    var gender = document.getElementById("prodGender" + i + ""); // gender input
    
    // Change all of them back to default colors
    
    quantity.style.border = "2px solid grey"; // Change border color
    quantity.style.backgroundColor = "white"; // Change background color  
    
    quantity.value = quantity.placeholder; // Change value
    
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

//****************************Verify all inputs in payment.jsp page ************
//          USED IN: payment.jsp

// cardNumber Invalid/Valid
function cardNumValid(){
    var cardNum = document.getElementById('cardNumber'); // var cardNumber
    cardNum.style.border = '1px solid black'; // set border
    cardNum.setCustomValidity(''); // set validity
    document.getElementById("cardNumber").title = ""; // set title
    return true; 
}

function cardNumInvalid(){
    var cardNum = document.getElementById('cardNumber'); // var cardNumber
    cardNum.style.border = '2px solid red'; // set border
    cardNum.setCustomValidity('Please Input a valid card number : 16 digits'); // set validity
    document.getElementById("cardNumber").title = "Please Input a valid card number : 16 inputs"; // set title
    return false;
}

// cvv Invalid/Valid
function cvvValid(){
    var cvv = document.getElementById('cvv'); // var cvv
    cvv.style.border = '1px solid black'; // set border
    cvv.setCustomValidity(''); // set validity
    cvv.getElementById("cardNumber").title = ""; // set title
    return true;
}

function cvvInvalid(){
    var cvv = document.getElementById('cvv'); // var cvv
    cvv.style.border = '2px solid red'; // set border
    cvv.setCustomValidity('Please Input a valid cvv number : 3 digits'); // set validity
    document.getElementById("cvv").title = "Please Input a valid cvv number : 3 digits"; // set title
    return false;    
}

// expDate Invalid/Valid (Also checks if the date is expired if its valid)
function expDateCheck(){
        
    var today = new Date();
    var date = document.getElementById("expDate");

    var nowMonth = today.getMonth()+1;
    var nowYear = today.getFullYear().toString().substr(-2);
    var month = date.value.split("/", 1);
    var year = date.value.split("/")[1];

    if (year > nowYear){
        date.style.border = '1px solid black'; // set border
        date.setCustomValidity(''); // set validity
        document.getElementById("expDate").title = "Valid Expiry Date"; // set title
        return true;
    } else if (year === nowYear){
        if(month > nowMonth){
                date.style.border = '1px solid black'; // set border
                date.setCustomValidity(''); // set validity
                document.getElementById("expDate").title = "Valid Expiry Date"; // set title
            return true;
        } else {
            date.style.border = "2px solid red"; // Change border color
            date.setCustomValidity("Invalid Expiry Date"); // custom validity

            document.getElementById("expDate").title = "Invalid Expiry Date"; // Set title
            return false;
        }
    } else {
        date.style.border = "2px solid red"; // Change border color
        date.setCustomValidity("Invalid Expiry Date"); // custom validity

        document.getElementById("expDate").title = "Invalid Expiry Date"; // Set title
        return false;
    }

}

function expDateInvalid(){
    var expDate = document.getElementById('expDate'); // var expDate
    expDate.style.border = '2px solid red'; // set border
    expDate.setCustomValidity('Please Input a valid date : MM/YY'); // set validity
    document.getElementById("expDate").title = "Please Input a valid date : MM/YY"; // set title
    return false;
}

// fname Invalid/Valid
function fnameValid(){
    var fname = document.getElementById('fname'); // var fname
    fname.style.border = '1px solid black'; // set border
    fname.setCustomValidity(''); // set validity
    document.getElementById("fname").title = "Please enter your first name"; // set title
    return true;
}

function fnameInvalid(){
    var fname = document.getElementById('fname'); // var fname
    fname.style.border = '2px solid red'; // set border
    fname.setCustomValidity('Please Input a valid first name : No digits'); // set validity
    document.getElementById("fname").title = "Please Input a valid first name : No digits"; // set title
    return false;
}

// mname Invalid/Valid
function mnameValid(){
    var mname = document.getElementById('mname'); // var mname
    mname.style.border = '1px solid black'; // set border
    mname.setCustomValidity(''); // set validity
    document.getElementById("mname").title = "Please enter your middle annitial"; // set title
    return true;
}

function mnameInvalid(){
    var mname = document.getElementById('mname'); // var fname
    mname.style.border = '2px solid red'; // set border
    mname.setCustomValidity('Please Input a valid middle annitial : No digits'); // set validity
    document.getElementById("mname").title = "Please Input a valid middle annitial : No digits"; // set title
    return false;
}

// lname Invalid/Valid
function lnameValid(){
    var lname = document.getElementById('lname'); // var lname
    lname.style.border = '1px solid black'; // set border
    lname.setCustomValidity(''); // set validity
    document.getElementById("lname").title = "Please enter your last name"; // set title
    return true;
}

function lnameInvalid(){
    var lname = document.getElementById('lname'); // var lname
    lname.style.border = '2px solid red'; // set border
    lname.setCustomValidity('Please enter a valid last name : No digits'); // set validity
    document.getElementById("lname").title = "Please enter a valid last name : No digits"; // set title
    return false;
}

// address Invalid/Valid
function addressValid(){
    var address = document.getElementById('address'); // var address
    address.style.border = '1px solid black'; // set border
    address.setCustomValidity(''); // set validity
    document.getElementById("address").title = "Please enter your address"; // set title
    return true;
}

function addressInvalid(){
    var address = document.getElementById('address'); // var address
    address.style.border = '2px solid red'; // set border
    address.setCustomValidity('Please enter a valid address : No special characters'); // set validity
    document.getElementById("address").title = "Please enter a valid address : No special characters"; // set title
    return false;
}

// address2 Invalid/Valid
function address2Valid(){
    var address2 = document.getElementById('address2'); // var address2
    address2.style.border = '1px solid black'; // set border
    address2.setCustomValidity(''); // set validity
    document.getElementById("address2").title = "Please enter your address : not required"; // set title
    return true;
}

function address2Invalid(){
    var address2 = document.getElementById('address2'); // var address2
    address2.style.border = '2px solid red'; // set border
    address2.setCustomValidity('Please enter your address : not required : No special characters'); // set validity
    document.getElementById("address2").title = "Please enter your address : not required : No special characters"; // set title
    return false;
}

// city Invalid/Valid
function cityValid(){
    var city = document.getElementById('city'); // var city
    city.style.border = '1px solid black'; // set border
    city.setCustomValidity(''); // set validity
    document.getElementById("city").title = "Please enter your city"; // set title
    return true;
}

function cityInvalid(){
    var city = document.getElementById('city'); // var city
    city.style.border = '2px solid red'; // set border
    city.setCustomValidity('Please enter a valid city: no digits'); // set validity
    document.getElementById("city").title = "Please enter a valid city : No digits"; // set title
    return false;
}

// state Invalid/Valid
function stateValid(){
    var state = document.getElementById('state'); // var state
    state.style.border = '1px solid black'; // set border
    state.setCustomValidity(''); // set validity
    document.getElementById("state").title = "Please enter your state Abbrev : GA"; // set title
    return true;    
}

function stateInvalid(){
    var state = document.getElementById('state'); // var state
    state.style.border = '2px solid red'; // set border
    state.setCustomValidity('Please enter a valid state Abbrev : No special digits'); // set validity
    document.getElementById("state").title = "Please enter a valid state Abbrev : No digits"; // set title
    return false;    
}

// zip Invalid/Valid
function zipValid(){
    var zip = document.getElementById('zip'); // var zip
    
    if(zip.value.length === 5){
        zip.style.border = '1px solid black'; // set border
        zip.setCustomValidity(''); // set validity
        document.getElementById("zip").title = "Please enter your zip"; // set title
        return true;
    }  
    else{
        var zip = document.getElementById('zip'); // var zip
        zip.style.border = '2px solid red'; // set border
        zip.setCustomValidity('Please enter a valid zip : 5 digits'); // set validity
        document.getElementById("zip").title = "Please enter a valid zip : 5 digits"; // set title
        return false;
    }
}

function zipInvalid(){
    var zip = document.getElementById('zip'); // var zip
    zip.style.border = '2px solid red'; // set border
    zip.setCustomValidity('Please enter a valid zip : 5 digits'); // set validity
    document.getElementById("zip").title = "Please enter a valid zip : 5 digits"; // set title
    return false;
}

// phone Invalid
function phoneInvalid(){
    var phone = document.getElementById('phone'); // var phone
    phone.style.border = '2px solid red'; // set border
    phone.setCustomValidity('Please enter a valid phone number : 10 digits'); // set validity
    document.getElementById("phone").title = "Please enter a valid phone number : 10 digits"; // set title
    return false;
}

// email Invalid/Valid
function emailValid(){
    var email = document.getElementById('email'); // var email
    email.style.border = '1px solid black'; // set border
    email.setCustomValidity(''); // set validity
    document.getElementById("email").title = "Please enter your email"; // set title
    return true;       
}

function emailInvalid(){
    var email = document.getElementById('email'); // var email
    email.style.border = '2px solid red'; // set border
    email.setCustomValidity('Please enter a valid email : whatever@mail.com'); // set validity
    document.getElementById("email").title = "Please enter a valid email : whatever@mail.com"; // set title
    return false;
}

//**************************** End of verify payment.jsp page ******************