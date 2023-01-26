package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

/**
 * <h1>Game page</h1>
 * <h2>This is the controller of the main game page.</h2>
 *
 *
 *
 * @author : Chih-Yu Huang
 * @since : Dec, 2022
 */
public class Game extends Setting implements Initializable {
    /**
     * <h2>players' status bar</h2>
     *
     * <b>Label_player</b> is the label of players' name
     * <b>Player_symbol</b> is the avatar of player
     * <b>Label_score</b> is the label of the word "Score"
     * <b>Label_player_score</b> is the score of player gain
     */
    @FXML
    private javafx.scene.control.Label Label_player1;
    @FXML
    private ImageView Player1_symbol;
    @FXML
    private javafx.scene.control.Label Label1_score;
    @FXML
    private javafx.scene.control.Label Label_player1_score;

    @FXML
    private javafx.scene.control.Label Label_player2;
    @FXML
    private ImageView Player2_symbol;
    @FXML
    private javafx.scene.control.Label Label2_score;
    @FXML
    private javafx.scene.control.Label Label_player2_score;

    @FXML
    private javafx.scene.control.Label Label_player3;
    @FXML
    private ImageView Player3_symbol;
    @FXML
    private javafx.scene.control.Label Label3_score;
    @FXML
    private javafx.scene.control.Label Label_player3_score;

    @FXML
    private javafx.scene.control.Label Label_player4;
    @FXML
    private ImageView Player4_symbol;
    @FXML
    private javafx.scene.control.Label Label4_score;
    @FXML
    private javafx.scene.control.Label Label_player4_score;


    /**
     *<h2>Dice part</h2>
     *
     * diceOne: the number of die 1 throws
     * diceTwo: the number of die 2 throws
     *
     */
    private Random random;
    private int diceOne;
    private int diceTwo;
    private int ranNum;
    @FXML
    private ImageView dice1;
    @FXML
    private ImageView dice2;
    @FXML
    private javafx.scene.control.Label dice1_label;
    @FXML
    private javafx.scene.control.Label dice2_label;


    /**
     * <h2>Obstacles</h2>
     *
     * position_obstacle: the position that obstacles at
     */
    @FXML
    private ImageView fire1;
    @FXML
    private ImageView trap1;
    @FXML
    private ImageView trap2;
    @FXML
    private ImageView shuffle1;
    @FXML
    private ImageView shuffle2;

    @FXML
    private ImageView fire2;
    @FXML
    private ImageView trap3;

    @FXML
    private ImageView fire3;
    @FXML
    private ImageView fire4;
    @FXML
    private ImageView trap4;

    public static int position_fire1[] = new int[2];
    public static int position_trap1[] = new int[2];
    public static int position_trap2[] = new int[2];
    public static int position_shuffle1[] = new int[2];
    public static int position_shuffle2[] = new int[2];

    public static int position_fire2[] = new int[2];
    public static int position_trap3[] = new int[2];

    public static int position_fire3[] = new int[2];
    public static int position_fire4[] = new int[2];
    public static int position_trap4[] = new int[2];


    /**
     * <h2>Player domino</h2>
     *
     * position[] random position to decide where's the starting point of domino and obstacles
     * position_player: the position that players at
     */
    @FXML
    private ImageView player1;
    @FXML
    private ImageView player2;
    @FXML
    private ImageView player3;
    @FXML
    private ImageView player4;


    private int position[] = { 3 , 1, 0, 2, 3 , 1, 0, 2}; //{3,2,1,0,3,2,1,0};//

    public static int position_player1[] = new int[2];
    public static int position_player2[] = new int[2];
    public static int position_player3[] = new int[2];
    public static int position_player4[] = new int[2];

    /**
     * <h3>The variable of each player</h3>
     * x1 means the player1's variable in horizontal level
     * y1 means the player1's variable in vertical level
     */
    int x1 = position[ranNum];
    int y1 = 0;
    int x2 = position[ranNum + 1];
    int y2 = 0;
    int x3 = position[ranNum + 2];
    int y3 = 0;
    int x4 = position[ranNum + 3];
    int y4 = 0;

