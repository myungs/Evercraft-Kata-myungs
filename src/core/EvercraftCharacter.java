package core;

public class EvercraftCharacter {

	private static final int MINIMUM_DAMAGE = 1;

	private static final int CRITICAL_ROLL = 20;

	private String name;
	private Alignments alignment = Alignments.NEUTRAL;
	private int baseDamage = 1;
	private int armorClass = 10;
	private int hitPoints = 5;
	private int strength = 10;
	private int dexterity = 10;
	private int constitution = 10;
	private int wisdom = 10;
	private int intelligence = 10;
	private int charisma = 10;

	public EvercraftCharacter(String name) {
		this.name = name;
	}

	public boolean isDead() {
		return (hitPoints <= 0); 
	}
	
	//TODO Move roll logic out into combat class
	/*
	 * Returns true when hit Returns false when miss
	 */
	public boolean attackedBy(EvercraftCharacter attackingCharacter, int roll) {
		int rollWithMods = roll + attackingCharacter.getStrengthModifier();
		if (isHitBy(rollWithMods)) {
			dealDamageWithRoll(roll);
			return true;
		} else {
			return false;
		}
	}
	
	private boolean isHitBy(int totalRoll) {
		return (totalRoll >= armorClass);
	}
	
	private void dealDamageWithRoll(int roll) {
		if (CRITICAL_ROLL == roll) {
			hitPoints = hitPoints - (2 * baseDamage);
		} else {
			hitPoints = hitPoints - (baseDamage);
		}
	}
	
	
	public boolean attackedByRoll(int roll) {
		return attackedBy(new EvercraftCharacter("Foo"), roll);
	}
	
	public int getStrengthModifier() {
		return ScoreModifiers.getModifier(strength);
	}

	public int attackDamageBonus() {
		int calculatedDamage = baseDamage
				+ getStrengthModifier();
		if (calculatedDamage < MINIMUM_DAMAGE) {
			return MINIMUM_DAMAGE;
		} else {
			return calculatedDamage;
		}
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Alignments getAlignment() {
		return alignment;
	}

	public void setAlignment(Alignments alignment) {
		this.alignment = alignment;
	}

	public int getArmorClass() {
		return armorClass;
	}

	public int getHitPoints() {
		return hitPoints;
	}
	
	public void setHitPoints(int hitPoints) {
		this.hitPoints = hitPoints;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getDexterity() {
		return dexterity;
	}

	public void setDexterity(int dexterity) {
		this.dexterity = dexterity;
	}

	public int getConstitution() {
		return constitution;
	}

	public void setConstitution(int constitution) {
		this.constitution = constitution;
	}

	public int getWisdom() {
		return wisdom;
	}

	public void setWisdom(int wisdom) {
		this.wisdom = wisdom;
	}

	public int getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}

	public int getCharisma() {
		return charisma;
	}

	public void setCharisma(int charisma) {
		this.charisma = charisma;
	}

}
