/open ImmutableMap.java
/open Keyable.java
/open KeyableMap.java
/open Assessment.java
/open Module.java
/open Student.java

new Module("CS2040").put(new Assessment("Lab1", "B")).get("Lab1")

new Student("Tony").put(new Module("CS2040").put(new Assessment("Lab1", "B")))

new Student("Tony").put(new Module("CS2040").put(new Assessment("Lab1", "B"))).get("CS2040")

Student natasha = new Student("Natasha");

natasha = natasha.put(new Module("CS2040").put(new Assessment("Lab1", "B")).put(new

Assessment("Lab2", "C")))

Student tony = new Student("Tony");

tony = tony.put(new Module("CS1231").put(new Assessment("Test", "A-")))

tony.put(new Module("CS2100").put(new Assessment("Test", "b")).put(new Assessment("Lab1",
"F")))

/exit