    /**
     * to count the times that game has been played
     *
     * To avoid overwriting the leader board list data.
     */
    public static int count = 0;

    /**
     * score for each player
     */
    public static int score1 = 0;
    public static int score2 = 0;
    public static int score3 = 0;
    public static int score4 = 0;


    /**
     * <h2>Direction Button</h2>
     */
    @FXML
    private javafx.scene.control.Button forwardB;
    @FXML
    private javafx.scene.control.Button leftB;
    @FXML
    private javafx.scene.control.Button rightB;
    @FXML
    private javafx.scene.control.Button backB;
    @FXML
    private javafx.scene.control.Button endMyTurn;

    /**
     * number_of_players: define the number of players
     * player: current player
     * turn: label for name of the current player
     */
    public static int number_of_players;
    public static int player = 1;
    @FXML
    private javafx.scene.control.Label turn;


    /**
     * <b>ranNum</b>
     * To create a random integer number between 1 and 4.
     */
    void ranNum(){
        ranNum =  random.nextInt(4);
    }


    /**
     * To set up some data that had been defined.
     * @param location
     * @param arg1
     *
     * To set the number of players as players_number in Main class.
     * To let players' score to be 0 every time we start this page.
     * Create a random number to decide where is the starting x coordination for each player.
     * Set player1's name as the current player (turn)
     * Set trap by calling <b>setObstacle</b>.
     * Determine the beginning position for each player by calling the function <b>Determination_players</b>.
     * Set all direction button disable in the beginning.
     */
    @Override
    public void initialize(URL location, ResourceBundle arg1) {
        number_of_players = sample.Main.players_number;

        score1 = 0;
        score2 = 0;
        score3 = 0;
        score4 = 0;

        //to define the starting position of each players

        if (random == null) {
            random = new Random();
        }
        ranNum();

        // player1 is always the first to play
//        turn.setText(Main.player1_name);
        setTurnName(player);

        //set obstacles
        setObstacle();
        Determination_players(Main.players_number);

        forwardB.setDisable(true);
        leftB.setDisable(true);
        rightB.setDisable(true);
        backB.setDisable(true);
        endMyTurn.setDisable(true);
    }

    /**
     * <b>setObstacle</b>
     * To define the position of each obstacle
     * with different level going higher, there'll be more obstacles.
     *
     * If the obstacles shouldn't be appear in that level, we'll set it and its coordinates to out of frame
     * so player won't see it or step on it.
     *
     */
    void setObstacle(){

        ranNum = 3;

        // 4 traps, 4 fire, 2 stop = 10
        if(level == 2){

//            ranNum();
            fire3.setTranslateX(150 * ranNum);
            position_fire3[0] = 150 * ranNum;
            position_fire3[1] = -80 * 3;

//            ranNum();
            fire4.setTranslateX(150 * ranNum);
            position_fire4[0] = 150 * ranNum;
            position_fire4[1] = -80 * 3;

//            ranNum();
            trap4.setTranslateX(150 * ranNum);
            position_trap4[0] = 150 * ranNum;
            position_trap4[1] = -80 * 4;

//            ranNum();
            fire2.setTranslateX(150 * ranNum);
            position_fire2[0] = 150 * ranNum;
            position_fire2[1] = -80 * 1;

//            ranNum();
            trap3.setTranslateX(150 * ranNum);
            position_trap3[0] = 150 * ranNum;
            position_trap3[1] = -80 * 6;

        }

        // 3 traps, 2 fire, 2 stop = 7
        if(level == 1){

            fire3.setTranslateX(2000);

            fire4.setTranslateX(2000);
            trap4.setTranslateX(2000);

            position_fire3[0] = 2000;
            position_fire3[1] = 2000;

            position_fire4[0] = 2000;
            position_fire4[1] = 2000;
            position_trap4[0] = 2000;
            position_trap4[1] = 2000;

            ranNum();
            fire2.setTranslateX(150 * ranNum);
            position_fire2[0] = 150 * ranNum;
            position_fire2[1] = -80 * 1;

            ranNum();
            trap3.setTranslateX(150 * ranNum);
            position_trap3[0] = 150 * ranNum;
            position_trap3[1] = -80 * 6;

        }

        // 2 traps, 1 fire, 2 stop = 5
        if(level == 0){

            fire2.setTranslateX(2000);
            fire3.setTranslateX(2000);
            fire4.setTranslateX(2000);

            trap3.setTranslateX(2000);
            trap4.setTranslateX(2000);

            position_fire2[0] = 2000;
            position_fire2[1] = 2000;
            position_fire3[0] = 2000;
            position_fire3[1] = 2000;
            position_fire4[0] = 2000;
            position_fire4[1] = 2000;

            position_trap3[0] = 2000;
            position_trap3[1] = 2000;
            position_trap4[0] = 2000;
            position_trap4[1] = 2000;
        }



//        ranNum();
        trap1.setTranslateX(150 * ranNum);
        position_trap1[0] = 150 * ranNum;
        position_trap1[1] = -80 * 6;

//        ranNum();
        fire1.setTranslateX(150 * ranNum);
        position_fire1[0] = 150 * ranNum;
        position_fire1[1] = -80 * 5;

//        ranNum();
        trap2.setTranslateX(150 * ranNum);
        position_trap2[0] = 150 * ranNum;
        position_trap2[1] = -80 * 4;

//        ranNum();
        shuffle1.setTranslateX(150 * ranNum);
        position_shuffle1[0] = 150 * ranNum;
        position_shuffle1[1] = -80 * 2;

//        ranNum();
        shuffle2.setTranslateX(150 * ranNum);
        position_shuffle2[0] = 150 * ranNum;
        position_shuffle2[1] = -80 * 2;

    }

