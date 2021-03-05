/*******************************************************************************
* Class: CIST 2931 Advanced Systems Project
* Semester: Fall 2020
* Instructor: Ronald Enz
* Description:  PaymentMethod Object for TeamOneSportingGoods Project
* Due: 08/27/2020
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
* Class PaymentMethod - Business Object with DB Access Methods
*******************************************************************************/
public class PaymentMethod {

/*******************************************************************************
* OBJECT PROPERTIES - Declare/Initialize object variables & CONSTANTS
*******************************************************************************/
    private String  custNumber      = " ";
    private String  cardNumber      = " ";
    private String  cardType        = " ";
    private String  cardExpDate     = " ";
    private String  cardCVV         = " ";
    private String  billFirstName   = " ";  
    private String  billMidInitial  = " ";
    private String  billLastName    = " ";
    private String  billAddrLine1   = " ";
    private String  billAddrLine2   = " ";
    private String  billCity        = " ";
    private String  billState       = " ";
    private String  billZip         = " ";
    private String  billPhone       = " ";
    private String  billEmail       = " ";
                                            // Database Driver
    final private String DBDRIVER = "net.ucanaccess.jdbc.UcanaccessDriver";
                                            // Database Link and Data
    final private String DBDATA = 
             "jdbc:ucanaccess://C:/DBData/TeamOneSportingGoodsACCDB.accdb";

/*******************************************************************************
* CONSTRUCTORS 
*******************************************************************************/
    // no-arg constructor to create PaymentMethod with default values
    public PaymentMethod()
    {   custNumber      = " ";
        cardNumber      = " ";
        cardType        = " ";
        cardExpDate     = " ";
        cardCVV         = " ";
        billFirstName   = " ";
        billMidInitial  = " ";
        billLastName    = " ";
        billAddrLine1   = " ";
        billAddrLine2   = " ";
        billCity        = " ";
        billState       = " ";
        billZip         = " ";
        billPhone       = " ";
        billEmail       = " ";
    } // ******************** END OF PaymentMethod no-arg CONSTRUCTOR **********

    // multi-arg constructor to create PaymentMethod with passed values
    public PaymentMethod(String newCustNumber, String newCardNumber, 
                    String newCardType, String newCardExpDate,
                    String newCardCVV, String newBillFirstName,
                    String newBillMidInitial, String newBillLastName,
                    String newBillAddrLine1, String newBillAddrLine2,
                    String newBillCity, String newBillState, String newBillZip,
                    String newBillPhone, String newBillEmail)
    {   this.custNumber     = newCustNumber;
        this.cardNumber     = newCardNumber;
        this.cardType       = newCardType;
        this.cardExpDate    = newCardExpDate;
        this.cardCVV        = newCardCVV;
        this.billFirstName  = newBillFirstName;
        this.billMidInitial = newBillMidInitial;
        this.billLastName   = newBillLastName;
        this.billAddrLine1  = newBillAddrLine1;
        this.billAddrLine2  = newBillAddrLine2;
        this.billCity       = newBillCity;
        this.billState      = newBillState;
        this.billZip        = newBillZip;
        this.billPhone      = newBillPhone;
        this.billEmail      = newBillEmail;
    } // ****************** END OF PaymentMethod multi-arg CONSTRUCTOR *********

/*******************************************************************************
* ACCESSOR METHODS - Getters 
* @return 
*******************************************************************************/
    public String getCustNumber()           // retrieve & return custNumber
    {   return this.custNumber;
    } // ******************** END OF getCustNumber ACCESSOR ********************

    public String getCardNumber()           // retrieve & return cardNumber
    {   return this.cardNumber;
    } // ******************** END OF getCardNumber ACCESSOR ********************

    public String getCardType()             // retrieve & return cardType
    {   return this.cardType;
    } // ******************** END OF getCardType ACCESSOR **********************

    public String getCardExpDate()          // retrieve & return cardExpDate
    {   return this.cardExpDate;
    } // ******************** END OF getCardExpDate ACCESSOR *******************

    public String getCardCVV()              // retrieve & return cardCVV
    {   return this.cardCVV;
    } // ******************** END OF getCardCVV ACCESSOR ***********************

    public String getBillFirstName()        // retrieve & return billFirstName
    {   return this.billFirstName;
    } // ******************** END OF getBillFirstName ACCESSOR *****************

