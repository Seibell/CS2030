/open ImmutableMap.java
/open Keyable.java
/open KeyableMap.java
/open Assessment.java
/open Module.java
/open Student.java
/open Roster.java

Roster roster = new Roster("AY1920")

roster = roster.add("Natasha", "CS2040", "Lab1" , "B")

roster.add("Tony", "CS1231", "Test", "A-")

roster.add("Natasha", "CS1231", "Test", "A-")

roster.add("Natasha", "CS2040", "Test", "A-")

roster.add("Natasha", "CS2040", "Lab1", "A-")

roster.getGrade("Natasha", "CS2040", "Lab1")

roster.getGrade("Natasha", "CS2040", "Test")

roster.getGrade("Natasha", "CS1231", "Lab1")

roster.getGrade("Tony", "CS2040", "Lab1")

/exit
