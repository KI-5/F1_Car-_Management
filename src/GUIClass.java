import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class GUIClass extends JFrame implements ActionListener, Serializable {

    private final ArrayList<Formula1Driver> drivers;
    //arraylist of drivers

    private final ArrayList<RaceCompleted> races;
    //arraylist of races

    private static final long serialVersionUID = 1L;

    /**
     * @TABLEMODELS
     */
    DefaultTableModel raceModel;
    //table model of drivers table

    DefaultTableModel completedModel;
    //table model of races table


    /**
     * @TABLES
     */
    JTable tblDriver;
    //table of drivers

    JTable tblCompleted;
    //table of races

    /**
     * @BUTTONS
     */
    private DefineButtons bnSortPoints;
    //button to sort based on points

    private DefineButtons bnFirstWins;
    //button to sort based on first wins

    private DefineButtons bnDate;
    //button to sort based on date

    private DefineButtons bnRandomRace;
    //button to create a random race

    private DefineButtons bnProbability;
    //button to create a race based on probability

    private DefineButtons bnSearch;
    //search button

    /**
     * @LABELS
     */
    private JLabel lbSort;
    private JLabel lbFirst;
    private JLabel lbDate;
    private JLabel lbRandom;
    private JLabel lbProbability;
    private JLabel lbSearch;

    /**
     * @CONTAINER
     */
    private Container main;

    private ImageIcon image;

    private Formula1ChampionshipManager driversManager;

    /**
     *
     * @SortUsing provides 4 types of sort options based on the buttons clicked
     * to sort points in descending order
     * to sort points in ascending order
     * to sort points based on first positions
     * to sort points based on the date of the races
     *
     */
    private enum SortUsing {
        POINTS, ASCENDING_POINTS, FIRSTS, DATE_CREATED
    }

    /**
     * @CONSTRUCTOR
     * @param drivers arraylist of drivers
     * @param races arraylist of races
     */
    public GUIClass(ArrayList<Formula1Driver> drivers,ArrayList<RaceCompleted> races){


        Path path1= Paths.get("./Formula1_Information.ser");
        Path path2= Paths.get("./Race_Information.ser");
        //get file information

        driversManager = new Formula1ChampionshipManager();

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



        this.drivers=drivers;
        //assign drivers to local variable

        this.races=races;
        //assign races to local variable

        this.sortTable(SortUsing.POINTS);
        //sort the table from the beginning

        this.basicLayout();
        //set up the basic properties

        this.main=this.getContentPane();
        //assign main

        this.main.setLayout(new BorderLayout(8,8));
        //set the BorderLayout

        this.fillTable();
        //set up the drivers table

        this.driverScroll();
        //set up the scroll pane of the drivers table

        this.playedRace();
        //set up the races table

        this.completeScroll();
        //set up the scroll pane of the races table

        this.baseLayout();
        //set up the base layout

        this.imageSetUp();
        //set up the image

        this.guiButtons("Sort by Points","Sort by Firsts","Sort races","Create Random","Probability random","Search");
        //set up the buttons

        this.buttonsLabels();
        //set up the labels

        this.pack();
        //pack the whole gui

    }

    /**
     * @basicLayout set up visible basic layout
     */
    public void basicLayout() {

        this.setTitle("Formula 1 Championship League");
        //title of the gui

        this.setLayout(null);

        this.getContentPane().setBackground(new Color(0x020706));
        //set background colour

        this.setBounds(100, 100, 1300, 700);
        //size of the gui

        this.setVisible(true);
        //visible

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //not terminate the whole program completely

    }

    /**
     * @fillTable method to fill the drivers table at the start
     */
    public void fillTable(){

        String[] heading = {"Driver", "Location", "Team", "Points","Races", "First", "Second", "Third","Below"};
        //column headings

        this.raceModel=new DefaultTableModel(heading,0);
        //model of the driver table

        for (Formula1Driver driver : this.drivers) {
            //loop through all the drivers

            String driverName = driver.getDriverName();
            //drivers' name

            String location = driver.getLocation();
            //drivers' location

            String teamName = driver.getTeamName();
            //drivers' team

            int points = driver.getNoOfPoints();
            //total number of points

            int races = driver.getNoOfRacesParticipated();
            //races participated in

            int firstP = driver.getFirstPositions();
            //number of first positions

            int secondP = driver.getSecondPositions();
            //number of second positions

            int thirdP = driver.getThirdPositions();
            //number of third positions

            int below = driver.getFourthPositions() + driver.getFifthPositions() + driver.getSixthPositions() + driver.getSeventhPositions() + driver.getEighthPositions() + driver.getNinthPositions() + driver.getTenthPositions();
            //number of positions below third place

            Object[] rows = {driverName, location, teamName, points, races, firstP, secondP, thirdP, below};

            raceModel.addRow(rows);
            //add rows to the table model

        }
        tblDriver=new JTable(raceModel);
        //assign model to the table
    }

    /**
     * @matchScroll method to add the table to the scroll pane
     */

    public void driverScroll()  {

        JScrollPane scroll=new JScrollPane(tblDriver);
        //new scroll pane

        JLabel heading=new JLabel("Drivers");
        //heading

        heading.setForeground(new Color(0xffffff));
        //set text colour

        scroll.setBounds(0, 0, 250, 400);
        //set size of the scroll pane

        JPanel plleft = new JPanel();
        //new panel

        plleft.setBackground(new Color(0x465855));
        //set background colour of the panel

        plleft.setBounds(0, 0, 250, 400);
        //set size of the panel

        plleft.setLayout(new FlowLayout());
        //set flow layout

        plleft.add(heading);
        plleft.add(scroll);
        //add scroll pane to panel

        this.main.add(plleft,BorderLayout.WEST);
        //assign scroll pane to the west

    }


    /**
     * @playedRace method to fill in the races played table
     */
    public void playedRace(){

        String[] heading={"Date","First","Second","Third"};
        //column headings

        this.completedModel=new DefaultTableModel(heading,0);
        //connect to the default table model

        for (RaceCompleted race : races) {

            String date = race.getRaceDate();
            //get the date of the match

            String first = race.getFirst().getDriverName();
            //get name of the driver in first place

            String second = race.getSecond().getDriverName();
            //get name of the driver in second place

            String third = race.getThird().getDriverName();
            //get name of the driver in third place

            Object[] rows = {date, first, second, third};
            //add rows to the table

            completedModel.addRow(rows);

        }
        tblCompleted=new JTable(completedModel);
        //add the default table to the table

    }

    /**
     * @completeScroll method of the scroll pane of the races table
     */
    public void completeScroll(){

        JScrollPane scroll = new JScrollPane(tblCompleted);
        //add table to scroll pane

        scroll.setBounds(0, 0, 250, 400);
        //set size of the scroll pane

        JLabel heading=new JLabel("Matches");
        //heading

        heading.setForeground(new Color(0xffffff));
        //set colour

        JPanel plright = new JPanel();
        //new panel

        plright.setBounds(0,0,250,400);
        //set size of the panel

        plright.setBackground(new Color(0x446561));
        //set background colour of the panel

        plright.setLayout(new FlowLayout());
        //set flow layout



        plright.add(scroll);
        //add scroll pane to panel

        plright.add(heading);

        this.main.add(plright, BorderLayout.EAST);
        //add to the east

    }


    /**
     * @buttonsLabels set up the buttons and labels
     */
    public void buttonsLabels() {

        JPanel plUp = new JPanel();
        //upper panel

        plUp.setBackground(new Color(0x465855));
        //upper panel background

        lbSort.setForeground(new Color(0xFFFFFF));
        //sort label text colour

        lbFirst.setForeground(new Color(0xFFFFFF));
        //sort first wins label text colour

        lbDate.setForeground(new Color(0xFFFFFF));
        //sort by date label text colour

        lbRandom.setForeground(new Color(0xFFFFFF));
        //create random match label text colour

        plUp.setLayout(new FlowLayout(FlowLayout.CENTER));
        //set up layout

        plUp.add(this.lbSort);
        plUp.add(this.bnSortPoints);
        plUp.add(this.lbFirst);
        plUp.add(this.bnFirstWins);
        plUp.add(this.lbDate);
        plUp.add(this.bnDate);
        plUp.add(this.lbRandom);
        plUp.add(this.bnRandomRace);
        //add everything to the upper panel

        this.main.add(plUp, BorderLayout.NORTH);
        // add to the container at the top

        JPanel plDown = new JPanel();
        //lower panel

        plDown.setBackground(new Color(0x465855));
        //lower panel background

        lbProbability.setForeground(new Color(0xFFFFFF));
        //random probability match label text colour

        lbSearch.setForeground(new Color(0xFFFFFF));
        //search label text colour

        plDown.setLayout(new FlowLayout(FlowLayout.CENTER));
        //set up layout

        plDown.add(this.lbProbability);
        plDown.add(this.bnProbability);
        plDown.add(this.lbSearch);
        plDown.add(this.bnSearch);
        //add everything to the lower panel

        this.main.add(plDown, BorderLayout.SOUTH);
        // add to the container at the bottom

    }

    /**
     * @baseLayout set up base layout for the labels
     */
    public void baseLayout() {

        this.lbSort = new JLabel("Sort points in ascending order: ");
        //sort label

        this.lbFirst = new JLabel("Sort first positions- ");
        //sort by firsts label

        this.lbDate=new JLabel("Sort races using dates- ");
        //sort by date label

        this.lbRandom = new JLabel("Generate random race- ");
        //generate random race label

        this.lbProbability=new JLabel("Generate random race based on starting points- ");
        //generate random match based on starting positions label

        this.lbSearch = new JLabel("Search played games by name- ");
        //search label

    }


    /**
     * @imageSetUp method to set up logo
     */
    public void imageSetUp(){

        try{

            image=new ImageIcon(getClass().getResource("f1.png"));
            //new image icon with image path

            JLabel lbCenter=new JLabel(image);
            //attach image to label

            this.main.add(lbCenter,BorderLayout.CENTER);
            //set to the center of the gui

        }catch (Exception e){
            //catch in image isn't available

            e.printStackTrace();
        }
    }


    /**
     * @guiButtons method to set up buttons
     * @param points sort in ascending order
     * @param firsts sort in descending order
     * @param date sort in ascending order
     * @param random generate random match
     * @param probability random match based on starting positions
     * @param search search for stats
     */
    public void guiButtons(String points, String firsts,String date, String random, String probability,String search) {

        this.bnSortPoints = new DefineButtons(points,this);
        //points sort button

        this.bnFirstWins = new DefineButtons(firsts,this);
        //first wins buttons

        this.bnDate=new DefineButtons(date,this);
        //date sort button

        this.bnRandomRace = new DefineButtons(random,this);
        //random match button

        this.bnProbability= new DefineButtons(probability,this);
        //probability random match button

        this.bnSearch = new DefineButtons(search,this);
        //search button

    }


    /**
     * @sortTable Method to sort each part
     * Points in descending order
     * Points in ascending order
     * Sorting by first positions
     * sorting by date
     **/
    public void sortTable(SortUsing sort){

        switch(sort){

            case POINTS:
                //sort points in descending order

                Collections.sort(this.drivers,new PositionsComparator());
                if(this.tblDriver!=null || this.raceModel!=null){
                    this.loadIntoTable();
                }
                break;
            case ASCENDING_POINTS:
                //sort points in ascending order

                Collections.sort(this.drivers,new PositionsComparator().reversed());
                if(this.tblDriver!=null || this.raceModel!=null){
                    this.loadIntoTable();
                }
                break;
            case FIRSTS:
                //sort based on first positions in descending order

                Collections.sort(this.drivers, new FirstPositionComparator());
                if(this.tblDriver!=null || this.raceModel!=null){
                    this.loadIntoTable();
                }
                break;

            case DATE_CREATED:
                //sort based on the date in ascending order

                Collections.sort(this.races, new DateComparator());
                if(this.tblDriver!=null || this.raceModel!=null){
                    this.loadIntoRacesTable();
                }
                break;

            default:
                throw new IllegalArgumentException("Wrong");
        }
    }

    /**
     * @randomRace method to create a random match using random class
     */
    private void randomRace(){


        int size=this.drivers.size();
        //size of the arraylist

        ArrayList<Integer> position=new ArrayList<>(size);
        //position arraylist

        Formula1Driver first,second,third,fourth,fifth,sixth,seventh,eighth,ninth,tenth;

        first=second=third=fourth=fifth=sixth=seventh=eighth=ninth=tenth=null;
        //instantiate drivers

        for (int i = 1; i <= size; i++) {
            position.add(i);
        }
        Collections.shuffle(position);
        //add random positions

        for (int i = 0; i < size; i++){
            //iterate through drivers

            if (position.get(i)==1){
                first=drivers.get(i);
                first.firstCalc(first);
                //first driver

            }else if (position.get(i)==2){
                second=drivers.get(i);
                second.secondCalc(second);
                //second driver

            }else if (position.get(i)==3){
                third=drivers.get(i);
                third.thirdCalc(third);
                //third driver

            }else if (position.get(i)==4){
                fourth=drivers.get(i);
                fourth.fourthCalc(fourth);
                //fourth driver

            }else if (position.get(i)==5){
                fifth=drivers.get(i);
                fifth.fifthCalc(fifth);
                //fifth driver

            }else if (position.get(i)==6){
                sixth=drivers.get(i);
                sixth.sixthCalc(sixth);
                //sixth driver

            }else if (position.get(i)==7){
                seventh=drivers.get(i);
                seventh.seventhCalc(seventh);
                //seventh driver

            }else if (position.get(i)==8){
                eighth=drivers.get(i);
                eighth.eighthCalc(eighth);
                //eighth driver

            }else if (position.get(i)==9){
                ninth=drivers.get(i);
                ninth.ninthCalc(ninth);
                //ninth driver

            }else if(position.get(i)==10){
                tenth=drivers.get(i);
                tenth.tenthCalc(tenth);
                //tenth driver

            }
        }

        Random race= new Random();
        //random

        int minLimitDate=(int) LocalDate.of(2021, 1, 1).toEpochDay();
        //minimum limit for the date

        int maxLimitDate=(int) LocalDate.of(2021,12,31).toEpochDay();
        //maximum limit for the date

        long range=minLimitDate +race.nextInt(maxLimitDate-minLimitDate);
        LocalDate date=LocalDate.ofEpochDay(range);
        //race date

        RaceCompleted raceCompleted= new RaceCompleted(first,second,third,fourth,fifth,sixth,seventh,eighth,ninth,tenth,date);
        //instantiate races

        this.races.add(raceCompleted);
        //add to races arraylist

        this.loadIntoRacesTable();
        this.loadIntoTable();
        //load into both tables

        driversManager.saveToFile();


    }

    /**
     * @randomPercent create random match based on starting position
     */
    public void randomPercent(){

        int size= this.drivers.size();
        //size of driver arraylist

        ArrayList <Integer> startingPositionArray= new ArrayList<>(size);
        //starting position arraylist

        ArrayList<Integer> position=new ArrayList<>(size);
        //position arraylist

        for (int i = 1; i <= size; i++) {
            position.add(i);
        }
        Collections.shuffle(position);
        //random numbers for the position

        for (int i = 1; i <= size; i++) {
            startingPositionArray.add(i);
        }
        Collections.shuffle(startingPositionArray);
        //random positions for the start

        Random percentRandom =new Random();
        //random percent

        Formula1Driver first,second,third,fourth,fifth,sixth,seventh,eighth,ninth,tenth;
        first=second=third=fourth=fifth=sixth=seventh=eighth=ninth=tenth=null;
        //instantiate drivers

        for (int i=0;i<size;i++){
            //iterate through drivers arraylist

            if (position.get(i)==1) {
                //position 1

                if (startingPositionArray.get(i) == 1) {
                    //starting position 1

                    if (percentRandom.nextDouble() < 0.4) {
                        //percent 40%
                        first = drivers.get(i);
                        first.firstCalc(first);

                    }else if (percentRandom.nextDouble() < 1.0) {
                        first = drivers.get(i);
                        first.firstCalc(first);
                    }

                } else if (startingPositionArray.get(i) == 2) {
                    //starting position 2

                    if (percentRandom.nextDouble() < 0.3) {
                        //percent 30%
                        first = drivers.get(i);
                        first.firstCalc(first);

                    }else if (percentRandom.nextDouble() < 1.0) {
                        first = drivers.get(i);
                        first.firstCalc(first);
                    }

                } else if ((startingPositionArray.get(i) == 3) || (startingPositionArray.get(i) == 4)) {
                    //starting position 3 and 4

                    if (percentRandom.nextDouble() < 0.1) {
                        //percent 10%
                        first = drivers.get(i);
                        first.firstCalc(first);

                    }else if (percentRandom.nextDouble() < 1.0) {
                        first = drivers.get(i);
                        first.firstCalc(first);
                    }

                } else if ((startingPositionArray.get(i) > 4) && (startingPositionArray.get(i) < 10)) {
                    //starting position between 4 and 10

                    if (percentRandom.nextDouble() < 0.02) {
                        //percent 2%
                        first = drivers.get(i);
                        first.firstCalc(first);

                    }else if (percentRandom.nextDouble() < 1.0) {
                        first = drivers.get(i);
                        first.firstCalc(first);
                    }

                } else if (startingPositionArray.get(i) > 9) {
                    //starting position below 10
                    if (percentRandom.nextDouble() < 0.0) {
                        //percent 0%
                        first = drivers.get(i);
                        first.firstCalc(first);

                    }else if (percentRandom.nextDouble() <1.0) {
                        first = drivers.get(i);
                        first.firstCalc(first);
                    }
                }
            }if (position.get(i)==2){
                //position 2
                second=drivers.get(i);
                second.secondCalc(second);

            }else if (position.get(i)==3){
                //position 3
                third=drivers.get(i);
                third.thirdCalc(third);

            }else if (position.get(i)==4){
                //position 4
                fourth=drivers.get(i);
                fourth.fourthCalc(fourth);

            }else if (position.get(i)==5){
                //position 5
                fifth=drivers.get(i);
                fifth.fifthCalc(fifth);

            }else if (position.get(i)==6){
                //position 6
                sixth=drivers.get(i);
                sixth.sixthCalc(sixth);

            }else if (position.get(i)==7){
                //position 7
                seventh=drivers.get(i);
                seventh.seventhCalc(seventh);

            }else if (position.get(i)==8){
                //position 8
                eighth=drivers.get(i);
                eighth.eighthCalc(eighth);

            }else if (position.get(i)==9){
                //position 9
                ninth=drivers.get(i);
                ninth.ninthCalc(ninth);

            }else if(position.get(i)==10){
                //position 10
                tenth=drivers.get(i);
                tenth.tenthCalc(tenth);

            }
        }

        Random race= new Random();
        //random date

        int minLimitDate=(int) LocalDate.of(2021, 1, 1).toEpochDay();
        //minimum limit for the date

        int maxLimitDate=(int) LocalDate.of(2021,12,31).toEpochDay();
        //maximum limit for the date

        long range=minLimitDate +race.nextInt(maxLimitDate-minLimitDate);
        LocalDate date=LocalDate.ofEpochDay(range);
        //race date

        RaceCompleted raceCompleted= new RaceCompleted(first,second,third,fourth,fifth,sixth,seventh,eighth,ninth,tenth,date);
        //instantiate races
        this.races.add(raceCompleted);
        //add to the races arraylist

        this.loadIntoRacesTable();
        this.loadIntoTable();
        //load into both tables

        driversManager.saveToFile();

    }


    /**
     * @loadIntoTable method to set up starting information of races table
     */
    public void loadIntoTable(){

        if (raceModel.getRowCount() > 0) {
            for (int i = raceModel.getRowCount() - 1; i > -1; i--) {
                raceModel.removeRow(i);
            }
        }
        //empty the table

        for (Formula1Driver driver : this.drivers) {
            //iterate through the drivers arraylist

            String name = driver.getDriverName();
            String location = driver.getLocation();
            String team = driver.getTeamName();
            int points = driver.getNoOfPoints();
            int races = driver.getNoOfRacesParticipated();
            int firstP = driver.getFirstPositions();
            int secondP = driver.getSecondPositions();
            int thirdP = driver.getThirdPositions();
            int below = driver.getFourthPositions() + driver.getFifthPositions() + driver.getSixthPositions() + driver.getSeventhPositions() + driver.getEighthPositions() + driver.getNinthPositions() + driver.getTenthPositions();
            Object[] rows = {name, location, team, points, races, firstP, secondP, thirdP, below};
            raceModel.addRow(rows);
            //add to the table
        }

        tblDriver.repaint();
        tblDriver.revalidate();
        this.repaint();
        this.revalidate();

    }

    /**
     * @loadIntoRacesTable method to load stats in to the races table
     */
    public void loadIntoRacesTable(){

        if(completedModel.getRowCount()>0){
            for (int i=completedModel.getRowCount()-1;i>-1;i--){
                completedModel.removeRow(i);
            }
        }
        //empty the table

        for (RaceCompleted race : this.races) {
            //iterate through the races arraylist

            String date = race.getRaceDate();
            String first = race.getFirst().getDriverName();
            String second = race.getSecond().getDriverName();
            String third = race.getThird().getDriverName();
            Object[] rows = {date, first, second, third};
            completedModel.addRow(rows);
            //add to the table
        }

        tblCompleted.repaint();
        tblCompleted.revalidate();
        this.repaint();
        this.revalidate();

    }


    /**
     *
     * @param e action event when a button is clicked
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == this.bnSortPoints) {
            this.sortTable(SortUsing.ASCENDING_POINTS);
            //sort points in the ascending order

        } else if (e.getSource() == this.bnFirstWins) {
            this.sortTable(SortUsing.FIRSTS);
            //sort first wins in descending order

        } else if (e.getSource() == this.bnDate) {
            this.sortTable(SortUsing.DATE_CREATED);
            //sort dates in descending order

        } else if (e.getSource() == this.bnRandomRace) {
            this.randomRace();
            //generate random race

        }else if (e.getSource()==this.bnProbability){
            this.randomPercent();
            //generate random race using starting positions

        }else if (e.getSource()==this.bnSearch){
            Search search=new Search(drivers,races);
            //open search gui
        }

    }

}