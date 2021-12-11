/*
 * Name:            Nathan Pham
 * 
 * Course:          CS-12, Fall 2021
 * 
 * Date:            11/22/21
 *
 * Filename:        CarNP.java
 *
 * Purpose:         This class contains a Car that demonstrates accessor, mutator, equivalence, and toString methods.
 * 
 * Github:          http://github.com/nathan-pham/car-np
 */

import java.util.Calendar;

class CarNP {

    // instance variables
    private String make;
    private String model;

    private int year;

    private double odometer;
    private double tankSize;
    private double tankLevel;

    private CS12Date saleDate;
    private double salePrice;

    // constant variables
    private final double THRESHOLD = .0001;

    // hidden variables
    double _tripMiles, _tripGallons, _tripMPG;

    // creates a new CarNP with default variables
    public CarNP() {

        // initialize default variables
        setMake("Sierra");
        setModel("Wolverine");

        setYear(Calendar.getInstance().get(Calendar.YEAR));

        setOdometer(0.0);
        setTankSize(0.0);
        setTankLevel(0.0);

        setSaleDate(new CS12Date());
        setSalePrice(0.0);

        _tripMiles = 0.0;
        _tripGallons = 0.0;
        _tripMPG = 25.0;

    }

    // creates a new CarNP with specified variables
    public CarNP(String make, String model, int year, double odometer, double tankLevel, double tankSize, CS12Date saleDate, double salePrice) {

        // initialize default variables
        this();


        setMake(make);
        setModel(model);

        setYear(year);

        setOdometer(odometer);
        setTankSize(tankSize);
        setTankLevel(tankLevel);

        setSaleDate(saleDate);
        setSalePrice(salePrice);

    }

    // creates a new CarNP with specified make, model, and year
    public CarNP(String make, String model, int year) {

        // initialize default variables
        this();

        // override default variables with specified variables
        setMake(make);
        setModel(model);
        setYear(year);

    }

    // creates a new CarNP with specified make, model, and odometer
    public CarNP(String make, String model, double odometer) {

        // initialize default variables
        this();

        // override default variables with specified variables
        setMake(make);
        setModel(model);
        setOdometer(odometer);

    }

    // return instance variables seperated by commas
    public String toString() {

        return String.join(" ", 
            getMake(), 
            getModel(), 
            Integer.toString(getYear()), 
            String.format("%,.2f", getOdometer()), 
            Double.toString(getTankLevel()),
            Double.toString(getTankSize()), 
            getSaleDate().toString(),
            String.format("%,.2f", getSalePrice()));

    }

    // display all instance vriables and derived data in a label-value format
    public void print() {

        // print instance variables
        System.out.printf("%-35s %s\n", "Make:", getMake());
        System.out.printf("%-35s %s\n", "Model:", getModel());
        System.out.printf("%-35s %d\n", "Model Year:", getYear());
        System.out.printf("%-35s %,.2f\n", "Odometer [miles]:", getOdometer());
        System.out.printf("%-35s %,.2f\n", "Tank level [gallons]:", getTankLevel());
        System.out.printf("%-35s %,.2f\n", "Tank size [gallons]:", getTankSize());
        System.out.printf("%-35s %s\n", "Sale date:", getSaleDate().toString());
        System.out.printf("%-35s %,.2f\n\n", "Sale price [$]:", getSalePrice());

        // print derived data
        System.out.printf("%-35s %d\n", "age [years]:", getAge());
        System.out.printf("%-35s %s\n", "status:", getStatus());
        System.out.printf("%-35s %,.2f\n", "depreciated value [$]:", getValue(5));
        System.out.printf("%-35s %,.2f\n", "remaining fuel [%]", getFuelPct());
        System.out.printf("%-35s %,.2f\n", "fuel travel range [miles]:", getFullRange());
        System.out.printf("%-35s %,.2f\n", "remaining travel range [miles]:", getTripRange());
        System.out.printf("%-35s %,.2f\n", "current MPG [miles/gal]", getMPG());
        
    }

    // display all instance variables and derived data in a label-value format preceded by a formatted box message 
    public void print(String message) {

        UtilsNP.message(message, true);
        print();

    }

    // display primary variables in advertisement-like format
    public void display() {

        System.out.printf("FOR SALE: used %s %s %s\n%s gal tank %s MPG %.2f miles\nlast sold %s $%,.2f est. value $%,.2f", getYear(), getMake(), getModel(), getTankSize(), getMPG(), getTankSize() * getMPG(), getSaleDate(), getSalePrice(), getValue(8));

    }

