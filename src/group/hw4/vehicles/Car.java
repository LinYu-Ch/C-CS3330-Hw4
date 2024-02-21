package group.hw4.vehicles;

public class Car extends AbstractVehicle{
	
	
    // constructor /////////
    public Car(String brand, String make, long modelYear, double price, VehicleColor color,
                 FuelType fuelType, double mileage, double mass, int cylinders,
                 double gasTankCapacity, StartMechanism startType) {
        super(brand, make, modelYear, price, color, fuelType, mileage, mass, cylinders, gasTankCapacity, startType);
    }
    

	// abstracted methods ///////////
	@Override
	public double calculateMaintenaceCost(double distance) {
		double maintenanceCost = distance * mass * (currentYear-modelYear) * cylinders * 0.0005;
		
		return maintenanceCost;
	}
	
	@Override
	public double calculateFuelEfficiency(double distance, double fuelPrice) {
		double fuelEfficiency = cylinders * gasTankCapacity * fuelPrice / distance * 0.003;
		 
		return fuelEfficiency;
	}
	
	@Override
	public void startEngine() {
		System.out.println(StartMechanism.PUSHSTART);
	}
	
	//tostring override
	@Override
	public String toString() {
		return "[Vehicletype="+"Car"+", brand=" + brand + ", make=" + make+ ",  modelYear=" + modelYear + ", price=" + price + ", color=" + color
				+ ", fuelType=" + fuelType + ", mileage=" + mileage + ", mass=" + mass + ", cylinders=" + cylinders
				+ ", startType=" + startType + ", GasTankCapacity=" + gasTankCapacity +  "]";
	}

}