    /**
     * <b>Determination_players</b>
     * @param number_of_players
     *
     * Decide if the player's status and domino should be shown by the number of players
     */
    void Determination_players(int number_of_players) {

        // set the names of players they define in setName page
        Label_player1.setText(Main.player1_name);
        Label_player2.setText(Main.player2_name);
        Label_player3.setText(Main.player3_name);
        Label_player4.setText(Main.player4_name);

        // decide where is the starting x coordination for each player.
        position_player1[0] = 150 * x1 ;
        position_player2[0] = 150 * x2 ;
        position_player3[0] = 150 * x3 ;
        position_player4[0] = 150 * x4 ;


        switch (number_of_players) {
            case 2:
                System.out.println("2 players set!");

                // there are only two playing, so we hide others' status and domino
                Label_player3.setVisible(false);
                Player3_symbol.setVisible(false);
                Label3_score.setVisible(false);
                Label_player3_score.setVisible(false);

                Label_player4.setVisible(false);
                Player4_symbol.setVisible(false);
                Label4_score.setVisible(false);
                Label_player4_score.setVisible(false);

                //set the starting point of player 1 and 2
                player1.setTranslateX( 150 * x1);
                player2.setTranslateX( 150 * x2);
                player3.setVisible(false);
                player4.setVisible(false);


                break;
            case 3:

                System.out.println("3 players set!");

                Label_player4.setVisible(false);
                Player4_symbol.setVisible(false);
                Label4_score.setVisible(false);
                Label_player4_score.setVisible(false);

                player1.setTranslateX( 150 * x1);
                player2.setTranslateX( 150 * x2);
                player3.setTranslateX( 150 * x3);
                player4.setVisible(false);


                break;
            default:
                System.out.println("4 players set");
                player1.setTranslateX( 150 * x1);
                player2.setTranslateX( 150 * x2);
                player3.setTranslateX( 150 * x3);
                player4.setTranslateX( 150 * x4);

        }
    }


