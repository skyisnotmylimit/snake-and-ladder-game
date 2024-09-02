package gameObjects;

import java.util.HashMap;

public class Ladders {
  private HashMap<Integer,Integer> laddersOnBoard;
  
  public Ladders() {
    this.laddersOnBoard = new HashMap<Integer,Integer>();
  }
  
  public void addLadder(int start, int end) {
    if(start < end) {
      laddersOnBoard.put(start,end);
    }
    else {
      System.out.println("Ladder can not be added");
    }
  }
  
  public boolean hasLadder(int position) {
    return laddersOnBoard.containsKey(position);
  }

  public int getEnd(int start) {
    return laddersOnBoard.get(start);
  }
}