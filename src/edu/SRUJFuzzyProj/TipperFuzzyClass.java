package edu.SRUJFuzzyProj;

import java.awt.GridLayout;
import java.text.NumberFormat;


import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;

public class TipperFuzzyClass {
	private static JButton button1;
	

	public static void gridLayoutExample() {
		JFrame frame = new JFrame("Flow Layout");
		String[] monthStrings = {"cold","tempate","hot"}; // get month names
		SpinnerListModel monthModel = new SpinnerListModel(monthStrings);
		JSpinner spinner = new JSpinner(monthModel);
		JLabel label1,label2;
		JTextField tempField;
		
		tempField = new JTextField("79.2", 20);
		button1 = new JButton("button 1");
		label1 = new JLabel("<html>Actual Temperature <br> in degrees<html>");
		label2 = new JLabel("<html>How you would discribe <br> that temperature<html>");
		
		frame.add(label1);
		frame.add(label2);
		frame.add(tempField);

		frame.add(spinner);
		frame.add(button1);
		frame.setLayout(new GridLayout(3, 3));
		frame.setSize(300, 200);
		frame.setVisible(true);

	}

	public static void main(String[] args) {

		// Load from 'FCL' file
		String fileName = "data/HotOrCold.fcl";
		FIS fis = FIS.load(fileName, true);

		if (fis == null) { // Error while loading?
			System.err.println("Can't load file: " + fileName);
		}

		gridLayoutExample();
		if(button1.getModel().isPressed()){
		System.out.println("the button is pressed");
		
		// Show ruleset
		FunctionBlock functionBlock = fis.getFunctionBlock(null);

		// Variable tip = functionBlock.getVariable("tip");
		// JFuzzyChart.get().chart(tip, tip.getDefuzzifier(), true);

		// Set inputs
		functionBlock.setVariable("temperature", 7);

		// Evaluate
		functionBlock.evaluate();

		// Get output
		double tip = functionBlock.getVariable("tip").getValue();

		// Show
		JFuzzyChart.get().chart(functionBlock);

		// Show
		System.out.println(functionBlock);
		System.out.println("TIP:" + functionBlock.getVariable("tip").getValue());

		// Set inputs
		for (double service = 0; service <= 9; service += 1.0)
			for (double food = 0; food <= 9; food += 1.0) {
				// Set inputs
				functionBlock.setVariable("service", service);
				functionBlock.setVariable("food", food);

				// Evaluate
				functionBlock.evaluate();

				// Get output
				// double tip = functionBlock.getVariable("tip").getValue();
				// Get output
				tip = functionBlock.getVariable("tip").getValue();

				// Show
				System.out.println(service + "\t" + food + "\t" + tip);
			}
		}

	}

}
