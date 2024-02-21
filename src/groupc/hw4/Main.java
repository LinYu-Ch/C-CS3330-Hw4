package groupc.hw4;

import groupc.hw4.vehicleManager.VehicleManagerSingleton;
import groupc.hw4.vehicles.Car;
import groupc.hw4.vehicles.FuelType;
import groupc.hw4.vehicles.StartMechanism;
import groupc.hw4.vehicles.Truck;
import groupc.hw4.vehicles.VehicleColor;

public class Main {

	public static void main(String[] args) {
		// Instantiate vehicleManager, perform operations based on the requirements. 
		VehicleManagerSingleton vehicleManager = VehicleManagerSingleton.getInstance();
		boolean vehicleManagerFlag = false;
		vehicleManagerFlag = vehicleManager.initializeStock();
		System.out.println("initializeStock(): "+vehicleManagerFlag);
		Car car = new Car("Nissan","Sentra",2018,18000,VehicleColor.RED,FuelType.GASOLINE,1000,0.3,6,14,StartMechanism.PUSHSTART);
		
		System.out.println("\n-------------------------Displaying Specific Vehicle Information----------------");
		System.out.println("\n---A car that exists:");
		vehicleManager.displayVehicleInformation(car);
		System.out.println("\n---A vehicle that doesn't exist:");
		vehicleManager.displayVehicleInformation(null);
		System.out.println("--------------------------------------------------------------------------------");
		
		System.out.println("\n-------------------------Displaying Vehicle Info--------------------------------");
		vehicleManager.displayAllVehicleInformation();
		System.out.println("--------------------------------------------------------------------------------");
		
		// TODO
		// Display all vehicle information.
		// TODO
		// Display all car information.
		// TODO
		// Display all motorbike information.
		// TODO
	}

}
