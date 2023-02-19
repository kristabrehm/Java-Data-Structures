public class Assignment5 {
    public static void main(String[] args){
        char input;
        String line;
        String inputInfo;

        // ArrayList used to store the hero objects
        ArrayList<PlayerEntity> playerList = new ArrayList<>();

        try{
            System.out.println("Welcome to the battle stats simulator!");
            printMenu();

            // create a BufferedREader object to read input from a keyboard
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader stdin = new BufferedReader(isr);

            do{
                System.out.println("\nWhat action would you like to perform?");
                line = stdin.readLine().trim();
                input = line.charAt(0);
                input = Character.toUpperCase(input);
                if(line.length() == 1){
                    switch (input){
                        case 'A': // add hero to the guild
                            System.out.println("Please enter your hero stats:");
                            inputInfo = stdin.readLine().trim();

                            //The following line takes in input from inputInfo and calls the method parseNewPlaer
                            //in the PlayerParser class and adds it to the arrayList.
                            
                            playerList.add(PlayerParser.parseNewPlayer(inputInfo));
                            
                            break;

                        case 'C': // calculate combat points
                            
                        	//The below for loop is needed to iterate over the entire arrayList to calculate for each hero.
                        	//You then must get the hero at its respective index and compute the power.
                        	//After computed the below statement is out-printed.
                        	
                    		for (int i = 0; i < playerList.size(); i++) {
                    			playerList.get(i).computeCombatPower();
                    		}
                    		
                    		System.out.print("Combat points computed\n");
                    		
                        	break;

                        case 'D': // how many heroes have combat points equal to or larger than a user-defined value
                            System.out.print("Please enter a minimum combat points you want to calculate:\n");
                            inputInfo = stdin.readLine().trim();
                            int min = Integer.parseInt(inputInfo);
                            int count = 0;

                            //the below for loop iterates through all of the objects in the arrayList
                            //We want to test how many of the heroes have a higher combat power than min
                            
                           
                            for (int i = 0; i < playerList.size(); i++) {
                            	if (playerList.get(i).getCombatPoints() >= min) {
                            		count++;
                            	}
                    		}
                            System.out.println("The number of heroes with " + min
                                    + " combat points or more is: " + count);	
                            break;

                        case 'L': // list heroes

                        	//the following code runs off of the boolean if the array is empty or not
                        	//If the array is empty (answer == true) then "no heroes in guild yet" is printed
                        	//If the array is not empty (answer == false) then all of the heros are printed
                        	
                        	boolean answer = playerList.isEmpty();
                        	
                        	if (answer == false) {
                        		for (int i = 0; i < playerList.size(); i++) {
                        			System.out.print(playerList.get(i).toString());
                        		}
                        	}
                        	if (answer == true) {
                        		System.out.print("No heroes in guild yet.\n");
                        	}
                        	break;

                        case 'Q':
                            break;

                        case '?':
                            printMenu();
                            break;

                        default:
                            System.out.print("Unknown action\n");
                            break;
                    }
                }
                else
                    System.out.println("Unknown action");

            }while (input != 'Q');
            System.out.println("Thanks for playing!");
        }
        catch(IOException e){
            System.out.println("IO Exception");
        }
    }


    public static void printMenu(){
        System.out.print("Choice\t\tAction\n" +
                "------\t\t------\n" +
                "A\t\tAdd Hero\n" +
                "C\t\tCompute Combat Points\n" +
                "D\t\tCount Heroes with Minimum Combat Points\n" +
                "L\t\tList Heroes\n" +
                "Q\t\tQuit\n" +
                "?\t\tDisplay Help\n\n");
    }
}
