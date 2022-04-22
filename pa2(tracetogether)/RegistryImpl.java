import java.util.List;

class RegistryImpl extends Registry {
   
    private final List<Token> tokens;

    RegistryImpl(String regID) {
       super(regID);
       this.tokens = List.of();
    }

    RegistryImpl(String regID, List<Token> tokens) {
        super(regID);
        this.tokens = tokens;
    }

    @Override
    void alert(int time) {
        for (Token t : tokens) {
            System.out.println(t.getTimes(time));
        }
    }

    @Override
    public String toString() {
        int count = 0;
        String print = "";

        for (Token t : tokens) {
            count++;
        }

        print += String.format("[%s]: %d tokens registered", this.getID(), count);

        if (count > 0) {
            for (Token t : tokens) {
                print += "\n";
                print += t.toString();
            }
        }
        return print;
    }
}
