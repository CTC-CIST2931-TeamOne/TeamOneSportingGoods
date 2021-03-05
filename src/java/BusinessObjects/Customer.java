/*******************************************************************************
* Class: CIST 2931 Advanced Systems Project
* Semester: Fall 2020
* Instructor: Ronald Enz
* Description:  Customer Object for TeamOneSportingGoods Project
* Due: 08/26/2020
* @author Ian Mashburn
* @version 1.0
*
* By turning in this code, I Pledge:
* 1. That I have completed the programming assignment independently.
* 2. I have not copied the code from a student or any source.
* 3. I have not given my code to any student.
*
*******************************************************************************/
package BusinessObjects;

import java.sql.*;                          // import for database access
import java.util.logging.Level;             // import for error logging
import java.util.logging.Logger;            // import for error logging

/*******************************************************************************
* Class Customer - Business Object with DB Access Methods
*******************************************************************************/
public class Customer {

/*******************************************************************************
* OBJECT PROPERTIES - Declare/Initialize object variables & CONSTANTS
*******************************************************************************/
    private String  custNumber      = " ";
    private String  custType        = " ";
    private String  custLoginID     = " ";
    private String  custPassword    = " ";
    private String  custFirstName   = " ";
    private String  custMidInitial  = " ";
    private String  custLastName    = " ";
    private String  custAddrLine1   = " ";
    private String  custAddrLine2   = " ";
    private String  custCity        = " ";
    private String  custState       = " ";
    private String  custZip         = " ";
    private String  custPhone       = " ";
    private String  custEmail       = " ";
    private double  custBalance     = 0.0;
                                            // Init paymentMethodList Object
    public  PaymentMethodList paymentMethodList = new PaymentMethodList();
                                            // Init orderList Object
    public  OrderList orderList = new OrderList();
                                            // Init cartList Object
    public  CartList cartList = new CartList();
    public  boolean custNotFound = false;   // Initialize custNotFound to false
    public  boolean usernameExists = false; // Initialize usernameExists to false
                                            // Database Driver
    final private String DBDRIVER = "net.ucanaccess.jdbc.UcanaccessDriver";
                                            // Database Link and Data
    final private String DBDATA = 
             "jdbc:ucanaccess://C:/DBData/TeamOneSportingGoodsACCDB.accdb";
             
/*******************************************************************************
* CONSTRUCTORS 
*******************************************************************************/
    // no-arg constructor to create Customer with default values
    public Customer() 
    {   custNumber      = " ";
        custType        = " ";
        custLoginID     = " ";
        custPassword    = " ";
        custFirstName   = " ";
        custMidInitial  = " ";
        custLastName    = " ";
        custAddrLine1   = " ";
        custAddrLine2   = " ";
        custCity        = " ";
        custState       = " ";
        custZip         = " ";
        custPhone       = " ";
        custEmail       = " ";
        custBalance     = 0.0;
    } // ******************** END OF Customer no-arg CONSTRUCTOR ***************

    // multi-arg constructor to create Customer with passed values
    public Customer(String newCustNumber, String newCustType, 
                    String newCustLoginID, String newCustPassword, 
                    String newCustFirstName, String newCustMidInitial,
                    String newCustLastName, String newCustAddrLine1,
                    String newCustAddrLine2, String newCustCity,
                    String newCustState, String newCustZip,
                    String newCustPhone, String newCustEmail, 
                    double newCustBalance)
    {   this.custNumber     = newCustNumber;
        this.custType       = newCustType;
        this.custLoginID    = newCustLoginID;
        this.custPassword   = newCustPassword;
        this.custFirstName  = newCustFirstName;
        this.custMidInitial = newCustMidInitial;
        this.custLastName   = newCustLastName;
        this.custAddrLine1  = newCustAddrLine1;
        this.custAddrLine2  = newCustAddrLine2;
        this.custCity       = newCustCity;
        this.custState      = newCustState;
        this.custZip        = newCustZip;
        this.custPhone      = newCustPhone;
        this.custEmail      = newCustEmail;
        this.custBalance    = newCustBalance;
    } // ****************** END OF Customer multi-arg CONSTRUCTOR **************

/*******************************************************************************
* ACCESSOR METHODS - Getters 
* @return 
*******************************************************************************/
    public String getCustNumber()           // retrieve & return custNumber
    {   return this.custNumber;
    } // ******************** END OF getCustNumber ACCESSOR ********************

