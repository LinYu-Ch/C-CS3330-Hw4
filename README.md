**_C-CS3330-HW4_**
------------------------------

_**Authors**_
------------------------------
- Darkskymoon - Zoe
- Derbzzzzzz - Ryan
- andopepe - Ando
- LinYu-Ch - John

**_Description_**
---------------------------
This project implements a hypothetical vehicle manager that utilizes a singleton design structure. It manages Trucks, Cars, SUVs, and MotorBikes, but could be extended further since they are all derived from an abstract class. each vehicle can hold the following information: brand, make, modelYear, price, color, fuelType, mileage, mass, cylinders, gasTankCapacity, and startType. The project also uses Enums to represent some of the data fields such as color and fuelType. Vehicles can be added, removed, and saved to a file (which data can also be retrieved from). The maintenance costs (lowest/highest) and fuel efficiency (lowest/highest) can also be retrieved. Finally the average fuel efficiency of an SUV can be returned to the user.

**_Contributions_**
----------------------------
_- Zoe:_

Completed the following methods:
- readFromFile()
- displayVehicleInformation()
- displayAllVehicleInformation()
- saveVehicleList()

Additionally:
- implemented singleton design pattern in vehicleManager by making a private constructor, adding a filePath variable, an instance variable, and a way to get the instance of the singleton.
- added equal methods for each of the different vehicles + abstract vehicle class
- toString methods for each of the concrete vehicles

_- Ryan:_  
    
Completed the following methods:  
-  getVehicleWithHighestMaintenanceCost  
-  getVehicleWithLowestMaintenanceCost  
-  getVehicleWithHighestFuelEfficiency  
-  getVehicleWithLowestFuelEfficiency  

Additionally:  
- Wrote test code for the 4 methods above  
- Wrote test code for Singleton Design Pattern  
- Wrote code to clean up vehicleList.csv after program completion  
- Wrote helper method getCopy to prevent information leaks
- Implemented the following abstract methods for each subclass of AbstractVehicle  
    * calculateMaintenaceCost  
    * calculateFuelEfficiency  
    * startEngine  

_- Ando:_

Completed the following methods:  
-   removeVehicle
-   addVehicle
-   isVehicleType
-   getNumberOfVehiclesByType

Additionally:  
- Added gitignore
- Cleaned up directories
- Wrote test code for the 4 methods above  

_- John:_
Project Initialization including: setting up Github, Vehicle Class, FuelType enum, StartMechanism enum, VehicleColorEnum, VehicleMangerClass, Classes for each type of vehicle. 

Implemented the methods:
-    displayAllCarInformation
-    displayAllTruckInformation
-    displayAllSUVInformation
-    displayAllMotorBikeInformation
-    getAverageFuelEfficiencyOfSUVs

_**Running The Code:**_
--------------------------
There are no additional requirements to run the code. To run the code clone the repository:

git clone https://github.com/LinYu-Ch/C-CS3330-Hw4.git

You should then be able to select the main file and run the code. The necessary files for the vehicleList are already located within the project.
