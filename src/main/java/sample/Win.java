package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static sample.Game.count;

/**
 * <h1>Win Page</h1>
 * This is the page when a player reaches the finish line and win the game.
 *
 * This page handles the leader board data.
 * @author : Chih-Yu Huang
 * @since : Dec, 2022
 */

public class Win extends Main implements Initializable {

    int player;
    String winner;
    int winnerScore;


    @FXML
    private javafx.scene.control.Label winnerName;
    @FXML
    private javafx.scene.control.Label scoreNum;


    /**
     * <b>updateHighScore</b>
     * @param rank
     * @param name
     * @param score
     *
     * This function updates the new high score data into the list and sort it in a descending way by scores
     */
    public void updateHighScore(int rank, String name, int score)
    {
        final int RANK_INDEX = rank - 1;

        if (RANK_INDEX < 0 || RANK_INDEX > HIGH_SCORES_COUNT)
        {
            throw new RuntimeException("Rank out of bounds.");
        }

        // shift all the records to next one
        for (int i = highScoresLeaderboard.length - 1; i > RANK_INDEX; i--)
        {
            highScoresLeaderboard[i].name = highScoresLeaderboard[i - 1].name;
            highScoresLeaderboard[i].score = highScoresLeaderboard[i - 1].score;
        }
        System.out.println("rank: " + rank);


        // Now update the high score
        highScoresLeaderboard[RANK_INDEX].name = name;
        highScoresLeaderboard[RANK_INDEX].score = score;
    }

    /**
     * <b>saveHighScores</b>
     * @throws IOException
     * Save the data in highScoresLeaderboard list to dat file in a specific form.
     */

    public void saveHighScores() throws IOException {

        try {
            File highScoreFile = new File(HIGH_SCORE_FILE_PATH);
            FileWriter writer = new FileWriter(highScoreFile);

            for (int i = 0; i < highScoresLeaderboard.length; i++) {
                writer.write(highScoresLeaderboard[i].name + getDataDelimiter() + highScoresLeaderboard[i].score + (i == highScoresLeaderboard.length - 1 ? "" : "\n"));
            }
            writer.close();
        } catch (Exception e){
            System.err.println("Error: " + e.getMessage());
        }
        System.out.println("yep");
    }


    public String getDataDelimiter()
    {
        return DATA_DELIMITER.replace("\\", "");
    }

    /**
     * <b>handleNewHighScore</b>
     * To check if winner score is great enough to be stored in the list/file.
     */
    public void handleNewHighScore() {

        if (winnerScore > 0) {
            int rank = getHighScoreRank(winnerScore);

            if (rank != -1) {
                updateHighScore(rank, winner, winnerScore);

                try{
                    saveHighScores();
                }catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    /**
     * <b>getHighScoreRank</b>
     * @param score : winner score
     * @return : the rank for new data
     */
    public int getHighScoreRank(int score)
    {
        for (int i = 0; i < highScoresLeaderboard.length; i++)
        {
            if (score <= highScoresLeaderboard[i].score)
            {
                return i + 1;
            }
        }
        return -1;
    }




    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("win.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    /**
     *
     * @param url
     * @param resourceBundle
     *
     * to inherit the winner name from Game and make it show on the page.
     *
     * If it's not the first play, we don't have to create a new list, or the previous data will be removed.
     * So only when the count is 0, we have to create a new list to store the data for leader board.
     *
     */

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        player = Game.player;

        switch (player){
            case 1:
                winner = Main.player1_name;
                winnerScore = Game.score1;
                break;
            case 2:
                winner = Main.player2_name;
                winnerScore = Game.score2;
                break;
            case 3:
                winner = Main.player3_name;
                winnerScore = Game.score3;
                break;
            case 4:
                winner = Main.player4_name;
                winnerScore = Game.score4;
                break;
        }

        winnerName.setText(winner);
        scoreNum.setText(Integer.toString(winnerScore));
//        System.out.printf("list length: " + highScoresLeaderboard.length);


        if(count == 0){
            for (int i = 0; i < HIGH_SCORES_COUNT; i++) {
                highScoresLeaderboard[i] = new HighScore("", 1000);
            }
        }

        handleNewHighScore();
    }

    @FXML
    void highScore() throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("leaderBoard.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
    }

}
