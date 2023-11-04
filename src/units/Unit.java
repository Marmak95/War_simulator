package src.units;

/*
 * This class includes everything about what each unit should
 * be able to have and do.
 */

public class Unit {
	private String name;
	private int hp; // Health of the unit.
	private int damage; // Average damage of the unit.
	private int defense; // Armour reduces damage done by the enemy.
	private double accuracy; // The chance to hit the enemy.
	private double evasion; // The chance to avoid enemy attacks.
	private int attackSpeed; // The speed of performing attacks in milliseconds.
	private int timeUntilAttack; // The time until the unit will attack.

	public Unit(String name, int hp, int damage, int defense, double accuracy, double evasion, int attackSpeed) {
		this.name = name;
		this.hp = hp;
		this.damage = damage;
		this.defense = defense;
		this.accuracy = accuracy;
		this.evasion = evasion;
		this.attackSpeed = attackSpeed;
	}

	public String getName() {
		return this.name;
	}

	public int getHealth() {
		return this.hp;
	}

	public int getDamage() {
		return this.damage;
	}

	public int getDefense() {
		return this.defense;
	}

	public double getAccuracy() {
		return this.accuracy;
	}

	public double getEvasion() {
		return this.evasion;
	}
	
	public int getAttackSpeed() {
		return this.attackSpeed;
	}
	
	public int getTimeUntilAttack() {
		return this.timeUntilAttack;
	}
}
