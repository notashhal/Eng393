// **********************************************************************************
// Major Project Part 5 - Player Recap System
// Ashhal Wasti 
// CMIS202-ONL1 (Seidel) Fall 2020
// Player.java, InputStats.java, InputPlayer.java, Help.java, Server.java, Stats.txt
// **********************************************************************************
public class Player {
	//Attributes
	   private String firstName;
	   private String lastName;
	   private String position;
	   private String fieldgoalPercentage;
	   private String points;
	   private String assists;
	   private String rebounds;
	   
	// Constructors:
	   public Player(String firstName, String lastName, String fieldgoalPercentage, String points, String assists, String rebounds, String position) {
		      this.firstName = firstName;
		      this.lastName = lastName;
		      this.fieldgoalPercentage = fieldgoalPercentage;
		      this.points = points;
		      this.assists = assists;
		      this.rebounds = rebounds;
		      this.position = position;
		   }
	   
	// Mutators:
	   public Player() {
		      firstName = "";
		      lastName = "";
		      fieldgoalPercentage = "";
		      points = "";
		      assists = "";
		      rebounds = "";
		      position = "";
		      
		   }
	   
	// Accessors:
	   public void setFirstName(String f) {
		      firstName = f;
		   }
		   public void setLastName(String l) {
		      lastName = l;
		   }
		   public void setFieldgoalPercentage(String fg) {
			   fieldgoalPercentage = fg;
		   }
		   public void setPoints(String p) {
			   points = p;
		   }
		   public void setAssists(String a) {
			   assists = a;
		   }
		   public void setRebounds(String r) {
			   rebounds = r;
		   }
		   public void setPosition(String po) {
			   position = po;
		   }
		   public String getFirstName() {
			      return this.firstName;
			   }
			   public String getLastName() {
			      return this.lastName;
			   }
			   public String getFieldgoalPercentage() {
				return this.fieldgoalPercentage;
			   }
			   public String getPoints() {
				return points; 
			   }
			   public String getAssists() {
				return assists;   
			   }
			   public String getRebounds() {
				return rebounds;
			   }
			   public String getPosition() {
				return position;
				   
			   }
			   public String toString() {
				      String result = "";
				      result += "First Name: "+getFirstName()+"\n";
				      result += "Last Name: "+getLastName()+"\n";
				      result += "Field Goal Percentage: "+getFieldgoalPercentage()+"\n";
				      result += "Points: "+getPoints()+"\n";
				      result += "Assists: "+getAssists()+"\n";
				      result += "Rebounds: "+getRebounds()+"\n";
				      result += "Position: "+getPosition()+"\n";
				      return result;
				   }

}//Player Class
