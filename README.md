# JavaGame
This is a JAVA game project from JAVA programming at UCD
We're asked to do a JavaFX game with MVC pattern.


## Game Description
This is a board-based(4X6) game which has a start and finish line.
In the beginning, you choose the difficulty of the game and the number of players, then assign names to each player.
When the game starts, player gets the chance to throw dice which decide their move(step and direction) in their turn.
Whoever reaches to the finish line first wins the game. and if its score is low enough, it'll be recorded in the leaderboard.

<img src = "https://github.com/BOBOeternal/JavaGame/blob/main/screenshot/0_Game%20View.png" width = "900">


### Rules
<img src = "https://github.com/BOBOeternal/JavaGame/blob/main/screenshot/0_rules.png" width = "750">
1. You can end your turn anytime you want.
2. Both dice are 4-side, one determines the steps you can take(1, 2, 3 or 4) and another is for the direction you can move(50% forward, 25% backward and 25%freeze).
3. Only when an obstacle or another player block the way, player can turn right or left.
4. Each step contributes to one point to score.
5. There are three kinds of obstacles, each has different rules. Once a player steps on it, the panelty applies.
  - Suffle: Shuffle all the obstacles and add 3 points as panelty.
  - Trap: Start from the start line.
  - Fire: Add 5 points as panelty.


### Screenshots of the game
1. Game starts in setting page, in here players get to choose how many players and the difficulty of this game.
<img src = "https://github.com/BOBOeternal/JavaGame/blob/main/screenshot/1_setting.png" width = "300">
2. Next, set the name for each players
<img src = "https://github.com/BOBOeternal/JavaGame/blob/main/screenshot/2_set%20name.png" width = "300">
3. Game start!
Player's name will be shown on the left of the game panel when it's his/her turn, click on the dice to determine the step and direction of this turn.
Move domino by using the button on the right.
<img src = "https://github.com/BOBOeternal/JavaGame/blob/main/screenshot/3_game1.png" width = "900">
Button will be activated/disabled accordingly in each situation.
<img src = "https://github.com/BOBOeternal/JavaGame/blob/main/screenshot/3_game3.png" width = "900">
<img src = "https://github.com/BOBOeternal/JavaGame/blob/main/screenshot/3_game4.png" width = "900">
4. Once a player reaches the finish line, the game stops and the winner's name and score will be announced
<img src = "https://github.com/BOBOeternal/JavaGame/blob/main/screenshot/3_win.png" width = "500">
5. When clicking on the "high score" button, it'll lead to the leaderboard.
<img src = "https://github.com/BOBOeternal/JavaGame/blob/main/screenshot/3_leaderboard.png" width = "650">
6. Start a new game!
<img src = "https://github.com/BOBOeternal/JavaGame/blob/main/screenshot/4_game.png" width = "900">
7. Announce the winner
<img src = "https://github.com/BOBOeternal/JavaGame/blob/main/screenshot/4_win.png" width = "500">
8. Leaderboard being updated.
<img src = "https://github.com/BOBOeternal/JavaGame/blob/main/screenshot/4_leaderboard.png" width = "650">


