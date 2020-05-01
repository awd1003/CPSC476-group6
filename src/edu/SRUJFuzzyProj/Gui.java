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
import java.awt.event.ActionListener;

public class Gui {
	
	private String userInput; //userinput for the temperature
	
	public float toFloat(String s) {
		return Float.parseFloat(s);
	}
	
	public float getUserInputFloat() {
		return Float.parseFloat(userInput);
	}
	
	public Gui() {
		final JFrame fileFrame = new JFrame("Hot Or Cold Interface");
		String[] defuzzifyMethods = {"Center of Gravity", "Center of Gravity Singleton"};
		JLabel fileLabel;
		JOptionPane getInput = new JOptionPane();
		JComboBox fclFileSelect = new JComboBox(defuzzifyMethods);
		fclFileSelect.setSelectedIndex(0);
		
		//add buttons and action listeners
		JButton selectButton = new JButton("Select");
		JButton restartButton = new JButton("Restart");
		selectButton.addActionListener(new ActionListener()
		{
			@Override
		    public void actionPerformed(ActionEvent event) {
		        HotOrColdFuzzyClass.runProgram();
		    }
		});
		
		restartButton.addActionListener(new ActionListener()
		{
			@Override
		    public void actionPerformed(ActionEvent event) {
				fileFrame.dispose();
				HotOrColdFuzzyClass.acquireInformation();
			}
			
		});
		//combobox change listener
		fclFileSelect.addActionListener(new ActionListener()
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
		            Information.setFilepath("data/HotOrColdCOGS.fcl");
		        }
		    }
		});
		
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

		//collect all the components to the GUI
		fileLabel = new JLabel("<html>Select Defuzzification Method<html>");
		fileFrame.add(fileLabel);
		fileFrame.add(fclFileSelect);
		fileFrame.add(selectButton);
		fileFrame.add(restartButton);
		
		fileFrame.setLayout(new GridLayout(3, 3));
		fileFrame.setSize(400, 300);
		fileFrame.setVisible(true);
		}
	
}
