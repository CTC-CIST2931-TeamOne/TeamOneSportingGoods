/*******************************************************************************
* Class: CIST 2931 Advanced Systems Project
* Semester: Fall 2020
* Instructor: Ronald Enz
* Description:  Order Object for TeamOneSportingGoods Project
* Due: 08/29/2020
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
* Class Order - Business Object with DB Access Methods
*
* NOTES:    Each product purchase creates and ORDERDATA Table record.
*******************************************************************************/
public class Order {

/*******************************************************************************
* OBJECT PROPERTIES - Declare/Initialize object variables & CONSTANTS
*******************************************************************************/
    private String  custNumber          = " ";
    private String  orderNumber         = " ";
    private String  productNumber       = " ";
    private int     quantity            = 0;
    private String  orderDate           = " ";
    private String  orderTime           = " ";  
    private String  orderStatus         = " ";
    private double  orderAmount         = 0.0;
    private double  orderSalesTax       = 0.0;
    private double  orderShippingCost   = 0.0;
    private double  orderTotal          = 0.0;
    private double  orderBalance        = 0.0;
    private String  productSize         = " ";
    private String  productGender       = " ";
                                            // Init productList Object
    public ProductList productList = new ProductList();

                                            // Database Driver
    final private String DBDRIVER = "net.ucanaccess.jdbc.UcanaccessDriver";
                                            // Database Link and Data
    final private String DBDATA = 
             "jdbc:ucanaccess://C:/DBData/TeamOneSportingGoodsACCDB.accdb";

/*******************************************************************************
* CONSTRUCTORS 
*******************************************************************************/
    // no-arg constructor to create Order with default values
    public Order()
    {   custNumber          = " ";
        orderNumber         = " ";
        productNumber       = " ";
        quantity            = 0;
        orderDate           = " ";
        orderTime           = " ";  
        orderStatus         = " ";
        orderAmount         = 0.0;
        orderSalesTax       = 0.0;
        orderShippingCost   = 0.0;
        orderTotal          = 0.0;
        orderBalance        = 0.0;
        productSize         = " ";
        productGender       = " ";
    } // ******************** END OF Order no-arg CONSTRUCTOR **********

    // multi-arg constructor to create Order with passed values
    public Order(String newCustNumber, String newOrderNumber, 
                    String newProductNumber, int newQuantity,
                    String newOrderDate, String newOrderTime,
                    String newOrderStatus, double newOrderAmount,
                    double newOrderSalesTax, double newOrderShippingCost,
                    double newOrderTotal, double newOrderBalance,
                    String newProductSize, String newProductGender)
    {   this.custNumber         = newCustNumber;
        this.orderNumber        = newOrderNumber;
        this.productNumber      = newProductNumber;
        this.quantity           = newQuantity;
        this.orderDate          = newOrderDate;
        this.orderTime          = newOrderTime;
        this.orderStatus        = newOrderStatus;
        this.orderAmount        = newOrderAmount;
        this.orderSalesTax      = newOrderSalesTax;
        this.orderShippingCost  = newOrderShippingCost;
        this.orderTotal         = newOrderTotal;
        this.orderBalance       = newOrderBalance;
        this.productSize        = newProductSize;
        this.productGender      = newProductGender;
    } // ****************** END OF Order multi-arg CONSTRUCTOR *********

/*******************************************************************************
* ACCESSOR METHODS - Getters 
* @return 
*******************************************************************************/
    public String getCustNumber()           // retrieve & return custNumber
    {   return this.custNumber;
    } // ******************** END OF getCustNumber ACCESSOR ********************

    public String getOrderNumber()          // retrieve & return orderNumber
    {   return this.orderNumber;
    } // ******************** END OF getOrderNumber ACCESSOR *******************

    public String getProductNumber()        // retrieve & return productNumber
    {   return this.productNumber;
    } // ******************** END OF getProductNumber ACCESSOR *****************

    public int getQuantity()                // retrieve & return quantity
    {   return this.quantity;
    } // ******************** END OF getQuantity ACCESSOR **********************

    public String getOrderDate()            // retrieve & return orderDate
    {   return this.orderDate;
    } // ******************** END OF getOrderDate ACCESSOR *********************

    public String getOrderTime()            // retrieve & return orderTime
    {   return this.orderTime;
    } // ******************** END OF getOrderTime ACCESSOR *********************

    public String getOrderStatus()          // retrieve & return orderStatus
    {   return this.orderStatus;
    } // ******************** END OF getOrderStatus ACCESSOR *******************

    public double getOrderAmount()          // retrieve & return orderAmount
    {   return this.orderAmount;
    } // ******************** END OF getOrderAmount ACCESSOR *******************

