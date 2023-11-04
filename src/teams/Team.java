package src.teams;
import src.units.*;

/*
 * This class includes units within a team.
 */

public class Team {
	String name;
	Unit[] units;
	
	public Team(String name, Unit[] units) {
		this.name = name;
		this.units = units;
	}

}
