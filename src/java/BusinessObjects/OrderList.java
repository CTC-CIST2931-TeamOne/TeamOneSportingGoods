/*******************************************************************************
* Class: CIST 2931 Advanced Systems Project
* Semester: Fall 2020
* Instructor: Ronald Enz
* Description:  OrderList Object for TeamOneSportingGoods Project
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

import java.util.ArrayList;

/*******************************************************************************
* Class OrderList - Business Object - DB
*******************************************************************************/
public class OrderList {

/*******************************************************************************
* PROPERTIES - Declare CONSTANTS, variables
*******************************************************************************/
                                            // Initialize numberOfOrders
    public  int numberOfOrders    = 0;
                                            // ArrayList of OrderObjects
    public  ArrayList<Order> oArr = new ArrayList<Order>();

/*******************************************************************************
* CONSTRUCTORS
*******************************************************************************/
    public OrderList()                      // no-arg constructor
    {   
    } // ******************** END OF OrderList no-arg CONSTRUCTOR ******

/*******************************************************************************
* addOrder METHOD
*
* Description:  adds current Order Object to oArr ArrayList
*       @param  Order oPassed
*******************************************************************************/
    public void addOrder( Order oPassed ){
        oArr.add(oPassed);                  // add Object to ArrayList oArr
        numberOfOrders++;                   // increment numberOfOrders
        System.out.println("OrderList:addOrder:numberOfOrders: " 
                            + numberOfOrders);
    } 

/*******************************************************************************
* show METHOD
*
* Description:  Display general current object information
*       @param  None
*******************************************************************************/
    public void show()
    {                                       // cycle through ArrayList entries
        for ( int i = 0; i < numberOfOrders; i++ ){
            System.out.println("\nEntry in ArrayList oArr: " + (i+1));
                                            // Order.show() of current
                                            //  object in list
            oArr.get(i).show();
       }      
    }

/*******************************************************************************
* MAIN METHOD - for TESTING purposes
* @param args
*******************************************************************************/
    public static void main(String[] args)
    {   // create 11 Order Objects
        Order a1 = new Order();
        Order a2 = new Order();
        Order a3 = new Order();
        Order a4 = new Order();
        Order a5 = new Order();
        Order a6 = new Order();
        Order a7 = new Order();
        Order a8 = new Order();
        Order a9 = new Order();
        Order a10 = new Order();
        Order a11 = new Order();
        // create OrderList ArrayList Object
        OrderList OrderList1 = new OrderList();
        // add 11 Order Objects to ArrayList (first index is 0)
        OrderList1.addOrder(a1);
        OrderList1.addOrder(a2);
        OrderList1.addOrder(a3);
        OrderList1.addOrder(a4);
        OrderList1.addOrder(a5);
        OrderList1.addOrder(a6);
        OrderList1.addOrder(a7);
        OrderList1.addOrder(a8);
        OrderList1.addOrder(a9);
        OrderList1.addOrder(a10);
        OrderList1.addOrder(a11);
        // use Order.display() for
        OrderList1.show();
    }
}
