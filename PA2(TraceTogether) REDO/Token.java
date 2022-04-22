class Token {
    private final int id;
    private final ImList<String> pings;
    
    Token(int id) {
        this.id = id;

        ImList<String> tempPing = new ImList<String>();
        this.pings = tempPing;
    }

    Token(int id, ImList<String> pings) {
        this.id = id;
        this.pings = pings;
    }


    Token ping(Token t, int time) {

        String s = String.format(" #%d@%d", t.getID(), time);

        return new Token(this.id, pings.add(s));
    }

    int getID() {
        return this.id;
    }

    @Override
    public String toString() {
        String printToken = String.format("Token #%d:", this.id);

        if (pings.size() == 0) {
            printToken += " none";
        } else {
            ImList<String> tempPing = new ImList<String>();
            tempPing = pings;

            for (int i = 0; i < pings.size() - 1; i++) {

                int one = Character.getNumericValue(pings.get(i).charAt(2));
                int two = Character.getNumericValue(pings.get(i + 1).charAt(2));

            if(one > two) {
                
                String temp = tempPing.get(i);
                tempPing = tempPing.set(i, pings.get(i + 1));
                tempPing = tempPing.set(i + 1, temp);
            }
        }
            for (int i = 0; i < pings.size(); i++) {
                printToken += tempPing.get(i);
            }
        }

        return printToken;
    }
}
