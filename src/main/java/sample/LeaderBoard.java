package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * <h1>LeaderBoard</h1>
 * This page shows the top 10 record of this game.
 *
 * @author : Chih-Yu Huang
 * @since : Dec, 2022
 */


public class LeaderBoard extends Main implements Initializable {

    // name and score label
    @FXML
    private javafx.scene.control.Label name1;
    @FXML
    private javafx.scene.control.Label name2;
    @FXML
    private javafx.scene.control.Label name3;
    @FXML
    private javafx.scene.control.Label name4;
    @FXML
    private javafx.scene.control.Label name5;
    @FXML
    private javafx.scene.control.Label name6;
    @FXML
    private javafx.scene.control.Label name7;
    @FXML
    private javafx.scene.control.Label name8;
    @FXML
    private javafx.scene.control.Label name9;
    @FXML
    private javafx.scene.control.Label name10;
    @FXML
    private javafx.scene.control.Label score1;
    @FXML
    private javafx.scene.control.Label score2;
    @FXML
    private javafx.scene.control.Label score3;
    @FXML
    private javafx.scene.control.Label score4;
    @FXML
    private javafx.scene.control.Label score5;
    @FXML
    private javafx.scene.control.Label score6;
    @FXML
    private javafx.scene.control.Label score7;
    @FXML
    private javafx.scene.control.Label score8;
    @FXML
    private javafx.scene.control.Label score9;
    @FXML
    private javafx.scene.control.Label score10;


    /**
     * Load the data from dat file, and show it
     * @param url
     * @param resourceBundle
     */

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            loadHighScore();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void start (Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("leaderBoard.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
    }

    public static void main (String[]args){
        launch();
    }


    /**
     * <b>loadHighScore</b>
     * Load the data from dat file and distinguish which is name and score and show it on the view
     *
     * @throws IOException
     */
    public void loadHighScore() throws IOException{

        File highScoreFile = new File(HIGH_SCORE_FILE_PATH);

        Scanner fileReader = new Scanner(highScoreFile);

        int totalLinesRead = 0;
        String highScoreLine;
        String[] lineTokens;

        while (fileReader.hasNextLine() && totalLinesRead < HIGH_SCORES_COUNT)
        {
            highScoreLine = fileReader.nextLine();

            lineTokens = highScoreLine.split(DATA_DELIMITER);

            if(lineTokens[0] == ""){
                lineTokens[0] = "-";
            }
            if (Integer.parseInt(lineTokens[1]) == 1000){
                lineTokens[1] = "-";
            }
            switch (totalLinesRead){
                case 0:
                    name1.setText(lineTokens[0]);
                    score1.setText(lineTokens[1]);
                    break;
                case 1:
                    name2.setText(lineTokens[0]);
                    score2.setText(lineTokens[1]);
                    break;
                case 2:
                    name3.setText(lineTokens[0]);
                    score3.setText(lineTokens[1]);
                    break;
                case 3:
                    name4.setText(lineTokens[0]);
                    score4.setText(lineTokens[1]);
                    break;
                case 4:
                    name5.setText(lineTokens[0]);
                    score5.setText(lineTokens[1]);
                    break;
                case 5:
                    name6.setText(lineTokens[0]);
                    score6.setText(lineTokens[1]);
                    break;
                case 6:
                    name7.setText(lineTokens[0]);
                    score7.setText(lineTokens[1]);
                    break;
                case 7:
                    name8.setText(lineTokens[0]);
                    score8.setText(lineTokens[1]);
                    break;
                case 8:
                    name9.setText(lineTokens[0]);
                    score9.setText(lineTokens[1]);
                    break;
                case 9:
                    name10.setText(lineTokens[0]);
                    score10.setText(lineTokens[1]);
                    break;
            }
            totalLinesRead++;
        }
        fileReader.close();
    }

    /**
     * <b>playAgain</b>
     * back to the main game page
     * @throws IOException
     */

    @FXML
    void playAgain() throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("game.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
    }



}

