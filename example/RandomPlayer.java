import java.io.IOException;
import java.util.Random;

import im.antoine.bombjava.Client;
import im.antoine.bombjava.GameState;
import im.antoine.bombjava.PlayerState;

public class RandomPlayer {

  public static void main(String[] args) {
    Client c = new Client("127.0.0.1", 40000);

    try {
      c.open();
    } catch (IOException e) {
      System.err.printf("Opening connection: %s\n", e.getMessage());
      e.printStackTrace();
    }

    try {
      while (c.hasNext()) {
        GameState state = c.nextState();
        doMove(state, c);
      }
    } catch (IOException e) {
      System.err.printf("Getting next state: %s\n", e.getMessage());
      e.printStackTrace();
    }

    try {
      c.close();
    } catch (IOException e) {
      System.err.printf("Closing connection: %s\n", e.getMessage());
      e.printStackTrace();
    }
  }

  private static void doMove(GameState state, Client c) throws IOException {

    PlayerState p = state.getPlayerState();
    System.out.printf("I'm %s, at (%d, %d)\n", p.getName(), p.getX(), p.getY());

    Random r = new Random(System.nanoTime());
    switch (r.nextInt(4)) {
      case 0:
        c.goUp();
        break;
      case 1:
        c.goDown();
        break;
      case 2:
        c.goLeft();
        break;
      case 3:
        c.goRight();
        break;
    }
  }
}
