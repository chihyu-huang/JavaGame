package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * <h1>Main Class</h1>
 *
 * @author : Chih-Yu Huang
 * @date : Dec, 2022
 */

public class Main extends Application {

    public Stage stage = new Stage();


    // number of players
    public static int players_number;

    // level of games
    public static int level;

    // name of each player
    public static String player1_name;
    public static String player2_name;
    public static String player3_name;
    public static String player4_name;


    // file path of leaderboard data
    public final String HIGH_SCORE_FILE_PATH = "src/main/java/sample/highScores.dat";
    public final String DATA_DELIMITER = "\\|";

    // list that store the top 10 high score
    public static HighScore[] highScoresLeaderboard = new HighScore[10];
    public final int HIGH_SCORES_COUNT = 10;



    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("game.fxml"));
        stage.setTitle("Hello!");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}