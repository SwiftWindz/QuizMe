package view;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * The main GUI class
 * @author Phil Ganem
 * @date 9/23/2022
 */
public class GUI extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("QuizMe!");
        StartMenu startMenu = new StartMenu();
        primaryStage.setScene(startMenu.StartMenuScene());
        primaryStage.show();
    }
}
    