    public double getOrderSalesTax()        // retrieve & return orderSalesTax
    {   return this.orderSalesTax;
    } // ******************** END OF getOrderSalesTax ACCESSOR *****************

    public double getOrderShippingCost()    // retrieve&return orderShippingCost
    {   return this.orderShippingCost;
    } // ******************** END OF getBillAddrLine2 ACCESSOR *****************

    public double getOrderTotal()           // retrieve & return orderTotal
    {   return this.orderTotal;
    } // ******************** END OF getOrderTotal ACCESSOR ********************

    public double getOrderBalance()         // retrieve & return orderBalance
    {   return this.orderBalance;
    } // ******************** END OF getOrderBalance ACCESSOR ******************

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

                                            // set orderNumber to value passed
    public void setOrderNumber(String orderNumberPassed)
    {   this.orderNumber = orderNumberPassed;
    } // ******************** END OF setOrderNumber MUTATOR ********************

                                            // set productNumber to value passed
    public void setProductNumber(String productNumberPassed)
    {   this.productNumber = productNumberPassed;
    } // ******************** END OF setProductNumber MUTATOR ******************

                                            // set quantity to value passed
    public void setQuantity(int quantityPassed)
    {   this.quantity = quantityPassed;
    } // ******************** END OF setQuantity MUTATOR ***********************

                                            // set orderDate to value passed
    public void setOrderDate(String orderDatePassed)
    {   this.orderDate = orderDatePassed;
    } // ******************** END OF setOrderDate MUTATOR **********************

                                            // set orderTime to value passed
    public void setOrderTime(String orderTimePassed)
    {   this.orderTime = orderTimePassed;
    } // ******************** END OF setOrderTime MUTATOR **********************

                                            // set orderStatus to value passd
    public void setOrderStatus(String orderStatusPassed)
    {   this.orderStatus = orderStatusPassed;
    } // ******************** END OF setOrderStatus MUTATOR ********************

                                            // set orderAmount to value passed
    public void setOrderAmount(double orderAmountPassed)
    {   this.orderAmount = orderAmountPassed;
    } // ******************** END OF setOrderAmount MUTATOR ********************

                                            // set orderSalesTax to value passed
    public void setOrderSalesTax(double orderSalesTaxPassed)
    {   this.orderSalesTax = orderSalesTaxPassed;
    } // ******************** END OF setOrderSalesTax MUTATOR ******************

                                            // set orderShippingCost to passed
    public void setOrderShippingCost(double orderShippingCostPassed)
    {   this.orderShippingCost = orderShippingCostPassed;
    } // ******************** END OF setOrderShippingCost MUTATOR **************

                                            // set orderTotal to value passed
    public void setOrderTotal(double orderTotalPassed)
    {   this.orderTotal = orderTotalPassed;
    } // ******************** END OF setOrderTotal MUTATOR *********************

                                            // set orderBalance to value passed
    public void setOrderBalance(double orderBalancePassed)
    {   this.orderBalance = orderBalancePassed;
    } // ******************** END OF setOrderBalance MUTATOR *******************

