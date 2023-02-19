import java.text.*;

//the Mage class inherits from the PlayerEntity class and is a child class
public class Mage extends PlayerEntity{

	//Instance Variable
	//Declared as private to protect encapsulation
	private double mana;
	
	//Constructor
	//"Super" is used to call the constructor from PlayerEntity and inherit the parent constructor
	//Mana is then added to the constructor as a new variable. Mana is not inherited.
	public Mage(double health, String name, int stamina, int attack, String weapon, double mana) {
		super(health, name, stamina, attack, weapon); //Calls Parent Constructor
		this.mana  = mana;
	}
	
	//Methods
	public void computeCombatPower() {
		//Type-Casting is needed here because combatPoints is an integer
		//while mana is declared as a double. You want combat points output as an integer value.
		
		combatPoints = (int)((attack + health)* (1 + mana));
		
		//Inside of this method you need to create an "if" loop because under the condition
		//that the mage is wielding a Staff, 30 extra points are added. But ONLY if they use a Staff.
		if (weapon.equals("Staff")) {
			combatPoints = (int)((attack + health)* (1 + mana) + 30);
		}

	}
	
	//The toString method uses super to call from the parent PLayerEntity class and inherit the toString method.
	//DecimalFormat is also used here to format mana output into a percent
	public String toString() {
		String str;
		
		double formatMana = (mana) * 100;
		
		DecimalFormat fff = new DecimalFormat("##.##");

		str = ("\nMage Hero:\n" +
			super.toString() + "Mana:\t\t" 			// Calls Parent Method
			+ (fff.format(formatMana)) + "%\n");
		return str;
	}

}