    public String getBillMidInitial()       // retrieve & return billMidInitial
    {   return this.billMidInitial;
    } // ******************** END OF getBillMidInitial ACCESSOR ****************

    public String getBillLastName()         // retrieve & return billLastName
    {   return this.billLastName;
    } // ******************** END OF getBillLastName ACCESSOR ******************

    public String getBillAddrLine1()        // retrieve & return billAddrLine1
    {   return this.billAddrLine1;
    } // ******************** END OF getBillAddrLine1 ACCESSOR *****************

    public String getBillAddrLine2()        // retrieve & return billAddrLine2
    {   return this.billAddrLine2;
    } // ******************** END OF getBillAddrLine2 ACCESSOR *****************

    public String getBillCity()             // retrieve & return billCity
    {   return this.billCity;
    } // ******************** END OF getBillCity ACCESSOR **********************

    public String getBillState()            // retrieve & return billState
    {   return this.billState;
    } // ******************** END OF getBillState ACCESSOR *********************

    public String getBillZip()              // retrieve & return billZip
    {   return this.billZip;
    } // ******************** END OF getBillZip ACCESSOR ***********************

    public String getBillPhone()            // retrieve & return billPhone
    {   return this.billPhone;
    } // ******************** END OF getBillPhone ACCESSOR *********************

    public String getBillEmail()            // retrieve & return billEmail
    {   return this.billEmail;
    } // ******************** END OF getBillEmail ACCESSOR *********************
    
/*******************************************************************************
* MUTATOR METHODS - Setters
*******************************************************************************/
                                            // set custNumber to value passed
    public void setCustNumber(String custNumberPassed)
    {   this.custNumber = custNumberPassed;
    } // ******************** END OF setCustNumber MUTATOR *********************

                                            // set cardNumber to value passed
    public void setCardNumber(String cardNumberPassed)
    {   this.cardNumber = cardNumberPassed;
    } // ******************** END OF setCardNumber MUTATOR *********************

                                            // set cardType to value passed
    public void setCardType(String cardTypePassed)
    {   this.cardType = cardTypePassed;
    } // ******************** END OF setCardType MUTATOR ***********************

                                            // set cardExpDate to value passed
    public void setCardExpDate(String cardExpDatePassed)
    {   this.cardExpDate = cardExpDatePassed;
    } // ******************** END OF setCardExpDate MUTATOR ********************

                                            // set cardCVV to value passed
    public void setCardCVV(String cardCVVPassed)
    {   this.cardCVV = cardCVVPassed;
    } // ******************** END OF setCardCVVName MUTATOR ********************

                                            // set billFirstName to value passed
    public void setBillFirstName(String billFirstNamePassed)
    {   this.billFirstName = billFirstNamePassed;
    } // ******************** END OF setBillFirstName MUTATOR ******************

                                            // set billMidInitial to value passd
    public void setBillMidInitial(String billMidInitialPassed)
    {   this.billMidInitial = billMidInitialPassed;
    } // ******************** END OF setBillMidInitial MUTATOR *****************

                                            // set billLastName to value passed
    public void setBillLastName(String billLastNamePassed)
    {   this.billLastName = billLastNamePassed;
    } // ******************** END OF setBillLastName MUTATOR *******************

                                            // set billAddrLine1 to value passed
    public void setBillAddrLine1(String billAddrLine1Passed)
    {   this.billAddrLine1 = billAddrLine1Passed;
    } // ******************** END OF setBillAddrLine1 MUTATOR ******************

                                            // set billAddrLine2 to value passed
    public void setBillAddrLine2(String billAddrLine2Passed)
    {   this.billAddrLine2 = billAddrLine2Passed;
    } // ******************** END OF setBillAddrLine2 MUTATOR ******************

                                            // set billCity to value passed
    public void setBillCity(String billCityPassed)
    {   this.billCity = billCityPassed;
    } // ******************** END OF setBillCity MUTATOR ***********************

                                            // set billState to value passed
    public void setBillState(String billStatePassed)
    {   this.billState = billStatePassed;
    } // ******************** END OF setBillState MUTATOR **********************

                                            // set billZip to value passed
    public void setBillZip(String billZipPassed)
    {   this.billZip = billZipPassed;
    } // ******************** END OF setBillZip MUTATOR ************************

