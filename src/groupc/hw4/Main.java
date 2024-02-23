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
		// Instantiate vehicleManager and confirm Singleton design works
		VehicleManagerSingleton vehicleManager = VehicleManagerSingleton.getInstance();
		VehicleManagerSingleton vehicleManager2 = VehicleManagerSingleton.getInstance();
		
		System.out.println("\n-------------------------Confirm Singleton Design Works----------------");
		System.out.println("vehicleManager.equals(vehicleManager2): " + vehicleManager.equals(vehicleManager2));
		System.out.println("--------------------------------------------------------------------------------");
		
		// Perform operations based on the requirements. 
		boolean vehicleManagerFlag = false;
		vehicleManagerFlag = vehicleManager.initializeStock();
		System.out.println("initializeStock(): "+ vehicleManagerFlag);
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
		
		System.out.println("\n-------------------------Displaying information of all Cars--------------------------------");
		vehicleManager.displayAllCarInformation();
		System.out.println("--------------------------------------------------------------------------------");

		System.out.println("\n-------------------------Displaying information of all Trucks--------------------------------");
		vehicleManager.displayAllTruckInformation();
		System.out.println("--------------------------------------------------------------------------------");

		System.out.println("\n-------------------------Displaying information of all SUVs--------------------------------");
		vehicleManager.displayAllSUVInformation();
		System.out.println("--------------------------------------------------------------------------------");

		System.out.println("\n-------------------------Displaying information of all Bikes--------------------------------");
		vehicleManager.displayAllMotorBikeInformation();
		System.out.println("--------------------------------------------------------------------------------");


		
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
		
		
		// Clean up so vehicleList.csv returns to original state
		vehicleManager.removeVehicle(car);
		vehicleManager.saveVehicleList();
		
	}

}