    // get and set methods for make
    public String getMake() { 
        return make; 
    }

    public void setMake(String make) { 
        this.make = make; 
    }
    
    public void setMake(boolean guiMode) { 
        this.make = UtilsNP.readString("Enter car make: ", guiMode); 
    }

    // get and set methods for model
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setModel(boolean guiMode) {
        this.model = UtilsNP.readString("Enter car model: ", guiMode);
    }

    // get and set methods for year
    public int getYear() {
        return year;
    }

    public void setYear(int year) {

        // year must be greater than 1900
        if(year >= 1900) {
            this.year = year;
        }

        // otherwise, print error
        else {
            UtilsNP.error("setYear(int year)", "year must be greater than or equal to 1900", "no change made");
        }

    }

    public void setYear(boolean guiMode) {
        this.year = UtilsNP.readInt("Enter model year: ", guiMode);
    }

    // get and set methods for odometer
    public double getOdometer() {
        return odometer;
    }

    public void setOdometer(double odometer) {

        // odometer must be greater than or equal to 0
        if(odometer >= 0.0) {
            this.odometer = odometer;
        }

        // otherwise, print error
        else {
            UtilsNP.error("setOdometer(double odometer)", "odometer must be greater than or equal to 0", "no change made");
        }

    }

    public void setOdometer(boolean guiMode) {
        this.odometer = UtilsNP.readDouble("Enter odometer [miles]: ", guiMode);
    }

    // get and set methods for tank level
    public double getTankLevel() {
        return tankLevel;
    }

    public void setTankLevel(double tankLevel) {

        // tank level must be greater than or equal to 0
        if(tankLevel >= 0.0) {

            // tank level must be less than or equal to tank size
            if(tankLevel <= getTankSize()) {
                this.tankLevel = tankLevel;
            }

            // otherwise, print error
            else {

                UtilsNP.error("setTankLevel(double tankLevel)", "tank level must be less than or equal to tank size", "no change made");

            }

        }

        // otherwise, print error
        else {
            UtilsNP.error("setTankLevel(double tankLevel)", "tank level must be greater than or equal to 0", "no change made");
        }

    }

    public void setTankLevel(boolean guiMode) {
        this.tankLevel = UtilsNP.readDouble("Enter current tank level [gallons]: ", guiMode);
    }

    // get and set methods for tank size
    public double getTankSize() {
        return tankSize;
    }

    public void setTankSize(double tankSize) {

        // tank size must be greater than or equal to 0
        if(tankSize >= 0.0) {

            // tank size must be greater than or equal to tank level
            if(tankSize >= getTankLevel()) {
                this.tankSize = tankSize;
            }

            // otherwise, print error
            else {

                UtilsNP.error("setTankSize(double tankSize)", "tank size must be greater than or equal to tank level", "no change made");

            }

        }

        // otherwise, print error
        else {
            UtilsNP.error("setTankSize(double tankSize)", "tank size must be greater than or equal to 0", "no change made");

        }

    }

    public void setTankSize(boolean guiMode) {
        this.tankSize = UtilsNP.readDouble("Enter total tank size [gallons]: ", guiMode);
    }

    // get and set methods for sale date
    public CS12Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(CS12Date saleDate) {
        this.saleDate = saleDate;
    }

    public void setSaleDate(boolean guiMode) {
        
        int month = UtilsNP.readInt("Enter month of sale: ", guiMode),
            day = UtilsNP.readInt("Enter day of sale: ", guiMode),
            year = UtilsNP.readInt("Enter year of sale: ", guiMode);

        this.saleDate = new CS12Date(month, day, year);
    
    }

    // get and set methods for sale price
    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {

        // sale price must be greater than or equal to 0
        if(salePrice >= 0.0) {
            this.salePrice = salePrice;
        }

        // otherwise, print error
        else {
            UtilsNP.error("setSalePrice(double salePrice)", "sale price must be greater than or equal to 0", "no change made");
        }

    }

    public void setSalePrice(boolean guiMode) {
        this.salePrice = UtilsNP.readDouble("Enter sale price [$]: ", guiMode);
    }

    // determine equality
    public boolean equals(Object obj) {
        
        // check object is a CarNP object
        if (obj instanceof CarNP) {

            // cast object to CarNP
            CarNP temp = (CarNP) obj;
            
            // check data field-by-field
            if (this.getMake().equals(temp.getMake()) &&
                this.getModel().equals(temp.getModel()) &&
                this.getYear() == temp.getYear() &&
                Math.abs(this.getOdometer() - temp.getOdometer()) < THRESHOLD &&
                Math.abs(this.getTankLevel() - temp.getTankLevel()) < THRESHOLD &&
                Math.abs(this.getTankSize() - temp.getTankSize()) < THRESHOLD &&
                this.getSaleDate().equals(temp.getSaleDate()) &&
                this.getSalePrice() == temp.getSalePrice()) {
                return true;

            }
            
            // one or more fields differ, not same date
            else {
                return false;
            }
        }
        
        // object is not a CarNP, so can't compare
        else {         
            return false;
        }

    }

