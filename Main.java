package frogger_pk;

//import java.io.File;
//import java.util.List;
//import javafx.scene.media.Media;
//import javafx.scene.media.MediaPlayer;
//import javafx.util.Duration;


import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;







/**
 * Main.java
 * 
 * This is the main class which will initialize all of components with data to run the javaFx application
 * 
 */
public class Main extends Application {

	// Attributes..
	private AnimationTimer timer;
	private MyStage background;
	private Scene scene;
	private Animal animal;
	private Stage primaryStage;
	private int level = 1;
	private BackgroundImage froggerback;
	private Scene start;
	private Scene operations;
	
	private Button startButton,helpButton,quitButton,backButton;
	
	/**
	 * It is the main entry of this application
	 * @param args  argument
	 */
	public static void main(String[] args) {

		launch(args);

	}

	/**
	 * This is the access modifier for all of the components and it will add them into the scene to start
	 * the game.
	 */
	@Override
	public void start(Stage primaryStage) {
try {
		this.primaryStage = primaryStage;
		startGame();
		 primaryStage.setResizable(false);  //disable resize
		 primaryStage.setTitle("Frogger");  //Title
		 primaryStage.getIcons().add(new Image("file:src/frogger_pk/FroggerIcon.png"));

		background = new MyStage();
		scene = new Scene(background, 520,610);		
		froggerback = new BackgroundImage(
				"file:src/frogger_pk/background.png");//background image for game screen
		background.start();
		

		// Start...
		primaryStage.show();

}catch(Exception e) {
	e.printStackTrace();
}
}

