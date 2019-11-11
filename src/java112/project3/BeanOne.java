package java112.project3;

/**
 *  This is a JavaBean to demonstrate using beans with JSP.
 *
 *@author    eknapp
 */
public class BeanOne extends Object {

    private String mySpecialData;
    private String teamName;
    private String playerName;
    private Integer jerseyNumber;


    /**
     *  Constructor for the BeanOne object
     */
    public BeanOne() {
        mySpecialData  = "default value";
        teamName = "default name";
    }

    /**
     *  Gets the mySpecialData attribute of the BeanOne object
     *
     *@return    The mySpecialData value
     */
    public String getMySpecialData() {
        return mySpecialData;
    }

    /**
     *  Sets the mySpecialData attribute of the BeanOne object
     *
     *@param  mySpecialData  The new mySpecialData value
     */
    public void setMySpecialData(String mySpecialData) {
        this.mySpecialData = mySpecialData;
    }

    /**
     *  Gets the mySpecialData attribute of the BeanOne object
     *
     *@return    The mySpecialData value
     */
    public String geTeamName() {
        return teamName;
    }

    /**
     *  Sets the mySpecialData attribute of the BeanOne object
     *
     *@param  mySpecialData  The new mySpecialData value
     */
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    /**
     *  Gets the mySpecialData attribute of the BeanOne object
     *
     *@return    The mySpecialData value
     */
    public Integer getJerseyNumber () {
        return jerseyNumber;
    }

    /**
     *  Sets the mySpecialData attribute of the BeanOne object
     *
     *@param  mySpecialData  The new mySpecialData value
     */
    public void setJerseyNumber(Integer jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
    }
}
