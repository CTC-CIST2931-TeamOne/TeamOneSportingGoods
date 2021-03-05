/*******************************************************************************
* Class: CIST 2931 Advanced Systems Project
* Semester: Fall 2020
* Instructor: Ronald Enz
* Description:  Product Object for TeamOneSportingGoods Project
* Due: 08/27/2020
* @author Hunter Browder & Ian Mashburn
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
* Class Product - Business Object with DB Access Methods
*******************************************************************************/
public class Product {

/*******************************************************************************
* OBJECT PROPERTIES - Declare/Initialize object variables & CONSTANTS
*******************************************************************************/
    private String  productNumber   = " ";
    private String  productName     = " ";
    private String  productDesc     = " ";
    private String  productCategory = " ";
    private String  productImagePath= " ";
    private double  productCost     = 0.0;
    private String  productBrand    = " ";
    private boolean productSize     = false;
    private boolean productGender   = false;
    private String  productSizeType = " ";
                                            // Database Driver
    final private String DBDRIVER = "net.ucanaccess.jdbc.UcanaccessDriver";
                                            // Database Link and Data
    final private String DBDATA = 
             "jdbc:ucanaccess://C:/DBData/TeamOneSportingGoodsACCDB.accdb";

/*******************************************************************************
* CONSTRUCTORS 
*******************************************************************************/
    // no-arg constructor to create Product with default values
    public Product()
    {   productNumber   = " ";
        productName     = " ";
        productDesc     = " ";
        productCategory = " ";
        productImagePath= " ";
        productCost     = 0.0;
        productBrand    = " ";
        productSize     = false;
        productGender   = false;
        productSizeType = " ";

    } // ******************** END OF Product no-arg CONSTRUCTOR ****************

    // multi-arg constructor to create Product with passed values
    public Product(String newProductNumber, String newProductName, 
                    String newProductDesc , String newProductCategory,
                    String newProductImagePath, double newProductCost,
                    String newProductBrand, boolean newProductSize, 
                    boolean newProductGender, String newProductSizeType)
    {   this.productNumber      = newProductNumber;
        this.productName        = newProductName;
        this.productDesc        = newProductDesc;
        this.productCategory    = newProductCategory;
        this.productImagePath   = newProductImagePath;
        this.productCost        = newProductCost;
        this.productBrand       = newProductBrand;
        this.productSize        = newProductSize;
        this.productGender      = newProductGender;
        this.productSizeType    = newProductSizeType;
    } // ****************** END OF Product multi-arg CONSTRUCTOR ***************

/*******************************************************************************
* ACCESSOR METHODS - Getters 
* @return 
*******************************************************************************/
    public String getProductNumber()        // retrieve & return productNumber
    {   return this.productNumber;
    } // ******************** END OF getProductNumber ACCESSOR *****************

    public String getProductName()          // retrieve & return productName
    {   return this.productName;
    } // ******************** END OF getProductName ACCESSOR *******************

    public String getProductDesc()          // retrieve & return productDesc
    {   return this.productDesc;
    } // ******************** END OF getProductDesc ACCESSOR *******************

    public String getProductCategory()      // retrieve & return productCategory
    {   return this.productCategory;
    } // ******************** END OF getProductCategory ACCESSOR ***************

    public String getProductImagePath()     // retrieve &return productImagePath
    {   return this.productImagePath;
    } // ******************** END OF getProductImagePath ACCESSOR **************

    public double getProductCost()          // retrieve & return productCost
    {   return this.productCost;
    } // ******************** END OF getProductCost ACCESSOR *******************
    
    public String getProductBrand()         // retrieve &return productBrand
    {   return this.productBrand;
    } // ******************** END OF getProductBrand ACCESSOR ******************

    public boolean getProductSize()         // retrieve & return productSize
    {   return this.productSize;
    } // ******************** END OF getProductSize ACCESSOR *******************

    public boolean getProductGender()       // retrieve & return productGender
    {   return this.productGender;
    } // ******************** END OF getProductGender ACCESSOR *****************
    
    public String getProductSizeType()      // retrieve &return productSizeType
    {   return this.productSizeType;
    } // ******************** END OF getProductSizeType ACCESSOR ***************
 
/*******************************************************************************
* MUTATOR METHODS - Setters
*******************************************************************************/
                                            // set productNumber to value passed
    public void setProductNumber(String productNumberPassed)
    {   this.productNumber = productNumberPassed;
    } // ******************** END OF setProductNumber MUTATOR ******************

                                            // set cardNumber to value passed
    public void setProductName(String productNamePassed)
    {   this.productName = productNamePassed;
    } // ******************** END OF setProductName MUTATOR ********************