    // derived data accessors
    // get method for age
    public int getAge() {
        
        // use UtilsNP to get age of car using the 1/1/model year
        return UtilsNP.getAge(new CS12Date(1, 1, getYear()));

    }    

    // get method for status
    public String getStatus() {

        int age = getAge();

        // car is a prototype if age < 0
        if(age < 0) {
            return "prototype";
        } 
        
        // car is new and unused
        else if(age == 0) {
            return "new";
        } 
        
        // car has been used before
        else {
            return "used";
        }

    }

    public double getValue(int deprYear) {

        double salePrice = getSalePrice();

        // depreciation year must be equal to 5 or 8
        if(deprYear == 5 || deprYear == 8) {
            return getAge() <= 0 ? salePrice : salePrice - (getAge() * salePrice / (float) deprYear);
        }

        // otherwise, print error
        else {

            UtilsNP.error("getValue(int deprYear)", "depreciation year must be 5 or 8", "return salePrice");
            return salePrice;

        }

    }

    // return current fuel level as a percent of tank size
    public double getFuelPct() {

        double tankSize = getTankSize();
        return tankSize == 0 ? 0 : (getTankLevel() * 100 / (float) tankSize);

    }

    // return full range of car
    public double getFullRange() {
        return getTankSize() * getMPG();
    }

    // return remaining range of car
    public double getTripRange() {
        return getTankLevel() * getMPG();
    }

    // returns current miles / gallon
    public double getMPG() {

        _tripMPG = _tripGallons == 0 ? _tripMPG : _tripMiles / _tripGallons;
        return _tripMPG;

    }

    // utility methods
    // update all instance variables at once with prompts
    public void update(boolean guiMode) {

        setMake(guiMode);
        setModel(guiMode);
        setYear(guiMode);
        setOdometer(guiMode);
        setTankLevel(guiMode);
        setTankSize(guiMode);
        setSaleDate(guiMode);
        setSalePrice(guiMode);
        
    }

    // allows user to drive the car some specified distance at a specified MPG rate
    public void drive(double miles, double mpg) {

        _tripMiles = miles;
        _tripGallons = miles / mpg;
        getMPG();

    }

    // allows user to drive the car some specified distance using the current MPG rate
    public void drive(double miles) {
        drive(miles, getMPG());
    }

    // add more fuel to the tank
    public void fuel(double gallons) {

        // gallons must be greater than 0
        if(gallons > 0) {

            double tankLevel = getTankLevel() + gallons;

            // new tank level must be lower than the tank size
            if(tankLevel < getTankSize()) {
                setTankLevel(tankLevel);
            }

            // otherwise, print error
            else {
                UtilsNP.error("fuel(double gallons)", "tank level must be less than or equal to tank size", "no change made");
            }

        }

        // otherwise, print error
        else {
            UtilsNP.error("fuel(double gallons)", "gallons must be greater than or equal to 0", "no change made");
        }

    }

    // sell the car for a specified price on a given date
    public void sell(double price, CS12Date date) {

        setSalePrice(price);
        setSaleDate(date);

    }

    // Test 1: initialize some Car objects
    public static void runTest1() {

        // initialize variables
        CarNP car1, car2, car3, car4;

        UtilsNP.message("Test 1: Create 4 Car objects, using all 4 constructor forms", true);
        
        // create 4 Car objects using all 4 constructor forms
        car1 = new CarNP();
        car2 = new CarNP("Honda", "Odysssey", 2010, 100_000.0, 17.5, 20.0, new CS12Date(5, 1, 2010), 27995.99);
        car3 = new CarNP("Toyota", "Prius", 2018);
        car4 = new CarNP("Tesla", "Model S", 123.4);

        System.out.println("(no visible output)");
        UtilsNP.blank();

    }

