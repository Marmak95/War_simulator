package src;
import java.util.ArrayList;
import java.util.Arrays;

import src.simEngine.SimulationEngine;
import src.teams.*;
import src.units.*;

/*
 * This is where the user runs the simulator and where
 * different inputs can be changed for the simulation.
 */

public class Main {
	
	// Function that adds x amount of units to an array list and returns the array list.
	private static ArrayList<Unit> addUnits(ArrayList<Unit> units, Unit unitType, int num){
		for(int i = 0; i < num; i++) {
			// Create a new instance of Unit for each unit.
	        Unit unit = new Unit(unitType.getName(), unitType.getHealth(), unitType.getDamage(),
	                             unitType.getDefense(), unitType.getAccuracy(), unitType.getEvasion(),
	                             unitType.getAttackSpeed(), unitType.getTimeUntilAttack());
	        units.add(unit);
		}
		return units;
	}

	public static void main(String[] args) {
		// Define the seed and initialize the simulation time and time step.
		final long seed = 1234; // The seed will randomize the results, but the results will stay the same for a seed.
		long startTime = System.currentTimeMillis();
		long currentTime = startTime;
		long timeStep = 1000; // 1 second time step (adjust as needed).
		
		// Create the units for the simulation.
		Unit swordsman = new Unit("Swordsman", 100, 12, 5, 0.8, 0.1, 500, 0);
		Unit ranger = new Unit("Ranger", 90, 13, 3, 0.85, 0.25, 600, 0);
		Unit armouredTroll = new Unit("Armoured troll", 225, 20, 10, 0.70, 0.0, 1800, 0);
		
		// Create the army for each team by creating array lists and adding different units.
		ArrayList<Unit> team1Units = new ArrayList<Unit>();
		ArrayList<Unit> team2Units = new ArrayList<Unit>();
		ArrayList<Unit> team3Units = new ArrayList<Unit>();
		
		team1Units = addUnits(team1Units, swordsman, 50);
		team1Units = addUnits(team1Units, ranger, 30);
		team2Units = addUnits(team2Units, swordsman, 40);
		team2Units = addUnits(team2Units, ranger, 40);
		team3Units = addUnits(team3Units, armouredTroll, 20);
		
		// Create the teams for the simulation.
		// Team 1 will currently always begin the attacks, then team 2 and so on.
		Team team1 = new Team("Team 1", team1Units);
		Team team2 = new Team("Team 2", team2Units);
		Team team3 = new Team("Team 3", team3Units);
		
		// Add all the teams in the war to a list of teams.
		ArrayList<Team> teams = new ArrayList<Team>(Arrays.asList(team1, team2, team3));

        // Initialize the simulation engine with user-defined parameters.
        SimulationEngine simulation = new SimulationEngine(seed, teams);
        
        // Prints to see what happens.
        System.out.println("The simulation starts.");
        
        // Simulation loop.
        while (true) {
        	// Calculate the time elapsed since the last update.
        	long newTime = System.currentTimeMillis();
        	long elapsedTime = newTime - currentTime;
        	currentTime = newTime;
        	
        	// Update the simulation with the elapsed time (e.g. attack other teams).
        	simulation.update(elapsedTime);
        	
        	// Display the simulation state.
        	simulation.currentStateStats();
        	
        	// Check for exit conditions (e.g., end simulation after a certain duration).
        	if(simulation.checkWarEnded() == true) {
        		// End the simulation since there was only one team left.
        		System.out.println("The simulation ended.");
        		System.exit(0);
        	}
        	
        	// Sleep to control the real-time pace of the simulation.
        	try {
        		Thread.sleep(timeStep);
        	} catch (InterruptedException e) {
        		// Handle any interruption.
        		System.out.println("The simulation was interupted.");
        		System.exit(1);
        	}
        }
	}
}
