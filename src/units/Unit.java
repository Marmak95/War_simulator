package src.units;

/*
 * This class includes everything about what each unit should
 * be able to have and do.
 */

public class Unit {
	String name;
	int hp; // Health of the unit.
	int damage; // Average damage of the unit.
	int armour; // Armour reduces damage done by the enemy.
	double hitChance; // The chance to hit the enemy.
	double dodge; // The chance to avoid enemy attacks.

	public Unit(String name, int hp, int damage, int armour, double hitChance, double dodge) {
		this.name = name;
		this.hp = hp;
		this.damage = damage;
		this.armour = armour;
		this.hitChance = hitChance;
		this.dodge = dodge;
	}
}
