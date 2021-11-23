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
 * Run on Replit:   https://replit.com/@phamn23/CarNP#CarNP.java
 */

import java.util.Calendar;

class CarNP {

    // instance variables
    private String make;
    private String model;

    private int year;

    private double odometer;
    private double tankLevel;
    private double tankSize;

    private CS12Date saleDate;
    private double salePrice;

    // creates a new CarNP with default variables
    // wasn't outlined in the program spec but it does reduce redundancy
    private void defaultCarNP() {

        setMake("Sierra");
        setModel("Wolverine");

        setYear(Calendar.getInstance().get(Calendar.YEAR));

        setOdometer(0.0);
        setTankLevel(0.0);
        setTankSize(0.0);

        setSaleDate(new CS12Date());
        setSalePrice(0.0);

    }

    public CarNP() {

        defaultCarNP();

    }

    // creates a new CarNP with specified variables
    public CarNP(String make, String model, int year, double odometer, double tankLevel, double tankSize, CS12Date saleDate, double salePrice) {

        setMake(make);
        setModel(model);

        setYear(year);

        setOdometer(odometer);
        setTankLevel(tankLevel);
        setTankSize(tankSize);

        setSaleDate(saleDate);
        setSalePrice(salePrice);

    }

    // creates a new CarNP with specified make, model, and year
    public CarNP(String make, String model, int year) {

        // initialize default variables
        defaultCarNP();

        // override default variables with specified variables
        setMake(make);
        setModel(model);
        setYear(year);

    }

    // creates a new CarNP with specified make, model, and odometer
    public CarNP(String make, String model, double odometer) {

        // initialize default variables
        defaultCarNP();

        // override default variables with specified variables
        setMake(make);
        setModel(model);
        setOdometer(odometer);

    }

    // return instance variables seperated by commas
    public String toString() {

        return String.join(", ", 
            getMake(), 
            getModel(), 
            Integer.toString(getYear()), 
            Double.toString(getOdometer()), 
            Double.toString(getTankLevel()),
            Double.toString(getTankSize()), 
            getSaleDate().toString(), 
            Double.toString(getSalePrice()));

    }

    // display all instance vriables and derived data in a label-value format
    public void print() {

        System.out.printf("%-25s %s\n", "Make:", getMake());
        System.out.printf("%-25s %s\n", "Model:", getModel());
        System.out.printf("%-25s %d\n", "Year:", getYear());
        System.out.printf("%-25s %.2f\n", "Odometer [miles]:", getOdometer());
        System.out.printf("%-25s %.2f\n", "Tank level [gallons]:", getTankLevel());
        System.out.printf("%-25s %.2f\n", "Tank size [gallons]:", getTankSize());
        System.out.printf("%-25s %s\n", "Sale date:", getSaleDate().toString());
        System.out.printf("%-25s %.2f\n", "Sale price [$]:", getSalePrice());

    }

    // display all instance vriables and derived data in a label-value format preceded by a formatted box message 
    public void print(String message) {

        UtilsNP.message(message, true);
        print();

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
        this.year = year;
    }

    public void setYear(boolean guiMode) {
        this.year = UtilsNP.readInt("Enter model year: ", guiMode);
    }

    // get and set methods for odometer
    public double getOdometer() {
        return odometer;
    }

    public void setOdometer(double odometer) {
        this.odometer = odometer;
    }

    public void setOdometer(boolean guiMode) {
        this.odometer = UtilsNP.readDouble("Enter odometer [miles]: ", guiMode);
    }

    // get and set methods for tank level
    public double getTankLevel() {
        return tankLevel;
    }

    public void setTankLevel(double tankLevel) {
        this.tankLevel = tankLevel;
    }

    public void setTankLevel(boolean guiMode) {
        this.tankLevel = UtilsNP.readDouble("Enter current tank level [gallons]: ", guiMode);
    }

    // get and set methods for tank size
    public double getTankSize() {
        return tankSize;
    }

    public void setTankSize(double tankSize) {
        this.tankSize = tankSize;
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
        this.salePrice = salePrice;
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
                this.getOdometer() == temp.getOdometer() &&
                this.getTankLevel() == temp.getTankLevel() &&
                this.getTankSize() == temp.getTankSize() &&
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
        System.out.printf("%-25s %s\n", "Make alone:", car2.getMake());
        System.out.printf("%-25s %s\n", "Model alone:", car2.getModel());
        System.out.printf("%-25s %d\n", "Year alone:", car2.getYear());
        System.out.printf("%-25s %.2f\n", "Odometer alone:", car2.getOdometer());
        System.out.printf("%-25s %.2f\n", "Tank level alone:", car2.getTankLevel());
        System.out.printf("%-25s %.2f\n", "Tank size alone:", car2.getTankSize());
        System.out.printf("%-25s %s\n", "Sale date alone:", car2.getSaleDate().toString());
        System.out.printf("%-25s %.2f\n", "Sale price alone:", car2.getSalePrice());
        
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
        car1.setMake(false);
        car1.setModel(false);
        car1.setYear(false);
        car1.setOdometer(false);
        car1.setTankLevel(false);
        car1.setTankSize(false);
        car1.setSaleDate(false);
        car1.setSalePrice(false);

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