                                            // set productDesc to value passed
    public void setProductDesc(String productDescPassed)
    {   this.productDesc = productDescPassed;
    } // ******************** END OF setProductDesc MUTATOR ********************

                                            // set setProductCategory to passed
    public void setProductCategory(String productCategoryPassed)
    {   this.productCategory = productCategoryPassed;
    } // ******************** END OF setProductCategory MUTATOR ****************

                                            // set productImagePath to passed
    public void setProductImagePath(String productImagePathPassed)
    {   this.productImagePath = productImagePathPassed;
    } // ******************** END OF setProductImagePath MUTATOR ***************

                                            // set productCost to value passed
    public void setProductCost(double productCostPassed)
    {   this.productCost = productCostPassed;
    } // ******************** END OF setProductCost MUTATOR ********************

                                            // set productBrand to value passed
    public void setProductBrand(String productBrandPassed)
    {   this.productBrand = productBrandPassed;
    } // ******************** END OF setProductBrand MUTATOR *******************

                                            // set productSize to value passed
    public void setProductSize(boolean productSizePassed)
    {   this.productSize = productSizePassed;
    } // ******************** END OF setProductSize MUTATOR ********************

                                            // set productGender to value passed
    public void setProductGender(boolean productGenderPassed)
    {   this.productGender = productGenderPassed;
    } // ******************** END OF setProductGender MUTATOR ******************
    
                                            // set productSizeType tovaluepassed
    public void setProductSizeType(String productSizeTypePassed)
    {   this.productSizeType = productSizeTypePassed;
    } // ******************** END OF setProductSizeType MUTATOR ****************
 
/*******************************************************************************
* DATABASE ACCESS METHODS
*******************************************************************************/
/*******************************************************************************
* selectDB METHOD
* 
* Description:  SELECT database record for productNumber passed and fill  
*               PaymentMethod Object with that record's data
*       @param  keyProductNumber
*******************************************************************************/
    public void selectDB(String keyProductNumber)
    {                                       // Load DB Driver and get connection
        System.out.println("\nStarting DB SELECT...........");
        
        try {                               // attempt database driver load
            Class.forName(DBDRIVER);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(
                    Product.class.getName()).log(Level.SEVERE, null, ex);
        }
        // attempt database connection and read with resources
        // JVM will Auto-Close connection to DB
        try (Connection con = DriverManager.getConnection(DBDATA)){
                                            // create Statement Object
            Statement stmt = con.createStatement();
                                            // set this.productNumber
            setProductNumber(keyProductNumber);
                                            // create sql string for query
            String sql = "select * from PRODUCT WHERE PRODUCTNUMBER=" 
                            + getProductNumber();
            System.out.println("\t" + sql);
                                            // executeQuery >> ResultSet object
            ResultSet rs = stmt.executeQuery(sql);
            
            // Process Data
            rs.next();                      // set DB cursor to the first result
            // set properties to DB positional record values
            setProductNumber(rs.getString(1));
            setProductName(rs.getString(2));
            setProductDesc(rs.getString(3));
            setProductCategory(rs.getString(4));
            setProductImagePath(rs.getString(5));
            setProductCost(rs.getDouble(6));
            setProductBrand(rs.getString(7));
            setProductSize(rs.getBoolean(8));
            setProductGender(rs.getBoolean(9));
            setProductSizeType(rs.getString(10));
        }
        catch(Exception e){                 // catch if database connection 
                                            //               or read failed
            System.out.println(
                "Database Access Failed for SELECT of PRODUCTNUMBER: "
                                                + getProductNumber());
            System.out.println("PP: " + e);
        }
    } // ******************** END OF selectDB DATABASE ACCESS METHOD ***********

/*******************************************************************************
* show METHOD - Display general current object information
*******************************************************************************/
    public void show()
    {   System.out.println("\n\t   productNumber: " + getProductNumber()
            + "\n\t     productName: " + getProductName()
            + "\n\t     productDesc: " + getProductDesc()           
            + "\n\t productCategory: " + getProductCategory()
            + "\n\tproductImagePath: " + getProductImagePath()          
            + "\n\t    productBrand: " + getProductBrand()
            + "\n\t     productSize: " + getProductSize()
            + "\n\t   productGender: " + getProductGender()
            + "\n\t productSizeType: " + getProductSizeType()   
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
                                            // Create Product Object pm1
        Product pm1 = new Product();
                                            // SELECT record from DB
        pm1.selectDB("123456557");
        pm1.show();                         // Display data SELECTed from DB

    }
}