	/**
	 * It will show  each level on the game screen.
	 */
	private void showLevel() {
		//alert pop up window for showing levels number and instruction
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Level "+level+"!");
		alert.setContentText("Pass all obstacles to reach next level "+level);
		alert.show();
		
		background.clearAll();   //it will clear stage which is defined in world file
		
		animal = new Animal("file:src/frogger_pk/froggerUp.png");  //Image of frog
		background.add(froggerback);
	
		
		
		
		switch(level) {
		case 1:
			background.add(new End(230,45));  //End image
            animal.setLimit(1);               //limit of end
			
			//images of obstacles
			background.add(new Log("file:src/frogger_pk/log2.png", 100, 0, 115, 0.75));
			background.add(new Log("file:src/frogger_pk/log2.png", 100, 220, 115, 0.75));
			background.add(new Log("file:src/frogger_pk/log2.png", 100, 440, 115, 0.75));

			background.add(new Log("file:src/frogger_pk/logs.png", 150, 0, 180, -1));
			background.add(new Log("file:src/frogger_pk/logs.png", 150, 400, 180, -1));

			background.add(new Log("file:src/frogger_pk/log3.png", 80, 50, 210, 0.75));
			background.add(new Log("file:src/frogger_pk/log3.png", 80, 270, 210, 0.75));
			background.add(new Log("file:src/frogger_pk/log3.png", 80, 490, 210, 0.75));
			
			
			background.add(new Turtle(500, 240, -1, 90, 90));
			background.add(new Turtle(300, 240, -1, 90, 90));
			background.add(new WetTurtle(700, 240, -1, 90, 90));
			background.add(new WetTurtle(600, 140, -1, 90, 90));
			background.add(new WetTurtle(400, 140, -1, 90, 90));
			background.add(new WetTurtle(200, 140, -1, 90, 90));
			
			
			
			background.add(new Obstacle("file:src/frogger_pk/truck3.png", 0, 525, 1, 80, 80));
			background.add(new Obstacle("file:src/frogger_pk/truck3.png", 300, 525, 1, 80, 80));
			background.add(new Obstacle("file:src/frogger_pk/truck3.png", 600, 525, 1, 80, 80));
			
			
			background.add(new Obstacle("file:src/frogger_pk/car3.png", 100, 480, -1, 40, 40));
			background.add(new Obstacle("file:src/frogger_pk/car3.png", 250, 480, -1, 40, 40));
			background.add(new Obstacle("file:src/frogger_pk/car3.png", 400, 480, -1, 40, 40));

			
			
			
			background.add(new Obstacle("file:src/frogger_pk/Car.png", 0, 430, 1, 40, 40));
			background.add(new Obstacle("file:src/frogger_pk/Car.png", 150, 430, 1, 40, 40));
			background.add(new Obstacle("file:src/frogger_pk/car1Left.png", 500, 390, -1, 40, 40));
			
			
			
			
	
			
			
			break;
		case 2:
			
			// image of end
			background.add(new End(180,45));  
			background.add(new End(280,45));;
			
			// image of end
            animal.setLimit(2);              
			
			
			//images of obstacles
			background.add(new Log("file:src/frogger_pk/log2.png", 100, 0, 115, 0.75));
			background.add(new Log("file:src/frogger_pk/log2.png", 100, 220, 115, 0.75));
			background.add(new Log("file:src/frogger_pk/log2.png", 100, 440, 115, 0.75));

			background.add(new Log("file:src/frogger_pk/logs.png", 150, 0, 180, -2));
			background.add(new Log("file:src/frogger_pk/logs.png", 150, 400, 180, -2));

			background.add(new Log("file:src/frogger_pk/log3.png", 80, 50, 210, 0.75));
			background.add(new Log("file:src/frogger_pk/log3.png", 80, 270, 210, 0.75));
			background.add(new Log("file:src/frogger_pk/log3.png", 80, 490, 210, 0.75));
			
			
			background.add(new Turtle(500, 240, -1, 90, 90));
			background.add(new Turtle(300, 240, -1, 90, 90));
			background.add(new WetTurtle(700, 240, -1, 90, 90));
			background.add(new WetTurtle(600, 140, -1, 90, 90));
			background.add(new WetTurtle(400, 140, -1, 90, 90));
			background.add(new WetTurtle(200, 140, -1, 90, 90));
			
			
			
			background.add(new Obstacle("file:src/frogger_pk/truck3.png", 0, 525, 1, 80, 80));
			background.add(new Obstacle("file:src/frogger_pk/truck3.png", 300, 525, 1, 80, 80));
			background.add(new Obstacle("file:src/frogger_pk/truck3.png", 600, 525, 1, 80, 80));
			
			
			background.add(new Obstacle("file:src/frogger_pk/car3.png", 100, 480, -1, 40, 40));
			background.add(new Obstacle("file:src/frogger_pk/car3.png", 250, 480, -1, 40, 40));
			background.add(new Obstacle("file:src/frogger_pk/car3.png", 400, 480, -1, 40, 40));

			
			
			
			background.add(new Obstacle("file:src/frogger_pk/Car.png", 0, 430, 1, 40, 40));
			background.add(new Obstacle("file:src/frogger_pk/Car.png", 150, 430, 1, 40, 40));
			
			background.add(new Obstacle("file:src/frogger_pk/truck1Right.png", 400, 390, 1, 80, 80));
			
			background.add(new Obstacle("file:src/frogger_pk/car1Left.png", 500, 340, -5, 40, 40));
			
			
			
			
	
			
			break;
		case 3:
			// image of end
			background.add(new End(135 ,45));       
			background.add(new End(235,45));
			background.add(new End(335,45));
			
			// image of end
            animal.setLimit(3); 
            
            
			//Images of obstacles
			background.add(new Log("file:src/frogger_pk/log2.png", 100, 0, 115, 0.75));
			background.add(new Log("file:src/frogger_pk/log2.png", 100, 220, 115, 0.75));
			background.add(new Log("file:src/frogger_pk/log2.png", 100, 440, 115, 0.75));

			background.add(new Log("file:src/frogger_pk/logs.png", 150, 0, 180, -3));
			background.add(new Log("file:src/frogger_pk/logs.png", 150, 400, 180, -3));

			background.add(new Log("file:src/frogger_pk/log3.png", 80, 50, 210, 0.75));
			background.add(new Log("file:src/frogger_pk/log3.png", 80, 270, 210, 0.75));
			background.add(new Log("file:src/frogger_pk/log3.png", 80, 490, 210, 0.75));
			
			
			background.add(new Turtle(500, 240, -1, 90, 90));
			background.add(new Turtle(300, 240, -1, 90, 90));
			background.add(new WetTurtle(700, 240, -1, 90, 90));
			background.add(new WetTurtle(600, 140, -1, 90, 90));
			background.add(new WetTurtle(400, 140, -1, 90, 90));
			background.add(new WetTurtle(200, 140, -1, 90, 90));
			
			
			
			background.add(new Obstacle("file:src/frogger_pk/truck3.png", 0, 525, 1, 80, 80));
			background.add(new Obstacle("file:src/frogger_pk/truck3.png", 300, 525, 1, 80, 80));
			background.add(new Obstacle("file:src/frogger_pk/truck3.png", 600, 525, 1, 80, 80));
			
			
			background.add(new Obstacle("file:src/frogger_pk/car3.png", 100, 480, -1, 40, 40));
			background.add(new Obstacle("file:src/frogger_pk/car3.png", 250, 480, -1, 40, 40));
			background.add(new Obstacle("file:src/frogger_pk/car3.png", 400, 480, -1, 40, 40));

			
			
			
			background.add(new Obstacle("file:src/frogger_pk/car1Left.png", 500, 340, -1, 40, 40));
			
			background.add(new Obstacle("file:src/frogger_pk/truck1Right.png", 400, 390, 1, 80, 80));
			background.add(new Obstacle("file:src/frogger_pk/truck1Right.png", 500, 390, 1, 80, 80));
			
			background.add(new Obstacle("file:src/frogger_pk/Car.png", 0, 430, 5, 40, 40));
			background.add(new Obstacle("file:src/frogger_pk/Car.png", 150, 430, 5, 40, 40));
			
			
			
			
			break;
		case 4:
			//image of end
			background.add(new End(80 ,45));
			background.add(new End(180,45));
			background.add(new End(280,45));
			background.add(new End(380,45));
			
			//limit of end
            animal.setLimit(4);
			
			//images of obstacles
			background.add(new Log("file:src/frogger_pk/log2.png", 100, 0, 115, 0.75));
			background.add(new Log("file:src/frogger_pk/log2.png", 100, 220, 115, 0.75));
			background.add(new Log("file:src/frogger_pk/log2.png", 100, 440, 115, 0.75));

			background.add(new Log("file:src/frogger_pk/logs.png", 150, 0, 180, -3));
			background.add(new Log("file:src/frogger_pk/logs.png", 150, 400, 180, -3));

			background.add(new Log("file:src/frogger_pk/log3.png", 80, 50, 210, 0.75));
			background.add(new Log("file:src/frogger_pk/log3.png", 80, 270, 210, 0.75));
			background.add(new Log("file:src/frogger_pk/log3.png", 80, 490, 210, 0.75));
			
			
			background.add(new Turtle(500, 240, -1, 90, 90));
			background.add(new Turtle(300, 240, -1, 90, 90));
			background.add(new WetTurtle(700, 240, -1, 90, 90));
			background.add(new WetTurtle(600, 140, -1, 90, 90));
			background.add(new WetTurtle(400, 140, -1, 90, 90));
			background.add(new WetTurtle(200, 140, -1, 90, 90));
			
			
			
			background.add(new Obstacle("file:src/frogger_pk/truck3.png", 0, 525, 1, 80, 80));
			background.add(new Obstacle("file:src/frogger_pk/truck3.png", 300, 525, 1, 80, 80));
			background.add(new Obstacle("file:src/frogger_pk/truck3.png", 600, 525, 1, 80, 80));
			
			
			background.add(new Obstacle("file:src/frogger_pk/car3.png", 100, 480, -1, 40, 40));
			background.add(new Obstacle("file:src/frogger_pk/car3.png", 250, 480, -1, 40, 40));
			background.add(new Obstacle("file:src/frogger_pk/car3.png", 400, 480, -1, 40, 40));

			
			
			
			background.add(new Obstacle("file:src/frogger_pk/Car.png", 0, 430, 5, 40, 40));
			background.add(new Obstacle("file:src/frogger_pk/Car.png", 150, 430, 5, 40, 40));
			
			background.add(new Obstacle("file:src/frogger_pk/truck1Right.png", 400, 390, 1, 80, 80));
			background.add(new Obstacle("file:src/frogger_pk/truck1Right.png", 500, 390, 1, 80, 80));
			
			background.add(new Obstacle("file:src/frogger_pk/car1Left.png", 500, 340, -5, 40, 40));
			background.add(new Obstacle("file:src/frogger_pk/car1Left.png", 650, 340, -5, 40, 40));
			
			
			break;
		case 5:
			//image of end
			background.add(new End(30 ,45));
			background.add(new End(130,45));
			background.add(new End(230,45));
			background.add(new End(330,45));
			background.add(new End(430,45));
			
			//limit of end
            animal.setLimit(5);
            
            
			//images of obstacles
			background.add(new Log("file:src/frogger_pk/log2.png", 100, 0, 115, 0.75));
			background.add(new Log("file:src/frogger_pk/log2.png", 100, 220, 115, 0.75));
			background.add(new Log("file:src/frogger_pk/log2.png", 100, 440, 115, 0.75));

			background.add(new Log("file:src/frogger_pk/logs.png", 150, 0, 180, -2));
			background.add(new Log("file:src/frogger_pk/logs.png", 150, 400, 180, -2));

			background.add(new Log("file:src/frogger_pk/log3.png", 80, 50, 210, 0.75));
			background.add(new Log("file:src/frogger_pk/log3.png", 80, 270, 210, 0.75));
			background.add(new Log("file:src/frogger_pk/log3.png", 80, 490, 210, 0.75));
			
			
			background.add(new Turtle(500, 240, -2, 90, 90));
			background.add(new Turtle(300, 240, -2, 90, 90));
			background.add(new WetTurtle(700, 240, -2, 90, 90));
			background.add(new Turtle(600, 140, -1, 90, 90));
			background.add(new Turtle(400, 140, -1, 90, 90));
			background.add(new WetTurtle(200, 140, -1, 90, 90));
			
			
			
			background.add(new Obstacle("file:src/frogger_pk/truck3.png", 0, 525, 1, 80, 80));
			background.add(new Obstacle("file:src/frogger_pk/truck3.png", 300, 525, 1, 80, 80));
			background.add(new Obstacle("file:src/frogger_pk/truck3.png", 600, 525, 1, 80, 80));
			
			
			background.add(new Obstacle("file:src/frogger_pk/car3.png", 100, 480, -5, 40, 40));
			background.add(new Obstacle("file:src/frogger_pk/car3.png", 250, 480, -5, 40, 40));
			background.add(new Obstacle("file:src/frogger_pk/car3.png", 400, 480, -5, 40, 40));

			
			
			background.add(new Obstacle("file:src/frogger_pk/Car.png", 0,  340, 3, 40, 40));
			background.add(new Obstacle("file:src/frogger_pk/Car.png", 150,  340, 3, 40, 40));
			
			background.add(new Obstacle("file:src/frogger_pk/truck1Right.png", 400, 390, 2, 80, 80));
			background.add(new Obstacle("file:src/frogger_pk/truck1Right.png", 500, 390, 2, 80, 80));
			
			
			background.add(new Obstacle("file:src/frogger_pk/car1Left.png", 500, 430, -3, 40, 40));
			
			
			
			break;
		
		}
		
		
		background.add(animal);
		//It will show the menu button on game screen for going back to menu screen
		backButton = new Button("Menu");
		backButton.setStyle("-fx-background-color:#004080; -fx-text-fill: white; -fx-font: 15 arial;");
		backButton.setLayoutX(10);
		backButton.setLayoutY(4);
		backButton.setPrefWidth(60);
		backButton.setPrefHeight(5);
		background.getChildren().add(backButton);
		
		
		
		 backButton.setOnAction(ae-> {
			    primaryStage.close();
				background.stopMusic();
				stop();
			    Platform.runLater( () -> new Main().start( new Stage() ) );
               
});
		 
		//button for exit screen
		 quitButton = new Button("Quit");
		 quitButton.setStyle("-fx-background-color:#004080; -fx-text-fill: white; -fx-font: 15 arial;");
		 quitButton.setLayoutX(75);
		 quitButton.setLayoutY(4);
		 quitButton.setPrefWidth(50);
		 quitButton.setPrefHeight(0);
	//Action 	
		 quitButton.setOnAction(ae-> {
			primaryStage.close();
		});
		
		 background.getChildren().add(quitButton);
		 
		
			
	//Score label
	    Label label = new Label("Scores:  ");
		label.setLayoutX(340);
		label.setLayoutY(10);
		label.setPrefWidth(100);
		label.setPrefHeight(0);
		label.setWrapText(true);
		
		label.setStyle("-fx-text-fill: white;-fx-font: 20 arial");
		label.setAlignment(Pos.CENTER);
		background.getChildren().add(label);
		
		
	}
		
