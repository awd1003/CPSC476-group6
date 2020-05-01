//Hot Or Cold Fuzzy Logic System developed by
//James Houseknecht, Greg Hopkins, and Adam Davenport
//April 2020

package edu.SRUJFuzzyProj;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Variable;

import java.util.concurrent.TimeUnit;

public class HotOrColdFuzzyClass {
	
	public static void main(String[] args) {
		acquireInformation(); //run the main execution of the program, is separate for restart
	}
	
	public static void acquireInformation() {
		Gui gui = new Gui();
	}
	
	public static void runProgram() {
		
		// Load from 'FCL' file
		FIS fis = FIS.load(Information.getFilepath(), true);
		//catches error if loading did not succeed
		if (fis == null) { 
			System.err.println("Can't load file: " + Information.getFilepath());
		}
		
		// Show rule set
		FunctionBlock functionBlock = fis.getFunctionBlock(null);
		
		
		// Set inputs
		functionBlock.setVariable("temperature", Information.getTemperature());
		

		// Evaluate and begin measuring execution time
		long startTime = System.nanoTime();
		functionBlock.evaluate();

		// Get output and complete execution time
		double result = functionBlock.getVariable("result").getValue();
		long endTime = System.nanoTime();
		

		// Show
		JFuzzyChart.get().chart(functionBlock);
		
		long executionTime = endTime - startTime;
		System.out.println("Execution time: " + executionTime + " nanoseconds.");
		
		//'Emulate' monotonic selection by mapping input variable to output variable (i.e., determine what input values produce certain output values) 
		//and using the output to determine which linguistic variable best fits
		if (result < 31) {
			System.out.println("Definitely wear sweats");
		}
		
		else if (result > 31 && result < 38) {
			System.out.println("Wear either sweats or jeans");
		}
		
		else if (result > 38 && result < 60) {
			System.out.println("Definitely wear jeans");
		}
		
		else if (result > 60 && result < 75) {
			System.out.println("Wear either jeans or shorts");
		}
		
		else if (result > 75) {
			System.out.println("Definitely wear shorts");
		}


	}
}