                                            // set productSize to value passed
    public void setProductSize(String productSizePassed)
    {   this.productSize = productSizePassed;
    } // ******************** END OF setOrderBalance MUTATOR *******************

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
* Description:  SELECT database record for custNumber+custOrder+productNumber
*               passed and fill Order Object with that record's data
*       @param  keyCustNumber, keyOrderNumber, keyProductNumber
*******************************************************************************/
    public void selectDB(String keyCustNumber, String keyOrderNumber,
                        String keyProductNumber)
    {                                       // Load DB Driver and get connection
        System.out.println("\nStarting DB SELECT...........");
        
        try {                               // attempt database driver load
            Class.forName(DBDRIVER);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(
                    Order.class.getName()).log(Level.SEVERE, null, ex);
        }
        // attempt database connection and read with resources
        // JVM will Auto-Close connection to DB
        try (Connection con = DriverManager.getConnection(DBDATA)){
                                            // create Statement Object
            Statement stmt = con.createStatement();
            setCustNumber(keyCustNumber);   // set this.custNumber
            setOrderNumber(keyOrderNumber); // set this.orderNumber
                                            // set this.productNumber 
            setProductNumber(keyProductNumber);           
                                            // create sql string for query
            String sql = "select * from ORDERDATA WHERE CUSTNUMBER=" 
                            + getCustNumber() + " AND ORDERNUMBER="
                            + getOrderNumber()+ " AND PRODUCTNUMBER="
                            + getProductNumber();
            System.out.println("\t" + sql);
                                            // executeQuery >> ResultSet object
            ResultSet rs = stmt.executeQuery(sql);
            
            // Process Data
            rs.next();                      // set DB cursor to the first result
            // set properties to DB positional record values
            setCustNumber(rs.getString(1));
            setOrderNumber(rs.getString(2));
            setProductNumber(rs.getString(3));
            setQuantity(rs.getInt(4));
            setOrderDate(rs.getString(5));
            setOrderTime(rs.getString(6));
            setOrderStatus(rs.getString(7));
            setOrderAmount(rs.getDouble(8));
            setOrderSalesTax(rs.getDouble(9));
            setOrderShippingCost(rs.getDouble(10));
            setOrderTotal(rs.getDouble(11));
            setOrderBalance(rs.getDouble(12));
            setProductSize(rs.getString(13));
            setProductGender(rs.getString(14));
        }
        catch(Exception e){                 // catch if database connection 
                                            //               or read failed
            System.out.println(
                "Database Access Failed for SELECT of CUSTNUMBER: "
                + getCustNumber() + " ORDERNUMBER: " + getOrderNumber());
            System.out.println("PP: " + e);
        }
    } // ******************** END OF selectDB DATABASE ACCESS METHOD ***********

/*******************************************************************************
* generateOrderNumber METHOD
*
* Description:  Generate new ORDERNUMBER before use of insertDB
*               Sets orderNumber of current object to new unique ORDERNUMBER
*      @param   None
*******************************************************************************/
    public void generateOrderNumber()
    {   
        System.out.println("\nStarting DB generateCustNumber...........");
        
        try {                               // attempt database driver load
            Class.forName(DBDRIVER);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(
                    Order.class.getName()).log(Level.SEVERE, null, ex);
        }
        // attempt database connection and read with resources
        // JVM will Auto-Close connection to DB
        try (Connection con = DriverManager.getConnection(DBDATA)){
                                            // create Statement Object
            Statement stmt = con.createStatement();
                                            // create sql string for query
            String sql = "SELECT CUSTNUMBER, MAX(ORDERNUMBER) FROM ORDERDATA WHERE CUSTNUMBER=" + getCustNumber() + " GROUP BY (CUSTNUMBER)";
            System.out.println("\t" + sql);
                                            // executeQuery >> ResultSet object
            ResultSet rs = stmt.executeQuery(sql);
            
            // Process Data
            rs.next();                      // set DB cursor to the first result
            // add 1 to last CUSTNUMBER in order to create new unique CUSTNUMBER
            int incrementOrderNumber = (Integer.parseInt(rs.getString(2)) + 1);
            String formattedOrderNumber = String.format("%08d", incrementOrderNumber);

            setOrderNumber(formattedOrderNumber);
        }
        catch(Exception e){                 // catch if database connection 
                                            //               or read failed
            System.out.println(
                "Database Access Failed for SELECT of last ORDERNUMBER");
            System.out.println("PP: " + e);
            
            // no orders on record, this will be order #1 for this customer
            setOrderNumber("00000001");
        } 
    } // ************ END OF generateOrderNumber DATABASE ACCESS METHOD ********
    
/*******************************************************************************
* insertDB METHOD
*
* Description:  INSERT a new row into DB using data passed
*       @param  custNumber, orderNumber, productNumber, quantity, 
*               orderDate, orderTime, orderStatus, orderAmount, 
*               orderSalesTax, orderShippingCost, orderTotal, orderBalance
*******************************************************************************/
    public void insertDB(String newCustNumber, String newOrderNumber, 
                    String newProductNumber, int newQuantity, 
                    String newOrderDate, String newOrderTime, 
                    String newOrderStatus, double newOrderAmount, 
                    double newOrderSalesTax, double newOrderShippingCost,
                    double newOrderTotal, double newOrderBalance,
                    String newProductSize, String newProductGender)
    {   
        System.out.println("\nStarting DB INSERT...........");
        
        try {                               // attempt database driver load
            Class.forName(DBDRIVER);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(
                    Order.class.getName()).log(Level.SEVERE, null, ex);
        }
        // attempt database connection and read with resources
        // JVM will Auto-Close connection to DB
        try (Connection con = DriverManager.getConnection(DBDATA)){
                                            // create Statement Object
            Statement stmt = con.createStatement();
            // set properties for current object to new passed values
            setCustNumber(newCustNumber);
            setOrderNumber(newOrderNumber );
            setProductNumber(newProductNumber);
            setQuantity(newQuantity);
            setOrderDate(newOrderDate);
            setOrderTime(newOrderTime);
            setOrderStatus(newOrderStatus);
            setOrderAmount(newOrderAmount);
            setOrderSalesTax(newOrderSalesTax);
            setOrderShippingCost(newOrderShippingCost);
            setOrderTotal(newOrderTotal);
            setOrderBalance(newOrderBalance);
            setProductSize(newProductSize);
            setProductGender(newProductGender);
                                            // create sql string for query
            String sql = "INSERT INTO ORDERDATA(CUSTNUMBER,ORDERNUMBER,PRODUCTNUMBER,QUANTITY,ORDERDATE,ORDERTIME,ORDERSTATUS,ORDERAMOUNT,ORDERSALESTAX,ORDERSHIPPINGCOST,ORDERTOTAL,ORDERBALANCE,PRODUCTSIZE,PRODUCTGENDER)"
                            + " VALUES('"+newCustNumber+"','"+newOrderNumber+"','"+newProductNumber+"',"+newQuantity+",'"+newOrderDate+"','"+newOrderTime+"','"+newOrderStatus+"',"+newOrderAmount+","+newOrderSalesTax+","+newOrderShippingCost+","+newOrderTotal+","+newOrderBalance+",'"+newProductSize+"','"+newProductGender+"')";
            System.out.println("\t" + sql);
            // executeUpdate:INSERT Order Object Data into Table
            int n = stmt.executeUpdate(sql);
            if ( n == 1)                    // if 1, INSERT successful
                System.out.println("\n\tINSERT Successful.");
            else                            // if not 1, INSERT failed
                System.out.println("\n\tINSERT Failed.");
    } 
    catch (SQLException e)                  // catch any DB Access/SQL errors
    {   System.out.println("\n\t***Database Access Failed for INSERT into ORDERDATA Table for custNumber: " + getCustNumber() + " orderNumber: " + getOrderNumber() + " productNumber: " + getProductNumber() + "***\n");
            System.out.println("PP: " + e);
    }
} // ******************** END OF insertDB DATABASE ACCESS METHOD ***************

/*******************************************************************************
* updateDB METHOD
*
* Description:  UPDATE SELECTed record with Order Object data. Updates 
*               all fields except custNumber,orderNumber and productNumber.
*       @param  None
*******************************************************************************/
    public void updateDB()
    {   
        System.out.println("\nStarting DB UPDATE...........");
        
        try {                               // attempt database driver load
            Class.forName(DBDRIVER);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(
                    Order.class.getName()).log(Level.SEVERE, null, ex);
        }
        // attempt database connection and read with resources
        // JVM will Auto-Close connection to DB
        try (Connection con = DriverManager.getConnection(DBDATA)){
                                            // create Statement Object
            Statement stmt = con.createStatement();
                                            // create sql string
            String sql = "UPDATE ORDERDATA SET QUANTITY = '"+getQuantity()+"',ORDERDATE = '"+getOrderDate()+"',ORDERTIME = '"+getOrderTime()+"',ORDERSTATUS = '"+getOrderStatus()+"',ORDERAMOUNT = '"+getOrderAmount()+"',ORDERSALESTAX = '"+getOrderSalesTax()+"',ORDERSHIPPINGCOST = '"+getOrderShippingCost()+"',ORDERTOTAL = '"+getOrderTotal()+"',ORDERBALANCE = '"+getOrderBalance()+"',PRODUCTSIZE = '"+getProductSize()+"',PRODUCTGENDER = '"+getProductGender()+"' WHERE CUSTNUMBER = '"+getCustNumber()+"' AND ORDERNUMBER = '"+getOrderNumber()+"' AND PRODUCTNUMBER = '"+getProductNumber()+"'";
            System.out.println("\t" + sql);
            // executeUpdate:UPDATE row data in Order Table
            int n = stmt.executeUpdate(sql);
            if ( n == 1)                    // if 1, UPDATE successful
                System.out.println("\n\tUPDATE Successful.");
            else                            // if not 1, UPDATE failed
                System.out.println("\n\tUPDATE Failed.");
            } 
        catch (SQLException e)              // catch any DB Access/SQL errors
        {   System.out.println("\n\t***Database Access Failed during UPDATE of ORDERDATA Table for custNumber: " + getCustNumber() + " orderNumber: " + getOrderNumber() + " productNumber: " + getProductNumber() + "***\n");
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
                    Order.class.getName()).log(Level.SEVERE, null, ex);
        }
        // attempt database connection and read with resources
        // JVM will Auto-Close connection to DB
        try (Connection con = DriverManager.getConnection(DBDATA)) {
            Statement stmt = con.createStatement();
                                            // create sql string
            String sql = "DELETE from ORDERDATA WHERE CUSTNUMBER = '"+getCustNumber()+"' AND ORDERNUMBER = '"+getOrderNumber()+"' AND PRODUCTNUMBER = '"+getProductNumber()+"'";
            System.out.println("\t" + sql);
            // executeUpdate:DELETE row data based on sql criteria
            int n = stmt.executeUpdate(sql);
            if ( n == 1)                    // if 1, DELETE successful
                System.out.println("\n\tDELETE Successful.");
            else                            // if not 1, DELETE failed
                System.out.println("\n\tDELETE Failed.");
    } 
    catch (SQLException e)                  // catch any DB Access/SQL errors
    {   System.out.println("\n\t***Database Access Failed during DELETE of ORDERDATA Table for custNumber: " + getCustNumber() + " orderNumber: " + getOrderNumber() + " productNumber: " + getProductNumber() + "***\n");
            System.out.println("PP: " + e);
    }
    } // ******************** END OF deleteDB DATABASE ACCESS METHOD ***********