    /**
     * <b>roll()</b>
     * Throw two dice to determine how many steps a player can take and what direction he/she go.
     * At the same time, the corresponding direction button will be activated.
     * Some buttons are functional in certain conditions.
     */
    @FXML
    void roll(){

        // dice one is a 4-side dice for steps
        diceOne = random.nextInt(4)+1;

        // show the corresponding image by the number thrown and set the text as well
        File dice1Image = new File("src/main/resources/sample/images/Dice" + diceOne+".png");
        dice1.setImage(new Image(dice1Image.toURI().toString()));
        dice1_label.setText(Integer.toString(diceOne));

        // dice two is a 4-side dice as well, but for direction
        diceTwo = random.nextInt(4)+5;

        File dice2Image = new File("src/main/resources/sample/images/Dice" + diceTwo+".png");
        dice2.setImage(new Image(dice2Image.toURI().toString()));
        String direction = "";

        // there's 50% chance a player can go forward, 25% go backward and 25% cannot move anywhere.
        switch (diceTwo){
            case 5, 6:
                direction = "forward";
                break;
            case 7:
                direction = "backward";
                break;
            case 8:
                direction = "freeze";
                break;

        }
        dice2_label.setText(direction);


        // let the direction button disable when they're not allowed to be push
        if(diceOne > 0){
            if(diceTwo == 5 || diceTwo == 6 ){
                forwardB.setDisable(false);
            }
            if(diceTwo == 7){
                backB.setDisable(false);
            }
        }
        if(diceTwo == 8){
            leftB.setDisable(true);
            rightB.setDisable(true);
        }

        // only when a players is in front of an obstacle, they can choose to turn right or left.
        if(player == 1 && nextObstacle(position_player1[0], position_player1[1]) ||
                player == 2 && nextObstacle(position_player2[0], position_player2[1]) ||
                player == 3 && nextObstacle(position_player3[0], position_player3[1]) ||
                player == 4 && nextObstacle(position_player4[0], position_player4[1])){
            leftB.setDisable(false);
            rightB.setDisable(false);
        }

        // once player roll the dice, they can end their turn anytime they wish
        endMyTurn.setDisable(false);

        // after throwing the dice, player are not allowed to throw again, so we make them disable and become a bit transparent.
        dice1.setDisable(true);
        dice2.setDisable(true);
        dice1.setOpacity(0.5);
        dice2.setOpacity(0.5);
    }


    /**
     * <b>moveForward</b>
     * This is a function connected to the moveForward button and make the player's domino move forward.
     * It counts the steps(score) a players has taken and the steps left, once he/she's running out of steps,
     * it's next player's turn,
     * It also monitors if a player steps on an obstacle, if so, there'll be corresponding penalties.
     * When a player reach the end, it riggers the game to stop and announces the name of winner
     * and its score.
     * @throws IOException
     */
    @FXML
    void moveForward() throws IOException {
        diceOne--;

        if (player == 1){
            y1++;
            player1.setTranslateY(-80 * y1);
            position_player1[1] = -80 * y1;
            score1++;
            if(stepOnTrap(position_player1[0], position_player1[1])){
                player1.setTranslateY(0);
                y1 = 0;
                position_player1[1] = -80 * y1;
                diceOne = 0;

            }
            if(stepOnFire(position_player1[0], position_player1[1])){
                score1 = score1 + 5;
                diceOne = 0;

            }
            if(stepOnShuffle(position_player1[0], position_player1[1])){
                setObstacle();
                score1 = score1 + 3;
                diceOne = 0;

            }
            if(nextObstacle(position_player1[0], position_player1[1]) && diceOne != 0){
                leftB.setDisable(false);
                rightB.setDisable(false);
            }
        }
        if (player == 2){
            y2++;
            player2.setTranslateY(-80 * y2);
            position_player2[1] = -80 * y2;
            score2++;
            if(stepOnTrap(position_player2[0], position_player2[1])){
                player2.setTranslateY(0);
                y2 = 0;
                position_player2[1] = -80 * y2;
            }
            if(stepOnFire(position_player2[0], position_player2[1])){
                score2 = score2 + 5;
            }
            if(stepOnShuffle(position_player2[0], position_player2[1])){
                setObstacle();
                score2 = score2 + 3;
            }
            if(nextObstacle(position_player2[0], position_player2[1]) && diceOne != 0){
                leftB.setDisable(false);
                rightB.setDisable(false);
            }
        }
        if (player == 3){
            y3++;
            player3.setTranslateY(-80 * y3);
            position_player3[1] = -80 * y3;
            score3++;
            if(stepOnTrap(position_player3[0], position_player3[1])){
                player3.setTranslateY(0);
                y3 = 0;
                position_player3[1] = -80 * y3;
            }
            if(stepOnFire(position_player3[0], position_player3[1])){
                score3 = score3 + 5;
            }
            if(stepOnShuffle(position_player3[0], position_player3[1])){
                setObstacle();
                score3 = score3 + 3;
            }
            if(nextObstacle(position_player3[0], position_player3[1]) && diceOne != 0){
                leftB.setDisable(false);
                rightB.setDisable(false);
            }
        }
        if (player == 4){
            y4++;
            player4.setTranslateY(-80 * y4);
            position_player4[1] = -80 * y4;
            score4++;
            if(stepOnTrap(position_player4[0], position_player4[1])){
                player4.setTranslateY(0);
                y4 = 0;
                position_player4[1] = -80 * y4;
            }
            if(stepOnFire(position_player4[0], position_player4[1])){
                score4 = score4 + 5;
            }
            if(stepOnShuffle(position_player4[0], position_player4[1])){
                setObstacle();
                score4 = score4 + 3;
            }
            if(nextObstacle(position_player4[0], position_player4[1]) && diceOne != 0){
                leftB.setDisable(false);
                rightB.setDisable(false);
            }
        }

        if(y1 > 6 || y2 > 6 || y3 > 6 || y4 > 6){
            Parent root = FXMLLoader.load(getClass().getResource("win.fxml"));
            stage.setScene(new Scene(root));
            stage.show();
            count++;
        }

        dice1_label.setText(Integer.toString(diceOne));
        if(diceOne == 0){
            next();
        }
    }

