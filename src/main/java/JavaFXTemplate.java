
import java.util.concurrent.TimeUnit;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class JavaFXTemplate extends Application {
	
	UserInterface UI = new UserInterface();
	int [] puzzlearray = UI.getPuzzle();
	
	Button startButton = new Button("Start");
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	//feel free to remove the starter code from this method
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setTitle("Welcome to JavaFX");
		
		
		BorderPane s = new BorderPane();
		Label welcome = new Label("Welcome to The\n AI 15 Puzzle");
		welcome.setFont(new Font("Times New Roman",50));
		
		GridPane grid = new GridPane();
		
		VBox v1 = new VBox();
		HBox h1 = new HBox();
		h1.getChildren().add(startButton);
		h1.setAlignment(Pos.CENTER);
		
		v1.getChildren().addAll(welcome,h1);
		v1.setSpacing(20);
		
		grid.add(v1, 0, 0);
		grid.setAlignment(Pos.CENTER);
		
		
		
		
		//Size of Grid 4 x 4 = 16
		GameButton [][]Board = new GameButton[4][4];
		GameButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16;
		
		//Initalize Buttons with ID's to go in Board
		b1 = new GameButton(1); b2 = new GameButton(2); b3 = new GameButton(3); b4 = new GameButton(4);
		b5 = new GameButton(5); b6 = new GameButton(6); b7 = new GameButton(7); b8 = new GameButton(8);
		b9 = new GameButton(9); b10 = new GameButton(10); b11 = new GameButton(11); b12 = new GameButton(12);
		b13 = new GameButton(13); b14 = new GameButton(14); b15 = new GameButton(15); b16 = new GameButton(16);
		
		Board[0][0] = b1; Board[0][1] = b2; Board[0][2] = b3; Board[0][3] = b4;
		Board[1][0] = b5; Board[1][1] = b6; Board[1][2] = b7; Board[1][3] = b8;
		Board[2][0] = b9; Board[2][1] = b10; Board[2][2] = b11; Board[2][3] = b12;
		Board[3][0] = b13; Board[3][1] = b14; Board[3][2] = b15; Board[3][3] = b16;
		
		GridPane gPane = new GridPane();
		
		gPane.add(b1,0,0); gPane.add(b2,1,0); gPane.add(b3,2,0); gPane.add(b4,3,0);
		gPane.add(b5,0,1); gPane.add(b6,1,1); gPane.add(b7,2,1); gPane.add(b8,3,1);
		gPane.add(b9,0,2); gPane.add(b10,1,2); gPane.add(b11,2,2); gPane.add(b12,3,2);
		gPane.add(b13,0,3); gPane.add(b14,1,3); gPane.add(b15,2,3); gPane.add(b16,3,3);
		
		b1.setPrefSize(50, 50);		
		b2.setPrefSize(50, 50);		
		b3.setPrefSize(50, 50);		
		b4.setPrefSize(50, 50);		
		b5.setPrefSize(50, 50);		
		b6.setPrefSize(50, 50);		
		b7.setPrefSize(50, 50);
		b8.setPrefSize(50, 50);		
		b9.setPrefSize(50, 50);		
		b10.setPrefSize(50, 50);	
		b11.setPrefSize(50, 50);	
		b12.setPrefSize(50, 50);	
		b13.setPrefSize(50, 50);	
		b14.setPrefSize(50, 50);	
		b15.setPrefSize(50, 50);	
		b16.setPrefSize(50, 50);
		

	    gPane.setAlignment(Pos.CENTER);
		
	    
	    
//		
//		Board[0][0].value = puzzlearray[0];		
//		Board[0][1].value = puzzlearray[1];
//		Board[0][2].value = puzzlearray[2];
//		Board[0][3].value = puzzlearray[3];
//		Board[1][0].value = puzzlearray[4];
//		Board[1][1].value = puzzlearray[5];
//		Board[1][2].value = puzzlearray[6];
//		Board[1][3].value = puzzlearray[7];
//		Board[2][0].value = puzzlearray[8];
//		Board[2][1].value = puzzlearray[9];
//		Board[2][2].value = puzzlearray[10];
//		Board[2][3].value = puzzlearray[11];
//		Board[3][0].value = puzzlearray[12];
//		Board[3][1].value = puzzlearray[13];
//		Board[3][2].value = puzzlearray[14];
//		Board[3][3].value = puzzlearray[15];
//		

//		Board[0][0].setText(Integer.toBinaryString(Board[0][0].value));
//		Board[0][1].setText(Integer.toBinaryString(Board[0][1].value));
//		Board[0][2].setText(Integer.toBinaryString(Board[0][2].value));
//		Board[0][3].setText(Integer.toBinaryString(Board[0][3].value));
//		Board[1][0].setText(Integer.toBinaryString(Board[1][0].value));
//		Board[1][1].setText(Integer.toBinaryString(Board[1][1].value));
//		Board[1][2].setText(Integer.toBinaryString(Board[1][2].value));
//		Board[1][3].setText(Integer.toBinaryString(Board[1][3].value));
//		Board[2][0].setText(Integer.toBinaryString(Board[2][0].value));
//		Board[2][1].setText(Integer.toBinaryString(Board[2][1].value));
//		Board[2][2].setText(Integer.toBinaryString(Board[2][2].value));
//		Board[2][3].setText(Integer.toBinaryString(Board[2][3].value));
//		Board[3][0].setText(Integer.toBinaryString(Board[3][0].value));
//		Board[3][1].setText(Integer.toBinaryString(Board[3][1].value));
//		Board[3][2].setText(Integer.toBinaryString(Board[3][2].value));
//		Board[3][3].setText(Integer.toBinaryString(Board[3][3].value));

		
		
//		Scene scene = new Scene(grid, 700,700);
//		primaryStage.setScene(scene);
//		primaryStage.show();
		
//		startButton.setOnAction(event->{
			
			
			
			b1.setText(Integer.toString(puzzlearray[0]));

			
			Scene scene2 = new Scene(gPane,700,700);
			primaryStage.setScene(scene2);
			primaryStage.show();
//		});

		
		Thread t = new Thread(()-> {A_IDS_A_15solver ids = new A_IDS_A_15solver();});
		t.start();

	}

}
