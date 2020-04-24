package edu.SRUJFuzzyProj;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Variable;

public class TipperFuzzyClass {
	
	public static void main(String[] args) {
		
		// Load from 'FCL' file
		info.setFilepath("data/HotOrCold.fcl"); 
		FIS fis = FIS.load(info.getFilepath(), true);

		if (fis == null) { // Error while loading?
			System.err.println("Can't load file: " + info.getFilepath());
		}
		
		Gui gui = new Gui();
		
		//System.out.println(gui.getUserInputFloat());
		
//		// Show ruleset
		FunctionBlock functionBlock = fis.getFunctionBlock(null);
//
//		Variable temp = functionBlock.getVariable("temp");
//		JFuzzyChart.get().chart(temp, temp.getDefuzzifier(), true);
		
		// Set inputs
		functionBlock.setVariable("temperature", info.getTemperature());

		// Evaluate
		functionBlock.evaluate();
//
		// Get output
		double result = functionBlock.getVariable("result").getValue();

		// Show
		JFuzzyChart.get().chart(functionBlock);

		// Show
		System.out.println(functionBlock);
		System.out.println("RESULT: " + functionBlock.getVariable("result").getValue());
//
//		// Set inputs
//		for (double service = 0; service <= 9; service += 1.0)
//			for (double temp = -30; temp <= 150; temp += 1.0) {
//				// Set inputs
//				functionBlock.setVariable("temperature", temp);
//				functionBlock.set Variable("food", food);
//
//				// Evaluate
//				functionBlock.evaluate();
//
//				// Get output
//				// double tip = functionBlock.getVariable("tip").getValue();
//				// Get output
//				tip = functionBlock.getVariable("tip").getValue();
//
//				// Show
//				System.out.println(service + "\t" + food + "\t" + tip);
//		}
	}
	static void restart(){
		FIS fis = FIS.load(info.getFilepath() , true);
		FunctionBlock functionBlock = fis.getFunctionBlock(null);
		functionBlock.setVariable("temperature", info.getTemperature());

		// Evaluate
		functionBlock.evaluate();
		double result = functionBlock.getVariable("result").getValue();

		// Show
		JFuzzyChart.get().chart(functionBlock);

		// Show
		System.out.println(functionBlock);
		System.out.println("RESULT: " + functionBlock.getVariable("result").getValue());

			
	}
}