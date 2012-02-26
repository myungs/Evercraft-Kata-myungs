package core;

public class EvercraftCharacter {

	private static final int MINIMUM_DAMAGE = 1;
	private static final int BASE_HEALTH = 5;
	private static final int MINIMUM_MAX_HEALTH = 1;
	private static final int MINIMUM_LEVEL = 1;
	private static final int CRITICAL_ROLL = 20;

	private String name;
	private Alignments alignment = Alignments.NEUTRAL;
	private int baseDamage = MINIMUM_DAMAGE;
	private int armorClass = 10;
	private int strength = 10;
	private int dexterity = 10;
	private int constitution = 10;
	private int wisdom = 10;
	private int intelligence = 10;
	private int charisma = 10;
	private int maxHitPoints = BASE_HEALTH;
	private int currentHitPoints = maxHitPoints;
	private int level = 1;
	private int experience = 0;

	public EvercraftCharacter(String name) {
		this.name = name;
	}

	public boolean isDead() {
		return (currentHitPoints <= 0); 
	}
	
	/*
	 * Returns true when hit Returns false when miss
	 */
	public boolean attack(EvercraftCharacter targetCharacter, int roll) {
		int rollWithMods = roll + getStrengthModifier();
		if (targetCharacter.isHitBy(rollWithMods)) {
			targetCharacter.takeDamageWithRoll(roll);
			this.addExperience(10);
			return true;
		} else {
			return false;
		}
	}	
	
	private boolean isHitBy(int totalRoll) {
		return (totalRoll >= armorClass);
	}
	
	private void takeDamageWithRoll(int roll) {
		if (CRITICAL_ROLL == roll) {
			currentHitPoints = currentHitPoints - attackDamageOnCrits();
		} else {
			currentHitPoints = currentHitPoints - attackDamage();
		}
	}
	
	public int getStrengthModifier() {
		return ScoreModifiers.getModifier(strength);
	}

	public int attackDamageOnCrits() {
		return (2 * attackDamage());
	}
	
	public int attackDamage() {
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
		return armorClass + ScoreModifiers.getModifier(dexterity);
	}

	public int getCurrentHitPoints() {
		return currentHitPoints;
	}
	
	public void setCurrentHitPoints(int hitPoints) {
		this.currentHitPoints = hitPoints;
	}
	
	public int getMaxHitPoints() {
		return maxHitPoints;
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
		this.maxHitPoints = BASE_HEALTH + ScoreModifiers.getModifier(constitution);
		if(this.maxHitPoints < MINIMUM_MAX_HEALTH)
			this.maxHitPoints = MINIMUM_MAX_HEALTH;
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

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
		if(this.level < MINIMUM_LEVEL)
			this.level = MINIMUM_LEVEL;
	}
	
	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
		setLevel((experience/1000) + 1);
	}

	public void addExperience(int experience) {
		setExperience(getExperience() + experience);
	}

}
