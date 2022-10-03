package view;

import java.io.File;

import javax.swing.text.html.Option;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.QuizType;

/**
 * Allows the user to start a game
 * @author Phil Ganem
 * @date 10/3/2022
 */
public class StartGame {

    QuizType quizType;
    String selectedDeck;
    
    public Scene StartGameScene(Stage stage) {
        VBox view = new VBox();
        VBox buttonBox = new VBox();  

        view.setStyle("-fx-background-color: #fcc332;");
        buttonBox.setStyle("-fx-alignment: center;" +
        "-fx-spacing: 25px;" +
        "-fx-padding: 50px;" +
        "-fx-color: #000000;" +
        "-fx-font-size: 40px;");

        //Menu of decks in data directory
        File folder = new File("data");
        File[] listOfFiles = folder.listFiles();
        
        for(File file : listOfFiles) {
            if(file.isFile()) {
                HBox deckBox = new HBox();
                String fileName = file.getName();
                Button selectDeck = new Button("Select");
                selectDeck.setOnAction((e) -> {
                    selectedDeck = fileName;
                    System.out.println(selectedDeck);
                });
                deckBox.getChildren().addAll(new Label(fileName), selectDeck);
                buttonBox.getChildren().add(deckBox);
            }
        }

        //Back to main menu
        Button back = new Button("Back");
        back.setOnAction((e) -> {
            MainMenu mainMenu = new MainMenu();
            stage.setScene(mainMenu.MainMenuScene(stage));
        });

        buttonBox.getChildren().add(back);
        view.getChildren().addAll(buttonBox);
        return new Scene(view, 750, 500);
    }
}
