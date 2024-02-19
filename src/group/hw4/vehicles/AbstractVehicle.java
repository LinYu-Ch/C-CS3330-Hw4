package group.hw4.vehicles;

public abstract class AbstractVehicle {
	
	// variables ///////////////
	protected String brand;
	protected String make;
	protected long modelYear;
	protected double price;
	protected VehicleColor color;
	protected FuelType fuelType;
	protected double mileage;
	protected double mass;
	protected int cylinders;
	protected double gasTankCapacity;
	protected StartMechanism startType;
	
	// base constructor ///////////////
	public AbstractVehicle(String brand, String make, long modelYear, double price, VehicleColor color, FuelType fuelType, double mileage, double mass, int cylinders, double gasTankCapacity, StartMechanism startType) {
		this.brand = brand;
		this.make = make;
		this.modelYear = modelYear;
		this.price = price;
		this.color = color;
		this.fuelType = fuelType;
		this.mileage = mileage;
		this.mass = mass;
		this.cylinders = cylinders;
		this.gasTankCapacity = gasTankCapacity;
		this.startType = startType;
 }

	
    // Copy constructor
    public AbstractVehicle(AbstractVehicle other) {
	    this.brand = other.brand;
	    this.make = other.make;
	    this.modelYear = other.modelYear;
	    this.price = other.price;
	    this.color = other.color;
	    this.fuelType = other.fuelType;
	    this.mileage = other.mileage;
	    this.mass = other.mass;
	    this.cylinders = other.cylinders;
	    this.gasTankCapacity = other.gasTankCapacity;
	    this.startType = other.startType;
    }
	
	// abstract methods ///////////
	
	// calculates maintenance cost for a specific vehicle
	public abstract double calculateMaintenaceCost(double distance); 
	
	// calculates the engine efficiency
	public abstract double calculateFuelEfficiency(double distance, double fuelPrice);
	
	// prints how the vehicle starts
	public abstract void startEngine();
	
	
	
	// Getters and setters ///////
	public String getBrand() {
		return brand;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public long getModelYear() {
		return modelYear;
	}
	
	public void setModelYear(long modelYear) {
		this.modelYear = modelYear;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public VehicleColor getColor() {
		return color;
	}
	
	public void setColor(VehicleColor color) {
		this.color = color;
	}
	
	public FuelType getFuelType() {
		return fuelType;
	}
	
	public void setFuelType(FuelType fuelType) {
		this.fuelType = fuelType;
	}
	
	public double getMileage() {
		return mileage;
	}
	
	public void setMileage(double mileage) {
		this.mileage = mileage;
	}
	
	public double getMass() {
		return mass;
	}
	
	public void setMass(double mass) {
		this.mass = mass;
	}
	
	public int getCylinders() {
		return cylinders;
	}
	
	public void setCylinders(int cylinders) {
		this.cylinders = cylinders;
	}
	
	public StartMechanism getStartType() {
		return startType;
	}
	
	public void setStartType(StartMechanism startType) {
		this.startType = startType;
	}
	
	// to string method
	@Override
	public String toString() {
		return "Vehicle [brand=" + brand + ", modelYear=" + modelYear + ", price=" + price + ", color=" + color
				+ ", fuelType=" + fuelType + ", mileage=" + mileage + ", mass=" + mass + ", cylinders=" + cylinders
				+ ", startType=" + startType + "]";
	}
}
