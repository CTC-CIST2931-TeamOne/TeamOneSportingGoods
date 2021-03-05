//package sporting.goods;
/*******************************************************************************
* Class: CIST 2931 Advanced Systems Project
* Semester: Fall 2020
* Instructor: Ronald Enz
* Description:  LoadProductTable Object for TeamOneSportingGoods Project
* Due: 08/28/2020
* @author Ian Mashburn & Hunter Browder
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;             // import for error logging
import java.util.logging.Logger;            // import for error logging

/*******************************************************************************
* Class LoadProductTable - Business Object with DB Access Method
*******************************************************************************/
public class LoadProductTable implements Cloneable {

/*******************************************************************************
* OBJECT PROPERTIES - Declare/Initialize object variables & CONSTANTS
*******************************************************************************/
                                            // Init ProductList Object
    public  ProductList productList = new ProductList();
    
    public  ProductList searchResult = new ProductList();
    
    public  ProductList defaultProductList = new ProductList();

    public  ProductList defaultSearchResult = new ProductList();
    
    //Added 11/4/2020
    public Boolean searchNotFound = false;
    //END
    
                                            // Database Driver
    final private String DBDRIVER = "net.ucanaccess.jdbc.UcanaccessDriver";
                                            // Database Link and Data
    final private String DBDATA = 
             "jdbc:ucanaccess://C:/DBData/TeamOneSportingGoodsACCDB.accdb";

/*******************************************************************************
* CONSTRUCTORS 
*******************************************************************************/
    // no-arg constructor to create LoadProductTable with default values
    public LoadProductTable() 
    {   
    } // ******************** END OF LoadProductTable no-arg CONSTRUCTOR *******

/*******************************************************************************
* memLoadProducts METHOD
*
* Description:  Load full PRODUCT Table into memory for faster searches
*       @param  None
*******************************************************************************/
    public void memLoadProducts()
    {
        System.out.println("\nStarting memLoadProducts()...........");
        
        try {                               // attempt database driver load
            Class.forName(DBDRIVER);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(
                LoadProductTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        // attempt database connection and read with resources
        // JVM will Auto-Close connection to DB
        try (Connection con = DriverManager.getConnection(DBDATA)){
                                            // create Statement Object
                Statement stmt = con.createStatement();
                                            // create sql string for query
                String sql = "select * from PRODUCT";
                System.out.println("\t" + sql);
                                            // executeQuery >> ResultSet object
                ResultSet rs = stmt.executeQuery(sql);
        
                // Process Data
                Product p1;                 // create work object for each rec
                while( rs.next()){          // cycle through ResultSet
                                            // instantiate new Product
                                            // and fill with current DB record
                    p1 = new Product(rs.getString(1),rs.getString(2),
                                     rs.getString(3),rs.getString(4),
                                     rs.getString(5),rs.getDouble(6),
                                     rs.getString(7),rs.getBoolean(8),
                                     rs.getBoolean(9),rs.getString(10));
                                            // add Product object to productList
                    productList.addProduct(p1);
                }
            }
        catch(Exception e){                 // catch if database connection or read failed
                System.out.println("Database Access Failed for SELECT of * from PRODUCT Table ");
                System.out.println("PP: " + e);
        }        
    }
    
/*******************************************************************************
* searchProductName METHOD
*
* Description:  Search Product List for a specified name
*                and creates a search result List
*       @param  namePassed
*******************************************************************************/
    
    public void searchProductName(String namePassed ){
        
        
        searchNotFound = false;
        
        searchResult.numberOfProducts = 0;
        searchResult.productList.clear();  // Resets the Search Results
                                            
                                           // sets the name being searched for to a lowercase to ensure accurate results
        namePassed = namePassed.toLowerCase();                           

                                           // cycle through Full ProductList
        for(Product p : productList.productList){                       
            
                                           // sets the names being searched against to a lowercase to ensure accurate results
            String searchTarget = p.getProductName().toLowerCase();   
        
        
                                           // Checks if searched name is found in product list
            if(searchTarget.contains(namePassed)){
                
                
                                           // adds product to search result list
                searchResult.addProduct(p);
            
            
            }
            else{
            
            System.out.println("NOT FOUND");
            
            }
        
        
        
        }
        //Checks if the search was unable to find results ---ADDED 11/4/20
         if(searchResult.numberOfProducts <= 0){
            
            searchNotFound = true;
            
            System.out.println("Search Is not Found");
            
            
        }
        //END
                 
        
    } 

/*******************************************************************************
* searchProductCategory METHOD
*
* Description:  Search Product List for a specified Category
*                and creates a search result List
*       @param  categoryPassed
*******************************************************************************/
        
     public void searchProductCategory(String categoryPassed ){
         
        searchNotFound = false;
        
        searchResult.numberOfProducts = 0;
        searchResult.productList.clear();  // Resets the Search Results
                                            
                                           // sets the name being searched for to a lowercase to ensure accurate results
        categoryPassed = categoryPassed.toLowerCase();                           

                                           // cycle through Full ProductList
        for(Product p : productList.productList){                       
            
                                           // sets the names being searched against to a lowercase to ensure accurate results
            String searchTarget = p.getProductCategory().toLowerCase();   
        
        
                                           // Checks for searched Category in product list
            if(searchTarget.contains(categoryPassed)){
                
                
                                           // adds product to search result list
                searchResult.addProduct(p);
                
                
            
            }
            else{
            
            System.out.println("NOT FOUND");
         
            }
        
            
           
        }
        
       
        
      
        
                 
        
    } 
    
 //EDITED 11/7/2020    
/*******************************************************************************
* sortPrice Comparator METHOD
*
* Description:  Test if the products price are less or greater than 
*      
*******************************************************************************/
     
    public static Comparator<Product> sortPrice(){
         
        System.out.println("*************************** IN LoadProductTable: sortPrice() *******************");
                 
        return new Comparator<Product>(){
            @Override
            public int compare(Product o1, Product o2) { 
                
                    System.out.println(o1.getProductCost()-o2.getProductCost());
                
                   double difference = o1.getProductCost()-o2.getProductCost();
                   if(difference > 0){
                    return 1;
                   }
                   if(difference < 0){
                    return -1;
                   }
                   else{ 
                     return 0;
                   }
                
                

          }
          
          
          
          
      };
        
            
     }
//END
//NEW 11/7/2020
/*******************************************************************************
* sortName Comparator METHOD
*
* Description:  Test if the products Name Comes first 
*      
*******************************************************************************/
    public static Comparator<Product> sortName(){
         
        System.out.println("*************************** IN LoadProductTable: sortName() *******************");
                 
        return new Comparator<Product>(){
            @Override
            public int compare(Product o1, Product o2) { 
                
                    System.out.println(o1.getProductName().compareTo(o2.getProductName()));
                
            
                    return (int)(o1.getProductName().compareTo(o2.getProductName()));
                
                

          }
          
          
          
          
      };
        
            
     }
//END    
    
  
    
//EDITED 11/7/2020     
/*******************************************************************************
* sortByPrice METHOD
*
* Description:  Updates the ProductList Array to be ordered By the 
*               Lowest Cost or highest Cost 
*      
*            @param pList, startWith
* 
*******************************************************************************/     
    public void sortByPrice(ProductList pList, String startWith){
        
           
        
       System.out.println("*************************** IN LoadProductTable: sortByPrice() *******************");
        
        Collections.sort(pList.productList, sortName());
        
        if(startWith.equalsIgnoreCase("low")){
            Collections.sort(pList.productList, sortPrice());
        }
        else if(startWith.equalsIgnoreCase("high")){
        
            Collections.sort(pList.productList, sortPrice());
            Collections.reverse(pList.productList);
        
        }
          
    }
    
/*******************************************************************************
* copyList METHOD
*
* Description:  Creates a copy of the provided ArrayList and 
*               sets it in the DefaultProductList variable
*             
*           @param  pList
*      
*******************************************************************************/     
    
    public void copyList(ProductList pList){
    
        System.out.println("*************************** IN LoadProductTable: copyList() *******************");
     
        defaultProductList.productList.addAll(pList.productList);
        
    
    }
    
/*******************************************************************************
* copySearchResult METHOD
*
* Description:  Creates a copy of the provided ArrayList and 
*               sets it in the defaultSearchResult variable
*             
*           @param  pList
*      
*******************************************************************************/ 
      
    public void copySearchResult(ProductList pList){
    
        System.out.println("*************************** IN LoadProductTable: copySearchResult() *******************");
        
        defaultSearchResult.productList.clear();
        defaultSearchResult.productList.addAll(pList.productList);
        
    
    }
      
    


    
/*******************************************************************************
* show METHOD - Display general current object information
*******************************************************************************/
    public void show()
    {   
        productList.show();                 // display full productList
    }

/*******************************************************************************
* MAIN METHOD - for TESTING purposes
* @param args
*******************************************************************************/
    public static void main(String[] args)
    {   
        System.out.println("\n***********************************************");
        System.out.println("*** FULL PRODUCTLIST on TeamOneSportingGoodsACCDB");
        System.out.println("*************************************************");
                                            // Create LoadProductable Object LP1
        LoadProductTable LP1 = new LoadProductTable();
        LP1.memLoadProducts();              // Load productList with full Table
        LP1.productList.show();             // show full productList        
    
        System.out.println("\n***********************************************");
        System.out.println("*** SEARCH TESTS on TeamOneSportingGoodsACCDB");
        System.out.println("*************************************************");

        LP1.productList.show();
    }
}
