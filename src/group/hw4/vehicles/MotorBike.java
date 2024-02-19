package group.hw4.vehicles;

public class MotorBike extends AbstractVehicle{
	
	
    // constructor /////////
    public MotorBike(String brand, String make, long modelYear, double price, VehicleColor color,
                 FuelType fuelType, double mileage, double mass, int cylinders,
                 double gasTankCapacity, StartMechanism startType, double cargoCapacity) {
        super(brand, make, modelYear, price, color, fuelType, mileage, mass, cylinders, gasTankCapacity, startType);
    }
    

	// abstracted methods ///////////
	@Override
	public double calculateMaintenaceCost(double distance) {
		/**
		 * Expected formula:
		 * maintenanceCost = distance * mass * (currentYear-modelYear) * cylinders * 0.0002
		 * */
		return 0;
	}
	
	@Override
	public double calculateFuelEfficiency(double distance, double fuelPrice) {
		/**
		 * Expected formula:
		 * fuelEfficiency = cylinders * gasTankCapacity * fuelPrice / distance * 0.001
		 * */
		return 0;
	}
	
	@Override
	public void startEngine() {
		/**
		 * Expected formula:
		 * KICKSTART
		 * */
	}

}
