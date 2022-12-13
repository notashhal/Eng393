import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Map.Entry;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;


public class InputStats extends Application implements EventHandler<ActionEvent>{



	public static void main(String[] args) {
		launch(args);




	}

	Button button3; //About Button
	Button button4; //Creator Button
	Button button5; //HowTo Button




	Stage window;
	Scene scene1, scene2, scene3, scene4, scene5, scene6, scene7, scene8, scene9, scene10, scene11;
	TableView<Player> table;
	TextField firstnameInput, lastnameInput, positionInput, fieldgoalpercentageInput, pointsInput, assistsInput, reboundsInput; 

	Help helpMenu = new Help();

	private ListView List = new ListView();

	DataOutputStream toServer = null;
	DataInputStream fromServer = null;
	String serverMessage = "";




	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		window = primaryStage;



		////////Columns////////	

		//First Name Column
		TableColumn<Player, String> firstnameColumn = new TableColumn<>("First Name");
		firstnameColumn.setMinWidth(200);
		firstnameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));

		//Last Name Column
		TableColumn<Player, String> lastnameColumn = new TableColumn<>("Last Name");
		lastnameColumn.setMinWidth(200);
		lastnameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));

		//Position Column
		TableColumn<Player, String> positionColumn = new TableColumn<>("Position");
		positionColumn.setMinWidth(200);
		positionColumn.setCellValueFactory(new PropertyValueFactory<>("position"));

		//Field Goal Percentage Column
		TableColumn<Player, String> fieldgoalpercentageColumn = new TableColumn<>("Field Goal Percentage");
		fieldgoalpercentageColumn.setMinWidth(200);
		fieldgoalpercentageColumn.setCellValueFactory(new PropertyValueFactory<>("fieldgoalPercentage"));

		//Points Column
		TableColumn<Player, String> pointsColumn = new TableColumn<>("Points");
		pointsColumn.setMinWidth(200);
		pointsColumn.setCellValueFactory(new PropertyValueFactory<>("points"));

		//Assists Column
		TableColumn<Player, String> assistsColumn = new TableColumn<>("Assists");
		assistsColumn.setMinWidth(200);
		assistsColumn.setCellValueFactory(new PropertyValueFactory<>("assists"));

		//Rebounds Column
		TableColumn<Player, String> reboundsColumn = new TableColumn<>("Rebounds");
		reboundsColumn.setMinWidth(200);
		reboundsColumn.setCellValueFactory(new PropertyValueFactory<>("rebounds"));

		////////Columns////////		


		//Positions in Basketball
		TextArea textBox = new TextArea();
		Queue<String> Posi = new LinkedList<>();

		Posi.add("Point Guard");
		Posi.add("Shooting Guard");
		Posi.add("Small Forward");
		Posi.add("Power Forward");
		Posi.add("Center");

		String PosContents = "";
		for(String s: Posi) {
			PosContents = PosContents + "\n" + s;

		}

		textBox.setText(PosContents);


		//Rules of Basketball
		HashMap<String, String> Rules = new HashMap<String, String>();

		Rules.put("Rule 01", "Court Dimensions - Equipment");
		Rules.put("Rule 02", "Duties of the Officials");
		Rules.put("Rule 03", "Players, Substitutes and Coaches");
		Rules.put("Rule 04", "Definitions");
		Rules.put("Rule 05", "Scoring and Timing");
		Rules.put("Rule 06", "Putting Ball in Play – Live/Dead Ball");
		Rules.put("Rule 07", "Shot Clock");
		Rules.put("Rule 08", "Out-of-Bounds and Throw-In");
		Rules.put("Rule 09", "Free Throws and Penalties");
		Rules.put("Rule 10", "Violations and Penalties");
		Rules.put("Rule 11", "Basket Interference – Goaltending");
		Rules.put("Rule 12", "Fouls and Penalties");
		Rules.put("Rule 13", "Instant Replay");
		Rules.put("Rule 14", "Coaches Challenge");


		//Columns for Rules
		TableColumn<HashMap.Entry<String, String>, String> columnRN = new TableColumn<>("Rule #");
		columnRN.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<HashMap.Entry<String, String>, String>, ObservableValue<String>>() {

			@Override
			public ObservableValue<String> call(TableColumn.CellDataFeatures<HashMap.Entry<String, String>, String> p) {

				return new SimpleStringProperty(p.getValue().getKey());
			}
		});

		TableColumn<HashMap.Entry<String, String>, String> columnR = new TableColumn<>("Rule");
		columnR.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<HashMap.Entry<String, String>, String>, ObservableValue<String>>() {

			@Override
			public ObservableValue<String> call(TableColumn.CellDataFeatures<HashMap.Entry<String, String>, String> p) {

				return new SimpleStringProperty(p.getValue().getValue());
			}
		});

		ObservableList<HashMap.Entry<String, String>> rulesList = FXCollections.observableArrayList(Rules.entrySet());
		final TableView<HashMap.Entry<String,String>> table1 = new TableView<>(rulesList);

		table1.getColumns().setAll(columnRN, columnR);

		////////User Input////////		

		//First Name Input
		firstnameInput = new TextField();
		firstnameInput.setPromptText("First Name");
		firstnameInput.setMinWidth(100);

		//Last Name Input
		lastnameInput = new TextField();
		lastnameInput.setPromptText("Last Name");
		lastnameInput.setMinWidth(100);

		//Position Input
		positionInput = new TextField();
		positionInput.setPromptText("Position");
		positionInput.setMinWidth(100);

		//Field Goal Percentage Input
		fieldgoalpercentageInput = new TextField();
		fieldgoalpercentageInput.setPromptText("Field Goal Percentage");
		fieldgoalpercentageInput.setMinWidth(100);

		//Points Input
		pointsInput = new TextField();
		pointsInput.setPromptText("Points");
		pointsInput.setMinWidth(100);

		//Assists Input
		assistsInput = new TextField();
		assistsInput.setPromptText("Assists");
		assistsInput.setMinWidth(100);

		//Rebounds Input
		reboundsInput = new TextField();
		reboundsInput.setPromptText("Rebounds");
		reboundsInput.setMinWidth(100);

		////////User Input////////			

		////////Add and Delete Button////////

		Button addButton = new Button("Add");
		addButton.setOnAction(e -> {
			try {
				addButtonClicked(e);
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		});
		Button deleteButton = new Button ("Delete");
		deleteButton.setOnAction(e -> deleteButtonClicked());


		////////Add and Delete Button////////

		////////User Input at bottom of the Main Screen////////	

		HBox hBox = new HBox();
		hBox.setPadding(new Insets(10, 10, 10, 10));
		hBox.setSpacing(10);
		hBox.getChildren().addAll(firstnameInput, lastnameInput, positionInput, fieldgoalpercentageInput, pointsInput, assistsInput, reboundsInput, addButton, deleteButton);

		////////User Input at bottom of the Main Screen////////			


		table = new TableView<>();
		table.setItems(getPlayer());
		table.getColumns().addAll(firstnameColumn, lastnameColumn, positionColumn, fieldgoalpercentageColumn, pointsColumn, assistsColumn, reboundsColumn);


		Label label1 = new Label("Welcome to the Player Recap System (PRS)");//Heading of Main Menu
		label1.setFont(new Font("Arial", 20));


		//Help Menu Labels//
		Label label2 = new Label(helpMenu.getAbout());
		Label label3 = new Label(helpMenu.getCreator());
		Label label4 = new Label(helpMenu.getHowto());
		//Help Menu Labels//

		////////Buttons////////	

		Button button1 = new Button("Help"); //The Help Button to send the user to the Help Menu
		button1.setOnAction(e -> window.setScene(scene2));

		Button button2d = new Button("Back");
		button2d.setOnAction(e -> window.setScene(scene1));

		Button button6a = new Button("Teams"); //The NBA Teams Button to send the user to the Teams Menu
		button6a.setOnAction(e -> window.setScene(scene7));

		Button button2da = new Button("Back");
		button2da.setOnAction(e -> window.setScene(scene6));

		Button button6b = new Button("Position"); //The Position Button to send the user to the Positions Menu
		button6b.setOnAction(e -> window.setScene(scene8));

		Button button2db = new Button("Back");
		button2db.setOnAction(e -> window.setScene(scene6));

		Button button6c = new Button("Rules"); //The Rules Button to send the user to the Rules Menu
		button6c.setOnAction(e -> window.setScene(scene9));

		Button button2dc = new Button("Back");
		button2dc.setOnAction(e -> window.setScene(scene6));

		////////Buttons////////	


		VBox layout6 = new VBox(30);
		layout6.getChildren().addAll(button2d, button6a, button6b, button6c);
		scene6 = new Scene(layout6, 800, 500);

		VBox layout7 = new VBox(30);
		layout7.getChildren().addAll(button2da, List);
		scene7 = new Scene(layout7, 800, 500);

		VBox layout8 = new VBox(30);
		layout8.getChildren().addAll(button2db, textBox);
		scene8 = new Scene(layout8, 800, 500);

		VBox layout9 = new VBox(30);
		layout9.getChildren().addAll(button2dc, table1);
		scene9 = new Scene(layout9, 800, 500);






		Button button6 = new Button("Info"); //The Common Info Button to send the user to the Info Menu
		button6.setOnAction(e -> window.setScene(scene6));

		Button button7 = new Button("Message"); //Client to Server Message Button
		button7.setOnAction(e -> window.setScene(scene10));

		Button button8 = new Button("Jersey"); //Jersey Number 
		button8.setOnAction(e -> window.setScene(scene11));


		VBox layout1 = new VBox(10);
		layout1.setPadding(new Insets(20, 20, 20, 20));
		layout1.getChildren().addAll(label1, button1, table, hBox, button6, button7, button8 );
		scene1 = new Scene(layout1, 1440, 500);


		////////Help Menu Buttons////////

		Button button2 = new Button("Back");
		button2.setOnAction(e -> window.setScene(scene1));


		button3 = new Button("About");
		button3.setOnAction(e -> window.setScene(scene3));

		button4 = new Button("Creator");
		button4.setOnAction(e -> window.setScene(scene4));

		button5 = new Button("HowTo");
		button5.setOnAction(e -> window.setScene(scene5));

		////////Help Menu Buttons////////


		////////Help Menu Scene and Button Functions////////

		VBox layout2 = new VBox(30); //Help Menu
		layout2.getChildren().addAll(button2,button3,button4,button5);
		scene2 = new Scene(layout2, 400, 500);

		Button button2a = new Button("Back");
		button2a.setOnAction(e -> window.setScene(scene2));

		VBox layout3 = new VBox(30);
		layout3.getChildren().addAll(label2, button2a);//About
		scene3 = new Scene(layout3, 800, 500);

		Button button2b = new Button("Back");
		button2b.setOnAction(e -> window.setScene(scene2));

		VBox layout4 = new VBox(30);
		layout4.getChildren().addAll(label3, button2b);//Creator
		scene4 = new Scene(layout4, 800, 500);

		Button button2c = new Button("Back");
		button2c.setOnAction(e -> window.setScene(scene2));

		VBox layout5 = new VBox(30);
		layout5.getChildren().addAll(label4, button2c);//Howto
		scene5 = new Scene(layout5, 800, 500);

		////////Help Menu Scene and Button Functions////////






		window.setScene(scene2);
		window.setTitle("Help");
		window.show();


		window.setScene(scene1);
		window.setTitle("Player Recap System");
		window.show();


		TeamData(); //The List of the NBA Teams
		handleItemClicks(); //For clicking on Teams


		////////Client Messaging////////

		BorderPane paneForTextField = new BorderPane();
		Button btnSend = new Button("|>");
		paneForTextField.setPadding(new Insets(5, 5, 5, 5)); 
		paneForTextField.setStyle("-fx-border-color: green");
		paneForTextField.setRight(btnSend);

		TextField tf = new TextField();
		tf.setAlignment(Pos.BOTTOM_RIGHT);
		paneForTextField.setCenter(tf);

		BorderPane mainPane = new BorderPane();

		//Text area for display
		TextArea ta = new TextArea();
		mainPane.setTop(new ScrollPane(ta));
		mainPane.setCenter(paneForTextField);

		Button button10a = new Button("Back");
		button10a.setOnAction(e -> window.setScene(scene1));

		VBox layout10 = new VBox(30);
		layout10.getChildren().addAll(mainPane, button10a);
		scene10 = new Scene(layout10, 800, 500);



		tf.setOnAction(e -> {
			try {
				//Get the message from the text field
				String message = ta.getText().trim();

				//Send the message to the server
				toServer.writeBytes(message);
				toServer.flush();

				ta.setText("");

				//Display
				ta.appendText("client: " + message + "\n");


			}
			catch (IOException ex) {
				System.err.println(ex);
			}
		});

		try {
			//Socket to Connect to Server
			Socket socket = new Socket("localhost", 8000);


			//Input stream to receive data from the server
			fromServer = new DataInputStream( socket.getInputStream() );

			//Output stream to send data to the server
			toServer = new DataOutputStream( socket.getOutputStream() );

			new Thread(() -> {
				try{
					while(true){
						serverMessage = fromServer.readUTF();

						Platform.runLater( () -> {

							ta.appendText(serverMessage);

						});

					}
				}
				catch(IOException e){
					ta.appendText(e.toString() + "\n");
				}

			}).start();
		}
		catch (IOException ex) {
			ta.appendText(ex.toString() + '\n');
		}

		////////Client Messaging////////


		////////Starting Jersey Numbers////////
		//Tree//
		TreeItem<String> rootItem = new TreeItem<String> ("Starting Jersey");
		rootItem.setExpanded(true);
		for (int i = 1; i < 6; i++) {
			TreeItem<String> item = new TreeItem<String> ("Number" + " " + i);            
			rootItem.getChildren().add(item);
		} 
		TreeView<String> tree = new TreeView<String> (rootItem);        
		StackPane root = new StackPane();
		root.getChildren().add(tree);

		Button button11a = new Button("Back");
		button11a.setOnAction(e -> window.setScene(scene1));
		
		VBox layout11 = new VBox(30);
		layout11.getChildren().addAll(root, button11a);
		scene11 = new Scene(layout11, 800, 500);

		////////Starting Jersey Numbers////////

	}






	//Teams Menu//
	private void TeamData() {

		String[] ListData = 
			{
					"Atlanta Hawks", "Boston Celtics", "Brooklyn Nets", "Charlotte Hornets", "Chicago Bulls", "Cleveland Cavaliers", "Dallas Mavericks", "Denver Nuggets", "Detroit Pistons", "Golden State Warriors", "Houston Rockets", "Indiana Pacers", "Los Angeles Clippers", 
					"Los Angeles Lakers", "Memphis Grizzlies", "Miami Heat", "Milwaukee Bucks", "Minnesota Timberwolves", "New Orleans Pelicans", "New York Knicks", "Oklahoma City Thunder", "Orlando Magic", "Philadelphia 76ers", 
					"Phoenix Suns", "Portland Trail Blazers", "Sacramento Kings", "San Antonio Spurs", "Toronto Raptors", "Utah Jazz", "Washington Wizards",
			};
		for (String Team : ListData)
		{
			List.getItems().add(Team);
		}
	}


	//Team Click//
	private void handleItemClicks() {
		List.setOnMouseClicked(event -> {

			String selectedItem = List.getSelectionModel().getSelectedItem().toString();
		});
	}

	//Sorts the most efficiently for my code since it needs to sort the array in the simplest way possible alphabetically.
	//QuickSort
	private ArrayList<Integer> insertionSort (ArrayList<Integer> list) { 

		int i,j, key, temp;
		for (i=1;i<list.size(); i++) {
			key = list.get(i);
			j = i-1;
			while (j>=0&&key<list.get(j)) {
				temp=list.get(j);
				list.set(j, list.get(j+1));
				list.set(j+1, temp);
				j--;
			}
		}
		return list;
	}



	//	class TreeNode<E> {
	//		protected E element;
	//		protected TreeNode<E> left;
	//		protected TreeNode<E> right;
	//		
	//		public TreeNode(E e) {
	//			element = e;
	//		}
	//		
	//		TreeNode<Integer> root = new TreeNode<>(60);
	//		root.left = new TreeNode<>(55);
	//		root.right = new TreeNode<>(100);
	//	}
	//	
	//
	//
	//	public boolean search(E element) {
	//		TreeNode<E> current = root;
	//		
	//		while (current != null)
	//			if (element < current.element) {
	//				current = current.left;
	//			}
	//			else if (element > current.element) {
	//				current = current.right;
	//				}
	//			else 
	//				return true;
	//		return false;
	//			}


	//Add Button Clicked
	public void addButtonClicked(ActionEvent e) throws IOException{
		Player player = new Player();
		player.setFirstName(firstnameInput.getText());
		player.setLastName(lastnameInput.getText());
		player.setPosition(positionInput.getText());
		player.setFieldgoalPercentage(fieldgoalpercentageInput.getText());
		player.setPoints(pointsInput.getText());
		player.setAssists(assistsInput.getText());
		player.setRebounds(reboundsInput.getText());
		table.getItems().add(player);

		//Copies statistics of players to a text document called Stats.txt
		StringBuilder sb = new StringBuilder();
		sb.append(firstnameInput.getText().toString() + " "); 
		sb.append(lastnameInput.getText().toString() + " || ");
		sb.append(positionInput.getText().toString() + " || ");
		sb.append(fieldgoalpercentageInput.getText().toString() + "% || ");
		sb.append(pointsInput.getText().toString() + " P || ");
		sb.append(assistsInput.getText().toString() + " A || ");
		sb.append(reboundsInput.getText().toString() + " R || \n");

		File file = new File("Stats.txt");
		FileWriter W = new FileWriter(file, true);
		W.write(sb.toString());
		W.close();

		firstnameInput.clear();
		lastnameInput.clear();
		positionInput.clear();
		fieldgoalpercentageInput.clear();
		pointsInput.clear();
		assistsInput.clear();
		reboundsInput.clear();


	}




	//Delete Button Clicked
	public void deleteButtonClicked() {
		ObservableList<Player> playerSelected, allPlayers;
		allPlayers = table.getItems();
		playerSelected = table.getSelectionModel().getSelectedItems();

		playerSelected.forEach(allPlayers::remove);


	}









	//Manual Player Info
	public ObservableList<Player> getPlayer() {
		ObservableList<Player> players = FXCollections.observableArrayList();
		players.add(new Player());
		return players;

	}


	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub

	}
}

