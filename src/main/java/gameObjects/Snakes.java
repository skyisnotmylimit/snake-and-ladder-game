package gameObjects;

import java.util.HashMap;

public class Snakes {
  private HashMap<Integer,Integer> snakesOnBoard;
  
  public Snakes() {
    this.snakesOnBoard = new HashMap<Integer,Integer>();
  }
  
  public void addSnake(int head, int tail) {
    if(head > tail) {
      snakesOnBoard.put(head,tail);
    }
    else {
      System.out.println("Snake can not be added");
    }
  }

  public boolean hasSnake(int position) {
    return snakesOnBoard.containsKey(position);
  }

  public int getTail(int head) {
    return snakesOnBoard.get(head);
  }
}