    /**
     * <b>nextObstacle</b>
     * This is a function to check if a player is blocked by an obstacle or another player.
     * @param player_x : the x coordinate of player
     * @param player_y : the y coordinate of player
     * @return ture/false means there's an obstacle in front of the player and not.
     */

    public boolean nextObstacle(int player_x, int player_y){
        if(player_x == position_trap1[0] && player_y == position_trap1[1] + 80 ||
                player_x == position_trap2[0] && player_y == position_trap2[1] + 80 ||
                player_x == position_trap3[0] && player_y == position_trap3[1] + 80 ||
                player_x == position_trap4[0] && player_y == position_trap4[1] + 80 ||
                player_x == position_fire1[0] && player_y == position_fire1[1] + 80 ||
                player_x == position_fire2[0] && player_y == position_fire2[1] + 80 ||
                player_x == position_fire3[0] && player_y == position_fire3[1] + 80 ||
                player_x == position_fire4[0] && player_y == position_fire4[1] + 80 ||
                player_x == position_shuffle1[0] && player_y == position_shuffle1[1] + 80 ||
                player_x == position_shuffle2[0] && player_y == position_shuffle2[1] + 80 ||
                player_x == position_player1[0] && player_y == position_player1[1] + 80 ||
                player_x == position_player2[0] && player_y == position_player2[1] + 80 ||
                player_x == position_player3[0] && player_y == position_player3[1] + 80 ||
                player_x == position_player4[0] && player_y == position_player4[1] + 80){
            return true;
        }

        return false;
    }

    /**
     * <b>stepOnTrap</b>
     * This is a function to check if a player step on the obstacle Trap.
     * @param player_x : the x coordinate of player
     * @param player_y : the y coordinate of player
     * @return ture/false means the player step on it or not.
     */
    boolean stepOnTrap(int player_x, int player_y){
        if(player_x == position_trap1[0] && player_y == position_trap1[1] ||
                player_x == position_trap2[0] && player_y == position_trap2[1] ||
                player_x == position_trap3[0] && player_y == position_trap3[1] ||
                player_x == position_trap4[0] && player_y == position_trap4[1]){
            return true;
        }
        return false;
    }

