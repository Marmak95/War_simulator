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

    public SimulationEngine(long seed, ArrayList<Team> teams2) {
        this.seed = seed;
        this.random = new Random(seed);
        this.teams = teams2;
    }

    public void update(long elapsedTime) {
        // Update the simulation based on the elapsed time.

        // Simulate unit movements, actions, and interactions.
        simulateWar(teams, elapsedTime);

        // Determine the winner if needed (e.g., at the end of the simulation).
        Team winner = determineWinner(teams);

        // Display real-time results or state updates, if desired.
        displayResults(winner);
    }

    public boolean checkWarEnded() {
    	// Check if the war has ended.
        if(this.teams.size() == 1) {
        	return true;
        }
    	return false;
    }
    
    public boolean checkAllUnitsDead(Team team) {
    	// Check if all the units of a team are dead.
	    for (Unit unit : team.getUnits()) {
	        if(unit.getHealth() > 0) {
	        	return false;
	        }
	    }
	    return true;
    }
    
    public void currentStateStats() {
    	// Print out the current state of the simulation with all the information.
        
    }
    
    private void simulateWar(ArrayList<Team> teams, long elapsedTime) {
        // Implements the logic to simulate the war, including unit interactions.
        // Includes real-time updates: the time elapsed since the last update.
    	
    }

    private Team determineWinner(ArrayList<Team> teams) {
        // Determine which team won the war based on your simulation results.
        // Factors can be the number of surviving units, strategy, etc.
        // Return the winning team.
    	return null;
    }

    private void displayResults(Team winner) {
        // Display the results of the war simulation to the user.
        // Show the winning team, statistics, and any other relevant information.
    }
}
