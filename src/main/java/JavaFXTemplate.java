
import java.util.concurrent.TimeUnit;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class JavaFXTemplate extends Application {
	
//	UserInterface UI = new UserInterface();
	int [] puzzlearray;
	int [] solnarray = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
	Boolean checkcond;
	Button startButton = new Button("Start");
    Button heu1 = new Button("Heuristic One");
    Button heu2 = new Button("HeuristicTwo");
    
    EventHandler<ActionEvent> move;
    
	UserInterface UI = new UserInterface();
	DropShadow shadow = new DropShadow();

	
	//Size of Grid 4 x 4 = 16
	GameButton [][]Board = new GameButton[4][4];
    GameButton []buttons = new GameButton[16];
	
	public void eventHandle(GameButton button) {
		
		if(button.value == 0) {
			return;
		}
		
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				if(button.value != 0 && button.value == Board[i][j].value) {
					
					//check for zero on top and move up
					if(i-1 >= 0) {
						if(Board[i-1][j].value == 0) {
							int temp = Board[i][j].value;
							Board[i-1][j].value = temp;
							Board[i][j].value = 0;
						
							Board[i-1][j].setText(Integer.toString(Board[i-1][j].value));
							Board[i][j].setText("");
							break;
						}
					}
					
					//Check for zero on left and move right
					if(j -1 >= 0) {
						if(Board[i][j-1].value == 0) {
							int temp = Board[i][j].value;
							Board[i][j-1].value = temp;
							Board[i][j].value = 0;
						
							Board[i][j-1].setText(Integer.toString(Board[i][j-1].value));
							Board[i][j].setText("");
							break;
						}
					}
					
					//Check if zero on right and move left
					if(j + 1 <= 3) {
						if(Board[i][j+1].value == 0) {
							int temp = Board[i][j].value;
							Board[i][j+1].value = temp;
							Board[i][j].value = 0;
						
							Board[i][j+1].setText(Integer.toString(Board[i][j+1].value));
							Board[i][j].setText("");
							break;
						}
					}
					
					//Check if zero below and move down
					if(i + 1 <= 3) {
						if(Board[i+1][j].value == 0) {
							int temp = Board[i][j].value;
							Board[i+1][j].value = temp;
							Board[i][j].value = 0;
						
							Board[i+1][j].setText(Integer.toString(Board[i+1][j].value));
							Board[i][j].setText("");
							break;
						}
					}
					
				}
			}
		}
		
	}
	
	
	
	
	
	
	
	
	
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
		
		
		
		
		//Initalize Buttons with ID's to go in Board
		
		for(int i=0;i<buttons.length;i++) {
			buttons[i] = new GameButton(i);
		}
		
		
		GridPane gPane = new GridPane();
		
		gPane.add(buttons[0],0,0); gPane.add(buttons[1],1,0); gPane.add(buttons[2],2,0); gPane.add(buttons[3],3,0);
		gPane.add(buttons[4],0,1); gPane.add(buttons[5],1,1); gPane.add(buttons[6],2,1); gPane.add(buttons[7],3,1);
		gPane.add(buttons[8],0,2); gPane.add(buttons[9],1,2); gPane.add(buttons[10],2,2); gPane.add(buttons[11],3,2);
		gPane.add(buttons[12],0,3); gPane.add(buttons[13],1,3); gPane.add(buttons[14],2,3); gPane.add(buttons[15],3,3);
		
	
		for(int i=0;i<buttons.length;i++) {
			buttons[i].setPrefSize(50, 50);
		}
						

	    gPane.setAlignment(Pos.CENTER);
		
	    HBox gameScene = new HBox();

	    gameScene.getChildren().addAll(heu1,heu2);
	    gameScene.setSpacing(30);
	    gameScene.setAlignment(Pos.CENTER);
	    
	    VBox vb1 = new VBox();
	    vb1.getChildren().addAll(gPane,gameScene);
	    vb1.setSpacing(70);
	    
	    vb1.setAlignment(Pos.CENTER);
	    
			
		Scene scene = new Scene(grid, 700,700);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		Thread t = new Thread(()->{
			
			
			puzzlearray = UI.getPuzzle();

			
			for(int i=0;i<puzzlearray.length;i++) {
				buttons[i].setText(Integer.toString(puzzlearray[i]));
				buttons[i].value = puzzlearray[i];
			}
			
			for(int i=0;i<buttons.length;i++) {
				if(buttons[i].value == 0) {
					buttons[i].setText("");
				}
			}
			
			
			
			Board[0][0] = buttons[0]; Board[0][1] = buttons[1]; Board[0][2] = buttons[2]; Board[0][3] = buttons[3];
			Board[1][0] = buttons[4]; Board[1][1] = buttons[5]; Board[1][2] = buttons[6]; Board[1][3] = buttons[7];
			Board[2][0] = buttons[8]; Board[2][1] = buttons[9]; Board[2][2] = buttons[10]; Board[2][3] = buttons[11];
			Board[3][0] = buttons[12]; Board[3][1] = buttons[13]; Board[3][2] = buttons[14]; Board[3][3] = buttons[15];
		
			
		});
		t.start();
		

		

		
		buttons[0].setOnAction(event->{eventHandle(buttons[0]);});
		buttons[1].setOnAction(event->{eventHandle(buttons[1]);});
		buttons[2].setOnAction(event->{eventHandle(buttons[2]);});
		buttons[3].setOnAction(event->{eventHandle(buttons[3]);});
		buttons[4].setOnAction(event->{eventHandle(buttons[4]);});
		buttons[5].setOnAction(event->{eventHandle(buttons[5]);});
		buttons[6].setOnAction(event->{eventHandle(buttons[6]);});
		buttons[7].setOnAction(event->{eventHandle(buttons[7]);});
		buttons[8].setOnAction(event->{eventHandle(buttons[8]);});
		buttons[9].setOnAction(event->{eventHandle(buttons[9]);});
		buttons[10].setOnAction(event->{eventHandle(buttons[10]);});
		buttons[11].setOnAction(event->{eventHandle(buttons[11]);});
		buttons[12].setOnAction(event->{eventHandle(buttons[12]);});
		buttons[13].setOnAction(event->{eventHandle(buttons[13]);});
		buttons[14].setOnAction(event->{eventHandle(buttons[14]);});
		buttons[15].setOnAction(event->{eventHandle(buttons[15]);});


		for(int i=0;i<solnarray.length;i++) {
			
			if(solnarray[i]!=buttons[i].value) {
				checkcond = false;
				break;
			}
			
			checkcond = true;
		}
		
		if(checkcond == true) {
			
			Label newLabel2 = new Label("GAME WON");
			newLabel2.setFont(new Font("Times New Roman",50));
			
			VBox vb3 = new VBox();
			vb3.getChildren().add(newLabel2);
			vb3.setAlignment(Pos.CENTER);
			
			Scene scene3 = new Scene(vb3,700,700);
			primaryStage.setScene(scene3);
			primaryStage.show();
			
			
			System.out.println("GAME WON !!");
		}
		
		startButton.setOnAction(event->{
			
// 0 14 13 12 15 9 5 8 11 7 4 1 3 10 6 2
// 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 
									
			Scene scene2 = new Scene(vb1,700,700);
			primaryStage.setScene(scene2);
			primaryStage.show();
			
		});
		
		heu1.setOnAction(event->{
			
			A_IDS_A_15solver solver = new  A_IDS_A_15solver();
			
			Node newState = new Node(UI.getPuzzle());
			newState.setDepth(0);
			
			solver.A_Star(newState,"heuristicOne");
			
			System.out.println("\nThanks for using me to solve your 15 puzzle......Goodbye");	
			
		});
		
		
		heu2.setOnAction(event->{
			
			A_IDS_A_15solver solver = new  A_IDS_A_15solver();
			
			Node newState = new Node(UI.getPuzzle());
			newState.setDepth(0);
			
			solver.A_Star(newState,"heuristicTwo");
			
			System.out.println("\nThanks for using me to solve your 15 puzzle......Goodbye");	
			
		});
		


	}

}