/*******************************************************************************
* show METHOD - Display general current object information
*******************************************************************************/
    public void show()
    {   System.out.println("\n\t       custNumber: " + getCustNumber()
            + "\n\t      orderNumber: " + getOrderNumber()
            + "\n\t    productNumber: " + getProductNumber()
            + "\n\t         quantity: " + getQuantity()            
            + "\n\t        orderDate: " + getOrderDate()            
            + "\n\t        orderTime: " + getOrderTime()
            + "\n\t      orderStatus: " + getOrderStatus()
            + "\n\t      orderAmount: " + getOrderAmount()
            + "\n\t    orderSalesTax: " + getOrderSalesTax()
            + "\n\torderShippingCost: " + getOrderShippingCost()
            + "\n\t       orderTotal: " + getOrderTotal()
            + "\n\t     orderBalance: " + getOrderBalance()
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
/*        System.out.println("\n***********************************************");
        System.out.println("*** SELECT TEST on TeamOneSportingGoodsACCDB");
        System.out.println("*************************************************");
                                            // Create Order Object o1
        Order o1 = new Order();
                                            // SELECT record from DB
        o1.selectDB("1000002","00000002","123189456");
        o1.show();                          // Display data SELECTed from DB

        System.out.println("\n***********************************************");
        System.out.println("*** INSERT TEST on TeamOneSportingGoodsACCDB");
        System.out.println("*************************************************");
                                            // Create Order Object o2
        Order o2 = new Order();
                                            // INSERT record into DB
        o2.insertDB("1000002", "00000004", "123359489", 1, "20201027", "195500", "O", 24.99, 1.50, 5.00, 31.49, 31.49," "," ");
                                            // SELECT record from DB
        o2.selectDB("1000002","00000004","123359489");
        o2.show();                          // Display data INSERTed into DB

        System.out.println("\n***********************************************");
        System.out.println("*** UPDATE TEST on TeamOneSportingGoodsACCDB");
        System.out.println("*************************************************");
                                            // Create Order Object o3
        Order o3 = new Order ();
                                            // SELECT record to UPDATE in DB
        o3.selectDB("1000002","00000004","123359489");
        o3.show();                          // Display record data BEFORE UPDATE
                                            // change multiple fields
        o3.setOrderStatus("S");
        o3.setOrderBalance(0.00);
        o3.setProductSize("34");
        o3.setProductGender("K");
        o3.updateDB();                      // UPDATE record with new o3 data
        o3.show();                          // Display record data AFTER UPDATE

        System.out.println("\n***********************************************");
        System.out.println("*** DELETE TEST on TeamOneSportingGoodsACCDB");
        System.out.println("*************************************************");
                                            // Create Order Object o4
        Order o4 = new Order();
                                            // SELECT record to UPDATE in DB
        o4.selectDB("1000001","56788765","876543210");
        o4.deleteDB();                      // DELETE current SELECTed record
*/
        
        System.out.println("\n***********************************************");
        System.out.println("*** GENERATE TEST on TeamOneSportingGoodsACCDB");
        System.out.println("*************************************************");
        Order o5 = new Order();       // Create Order Object o5
        o5.setCustNumber("1000002");
        o5.generateOrderNumber();
        String newOrderNumber = o5.getOrderNumber();
        
        o5.insertDB("1000002", newOrderNumber, "123189456", 1, "20201027", "195500", "S", 24.99, 1.50, 5.00, 31.49, 31.49," "," ");
        o5.selectDB("1000002",newOrderNumber,"123189456");
        o5.show();                          // Display data INSERTed into DB
        
    }
}