	/**
	 * It will show the Menu screen 
	 */
	private void startGame() {
		
		Group group = new Group();
		// Start scene.
		start = new Scene(group, 540,610);
		ImageView background = new ImageView();
		background.setImage(new Image("file:src/frogger_pk/Frogger.png", 610,610, true, true));
		background.setX(0);
		background.setY(0);
		group.getChildren().add(background);
		
		// Button to start the game.
		startButton = new Button("Start Game");
		startButton.setStyle("-fx-background-color: #004080; -fx-text-fill: white; -fx-font: 25 arial;");
		startButton.setLayoutX(20);
		startButton.setLayoutY(380);
		startButton.setPrefWidth(180);
		startButton.setPrefHeight(50);
		
		//Action to start the Game
		startButton.setOnAction(ae-> {
				showLevel();
				primaryStage.setScene(scene);
				start();

});
		
		group.getChildren().add(startButton);    
	    primaryStage.setScene(start);
           
           
		
		 // Help Button for game operations
		 
		helpButton = new Button("Help");
		helpButton.setStyle("-fx-background-color: #004080; -fx-text-fill: white; -fx-font: 27 arial;");
		helpButton.setLayoutX(20);
		helpButton.setLayoutY(435);
		helpButton.setPrefWidth(130);
		helpButton.setPrefHeight(50);
		
		//Action for opening new screen
		helpButton.setOnAction(new EventHandler<ActionEvent>() {
/**
 * It will show the game operations on the screen by clicking on help button
 */
			@Override
			public void handle(ActionEvent arg0) {
				

				Group group=new Group();
				operations=new Scene(group,520,610);
				{
					
					ImageView background = new ImageView();
					background.setImage(new Image("file:src/frogger_pk/background.png", 520,630, true, true));
					background.setX(0);
					background.setY(0);
					group.getChildren().add(background);
					
				   Label label = new Label("************************Game operations**************************\n\n"
						   +"1.Use arrow keys to move frogger\n\n "
							              +"2.Avoid to interact with obstacles,otherwise you will loose your life\n\n"
							              +"3.Pass all obstacles to reach next level of the game\n\n"
							              +"4.Pass all levels to win the game\n\n");
					label.setLayoutX(75);
					label.setLayoutY(210);
					label.setPrefWidth(365);
					label.setPrefHeight(200);
					label.setWrapText(true);
					
					label.setStyle("-fx-background-color: black; -fx-text-fill: white;");
					label.setAlignment(Pos.CENTER);
					group.getChildren().add(label);
					
					
		
		
				backButton = new Button("Go back to Menu");
				backButton.setStyle("-fx-background-color: #004080; -fx-text-fill: white; -fx-font: 25 arial;");
				backButton.setLayoutX(140);
				backButton.setLayoutY(415);
				backButton.setPrefWidth(250);
				backButton.setPrefHeight(50);
				group.getChildren().add(backButton);
				
				
				
				 backButton.setOnAction(ae-> {
				 primaryStage.setScene(start);
						
		});
				
	}
				primaryStage.setScene(operations);

		
			
}
			
		});		
		
		
		group.getChildren().add(helpButton);
		
		
		//button for exit screen
		 quitButton = new Button("Quit");
		 quitButton.setStyle("-fx-background-color: #004080; -fx-text-fill: white; -fx-font: 25 arial;");
		 quitButton.setLayoutX(20);
		 quitButton.setLayoutY(490);
		 quitButton.setPrefWidth(120);
		 quitButton.setPrefHeight(50);
	//Action 	
		 quitButton.setOnAction(ae-> {
			primaryStage.close();
		});
		
		 group.getChildren().add(quitButton);
		 
		 
		 
		  
		
		
}
	
	

