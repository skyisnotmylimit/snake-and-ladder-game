import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;
import gameObjects.Snakes;
import gameObjects.Dice;
import gameObjects.Ladders;
import gameObjects.Player;

public class GameBoard {

  private HashSet<Integer> specialBlocks;
  private Snakes snakes;
  private Dice dice;
  private Ladders ladders;
  private List<Player> players;

  public GameBoard() {
    this.snakes = new Snakes();
    this.dice = new Dice();
    this.ladders = new Ladders();
    this.players = new ArrayList<Player>();
    this.specialBlocks = new HashSet<Integer>();
  }

  public void addPlayer(Player player) {
    players.add(player);
  }

  public void placeSnake(int head, int tail) {
    specialBlocks.add(head);
    snakes.addSnake(head, tail);
  }

  public void placeLadder(int start, int end) {
    specialBlocks.add(start);
    ladders.addLadder(start, end);
  }

  public void movePlayer(Player player, int steps) {
    int currentPosition = player.getCurrentPosition();
    int newPosition = currentPosition + steps;
    if (newPosition > 100) {
      System.out.println("Player cannot move");
      return;
    }
    if (specialBlocks.contains(newPosition)) {
      if (snakes.hasSnake(newPosition)) {
        newPosition = snakes.getTail(newPosition);
        System.out.println("Player " + player.getPlayerName() + " has landed on a snake");
      } else if (ladders.hasLadder(newPosition)) {
        newPosition = ladders.getEnd(newPosition);
        System.out.println("Player " + player.getPlayerName() + " has landed on a ladder");
      } else {
        System.out.println("Some Error Occured in making the move");
      }
    }
    player.setCurrentPosition(newPosition);
    System.out.println("Player " + player.getPlayerName() + " is at " + player.getCurrentPosition());
  }

  public int throwDice() {
    int diceValue = dice.roll();
    System.out.println("Dice Value is " + diceValue);
    return diceValue;
  }

  public boolean isWinner(Player player) {
    int currentPosition = player.getCurrentPosition();
    if (currentPosition == 100) {
      return true;
    } else {
      return false;
    }
  }

  public List<Player> getPlayers() {
    return players;
  }

}