                                            // set billPhone to value passed
    public void setBillPhone(String billPhonePassed)
    {   this.billPhone = billPhonePassed;
    } // ******************** END OF setBillPhone MUTATOR **********************

                                            // set billEmail to value passed
    public void setBillEmail(String billEmailPassed)
    {   this.billEmail = billEmailPassed;
    } // ******************** END OF setBillEmail MUTATOR **********************

/*******************************************************************************
* DATABASE ACCESS METHODS
*******************************************************************************/
/*******************************************************************************
* selectDB METHOD
* 
* Description:  SELECT database record for custNumber passed and fill  
*               PaymentMethod Object with that record's data
*       @param  keyCustNumber, keyCardNumber
*******************************************************************************/
    public void selectDB(String keyCustNumber, String keyCardNumber)
    {                                       // Load DB Driver and get connection
        System.out.println("\nStarting DB SELECT...........");
        
        try {                               // attempt database driver load
            Class.forName(DBDRIVER);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(
                    PaymentMethod.class.getName()).log(Level.SEVERE, null, ex);
        }
        // attempt database connection and read with resources
        // JVM will Auto-Close connection to DB
        try (Connection con = DriverManager.getConnection(DBDATA)){
                                            // create Statement Object
            Statement stmt = con.createStatement();
            setCustNumber(keyCustNumber);   // set this.custNumber
            setCardNumber(keyCardNumber);   // set this.cardNumber          
                                            // create sql string for query
            String sql = "select * from PAYMENTMETHOD WHERE CUSTNUMBER=" 
                            + getCustNumber() + " AND CARDNUMBER="
                            + getCardNumber();
            System.out.println("\t" + sql);
                                            // executeQuery >> ResultSet object
            ResultSet rs = stmt.executeQuery(sql);
            
            // Process Data
            rs.next();                      // set DB cursor to the first result
            // set properties to DB positional record values
            setCustNumber(rs.getString(1));
            setCardNumber(rs.getString(2));
            setCardType(rs.getString(3));
            setCardExpDate(rs.getString(4));
            setCardCVV(rs.getString(5));
            setBillFirstName(rs.getString(6));
            setBillMidInitial(rs.getString(7));
            setBillLastName(rs.getString(8));
            setBillAddrLine1(rs.getString(9));
            setBillAddrLine2(rs.getString(10));
            setBillCity(rs.getString(11));
            setBillState(rs.getString(12));
            setBillZip(rs.getString(13));
            setBillPhone(rs.getString(14));
            setBillEmail(rs.getString(15));
        }
        catch(Exception e){                 // catch if database connection 
                                            //               or read failed
            System.out.println(
                "Database Access Failed for SELECT of CUSTNUMBER: "
                                                + getCustNumber());
            System.out.println("PP: " + e);
        }
    } // ******************** END OF selectDB DATABASE ACCESS METHOD ***********
    
/*******************************************************************************
* insertDB METHOD
*
* Description:  INSERT a new row into DB using data passed
*       @param  custNumber, cardNumber, cardType, cardExpDate, 
*               cardCVV, billFirstName, billMidInitial, billLastName, 
*               billAddrLine1, billAddrLine2, billCity, billState, billZip, 
*               billPhone, billEmail
*******************************************************************************/
    public void insertDB(String newCustNumber, String newCardNumber, 
                    String newCardType, String newCardExpDate, 
                    String newCardCVV, String newBillFirstName, 
                    String newBillMidInitial, String newBillLastName, 
                    String newBillAddrLine1, String newBillAddrLine2,
                    String newBillCity, String newBillState, String newBillZip,
                    String newBillPhone, String newBillEmail)
    {   
        System.out.println("\nStarting DB INSERT...........");
        
        try {                               // attempt database driver load
            Class.forName(DBDRIVER);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(
                    PaymentMethod.class.getName()).log(Level.SEVERE, null, ex);
        }
        // attempt database connection and read with resources
        // JVM will Auto-Close connection to DB
        try (Connection con = DriverManager.getConnection(DBDATA)){
                                            // create Statement Object
            Statement stmt = con.createStatement();
            // set properties for current object to new passed values
            setCustNumber(newCustNumber);
            setCardNumber(newCardNumber);
            setCardType(newCardType);
            setCardExpDate(newCardExpDate);
            setCardCVV(newCardCVV);
            setBillFirstName(newBillFirstName);
            setBillMidInitial(newBillMidInitial);
            setBillLastName(newBillLastName);
            setBillAddrLine1(newBillAddrLine1);
            setBillAddrLine2(newBillAddrLine2);
            setBillCity(newBillCity);
            setBillState(newBillState);
            setBillZip(newBillZip);
            setBillPhone(newBillPhone);
            setBillEmail(newBillEmail);
                                            // create sql string for query
            String sql = "INSERT INTO PAYMENTMETHOD(CUSTNUMBER,CARDNUMBER,CARDTYPE,CARDEXPDATE,CARDCVV,BILLFIRSTNAME,BILLMIDINITIAL,BILLLASTNAME,BILLADDRLINE1,BILLADDRLINE2,BILLCITY,BILLSTATE,BILLZIP,BILLPHONE,BILLEMAIL)"
                            + " VALUES('"+newCustNumber+"','"+newCardNumber+"','"+newCardType+"','"+newCardExpDate+"','"+newCardCVV+"','"+newBillFirstName+"','"+newBillMidInitial+"','"+newBillLastName+"','"+newBillAddrLine1+"','"+newBillAddrLine2+"','"+newBillCity+"','"+newBillState+"','"+newBillZip+"','"+newBillPhone+"','"+newBillEmail+"')";
            System.out.println("\t" + sql);
            // executeUpdate:INSERT PaymentMethod Object Data into Table
            int n = stmt.executeUpdate(sql);
            if ( n == 1)                    // if 1, INSERT successful
                System.out.println("\n\tINSERT Successful.");
            else                            // if not 1, INSERT failed
                System.out.println("\n\tINSERT Failed.");
    } 
    catch (SQLException e)                  // catch any DB Access/SQL errors
    {   System.out.println("\n\t***Database Access Failed for INSERT into PAYMENTMETHOD Table for custNumber: " + getCustNumber() + "***\n");
            System.out.println("PP: " + e);
    }
} // ******************** END OF insertDB DATABASE ACCESS METHOD ***************

/*******************************************************************************
* updateDB METHOD
*
* Description:  UPDATE SELECTed record with PaymentMethod Object data. Updates 
*               all fields except custNumber,cardNumber and cardType.
*       @param  None
*******************************************************************************/
    public void updateDB()
    {   
        System.out.println("\nStarting DB UPDATE...........");
        
        try {                               // attempt database driver load
            Class.forName(DBDRIVER);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(
                    PaymentMethod.class.getName()).log(Level.SEVERE, null, ex);
        }
        // attempt database connection and read with resources
        // JVM will Auto-Close connection to DB
        try (Connection con = DriverManager.getConnection(DBDATA)){
                                            // create Statement Object
            Statement stmt = con.createStatement();
                                            // create sql string
            String sql = "UPDATE PAYMENTMETHOD SET CARDEXPDATE = '"+getCardExpDate()+"',CARDCVV = '"+getCardCVV()+"',BILLFIRSTNAME = '"+getBillFirstName()+"',BILLMIDINITIAL = '"+getBillMidInitial()+"',BILLLASTNAME = '"+getBillLastName()+"',BILLADDRLINE1 = '"+getBillAddrLine1()+"',BILLADDRLINE2 = '"+getBillAddrLine2()+"',BILLCITY = '"+getBillCity()+"',BILLSTATE = '"+getBillState()+"',BILLZIP = '"+getBillZip()+"',BILLPHONE = '"+getBillPhone()+"',BILLEMAIL = '"+getBillEmail()+"' WHERE CUSTNUMBER = '"+getCustNumber()+"' AND CARDNUMBER = '"+getCardNumber()+"'";
            System.out.println("\t" + sql);
            // executeUpdate:UPDATE row data in PaymentMethod Table
            int n = stmt.executeUpdate(sql);
            if ( n == 1)                    // if 1, UPDATE successful
                System.out.println("\n\tUPDATE Successful.");
            else                            // if not 1, UPDATE failed
                System.out.println("\n\tUPDATE Failed.");
            } 
        catch (SQLException e)              // catch any DB Access/SQL errors
        {   System.out.println("\n\t***Database Access Failed during UPDATE of PaymentMethod Table for custNumber: " + getCustNumber() + " cardNumber: " + getCardNumber() + "***\n");
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
                    PaymentMethod.class.getName()).log(Level.SEVERE, null, ex);
        }
        // attempt database connection and read with resources
        // JVM will Auto-Close connection to DB
        try (Connection con = DriverManager.getConnection(DBDATA)) {
            Statement stmt = con.createStatement();
                                            // create sql string
            String sql = "DELETE from PAYMENTMETHOD WHERE CUSTNUMBER = '"+getCustNumber()+"' AND CARDNUMBER = '"+getCardNumber()+"'";
            System.out.println("\t" + sql);
            // executeUpdate:DELETE row data based on sql criteria
            int n = stmt.executeUpdate(sql);
            if ( n == 1)                    // if 1, DELETE successful
                System.out.println("\n\tDELETE Successful.");
            else                            // if not 1, DELETE failed
                System.out.println("\n\tDELETE Failed.");
    } 
    catch (SQLException e)                  // catch any DB Access/SQL errors
    {   System.out.println("\n\t***Database Access Failed during DELETE of PaymentMethod Table for custNumber: " + getCustNumber() + " cardNumber: " + getCardNumber() + "***\n");
            System.out.println("PP: " + e);
    }
    } // ******************** END OF deleteDB DATABASE ACCESS METHOD ***********