    public String getCustType()             // retrieve & return custType
    {   return this.custType;
    } // ******************** END OF getCustType ACCESSOR **********************

    public String getCustLoginID()          // retrieve & return custLoginID
    {   return this.custLoginID;
    } // ******************** END OF getCustLoginID ACCESSOR *******************

    public String getCustPassword()         // retrieve & return custPassword
    {   return this.custPassword;
    } // ******************** END OF getCustPassword ACCESSOR ******************

    public String getCustFirstName()        // retrieve & return custFirstName
    {   return this.custFirstName;
    } // ******************** END OF getCustFirstName ACCESSOR *****************

    public String getCustMidInitial()       // retrieve & return custMidInitial
    {   return this.custMidInitial;
    } // ******************** END OF getCustMidInitial ACCESSOR ****************

    public String getCustLastName()         // retrieve & return custLastName
    {   return this.custLastName;
    } // ******************** END OF getCustLastName ACCESSOR ******************

    public String getCustAddrLine1()        // retrieve & return custAddrLine1
    {   return this.custAddrLine1;
    } // ******************** END OF getCustAddrLine1 ACCESSOR *****************

    public String getCustAddrLine2()        // retrieve & return custAddrLine2
    {   return this.custAddrLine2;
    } // ******************** END OF getCustAddrLine2 ACCESSOR *****************

    public String getCustCity()             // retrieve & return custCity
    {   return this.custCity;
    } // ******************** END OF getCustCity ACCESSOR **********************

    public String getCustState()            // retrieve & return custState
    {   return this.custState;
    } // ******************** END OF getCustState ACCESSOR *********************

    public String getCustZip()              // retrieve & return custZip
    {   return this.custZip;
    } // ******************** END OF getCustZip ACCESSOR ***********************

    public String getCustPhone()            // retrieve & return custPhone
    {   return this.custPhone;
    } // ******************** END OF getCustPhone ACCESSOR *********************

    public String getCustEmail()            // retrieve & return custEmail
    {   return this.custEmail;
    } // ******************** END OF getCustEmail ACCESSOR *********************

    public double getCustBalance()          // retrieve & return custBalance
    {   return this.custBalance;
    } // ******************** END OF getCustBalance ACCESSOR *******************
    
/*******************************************************************************
* MUTATOR METHODS - Setters
*******************************************************************************/
                                            // set custNumber to value passed
    public void setCustNumber(String custNumberPassed)
    {   this.custNumber = custNumberPassed;
    } // ******************** END OF setCustNumber MUTATOR *********************

                                            // set custType to value passed
    public void setCustType(String custTypePassed)
    {   this.custType = custTypePassed;
    } // ******************** END OF setCustNumber MUTATOR *********************

                                            // set custLoginID to value passed
    public void setCustLoginID(String custLoginIDPassed)
    {   this.custLoginID = custLoginIDPassed;
    } // ******************** END OF setCustLoginID MUTATOR ********************

                                            // set custPassword to value passed
    public void setCustPassword(String custPasswordPassed)
    {   this.custPassword = custPasswordPassed;
    } // ******************** END OF setCustPassword MUTATOR *******************

                                            // set custFirstName to value passed
    public void setCustFirstName(String custFirstNamePassed)
    {   this.custFirstName = custFirstNamePassed;
    } // ******************** END OF setCustFirstName MUTATOR ******************

                                            // set custMidInitial to value passd
    public void setCustMidInitial(String custMidInitialPassed)
    {   this.custMidInitial = custMidInitialPassed;
    } // ******************** END OF setCustMidInitial MUTATOR *****************

                                            // set custLastName to value passed
    public void setCustLastName(String custLastNamePassed)
    {   this.custLastName = custLastNamePassed;
    } // ******************** END OF setCustLastName MUTATOR *******************

                                            // set custAddrLine1 to value passed
    public void setCustAddrLine1(String custAddrLine1Passed)
    {   this.custAddrLine1 = custAddrLine1Passed;
    } // ******************** END OF setCustAddrLine1 MUTATOR ******************

                                            // set custAddrLine2 to value passed
    public void setCustAddrLine2(String custAddrLine2Passed)
    {   this.custAddrLine2 = custAddrLine2Passed;
    } // ******************** END OF setCustAddrLine2 MUTATOR ******************

                                            // set custCity to value passed
    public void setCustCity(String custCityPassed)
    {   this.custCity = custCityPassed;
    } // ******************** END OF setCustCity MUTATOR ***********************

