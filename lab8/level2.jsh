/open ImList.java
/open Pair.java
/open Thing.java
/open Room.java
/open Candle.java
/open Troll.java
/open Sword.java

new Troll()
new Troll().identify()
new Sword()
new Sword().identify()
Room foyer = new Room("foyer").add(new Candle()).add(new Troll())
Stream.iterate(foyer, x -> x.tick()).limit(6).forEach(System.out::println)
foyer = foyer.add(new Sword())
Stream.iterate(foyer, x -> x.tick()).limit(3).forEach(System.out::println);
foyer

/exit
