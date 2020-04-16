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
		String[] monthStrings = {"cold","tempate","hot"}; // get month names
		SpinnerListModel monthModel = new SpinnerListModel(monthStrings);
		JSpinner spinner = new JSpinner(monthModel);
		JLabel label1,label2;
		JTextField tempField;
		JOptionPane getInput = new JOptionPane();
		userInput = new String(getInput.showInputDialog(null, "Please enter a temperature: "));
		
		tempField = new JTextField(userInput, 20);
		JButton button1 = new JButton("button 1");
		button1.addActionListener(new Listener());
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
	
}
