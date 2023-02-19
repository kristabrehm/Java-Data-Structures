public class PlayerParser {

		//The below method uses the split() method to pull out
		//information about the fighter and returns an object of type PlayerEntity.
		//To parse the input string a wrapper class is used. 
	
		public static PlayerEntity parseNewPlayer(String lineToParse) {
	
			String[] array = lineToParse.split("/");
			
			//If input is a Mage an index 0
			//The following lines use the wrapper class to parse the input string into the respective variables.
			//Using the split method results in strings so you must parse into int/double/boolean.
			if(array[0].equalsIgnoreCase("Mage")) {


				Double health = Double.parseDouble(array[1]);
				String name = array[2];
				Integer stamina = Integer.parseInt(array[3]);
				Integer attack = Integer.parseInt(array[4]);
				String weapon = array[5];
				Double mana = Double.parseDouble(array[6]);
				
				//If the index 0 is a Mage, after parsing you will return a new Mage object
				PlayerEntity hero = new Mage(health, name, stamina, attack, weapon, mana);
				return hero;
			}
			
			//If input is a Fighter at index 0
			//The following lines use the wrapper class to parse the input string into the respective variables.
			//Using the split method results in strings so you must parse into int/double/boolean.
			if(array[0].equalsIgnoreCase("Fighter")) {

				String fighterType = array[6];
				boolean isRanged = true;
				
				Double health = Double.parseDouble(array[1]);
				String name = array[2];
				Integer stamina = Integer.parseInt(array[3]);
				Integer attack = Integer.parseInt(array[4]);
				String weapon = array[5];
				
				if(fighterType.equalsIgnoreCase("Range")){
					isRanged = true;
				}
			
				else if (fighterType.equalsIgnoreCase("Melee")) {
					 isRanged = false;
				}
				
				//If the index 0 is a Fighter, after parsing you will return a new Fighter object
				PlayerEntity hero = new Fighter(health, name, stamina, attack, weapon, isRanged);
				return hero;

			}
			
			//The method should return a type of object PlayerEntity
			//The object returned is either a fighter or mage, but not neither
			//In the case the hero was neither, the return would be null. 
			return null;
			
		}

	}
