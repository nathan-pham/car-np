/*
 * Name:        Nathan Pham
 * 
 * Course:      CS-12, Fall 2021
 * 
 * Date:        11/04/21
 *
 * Filename:    UtilsNP.java
 *
 * Purpose:     This class is a collection of useful utility methods
 */

import javax.swing.JOptionPane;
import java.util.Scanner;

public class UtilsNP {
    
    // get an int value
    public static int readInt(String prompt, Boolean guiMode) {

        // data and scanner variables
        int data;
        Scanner input;

        try {

            // use JOptionPane if guiMode enabled else use Scanner
            if(guiMode) {

                // get input from JOptionPane & convert to int
                data = Integer.parseInt(JOptionPane.showInputDialog(prompt));

            } else {

                // create new scanner
                input = new Scanner(System.in);

                // get input from Scanner & convert to int
                System.out.print(prompt);
                data = input.nextInt();

            }

        } 
        
        // catch InputMismatchException or NumberFormatException
        catch(Exception error) {

            // call function again to get a valid integer
            return readInt(prompt, guiMode);

        }
        

        return data;

    }

    // get a double value
    public static double readDouble(String prompt, Boolean guiMode) {

        // data and scanner variables
        double data;
        Scanner input;

        try {

            // use JOptionPane if guiMode enabled else use Scanner
            if(guiMode) {

                // get input from JOptionPane & convert to int
                data = Double.parseDouble(JOptionPane.showInputDialog(prompt));

            } else {

                // create new scanner
                input = new Scanner(System.in);

                // get input from Scanner & convert to int
                System.out.print(prompt);
                data = input.nextDouble();

            }

        } 
        
        // catch InputMismatchException or NumberFormatException
        catch(Exception error) {

            // call function again to get a valid integer
            return readInt(prompt, guiMode);

        }
        

        return data;

    }

    // get a string value
    public static String readString(String prompt, Boolean guiMode) {

        // data and scanner variables
        String data;
        Scanner input;

        // use JOptionPane if guiMode enabled else use Scanner
        if(guiMode) {

            // get input from JOptionPane
            data = JOptionPane.showInputDialog(prompt);

        } else {

            // create new scanner
            input = new Scanner(System.in);

            // get input from Scanner
            System.out.print(prompt);
            data = input.nextLine();

        }

        // return first char of String cause linter was complaining & I used String
        return data;

    }

    // get a single character
    public static char readChar(String prompt, Boolean guiMode) {

        // reuse string method but only return first character
        return readString(prompt, guiMode).charAt(0);

    }
    
    //---------------------------------------------------------------------------
    // age-related methods
    //---------------------------------------------------------------------------
    
    // returns the age as of some REFERENCE date (2-input overloaded form, MODS NEEDED)
    public static int getAge(CS12Date dateBd, CS12Date dateRef) {

        // age in years, default of -1
        int age = -1;

        // individual date variables
        int bdMonth = dateBd.getMonth(), 
            bdDay = dateBd.getDay(),
            bdYear = dateBd.getYear(),
            refMonth = dateRef.getMonth(),
            refDay = dateRef.getDay(),
            refYear = dateRef.getYear();

        int compare = dateBd.compare(dateRef);

        // if birth date is before reference date
        if(compare > 0) {

            // calculate age from years
            age = refYear - bdYear;
            
            // adjust age depending on months or days
            if(refMonth < bdMonth || (refMonth == bdMonth && refDay < bdDay)) {
                age--;
            }

        } 

        // dates are the same, born today
        else if(compare == 0) {
            
            // set age to zero
            age = 0;
        
        } 

        // birth date is after reference date
        else {

            // print error
            System.out.printf("\nERROR: provided birthdate %s is after reference date %s: age = -1\n", dateBd, dateRef);

        }

        return age;
        
    } // end 2-input overloaded version
    
    //---------------------------------------------------------------------------

    // returns the age as of TODAY'S date (1-input overloaded form, NO CHANGES NEEDED, DO NOT EDIT)
    public static int getAge(CS12Date dateBd) {

        int age;
        CS12Date dateToday = today();
        
        // calls overloaded version of above method, using TODAY as the reference date
        age = getAge(dateBd, dateToday);  
        return age;
        
    } // end 1-input overloaded version
    
    
    //---------------------------------------------------------------------------
    // date-related methods 
    //---------------------------------------------------------------------------
    
    // returns today's date as a CS12Date (NO CHANGES NEEDED, DO NOT EDIT)
    public static CS12Date today() {
    
        // simply return a default date, which is today
        return new CS12Date();
        
    }

    // pauses execution until any key is pressed, specific prompt
    public static void pause(String message) {
        // ignores any returned value
        UtilsNP.readString(message, false);
        System.out.println();   // add a blank line
    }
    
    // pauses execution until any key is pressed, generic prompt
    public static void pause() {
        pause("Press <Enter> to continue... ");
    }

    // display related methods --------------------------------------------------

    // prints a specified character N times
    public static void spacer(char ch, int num) {
        // print specified char N times
        for (int i=0; i<num; i++) {
            System.out.print(ch);
        }
        System.out.println();
    }
    
    // prints a default character N times
    public static void spacer(int num) {
        final char SEP_CHAR = '=';   // default separator character
        
        // overloaded call to the other version
        spacer(SEP_CHAR, num);
    }
    
    // prints a default spacer, = x40 wide
    public static void spacer() {
        final char SEP_CHAR = '=';   // default separator character
        final int SEP_NUM = 40;      // default separator width
        
        // overloaded call to the other version
        spacer(SEP_CHAR, SEP_NUM);
    }
    
    //------------------------------------------------------------------
       
    // print a message with or without surrounding bounding box
    public static void message(String msg, boolean box) {
        // print message w/o boxing
        if (!box) {
            System.out.println(msg);
        }
        
        // prints message WITH boxing, using length of desired message
        else {
            spacer('=', msg.length());
            System.out.println(msg);
            spacer('=', msg.length());
        }
    }
    
    //------------------------------------------------------------------
    
    // print one blank line
    public static void blank() {
        System.out.println();
    }
    
    // overloaded version, prints N blank lines
    public static void blank(int num) {
        for (int i=1; i<=num; i++) {
            blank();
        }
    }

}