    /**
     * <b>stepOnFire</b>
     * This is a function to check if a player step on obstacle Fire.
     * @param player_x : the x coordinate of player
     * @param player_y : the y coordinate of player
     * @return ture/false means the player step on it or not.
     */
    boolean stepOnFire(int player_x, int player_y){
        if(player_x == position_fire1[0] && player_y == position_fire1[1] ||
                player_x == position_fire2[0] && player_y == position_fire2[1] ||
                player_x == position_fire3[0] && player_y == position_fire3[1] ||
                player_x == position_fire4[0] && player_y == position_fire4[1]){
            return true;
        }
        return false;
    }

    /**
     * <b>stepOnShuffle</b>
     * This is a function to check if a player step on obstacle Shuffle.
     * @param player_x : the x coordinate of player
     * @param player_y : the y coordinate of player
     * @return ture/false means the player step on it or not.
     */
    boolean stepOnShuffle(int player_x, int player_y){
        if(player_x == position_shuffle1[0] && player_y == position_shuffle1[1] ||
                player_x == position_shuffle2[0] && player_y == position_shuffle2[1]){
            return true;
        }
        return false;
    }


    /**
     * <b>moveBackward</b>
     * This is a function let the player move backward.
     */
    @FXML
    void moveBackward(){
        diceOne--;
        dice1_label.setText(Integer.toString(diceOne));


        if (player == 1){
            y1--;
            player1.setTranslateY(-80 * y1);
            position_player1[1] = -80 * y1;
            score1++;
            if(stepOnTrap(position_player1[0], position_player1[1])){
                player1.setTranslateY(0);
                y1 = 0;
            }
            if(stepOnFire(position_player1[0], position_player1[1])){
                score1 = score1 + 5;
            }
            if(stepOnShuffle(position_player1[0], position_player1[1])){
                setObstacle();
                score1 = score1 + 3;
            }
            if(nextObstacle(position_player1[0], position_player1[1]) && diceOne != 0){
                leftB.setDisable(false);
                rightB.setDisable(false);
            }
        }
        if (player == 2){
            y2--;
            player2.setTranslateY(-80 * y2);
            position_player2[1] = -80 * y2;
            score2++;
            if(stepOnTrap(position_player2[0], position_player2[1])){
                player2.setTranslateY(0);
                y2 = 0;
            }
            if(stepOnFire(position_player2[0], position_player2[1])){
                score2 = score2 + 5;
            }
            if(stepOnShuffle(position_player2[0], position_player2[1])){
                setObstacle();
                score2 = score2 + 3;
            }
            if(nextObstacle(position_player2[0], position_player2[1]) && diceOne != 0){
                leftB.setDisable(false);
                rightB.setDisable(false);
            }
        }
        if (player == 3){
            y3--;
            player3.setTranslateY(-80 * y3);
            position_player3[1] = -80 * y3;
            score3++;
            if(stepOnTrap(position_player3[0], position_player3[1])){
                player3.setTranslateY(0);
                y3 = 0;
            }
            if(stepOnFire(position_player3[0], position_player3[1])){
                score3 = score3 + 5;
            }
            if(stepOnShuffle(position_player3[0], position_player3[1])){
                setObstacle();
                score3 = score3 + 3;
            }
            if(nextObstacle(position_player3[0], position_player3[1]) && diceOne != 0){
                leftB.setDisable(false);
                rightB.setDisable(false);
            }
        }
        if (player == 4){
            y4--;
            player4.setTranslateY(-80 * y4);
            position_player4[1] = -80 * y4;
            score4++;
            if(stepOnTrap(position_player4[0], position_player4[1])){
                player4.setTranslateY(0);
                y4 = 0;
            }
            if(stepOnFire(position_player4[0], position_player4[1])){
                score4 = score4 + 5;
            }
            if(stepOnShuffle(position_player4[0], position_player4[1])){
                setObstacle();
                score4 = score4 + 3;
            }
            if(nextObstacle(position_player4[0], position_player4[1]) && diceOne != 0){
                leftB.setDisable(false);
                rightB.setDisable(false);
            }
        }

        if(diceOne == 0){
            next();
        }


    }

