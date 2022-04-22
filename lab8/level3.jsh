/open ImList.java
/open Pair.java
/open Thing.java
/open Action.java
/open Room.java
/open Candle.java
/open Troll.java
/open Sword.java
/open actions.jsh


new Room("foyer").add(new Candle()).add(new Sword()).tick(x -> x)

new Room("foyer").add(new Candle()).add(new Sword()).tick(x -> x).tick(x -> x)

new Room("foyer").add(new Sword()).tick(takeSword)

new Room("foyer").add(new Sword()).tick(takeSword).tick(takeSword)
new Room("foyer").tick(takeSword)

new Room("foyer").add(new Candle()).add(new Troll()).add(new Sword()).tick()

new Room("foyer").add(new Candle()).add(new Troll()).add(new Sword()).tick(x -> x)

new Room("foyer").add(new Candle()).add(new Troll()).add(new Sword()).tick().tick(x -> x)


/exit