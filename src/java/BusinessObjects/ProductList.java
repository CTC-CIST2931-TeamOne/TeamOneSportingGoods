/*******************************************************************************
* Class: CIST 2931 Advanced Systems Project
* Semester: Fall 2020
* Instructor: Ronald Enz
* Description:  ProductList Object for TeamOneSportingGoods Project
* Due: 08/28/2020
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

import java.util.ArrayList;

/*******************************************************************************
* Class ProductList - Business Object - DB
*******************************************************************************/
public class ProductList {

/*******************************************************************************
* PROPERTIES - Declare CONSTANTS, variables
*******************************************************************************/
                                            // Initialize numberOfProducts
    public  int numberOfProducts    = 0;
                                            // ArrayList of Product Objects
    public  ArrayList<Product> productList = new ArrayList<Product>();

/*******************************************************************************
* CONSTRUCTORS
*******************************************************************************/
    public ProductList()                    // no-arg constructor
    {   
    } // ******************** END OF ProductList no-arg CONSTRUCTOR ************

/*******************************************************************************
* addProduct METHOD
*
* Description:  adds current Product Object to productList ArrayList
*       @param  Product productPassed
*******************************************************************************/
    public void addProduct( Product productPassed ){
        productList.add(productPassed);     // add Object to productList
        numberOfProducts++;                 // increment numberOfProducts
        System.out.println("ProductList:addProduct:numberOfProducts: " + numberOfProducts);
    } 

/*******************************************************************************
* show METHOD
*
* Description:  Display general current object information
*       @param  None
*******************************************************************************/
    public void show()
    {                                       // cycle through ArrayList entries
        for ( int i = 0; i < numberOfProducts; i++ ){
            System.out.println("\nEntry in ArrayList productList: " + (i+1));
                                            // Product.show() of current
                                            //  object in list
            productList.get(i).show();
       }      
    }

/*******************************************************************************
* MAIN METHOD - for TESTING purposes
* @param args
*******************************************************************************/
    public static void main(String[] args)
    {   // create 11 Product Objects
        Product a1 = new Product();
        Product a2 = new Product();
        Product a3 = new Product();
        Product a4 = new Product();
        Product a5 = new Product();
        Product a6 = new Product();
        Product a7 = new Product();
        Product a8 = new Product();
        Product a9 = new Product();
        Product a10 = new Product();
        Product a11 = new Product();
        // create ProductList ArrayList Object
        ProductList ProductList1 = new ProductList();
        // add 11 Product Objects to ArrayList (first index is 0)
        ProductList1.addProduct(a1);
        ProductList1.addProduct(a2);
        ProductList1.addProduct(a3);
        ProductList1.addProduct(a4);
        ProductList1.addProduct(a5);
        ProductList1.addProduct(a6);
        ProductList1.addProduct(a7);
        ProductList1.addProduct(a8);
        ProductList1.addProduct(a9);
        ProductList1.addProduct(a10);
        ProductList1.addProduct(a11);
        // use Product.display() for
        ProductList1.show();
    }
}