    // Test 2: display all Car objects
    public static void runTest2() {

        // initialize variables
        CarNP car1 = new CarNP(), 
            car2 = new CarNP("Honda", "Odysssey", 2010, 100_000.0, 17.5, 20.0, new CS12Date(5, 1, 2010), 27995.99),
            car3 = new CarNP("Toyota", "Prius", 2018), 
            car4 = new CarNP("Tesla", "Model S", 123.4);

        UtilsNP.message("Test 2: Display all Car objects using toString and overloaded print", true);
        UtilsNP.blank();

        // print car 1
        System.out.println(car1);
        car1.print("default constructor - car1");
        UtilsNP.blank();
        UtilsNP.pause();
        
        // print car 2
        System.out.println(car2);
        car2.print("full constructor - car2");
        UtilsNP.blank();
        UtilsNP.pause();

        // print car 3
        System.out.println(car3);
        car3.print("make/model/year constructor - car3");
        UtilsNP.blank();
        UtilsNP.pause();

        // print car 4
        System.out.println(car4);
        car4.print("make/model/odometer constructor - car4");
        UtilsNP.blank();
        UtilsNP.pause();

    }

    // Test 3: display a Car using the accessor functions
    public static void runTest3() {

        // initialize variables
        CarNP car2 = new CarNP("Honda", "Odysssey", 2010, 100_000.0, 17.5, 20.0, new CS12Date(5, 1, 2010), 27995.99);

        UtilsNP.message("Test 3: Display all instance variables with accessor functions", true);
        UtilsNP.blank();
        car2.print("Starting car");

        UtilsNP.blank();
        System.out.println("All instance variables displayed using each get");
        System.out.printf("%-35s %s\n", "Make alone:", car2.getMake());
        System.out.printf("%-35s %s\n", "Model alone:", car2.getModel());
        System.out.printf("%-35s %d\n", "Year alone:", car2.getYear());
        System.out.printf("%-35s %.2f\n", "Odometer alone:", car2.getOdometer());
        System.out.printf("%-35s %.2f\n", "Tank level alone:", car2.getTankLevel());
        System.out.printf("%-35s %.2f\n", "Tank size alone:", car2.getTankSize());
        System.out.printf("%-35s %s\n", "Sale date alone:", car2.getSaleDate().toString());
        System.out.printf("%-35s %.2f\n", "Sale price alone:", car2.getSalePrice());
        
        UtilsNP.blank();
        UtilsNP.pause();

    }

    // Test 4: update each Car field using mutators
    public static void runTest4() {

        // initialize variables
        CarNP car1 = new CarNP();

        // print starting car
        UtilsNP.message("Test 4: Update each field with mutators", true);
        UtilsNP.blank();
        car1.print("Starting car");

        UtilsNP.blank();
        System.out.println("All instance variables updated using sets");
        UtilsNP.blank();

        car1.setMake("Toyota");
        car1.setModel("Prius");
        car1.setYear(2018);
        car1.setOdometer(1234.5);
        car1.setTankLevel(12.3);
        car1.setTankSize(23.4);
        car1.setSaleDate(new CS12Date(4, 1, 2010));
        car1.setSalePrice(23456.78);

        car1.print("Default car updated");
        UtilsNP.blank();
        UtilsNP.pause();

    }

    // Test 5: update each Car field using prompt mutators
    public static void runTest5() {

        // initialize variables
        CarNP car1 = new CarNP();

        UtilsNP.message("Test 5: Update each field with prompt mutators", true);
        UtilsNP.blank();
        car1 = new CarNP();
        car1.print("Starting car");

        UtilsNP.blank();
        System.out.println("All instance variables updated using prompts");
        car1.update(false);

        UtilsNP.blank();
        car1.print("Default car updated");
        UtilsNP.blank();
        UtilsNP.pause();

    }

    // Test 6: use the equals method
    public static void runTest6() {

        // initialize variables
        CarNP car1 = new CarNP(), 
            car2 = new CarNP("Honda", "Odysssey", 2010, 100_000.0, 17.5, 20.0, new CS12Date(5, 1, 2010), 27995.99);

        UtilsNP.message("Test 6: Test equals method", true);
        System.out.printf("%-30s%s\n", "test car1 vs car1:", car1.equals(car1));
        System.out.printf("%-30s%s\n", "test car1 vs car2:", car1.equals(car2));
        System.out.printf("%-30s%s\n", "test car1 vs any String:", car1.equals("A Car"));
        System.out.printf("%-30s%s\n", "test car1 vs any CS12Date:", car1.equals(new CS12Date(1, 1, 2000)));

    }

    // main method
    public static void main(String[] args) {


        // run tests
        runTest1();
        runTest2();
        runTest3();
        runTest4();
        runTest5();
        runTest6();
        
        // end of tests
        UtilsNP.blank();
        UtilsNP.message("End of Tests", true);

    }

}