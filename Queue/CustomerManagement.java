import java.util.LinkedList;

public class CustomerManagement
{
   private LinkedList<Customer> LEQueue;
   private LinkedList<Customer> MEQueue;
   private LinkedList<Customer> SEQueue;

   private LinkedList<Customer> checkoutQueue;

   private LoanOfficer[] officerList;

   //**********************************************
   //Constructor
   public CustomerManagement(int numOfLoanOfficers)
   {
      LEQueue = new LinkedList<Customer>();
      MEQueue = new LinkedList<Customer>();
      SEQueue = new LinkedList<Customer>();
      checkoutQueue = new LinkedList<Customer>();

      //creating LoanOfficer objects
      officerList = new LoanOfficer[numOfLoanOfficers];
      for (int i=0; i< officerList.length; i++)
      {
         officerList[i] = new LoanOfficer(i);
      }
   }

   //*******************************************************************
   //add a customer to the corresponding queue based on its category
   //return true if added to a queue successfully; otherwise return false
   boolean addCustomer(int id, String category) {
	   Customer customer1 = new Customer(id, category);					
	   																	//We need 3 if statements, one for each queue parameter
	   if (category.equals("LE")) {										//if the category equals LE 
		   LEQueue.add(customer1);										//Add customer to queue
	       return true;													//return true
	      } else if (category.equals("ME")) {							//if the category equals ME 
	    	  MEQueue.add(customer1);									//Add customer to queue
	    	  return true;												//return true
	      } else if (category.equals("SE")) {							//if the category equals SE 
	    	  SEQueue.add(customer1);									//Add customer to queue
		      return true;											    //return true
	      } 												
	    return false;												    //return false
   }

   //the below method is a helper method that corresponds to looping 
   //through the officerList array for assignCustomerToLoanOfficer().
   //Based off of the method explanation, if the index is found, use that index
   int officerForLoop() {
	   for (int i = 0; i < officerList.length; i++) {                  //iterate through the array of officers
		   if (officerList[i].hasCustomer()== false) {                 //if a match is found,
			   return i;                                               //set the location of the officer equal to i
		   }  
	   }
	   return -1;														//else if the officer is not found return -1
   }
   
   //*******************************************************************
   //assign a customer to a loan officer with large enterprise (LE) queues
   //going first; return null if there are no customers in the queues or if
   //there are no loan officer are available
   Customer assignCustomerToLoanOfficer(){		
	   Customer temp;													//create a customer variable
	   
	   //return null of no customers in all 3 queues or no officers available
	   if((LEQueue.isEmpty()) && (MEQueue.isEmpty()) && (SEQueue.isEmpty()) || officerForLoop() == -1) {
		   return null;
	   }

	      if(!LEQueue.isEmpty()) {										//Corresponds to the LEQueue
	         temp = LEQueue.removeFirst();										//get the customer and remove them
	         officerList[officerForLoop()].assignCustomer(temp);		//assign officer to an customer
	         return temp;												//return that customer
	      }
	      else if(!MEQueue.isEmpty()) {								    //Corresponds to the MEQueue
	         temp = MEQueue.removeFirst();										//get the customer
	         officerList[officerForLoop()].assignCustomer(temp);		//assign officer to an customer
	         return temp;												//return that customer
	      }
	      else if(!SEQueue.isEmpty()) {								    //Corresponds to the SEQueue
	         temp = SEQueue.removeFirst();										//get the customer
	         officerList[officerForLoop()].assignCustomer(temp);		//assign officer to an customer
	         return temp;												//return that customer
	      } else {														//for all other cases
	    	  return null;												//return null
	   }
   }

   //***************************************************************
   //check if officer with the officerID has a customer, and release
   //that customer if they do. Then add that customer to checkout queue
   //and return the Customer object; otherwise return null				
   Customer releaseCustomerFromOfficer(int officerID){	
	   Customer temp;													//create temporary customer object
	   int locationOfOfficer = -1;										//create a variable to find the officers location
	   
	   for (int i = 0; i < officerList.length; i++) {					//iterate through the array of officers
		   if (officerList[i].getID() == officerID) {					//if a match is found,
			   locationOfOfficer = i;									//set the location of the officer equal to i
		   }
	   }
	   if (locationOfOfficer == -1) {									//if the officer is not found
		   return null;													//return null
	   }
	   if (officerList[locationOfOfficer].hasCustomer()) {				//now, if the officer has a customer
    	  temp = officerList[locationOfOfficer].handleCustomer();		//handle the customer 
    	  checkoutQueue.add(temp);										//add the customer to the checkoutQueue
    	  return temp;													//return the customer
      }
	   return null;														//by default return null
   }

   //**************************************************************
   //remove the first Customer from the checkoutQueue and return it;
   //otherwise the method return null.
   public Customer checkoutCustomer() {								
	   if(!checkoutQueue.isEmpty()) {			    					//create customer object
		   return checkoutQueue.removeFirst();  						//return the customer removed
	   } 																//else, if queue is empty
	   return null;													    //return null
   }

   //************************************************
   //The printQueue prints out the content
   //of the queues and the array of loan officers
   public void printQueues()
   {
      System.out.print("\nLarge Enterprise Queue:\n" + LEQueue.toString() + "\n");
      System.out.print("\nMedium Enterprise Queue:\n" + MEQueue.toString() + "\n");
      System.out.print("\nSmall Enterprise Queue:\n" + SEQueue.toString() + "\n\n");
      for (int i = 0; i < officerList.length; i++)
      {
         System.out.print(officerList[i].toString());
      }
      System.out.print("\nCheckout Customer Queue:\n" + checkoutQueue.toString() + "\n\n");
   }
  }