/*******************************************************************************
* show METHOD - Display general current object information
*******************************************************************************/
    public void show()
    {   System.out.println("\n\t     custNumber: " + getCustNumber()
            + "\n\t     cardNumber: " + getCardNumber()
            + "\n\t       cardType: " + getCardType()
            + "\n\t    cardExpDate: " + getCardExpDate()            
            + "\n\t        cardCVV: " + getCardCVV()            
            + "\n\t  billFirstName: " + getBillFirstName()
            + "\n\t billMidInitial: " + getBillMidInitial()
            + "\n\t   billLastName: " + getBillLastName()
            + "\n\t  billAddrLine1: " + getBillAddrLine1()
            + "\n\t  billAddrLine2: " + getBillAddrLine2()
            + "\n\t       billCity: " + getBillCity()
            + "\n\t      billState: " + getBillState()
            + "\n\t        billZip: " + getBillZip()
            + "\n\t      billPhone: " + getBillPhone()
            + "\n\t      billEmail: " + getBillEmail() );
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
                                            // Create PaymentMethod Object pm1
        PaymentMethod pm1 = new PaymentMethod();
                                            // SELECT record from DB
        pm1.selectDB("1000001","543200000000123");
        pm1.show();                         // Display data SELECTed from DB

        System.out.println("\n***********************************************");
        System.out.println("*** INSERT TEST on TeamOneSportingGoodsACCDB");
        System.out.println("*************************************************");
                                            // Create PaymentMethod Object pm2
        PaymentMethod pm2 = new PaymentMethod();
                                            // INSERT record into DB
        pm2.insertDB("1000001", "9999123412341234", "VISA", "11/25", "321", "TestC", "C", "DataC", "2 Billing Circle", "APT 210", "Acworth", "GA", "30101", "6785553333", "testA@gmail.com");
                                            // SELECT record from DB
        pm2.selectDB("1000001","9999123412341234");
        pm2.show();                         // Display data INSERTed into DB

        System.out.println("\n***********************************************");
        System.out.println("*** UPDATE TEST on TeamOneSportingGoodsACCDB");
        System.out.println("*************************************************");
                                            // Create PaymentMethod Object pm3
        PaymentMethod pm3 = new PaymentMethod ();
                                            // SELECT record to UPDATE in DB
        pm3.selectDB("1000001","9999123412341234");
        pm3.show();                         // Display record data BEFORE UPDATE
                                            // change multiple fields
        pm3.setBillMidInitial("Z");
        pm3.setBillAddrLine2("APT 999");
        pm3.setBillZip("99999");
        pm3.updateDB();                     // UPDATE record with new pm3 data
        pm3.show();                         // Display record data AFTER UPDATE

        System.out.println("\n***********************************************");
        System.out.println("*** DELETE TEST on TeamOneSportingGoodsACCDB");
        System.out.println("*************************************************");
                                            // Create PaymentMethod Object pm4
        PaymentMethod pm4 = new PaymentMethod();
                                            // SELECT record to UPDATE in DB
        pm4.selectDB("1000001","9999123412341234");
        pm4.deleteDB();                     // DELETE current SELECTed record

    }
}
