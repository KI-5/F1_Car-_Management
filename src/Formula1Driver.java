import java.io.Serializable;

public class Formula1Driver extends Driver implements Serializable{
    //variables related to a Formula1 driver

    private String driverName;
    //name of the driver

    private String location;
    //location of the team

    private String teamName;
    //name of the team

    private int firstPositions;
    //number of first positions

    private int secondPositions;
    //number of second positions

    private int thirdPositions;
    //number of third positions

    private int fourthPositions;
    //number of fourth positions

    private int fifthPositions;
    //number of fifth positions

    private int sixthPositions;
    //number of sixth positions

    private int seventhPositions;
    //number of seventh positions

    private int eighthPositions;
    //number of eighth positions

    private int ninthPositions;
    //number of ninth positions

    private int tenthPositions;
    //number of tenth positions

    private int noOfPoints;
    //number of points

    private int noOfRacesParticipated;
    //number of races participated

    private int position;
    //position in a particular race


    /**
     * @CONSTRUCTOR
     */
    public Formula1Driver(){
        super();
        //abstract class constructor called

    }

    public Formula1Driver(String name, String location, String teamName,int firstPositions,int secondPositions,int thirdPositions,int fourthPositions,int fifthPositions,int sixthPositions,int seventhPositions, int eighthPositions, int ninthPositions, int tenthPositions, int position, int noOfPoints,int noOfRacesParticipated){
        //parameterized constructor

        super(name,location,teamName);
        //abstract class constructor called

        this.firstPositions=firstPositions;
        this.secondPositions=secondPositions;
        this.thirdPositions=thirdPositions;
        this.fourthPositions=fourthPositions;
        this.fifthPositions=fifthPositions;
        this.sixthPositions=sixthPositions;
        this.seventhPositions=seventhPositions;
        this.eighthPositions=eighthPositions;
        this.ninthPositions=ninthPositions;
        this.tenthPositions=tenthPositions;
        this.noOfPoints=noOfPoints;
        this.noOfRacesParticipated=noOfRacesParticipated;
        this.position =position;
    }

    public void setPosition(int position) {
        //setter for position

        this.position = position;
    }

    public int getPosition() {
        //getter for position

        return position;
    }

    public void setDriverName(String driverName) {
        //setter for DriverName

        this.driverName = driverName;
    }

    public String getDriverName(){
        //getter for DriverName

        return driverName;
    }

    public void setLocation(String location) {
        //setter for location

        this.location = location;
    }

    public String getLocation() {
        //getter for location

        return location;
    }

    public void setTeamName(String teamName) {
        //setter for teamName

        this.teamName = teamName;
    }

    public String getTeamName(){
        //getter for teamName

        return teamName;
    }

    public void setFirstPositions(int firstPositions) {
        //setter for the number of first positions

        this.firstPositions = firstPositions;
    }

    public int getFirstPositions() {
        //getter for the number of first positions

        return firstPositions ;
    }

    public void setSecondPositions(int secondPositions) {
        //setter for the number of second positions

        this.secondPositions = secondPositions;
    }

    public int getSecondPositions() {
        //getter for the number of second positions

        return secondPositions ;
    }

    public void setThirdPositions(int thirdPositions) {
        //setter for the number of third positions

        this.thirdPositions = thirdPositions;
    }

    public int getThirdPositions() {
        //getter for the number of third positions

        return thirdPositions ;
    }

    public void setFourthPositions(int fourthPositions) {
        //setter for the number of fourth positions

        this.fourthPositions = fourthPositions;
    }

    public int getFourthPositions() {
        //getter for the number of fourth positions

        return fourthPositions;
    }

    public void setFifthPositions(int fifthPositions) {
        //setter for the number of fifth positions

        this.fifthPositions = fifthPositions;
    }

    public int getFifthPositions() {
        //getter for the number of fifth positions

        return fifthPositions ;
    }

    public void setSixthPositions(int sixthPositions) {
        //setter for the number of sixth positions

        this.sixthPositions = sixthPositions;
    }

    public int getSixthPositions() {
        //getter for the number of sixth positions

        return sixthPositions ;
    }

    public void setSeventhPositions(int seventhPositions) {
        //setter for the number of seventh positions

        this.seventhPositions = seventhPositions;
    }

    public int getSeventhPositions() {
        //getter for the number of seventh positions

        return seventhPositions ;
    }

    public void setEightPositions(int eighthPositions) {
        //setter for the number of eighth positions

        this.eighthPositions = eighthPositions;
    }

    public int getEighthPositions() {
        //getter for the number of eighth positions

        return eighthPositions ;
    }

    public void setNinthPositions(int ninthPositions) {
        //setter for the number of ninth positions

        this.ninthPositions = ninthPositions;
    }

    public int getNinthPositions() {
        //getter for the number of ninth positions

        return ninthPositions ;
    }

