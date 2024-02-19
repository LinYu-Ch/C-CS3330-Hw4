package group.hw4.vehicles;

public class Truck extends AbstractVehicle{
	
	
    // constructor /////////
    public Truck(String brand, String make, long modelYear, double price, VehicleColor color,
                 FuelType fuelType, double mileage, double mass, int cylinders,
                 double gasTankCapacity, StartMechanism startType, double cargoCapacity) {
        super(brand, make, modelYear, price, color, fuelType, mileage, mass, cylinders, gasTankCapacity, startType);
    }
    
    

	// abstracted methods ///////////
	@Override
	public double calculateMaintenaceCost(double distance) {
		/**
		 * Expected formula:
		 * maintenanceCost = distance * mass * (currentYear-modelYear) * cylinders * 0.002
		 * */
		return 0;
	}

	@Override
	public double calculateFuelEfficiency(double distance, double fuelPrice) {
		/**
		 * Expected formula:
		 * fuelEfficiency = cylinders * gasTankCapacity * fuelPrice / distance * 0.1
		 * */
		return 0;
	}

	@Override
	public void startEngine() {
		/**
		 * Expected formula:
		 * KEYSTART
		 * */
	}

}
