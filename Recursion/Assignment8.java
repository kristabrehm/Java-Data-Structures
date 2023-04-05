import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Assignment8 {

	public static void main(String[] args) {
		
		String inputLine, stringName, stringRemoved, caseCValues, caseDValues; 
		char inputOpt = ' ';
		double sum;
		int firstInt, secondInt, factorialNumber, caseBValues;
		double[] array;
		
		
		try {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader stdin = new BufferedReader(isr);

            do {
                printMenu();
                inputLine = stdin.readLine().trim();
                if (inputLine.isEmpty()) {
                    continue;
                }
                inputOpt = inputLine.charAt(0);
                inputOpt = Character.toUpperCase(inputOpt);

                switch (inputOpt) {
            		// A: recursive method that calculates the sum of all elements in an array of
            		// doubles and returns the sum
                    case 'A':	
                    	System.out.print("Enter numbers (0 to finish):");
                    	array = parseDoubles(stdin);										//We must call the helper method parseDoubles using the buffered reader
                    																		//By doing so, we are taking all the elements in the array and declaring them of type double
                    	sum = sumArrayElements(array, array.length);						//We need to call the recursive method with the respective input types
                    			
                    	System.out.print(" Sum of elements in array: " + sum + "\n");
                    	break;
                    	
                    // B: recursive method that calculates the sum of all integers between two
                    // numbers (including the two numbers) and returns the sum    	
                    case 'B':
                    	System.out.print("Enter the first number: ");
                    	firstInt = readInteger(stdin);										//We must call the helper method readInteger using the buffered reader
                    																		//Reads in value as integer
                    	System.out.print("Enter the second number: ");
                    	secondInt = readInteger(stdin);										//We must call the helper method readInteger using the buffered reader
                    																		//Reads in value as integer
                    	caseBValues = calculateSum (firstInt, secondInt);
                    			
                    	System.out.print("The sum of all integers between " + firstInt + " and " + secondInt + " is: " + caseBValues + "\n");
                    	break;
                    	
                    // C: recursive method that calculates the prime factorization of an integer and returns a string as a result  	
                    case 'C':	
                        System.out.print("Enter an integer to factorize: ");				//We must call the helper method readInteger using the buffered reader
                    	factorialNumber = readInteger(stdin);								//Reads in value as integer
                    	
                    	int divide = 2; 													//In this case we are declaring the value that is used as a parameter as 2 
                    	caseCValues = factorial(factorialNumber, divide);					//because for prime factorization you are always dividing by 2
                    	
                    	System.out.print("The prime factorization of " + factorialNumber + " is: " + caseCValues + "\n");		
                    	break;  
                    
                    // D: recursive method that removes all occurrences of a specified substring in a string and returns the result string
                    case 'D':	
                    	System.out.print("Please enter string: ");			
                    	stringName = stdin.readLine().trim();								//Reads in String and trims it
                    	
                    	System.out.print("Please enter substring to remove: ");
                    	stringRemoved = stdin.readLine().trim();							//Reads in String and trims it
                    	
                    	caseDValues = removeSubstring(stringName, stringRemoved);			
                    	System.out.print("String after substring removal: " + caseDValues + "\n");
                    	break;
                    	
                    //Quit	
                    case 'E': 		
                    	break;
                    
                    //Default if no case is called or a different letter outside of A-E is declared
                    default:
                        System.out.print("Invalid choice. Please choose a char between A and E.\n");
                        break;
                }
                //While the user in not quitting the system, you must have catch statements in the case of an exception
            } while (inputOpt != 'E' || inputLine.length() != 1);
        }
        catch (IOException exception) {
            System.out.print("IO Exception\n");
        }
		catch (NumberFormatException ex) {
    		System.out.print("Invalid input. Only positive integers allowed. Please try again");
    	}
    }

	// ----------------------------------------------------------------------------------------

	// utility method for parsing doubles from standard input that returns an array of doubles
	public static double[] parseDoubles(BufferedReader reader) {
		String line = "";
		ArrayList<Double> container = new ArrayList<>();
		try {
			line = reader.readLine();
			double num = Double.parseDouble(line);

			while (num != 0) {
				container.add(num);
				line = reader.readLine();
				num = Double.parseDouble(line);
			}

		} catch (IOException ex) {
			System.out.println("IO Exception.");
		} catch (NumberFormatException e) {
			System.out.println("Invalid input, return to main menu.");
		}

		double[] result = new double[container.size()];
		for (int i = 0; i < container.size(); i++) {
			result[i] = container.get(i);
		}
		return result;
	}

	// utility method for parsing integers from standard input (only positive integers allowed)
    public static int readInteger(BufferedReader reader) throws IOException {
        int number = 0;
        try {
            String line = reader.readLine();
            number = Integer.parseInt(line);
        } catch (IOException e) {
            System.out.println("Error reading input. Please try again.");
            number = readInteger(reader);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please try again.");
            number = readInteger(reader);
        }
        if (number < 0) {
        	System.out.println("Invalid input. Only positive integers allowed. Please try again.");
        	number = readInteger(reader);
        }
        return number;
    }

	// utility method for printing the menu
	public static void printMenu() {
		System.out.print("\nWhat would you like to do?\n\n");
		System.out.print("A: Calculate the sum of all elements in an array of doubles\n");
		System.out.print("B: Calculate the sum of all integers between two numbers (including the two numbers)\n");
		System.out.print("C: Calculate the prime factorization of an integer\n");
		System.out.print("D: Remove all occurrences of a specified substring in a string\n");
		System.out.print("E: Quit\n\n");
	}
	
	//Task 1;
	//recursive method used to calculate sum of elements in array
	public static double sumArrayElements(double[] list, int index) {
		
		if (index == 0) {		//Base Case																
			return 0;					
		} else {				//If the index is not 0, execute recursively											
			return list[index - 1] + sumArrayElements(list, index - 1);
		}
	}

	
	//Task 2:
	// B: recursive method that calculates the sum of all integers between two integers
	public static int calculateSum(int valueOne, int valueTwo) {
		if (valueOne == valueTwo) {
			return valueTwo;			//Base Case		
		} else {
			//In this else statement we must have a nested if statement because it is possible that
			//valueTwo is larger than valueOne or vice versa. we must consider both cases.
			if (valueOne < valueTwo) {
				return valueOne + calculateSum(valueOne + 1, valueTwo);	
			}
				return valueOne + calculateSum(valueOne - 1, valueTwo);	
		}
	}
	
	//Task 3:
	//recursive method used to calculate prime factorization
	public static String factorial(int number, int divisor) {		
		
		if (number == divisor) {		//Base Case		
			return number + ""; 
		} 
		else if(number % divisor == 0) {
			//if the number being factorized is divisible by 2, the following recursive call is executed.
			//You are concating that recursive call to the divisor and "x".
			return divisor + "x" + factorial(number/divisor, 2);
		}
		else {
			return factorial(number, divisor + 1); 
		}
	}
	
	//Task 4:
	//Remove all occurrences of a substring within a string
	public static String removeSubstring(String s, String occurrences) {
		int indexOfOccurrence= s.indexOf(occurrences);
		
		if (indexOfOccurrence == -1) {			//Base Case		
			return s;
		} else {
			//Here, we are looking for the occurrence (substring) at a specific index within the string.
			//In the case that it is found, you return the recursive call where s in the substring of the occurrence plus the remaining length
			s = s.substring(0, indexOfOccurrence) + s.substring(indexOfOccurrence + occurrences.length());
			return removeSubstring(s, occurrences);
		}
	}
}
