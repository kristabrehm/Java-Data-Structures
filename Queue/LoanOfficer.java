public class LoanOfficer
{
   private int officerID;
   private Customer currentCustomer;

   //**************************************************
   //Constructor to initialize member variables
   //Initially no patient is assigned
   public LoanOfficer(int id)
   {
      this.officerID = id;
      currentCustomer = null;
   }

   //******************************************
   //an accessor method for the officer's ID
   public int getID()
   {
      return officerID;
   }

   //****************************************************************
   //method to determine if a loanOfficer currently has a customer by
   //checking the currentCustomer variable
   public boolean hasCustomer() {
	 if (currentCustomer == null) {										//if the current customer is null
		 return false;													//return false
	 } else {															//if the customer is not null (has no customer)
		 return true;													//return true
	 }
   }

   //************************************************************************
   //assign customer1 to currentCustomer if the officer does not have customer
   public boolean assignCustomer(Customer customer1) {
      if (hasCustomer() == false) {										//if the current customer is false (no customer)
    	  currentCustomer = customer1;									//assign customer1 to current customer
    	  return true;													//return true
      } else {															//else, if the officer has a customer
    	  return false;													//return false
      }
   }

   //*********************************************
   //This method simulates a loan officer handling a customer. 
   //If the loan officer has an assigned Customer, this method returns its currentCustomer 
   //and later set currentCustomer to null; otherwise, this method returns null.
   public Customer handleCustomer() {
      if (hasCustomer() != false) {										//if the current customer is false (no customer)
    	  Customer temp = currentCustomer;								//create a customer object and set it to currentCustomer
          currentCustomer = null;										//set the currentCustomer to null
    	  return temp; 													//return the customer object
      } 
      else {															//else, if the officer has a customer
    	  return null;													//return null
      }
   }

   //********************************************
   //toString method returns a string containing
   //the information of a loanOfficer
   public String toString()
   {
      String result = "\nOfficer ID: " + officerID;

      if (currentCustomer == null)
         result += " does not have any cutomers\n";
      else
         result += " is serving customer with id " + currentCustomer.getCustID() + "\n";

      return result;
   }
}
