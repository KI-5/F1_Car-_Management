import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class RaceCompleted implements Serializable {
    /**
     * attributes of the race completed class
     * all the positions of a race up to 10
     * the date of the race
     **/

    private ArrayList<Formula1Driver> championshipDrivers=new ArrayList<>();


    private Formula1Driver first;
    //first driver

    private Formula1Driver second;
    //second driver

    private Formula1Driver third;
    //third driver

    private Formula1Driver fourth;
    //fourth driver

    private Formula1Driver fifth;
    //fifth driver

    private Formula1Driver sixth;
    //sixth driver

    private Formula1Driver seventh;
    //seventh driver

    private Formula1Driver eighth;
    //eighth driver

    private Formula1Driver ninth;
    //ninth driver

    private Formula1Driver tenth;
    //tenth driver

    private Date raceDate;
    //race date

    /**
     * @CONSTRUCTOR
     */
    public RaceCompleted(){
        //default constructor

    }

    public RaceCompleted(Formula1Driver first,Formula1Driver second,Formula1Driver third,Formula1Driver fourth,Formula1Driver fifth, Formula1Driver sixth,Formula1Driver seventh, Formula1Driver eighth,Formula1Driver ninth,Formula1Driver tenth, LocalDate date){
        //parameterized constructor

        this.first=first;
        this.second=second;
        this.third=third;
        this.fourth=fourth;
        this.fifth=fifth;
        this.sixth=sixth;
        this.seventh=seventh;
        this.eighth=eighth;
        this.ninth=ninth;
        this.tenth=tenth;

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy MM dd");
        String raceDay = date.format(dateTimeFormatter);
        //setting the date format

        this.setRaceDate2(raceDay);

    }

    public RaceCompleted(Formula1Driver first,Formula1Driver second,Formula1Driver third,Formula1Driver fourth,Formula1Driver fifth, Formula1Driver sixth,Formula1Driver seventh, Formula1Driver eighth,Formula1Driver ninth,Formula1Driver tenth, String date){
        //parameterized constructor

        this.first=first;
        this.second=second;
        this.third=third;
        this.fourth=fourth;
        this.fifth=fifth;
        this.sixth=sixth;
        this.seventh=seventh;
        this.eighth=eighth;
        this.ninth=ninth;
        this.tenth=tenth;

        this.setRaceDate1(date);
        //string date

    }

    public void setChampionshipDrivers(ArrayList<Formula1Driver> championshipDrivers) {
        //setter
        championshipDrivers.add(first);
        championshipDrivers.add(second);
        championshipDrivers.add(third);
        championshipDrivers.add(fourth);
        championshipDrivers.add(fifth);
        championshipDrivers.add(sixth);
        championshipDrivers.add(seventh);
        championshipDrivers.add(seventh);
        championshipDrivers.add(eighth);
        championshipDrivers.add(ninth);
        this.championshipDrivers=championshipDrivers;

    }

    public ArrayList<Formula1Driver> getChampionshipDrivers() {
        //getter of drivers arraylist

        return championshipDrivers;
    }

    public Formula1Driver getFirst() {
        //getter of the first driver

        return first;
    }

    public void setFirst(Formula1Driver first) {
        //setter of the first driver

        this.first = first;
    }

    public  Formula1Driver getSecond() {
        //getter of the second driver

        return second;
    }

    public void setSecond(Formula1Driver second) {
        //setter of the second driver

        this.second = second;
    }

    public  Formula1Driver getThird() {
        //getter of the third driver

        return third;
    }

    public void setThird(Formula1Driver third) {
        //setter of the third driver

        this.third = third;
    }

    public Formula1Driver getFourth() {
        //getter of the fourth driver

        return fourth;
    }

    public void setFourth(Formula1Driver fourth) {
        //setter of the fourth driver

        this.fourth = fourth;
    }

    public Formula1Driver getFifth() {
        //getter of the fifth driver

        return fifth;
    }

    public void setFifth(Formula1Driver fifth) {
        //setter of the fifth driver

        this.fifth = fifth;
    }

    public Formula1Driver getSixth() {
        //getter of the sixth driver

        return sixth;
    }

    public void setSixth(Formula1Driver sixth) {
        //setter of the sixth driver

        this.sixth = sixth;
    }

    public Formula1Driver getSeventh() {
        //getter of the seventh driver

        return seventh;
    }

    public void setSeventh(Formula1Driver seventh) {
        //setter of the seventh driver

        this.seventh = seventh;
    }

    public Formula1Driver getEighth() {
        //getter of the eighth driver

        return eighth;
    }

    public void setEighth(Formula1Driver eighth) {
        //setter of the eighth driver

        this.eighth = eighth;
    }

    public Formula1Driver getNinth() {
        //getter of the ninth driver

        return ninth;
    }

    public void setNinth(Formula1Driver ninth) {
        //setter of the ninth driver

        this.ninth = ninth;
    }

    public Formula1Driver getTenth() {
        //getter of the tenth driver

        return tenth;
    }

    public void setTenth(Formula1Driver tenth) {
        //setter of the tenth driver

        this.tenth = tenth;
    }


    public String getRaceDate() {
        //getter of the date

        return new SimpleDateFormat("yyyy/MM/dd").format(this.raceDate);
    }


    private void setRaceDate1(String gameDate) {
        //setter of the string type date

        Date date;
        try {
            // parse string to data format

            date = (Date) new SimpleDateFormat("yyyy/MM/dd").parse(gameDate);
            this.raceDate = date;
            //set date

        } catch (ParseException e) {

            e.printStackTrace();
        }
    }


    private void setRaceDate2(String gameDate) {
        //setter of the LocalDate date

        Date date;
        try {

            // parse string to data format

            date = (Date) new SimpleDateFormat("yyyy MM dd").parse(gameDate);
            this.raceDate = date;
            //set date

        } catch (ParseException e) {

            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "MatchDate=" + raceDate;
    }
}
