package edu.SRUJFuzzyProj;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Variable;

public class HotOrColdFuzzyClass {
	
	public static void main(String[] args) {
		
		
		Gui gui = new Gui();
		
		// Load from 'FCL' file
		Information.setFilepath("data/HotOrColdCOG.fcl"); 
		FIS fis = FIS.load(Information.getFilepath(), true);
		//catches error if loading did not succeed
		if (fis == null) { 
			System.err.println("Can't load file: " + Information.getFilepath());
		}
		
		//System.out.println(gui.getUserInputFloat());
		
//		// Show ruleset
		FunctionBlock functionBlock = fis.getFunctionBlock(null);
		
		// Set inputs
		functionBlock.setVariable("temperature", Information.getTemperature());
		

		// Evaluate
		functionBlock.evaluate();

		// Get output
		double result = functionBlock.getVariable("result").getValue();

		// Show
		JFuzzyChart.get().chart(functionBlock);

		// Show
		//System.out.println(functionBlock);
		//System.out.println("RESULT: " + result);
		
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
	static void restart(){
		FIS fis = FIS.load(Information.getFilepath() , true);
		FunctionBlock functionBlock = fis.getFunctionBlock(null);
		functionBlock.setVariable("temperature", Information.getTemperature());

		// Evaluate
		functionBlock.evaluate();
		double result = functionBlock.getVariable("result").getValue();

		// Show
		JFuzzyChart.get().chart(functionBlock);

		// Show
		//System.out.println(functionBlock);
		//System.out.println("RESULT: " + result);
		
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