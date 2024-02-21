package groupc.hw4.vehicleManager;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileInputStream;

import group.hw4.vehicles.AbstractVehicle;
import group.hw4.vehicles.Car;
import group.hw4.vehicles.FuelType;
import group.hw4.vehicles.MotorBike;
import group.hw4.vehicles.SUV;
import group.hw4.vehicles.StartMechanism;
import group.hw4.vehicles.Truck;
import group.hw4.vehicles.VehicleColor;

public class VehicleManagerSingleton {

	//Keeps track of the ONLY instance of the Vehicle Manager
	private static VehicleManagerSingleton instance =null;
	
	
	//Variable to keep track of the CSV file relative path. 
	//final to avoid modifications
	private final String VehicleFilePath = "./files/vehicleList.csv";
	
	//An arraylist to hold each of the vehicles read from the CSV file
	ArrayList<AbstractVehicle> vehicleList;
	
	/**
	 * base constructor that is private to avoid creating multiple copies of the same singleton
	 */
	private VehicleManagerSingleton() {
		this.vehicleList = new ArrayList<AbstractVehicle>();
		
	}
	
	/**
	 * 
	 * 
	 * This is a method to get the ONLY instance of the VehicleManager
	 * Author:Zoe
	 * 
	 * @return VehicleManager instance
	 */
	public static VehicleManagerSingleton getInstance() {
		if(instance == null) {
			instance = new VehicleManagerSingleton();//creates an instance, if the current instance is null
		}
		return instance;
	}
	
	
	/**
	 * Reads the data from a CSV file located at vehicleFilePath. Initialize each of the Vehicle
	 * objects. Stores the objects into vehicleList).
	 * 
	 * Author: Zoe 
	 * Note: The code used below uses concepts from Ryan's implementation of initializeStock() from assignment3
	 * 
	 * @return true if the read file and initialization are successful. false if cannot read/find the file
	 * @param fileName
	 * */
	public boolean initializeStock() {
		Scanner fileScanner=null; 
		try {
			fileScanner= new Scanner(new FileInputStream(VehicleFilePath));
			//Checks to see if a file is empty. If it is, then return false
			if(!fileScanner.hasNextLine()) {
				return false;
			}
			
			//Ignores the titles for each column
			fileScanner.nextLine();
			
			while(fileScanner.hasNextLine()) {
				//Splits each line into the different fields
				String[] splitted = fileScanner.nextLine().split(",");
				
				//makes sure that the split line has the proper number of fields. 
				//IF IT DOES NOT, close the scanner and return false to indicate the file was not read
				if(splitted.length!=12) {
					fileScanner.close();
					return false;
				}
				
				
				//Splits the splitted string array to its different components
				String type = splitted[0]; //Vehicle type 
				String model = splitted[1]; //the model of the vehicle (Also called Brand
				String make = splitted[2]; //the make of the vehicle
				long modelYear = Long.parseLong(splitted[3]); // the year the vehicle was released
				double price = Integer.parseInt(splitted[4]); //The price of the vehicle
				VehicleColor color = VehicleColor.valueOf(splitted[5]); //Color of the vehicle
				FuelType fuelType= FuelType.valueOf(splitted[6]); //type of fuel the vehicle uses
				double mileage = Double.parseDouble(splitted[7]); //The mileage of the vehicle
				double mass = Double.parseDouble(splitted[8]); //The mass of the vehicle
				int cylinders = Integer.parseInt(splitted[9]);
				double gasTankCapacity= Double.parseDouble(splitted[10]);
				StartMechanism startMechanism = StartMechanism.valueOf(splitted[11]);
				
				
			
				//Assigns the splitted values to a new object of the proper type and then adds it to the VehicleList
				if(type.equals("Truck")) {
					vehicleList.add(new Truck(model, make, modelYear, price, color, fuelType, mileage, mass, cylinders, gasTankCapacity, startMechanism));
				} else if(type.equals("Car")) {
					vehicleList.add(new Car(model, make, modelYear, price, color, fuelType, mileage, mass, cylinders, gasTankCapacity, startMechanism));
				}else if(type.equals("SUV")) {
					vehicleList.add(new SUV(model, make, modelYear, price, color, fuelType, mileage, mass, cylinders, gasTankCapacity, startMechanism));
				}else if(type.equals("MotorBike")) {
					vehicleList.add(new MotorBike(model, make, modelYear, price, color, fuelType, mileage, mass, cylinders, gasTankCapacity, startMechanism));
				}else { //the vehicle trying to be added to the list is not a valid vehicle. Thus, clear all of the vehicles and return false to indicate an error
					vehicleList.clear();
					fileScanner.close();
					return false;
				}
				
			}

			//Closing the scanner and then returning true to indicate a successful read
			fileScanner.close();
			return true;
		}
		catch (Exception e) { //Some error occurred that wasn't taken care of above in the try
			return false;
		}
		

		
	}

	
	/**
	 * This will display the information, including maintenance cost, fuel efficiency, and how
	 * the vehicle starts, of all the cars present in the vehicleList.
	 * 
	 * If the vehicle is not found, then print an appropriate error message.
	 */
	public void displayAllCarInformation() {
	}
	