    /**
     * <b>turn_left</b>
     * This is a function let the player turn left.
     */

    @FXML
    void turn_left(){
        diceOne--;
        dice1_label.setText(Integer.toString(diceOne));

        if (player == 1){
            x1--;
            player1.setTranslateX(150 * x1);
            position_player1[0] = 150 * x1;
            score1++;
            if(stepOnTrap(position_player1[0], position_player1[1])){
                player1.setTranslateY(0);
                y1 = 0;
            }
            if(stepOnFire(position_player1[0], position_player1[1])){
                score1 = score1 + 5;
            }
            if(stepOnShuffle(position_player1[0], position_player1[1])){
                setObstacle();
                score1 = score1 + 3;
            }
            if(nextObstacle(position_player1[0], position_player1[1]) && diceOne != 0){
                leftB.setDisable(false);
                rightB.setDisable(false);
            }
        }
        if (player == 2){
            x2--;
            player2.setTranslateX(150 * x2);
            position_player2[0] = 150 * x2;
            score2++;
            if(stepOnTrap(position_player2[0], position_player2[1])){
                player2.setTranslateY(0);
                y2 = 0;
            }
            if(stepOnFire(position_player2[0], position_player2[1])){
                score2 = score2 + 5;
            }
            if(stepOnShuffle(position_player2[0], position_player2[1])){
                setObstacle();
                score2 = score2 + 3;
            }
            if(nextObstacle(position_player2[0], position_player2[1]) && diceOne != 0){
                leftB.setDisable(false);
                rightB.setDisable(false);
            }
        }
        if (player == 3){
            x3--;
            player3.setTranslateX(150 * x3);
            position_player3[0] = 150 * x3;
            score3++;
            if(stepOnTrap(position_player3[0], position_player3[1])){
                player3.setTranslateY(0);
                y3 = 0;
            }
            if(stepOnFire(position_player3[0], position_player3[1])){
                score3 = score3 + 5;
            }
            if(stepOnShuffle(position_player3[0], position_player3[1])){
                setObstacle();
                score3 = score3 + 3;
            }
            if(nextObstacle(position_player3[0], position_player3[1]) && diceOne != 0){
                leftB.setDisable(false);
                rightB.setDisable(false);
            }
        }
        if (player == 4){
            x4--;
            player4.setTranslateX(150 * x4);
            position_player4[0] = 150 * x4;
            score4++;if(stepOnTrap(position_player4[0], position_player4[1])){
                player4.setTranslateY(0);
                y4 = 0;
            }
            if(stepOnFire(position_player4[0], position_player4[1])){
                score4 = score4 + 5;
            }
            if(stepOnShuffle(position_player4[0], position_player4[1])){
                setObstacle();
                score4 = score4 + 3;
            }
            if(nextObstacle(position_player4[0], position_player4[1]) && diceOne != 0){
                leftB.setDisable(false);
                rightB.setDisable(false);
            }
        }

        if(diceOne == 0){
//            forwardB.setDisable(true);
//            leftB.setDisable(true);
//            rightB.setDisable(true);
//            backB.setDisable(true);
            next();
        }

    }

    /**
     * <b>turn_right</b>
     * This is a function let the player turn right.
     */

