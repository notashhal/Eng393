//import java.util.Scanner;
//public class InputPlayer {
//   public static void main(String[] args) {
//      Scanner key = new Scanner(System.in);
//      Player p = new Player();
//      System.out.print("What is the Player's first name? ");
//      p.setFirstName(key.nextLine());
//      System.out.print("What is "+p.getFirstName()+"'s last name? ");
//      p.setLastName(key.nextLine());
//      System.out.println("What is "+p.getFirstName()+" "+p.getLastName()+" Field Goal Percentage? ");
//      p.setFieldgoalPercentage(key.nextLine());
//      System.out.println("How many points did "+p.getFirstName()+" "+p.getLastName()+" score? ");
//      p.setPoints(key.nextLine());
//      System.out.println("How many assists did "+p.getFirstName()+" "+p.getLastName()+" get? ");
//      p.setAssists(key.nextLine());
//      System.out.println("How many rebounds did "+p.getFirstName()+" "+p.getLastName()+" get? ");
//      p.setRebounds(key.nextLine());
//      System.out.println(p);
//   }
//}
//		Scanner key = new Scanner(System.in);
//		System.out.println("Welcome to the P.R.S (Player Recap System)");
//		System.out.print("How many players do you wish to enter?: ");
//		int size = Integer.parseInt(key.nextLine());
//		String input;
//
//		// Declare array of the player
//		Player player[] = new Player[size];
//
//		for (int i=0; i<player.length; i++) {
//			// Declare a new player object and get information and statistics
//			Player p = new Player();
//			System.out.println("What is the player's first name? ");
//			p.setFirstName(key.nextLine());
//			System.out.println("What is "+p.getFirstName()+"'s last name? ");
//			p.setLastName(key.nextLine());
//			System.out.println("What is "+p.getFirstName()+" "+p.getLastName()+" Field Goal Percentage? ");
//			p.setFieldgoalPercentage(key.nextLine());
//			System.out.println("How many points did "+p.getFirstName()+" "+p.getLastName()+" score? ");
//			p.setPoints(key.nextLine());
//			System.out.println("How many assists did "+p.getFirstName()+" "+p.getLastName()+" get? ");
//			p.setAssists(key.nextLine());
//			System.out.println("How many rebounds did "+p.getFirstName()+" "+p.getLastName()+" get? ");
//			p.setRebounds(key.nextLine());
//			// Assign p to the people array
//			player[i] = p;
//		}
//		
//
//		int[][] jersey = new int[size][2]; //The jersey numbers of the players using a 2d array
//		
//		java.util.Scanner input1 = new java.util.Scanner(System.in);
//		System.out.println("\rEnter the " + jersey.length + " player's Jersey Numbers as columns of " + jersey[0].length + "(Please put spaces in between each digit):");
//		for (int row =0; row<jersey.length; row++) {
//			for (int column = 0; column < jersey[row].length; column++) {
//				jersey[row][column] = input1.nextInt();
//				//System.out.print(jersey[row][column]);
//				
//				
//			}
//
//			
//			
//		}
//		
//		System.out.println(" \rThese are the players Jersey Numbers In Order. ");
//
//		System.out.println("\nPlayers entered:");
//		for (Player p:player)
//			System.out.println(p);
//		
//		
//
//
//		if(event.getSource()==button3) {
//			System.out.println(helpMenu.getAbout());   //Calling Help Class
//		}
//		if(event.getSource()==button4) {
//			System.out.println(helpMenu.getCreator()); //Calling Help Class
//		}
//		if(event.getSource()==button5) {
//			System.out.println(helpMenu.getHowto()); //Calling Help Class
//
//		}
