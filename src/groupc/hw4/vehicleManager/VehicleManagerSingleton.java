package groupc.hw4.vehicleManager;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileInputStream;

import group.hw4.vehicles.AbstractVehicle;
import group.hw4.vehicles.FuelType;
import group.hw4.vehicles.StartMechanism;
import group.hw4.vehicles.VehicleColor;

public class VehicleManagerSingleton {

	//Keeps track of the ONLY instance of the Vehicle Manager
	private static VehicleManagerSingleton instance =null;
	
	
	//Variable to keep track of the CSV file relative path. 
	//Note that unlike HW3, since the path is set up during initialization, VehicleFilePath is NOT final
	private String VehicleFilePath = null;
	
	//An arraylist to hold each of the vehicles read from the CSV file
	ArrayList<AbstractVehicle> vehicleList;
	
	/**
	 * base constructor that is private to avoid creating multiple copies of the same singleton
	 */
	private VehicleManagerSingleton() {
		this.vehicleList = new ArrayList<AbstractVehicle>();
		
	}
	
	/**
	 * TODO
	 * 
	 * This is a method to get the ONLY instance of the VehicleManager
	 * @return
	 */
	public static VehicleManagerSingleton getInstance() {
		if(instance == null) {
			instance = new VehicleManagerSingleton();//creates an instance, if the current instance is null
		}
		return instance;
	}
	
	
	/**
	 * Reads the data from a CSV file located at vehicleFilePath. Initialize each of the Vehicle
	 * objects (Hint: Consider using the split() method for tokenization. Check the type of each
	 * object and instantiate the exact class. Store the objects into vehicleList).
	 * 
	 * Return true if the read file and initialization are successful.
	 * 
	 * Return false if cannot read/find the file.
	 * @param fileName
	 * */
	public boolean readFromFile(String fileName) {
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
				String type = splitted[0]; //Vehicle type TODO??
				//,GasTankCapacity,StartType
				String Model = splitted[1]; //the model of the vehicle
				String Make = splitted[2]; //the make of the vehicle
				long ModelYear = Long.parseLong(splitted[3]); // the year the vehicle was released
				double price = Integer.parseInt(splitted[4]); //The price of the vehicle
				VehicleColor color = VehicleColor.valueOf(splitted[5]); //Color of the vehicle
				FuelType fueltype= FuelType.valueOf(splitted[6]); //type of fuel the vehicle uses
				double Mileage = Double.parseDouble(splitted[7]); //The mileage of the vehicle
				double mass = Double.parseDouble(splitted[8]); //The mass of the vehicle
				int cylinders = Integer.parseInt(splitted[9]);
				double gasTankCapacity= Double.parseDouble(splitted[10]);
				StartMechanism startMechanism = StartMechanism.valueOf(splitted[11]);
				
				
				
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
	 * Constructor that reads the data from a CSV file located at vehicleFilePath. Initialize each
	 * of the Vehicle objects (Hint: call readFromFile).
	 * @param fileName
	 */
	public void VehicleManager(String fileName) {
		//initialize filepath to fileName
		this.VehicleFilePath=fileName;
		
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
		return null;
	}

	/**
	 * Calculate the maintenance cost for each vehicle in the vehicle list and return the vehicle
	 * with the lowest maintenance cost.
	 * If multiple vehicles have the same maintenance cost, randomly return one of the
	 * vehicles (Use the Random class for random selection).
	 */
	public AbstractVehicle getVehicleWithLowestMaintenanceCost(double distance) {
		return null;
	}

	/**
	 * Calculate the fuel efficiencies for each vehicle in the vehicle list and return the vehicle
	 * with the highest fuel efficiency.
	 * If multiple vehicles have the same highest fuel efficiency, return vehicles with the same
	 * highest fuel efficiency in an ArrayList.
	 */
	public ArrayList<AbstractVehicle> getVehicleWithHighestFuelEfficiency(double distance, double fuelPrice) {
		return null;
	}

	/**
	 * Calculate the fuel efficiencies for each vehicle in the vehicle list and return the vehicle
	 * with the lowest fuel efficiency.
	 * If multiple vehicles have the same lowest fuel efficiency, return vehicles with the same
	 * lowest fuel efficiency in an ArrayList.
	 */
	public ArrayList<AbstractVehicle> getVehicleWithLowestFuelEfficiency(double distance, double fuelPrice) {
		return null;
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
