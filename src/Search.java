import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Search extends JFrame implements ActionListener, Serializable {

    private final ArrayList<Formula1Driver> drivers;
    //arraylist of drivers

    private final ArrayList<RaceCompleted> races;
    //arraylist of races

    /**
     * @TEXTFIELD gets the value of user input
     */
    private JTextField tfSearch;


    /**
     * @BUTTONS to get the user input and display related information
     */
    private DefineButtons bnSearch;


    /**
     * @CONTAINER
     */
    private Container container;


    /**
     * @TABLEMODEL for the output table
     */
    private DefaultTableModel defaultTableModel;


    /**
     * @TABLES to get the output
     */
    private JTable tblDetail;

    /**
     * @LABELS for the search option
     */
    private JLabel lbSearch;


    /**
     * @CONSTRUCTOR
     * @param drivers arraylist of drivers
     * @param races arraylist of races
     */

    public Search(ArrayList<Formula1Driver> drivers,ArrayList<RaceCompleted> races){

        Path path1= Paths.get("./Formula1_Information.ser");
        Path path2= Paths.get("./Race_Information.ser");
        //get file information

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



        this.drivers=drivers;
        //assign drivers to local variable

        this.races=races;
        //assign races to local variable

        this.baseSetUp();
        //set up the basic properties

        this.container=this.getContentPane();
        //assign container

        this.container.setLayout(new BorderLayout(15,15));
        //set the BorderLayout

        this.fillInTable();
        //set up the output table

        this.searchScroll();
        //set up the scroll pane of the output table

        this.setText();
        //set up the base layout

        bnSearch=new DefineButtons("Search",this);
        //set up the search button

        this.pane();

        this.pack();
        //pack the whole gui
    }


    /**
     * @fillInTable method to fill the drivers table at the start
     */
    public void fillInTable() throws IndexOutOfBoundsException{

        String [] columns={"Date","Position placed"};
        //heading of the table

        this.defaultTableModel = new DefaultTableModel(columns, 0);
        //set rows and columns

        for (int i=0; i < this.races.size(); i++) {
            //loop through all the drivers

            String date = this.races.get(i).getRaceDate();
            //race date

            int position = 0;
            //default position when first opened

            Object[] rows = {date, position};

            defaultTableModel.addRow(rows);
            //add rows to the table model

        }

        tblDetail=new JTable(defaultTableModel);
        //assign model to the table

    }

    /**
     * @searchScroll method to add the table to the scroll pane
     */
    public void searchScroll(){

        JScrollPane scroll=new JScrollPane(tblDetail);
        //new scroll pane with the table

        scroll.setBackground(new Color(0x446561));
        //set background colour of the scroll pane

        scroll.setBounds(0,0,400,500);
        //set size of the scroll pane

        this.container.add(scroll,BorderLayout.CENTER);
        //assign scroll pane to the center

    }

    /**
     * @pane set up the button and label
     */
    public void pane(){

        JPanel input=new JPanel();
        //panel

        input.setBackground(new Color(0x465855));
        //panel background

        input.setForeground(new Color(0xFFFFFF));
        //label text colour

        input.setLayout(new FlowLayout(FlowLayout.CENTER));
        //set up layout

        input.add(tfSearch);
        input.add(bnSearch);
        //add everything to the panel

        this.container.add(input,BorderLayout.NORTH);
        // add to the container at the top

    }

    /**
     * @baseSetUp set up visible basic layout
     */
    public void baseSetUp(){

        this.setTitle("Search for a drivers' statistics");
        //title of the gui

        this.setLayout(null);

        this.getContentPane().setBackground(new Color(0x000000));
        //set background colour

        this.setBounds(0, 0, 500, 600);
        //size of the gui

        this.setVisible(true);
        //visible

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //terminate the program

    }

    /**
     * @searchStatistics shows the stats of the person whose name is typed
     */
    public void searchStats(){

        String searchValue=this.tfSearch.getText();
        //value input

        if(this.defaultTableModel.getRowCount()>0){
            for (int i= defaultTableModel.getRowCount()-1;i>-1;i--){
                defaultTableModel.removeRow(i);
            }
        }
        //empty the table

        for (RaceCompleted race : this.races) {
            //iterate through the races arraylist

            for (Formula1Driver driver : this.drivers) {
                //iterate through the drivers arraylist

                if (driver.getDriverName().equalsIgnoreCase(searchValue)) {
                    //check if equal

                    String date = race.getRaceDate();
                    //race date

                    int position = driver.getPosition();
                    //position

                    Object[] rows = {date, position};
                    defaultTableModel.addRow(rows);
                    //add to the table model

                }
            }

        }


        tblDetail.repaint();
        tblDetail.revalidate();
        this.repaint();
        this.revalidate();
    }

    /**
     * @setText set up base layout for the labels
     */
    public void setText(){

        this.lbSearch=new JLabel("Enter the name of the driver");
        //search label

        this.tfSearch=new JTextField("Enter the name");
        //search text field

        this.tfSearch.setColumns(25);
        //set the size of the text field

    }

    /**
     *
     * @param e action event when a button is clicked
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==this.bnSearch){
            this.searchStats();
            //show statistics

        }
    }
}

