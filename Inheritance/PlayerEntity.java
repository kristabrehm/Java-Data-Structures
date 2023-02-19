
public abstract class PlayerEntity {

		//Instance Variables.
		//Declared as protected because they are inherited by the Mage & Fighter class.
		//You need to protect encapsulation.
	
		protected double health;
		protected String entityName;
		protected int stamina;
		protected int attack;
		protected int combatPoints;
		protected String weapon;
		
		//Constructor
		//Sets default instance variables
		public PlayerEntity (double health, String name, int stamina, int attack, String weapon) {
			
			this.health = health;
			this.entityName = name;
			this.stamina = stamina;
			this.attack = attack;
			this.weapon = weapon;
			
			this.combatPoints = 0;
	}
		
		//Accessor (Getter) Method
		public int getCombatPoints() {
			return combatPoints;
		}
		
		//Abstract Method
		//This method is implemented by the child classes Mage and Fighter
		//to update combat power.
		public abstract void computeCombatPower();
		
		//toString Method
		//Concats together all of the output variable values into one string to be returned
		public String toString() {
			String string;
			string = ("Hero name:\t\t" + entityName +
					"\nCurrent Health:\t\t" + health + 
					"\nStamina:\t\t" + stamina + 
					"\nAttack Damage:\t\t" + attack +
					"\nWeapon:\t\t\t" + weapon +
					"\nCurrent Combat Points:\t" + combatPoints + "\n");
			return string;
		}

}
