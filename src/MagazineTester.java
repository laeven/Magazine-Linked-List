/**
 * Created by Oscar Duarte on 2/2/16.
 * CE 3345
 */

import java.util.Scanner;

public class MagazineTester {

    /*
    Some static variables used throughout the program
     */
    static int intIn;
    static MagazineList list;

    /**
     * Main function, runs the menu and allows creation and alteration of MagazineList
     * @param args not used
     */
    public static void main(String args[]){

        //List is initialized empty
        list = new MagazineList();

        /**
         * Initial display of menu,
         * @done Boolean variable used to keep menu going for multiple options
         */
        displayMenu();
        boolean done = false;

        while(!done) {
            /**
             * Switch case used to interpret input for menu choices
             * Magazine m, int id, and String output are used throughout the switch so that
             * they are not continually declared and one doesnt have to use too many variables.
             */
            Magazine m;
            int id;
            String output;
            switch (intIn) {
                //Case 1, make list empty
                case 1:
                    list.makeEmpty();
                    break;
                //Case 2, search for an ID, the input is verified and null is printed out if magazine is null
                case 2:
                    id = inputID();
                    try {
                        System.out.println(list.findID(id).print());
                    }
                    catch(NullPointerException e){
                        System.out.println("Null\n");
                    }
                    break;
                //Case 3, creates a magazine.
                case 3:
                    m = createMag();
                    output = list.insertAtFront(m) ? "...\nMagazine Added" : "Magazine ID already exists";
                    System.out.println(output + "\n");
                    break;
                //Case 4, deletes from front
                case 4:
                    m = list.deleteFromFront();
                    output = m != null ? m.print() : "Null\n";
                    System.out.println(output);
                    break;
                //Case 5, deletes magazine based on id, if does not exists user is told.
                case 5:
                    id = inputID();
                    output = list.delete(id) ? "Magazine with this ID was deleted.\n" : "Magazine with this ID does not exist.\n";
                    System.out.println(output);
                    break;
                //Case 6, prints out searched magazine, prints null if not found.
                case 6:
                    id = inputID();
                    m = list.findID(id);
                    if(m == null){
                        System.out.println("Null\n");
                    }
                    else
                    System.out.println(m.print());
                    break;
                //Case 7, prints all records in order of list.
                case 7:
                    list.printAllRecords();
                    break;
                //Case 8, closes program
                case 8:
                    System.out.println("Done");
                    done = true;
            }
            //Repeated menu that prompts input
            displayMenu();
        }
        /**
         * Scanner is closed after input is done.
         */
    }

    /**
     * checkInt verifies that input for menu is both an integer, as well as
     * in the given range. Try catch and if statement cause repeated attempts
     * by returning false.
     * @param in the input in string format
     * @return returns whether it is valid input or not
     */
    public static boolean checkInt(String in){
        try{
           intIn = Integer.parseInt(in);
        }
        catch(NumberFormatException e){
            System.out.print("Please enter a valid choice: ");
            return false;
        }
        if(intIn <1 || intIn >8){
            System.out.print("Please enter a valid choice: ");
            return false;
        }
        return true;
    }

    /**
     * inputID takes an input and transforms it into an integer.
     * Used in order to catch any problems (such as user putting in
     * a string/character)
     * @return returns the integer in int form
     */
    public static int inputID(){
        Scanner in = new Scanner(System.in);
        int id = -1;
        boolean done = false;

        System.out.print("ID No: ");
        while(!done) {
            try {
                done = true;
                id = Integer.parseInt(in.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Please input a number: ");
                done = false;
            }
        }
        return id;
    }

    /**
     * createMag is used to get input from user for a magazine and create a
     * magazine object that can be added to the list. Also verifies proper
     * input.
     * @return the magazine object created from user input
     */

    public static Magazine createMag(){
        Magazine m;
        Scanner in = new Scanner(System.in);
        String magName;
        int magID;
        String pubName;

        System.out.print("Please input the magazine ID: ");

        //Checks whether it can be a number or not
        while(true) {
            try {
                magID = Integer.parseInt(in.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.print("Please input a number: ");
            }
        }

        System.out.print("Please input the magazine name: ");
        magName = in.nextLine();

        System.out.print("Please input the publisher name: ");
        pubName = in.nextLine();
        m = new Magazine(magID, magName, pubName);
        return m;
    }

    /**
     * getInput prompts user for an input used for the menu
     */

    public static void getInput(){
        System.out.print("Your choice: ");
        Scanner in = new Scanner(System.in);

        String input = in.nextLine();

        boolean cont = false;
        while(!cont) {
            cont = true;
            while (!checkInt(input)) {
                input = in.nextLine();
            }
        }
    }

    /**
     * display menu prints out the main menu then prompts user for input
     */

    public static void displayMenu(){
        System.out.println("Operations on List");
        System.out.println("1. Make Empty");
        System.out.println("2. Find ID");
        System.out.println("3. Insert at Front");
        System.out.println("4. Delete From Front");
        System.out.println("5. Delete ID");
        System.out.println("6. Print ID");
        System.out.println("7. Print All Records");
        System.out.println("8. Done\n");
        getInput();
    }
}
