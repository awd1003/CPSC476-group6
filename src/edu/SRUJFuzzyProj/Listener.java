package edu.SRUJFuzzyProj;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Listener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		

		// Evaluate
		HotOrColdFuzzyClass.restart();
	}
	
}
