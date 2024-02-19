package groupc.hw4;

import groupc.hw4.vehicleManager.VehicleManagerSingleton;

public class Main {

	public static void main(String[] args) {
		// Instantiate vehicleManager, perform operations based on the requirements. TODO this is modified from what the canvas documents have
		VehicleManagerSingleton vehicleManager = VehicleManagerSingleton.getInstance();
		vehicleManager.VehicleManager("./files/vehicleList.csv");
		// Read vehicle data from the vehcileList.csv file and initialize objects.
		boolean flag =vehicleManager.readFromFile(null);
		if(flag==false) {
			System.out.println("Broken");
		}
		// TODO
		// Display all vehicle information.
		// TODO
		// Display all car information.
		// TODO
		// Display all motorbike information.
		// TODO
	}

}
