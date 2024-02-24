package groupc.hw4;

import java.util.ArrayList;

import groupc.hw4.vehicleManager.VehicleManagerSingleton;
import groupc.hw4.vehicles.AbstractVehicle;
import groupc.hw4.vehicles.Car;
import groupc.hw4.vehicles.FuelType;
import groupc.hw4.vehicles.MotorBike;
import groupc.hw4.vehicles.SUV;
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
		//initialize the stock 
		System.out.println("\n-------------------------Initialize Stock----------------");
		boolean vehicleManagerFlag = false;
		vehicleManagerFlag = vehicleManager.initializeStock();
		System.out.println("initializeStock(): "+ vehicleManagerFlag);
		System.out.println("-----------------------------------------------------------");

		//Adding a car to the stock - Shows functionality of the add function
		Car car = new Car("FALSECAR","Sentra",2018,18000,VehicleColor.RED,FuelType.GASOLINE,1000,0.3,6,14,StartMechanism.PUSHSTART);

		System.out.println("\n-------------------------Adding vehicle to vehicle Manager----------------");
		System.out.println("addVehicle(car): " + vehicleManager.addVehicle(car));
		System.out.println("addVehicle(null): " + vehicleManager.addVehicle(null));
		System.out.println("--------------------------------------------------------------------------------");

		//Displaying a specific vehicle Information
		System.out.println("\n-------------------------Displaying Specific Vehicle Information----------------");
		System.out.println("\n---A car that exists:");
		vehicleManager.displayVehicleInformation(car);
		System.out.println("\n---A vehicle that doesn't exist:");
		vehicleManager.displayVehicleInformation(null);
		System.out.println("--------------------------------------------------------------------------------");
		
		
		//saving the updates to the vehicle list
		System.out.println("\n-------------------------Saving Vehicle List--------------------------------");
		boolean saveFlag=vehicleManager.saveVehicleList();
		System.out.println("Return value of vehicleManager.saveVehicleList(): " + saveFlag);
		System.out.println("--------------------------------------------------------------------------------");
		
		
		// Display all vehicle information.
		System.out.println("\n-------------------------Displaying Vehicle Info--------------------------------");
		vehicleManager.displayAllVehicleInformation();
		System.out.println("--------------------------------------------------------------------------------");
		
		//displaying all car information
		System.out.println("\n-------------------------Displaying information of all Cars--------------------------------");
		vehicleManager.displayAllCarInformation();
		System.out.println("Number of Cars: "+vehicleManager.getNumberOfVehiclesByType(Car.class));
		System.out.println("--------------------------------------------------------------------------------");

		//displaying all truck information
		System.out.println("\n-------------------------Displaying information of all Trucks--------------------------------");
		vehicleManager.displayAllTruckInformation();
		System.out.println("Number of Trucks: "+vehicleManager.getNumberOfVehiclesByType(Truck.class));
		System.out.println("--------------------------------------------------------------------------------");

		//displaying all information of SUVs
		System.out.println("\n-------------------------Displaying information of all SUVs--------------------------------");
		vehicleManager.displayAllSUVInformation();
		System.out.println("Number of SUVs: "+vehicleManager.getNumberOfVehiclesByType(SUV.class));
		System.out.println("--------------------------------------------------------------------------------");

		//displaying all information of bikes
		System.out.println("\n-------------------------Displaying information of all Bikes--------------------------------");
		vehicleManager.displayAllMotorBikeInformation();
		System.out.println("Number of MotorBikes: "+vehicleManager.getNumberOfVehiclesByType(MotorBike.class));
		System.out.println("--------------------------------------------------------------------------------");
		
		
		
		System.out.println("\n-------------------------Display number of incorrect types--------------------------------");
		System.out.println("Null: " + vehicleManager.getNumberOfVehiclesByType(null));
		System.out.println("ArrayList: " + vehicleManager.getNumberOfVehiclesByType(ArrayList.class));
		System.out.println("------------------------------------------------------------------------------------------");

		//finding lowest maintenance vehicle and displaying it
		System.out.println("\n-------------------------Vehicle with Lowest Maintenance Cost--------------------------------");
		AbstractVehicle lowestMaintenance = vehicleManager.getVehicleWithLowestMaintenanceCost(300);
		System.out.println(lowestMaintenance);
		System.out.println("Maintenance Cost: " + lowestMaintenance.calculateMaintenaceCost(300));
		System.out.println("--------------------------------------------------------------------------------");
		
		//finding vehicle with the highest maintenance cost
		System.out.println("\n-------------------------Vehicle with Highest Maintenance Cost--------------------------------");
		AbstractVehicle highestMaintenance = vehicleManager.getVehicleWithHighestMaintenanceCost(300);
		System.out.println(highestMaintenance);
		System.out.println("Maintenance Cost: " + highestMaintenance.calculateMaintenaceCost(300));
		System.out.println("--------------------------------------------------------------------------------");
		
		//displaying vehicle with lowest fuel efficiency
		System.out.println("\n-------------------------Vehicle with Lowest Fuel Efficiency--------------------------------");
		ArrayList<AbstractVehicle> lowestEfficiency = vehicleManager.getVehicleWithLowestFuelEfficiency(300, 3.25);
		for (AbstractVehicle vehicle : lowestEfficiency) {
			System.out.println(vehicle);
			System.out.println("Fuel Efficiency: " + vehicle.calculateFuelEfficiency(300, 3.25));
		}
		System.out.println("--------------------------------------------------------------------------------");
		
		
		//displaying vehicle with highest fuel efficiency
		System.out.println("\n-------------------------Vehicle with Highest Fuel Efficiency--------------------------------");
		ArrayList<AbstractVehicle> highestEfficiency = vehicleManager.getVehicleWithHighestFuelEfficiency(300, 3.25);
		for (AbstractVehicle vehicle : highestEfficiency) {
			System.out.println(vehicle);
			System.out.println("Fuel Efficiency: " + vehicle.calculateFuelEfficiency(300, 3.25));
		}
		System.out.println("--------------------------------------------------------------------------------");
		
		//displaying SUV average fuel efficiency
		System.out.println("\n-------------------------SUV average fuel efficiency--------------------------------");
		System.out.println("suv avg fuel efficiency");
		System.out.println(vehicleManager.getAverageFuelEfficiencyOfSUVs(300, 3.25));
		System.out.println("--------------------------------------------------------------------------------");
		
		
		// Clean up so vehicleList.csv returns to original state
		System.out.println("\n-------------------------Test Remove Vehicle--------------------------------");
		System.out.println("removeVehicle(car): "+vehicleManager.removeVehicle(car));
		System.out.println("removeVehicle(null): "+vehicleManager.removeVehicle(null));
		System.out.println("--------------------------------------------------------------------------------");

		// Check to see if information leak occures and protected data can be edited
		System.out.println("\n-------------------------Test Information Leak--------------------------------");
		vehicleManager.getVehicleWithHighestMaintenanceCost(300).setBrand("ALTERED");
		System.out.println("setBrand(\"ALTERED\")");
		System.out.println("getBrand(): " + vehicleManager.getVehicleWithHighestMaintenanceCost(300).getBrand());
		System.out.println("--------------------------------------------------------------------------------");
		
		//save the vehicleList to the file.
		vehicleManager.saveVehicleList();
		
	}

}
