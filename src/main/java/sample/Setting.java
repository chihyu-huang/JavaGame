package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * This is a final project of Java Programming at UCD.
 * We aim to make a simple game with some rules.
 *
 * @author : Chih-Yu Huang
 * @since : Dec, 2022
 */


/**
 * <h1>Starting page</h1>
 * <p>This page is used to set the number of players.</p>
 */

public class Setting extends Main implements Initializable{

    @FXML
    private Button nextButton;

    /**
     * make the parent root load the corresponding fxml file, so when the page starts,
     * it'll show the contents in the file.
     *
     * @param stage is a container
     * @throws IOException: there's chance cannot find the file, so we have to throw exception.
     */


    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("setting.fxml"));
        stage.setScene(new Scene(root));
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }


    /**
     * <b>on_click_P2()</b>
     * Set the number of players to 2 and enables next button, so it can keep going on.
     *
     * @throws IOException
     */

    @FXML
    public void on_click_P2(){
        setPlayersNumber(2);
        nextButton.setDisable(false);
        System.out.println("2 Players");
    }

    @FXML
    void on_click_P3(){
        setPlayersNumber(3);
        nextButton.setDisable(false);
        System.out.println("3 Players");
    }

    @FXML
    void on_click_P4(){
        setPlayersNumber(4);
        System.out.println("4 Players");
        nextButton.setDisable(false);
    }

    public void setPlayersNumber(int playersNumber){
        if(playersNumber >= 2 || playersNumber <=4){
            Main.players_number = playersNumber;
        } else {
            throw new IllegalArgumentException("Players number should between 2 and 4.");
        }

    }




    /**
     * to set the level of the game, the harder the game is, the more obstacles in the game
     */

    @FXML
    void easy(){
        level = 0;
        System.out.println("level: " + level);
    }

    @FXML
    void mid(){
        level = 1;
        System.out.println("level: " + level);
    }

    @FXML
    void hard(){
        level = 2;
        System.out.println("level: " + level);
    }

    /**
     * <b>nextButton</b>
     * push the button to open setName page
     * @throws IOException
     */


    @FXML
    void nextButton() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("setName.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
    }

    /**
     * <b>ruleButton</b>
     * push this button to open rule page
     * @throws IOException
     */

    @FXML
    void ruleButton() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("rule.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
    }

    /**
     * <b>scoreButton</b>
     * push this button to open leaderBoard(highScore) page
     * @throws IOException
     */

    @FXML
    void scoreButton() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("leaderBoard.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
    }

    /**
     * The next button only activates when the number of players have been set.
     * @param url
     * @param resourceBundle
     *
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nextButton.setDisable(true);
    }
}
