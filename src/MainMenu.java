/**
 * REFERENCES
 * https://www.youtube.com/watch?v=ntirmRhy6Fw
 * https://github.com/Nadeeja99/Premier-League-Championship/tree/main/src
 * https://github.com/Chamithsulakkana13/PremierLeagueManager_java
 * https://howtodoinjava.com/java/collections/arraylist/serialize-deserialize-arraylist/
 * https://stackoverflow.com/questions/26953460/75-probability-in-java
 * https://docs.oracle.com/javase/tutorial/uiswing/components/table.html#sorting
 * https://www.javatpoint.com/
 * https://www.quora.com/How-do-I-generate-random-numbers-between-0-and-10-with-no-repeat-any-value-in-java
 * https://stackoverflow.com/questions/64193070/java-random-percentage-chance
 * https://stackoverflow.com/questions/17272045/swing-jtable-sort-by-date
 * https://github.com/vladmusuz/PremierLeague/tree/dev/src
 * https://www.codegrepper.com/code-examples/java/use+for+loop+to+get+values+from+a+arraylist+in+java
 * https://www.educative.io/courses/learn-object-oriented-programming-in-java
 * https://docs.oracle.com/javase/7/docs/api/javax/swing/JTextField.html
 * https://stackoverflow.com/questions/65162271/outputting-content-from-jtable-onto-textarea-using-java-swing
 * https://stackoverflow.com/questions/32101688/illegalargumentexception-bound-must-be-positive
 * https://www.baeldung.com/a-guide-to-java-enums
 */



import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;


public class MainMenu implements Serializable {
    //main menu class

    public static void main(String[] args) {

        //specify paths of files
        Path path1= Paths.get("./Formula1_Information.ser");
        Path path2= Paths.get("./Race_Information.ser");

        Formula1ChampionshipManager driversManager = new Formula1ChampionshipManager();

        if (Files.exists(path1)){
            //check for first file
            driversManager.getFromFile();

        }else if(Files.exists(path2)){
            //check for second file
            driversManager.getFromFile();

        }
        else{
            driversManager=new Formula1ChampionshipManager();
        }

        boolean menuLoop = true;
        //menu loop option

        while (menuLoop) {
            driversManager.userMenu();
            //get menu from class Formula1ChampionshipManager

            System.out.println("Please enter your choice according to the choices given above:");
            Scanner input = new Scanner(System.in);
            while(!input.hasNextInt()){
                //check if input is available

                System.out.println("Please enter a valid number:");
                input.next();
            }
            int userInput=input.nextInt();
            //get user input

            switch (userInput) {
                case 1:
                    //add
                    System.out.println(".....1 - Add a new Formula 1 driver.....");
                    System.out.println(" ");
                    driversManager.addDriver();
                    driversManager.saveToFile();
                    break;

                case 2:
                    //delete driver
                    System.out.println(".....2 - Delete a player from the team.....");
                    System.out.println(" ");
                    driversManager.deleteDriver();
                    driversManager.saveToFile();
                    break;

                case 3:
                    //change driver
                    System.out.println(".....3 - Change a driver.....");
                    System.out.println(" ");
                    driversManager.changeDriver();
                    driversManager.saveToFile();
                    break;

                case 4:
                    //display statistics
                    System.out.println(".....4 - Display statistics of a driver.....");
                    System.out.println(" ");
                    driversManager.displayStatistics();
                    break;

                case 5:
                    //display table
                    System.out.println(".....5 - Display the Formula 1 Driver Table.....");
                    System.out.println(" ");
                    driversManager.displayFormula1DriverTable();
                    break;

                case 6:
                    //add completed race
                    System.out.println(".....6 - Add a race completed.....");
                    System.out.println(" ");
                    driversManager.addCompletedRace();
                    //driversManager.saveToFile();
                    break;

                case 7:
                    //open gui
                    System.out.println(".....7 - Open User Interface [GUI].....");
                    GUIClass gui= new GUIClass(driversManager.getChampionshipDrivers(), driversManager.getRacePositions());
                    driversManager.saveToFile();
                    break;

                case 8:
                    //exit the system
                    System.out.println(".....8 - Exit the system.....");
                    break;

                default:
                    System.out.println("Please enter the correct input");
                    break;
            }

            System.out.println("Would you like to return back to the menu selection(Yes/No):");
            boolean checkInput = true;

            while (checkInput) {
                //loop to check the input

                Scanner newInput = new Scanner(System.in);
                String selection = newInput.nextLine();
                //user selection

                if (selection.equalsIgnoreCase("Yes")) {
                    menuLoop = true;
                    checkInput = false;
                }
                //condition which will access the menu selection again

                else if (selection.equalsIgnoreCase("No")) {
                    menuLoop = false;
                    checkInput = false;
                }
                //condition which will stop the program

                else if ((!selection.equalsIgnoreCase("Yes")) || (!selection.equalsIgnoreCase("No"))) {
                    System.out.println("Unknown input. Would you like to return back to the menu selection(Yes/No):");
                    menuLoop = false;
                    checkInput = true;

                }
                //condition to check for invalid inputs and run the loop once again
            }
        }
    }
}