    public void setTenthPositions(int tenthPositions) {
        //setter for the number of tenth positions

        this.tenthPositions = tenthPositions;
    }

    public int getTenthPositions() {
        //getter for the number of tenth positions

        return tenthPositions;
    }

    public void setNoOfPoints(int noOfPoints) {
        //setter for the number of points

        this.noOfPoints = noOfPoints;
    }

    public int getNoOfPoints() {
        //getter for the number of points

        return noOfPoints;
    }

    public void setNoOfRacesParticipated(int noOfRacesParticipated) {
        //setter for the number of races participated in

        this.noOfRacesParticipated = noOfRacesParticipated;
    }

    public int getNoOfRacesParticipated() {
        //getter for the number of races participated in

        return noOfRacesParticipated;
    }

    public void firstCalc(Formula1Driver driver){
        //calculation for the first position

        setPosition(1);
        setNoOfPoints(driver.getNoOfPoints()+25);
        setFirstPositions(driver.getFirstPositions()+1);
        setNoOfRacesParticipated(driver.getNoOfRacesParticipated()+1);
    }
    public void secondCalc(Formula1Driver driver){
        //calculation for the second position

        setPosition(2);
        setNoOfPoints(driver.getNoOfPoints()+18);
        setSecondPositions(driver.getSecondPositions()+1);
        setNoOfRacesParticipated(driver.getNoOfRacesParticipated()+1);
    }
    public void thirdCalc(Formula1Driver driver){
        //calculation for the third position

        setPosition(3);
        setNoOfPoints(driver.getNoOfPoints()+15);
        setThirdPositions(driver.getThirdPositions()+1);
        setNoOfRacesParticipated(driver.getNoOfRacesParticipated()+1);
    }
    public void fourthCalc(Formula1Driver driver){
        //calculation for the fourth position

        setPosition(4);
        setNoOfPoints(driver.getNoOfPoints()+12);
        setFourthPositions(driver.getFourthPositions()+1);
        setNoOfRacesParticipated(driver.getNoOfRacesParticipated()+1);
    }
    public void fifthCalc(Formula1Driver driver){
        //calculation for the fifth position

        setPosition(5);
        setNoOfPoints(driver.getNoOfPoints()+10);
        setTenthPositions(driver.getFifthPositions()+1);
        setNoOfRacesParticipated(driver.getNoOfRacesParticipated()+1);
    }
    public void sixthCalc(Formula1Driver driver){
        //calculation for the sixth position

        setPosition(6);
        setNoOfPoints(driver.getNoOfPoints()+8);
        setSixthPositions(driver.getSixthPositions()+1);
        setNoOfRacesParticipated(driver.getNoOfRacesParticipated()+1);
    }
    public void seventhCalc(Formula1Driver driver){
        //calculation for the seventh position

        setPosition(7);
        setNoOfPoints(driver.getNoOfPoints()+6);
        setSeventhPositions(driver.getSeventhPositions()+1);
        setNoOfRacesParticipated(driver.getNoOfRacesParticipated()+1);
    }
    public void eighthCalc(Formula1Driver driver){
        //calculation for the eighth position

        setPosition(8);
        setNoOfPoints(driver.getNoOfPoints()+4);
        setEightPositions(driver.getEighthPositions()+1);
        setNoOfRacesParticipated(driver.getNoOfRacesParticipated()+1);
    }
    public void ninthCalc(Formula1Driver driver){
        //calculation for the ninth position

        setPosition(9);
        setNoOfPoints(driver.getNoOfPoints()+2);
        setNinthPositions(driver.getNinthPositions()+1);
        setNoOfRacesParticipated(driver.getNoOfRacesParticipated()+1);
    }
    public void tenthCalc(Formula1Driver driver){
        //calculation for the tenth position

        setPosition(10);
        setNoOfPoints(driver.getNoOfPoints()+1);
        setTenthPositions(driver.getTenthPositions()+1);
        setNoOfRacesParticipated(driver.getNoOfRacesParticipated()+1);
    }



    @Override
    public String toString() {
        //toString method

        return "Formula1Driver{" +
                "driverName='" + driverName + '\'' +
                ", location='" + location + '\'' +
                ", teamName='" + teamName + '\'' +
                ", firstPositions=" + firstPositions +
                ", secondPositions=" + secondPositions +
                ", thirdPositions=" + thirdPositions +
                ", fourthPositions=" + fourthPositions +
                ", fifthPositions=" + fifthPositions +
                ", sixthPositions=" + sixthPositions +
                ", seventhPositions=" + seventhPositions +
                ", eighthPositions=" + eighthPositions +
                ", ninthPositions=" + ninthPositions +
                ", tenthPositions=" + tenthPositions +
                ", noOfPoints=" + noOfPoints +
                ", noOfRacesParticipated=" + noOfRacesParticipated +
                '}';
    }
}

