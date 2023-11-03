package src;
import java.util.Scanner;
import src.simEngine.SimulationEngine;

/*
 * This is where the user runs the simulator and where
 * different inputs can be changed for the simulation.
 */

public class main {

	public static void main(String[] args) {
        // Collect user input for parameters (seed, teams, unit types, number of units).

        // Initialize the simulation engine with user-defined parameters.
        SimulationEngine simulation = new SimulationEngine(seed, numTeams, unitTypes, numUnitsPerTeam);

        // Run the simulation.
        simulation.run();

        // Display simulation results to the user.
        simulation.displayResults();
	}

}
