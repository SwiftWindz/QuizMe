package view;

import java.io.File;
import java.util.ArrayList;

import controller.LoadDeck;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Card;
import model.Deck;
import model.QuizType;

/**
 * Allows the user to start a game
 * @author Phil Ganem
 * @date 10/3/2022
 */
public class StartGame {

    QuizType quizType = QuizType.UNKNOWN;
    String selectedDeck = "Unknown";

    public Button selectFileButton(String fileName){
        Button selectDeck = new Button("Select");
        selectDeck.setOnAction((e) -> {
            if(selectedDeck.equals("Unknown")) {
                selectedDeck = fileName;
                System.out.println(selectedDeck);
                //change color to grey
                selectDeck.setStyle("-fx-background-color: #cccccc;");
            }
            else if (selectedDeck.equals(fileName)){
                selectedDeck = "Unknown";
                System.out.println(selectedDeck);
                //change color to black
                selectDeck.setStyle("-fx-background-color: #000000;");
            }
            else {return;}
        });
        return selectDeck;
    }

    public Button gameTypeButton(QuizType type){
        Button gameType = new Button(type.toString());
        gameType.setOnAction((e) -> {
            if(quizType == QuizType.UNKNOWN) {
                quizType = type;
                //change color to grey
                gameType.setStyle("-fx-background-color: #cccccc;");
            }
            else if (quizType == type){
                quizType = QuizType.UNKNOWN;
                //change color to black
                gameType.setStyle("-fx-background-color: #000000;");
            }
            else {return;}
            System.out.println(quizType);
        });
        return gameType;
    }
    
    public Scene StartGameScene(Stage stage) {
        VBox view = new VBox();
        VBox buttonBox = new VBox();
        VBox buttonBoxFileSelect = new VBox();  
        HBox buttonBoxGameType = new HBox();


        view.setStyle("-fx-background-color: #fcc332;");
        buttonBoxFileSelect.setStyle("-fx-alignment: center;" +
        "-fx-spacing: 25px;" +
        "-fx-padding: 50px;" +
        "-fx-color: #000000;" +
        "-fx-font-size: 40px;");
        buttonBoxGameType.setStyle("-fx-alignment: center;" +
        "-fx-spacing: 25px;" +
        "-fx-padding: 50px;" +
        "-fx-color: #000000;" +
        "-fx-font-size: 40px;");
        
        Label title = new Label("Select a deck to play");
        
        //Menu of decks in data directory
        File folder = new File("data");
        File[] listOfFiles = folder.listFiles();
        
        for(File file : listOfFiles) {
            if(file.isFile()) {
                HBox deckBox = new HBox();
                String fileName = file.getName();
                Button selectDeck = selectFileButton(fileName);
                deckBox.getChildren().addAll(new Label(fileName), selectDeck);
                buttonBoxFileSelect.getChildren().add(deckBox);
            }
        }
        
        //Game type
        Button Score = gameTypeButton(QuizType.SCORE);
        Button Note = gameTypeButton(QuizType.NOTE);

        //Start game
        Button start = new Button("Start");
        start.setOnAction((e) -> {
            if(selectedDeck == null || selectedDeck.equals("")) {
                return;
            }
            else {
                Deck deck = new Deck(new ArrayList<Card>());
                LoadDeck loadDeck = new LoadDeck(deck, quizType, selectedDeck);
                loadDeck.execute();
                switch(quizType) {
                    case SCORE:
                        Scene gameScene = new ScoreGame().scoreScene(stage, deck, 0);
                        stage.setScene(gameScene);
                        break;
                    case NOTE:
                        Scene noteScene = new NoteGame().noteScene(stage, deck);
                        stage.setScene(noteScene);
                        break;
                    default:
                        return;
                }
                // Game game = new Game(deck);
                // Game game = new Game();
                // stage.setScene(game.GameScene(stage, selectedDeck, quizType));
            }
        });

        //Back to main menu
        Button back = new Button("Back");
        back.setOnAction((e) -> {
            MainMenu mainMenu = new MainMenu();
            stage.setScene(mainMenu.MainMenuScene(stage));
        });

        buttonBoxGameType.getChildren().addAll(Score, Note);
        buttonBox.getChildren().addAll(buttonBoxFileSelect,buttonBoxGameType);
        view.getChildren().addAll(title, buttonBox, start, back);
        return new Scene(view, 750, 500);
    }
}