	/**
	 * This will display the information, including maintenance cost, fuel efficiency, and how
	 * the vehicle starts, of all the trucks present in the vehicleList.
	 * 
	 * If the vehicle is not found, then print an appropriate error message.
	 */
	public void displayAllTruckInformation() {
	}
	
	/**
	 * This will display the information, including maintenance cost, fuel efficiency, and how
	 * the vehicle starts, of all the SUVs present in the vehicleList.
	 * 
	 * If the vehicle is not found, then print an appropriate error message.
	 */
	public void displayAllSUVInformation() {
	}
	
	/**
	 * This will display the information, including maintenance cost, fuel efficiency, and how
	 * the vehicle starts, of all the motor bikes present in the vehicleList.
	 * 
	 * If the vehicle is not found, then print an appropriate error message.
	 */
	public void displayAllMotorBikeInformation() {
	}
	
	/**
	 * This will display the vehicle information, including maintenance cost, fuel efficiency, and
	 * how the vehicle starts, of a Vehicle v which is present in the vehicleList.
	 * 
	 * If the vehicle is not found, then print an appropriate error message.
	 * @param v
	 */
	public void displayVehicleInformation(AbstractVehicle v) {
		//checks if vehicle exists
		boolean containsFlag= vehicleList.contains(v);
		
		//displays a message if the vehicle is not found and returns
		if(containsFlag == false) {
			System.out.println(v + " Does not exist");
			return;
		}
		
		//gets the index of the vehicle
		int index =vehicleList.indexOf(v);
		//prints out the vehicle information
		System.out.println(vehicleList.get(index).toString());
	}
	
	/**
	 * This will print the information, including maintenance cost, fuel efficiency, and how the
	 * vehicle starts, of all the vehicles in the vehicleList
	 * 
	 * Print an appropriate message if the list is empty
	 */
	public void displayAllVehicleInformation() {
	}
	/**
	 * Removes the given vehicle from the vehicleList.
	 * Returns true if the removal is successful, false otherwise.
	 */
	public boolean removeVehicle(AbstractVehicle vehicle) {
		return false;
	}

	/**
	 * Adds the given vehicle into the vehicleList.
	 * Returns true if the addition is successful, false otherwise.
	 */
	public boolean addVehicle(AbstractVehicle vehicle) {
		return false;
	}

	/**
	 * Saves the updated vehicleList back to the CSV file located at vehicleFilePath.
	 * Overwrites the existing file with the updated data.
	 * Returns true if the saving is successful, false otherwise (file does not exist, or file empty).
	 */
	public boolean saveVehicleList() {
		return false;
	}

	/**
	 * Checks if the given vehicle is a specific type of Vehicle subclass.
	 * If the given vehicle object is the object type, then return true, otherwise return false.
	 * Use instanceof or getClass() to count the number.
	 * Call example: isVehicleType(vehicleObj, Truck.class);
	 */
	private boolean isVehicleType(AbstractVehicle v, Class clazz) {
		return false;
	}

	/**
	 * Returns the number of objects in the vehicle list based on the object vehicle type
	 * Use the isVehicleType(Vehicle v, Class clazz) method.
	 * Call example: getNumberOfVehiclesByType(SUV.class);
	 */
	public int getNumberOfVehiclesByType(Class clazz) {
		return 0;
	}

