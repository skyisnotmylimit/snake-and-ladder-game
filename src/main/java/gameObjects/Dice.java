package gameObjects;

public class Dice {
  private int value;
  
  public Dice() {
    value = 1;
  }
  
  public int getValue() {
    return value;
  }
  
  public int roll(){
    value = (int)(Math.random() * 6) + 1;
    return value;
  }
}