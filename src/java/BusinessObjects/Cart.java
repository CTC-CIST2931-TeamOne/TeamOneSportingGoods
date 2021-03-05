/*******************************************************************************
* Class: CIST 2931 Advanced Systems Project
* Semester: Fall 2020
* Instructor: Ronald Enz
* Description:  Cart Object for TeamOneSportingGoods Project
* Due: 08/30/2020
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
* Class Cart - Business Object with DB Access Methods
*******************************************************************************/
public class Cart {

/*******************************************************************************
* OBJECT PROPERTIES - Declare/Initialize object variables & CONSTANTS
*******************************************************************************/
    private String  custNumber         = " ";
    private String  productNumber      = " ";
    private int     quantity           = 0;
    private String  productSize        = " ";
    private String  productGender      = " ";
                                            // Database Driver
    final private String DBDRIVER = "net.ucanaccess.jdbc.UcanaccessDriver";
                                            // Database Link and Data
    final private String DBDATA = 
             "jdbc:ucanaccess://C:/DBData/TeamOneSportingGoodsACCDB.accdb";

/*******************************************************************************
* CONSTRUCTORS 
*******************************************************************************/
    // no-arg constructor to create Cart with default values
    public Cart()
    {   custNumber          = " ";
        productNumber       = " ";
        quantity            = 0;
        productSize         = " ";
        productGender       = " ";
    } // ******************** END OF Cart no-arg CONSTRUCTOR **********

    // multi-arg constructor to create Cart with passed values
    public Cart(String newCustNumber, String newProductNumber, int newQuantity,
                String newProductSize, String newProductGender)
    {   this.custNumber         = newCustNumber;
        this.productNumber      = newProductNumber;
        this.quantity           = newQuantity;
        this.productSize        = newProductSize;
        this.productGender      = newProductGender;
    } // ****************** END OF Cart multi-arg CONSTRUCTOR *********

/*******************************************************************************
* ACCESSOR METHODS - Getters 
* @return 
*******************************************************************************/
    public String getCustNumber()           // retrieve & return custNumber
    {   return this.custNumber;
    } // ******************** END OF getCustNumber ACCESSOR ********************

    public String getProductNumber()        // retrieve & return productNumber
    {   return this.productNumber;
    } // ******************** END OF getProductNumber ACCESSOR *****************

    public int getQuantity()                // retrieve & return quantity
    {   return this.quantity;
    } // ******************** END OF getQuantity ACCESSOR **********************

    public String getProductSize()          // retrieve & return productSize
    {   return this.productSize;
    } // ******************** END OF getProductSize ACCESSOR *******************

    public String getProductGender()        // retrieve & return productGender
    {   return this.productGender;
    } // ******************** END OF getProductGender ACCESSOR *****************
   
/*******************************************************************************
* MUTATOR METHODS - Setters
*******************************************************************************/
                                            // set custNumber to value passed
    public void setCustNumber(String custNumberPassed)
    {   this.custNumber = custNumberPassed;
    } // ******************** END OF setCustNumber MUTATOR *********************

                                            // set productNumber to value passed
    public void setProductNumber(String productNumberPassed)
    {   this.productNumber = productNumberPassed;
    } // ******************** END OF setProductNumber MUTATOR ******************

                                            // set quantity to value passed
    public void setQuantity(int quantityPassed)
    {   this.quantity = quantityPassed;
    } // ******************** END OF setQuantity MUTATOR ***********************

                                            // set productSize to value passed
    public void setProductSize(String productSizePassed)
    {   this.productSize = productSizePassed;
    } // ******************** END OF setProductSize MUTATOR ********************

