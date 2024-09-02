import java.util.Scanner;
import gameObjects.*;
public class GameManager {
  private GameBoard gameBoard;
  Scanner in;
  public GameManager() {
    this.gameBoard = new GameBoard();
    this.in = new Scanner(System.in);
  }

  public void newGame() {
    System.out.println("Enter the Number of Players in game...");
    int n = in.nextInt();
    System.out.println("Enter the Player name of Players...");
    for(int i=0;i<n;i++) {
      String playerName = in.next();
      gameBoard.addPlayer(new Player(playerName));
    }
  }

  public void configureSnakes() {
    System.out.println("Enter the Number of Snakes in game...");
    int n = in.nextInt();
    System.out.println("Enter the Head and Tail of Snakes...");
    for(int i=0;i<n;i++) {
      int head = in.nextInt();
      int tail = in.nextInt();
      gameBoard.placeSnake(head,tail);
    }
  }

  public void configureLadders() {
    System.out.println("Enter the Number of Ladders in game...");
    int n = in.nextInt();
    System.out.println("Enter the Start and End of Ladders...");
    for(int i=0;i<n;i++) {
      int start = in.nextInt();
      int end = in.nextInt();
      gameBoard.placeLadder(start,end);
    }
  }

  public void configureBoard() {
    this.configureSnakes();
    this.configureLadders();
  }
  
  public void playGame(){
    while(true) {
      for(Player player : gameBoard.getPlayers()) {
        System.out.println("Player " + player.getPlayerName() + " is playing...");
        System.out.println("Enter 'R' or 'r' to roll the dice...");
        char c = in.next().charAt(0);
        if(c == 'R' || c == 'r') {
          int diceValue = gameBoard.throwDice();
          gameBoard.movePlayer(player,diceValue);
          if(gameBoard.isWinner(player)) {
            System.out.println("Player " + player.getPlayerName() + " is the winner...");
            in.close();
            return;
          }
        }
        else {
          System.out.println("Enter a valid input...");
        }
      }
    }
  }
}