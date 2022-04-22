import java.util.List;
import java.util.function.Function;

ImList<String> swordStates = ImList.<String>of(
    List.<String>of("--> You have taken sword.", 
                    "--> You already have sword.",
                    "--> There is no sword."));

ImList<String> trollStates = ImList.<String>of(
    List.<String>of("--> Troll is killed.",
                    "--> There is no troll."));


Room takeSwordHelper(Room other) {
   ImList<Thing> temp =  other.getThings();
   for(Thing t : temp) {
       if(t.identify().contains("Sword")) {
            int idx = temp.indexOf(t);
            
            if (t.getAction().getNumState() == 0) {
                System.out.println(swordStates.get(0));
            } else {
                System.out.println(swordStates.get(1));
            }
            return new Room(other.getName(),
                            temp.set(idx, new Sword(t.getNum(), t.getAction().getNumState() + 1)));
       }
   }
   System.out.println(swordStates.get(2));
   return other;
}

Room killTrollHelper(Room other) {
    ImList<Thing> temp = other.getThings();
    for(Thing t : temp) {
        if(t.identify().contains("Troll")) {
            int idx = temp.indexOf(t);

            for(Thing t1 : temp) {
                if(t1.identify().contains("Sword")) {
                    
                    // If you sword isnt picked up

                    if(t1.getAction().getNumState() == 0) {
                        System.out.println("--> You have no sword.");
                        return other;
                    }

                    // If sword is picked up

                    if(t1.getAction().getNumState() == 1) {
                        System.out.println(trollStates.get(0));
                        return new Room(other.getName(), temp.remove(idx).second());
                    }
                }
            }

            // Loop through whole temp and no sword

            System.out.println("--> You have no sword.");
            return other;
        }
    }

    //Loop through whole temp and no troll

    System.out.println(trollStates.get(1));
    return other;
}

Room dropSwordHelper(Room other) {
    ImList<Thing> temp = other.getThings();
    for(Thing t : temp) {
        if (t.identify().contains("Sword")) {
            int idx = temp.indexOf(t);
            if (t.getAction().getNumState() == 1) {
                System.out.println("--> You have dropped sword.");
                temp = temp.remove(idx).second();
                return new Room(other.getName(), temp.add(new Sword()));
            }
        }
    }
    return other;
}


Function<Room, Room> takeSword = x -> takeSwordHelper(x);
Function<Room, Room> killTroll = x -> killTrollHelper(x);
Function<Room, Room> dropSword = x -> dropSwordHelper(x);