                                            // set productGender to value passed
    public void setProductGender(String productGenderPassed)
    {   this.productGender = productGenderPassed;
    } // ******************** END OF setProductGender MUTATOR ******************

/*******************************************************************************
* DATABASE ACCESS METHODS
*******************************************************************************/
/*******************************************************************************
* selectDB METHOD
* 
* Description:  SELECT database record for custNumber+productNumber
*               passed and fill Cart Object with that record's data
*       @param  keyCustNumber, keyProductNumber
*******************************************************************************/
    public void selectDB(String keyCustNumber, String keyProductNumber)
    {                                       // Load DB Driver and get connection
        System.out.println("\nStarting DB SELECT...........");
        
        try {                               // attempt database driver load
            Class.forName(DBDRIVER);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(
                    Cart.class.getName()).log(Level.SEVERE, null, ex);
        }
        // attempt database connection and read with resources
        // JVM will Auto-Close connection to DB
        try (Connection con = DriverManager.getConnection(DBDATA)){
                                            // create Statement Object
            Statement stmt = con.createStatement();
            setCustNumber(keyCustNumber);   // set this.custNumber
                                            // set this.productNumber 
            setProductNumber(keyProductNumber);           
                                            // create sql string for query
            String sql = "select * from CART WHERE CUSTNUMBER=" 
                            + getCustNumber() + " AND PRODUCTNUMBER="
                            + getProductNumber();
            System.out.println("\t" + sql);
                                            // executeQuery >> ResultSet object
            ResultSet rs = stmt.executeQuery(sql);
            
            // Process Data
            rs.next();                      // set DB cursor to the first result
            // set properties to DB positional record values
            setCustNumber(rs.getString(1));
            setProductNumber(rs.getString(2));
            setQuantity(rs.getInt(3));
            setProductSize(rs.getString(4));
            setProductGender(rs.getString(5));
        }
        catch(Exception e){                 // catch if database connection 
                                            //               or read failed
            System.out.println(
                "Database Access Failed for SELECT of CUSTNUMBER: "
                + getCustNumber() + " PRODUCTNUMBER: " + getProductNumber());
            System.out.println("PP: " + e);
        }
    } // ******************** END OF selectDB DATABASE ACCESS METHOD ***********
    
/*******************************************************************************
* insertDB METHOD
*
* Description:  INSERT a new row into DB using data passed
*       @param  custNumber, productNumber, quantity
*******************************************************************************/
    public void insertDB(String newCustNumber, String newProductNumber, 
                    int newQuantity, String newProductSize, 
                    String newProductGender)
    {   
        System.out.println("\nStarting DB INSERT...........");
        
        try {                               // attempt database driver load
            Class.forName(DBDRIVER);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(
                    Cart.class.getName()).log(Level.SEVERE, null, ex);
        }
        // attempt database connection and read with resources
        // JVM will Auto-Close connection to DB
        try (Connection con = DriverManager.getConnection(DBDATA)){
                                            // create Statement Object
            Statement stmt = con.createStatement();
            // set properties for current object to new passed values
            setCustNumber(newCustNumber);
            setProductNumber(newProductNumber);
            setQuantity(newQuantity);
            setProductSize(newProductSize);
            setProductGender(newProductGender);
                                            // create sql string for query
            String sql = "INSERT INTO CART(CUSTNUMBER,PRODUCTNUMBER,QUANTITY,PRODUCTSIZE,PRODUCTGENDER)"
                            + " VALUES('"+newCustNumber+"','"+newProductNumber+"',"+newQuantity+",'"+newProductSize+"','"+newProductGender+"')";
            System.out.println("\t" + sql);
            // executeUpdate:INSERT Cart Object Data into Table
            int n = stmt.executeUpdate(sql);
            if ( n == 1)                    // if 1, INSERT successful
                System.out.println("\n\tINSERT Successful.");
            else                            // if not 1, INSERT failed
                System.out.println("\n\tINSERT Failed.");
    } 
    catch (SQLException e)                  // catch any DB Access/SQL errors
    {   System.out.println("\n\t***Database Access Failed for INSERT into CART Table for custNumber: " + getCustNumber() + " productNumber: " + getProductNumber() + "***\n");
            System.out.println("PP: " + e);
    }
} // ******************** END OF insertDB DATABASE ACCESS METHOD ***************

/*******************************************************************************
* updateDB METHOD
*
* Description:  UPDATE SELECTed record with Cart Object data. Updates 
*               Quantity field.
*       @param  None
*******************************************************************************/
    public void updateDB()
    {   
        System.out.println("\nStarting DB UPDATE...........");
        
        try {                               // attempt database driver load
            Class.forName(DBDRIVER);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(
                    Cart.class.getName()).log(Level.SEVERE, null, ex);
        }
        // attempt database connection and read with resources
        // JVM will Auto-Close connection to DB
        try (Connection con = DriverManager.getConnection(DBDATA)){
                                            // create Statement Object
            Statement stmt = con.createStatement();
                                            // create sql string
            String sql = "UPDATE CART SET QUANTITY = '"+getQuantity()+"',PRODUCTSIZE = '"+getProductSize()+"',PRODUCTGENDER = '"+getProductGender()+"' WHERE CUSTNUMBER = '"+getCustNumber()+"' AND PRODUCTNUMBER = '"+getProductNumber()+"'";
            System.out.println("\t" + sql);
            // executeUpdate:UPDATE row data in Cart Table
            int n = stmt.executeUpdate(sql);
            if ( n == 1)                    // if 1, UPDATE successful
                System.out.println("\n\tUPDATE Successful.");
            else                            // if not 1, UPDATE failed
                System.out.println("\n\tUPDATE Failed.");
            } 
        catch (SQLException e)              // catch any DB Access/SQL errors
        {   System.out.println("\n\t***Database Access Failed during UPDATE of CART Table for custNumber: " + getCustNumber() + " productNumber: " + getProductNumber() + "***\n");
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
                    Cart.class.getName()).log(Level.SEVERE, null, ex);
        }
        // attempt database connection and read with resources
        // JVM will Auto-Close connection to DB
        try (Connection con = DriverManager.getConnection(DBDATA)) {
            Statement stmt = con.createStatement();
                                            // create sql string
            String sql = "DELETE from CART WHERE CUSTNUMBER = '"+getCustNumber()+"' AND PRODUCTNUMBER = '"+getProductNumber()+"'";
            System.out.println("\t" + sql);
            // executeUpdate:DELETE row data based on sql criteria
            int n = stmt.executeUpdate(sql);
            if ( n == 1)                    // if 1, DELETE successful
                System.out.println("\n\tDELETE Successful.");
            else                            // if not 1, DELETE failed
                System.out.println("\n\tDELETE Failed.");
    } 
    catch (SQLException e)                  // catch any DB Access/SQL errors
    {   System.out.println("\n\t***Database Access Failed during DELETE of CART Table for custNumber: " + getCustNumber() + " productNumber: " + getProductNumber() + "***\n");
            System.out.println("PP: " + e);
    }
    } // ******************** END OF deleteDB DATABASE ACCESS METHOD ***********

