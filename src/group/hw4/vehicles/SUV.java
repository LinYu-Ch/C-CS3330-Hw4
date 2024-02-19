package group.hw4.vehicles;

public class SUV extends AbstractVehicle{
	
	
    // constructor /////////
    public SUV(String brand, String make, long modelYear, double price, VehicleColor color,
                 FuelType fuelType, double mileage, double mass, int cylinders,
                 double gasTankCapacity, StartMechanism startType) {
        super(brand, make, modelYear, price, color, fuelType, mileage, mass, cylinders, gasTankCapacity, startType);
    }
    

	// abstracted methods ///////////
	@Override
	public double calculateMaintenaceCost(double distance) {
		/**
		 * Expected formula:
		 * maintenanceCost = distance * mass * (currentYear-modelYear) * cylinders * 0.001
		 * */
		return 0;
	}
	
	@Override
	public double calculateFuelEfficiency(double distance, double fuelPrice) {
		/**
		 * Expected formula:
		 * fuelEfficiency = cylinders * gasTankCapacity * fuelPrice / distance * 0.05
		 * */
		return 0;
	}
	
	@Override
	public void startEngine() {
		/**
		 * Expected formula:
		 * PUSHSTART
		 * */
	}

}
