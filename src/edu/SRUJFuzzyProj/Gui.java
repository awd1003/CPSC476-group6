package edu.SRUJFuzzyProj;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;

public class Gui {
	
	private String userInput;
	
	public float toFloat(String s) {
		return Float.parseFloat(s);
	}
	
	public float getUserInputFloat() {
		return Float.parseFloat(userInput);
	}
	
	public Gui() {
		JFrame frame = new JFrame("Flow Layout");
		String[] tempStrings = {"freezing","cold","temperate","warm","hot"}; // get temp descriptions
		SpinnerListModel tempModel = new SpinnerListModel(tempStrings);
		JSpinner spinner = new JSpinner(tempModel);
		JLabel label1,label2;
		JTextField tempField;
		JOptionPane getInput = new JOptionPane();
		userInput = new String(getInput.showInputDialog(null, "Please enter a temperature: "));
		try
		{
			  Double.parseDouble(userInput);
			  info.setTemperature(Double.parseDouble (userInput));
		}
		catch(NumberFormatException e)
		{
			System.out.println("wrong type");			
		}
		
		tempField = new JTextField(userInput, 50);
		JButton button1 = new JButton("Restart");
		button1.addActionListener(new Listener());
		label1 = new JLabel("<html>Actual Temperature <br> in Fahrenheit<html>");
		label2 = new JLabel("<html>How you would describe <br> that temperature<html>");
		
		frame.add(label1);
		frame.add(label2);
		frame.add(tempField);

		frame.add(spinner);
		frame.add(button1);
		frame.setLayout(new GridLayout(3, 3));
		frame.setSize(300, 200);
		frame.setVisible(true);
	}
	
}