	/**
	 * Calculate the maintenance cost for each vehicle in the vehicle list and return the vehicle
	 * with the highest maintenance cost.
	 * If multiple vehicles have the same maintenance cost, randomly return one of the
	 * vehicles (Use the Random class for random selection).
	 */
	public AbstractVehicle getVehicleWithHighestMaintenanceCost(double distance) {
		if(vehicleList.size() == 0) return null;
	    
		ArrayList<AbstractVehicle> highestList = new ArrayList<AbstractVehicle>();
		highestList.add(vehicleList.get(0));
		double highestCost = highestList.get(0).calculateMaintenaceCost(distance);
		
		for(AbstractVehicle vehicle : vehicleList) {
			double currCost = vehicle.calculateMaintenaceCost(distance);
			if(currCost > highestCost) {
				highestCost = currCost;
				highestList.clear();
				highestList.add(vehicle);
			} else if(currCost == highestCost) {
				highestList.add(vehicle);
			}
		}
		
		int randIndex = (int)(Math.random() * highestList.size());
		
		return highestList.get(randIndex);
		
	}

	/**
	 * Calculate the maintenance cost for each vehicle in the vehicle list and return the vehicle
	 * with the lowest maintenance cost.
	 * If multiple vehicles have the same maintenance cost, randomly return one of the
	 * vehicles (Use the Random class for random selection).
	 */
	public AbstractVehicle getVehicleWithLowestMaintenanceCost(double distance) {
		if(vehicleList.size() == 0) return null;
	    
		ArrayList<AbstractVehicle> lowestList = new ArrayList<AbstractVehicle>();
		lowestList.add(vehicleList.get(0));
		double lowestCost = lowestList.get(0).calculateMaintenaceCost(distance);
		
		for(AbstractVehicle vehicle : vehicleList) {
			double currCost = vehicle.calculateMaintenaceCost(distance);
			if(currCost < lowestCost) {
				lowestCost = currCost;
				lowestList.clear();
				lowestList.add(vehicle);
			} else if(currCost == lowestCost) {
				lowestList.add(vehicle);
			}
		}
		
		int randIndex = (int)(Math.random() * lowestList.size());
		
		return lowestList.get(randIndex);
	}

	/**
	 * Calculate the fuel efficiencies for each vehicle in the vehicle list and return the vehicle
	 * with the highest fuel efficiency.
	 * If multiple vehicles have the same highest fuel efficiency, return vehicles with the same
	 * highest fuel efficiency in an ArrayList.
	 */
	public ArrayList<AbstractVehicle> getVehicleWithHighestFuelEfficiency(double distance, double fuelPrice) {
		if(vehicleList.size() == 0) return null;
	    
		ArrayList<AbstractVehicle> highestList = new ArrayList<AbstractVehicle>();
		highestList.add(vehicleList.get(0));
		double highestEfficiency = highestList.get(0).calculateFuelEfficiency(distance, fuelPrice);
		
		for(AbstractVehicle vehicle : vehicleList) {
			double currEfficiency = vehicle.calculateFuelEfficiency(distance, fuelPrice);
			if(currEfficiency > highestEfficiency) {
				highestEfficiency = currEfficiency;
				highestList.clear();
				highestList.add(vehicle);
			} else if(currEfficiency == highestEfficiency) {
				highestList.add(vehicle);
			}
		}
		
		return highestList;
	}

	/**
	 * Calculate the fuel efficiencies for each vehicle in the vehicle list and return the vehicle
	 * with the lowest fuel efficiency.
	 * If multiple vehicles have the same lowest fuel efficiency, return vehicles with the same
	 * lowest fuel efficiency in an ArrayList.
	 */
	public ArrayList<AbstractVehicle> getVehicleWithLowestFuelEfficiency(double distance, double fuelPrice) {
		if(vehicleList.size() == 0) return null;
	    
		ArrayList<AbstractVehicle> lowestList = new ArrayList<AbstractVehicle>();
		lowestList.add(vehicleList.get(0));
		double lowestEfficiency = lowestList.get(0).calculateFuelEfficiency(distance, fuelPrice);
		
		for(AbstractVehicle vehicle : vehicleList) {
			double currEfficiency = vehicle.calculateFuelEfficiency(distance, fuelPrice);
			if(currEfficiency < lowestEfficiency) {
				lowestEfficiency = currEfficiency;
				lowestList.clear();
				lowestList.add(vehicle);
			} else if(currEfficiency == lowestEfficiency) {
				lowestList.add(vehicle);
			}
		}
		
		return lowestList;
	}

	/**
	 * Calculate the average/mean of the fuel efficiency of SUVs in the vehicle list.
	 * Use the isVehicleType(Vehicle v, Class clazz) method.
	 * If no SUVs exist in the list return -1.0 as an error code that indicates there is no SUVs in
	 * the list to calculate the average fuel efficiency.
	 */
	public double getAverageFuelEfficiencyOfSUVs(double distance, double fuelPrice) {
		return fuelPrice;
	}
}