    @FXML
    void turn_right(){
        diceOne--;
        dice1_label.setText(Integer.toString(diceOne));

        if (player == 1){
            x1++;
            player1.setTranslateX(150 * x1);
            position_player1[0] = 150 * x1;
            score1++;
            if(stepOnTrap(position_player1[0], position_player1[1])){
                player1.setTranslateY(0);
                y1 = 0;
            }
            if(stepOnFire(position_player1[0], position_player1[1])){
                score1 = score1 + 5;
            }
            if(stepOnShuffle(position_player1[0], position_player1[1])){
                setObstacle();
                score1 = score1 + 3;
            }
            if(nextObstacle(position_player1[0], position_player1[1]) && diceOne != 0){
                leftB.setDisable(false);
                rightB.setDisable(false);
            }
        }
        if (player == 2){
            x2++;
            player2.setTranslateX(150 * x2);
            position_player2[0] = 150 * x2;
            score2++;
            if(stepOnTrap(position_player2[0], position_player2[1])){
                player2.setTranslateY(0);
                y2 = 0;
            }
            if(stepOnFire(position_player2[0], position_player2[1])){
                score2 = score2 + 5;
            }
            if(stepOnShuffle(position_player2[0], position_player2[1])){
                setObstacle();
                score2 = score2 + 3;
            }
            if(nextObstacle(position_player2[0], position_player2[1]) && diceOne != 0){
                leftB.setDisable(false);
                rightB.setDisable(false);
            }
        }
        if (player == 3){
            x3++;
            player3.setTranslateX(150 * x3);
            position_player3[0] = 150 * x3;
            score3++;
            if(stepOnTrap(position_player3[0], position_player3[1])){
                player3.setTranslateY(0);
                y3 = 0;
            }
            if(stepOnFire(position_player3[0], position_player3[1])){
                score3 = score3 + 5;
            }
            if(stepOnShuffle(position_player3[0], position_player3[1])){
                setObstacle();
                score3 = score3 + 3;
            }
            if(nextObstacle(position_player3[0], position_player3[1]) && diceOne != 0){
                leftB.setDisable(false);
                rightB.setDisable(false);
            }
        }
        if (player == 4){
            x4++;
            player4.setTranslateX(150 * x4);
            position_player4[0] = 150 * x4;
            score4++;
            if(stepOnTrap(position_player4[0], position_player4[1])){
                player4.setTranslateY(0);
                y4 = 0;
            }
            if(stepOnFire(position_player4[0], position_player4[1])){
                score4 = score4 + 5;
            }
            if(stepOnShuffle(position_player4[0], position_player4[1])){
                setObstacle();
                score4 = score4 + 3;
            }
            if(nextObstacle(position_player4[0], position_player4[1]) && diceOne != 0){
                leftB.setDisable(false);
                rightB.setDisable(false);
            }
        }

        if(diceOne == 0){
//            forwardB.setDisable(true);
//            leftB.setDisable(true);
//            rightB.setDisable(true);
//            backB.setDisable(true);
            next();
        }
    }

    /**
     * <b>next</b>
     * It ends the turn of current player and moves to the next one.
     * It also tracks who is the current player.
     * At the same time, it updates the score each player gains so far,
     * clears dice label, make direction buttons disable and enable dice buttons.
     *
     */
    @FXML
    void next(){
        player++;
        if(player > Main.players_number){
            player = 1;
        }

        setTurnName(player);

        Label_player1_score.setText(Integer.toString(score1));
        Label_player2_score.setText(Integer.toString(score2));
        Label_player3_score.setText(Integer.toString(score3));
        Label_player4_score.setText(Integer.toString(score4));

        dice1_label.setText("");
        dice2_label.setText("...");

        forwardB.setDisable(true);
        leftB.setDisable(true);
        rightB.setDisable(true);
        backB.setDisable(true);
        endMyTurn.setDisable(true);

        diceOne = 0;

        dice1.setDisable(false);
        dice2.setDisable(false);
        dice1.setOpacity(1);
        dice2.setOpacity(1);

    }

    void setTurnName(int player){
        if(player == 1){
            turn.setText(Main.player1_name);
        }
        if(player == 2){
            turn.setText(Main.player2_name);
        }
        if(player == 3){
            turn.setText(Main.player3_name);
        }
        if(player == 4){
            turn.setText(Main.player4_name);
        }
    }

    /**
     * To restart the game, clear the score from previous plays but keep other data like player name.
     * @throws IOException
     */

    @FXML
    void restart() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("game.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
        score1 = 0;
        score2 = 0;
        score3 = 0;
        score4 = 0;
    }

    /**
     * back to the setting page(number of players)
     * @throws IOException
     */
    @FXML
    void back() throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("setting.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
    }


}