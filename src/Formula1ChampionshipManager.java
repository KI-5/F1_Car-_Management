import java.io.*;
import java.util.*;

    public class Formula1ChampionshipManager implements ChampionshipManager,Serializable{
        /**
         * manager class to implement all methods
         * add a driver
         * delete a driver
         * change a driver
         * display statistics
         * display table
         * save to file
         * load from file
         * **/

        private ArrayList<Formula1Driver> championshipDrivers = new ArrayList<Formula1Driver>();
        //initialise arraylist of Formula1Driver class objects

        private ArrayList<RaceCompleted> racePositions= new ArrayList<RaceCompleted>();
        //initialise arraylist of RaceCompleted class objects



        public ArrayList<Formula1Driver> getChampionshipDrivers() {
            //getter for the drivers arraylist
            return championshipDrivers;
        }
        public ArrayList<RaceCompleted> getRacePositions(){
            //getter for the races completed arraylist
            return racePositions;
        }

        public static void userMenu() {
            //Menu for the user

            System.out.println("......................................");
            System.out.println(" ");
            System.out.println("-----------FORMULA 1 CHAMPIONSHIP MANAGER-----------");
            System.out.println(" ");
            System.out.println(" 1 - Add a new Formula 1 driver ");
            System.out.println(" 2 - Delete a player from the team ");
            System.out.println(" 3 - Change a driver ");
            System.out.println(" 4 - Display statistics of a driver ");
            System.out.println(" 5 - Display the Formula 1 Driver Table ");
            System.out.println(" 6 - Add a race completed ");
            System.out.println(" 7 - Open the GUI ");
            System.out.println(" 8 - Quit ");
            System.out.println("......................................");
        }

        /**
         * @addDriver add a driver to the system
         */
        @Override
        public void addDriver() {

                Formula1Driver formula1Driver= new Formula1Driver();
                //instantiate the object


                System.out.print("Enter the driver's name: ");
                Scanner name = new Scanner(System.in);
                while (!name.hasNext()){
                    //check input

                    System.out.println("Enter a name");
                    name.next();
                }
                String driverName = name.next();
                //name input

                formula1Driver.setDriverName(driverName);
                //set name

                System.out.print("Enter location: ");
                Scanner location = new Scanner(System.in);
                while (!location.hasNext()){
                    //check input

                    System.out.println("Enter a location");
                    name.next();
                }
                String locationName = location.next();
                //location input

                formula1Driver.setLocation(locationName);
                //set location

                System.out.print("Enter the name of the team: ");
                Scanner team = new Scanner(System.in);
                while (!team.hasNext()){
                    //check input

                    System.out.println("Enter a team name");
                    team.next();
                }
                String teamName = team.next();
                //team name input

                formula1Driver.setTeamName(teamName);
                //set team name

                championshipDrivers.add(formula1Driver);
                //add driver

        }

        /**
         * @deleteDriver delete a driver from the system
         */
        @Override
        public void deleteDriver() {

            if (championshipDrivers.size() > 0) {
                //check if there are drivers


                System.out.print("Enter the name of the driver to be deleted: ");
                Scanner userInput = new Scanner(System.in);
                while (!userInput.hasNext()) {
                    //check input

                    System.out.println("Please enter a valid input:");
                    userInput.next();
                }
                String driverName = userInput.nextLine();

                int check = 1;
                //check the list

                for (Formula1Driver driver : championshipDrivers) {
                    //loop through drivers arraylist
                    if (driver.getDriverName().equalsIgnoreCase(driverName)) {
                        //check name

                        championshipDrivers.remove(driver);
                        //delete driver

                        System.out.println("Formula1 Driver " + driver.getDriverName() + " has been deleted successfully");

                        check = 0;
                        break;
                    }
                }

                if (check == 1) {
                    //if not a match
                    System.out.println("There is no such driver");
                }

            } else{
                //in case there are no drivers

                System.out.println("No drivers in our records");
            }

        }

        /**
         * @changeDriver change a driver in the system
         */
        @Override
        public void changeDriver() {
            if (championshipDrivers.size()>0) {
                System.out.println("Enter the name of the driver whom you want change: ");
                Scanner driverName = new Scanner(System.in);
                while (!driverName.hasNext()) {
                    //check input

                    System.out.println("Please enter a valid input:");
                    driverName.next();
                }
                String updateName = driverName.nextLine();

                System.out.print("Enter the new driver's name: ");
                Scanner newName = new Scanner(System.in);
                while (!newName.hasNext()) {
                    //check input

                    System.out.println("Please enter a valid input:");
                    newName.next();
                }
                String newDriverName = newName.nextLine();

                System.out.print("Enter location: ");
                Scanner newLocation = new Scanner(System.in);
                String newLocationName = newLocation.nextLine();

                int check = 1;
                //check the list

                for (Formula1Driver driver : championshipDrivers) {
                    //iterate through arraylist

                    if (driver.getDriverName().equalsIgnoreCase(updateName)) {
                        //checks if the name exists

                        driver.setDriverName(newDriverName);
                        driver.setLocation(newLocationName);
                        driver.setNoOfPoints(0);
                        driver.setNoOfRacesParticipated(0);
                        driver.setFirstPositions(0);
                        driver.setSecondPositions(0);
                        driver.setThirdPositions(0);
                        driver.setFourthPositions(0);
                        driver.setFifthPositions(0);
                        driver.setSixthPositions(0);
                        driver.setSeventhPositions(0);
                        driver.setEightPositions(0);
                        driver.setNinthPositions(0);
                        driver.setTenthPositions(0);
                        //reset all the values

                        check = 0;
                        break;
                    }
                }
                if (check == 1) {
                    //if not a match

                    System.out.println("There is no such driver");
                }

            }else{
                //in case there are no drivers

                System.out.println("No drivers in our records");
            }

        }

        /**
         * @displayStatistics display statistics for the corresponding name given by the user
         */
        @Override
        public void displayStatistics() {

            if(championshipDrivers.size()>0) {
                System.out.print("Enter the name of the driver whose statistics you want to view: ");
                Scanner userInput = new Scanner(System.in);
                while (!userInput.hasNext()) {
                    //check input

                    System.out.println("Please enter a valid input:");
                    userInput.next();
                }
                String driverName = userInput.nextLine();

                for (Formula1Driver driver : championshipDrivers) {
                    //iterate through arraylist

                    if (driver.getDriverName().equalsIgnoreCase(driverName)) {
                        //checks for the driver name

                        System.out.println("Name: " + driver.getDriverName() + ", Location: " + driver.getLocation() + ", Team name:" + driver.getTeamName());
                        System.out.println("Total points scored: " + driver.getNoOfPoints());
                        System.out.println("Total number of races participated in: " + driver.getNoOfRacesParticipated());
                        System.out.println("Number of first positions won: " + driver.getFirstPositions());
                        System.out.println("Number of second positions won: " + driver.getSecondPositions());
                        System.out.println("Number of third positions won: " + driver.getThirdPositions());
                        System.out.println("Positions below third" + driver.getFourthPositions() + driver.getFifthPositions() + driver.getSixthPositions() + driver.getSeventhPositions() + driver.getEighthPositions() + driver.getNinthPositions() + driver.getTenthPositions());
                        break;

                    } else {

                        System.out.println("Sorry there is no such driver in the system");
                    }

                }
            }else{
                //in case there are no drivers

                System.out.println("No drivers in our records");
            }
        }


        /**
         * method to display the driver table in descending order of their points and based on the number of first positions
         */
        @Override
        public void displayFormula1DriverTable() {

            if (championshipDrivers.size()>0) {

                Collections.sort(championshipDrivers, new PositionsComparator());
                //using the comparator

                System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s\n", "Name of the Driver", "Location", "Team Name", "Total Points", "Matches Participated", "First Positions", "Second Positions", "Third Positions", "Below Third");
                for (Formula1Driver driver : championshipDrivers) {
                    //iterate through arraylist

                    System.out.printf("%-20s%-20s%-20s%-20d%-20d%-20d%-20d%-20d%-20d\n", driver.getDriverName(), driver.getLocation(), driver.getTeamName(), driver.getNoOfPoints(), driver.getNoOfRacesParticipated(), driver.getFirstPositions(), driver.getSecondPositions(), driver.getThirdPositions(), driver.getFourthPositions() + driver.getFifthPositions() + driver.getSixthPositions() + driver.getSeventhPositions() + driver.getEighthPositions() + driver.getNinthPositions() + driver.getTenthPositions());
                }
            }else{
                System.out.println("No drivers in our records");
            }
        }


        /**
         * @addCompletedRace method to add a completed race and update the drivers' statistics
         * @throws InputMismatchException throws error
         */
        @Override
        public void addCompletedRace() throws InputMismatchException {

            if (championshipDrivers.size()>0) {
                System.out.println("------ENTER THE DATE OF THE RACE------");
                System.out.println("");
                System.out.println("Enter the year:");
                Scanner year = new Scanner(System.in);

                while (!year.hasNext()) {
                    //check input

                    System.out.println("Please enter a valid input:");
                    year.next();
                }
                String raceYear = year.next();

                System.out.println("Enter the month");
                Scanner month = new Scanner(System.in);

                while (!month.hasNext()) {
                    //checks input

                    System.out.println("Please enter a valid input:");
                    month.next();
                }
                String raceMonth = month.next();

                System.out.println("Enter the day");
                Scanner day = new Scanner(System.in);

                while (!day.hasNext()) {
                    //checks input

                    System.out.println("Please enter a valid input:");
                    day.next();
                }
                String raceDay = day.next();

                System.out.println("------ENTER THE NAMES OF THE 10 DRIVERS------");
                System.out.println("");

                System.out.println("Enter the driver in first position:");
                Scanner first = new Scanner(System.in);
                while (!first.hasNext()) {
                    //checks input

                    System.out.println("Please enter an input:");
                    first.next();
                }
                String firstPosition = first.nextLine();
                System.out.println("Enter the driver in second position:");
                Scanner second = new Scanner(System.in);
                while (!second.hasNext()) {
                    //checks input

                    System.out.println("Please enter an input:");
                    second.next();
                }
                String secondPosition = second.nextLine();
                System.out.println("Enter the driver in third position:");
                Scanner third = new Scanner(System.in);
                while (!third.hasNext()) {
                    //checks input

                    System.out.println("Please enter an input:");
                    third.next();
                }
                String thirdPosition = third.nextLine();
                System.out.println("Enter the driver in fourth position:");
                Scanner fourth = new Scanner(System.in);
                while (!fourth.hasNext()) {
                    //checks input

                    System.out.println("Please enter an input:");
                    fourth.next();
                }
                String fourthPosition = fourth.nextLine();
                System.out.println("Enter the driver in fifth position:");
                Scanner fifth = new Scanner(System.in);
                while (!fifth.hasNext()) {
                    //checks input

                    System.out.println("Please enter an input:");
                    fifth.next();
                }
                String fifthPosition = fifth.nextLine();
                System.out.println("Enter the driver in sixth position:");
                Scanner sixth = new Scanner(System.in);
                while (!sixth.hasNext()) {
                    //checks input

                    System.out.println("Please enter an input:");
                    sixth.next();
                }
                String sixthPosition = sixth.nextLine();
                System.out.println("Enter the driver in seventh position:");
                Scanner seventh = new Scanner(System.in);
                while (!seventh.hasNext()) {
                    //checks input

                    System.out.println("Please enter an input:");
                    seventh.next();
                }
                String seventhPosition = seventh.nextLine();
                System.out.println("Enter the driver in eighth position:");
                Scanner eighth = new Scanner(System.in);
                while (!eighth.hasNext()) {
                    //checks input

                    System.out.println("Please enter an input:");
                    eighth.next();
                }
                String eighthPosition = eighth.nextLine();
                System.out.println("Enter the driver in ninth position:");
                Scanner ninth = new Scanner(System.in);
                while (!ninth.hasNext()) {
                    //checks input

                    System.out.println("Please enter an input:");
                    ninth.next();
                }
                String ninthPosition = ninth.nextLine();
                System.out.println("Enter the driver in tenth position:");
                Scanner tenth = new Scanner(System.in);
                while (!tenth.hasNext()) {
                    //checks input

                    System.out.println("Please enter an input:");
                    tenth.next();
                }
                String tenthPosition = tenth.nextLine();


                Formula1Driver driver1, driver2, driver3, driver4, driver5, driver6, driver7, driver8, driver9, driver10;
                driver1 = driver2 = driver3 = driver4 = driver5 = driver6 = driver7 = driver8 = driver9 = driver10 = null;
                //instantiate Formula1Driver class objects for each position

                for (Formula1Driver driver : championshipDrivers) {

                    if (driver.getDriverName().equalsIgnoreCase(firstPosition)) {
                        driver1 = driver;
                        driver1.firstCalc(driver1);
                        //update details of first position

                    } else if (driver.getDriverName().equalsIgnoreCase(secondPosition)) {
                        driver2 = driver;
                        driver2.secondCalc(driver2);
                        //update details of second position

                    } else if (driver.getDriverName().equalsIgnoreCase(thirdPosition)) {
                        driver3 = driver;
                        driver3.thirdCalc(driver3);
                        //update details of third position

                    } else if (driver.getDriverName().equalsIgnoreCase(fourthPosition)) {
                        driver4 = driver;
                        driver4.fourthCalc(driver4);
                        //update details of fourth position

                    } else if (driver.getDriverName().equalsIgnoreCase(fifthPosition)) {
                        driver5 = driver;
                        driver5.fifthCalc(driver5);
                        //update details of fifth position

                    } else if (driver.getDriverName().equalsIgnoreCase(sixthPosition)) {
                        driver6 = driver;
                        driver6.sixthCalc(driver6);
                        //update details of sixth position

                    } else if (driver.getDriverName().equalsIgnoreCase(seventhPosition)) {
                        driver7 = driver;
                        driver7.seventhCalc(driver7);
                        //update details of seventh position

                    } else if (driver.getDriverName().equalsIgnoreCase(eighthPosition)) {
                        driver8 = driver;
                        driver8.eighthCalc(driver8);
                        //update details of eighth position

                    } else if (driver.getDriverName().equalsIgnoreCase(ninthPosition)) {
                        driver9 = driver;
                        driver9.ninthCalc(driver9);
                        //update details of ninth position

                    } else if (driver.getDriverName().equalsIgnoreCase(tenthPosition)) {
                        driver10 = driver;
                        driver10.tenthCalc(driver10);
                        //update details of tenth position

                    }

                }
                String raceDate = raceYear + "/" + raceMonth + "/" + raceDay;
                //date string

                RaceCompleted race = new RaceCompleted(driver1, driver2, driver3, driver4, driver5, driver6, driver7, driver8, driver9, driver10, raceDate);
                //instantiate RaceCompleted object
                racePositions.add(race);
                //add to racePositions arraylist

            }else{
                //in case there are no drivers

                System.out.println("No drivers in our records");
            }
        }


        /**
         * @saveToFile save to a file
         */
        @Override
        public void saveToFile() {


            try{
                //save information about the drivers

                FileOutputStream file1 = new FileOutputStream("Formula1_Information.ser");
                ObjectOutputStream output1 = new ObjectOutputStream(file1);
                output1.writeObject(championshipDrivers);
                output1.close();
                file1.close();

                //save information about the races

                FileOutputStream file2 = new FileOutputStream("Race_Information.ser");
                ObjectOutputStream output2 = new ObjectOutputStream(file2);
                output2.writeObject(racePositions);
                output2.close();
                file2.close();


            }catch (FileNotFoundException f) {
                //missing file
                System.out.println("File not Found");

            }catch(Exception e){

                e.printStackTrace();
            }
        }

        /**
         * @getFromFile get information
         */
        @Override
        public void getFromFile(){



            try{
                //get drivers information
                FileInputStream file1= new FileInputStream ("Formula1_Information.ser");
                ObjectInputStream input1 = new ObjectInputStream(file1);
                championshipDrivers= (ArrayList<Formula1Driver>)input1.readObject();

                input1.close();
                file1.close();

                //get race information
                FileInputStream file2= new FileInputStream ("Race_Information.ser");
                ObjectInputStream input2 = new ObjectInputStream(file2);
                racePositions=(ArrayList<RaceCompleted>)input2.readObject();

                input2.close();
                file2.close();

            }catch (IOException ex){
                ex.printStackTrace();

            }catch (ClassNotFoundException c){
                System.out.println("File not found");
                c.printStackTrace();
            }

        }






}
