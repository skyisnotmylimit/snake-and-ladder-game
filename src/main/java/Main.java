import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    GameManager gm = new GameManager();
    int choice = 0;

    while (true) {
      try {
        System.out.println("Enter 1 to configure the board...");
        System.out.println("Enter 2 to play the game...");
        System.out.println("Enter 3 to exit...");

        if (!in.hasNextInt()) {
          System.out.println("Enter a valid integer...");
          in.next();
          continue;
        }

        choice = in.nextInt();

        switch (choice) {
          case 1:
            gm.configureBoard();
            break;
          case 2:
            gm.newGame();
            gm.playGame();
            break;
          case 3:
            System.out.println("Thank you for playing the game...");
            return;
          default:
            System.out.println("Enter a valid input...");
        }
      } catch (Exception e) {
        System.out.println("An error occurred: " + e.getMessage());
        in.nextLine();
      }
    }
  }

  // @Test
  // void addition() {
  //     assertEquals(2, 1 + 1);
  // }
}