	/**
	 *  This is method of creating timer which will run continuously unless you won the game
	 */
	public void createTimer() {

		timer = new AnimationTimer() {
			@Override
			public void handle(long now) {
				if (animal.changeScore()) {
					setNumber(animal.getPoints());
				}
				if (animal.getStop()) {
					if(level == 5) {
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("You Have Won The Game!");
						alert.setContentText("Your High Score: " + animal.getPoints() + "!");
						alert.show();
						background.stopMusic();
						stop();
						background.stop();
					} else {
						level++;
						showLevel();
					}
				}
			}
		};

	}

	/**
	 * it will start timer and music
	 */
	public void start() {

		background.playMusic();
		createTimer();
		timer.start();

	}

	/**
	 * this is for stopping timer.
	 */
	public void stop() {

		timer.stop();

	}

	/**
	 * It will show the scores on the game screen.
	 * 
	 * @param n is for number to show
	 */
	public void setNumber(int n) {
		
		
		for (int shift=0; n > 0; shift+=30) {
			int d = n / 10;
			int k = n - d * 10;
			n = d;
			background.add(new Digit(k, 28, 480 - shift, 8));
			
		}
	
	}
	
}

//public void setNumber(int n) {
	//int shift = 0;
	//while (n > 0) {
		  //int d = n / 10;
		 // int k = n - d * 10;
		 // n = d;
		 // background.add(new Digit(k, 30, 360 - shift, 25));
		 // shift+=30;
		//}
//}
//}
