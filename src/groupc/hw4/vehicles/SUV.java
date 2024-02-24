package groupc.hw4.vehicles;

public class SUV extends AbstractVehicle{
	
	
    // constructor /////////
    public SUV(String brand, String make, long modelYear, double price, VehicleColor color,
                 FuelType fuelType, double mileage, double mass, int cylinders,
                 double gasTankCapacity, StartMechanism startType) {
        super(brand, make, modelYear, price, color, fuelType, mileage, mass, cylinders, gasTankCapacity, startType);
    }
    
    //copy constructor
    public SUV(SUV suv) {
		super(suv);
	}

	// abstracted methods ///////////
	@Override
	public double calculateMaintenaceCost(double distance) {
		double maintenanceCost = distance * mass * (currentYear-modelYear) * cylinders * 0.001;
		
		return maintenanceCost;
	}
	
	@Override
	public double calculateFuelEfficiency(double distance, double fuelPrice) {
		double fuelEfficiency = cylinders * gasTankCapacity * fuelPrice / distance * 0.05;
		
		return fuelEfficiency;
	}
	
	@Override
	public void startEngine() {
		System.out.println(StartMechanism.PUSHSTART);
	}
	
	//toString override
	@Override
	public String toString() {
		return "[Vehicletype="+"SUV"+", brand=" + brand + ", make=" + make+ ",  modelYear=" + modelYear + ", price=" + price + ", color=" + color
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
		return "SUV";
	}

}
