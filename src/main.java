package src;
import java.util.Scanner;
import java.util.ArrayList;
import src.simEngine.SimulationEngine;
import src.teams.*;
import src.units.*;

/*
 * This is where the user runs the simulator and where
 * different inputs can be changed for the simulation.
 */

public class main {

	public static void main(String[] args) {
        // Define the seed.
		final int seed = 1234;
		
		// Initialize the simulation time and time step.
        long startTime = System.currentTimeMillis();
        long currentTime = startTime;
        long timeStep = 1000; // 1 second time step (adjust as needed).
		
		
		// Create the units for the simulation.
        Unit[] team1Units = {};
        Unit[] team2Units = {};
        
        
		Unit swordsman = new Unit("Swordsman", 100, 12, 5, 0.8, 0.1);
		Unit ranger = new Unit("Ranger", 90, 13, 3, 0.85, 0.15);
		
		// Create the teams for the simulation.
		Team team1 = new Team("Team 1", team1Units) ;
		Team team2 = new Team("Team 2", team2Units);
		
		// Add all the teams in the war to a list of teams.
		Team[] teams = {team1, team2};

        // Initialize the simulation engine with user-defined parameters.
        SimulationEngine simulation = new SimulationEngine(seed, teams);

        // Simulation loop.
        while (true) {
            // Calculate the time elapsed since the last update.
            long newTime = System.currentTimeMillis();
            long elapsedTime = newTime - currentTime;
            currentTime = newTime;

            // Update the simulation with the elapsed time (e.g., move units, handle interactions).
            simulation.update(elapsedTime);

            // Display the simulation state (if needed).

            // Check for exit conditions (e.g., end simulation after a certain duration).

            // Sleep to control the real-time pace of the simulation.
            try {
                Thread.sleep(Math.max(0, timeStep - elapsedTime));
            } catch (InterruptedException e) {
                // Handle any interruption.
            }
        }
	}

}
