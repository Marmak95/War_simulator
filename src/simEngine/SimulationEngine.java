package src.simEngine;
import java.util.ArrayList;
import java.util.Random;
import src.teams.*;
import src.units.*;

/*
 * This class simulates the war and displays the results.
 */

public class SimulationEngine {
    private long seed;
    private Random random;
    private ArrayList<Team> teams;

    public SimulationEngine(long seed, ArrayList<Team> teams) {
        this.seed = seed;
        this.random = new Random(seed);
        this.teams = teams;
    }

    public void update(long elapsedTime) {
        // Update the simulation based on the elapsed time.
    	
    	// Simulate unit attacks.
        simulateWar(teams, elapsedTime);
        
    	// Determine the winner.
        Team winner = determineWinner(teams);

        // Display real-time winner results.
        displayResults(winner);
    }

    public boolean checkWarEnded() {
    	// Check if the war has ended.
        if(this.teams.size() == 1) {
        	return true;
        }
    	return false;
    }
    
    public void currentStateStats() {
    	// Print out the current state of the simulation with all the information.
    	System.out.println("Current state stats:");
    	for(Team team : teams) {
    		System.out.println(team.getName() + " | Units left: " + team.getUnits().size());
    	}
    }
    
    private void simulateWar(ArrayList<Team> teams, long elapsedTime) {
        // Implements the logic to simulate the war, including unit interactions.
        // Includes real-time updates: the time elapsed since the last update.
    	
    	// All units will attack one time on one of the other teams' units if
    	// timeUntilAttack is available for the unit.
    	for(Team team : teams) {
    		Team attackerTeam = team;
    		for (Unit unit : team.getUnits()) {
    			// Select a random target unit from a different team to attack.
                Team targetTeam;
                Unit targetUnit;
                
                // Do not attack if there is only one team left.
                if(teams.size() == 1) {
        			break;
        		}
                
                do {
                    targetTeam = teams.get(random.nextInt(teams.size())); // Randomly select a target team.
                } while (targetTeam == attackerTeam); // Ensure the target team is different.

                ArrayList<Unit> targetUnits = targetTeam.getUnits();
                targetUnit = targetUnits.get(random.nextInt(targetUnits.size())); // Randomly select a target unit.

                // Attack the targeted unit if the time until attack is less than or equal to 0 milliseconds.
                if(unit.getTimeUntilAttack() <= 0) {
                	// Hit or miss the target unit.
                	if(random.nextDouble() <= unit.getAccuracy()) {
                		// If the defense is higher than the damage done, then the attack did 0 damage.
                		if(targetUnit.getDefense() - unit.getDamage() > 0) {
	                		targetUnit.setHealth(targetUnit.getHealth());
	                	}
	                	else {
	                		targetUnit.setHealth(targetUnit.getHealth() + targetUnit.getDefense() - unit.getDamage());
	                	}
                	}
                }
                
                // Check if the target unit died, if so delete it from the target army.
                if(targetUnit.getHealth() <= 0) {
                	targetUnits.remove(targetUnit);
                }
                
                // Remove the target team if it does not have any more units alive.
                if(targetTeam.getUnits().size() == 0) {
                	teams.remove(targetTeam);
                }
                
                unit.updateTimeUntilAttack();
    	    }
    	}
    }

    private Team determineWinner(ArrayList<Team> teams) {
        // Determine which team won the war based on your simulation results.
        // Factors can be the number of surviving units, strategy, etc.
        // Return the winning team.
    	if(teams.size() == 1) {
    		Team winningTeam = teams.get(0);
    		return winningTeam;
    	}
    	else {
    		return null;
    	}
    }

    private void displayResults(Team winner) {
        // Display the results of the war simulation to the user.
        // Show the winning team, statistics, and any other relevant information.
    	if(winner != null) {
    		System.out.println("The winner is: " + winner.getName() + "!");
    	}
    }
}
