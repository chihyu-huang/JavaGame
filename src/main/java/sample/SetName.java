package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * <h1>SetName page</h1>
 * <p>This page is used to let user to set names of players in this game.</p>
 */

public class SetName extends Main implements Initializable {

    /**
     * These label and text field are defined in the fxml file,
     */
    @FXML
    private javafx.scene.control.Label playerNameLabel1;
    @FXML
    private javafx.scene.control.Label playerNameLabel2;
    @FXML
    private javafx.scene.control.Label playerNameLabel3;
    @FXML
    private javafx.scene.control.Label playerNameLabel4;

    @FXML
    private javafx.scene.control.TextField player1_name;
    @FXML
    private javafx.scene.control.TextField player2_name;

    @FXML
    private javafx.scene.control.TextField player3_name;
    @FXML
    private javafx.scene.control.TextField player4_name;


    public int players_number;


    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("setName.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    /**
     * Inherit the number of players from main class to decide how many columns to show by calling the
     * function name <b>Num_Name_Field</b>.
     *
     * @param location
     * @param arg
     *
     */

    @Override
    public void initialize(URL location, ResourceBundle arg) {
        players_number = Main.players_number;
        Num_Name_Field(players_number);
    }

    /**
     * <b>Num_Name_Field</b>
     * Decide which label and text field to show by the number of players.
     *
     * @param number_of_players : from main class
     * e.g. If the number of players is 2, then it'll only show two line(name label and text field) to
     * let user enter information(name). So label and text field 3,4 have to been set as invisible.
     */

    void Num_Name_Field(int number_of_players) {
        switch (number_of_players) {
            case 2:
                playerNameLabel3.setVisible(false);
                player3_name.setVisible(false);

                playerNameLabel4.setVisible(false);
                player4_name.setVisible(false);
                break;
            case 3:
                playerNameLabel4.setVisible(false);
                player4_name.setVisible(false);
                break;
            default:
                break;
        }
    }

    /**
     * <b>startButton</b>
     * When user finish typing their names in and hit the start button,
     * define the corresponding player name in Main class.
     * Then open the game.fxml page(Main game page)
     *
     * @throws IOException
     * e.g. if user put "A" in the player1 text field (player1_name) after the player1 label(layerNameLabel1),
     *      then the variable "player1_name" in Main class will be set to "A".
     *      if user put "B" in the player2 text field (player2_name) after the player2 label(layerNameLabel2),
     *      then the variable "player2_name" in Main class will be set to "B" and so on.
     */

    @FXML
    void startButton() throws IOException {
        Main.player1_name = player1_name.getText();
        Main.player2_name = player2_name.getText();
        Main.player3_name = player3_name.getText();
        Main.player4_name = player4_name.getText();
        Parent root = FXMLLoader.load(getClass().getResource("game.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
    }

}
