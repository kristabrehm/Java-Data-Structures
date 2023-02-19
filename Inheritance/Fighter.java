//the Fighter class inherits from PlayerEntity class and is a child class
public class Fighter extends PlayerEntity {
	
	//Instance Variables
	//Declared as private to protect encapsulation
	private double armor;
	private int maxAttack;
	private boolean isRanged;
	
	
	//Constructor
	//"Super" is used to call the constructor from PlayerEntity and inherit the parent constructor
	//Armor, maxAttack and isRanged are all then added to the constructor as new variables. 
	//Armor, maxAttack and isRanged are not inherited.
	public Fighter (double health, String name, int stamina, int attack, String weapon, boolean isRanged) {
		super(health, name, stamina, attack, weapon); //Calls Parent Constructor
		this.maxAttack = attack;
		this.isRanged = isRanged;
		
		
		//The following loops are used to initialize the value of isRanged.
		//isRanged value is dependent upon if the fighter is ranged (from a distance) or melee (close)
		//In the boolean, fight from a distance is TRUE
		//Melee is FALSE

		if(isRanged == true){		//the fighter is ranged (can fight from a distance)
			armor = 0.25;
			maxAttack = 125;
		}
		 else if (isRanged == false) {		//the fighter is melee (not ranged)
			armor = 0.50;
			maxAttack = 100;
		}

	}

	
	//Methods
	
	//The following method is used to used to compute the fighters power points
	//The first if-else statement determined the initial combatPoints based off of the attack attribute.
	//If the maxAttack is less than or equal to the attack, you declare combatPoints as one formula, else wise you use the other formula.
	//The final 2 if statements are used in specific scenarios to add additional points.
	
	public void computeCombatPower() {
		if (maxAttack <= attack){
			combatPoints = (int)((maxAttack + health) * (1 - armor));	
		}
		else {
			combatPoints = (int)((attack + health) * (1 - armor));
		}
		

		if ((isRanged == false) && (weapon.equalsIgnoreCase("Sword"))) {
			combatPoints = (combatPoints + combatPoints);
		}
		if ((isRanged == true) && (weapon.equalsIgnoreCase("Rock"))) {
				combatPoints = combatPoints + 50;
		}
	}
	//The toString method uses super to call from the parent PLayerEntity class and inherit the toString method.
	//Similar to the Mage class, DecimalFormat is also used here to format armor output into a percent
	public String toString() {
		String fighterString = "";
		
		double formatArmor = (armor) * 100;
		
		DecimalFormat ff = new DecimalFormat("##.##");

		if (isRanged == false) {
			fighterString =  ("\nFighter Hero:\t\tMelee Type\n" +
				super.toString() + 
				"Armor:\t\t\t" + (ff.format(formatArmor)) + "%\n");
		}
		else if (isRanged == true){
			fighterString =  "\nFighter Hero:\t\tRanged Type\n" +
					 super.toString() + 
					"Armor:\t\t\t" + (ff.format(formatArmor)) + "%\n";
		}
		return fighterString;
	}

}
