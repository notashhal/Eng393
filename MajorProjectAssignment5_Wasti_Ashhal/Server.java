import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TextField;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
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
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;

public class Server extends Application {

    private TextField tf = new TextField();
    private ServerSocket serverSocket;
    private Socket socket;
    private DataInputStream input ;
    private DataOutputStream output;
    
    
    TextArea ta = new TextArea();

    @Override 
    public void start(Stage primaryStage) {


        //Server Socket
        BorderPane borderPaneForText = new BorderPane();
        Button btnSend = new Button("|>");
        btnSend.setOnAction( e-> {

            Platform.runLater( () -> {
                try{

                    output.writeUTF(tf.getText());
                    showMessage("server: " + tf.getText() + "\n");

                }
                catch(IOException ex){
                    ex.printStackTrace();
                }
            });
        });

        tf.setAlignment(Pos.BOTTOM_RIGHT);

        borderPaneForText.setCenter(tf);
        borderPaneForText.setRight(btnSend);
        borderPaneForText.setPadding( new Insets( 5, 5, 5, 5) );

        BorderPane mainPane = new BorderPane();
        mainPane.setTop(new ScrollPane(ta));
        mainPane.setCenter(borderPaneForText);

        
        Scene scene = new Scene(mainPane, 450, 270);
        primaryStage.setTitle("Server"); 
        primaryStage.setScene(scene);
        primaryStage.show();

        ta.setEditable(false);
        new Thread( () -> {
            try {
                
                serverSocket = new ServerSocket(8000);
                Platform.runLater(() ->
                        ta.appendText("Server started at " + new Date() + '\n'));

                
                Socket socket = serverSocket.accept();

                
                input = new DataInputStream( socket.getInputStream() ); //Input Data
                output = new DataOutputStream(socket.getOutputStream()); //Output Data

                while (true) {
                    
                    String message = input.readUTF();

                    output.writeUTF(message);
                    Platform.runLater(() -> {
                        ta.appendText("Client: " + message + "\n");
                    });
                }
            }
            catch(IOException ex) {
                ex.printStackTrace();
            }
        }).start();
    }

    /**
     * The main method is only needed for the IDE with limited
     * JavaFX support. Not needed for running from the command line.
     */
    public static void main(String[] args) {
        launch(args);
    }




    public void showMessage(String message){

        Platform.runLater( () -> {
            ta.appendText(message);

        });
    }



}