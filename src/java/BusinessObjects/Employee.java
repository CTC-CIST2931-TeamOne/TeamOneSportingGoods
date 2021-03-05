/*******************************************************************************
* Class: CIST 2931 Advanced Systems Project
* Semester: Fall 2020
* Instructor: Ronald Enz
* Description:  Employee Object for TeamOneSportingGoods Project
* Due: 08/29/2020
* @author William G. Weldy & Ian Mashburn
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
* Class Employee - Business Object with DB Access Methods
*******************************************************************************/
public class Employee {

/*******************************************************************************
* OBJECT PROPERTIES - Declare/Initialize object variables & CONSTANTS
*******************************************************************************/
    private String  empNumber       = " ";
    private String  empLoginID      = " ";
    private String  empPassword     = " ";
    private String  empFirstName    = " ";
    private String  empLastName     = " ";
    public  boolean empNotFound     = false;// Initialize empNotFound to false
                                            // Init orderList Object
    public  OrderList orderList = new OrderList();
                                            // Database Driver
    final private String DBDRIVER = "net.ucanaccess.jdbc.UcanaccessDriver";
                                            // Database Link and Data
    final private String DBDATA = 
             "jdbc:ucanaccess://C:/DBData/TeamOneSportingGoodsACCDB.accdb";

/*******************************************************************************
* CONSTRUCTORS 
*******************************************************************************/
    // no-arg constructor to create Employee with default values
    public Employee()
    {   empNumber       = " ";
        empLoginID      = " ";
        empPassword     = " ";
        empFirstName    = " ";
        empLastName     = " ";

    } // ******************** END OF Employee no-arg CONSTRUCTOR ***************

    // multi-arg constructor to create Employee with passed values
    public Employee(String newEmpNumber, String newEmpLoginID, 
                    String newEmpPassword , String newEmpFirstName,
                    String newEmpLastName)
    {   this.empNumber      = newEmpNumber;
        this.empLoginID     = newEmpLoginID;
        this.empPassword    = newEmpPassword;
        this.empFirstName   = newEmpFirstName;
        this.empLastName    = newEmpLastName;
    } // ****************** END OF Employee multi-arg CONSTRUCTOR **************

/*******************************************************************************
* ACCESSOR METHODS - Getters 
* @return 
*******************************************************************************/
    public String getEmpNumber()            // retrieve & return empNumber
    {   return this.empNumber;
    } // ******************** END OF getEmpNumber ACCESSOR *********************

    public String getEmpLoginID()           // retrieve & return empLoginID
    {   return this.empLoginID;
    } // ******************** END OF getEmpLoginID ACCESSOR ********************

    public String getEmpPassword()          // retrieve & return empPassword
    {   return this.empPassword;
    } // ******************** END OF getEmpPassword ACCESSOR *******************

    public String getEmpFirstName()         // retrieve & return empFirstName
    {   return this.empFirstName;
    } // ******************** END OF getEmpFirstName ACCESSOR ******************

    public String getEmpLastName()          // retrieve &return empLastName
    {   return this.empLastName;
    } // ******************** END OF getEmpLastName ACCESSOR *******************
    
/*******************************************************************************
* MUTATOR METHODS - Setters
*******************************************************************************/
                                            // set empNumber to value passed
    public void setEmpNumber(String empNumberPassed)
    {   this.empNumber = empNumberPassed;
    } // ******************** END OF setEmpNumber MUTATOR **********************

                                            // set empLoginID to value passed
    public void setEmpLoginID(String empLoginIDPassed)
    {   this.empLoginID = empLoginIDPassed;
    } // ******************** END OF setEmpLoginID MUTATOR *********************

                                            // set empPassword to value passed
    public void setEmpPassword(String empPasswordPassed)
    {   this.empPassword = empPasswordPassed;
    } // ******************** END OF setEmpPassword MUTATOR ********************

                                            // set empFirstName to passed
    public void setEmpFirstName(String empFirstNamePassed)
    {   this.empFirstName = empFirstNamePassed;
    } // ******************** END OF setEmpFirstName MUTATOR *******************

