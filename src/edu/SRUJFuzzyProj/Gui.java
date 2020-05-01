package edu.SRUJFuzzyProj;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import java.awt.event.ActionEvent;

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
		JFrame fileFrame = new JFrame("Flow Layout");
		String[] tempStrings = {"freezing","cold","temperate","warm","hot"}; // get temp descriptions
		String[] defuzzifyMethods = {"Center of Gravity", "Center of Gravity Singleton"};
		SpinnerListModel tempModel = new SpinnerListModel(tempStrings);
		JSpinner spinner = new JSpinner(tempModel);
		JLabel fileLabel,label1,label2;
		JTextField tempField;
		JOptionPane getInput = new JOptionPane();
		JComboBox fclFileSelect = new JComboBox(defuzzifyMethods);
		fclFileSelect.setSelectedIndex(0);
		
		userInput = new String(getInput.showInputDialog(null, "Please enter a temperature (in Fahrenheit): "));
		try
		{
			  Double.parseDouble(userInput);
			  Information.setTemperature(Double.parseDouble (userInput));
		}
		catch(NumberFormatException e)
		{
			System.out.println("wrong type");			
		}
		
		JButton buttonSelect = new JButton("Select");
//move this to the listener class?
		fclFileSelect.addActionListener(new Listener()
		{
			@Override
		    public void actionPerformed(ActionEvent event) {
		        JComboBox<String> combo = (JComboBox<String>) event.getSource();
		        String selectedFile = (String) combo.getSelectedItem();
		 
		        if (selectedFile.equals("Center of Gravity")) {
		            System.out.println("COG!");
		            Information.setFilepath("data/HotOrColdCOG.fcl");
		        }
		        else if (selectedFile.equals("Center of Gravity Singleton")) {
		            System.out.println("Singleton!");
		            Information.setFilepath("data/HotOrColdSugueno.fcl");
		        }
		    }
		});
		
		fileLabel = new JLabel("<html>Select Defuzzification Method<html>");
		fileFrame.add(fileLabel);
		fileFrame.add(fclFileSelect);
		fileFrame.add(buttonSelect);
		fileFrame.setLayout(new GridLayout(3, 3));
		fileFrame.setSize(300, 200);
		fileFrame.setVisible(true);
		
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
