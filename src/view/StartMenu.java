package view;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * The opening menu of the application
 * @author Phil Ganem
 * @date 10/3/2022
 */
public class StartMenu {

    public Scene StartMenuScene(Stage stage) {
        VBox view = new VBox();
        HBox titlebox = new HBox();
        VBox buttonbox = new VBox();
        
        //change background color to yellow
        view.setStyle("-fx-background-color: #fcc332;");
        //change button color to black
        buttonbox.setStyle("-fx-alignment: center;" +
                            "-fx-spacing: 25px;" +
                            "-fx-padding: 50px;" +
                            "-fx-color: #000000;" +
                            "-fx-font-size: 40px;");

        // Title
        Label title = new Label("QuizMe!");
        title.setStyle("-fx-font-size: 75px;" +
                        "-fx-font-family: 'Arial';" + "-fx-text-fill: #000000;" +
                        "-fx-font-weight: bold;" +
                        "-fx-alignment: center;" +
                        "-fx-padding: 50px;");
        // buttons
        //Brings the user to the main menu
        Button start = new Button("Start");
        start.setOnAction((e) -> {
            MainMenu mainMenu = new MainMenu();
            stage.setScene(mainMenu.MainMenuScene(stage));
            
        });
        //Exits the program
        Button exit = new Button("Exit");
        exit.setOnAction((e) -> {
            Platform.exit();
        });

        //Adding to view
        titlebox.getChildren().add(title);
        titlebox.setStyle("-fx-alignment: center;");
        buttonbox.getChildren().addAll(start, exit);
        view.getChildren().addAll(titlebox, buttonbox);

        return new Scene(view, 750, 500);
    }
}