                                            // set empLastName to passed
    public void setEmpLastName(String empLastNamePassed)
    {   this.empLastName = empLastNamePassed;
    } // ******************** END OF setEmpLastName MUTATOR ********************

/*******************************************************************************
* DATABASE ACCESS METHODS
*******************************************************************************/
/*******************************************************************************
* selectDB METHOD
* 
* Description:  SELECT database record for empNumber passed and fill  
*               Employee Object with that record's data
*       @param  keyEmpNumber
*******************************************************************************/
    public void selectDB(String keyEmpNumber)
    {                                       // Load DB Driver and get connection
        System.out.println("\nStarting DB SELECT...........");
        
        try {                               // attempt database driver load
            Class.forName(DBDRIVER);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(
                    Employee.class.getName()).log(Level.SEVERE, null, ex);
        }
        // attempt database connection and read with resources
        // JVM will Auto-Close connection to DB
        try (Connection con = DriverManager.getConnection(DBDATA)){
                                            // create Statement Object
            Statement stmt = con.createStatement();
                                            // set this.empNumber
            setEmpNumber(keyEmpNumber);
                                            // create sql string for query
            String sql = "select * from EMPLOYEE WHERE EMPNUMBER=" 
                            + getEmpNumber();
            System.out.println("\t" + sql);
                                            // executeQuery >> ResultSet object
            ResultSet rs = stmt.executeQuery(sql);
            
            // Process Data
            rs.next();                      // set DB cursor to the first result
            // set properties to DB positional record values
            setEmpNumber(rs.getString(1));
            setEmpLoginID(rs.getString(2));
            setEmpPassword(rs.getString(3));
            setEmpFirstName(rs.getString(4));
            setEmpLastName(rs.getString(5));
        }
        catch(Exception e){                 // catch if database connection 
                                            //               or read failed
            empNotFound = true;             // set empNotFound flag to true
            System.out.println(
                "Database Access Failed for SELECT of EMPNUMBER: "
                                                + getEmpNumber());
            System.out.println("PP: " + e);
        }
    } // ******************** END OF selectDB DATABASE ACCESS METHOD ***********

/*******************************************************************************
* loginDB METHOD
* 
* Description:  SELECT database record for empLoginID passed and fill Employee 
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
            setEmpLoginID(loginID);         // set this.empLoginID
            setEmpPassword(password);       // set this.empPassword
                                            // create sql string for query
            String sql = "select * from EMPLOYEE WHERE EMPLOGINID = '"+getEmpLoginID()+"' AND EMPPASSWORD = '"+getEmpPassword()+"'";
            System.out.println("\t" + sql);
                                            // executeQuery >> ResultSet object
            ResultSet rs = stmt.executeQuery(sql);
            
            // Process Data
            rs.next();                      // set DB cursor to the first result
            // set properties to DB positional record values
            setEmpNumber(rs.getString(1));
            setEmpLoginID(rs.getString(2));
            setEmpPassword(rs.getString(3));
            setEmpFirstName(rs.getString(4));
            setEmpLastName(rs.getString(5));
        }
        catch(Exception e){                 // catch if database connection 
                                            //               or read failed
            empNotFound = true;             // set empNotFound flag to true
            System.out.println(
                "Database Access Failed for SELECT of EMPNUMBER: "
                                                + getEmpNumber());
            System.out.println("PP: " + e);
        }
        if (!(empNotFound)){                // if empNotFound was found
                                            // invoke getOrders()
            getOrders();                    //  to get all Orders from DB        
        }
    } // ******************** END OF loginDB DATABASE ACCESS METHOD ************

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
                    Employee.class.getName()).log(Level.SEVERE, null, ex);
        }
        // attempt database connection and read with resources
        // JVM will Auto-Close connection to DB
        try (Connection con = DriverManager.getConnection(DBDATA)){
                                            // create Statement Object
                Statement stmt = con.createStatement();
                                            // create sql string for query
                String sql = "select * from ORDERDATA";
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
                System.out.println("Database Access Failed for SELECT of *: " + getEmpNumber());
                System.out.println("PP: " + e);
        }        
    } // ******************** END OF getOrders DATABASE ACCESS METHOD **********

/*******************************************************************************
* show METHOD - Display general current object information
*******************************************************************************/
    public void show()
    {   System.out.println("\n\t       empNumber: " + getEmpNumber()
            + "\n\t      empLoginID: " + getEmpLoginID()
            + "\n\t     empPassword: " + getEmpPassword()           
            + "\n\t    empFirstName: " + getEmpFirstName()
            + "\n\t     empLastName: " + getEmpLastName());
        orderList.show();                   // display all Order(s)
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
                                            // Create Employee Object e1
        Employee e1 = new Employee();
                                            // SELECT record from DB
        e1.selectDB("76543");
        e1.show();                          // Display data SELECTed from DB

        System.out.println("\n***********************************************");
        System.out.println("*** LOGIN TEST on TeamOneSportingGoodsACCDB");
        System.out.println("*************************************************");
                                            // Create Employee Object e2
        Employee e2 = new Employee();
                                            // SELECT record from DB
        e2.loginDB("EMPTEST","PasswordTest");
        e2.show();                          // Display data SELECTed from DB
    }
}
