import java.util.function.Function;

class Room {
    private final String name;
    private final ImList<Thing> things;
    private final ImList<Room> rooms;
    private final int roomNum;

    Room(String name) {
        this.name = name;
        this.things = ImList.<Thing>of();
        this.rooms = ImList.<Room>of();
        this.roomNum = 0;
    }

    Room(String name, ImList<Thing> things) {
        this.name = name;
        this.things = things;
        this.rooms = ImList.<Room>of();
        this.roomNum = 0;
    }

    Room(String name, ImList<Thing> things, ImList<Room> rooms, int roomNum) {
        this.name = name;
        this.things = things;
        this.rooms = rooms;
        this.roomNum = roomNum;
    }

    Room add(Thing thing) {
        return new Room(this.name, this.things.add(thing));
    }

    Room tick() {
        
        ImList<Thing> temp = ImList.<Thing>of();

        for (Thing t : this.things) {
            temp = temp.add(t.tick());
        }

        return new Room(this.name, temp, this.rooms, this.roomNum);
    }

    Room tick(Function<Room, Room> func) {
        Room tempRoom = func.apply(this.tick());

        return new Room(tempRoom.getName(), tempRoom.getThings(), this.rooms, this.roomNum);
    }

    public ImList<Thing> getThings() {
        return this.things;
    }

    public String getName() {
        return this.name;
    }

    public ImList<Room> getRoom() {
        return this.rooms;
    }

    public int getNum() {
        return this.roomNum;
    }

    public Room go(Function<ImList<Thing>, Room> func) {
        Room temp = func.apply(this.things);

        ImList<Thing> thisThing = this.things;

        ImList<Thing> inven = ImList.<Thing>of();

        for (Thing t : this.things) {
            if (t.identify().contains("Sword") && t.getAction().getNumState() == 1) {
                int idx = this.things.indexOf(t);

                inven = inven.add(t);

                thisThing = thisThing.remove(idx).second();
            }
        }

        inven = inven.addAll(temp.getThings());

        return new Room(temp.getName(), inven,
                this.rooms.add(new Room(this.getName(), thisThing, this.rooms, this.roomNum)),
                this.roomNum + 1);  
    }

    public Room back() {
        if (this.rooms.isEmpty()) {
            return this;
        } else {

            Room oldRoom = this.rooms.get(this.roomNum - 1);

            ImList<Thing> inven = ImList.<Thing>of();

            inven = inven.addAll(oldRoom.getThings());

            for (Thing t : this.things) {
                if (t.identify().contains("Sword") && t.getAction().getNumState() == 1) {
                    inven = inven.add(t);
                }
            }
            return new Room(oldRoom.getName(), inven, oldRoom.getRoom(), this.roomNum - 1).tick();
        }
    }

    @Override
    public String toString() {
        String print = this.name;

        if (!this.things.isEmpty()) {
            
            for (Thing t : this.things) {
                print += "\n" + t.toString();
            }
        }

        return "@" + print;
    }
}
