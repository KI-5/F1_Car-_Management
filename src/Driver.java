public abstract class Driver {
    /**
    * Abstract class of the Driver
    * **/

    private String driverName;
    private String location;
    private String teamName;
    //variables of Driver abstract class

    /**
     * @CONSTRUCTOR
     */
    public Driver(){
        //default constructor of Driver class
    }

    public Driver(String driverName,String location, String teamName){
        //parameterized constructor

        this.driverName=driverName;
        //set name

        this.location=location;
        //set location

        this.teamName=teamName;
        //set team name

    }
}
