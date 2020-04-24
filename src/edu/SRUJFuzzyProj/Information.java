package edu.SRUJFuzzyProj;

public class Information {

	private static String filepath;
	private static double temperature;
	
	public Information() 
	{
		filepath = "data/HotOrCold.fcl";
		temperature = 0.0;
	}

	public static String setFilepath(String path) {
		filepath = path;
		return "Filepath is " + filepath;
	}
	
	public static String getFilepath() {
		return filepath;
	}
	
	public static String setTemperature(double temp) {
		temperature = temp;
		return "Temperature is " + temp;
	}
	
	public static double getTemperature() {
		return temperature;
	}
}