/*******************************************************************************
* show METHOD - Display general current object information
*******************************************************************************/
    public void show()
    {   System.out.println("\n\t       custNumber: " + getCustNumber()
            + "\n\t    productNumber: " + getProductNumber()
            + "\n\t         quantity: " + getQuantity()
            + "\n\t      productSize: " + getProductSize()
            + "\n\t    productGender: " + getProductGender()
            );
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
                                            // Create Cart Object c1
        Cart c1 = new Cart();
                                            // SELECT record from DB
        c1.selectDB("1000002","876543210");
        c1.show();                          // Display data SELECTed from DB

        System.out.println("\n***********************************************");
        System.out.println("*** INSERT TEST on TeamOneSportingGoodsACCDB");
        System.out.println("*************************************************");
                                            // Create Cart Object c2
        Cart c2 = new Cart();
                                            // INSERT record into DB
        c2.insertDB("1000001", "987654321", 20, "LARGE","K");
                                            // SELECT record from DB
        c2.selectDB("1000001", "987654321");
        c2.show();                          // Display data INSERTed into DB

        System.out.println("\n***********************************************");
        System.out.println("*** UPDATE TEST on TeamOneSportingGoodsACCDB");
        System.out.println("*************************************************");
                                            // Create Cart Object c3
        Cart c3 = new Cart ();
                                            // SELECT record to UPDATE in DB
        c3.selectDB("1000001","987654321");
        c3.show();                          // Display record data BEFORE UPDATE
                                            // change multiple fields
        c3.setQuantity(5);
        c3.setProductGender("N");
        c3.updateDB();                      // UPDATE record with new c3 data
        c3.show();                          // Display record data AFTER UPDATE
/*
        System.out.println("\n***********************************************");
        System.out.println("*** DELETE TEST on TeamOneSportingGoodsACCDB");
        System.out.println("*************************************************");
                                            // Create Cart Object c4
        Cart c4 = new Cart();
                                            // SELECT record to UPDATE in DB
        c4.selectDB("1000002","987654333");
        c4.deleteDB();                      // DELETE current SELECTed record
*/
    }
}