                                            // set custState to value passed
    public void setCustState(String custStatePassed)
    {   this.custState = custStatePassed;
    } // ******************** END OF setCustState MUTATOR **********************

                                            // set custZip to value passed
    public void setCustZip(String custZipPassed)
    {   this.custZip = custZipPassed;
    } // ******************** END OF setCustZip MUTATOR ************************

                                            // set custPhone to value passed
    public void setCustPhone(String custPhonePassed)
    {   this.custPhone = custPhonePassed;
    } // ******************** END OF setCustPhone MUTATOR **********************

                                            // set custEmail to value passed
    public void setCustEmail(String custEmailPassed)
    {   this.custEmail = custEmailPassed;
    } // ******************** END OF setCustEmail MUTATOR **********************

                                            // set custBalance to value passed
    public void setCustBalance(double custBalancePassed)
    {   this.custBalance = custBalancePassed;
    } // ******************** END OF setCustBalance MUTATOR ********************

/*******************************************************************************
* DATABASE ACCESS METHODS
*******************************************************************************/
/*******************************************************************************
* selectDB METHOD
* 
* Description:  SELECT database record for custNumber passed and fill Customer 
*               Object with that record's data
*       @param  keyCustNumber
*******************************************************************************/
    public void selectDB(String keyCustNumber)
    {                                       // Load DB Driver and get connection
        System.out.println("\nStarting DB SELECT...........");
        
        try {                               // attempt database driver load
            Class.forName(DBDRIVER);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(
                    Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
        // attempt database connection and read with resources
        // JVM will Auto-Close connection to DB
        try (Connection con = DriverManager.getConnection(DBDATA)){
                                            // create Statement Object
            Statement stmt = con.createStatement();
            setCustNumber(keyCustNumber);   // set this.custNumber
                                            // create sql string for query
            String sql = "select * from CUSTOMER WHERE CUSTNUMBER=" 
                            + getCustNumber();
            System.out.println("\t" + sql);
                                            // executeQuery >> ResultSet object
            ResultSet rs = stmt.executeQuery(sql);
            
            // Process Data
            rs.next();                      // set DB cursor to the first result
            // set properties to DB positional record values
            setCustNumber(rs.getString(1));
            setCustType(rs.getString(2));
            setCustLoginID(rs.getString(3));
            setCustPassword(rs.getString(4));
            setCustFirstName(rs.getString(5));
            setCustMidInitial(rs.getString(6));
            setCustLastName(rs.getString(7));
            setCustAddrLine1(rs.getString(8));
            setCustAddrLine2(rs.getString(9));
            setCustCity(rs.getString(10));
            setCustState(rs.getString(11));
            setCustZip(rs.getString(12));
            setCustPhone(rs.getString(13));
            setCustEmail(rs.getString(14));
            setCustBalance(rs.getDouble(15));
        }
        catch(Exception e){                 // catch if database connection 
                                            //               or read failed
            custNotFound = true;            // set custNotFound flag to true
            System.out.println(
                "Database Access Failed for SELECT of CUSTNUMBER: "
                                                + getCustNumber());
            System.out.println("PP: " + e);
        }
        
        if (!(custNotFound)){               // if custNotFound was found
                                            // invoke getPaymentMethods()
            getPaymentMethods();            //  to get associated paymentMethods
                                            // invoke getOrders()
            getOrders();                    //  to get associated Orders        
                                            // invoke getCart()
            getCart();                      //  to get list of Cart Entries 
        }
    
    } // ******************** END OF selectDB DATABASE ACCESS METHOD ***********

/*******************************************************************************
* loginDB METHOD
* 
* Description:  SELECT database record for custLoginID passed and fill Customer 
*               Object with that records data
*       @param  String loginID, String password
*******************************************************************************/
    public void loginDB(String loginID, String password)
    {                                       // Load DB Driver and get connection
        System.out.println("\nStarting DB SELECT (LOGIN)...........");
        
        try {                               // attempt database driver load
            Class.forName(DBDRIVER);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(
                    Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
        // attempt database connection and read with resources
        // JVM will Auto-Close connection to DB
        try (Connection con = DriverManager.getConnection(DBDATA)){
                                            // create Statement Object
            Statement stmt = con.createStatement();
            setCustLoginID(loginID);        // set this.custLoginID
            setCustPassword(password);      // set this.custPassword
                                            // create sql string for query
            String sql = "select * from CUSTOMER WHERE CUSTLOGINID = '"+getCustLoginID()+"' AND CUSTPASSWORD = '"+getCustPassword()+"'";
            System.out.println("\t" + sql);
                                            // executeQuery >> ResultSet object
            ResultSet rs = stmt.executeQuery(sql);
            
            // Process Data
            rs.next();                      // set DB cursor to the first result
            // set properties to DB positional record values
            setCustNumber(rs.getString(1));
            setCustType(rs.getString(2));
            setCustLoginID(rs.getString(3));
            setCustPassword(rs.getString(4));
            setCustFirstName(rs.getString(5));
            setCustMidInitial(rs.getString(6));
            setCustLastName(rs.getString(7));
            setCustAddrLine1(rs.getString(8));
            setCustAddrLine2(rs.getString(9));
            setCustCity(rs.getString(10));
            setCustState(rs.getString(11));
            setCustZip(rs.getString(12));
            setCustPhone(rs.getString(13));
            setCustEmail(rs.getString(14));
            setCustBalance(rs.getDouble(15));
        }
        catch(Exception e){                 // catch if database connection 
                                            //               or read failed
            custNotFound = true;            // set custNotFound flag to true
            System.out.println(
                "Database Access Failed for SELECT of CUSTNUMBER: "
                                                + getCustNumber());
            System.out.println("PP: " + e);
        }
        
        if (!(custNotFound)){               // if custNotFound was found
                                            // invoke getPaymentMethods()
            getPaymentMethods();            //  to get associated paymentMethods
                                            // invoke getOrders()
            getOrders();                    //  to get associated Orders        
                                            // invoke getCart()
            getCart();                      //  to get list of Cart Entries 
        }
    } // ******************** END OF loginDB DATABASE ACCESS METHOD ************

/*******************************************************************************
* getPaymentMethods METHOD
*
* Description:  Get list of all paymentMethods for current Customer
*       @param  None
*******************************************************************************/
    public void getPaymentMethods()
    {
        System.out.println("\nStarting getPaymentMethods()...........");
        
        try {                               // attempt database driver load
            Class.forName(DBDRIVER);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(
                    Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
        // attempt database connection and read with resources
        // JVM will Auto-Close connection to DB
        try (Connection con = DriverManager.getConnection(DBDATA)){
                                            // create Statement Object
                Statement stmt = con.createStatement();
                                            // create sql string for query
                String sql = "select * from PAYMENTMETHOD WHERE CUSTNUMBER=" + getCustNumber();
                System.out.println("\t" + sql);
                                            // executeQuery >> ResultSet object
                ResultSet rs = stmt.executeQuery(sql);
        
                // Process Data
                PaymentMethod pm1;          // create work object for each rec
                String custNumberTemp;      // placeholder for custNumber
                String cardNumberTemp;      // placeholder for cardNumber
                while( rs.next()){          // cycle through ResultSet
                                            // set work fields to current data
                    custNumberTemp = rs.getString(1);
                    cardNumberTemp = rs.getString(2);
                                            // instantiate new PaymentMethod
                    pm1 = new PaymentMethod();
                                            // fill with current data from DB
                    pm1.selectDB(custNumberTemp,cardNumberTemp);
                                            // add PaymentMethod object to 
                                            //  paymentMethodList for this
                                            //  Customer
                    paymentMethodList.addPaymentMethod(pm1);
                }
            }
        catch(Exception e){                 // catch if database connection or read failed
                System.out.println("Database Access Failed for SELECT of CUSTNUMBER: " + getCustNumber());
                System.out.println("PP: " + e);
        }        
    } // ******************** END OF getPaymentMethods DATABASE ACCESS METHOD **

/*******************************************************************************
* getOrders METHOD
*
* Description:  Get list of all Orders for current Customer
*       @param  None
*******************************************************************************/
    public void getOrders()
    {
        System.out.println("\nStarting getOrders()...........");
        
        try {                               // attempt database driver load
            Class.forName(DBDRIVER);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(
                    Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
        // attempt database connection and read with resources
        // JVM will Auto-Close connection to DB
        try (Connection con = DriverManager.getConnection(DBDATA)){
                                            // create Statement Object
                Statement stmt = con.createStatement();
                                            // create sql string for query
                String sql = "select * from ORDERDATA WHERE CUSTNUMBER=" + getCustNumber();
                System.out.println("\t" + sql);
                                            // executeQuery >> ResultSet object
                ResultSet rs = stmt.executeQuery(sql);
        
                // Process Data
                Order o1;                   // create work object for each rec
                String custNumberTemp;      // placeholder for custNumber
                String orderNumberTemp;      // placeholder for orderNumber
                String productNumberTemp;   // placeholder for productNumber
                while( rs.next()){          // cycle through ResultSet
                                            // set work fields to current data
                    custNumberTemp = rs.getString(1);
                    orderNumberTemp = rs.getString(2);
                    productNumberTemp = rs.getString(3);
                                            // instantiate new Order
                    o1 = new Order();
                                            // fill with current data from DB
                    o1.selectDB(custNumberTemp,orderNumberTemp,productNumberTemp);
                                            // add Order object to 
                                            //  orderList for this Customer
                    orderList.addOrder(o1);
                }
            }
        catch(Exception e){                 // catch if database connection or read failed
                System.out.println("Database Access Failed for SELECT of CUSTNUMBER: " + getCustNumber());
                System.out.println("PP: " + e);
        }        
    } // ******************** END OF getOrders DATABASE ACCESS METHOD **********

/*******************************************************************************
* getCart METHOD
*
* Description:  Get list of Cart Entries for current Customer
*       @param  None
*******************************************************************************/
    public void getCart()
    {
        System.out.println("\nStarting getCart()...........");
        
        try {                               // attempt database driver load
            Class.forName(DBDRIVER);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(
                    Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
        // attempt database connection and read with resources
        // JVM will Auto-Close connection to DB
        try (Connection con = DriverManager.getConnection(DBDATA)){
                                            // create Statement Object
                Statement stmt = con.createStatement();
                                            // create sql string for query
                String sql = "select * from CART WHERE CUSTNUMBER=" + getCustNumber();
                System.out.println("\t" + sql);
                                            // executeQuery >> ResultSet object
                ResultSet rs = stmt.executeQuery(sql);
        
                // Process Data
                Cart c1;                    // create work object for each rec
                String custNumberTemp;      // placeholder for custNumber
                String productNumberTemp;   // placeholder for productNumber
               while( rs.next()){           // cycle through ResultSet
                                            // set work fields to current data
                    custNumberTemp = rs.getString(1);
                    productNumberTemp = rs.getString(2);
                                            // instantiate new Cart
                    c1 = new Cart();
                                            // fill with current data from DB
                    c1.selectDB(custNumberTemp,productNumberTemp);
                                            // add Cart object to 
                                            //  cartList for this Customer
                    cartList.addCart(c1);
                }
            }
        catch(Exception e){                 // catch if database connection or read failed
                System.out.println("Database Access Failed for SELECT of CUSTNUMBER: " + getCustNumber());
                System.out.println("PP: " + e);
        }        
    } // ******************** END OF getCart DATABASE ACCESS METHOD ************

/*******************************************************************************
* generateCustNumber METHOD
*
* Description:  Generate new CUSTNUMBER before use of insertDB
*               Sets custNumber of current object to new unique CUSTNUMBER
*      @param   None
*******************************************************************************/
    public void generateCustNumber()
    {   
        System.out.println("\nStarting DB generateCustNumber...........");
        
        try {                               // attempt database driver load
            Class.forName(DBDRIVER);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(
                    Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
        // attempt database connection and read with resources
        // JVM will Auto-Close connection to DB
        try (Connection con = DriverManager.getConnection(DBDATA)){
                                            // create Statement Object
            Statement stmt = con.createStatement();
                                            // create sql string for query
            String sql = "SELECT * FROM CUSTOMER WHERE CUSTNUMBER = (SELECT MAX(CUSTNUMBER) FROM CUSTOMER)";
            System.out.println("\t" + sql);
                                            // executeQuery >> ResultSet object
            ResultSet rs = stmt.executeQuery(sql);
            
            // Process Data
            rs.next();                      // set DB cursor to the first result
            // add 1 to last CUSTNUMBER in order to create new unique CUSTNUMBER
            int incrementCustNumber = (Integer.parseInt(rs.getString(1)) + 1);
            setCustNumber(Integer.toString(incrementCustNumber));
        }
        catch(Exception e){                 // catch if database connection 
                                            //               or read failed
            System.out.println(
                "Database Access Failed for SELECT of last CUSTNUMBER");
            System.out.println("PP: " + e);
        } 
    } // ******************** END OF generateCustNumber DATABASE ACCESS METHOD *

/*******************************************************************************
* checkDupUsername METHOD
* 
* Description:  SELECT database record for custLoginID passed and return true or
*               false of whether duplicate username exists
*       @param  String loginID
*******************************************************************************/
    public void checkDupUsername(String loginID)
    {                                       // Load DB Driver and get connection
        System.out.println("\nStarting DB SELECT (LOGINID)...........");
        
        try {                               // attempt database driver load
            Class.forName(DBDRIVER);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(
                    Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
        // attempt database connection and read with resources
        // JVM will Auto-Close connection to DB
        try (Connection con = DriverManager.getConnection(DBDATA)){
                                            // create Statement Object
            Statement stmt = con.createStatement();
            setCustLoginID(loginID);        // set this.custLoginID
                                            // create sql string for query
            String sql = "select * from CUSTOMER WHERE CUSTLOGINID = '"+getCustLoginID()+"'";
            System.out.println("\t" + sql);
                                            // executeQuery >> ResultSet object
            ResultSet rs = stmt.executeQuery(sql);
            
            // Process Data
            usernameExists = rs.next();     // does result set have data
        }
        catch(Exception e){                 // catch if database connection 
                                            //               or read failed
            System.out.println(
                "Database Access Failed for SELECT of CUSTLOGINID: "
                                                + getCustLoginID());
            System.out.println("PP: " + e);
        }
    } // *********** END OF checkDupUsername DATABASE ACCESS METHOD ************

/*******************************************************************************
* insertDB METHOD
*
* Description:  INSERT a new row into DB using data passed
*       @param  custNumber, custType, custLoginID, custPassword, custFirstName, 
*               custMidInitial, custLastName, custAddrLine1, custAddrLine2,
*               custCity, custState, custZip, custPhone, custEmail, custBalance
*******************************************************************************/
    public void insertDB(String newCustNumber, String newCustType, 
                    String newCustLoginID, String newCustPassword, 
                    String newCustFirstName, String newCustMidInitial,
                    String newCustLastName, String newCustAddrLine1,
                    String newCustAddrLine2, String newCustCity,
                    String newCustState, String newCustZip,
                    String newCustPhone, String newCustEmail, 
                    double newCustBalance)
    {   
        System.out.println("\nStarting DB INSERT...........");
        
        try {                               // attempt database driver load
            Class.forName(DBDRIVER);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(
                    Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
        // attempt database connection and read with resources
        // JVM will Auto-Close connection to DB
        try (Connection con = DriverManager.getConnection(DBDATA)){
                                            // create Statement Object
            Statement stmt = con.createStatement();
            // set properties for current object to new passed values
            setCustNumber(newCustNumber);
            setCustType(newCustType);
            setCustLoginID(newCustLoginID);
            setCustPassword(newCustPassword);
            setCustFirstName(newCustFirstName);
            setCustMidInitial(newCustMidInitial);
            setCustLastName(newCustLastName);
            setCustAddrLine1(newCustAddrLine1);
            setCustAddrLine2(newCustAddrLine2);
            setCustCity(newCustCity);
            setCustState(newCustState);
            setCustZip(newCustZip);
            setCustPhone(newCustPhone);
            setCustEmail(newCustEmail);
            setCustBalance(newCustBalance);
                                            // create sql string for query
            String sql = "INSERT INTO CUSTOMER(CUSTNUMBER,CUSTOMERTYPE,CUSTLOGINID,CUSTPASSWORD,CUSTFIRSTNAME,CUSTMIDINITIAL,CUSTLASTNAME,CUSTADDRLINE1,CUSTADDRLINE2,CUSTCITY,CUSTSTATE,CUSTZIP,CUSTPHONE,CUSTEMAIL,CUSTBALANCE)"
                            + " VALUES('"+newCustNumber+"','"+newCustType+"','"+newCustLoginID+"','"+newCustPassword+"','"+newCustFirstName+"','"+newCustMidInitial+"','"+newCustLastName+"','"+newCustAddrLine1+"','"+newCustAddrLine2+"','"+newCustCity+"','"+newCustState+"','"+newCustZip+"','"+newCustPhone+"','"+newCustEmail+"',"+newCustBalance+")";
            System.out.println("\t" + sql);
            // executeUpdate:INSERT Customer Object Data into Table
            int n = stmt.executeUpdate(sql);
            if ( n == 1)                    // if 1, INSERT successful
                System.out.println("\n\tINSERT Successful.");
            else                            // if not 1, INSERT failed
                System.out.println("\n\tINSERT Failed.");
    } 
    catch (SQLException e)                  // catch any DB Access/SQL errors
    {   System.out.println("\n\t***Database Access Failed for INSERT into CUSTOMER Table for custNumber: " + getCustNumber() + "***\n");
            System.out.println("PP: " + e);
    }
} // ******************** END OF insertDB DATABASE ACCESS METHOD ***************

/*******************************************************************************
* updateDB METHOD
*
* Description:  UPDATE SELECTed record with Customer Object data. Updates all 
*               fields except custNumber and custType.
*       @param  None
*******************************************************************************/
    public void updateDB()
    {   
        System.out.println("\nStarting DB UPDATE...........");
        
        try {                               // attempt database driver load
            Class.forName(DBDRIVER);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(
                    Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
        // attempt database connection and read with resources
        // JVM will Auto-Close connection to DB
        try (Connection con = DriverManager.getConnection(DBDATA)){
                                            // create Statement Object
            Statement stmt = con.createStatement();
                                            // create sql string
            String sql = "UPDATE CUSTOMER SET CUSTLOGINID = '"+getCustLoginID()+"',CUSTPASSWORD = '"+getCustPassword()+"',CUSTFIRSTNAME = '"+getCustFirstName()+"',CUSTMIDINITIAL = '"+getCustMidInitial()+"',CUSTLASTNAME = '"+getCustLastName()+"',CUSTADDRLINE1 = '"+getCustAddrLine1()+"',CUSTADDRLINE2 = '"+getCustAddrLine2()+"',CUSTCITY = '"+getCustCity()+"',CUSTSTATE = '"+getCustState()+"',CUSTZIP = '"+getCustZip()+"',CUSTPHONE = '"+getCustPhone()+"',CUSTEMAIL = '"+getCustEmail()+"',CUSTBALANCE = '"+getCustBalance()+"' WHERE CUSTNUMBER = '"+getCustNumber()+"'";
            System.out.println("\t" + sql);
            // executeUpdate:UPDATE row data in Customer Table
            int n = stmt.executeUpdate(sql);
            if ( n == 1)                    // if 1, UPDATE successful
                System.out.println("\n\tUPDATE Successful.");
            else                            // if not 1, UPDATE failed
                System.out.println("\n\tUPDATE Failed.");
            } 
        catch (SQLException e)              // catch any DB Access/SQL errors
        {   System.out.println("\n\t***Database Access Failed during UPDATE of Customer Table for custNumber: " + getCustNumber() + "***\n");
            System.out.println("PP: " + e);
        }
    } // ******************** END OF updateDB DATABASE ACCESS METHOD ***********

/*******************************************************************************
* deleteDB METHOD
*
* Description:  DELETE SELECTed record from DB
*      @param   None
*******************************************************************************/
    public void deleteDB()
    {   
        System.out.println("\nStarting DB DELETE...........");
        
        try {                               // attempt database driver load
            Class.forName(DBDRIVER);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(
                    Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
        // attempt database connection and read with resources
        // JVM will Auto-Close connection to DB
        try (Connection con = DriverManager.getConnection(DBDATA)) {
            Statement stmt = con.createStatement();
                                            // create sql string
            String sql = "DELETE from CUSTOMER WHERE CUSTNUMBER = '"+getCustNumber()+"'";
            System.out.println("\t" + sql);
            // executeUpdate:DELETE row data based on sql criteria
            int n = stmt.executeUpdate(sql);
            if ( n == 1)                    // if 1, DELETE successful
                System.out.println("\n\tDELETE Successful.");
            else                            // if not 1, DELETE failed
                System.out.println("\n\tDELETE Failed.");
    } 
    catch (SQLException e)                  // catch any DB Access/SQL errors
    {   System.out.println("\n\t***Database Access Failed during DELETE of Customer Table for custNumber: " + getCustNumber() + "***\n");
            System.out.println("PP: " + e);
    }
    } // ******************** END OF deleteDB DATABASE ACCESS METHOD ***********

/*******************************************************************************
* show METHOD - Display general current object information
*******************************************************************************/
    public void show()
    {   System.out.println("\n\t     custNumber: " + getCustNumber()
            + "\n\t   customerType: " + getCustType() 
            + "\n\t    custLoginID: " + getCustLoginID() 
            + "\n\t   custPassword: " + getCustPassword() 
            + "\n\t  custFirstName: " + getCustFirstName()
            + "\n\t custMidInitial: " + getCustMidInitial()
            + "\n\t   custLastName: " + getCustLastName()
            + "\n\t  custAddrLine1: " + getCustAddrLine1()
            + "\n\t  custAddrLine2: " + getCustAddrLine2()
            + "\n\t       custCity: " + getCustCity()
            + "\n\t      custState: " + getCustState()
            + "\n\t        custZip: " + getCustZip()
            + "\n\t      custPhone: " + getCustPhone()
            + "\n\t      custEmail: " + getCustEmail()
            + "\n\t    custBalance: " + getCustBalance() );
        paymentMethodList.show();           // display all PaymentMethod(s)
        orderList.show();                   // display all Order(s)
        cartList.show();                    // display all Cart Entries
    }

/*******************************************************************************
* MAIN METHOD - for TESTING purposes
* @param args
*******************************************************************************/
    public static void main(String[] args)
    {   
        System.out.println("\n***********************************************");
        System.out.println("*** SELECT TEST on TeamOneSportingGoodsACCDB");
        System.out.println("*************************************************");

        Customer c1 = new Customer();       // Create Customer Object c1
        c1.selectDB("1000001");             // SELECT record from DB
        c1.show();                          // Display data SELECTed from DB

        System.out.println("\n***********************************************");
        System.out.println("*** INSERT TEST on TeamOneSportingGoodsACCDB");
        System.out.println("*************************************************");

        Customer c2 = new Customer();       // Create Customer Object c2
                                            // INSERT record into DB
        c2.insertDB("1000003", "A", "testC", "passwordC", "TestC", "C", "DataC", "2 Circle Circle", "APT 210", "Acworth", "GA", "30101", "6785553333", "testC@yahoo.com", 25.25);
        c2.selectDB("1000003");             // SELECT record from DB
        c2.show();                          // Display data INSERTed into DB

        System.out.println("\n***********************************************");
        System.out.println("*** UPDATE TEST on TeamOneSportingGoodsACCDB");
        System.out.println("*************************************************");

        Customer c3 = new Customer ();      // Create Customer Object c3
        c3.selectDB("1000003");             // SELECT record to UPDATE in DB
        c3.show();                          // Display record data BEFORE UPDATE
                                            // change multiple fields
        c3.setCustMidInitial("Z");
        c3.setCustAddrLine2("APT 999");
        c3.setCustBalance(33.33);
        c3.updateDB();                      // UPDATE record with new c3 data
        c3.show();                          // Display record data AFTER UPDATE

        System.out.println("\n***********************************************");
        System.out.println("*** DELETE TEST on TeamOneSportingGoodsACCDB");
        System.out.println("*************************************************");

        Customer c4 = new Customer();       // Create Customer Object c4
        c4.selectDB("1000003");             // SELECT record from DB
        c4.deleteDB();                      // DELETE current SELECTed record

        System.out.println("\n***********************************************");
        System.out.println("*** LIST TEST on TeamOneSportingGoodsACCDB");
        System.out.println("*************************************************");

        Customer c5 = new Customer();       // Create Customer Object c5
        c5.selectDB("1000002");             // SELECT record from DB
                                            // Display data SELECTed from DB
                                            //  and all associated
                                            //  PaymentMethod(s),Order(s) & Cart
        c5.show();                         

        System.out.println("\n***********************************************");
        System.out.println("*** GENERATE TEST on TeamOneSportingGoodsACCDB");
        System.out.println("*************************************************");

        Customer c6 = new Customer();       // Create Customer Object c6
        c6.generateCustNumber();
        String newCustNumber = c6.getCustNumber();
        c6.insertDB(newCustNumber, "A", "testC", "passwordC", "TestC", "C", "DataC", "2 Circle Circle", "APT 210", "Acworth", "GA", "30101", "6785553333", "testC@yahoo.com", 25.25);
        c6.selectDB(newCustNumber);         // SELECT record from DB
        c6.show();                          // Display data INSERTed into DB

        System.out.println("\n***********************************************");
        System.out.println("*** LOGIN TEST on TeamOneSportingGoodsACCDB");
        System.out.println("*************************************************");     
        Customer c7 = new Customer();       // Create Customer Object c7
        c7.loginDB("testB","passwordB");
        c7.show();                          // Display Customer Object Data        

    }
}
