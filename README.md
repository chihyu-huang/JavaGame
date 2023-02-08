# JavaGame
This is a JAVA game project from JAVA programming at UCD
We're asked to do a JavaFX game with MVC pattern.


## Game Description
This game is board-based(4X6) game which has a start and finish line.
In the beginning, you can choose the difficulty of the game and the number of players. Then assign names to each player.
When the game starts, player gets the chance to throw dice which decide their move(step and direction) in their turn.
Whoever reaches to the finish line first wins the game. and if its score is low enough, it'll be recorded in the leaderboard.

### Rules
1. You can end your turn anytime you want.
2. Both dice are 4-side, one determines the steps you can take(1, 2, 3 or 4) and another is for the direction you can move(50% forward, 25% backward and 25%freeze).
3. Only when an obstacle or another player block the way, player can turn right or left.
4. Each step contributes to one point to score.
5. There are three kinds of obstacles, each has different rules. Once a player steps on it, the panelty applies.
  - Suffle: Shuffle all the obstacles and add 3 points as panelty.
  - Trap: Start from the start line.
  - Fire: Add 5 points as panelty.
