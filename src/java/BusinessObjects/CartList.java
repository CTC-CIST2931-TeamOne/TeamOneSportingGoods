/*******************************************************************************
* Class: CIST 2931 Advanced Systems Project
* Semester: Fall 2020
* Instructor: Ronald Enz
* Description:  CartList Object for TeamOneSportingGoods Project
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

import java.util.ArrayList;

/*******************************************************************************
* Class CartList - Business Object - DB
*******************************************************************************/
public class CartList {

/*******************************************************************************
* PROPERTIES - Declare CONSTANTS, variables
*******************************************************************************/
                                            // Initialize numberOfProducts
    public  int numberOfProducts    = 0;
                                            // ArrayList of Cart Objects
    public  ArrayList<Cart> cArr = new ArrayList<Cart>();

/*******************************************************************************
* CONSTRUCTORS
*******************************************************************************/
    public CartList()                       // no-arg constructor
    {   
    } // ******************** END OF CartList no-arg CONSTRUCTOR ******

/*******************************************************************************
* addCart METHOD
*
* Description:  adds current Cart Object to cArr ArrayList
*       @param  Cart cPassed
*******************************************************************************/
    public void addCart( Cart cPassed ){
        cArr.add(cPassed);                  // add Object to ArrayList cArr
        numberOfProducts++;                 // increment numberOfProducts
        System.out.println("CartList:addCart:numberOfProducts: " 
                            + numberOfProducts);
    } 

/*******************************************************************************
* removeCart METHOD
*
* Description:  removes current Cart Object from cArr ArrayList
*       @param  Cart cPassed
*******************************************************************************/
    public void removeCart( int cPassed ){
    cArr.remove(cPassed);                   // remove Object from ArrayList cArr
        numberOfProducts--;                 // decrement numberOfProducts
        System.out.println("CartList:removeCart:numberOfProducts: " 
                            + numberOfProducts);
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
            System.out.println("\nEntry in ArrayList cArr: " + (i+1));
                                            // Cart.show() of current
                                            //  object in list
            cArr.get(i).show();
       }      
    }

/*******************************************************************************
* MAIN METHOD - for TESTING purposes
* @param args
*******************************************************************************/
    public static void main(String[] args)
    {   // create 11 Cart Objects
        Cart a1 = new Cart();
        Cart a2 = new Cart();
        Cart a3 = new Cart();
        Cart a4 = new Cart();
        Cart a5 = new Cart();
        Cart a6 = new Cart();
        Cart a7 = new Cart();
        Cart a8 = new Cart();
        Cart a9 = new Cart();
        Cart a10 = new Cart();
        Cart a11 = new Cart();
        // create CartList ArrayList Object
        CartList CartList1 = new CartList();
        // add 11 Cart Objects to ArrayList (first index is 0)
        CartList1.addCart(a1);
        CartList1.addCart(a2);
        CartList1.addCart(a3);
        CartList1.addCart(a4);
        CartList1.addCart(a5);
        CartList1.addCart(a6);
        CartList1.addCart(a7);
        CartList1.addCart(a8);
        CartList1.addCart(a9);
        CartList1.addCart(a10);
        CartList1.addCart(a11);
        // use Cart.display() for
        CartList1.show();
    }
}
