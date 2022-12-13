
public class Help {
//Attributes	
private String about; //about the program
private String creator; //about me the creator
private String howto; //any questions on how to input anything

//Constructors
public Help(String about, String creator, String howto) {
	this.about = about;
	this.creator = creator;
	this.howto = howto;
	

}

//Mutators	
public Help() {
	about = "This program is about keeping track of players stats and how they do each game.\nSo that coaches and players are able to compare these "
			+ "stats so they can improve or work on certain aspects about the players.\nIt keeps track of their name, points, assists, rebounds, fieldgoal percentage and the position they play.\n";
	creator = "Ashhal Wasti, 19, Student at FCC (Frederick Community College)\n"
			+ "ashhalwasti854@myfcc.frederick.edu\n"
			+ "783-231-3865\n";
	howto = "1. Enter any number of players you wish to enter.\n"
			+ "2. Then Enter First and Last Name.\n"
			+ "3. Enter their stats (position, fieldgoal percentage, points, etc).\n"
			+ "4. Press the Add button to add the player to the table.\n"
			+ "5. Repeat if you enter multiple players.\n"
			+ "6. If you would like to remove a player, you can just press the Delete Button and it will remove the player from the table.\n"
			+ "MAKE SURE WHEN REMOVING A PLAYER YOU ALSO REMOVE IT FROM THE Stats.txt FILE MANUALLY.\n"
			+ "7. You can also sort the columns.\n";
	
}
//Accessors
public void setAbout(String a) {
	about = a;
}
	public void setCreator(String c) {
		creator = c;
	}
	public void setHowto(String h) {
		howto = h;
	}
	public String getAbout() {
		return this.about;
	}
	public String getCreator() {
		return this.creator;
	}
	public String getHowto() {
		return this.howto;
	}
	
	public String toString() {
		String result = "";
		result += about;
		result += creator;
		result += howto;
		return result;
	}
}//Help Class