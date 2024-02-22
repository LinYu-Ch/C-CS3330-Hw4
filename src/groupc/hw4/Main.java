package groupc.hw4;

import java.util.ArrayList;

import groupc.hw4.vehicleManager.VehicleManagerSingleton;
import groupc.hw4.vehicles.AbstractVehicle;
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
		Car car = new Car("FALSECAR","Sentra",2018,18000,VehicleColor.RED,FuelType.GASOLINE,1000,0.3,6,14,StartMechanism.PUSHSTART);
		vehicleManager.addVehicle(car);
		
		System.out.println("\n-------------------------Displaying Specific Vehicle Information----------------");
		System.out.println("\n---A car that exists:");
		vehicleManager.displayVehicleInformation(car);
		System.out.println("\n---A vehicle that doesn't exist:");
		vehicleManager.displayVehicleInformation(null);
		System.out.println("--------------------------------------------------------------------------------");
		
		System.out.println("\n-------------------------Displaying Vehicle Info--------------------------------");
		vehicleManager.displayAllVehicleInformation();
		System.out.println("--------------------------------------------------------------------------------");
		
		System.out.println("\n-------------------------Saving Vehicle List--------------------------------");
		boolean saveFlag=vehicleManager.saveVehicleList();
		System.out.println("Return value of vehicleManager.saveVehicleList(): " + saveFlag);
		System.out.println("--------------------------------------------------------------------------------");
		// TODO
		// Display all vehicle information.
		// TODO
		// Display all car information.
		// TODO
		// Display all motorbike information.
		// TODO
		
		System.out.println("\n-------------------------Vehicle with Lowest Maintenance Cost--------------------------------");
		AbstractVehicle lowestMaintenance = vehicleManager.getVehicleWithLowestMaintenanceCost(300);
		System.out.println(lowestMaintenance);
		System.out.println("Maintenance Cost: " + lowestMaintenance.calculateMaintenaceCost(300));
		System.out.println("--------------------------------------------------------------------------------");
		
		System.out.println("\n-------------------------Vehicle with Highest Maintenance Cost--------------------------------");
		AbstractVehicle highestMaintenance = vehicleManager.getVehicleWithHighestMaintenanceCost(300);
		System.out.println(highestMaintenance);
		System.out.println("Maintenance Cost: " + highestMaintenance.calculateMaintenaceCost(300));
		System.out.println("--------------------------------------------------------------------------------");
		
		System.out.println("\n-------------------------Vehicle with Lowest Fuel Efficiency--------------------------------");
		ArrayList<AbstractVehicle> lowestEfficiency = vehicleManager.getVehicleWithLowestFuelEfficiency(300, 3.25);
		for (AbstractVehicle vehicle : lowestEfficiency) {
			System.out.println(vehicle);
			System.out.println("Fuel Efficiency: " + vehicle.calculateFuelEfficiency(300, 3.25));
		}
		System.out.println("--------------------------------------------------------------------------------");
		
		System.out.println("\n-------------------------Vehicle with Highest Fuel Efficiency--------------------------------");
		ArrayList<AbstractVehicle> highestEfficiency = vehicleManager.getVehicleWithHighestFuelEfficiency(300, 3.25);
		for (AbstractVehicle vehicle : highestEfficiency) {
			System.out.println(vehicle);
			System.out.println("Fuel Efficiency: " + vehicle.calculateFuelEfficiency(300, 3.25));
		}
		System.out.println("--------------------------------------------------------------------------------");
		
		
		
	}

}
