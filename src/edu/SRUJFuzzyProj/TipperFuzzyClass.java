package edu.SRUJFuzzyProj;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;

public class TipperFuzzyClass {

	public static void main(String[] args) {
		
		// Load from 'FCL' file
		String fileName = "data/HotOrCold.fcl";
		FIS fis = FIS.load(fileName, true);

		if (fis == null) { // Error while loading?
			System.err.println("Can't load file: " + fileName);
		}
		
		Gui gui = new Gui();
		
		System.out.println(gui.getUserInputFloat());
		
//		// Show ruleset
//		FunctionBlock functionBlock = fis.getFunctionBlock(null);
//
//		// Variable tip = functionBlock.getVariable("tip");
//		// JFuzzyChart.get().chart(tip, tip.getDefuzzifier(), true);
//
//		// Set inputs
//		functionBlock.setVariable("temperature", gui.getUserInputFloat());
//
//		// Evaluate
//		functionBlock.evaluate();
//
//		// Get output
//		double tip = functionBlock.getVariable("tip").getValue();
//
//		// Show
//		JFuzzyChart.get().chart(functionBlock);
//
//		// Show
//		System.out.println(functionBlock);
//		System.out.println("TIP:" + functionBlock.getVariable("tip").getValue());
//
//		// Set inputs
//		for (double service = 0; service <= 9; service += 1.0)
//			for (double food = 0; food <= 9; food += 1.0) {
//				// Set inputs
//				functionBlock.setVariable("service", service);
//				functionBlock.setVariable("food", food);
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
}