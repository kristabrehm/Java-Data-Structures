import java.util.Scanner;

public class Assignment2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int userChoice = -1;
        int userInput1;
        int sum = -1, fac = -1, leftmost = -1;
        int length;

        do {
            displayMenu();
            userChoice = scanner.nextInt();
            
    		//The switch statement redirects the users choice into one of 6 cases. 
            //As long as the user does not select option 6, which is "quit", they will continue in the system.
            //Hence why there is a nested do, while loop. While the condition is not 6, the loop continues.
            
            switch (userChoice) {
            case 1:
                int i = 1;

                System.out.println("Enter a number:");
                userInput1 = scanner.nextInt();

    			//The following nested while loop runs while i (our increment) is less than or equal to the user imputed value.
    			//For example, if the user entered 60, the while loop would run until i = 60
                //For every iteration i increase (i++).
                
                sum = 0;
                
                while (i <= userInput1) {
                	sum = sum + i;
                    i++;
                }
                System.out.println("The sum of 1 to " + userInput1 + " is " + sum);
                System.out.println();
                break;

            case 2:
                i = 0;

                System.out.println("Enter a number:");
                userInput1 = scanner.nextInt();
                                
                //To calculate the factorial you need some sort of loop. Because you are multiplying every number from 1 to
                //The user imputed number, you need a way to keep track.
                //Using a for loop allows to you to keep track while the userInput1 is less than or equal to i. 
                //The loop will end as soon as userInput1 is greater than i.
                
                fac = 1;
                for (i = 1; i <= userInput1; i++) {
				    fac = fac * i;
			    }

                System.out.println("The factorial of " + userInput1 + " is " + fac);
                System.out.println();
                break;

            case 3:
            	int oddCount = 0;
                
                System.out.println("Enter the length of sequence");
                length = scanner.nextInt();
                
                int [] array = new int[length];
                
                System.out.println("Enter the sequence");

                //for loop is necessary to iterate over the length of the sequence 
                //the loop will stop when you are no longer less than the length imputed by the user

                for (i = 0; i < length; i++) {
                	array[i] = scanner.nextInt();
                }
                
               //For this specific case, I created an addition method.
               // Reference lines 170 through 180.
               //The value that is obtained through the method oddCounter() is then returned to the variable oddCount.
                
                oddCount = oddCounter(array, length);

                System.out.println("The count of odd integers in the sequence is " + oddCount);
                System.out.println();
                break;

            case 4:
                System.out.println("Enter a number:");
                
                userInput1 = scanner.nextInt();
                int userInput2 = userInput1;
                
                //Creating a while loop allows you to keep removing the rightmost digit until you reach the leftmost.
                //In this case the while loop will run until you can no longer remove any digits.
                
                while (userInput1 >= 10) {
                	leftmost = userInput1 /= 10; 
                }
                
                System.out.println("The leftmost digit of " + userInput2 + " is " + leftmost);
                System.out.println();
                break;

            case 5:
            	//The first thing I did was create a variable that could be used to track/declare the gcd.
                int gcd = 0;

                System.out.println("Enter the first integer: ");
                int x = scanner.nextInt();

                System.out.println("Enter the second integer: ");
                int y = scanner.nextInt();
                
               //For this specific case, I created an addition method.
               // Reference lines 124 through 133.
               //The value that is obtained through the method gcdCalculator() is then returned to the variable gcd.

                gcd = gcdCalculator(x, y);
                
                System.out.println("The greatest common divisor of " + x + " and " + y + " is " + gcd);
                System.out.println();
                break;

            case 6:
                System.out.print("Bye");
                
                break;
            }
        } while (userChoice != 6);
    }

    private static void displayMenu() {
        System.out.println("Please choose one option from the following menu:");
        System.out.println("1. Calculate the sum of integers from 1 to m");
        System.out.println("2. Calculate the factorial of a given number");
        System.out.println("3. Calculate the count of odd integers in a given sequence");
        System.out.println("4. Display the leftmost digit of a given number");
        System.out.println("5. Calculate the greatest common divisor of two given integers");
        System.out.println("6. Quit");
    }
    //The following method was created to calculate the gcd (case 5).
    //In the case we have 2 user imputed values, x and y. These values will need to be compared using a loop.
    //In this case I chose a while loop with a nested if-else statement.
    //As long as the second user value is not 0 the following holds true: 
    
    public static int gcdCalculator(int x, int y){
        while (y != 0){
            if (x > y){
                x = x - y;
            } else {
                y = y - x;
            }
        }
        //Return x represents the value that is returned to line 103 where the gcdCalculator() method is called.
        return x;
    }
    //the following method is used to keep count of the odd numbers in the sequence
    //Modulus allows you to keep track of the remainder, which in this case is odd numbers.
    
    public static int oddCounter(int [] array, int length){
    	int i;
    	int oddCount = 0;
    	
    	for(i = 0; i < length; i++) {
    	//the nested if loop is used to add a value to the oddCount as long as % 2 != 0	
    		if(array[i] % 2 != 0) {
        		oddCount++;
    		}	
    	}
    	return oddCount;
    	
    }
}
