package src.teams;
import java.util.ArrayList;
import src.units.*;

/*
 * This class includes units within a team.
 */

public class Team {
	private String name;
	private ArrayList<Unit> units;
	private int kills;
	
	public Team(String name, ArrayList<Unit> units) {
		this.name = name;
		this.units = units;
	}

	public ArrayList<Unit> getUnits() {
		return this.units;
	}

	public String getName() {
		return this.name;
	}
	
	public int getKills() {
		return this.kills;
	}
	
	public void setKills(int kills) {
		this.kills = kills;
	}
}
