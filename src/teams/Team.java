package src.teams;
import java.util.ArrayList;
import src.units.*;

/*
 * This class includes units within a team.
 */

public class Team {
	String name;
	ArrayList<Unit> units;
	
	public Team(String name, ArrayList<Unit> units) {
		this.name = name;
		this.units = units;
	}

	public ArrayList<Unit> getUnits() {
		return this.units;
	}

}
