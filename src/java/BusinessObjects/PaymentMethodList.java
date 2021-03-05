/*******************************************************************************
* Class: CIST 2931 Advanced Systems Project
* Semester: Fall 2020
* Instructor: Ronald Enz
* Description:  PaymentMethodList Object for TeamOneSportingGoods Project
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

import java.util.ArrayList;

/*******************************************************************************
* Class PaymentMethodList - Business Object - DB
*******************************************************************************/
public class PaymentMethodList {

/*******************************************************************************
* PROPERTIES - Declare CONSTANTS, variables
*******************************************************************************/
                                            // Initialize numberOfPaymentMethods
    public  int numberOfPaymentMethods    = 0;
                                            // ArrayList of PaymentMethodObjects
    public  ArrayList<PaymentMethod> pmArr = new ArrayList<PaymentMethod>();

/*******************************************************************************
* CONSTRUCTORS
*******************************************************************************/
    public PaymentMethodList()              // no-arg constructor
    {   
    } // ******************** END OF PaymentMethodList no-arg CONSTRUCTOR ******

/*******************************************************************************
* addPaymentMethod METHOD
*
* Description:  adds current PaymentMethod Object to pmArr ArrayList
*       @param  PaymentMethod pmPassed
*******************************************************************************/
    public void addPaymentMethod( PaymentMethod pmPassed ){
        pmArr.add(pmPassed);                // add Object to ArrayList pmArr
        numberOfPaymentMethods++;           // increment numberOfPaymentMethods
        System.out.println("PaymentMethodList:addPaymentMethod:numberOfPaymentMethods: " + numberOfPaymentMethods);
    } 

/*******************************************************************************
* show METHOD
*
* Description:  Display general current object information
*       @param  None
*******************************************************************************/
    public void show()
    {                                       // cycle through ArrayList entries
        for ( int i = 0; i < numberOfPaymentMethods; i++ ){
            System.out.println("\nEntry in ArrayList pmArr: " + (i+1));
                                            // PaymentMethod.show() of current
                                            //  object in list
            pmArr.get(i).show();
       }      
    }

/*******************************************************************************
* MAIN METHOD - for TESTING purposes
* @param args
*******************************************************************************/
    public static void main(String[] args)
    {   // create 11 PaymentMethod Objects
        PaymentMethod a1 = new PaymentMethod();
        PaymentMethod a2 = new PaymentMethod();
        PaymentMethod a3 = new PaymentMethod();
        PaymentMethod a4 = new PaymentMethod();
        PaymentMethod a5 = new PaymentMethod();
        PaymentMethod a6 = new PaymentMethod();
        PaymentMethod a7 = new PaymentMethod();
        PaymentMethod a8 = new PaymentMethod();
        PaymentMethod a9 = new PaymentMethod();
        PaymentMethod a10 = new PaymentMethod();
        PaymentMethod a11 = new PaymentMethod();
        // create PaymentMethodList ArrayList Object
        PaymentMethodList PaymentMethodList1 = new PaymentMethodList();
        // add 11 PaymentMethod Objects to ArrayList (first index is 0)
        PaymentMethodList1.addPaymentMethod(a1);
        PaymentMethodList1.addPaymentMethod(a2);
        PaymentMethodList1.addPaymentMethod(a3);
        PaymentMethodList1.addPaymentMethod(a4);
        PaymentMethodList1.addPaymentMethod(a5);
        PaymentMethodList1.addPaymentMethod(a6);
        PaymentMethodList1.addPaymentMethod(a7);
        PaymentMethodList1.addPaymentMethod(a8);
        PaymentMethodList1.addPaymentMethod(a9);
        PaymentMethodList1.addPaymentMethod(a10);
        PaymentMethodList1.addPaymentMethod(a11);
        // use PaymentMethod.display() for
        PaymentMethodList1.show();
    }
}
