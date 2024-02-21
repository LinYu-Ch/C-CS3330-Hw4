package groupc.hw4;

import groupc.hw4.vehicleManager.VehicleManagerSingleton;

public class Main {

	public static void main(String[] args) {
		// Instantiate vehicleManager, perform operations based on the requirements. 
		VehicleManagerSingleton vehicleManager = VehicleManagerSingleton.getInstance();
		boolean vehicleManagerFlag = false;
		vehicleManagerFlag = vehicleManager.initializeStock();
		System.out.println("initializeStock(): "+vehicleManagerFlag);
		// Read vehicle data from the vehcileList.csv file and initialize objects.
		
		// TODO
		// Display all vehicle information.
		// TODO
		// Display all car information.
		// TODO
		// Display all motorbike information.
		// TODO
	}

}
