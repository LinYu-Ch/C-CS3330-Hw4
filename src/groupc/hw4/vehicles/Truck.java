package groupc.hw4.vehicles;

public class Truck extends AbstractVehicle{
	
	
    // constructor /////////
    public Truck(String brand, String make, long modelYear, double price, VehicleColor color,
                 FuelType fuelType, double mileage, double mass, int cylinders,
                 double gasTankCapacity, StartMechanism startType) {
        super(brand, make, modelYear, price, color, fuelType, mileage, mass, cylinders, gasTankCapacity, startType);
    }
    
    //copy constructor
    public Truck(Truck truck) {
		super(truck);
	}

	// abstracted methods ///////////
	@Override
	public double calculateMaintenaceCost(double distance) {
		double maintenanceCost = distance * mass * (currentYear-modelYear) * cylinders * 0.002;
		 
		return maintenanceCost;
	}

	@Override
	public double calculateFuelEfficiency(double distance, double fuelPrice) {
		double fuelEfficiency = cylinders * gasTankCapacity * fuelPrice / distance * 0.1;
		 
		return fuelEfficiency;
	}

	@Override
	public void startEngine() {
		System.out.println(StartMechanism.KEYSTART);
	}

	
	//toString override
	@Override
	public String toString() {
		return "[Vehicletype="+"Truck"+", brand=" + brand + ", make=" + make+ ",  modelYear=" + modelYear + ", price=" + price + ", color=" + color
				+ ", fuelType=" + fuelType + ", mileage=" + mileage + ", mass=" + mass + ", cylinders=" + cylinders
				+ ", startType=" + startType + ", GasTankCapacity=" + gasTankCapacity +  "]";
	}
	
	//equals override that checks the class as well, returning false if the classes don't match 
	@Override
	public boolean equals(Object obj) {
		if(obj.getClass() == this.getClass()) {
			return super.equals(obj);
		}
		return false;
	}
	
	/**
	 * returns a File compatible string of what the class is
	 * @param obj
	 * @return string representing the class
	 */
	public String getClassString() {
		return "Truck";
	}
}


