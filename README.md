# Bombjava

Java client [bomberman](https://github.com/aybabtme/bomberman) client.

# Quickstart

It’s dangerous to go alone! Take this [jar](https://github.com/aybabtme/bombjava/raw/master/dist/bombjava.jar).

Then
```java
// import the files
import im.antoine.bombjava.Client;
import im.antoine.bombjava.GameState;
import im.antoine.bombjava.PlayerState;
```

Now use the client!
```java
// Prepare the client
Client c = new Client("127.0.0.1", 40000);

// Open the client resources
c.open();

// Read states till no more!
while (c.hasNext()) {
    GameState state = c.nextState();
    doMove(state, c);
}

// Cleanup the client resources
c.close();
```

You can then consume the `GameState` object any way you want - it's immutable - and
send commands to the game through the client.

```java
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
```

Prints

```
I'm p2, at (46, 15)
I'm p2, at (46, 15)
I'm p2, at (47, 15)
I'm p2, at (48, 15)
I'm p2, at (47, 15)
I'm p2, at (48, 15)
I'm p2, at (49, 15)
I'm p2, at (48, 15)
```

# Docs

Javadocs aren't available at this time.  However, the objects are pretty simple.  Feel
free to submit docs in a PR if you feel like it.

## `Client`

Each call to `Client` is a call to the network, so they will all block.

## `GameState`

All the values in `GameState` objects are actual values. They are also immutable.

No call to `GameState` will block.
