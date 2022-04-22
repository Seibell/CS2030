import java.util.List;

class Grid2D {

    private final ImList<Integer> list;
    private final int numOfCols;

    Grid2D(List<Integer> list, int numOfCols) {
        this.list = new ImList<Integer>(list);
        this.numOfCols = numOfCols;
    }

    Grid2D(int numOfCols) {
        this.list = new ImList<Integer>();
        this.numOfCols = numOfCols;
    }

    Grid2D(ImList<Integer> list, int numOfCols) {
        this.list = list;
        this.numOfCols = numOfCols;
    }

    Grid2D add(int elem) {
        return new Grid2D(this.list.add(elem), this.numOfCols);
    }

    public int get(int r, int c) {
        int index = (r * this.numOfCols) + c;
        return this.list.get(index);
    }

    Grid2D set(int r, int c, int elem) {
        
        int index = (r * this.numOfCols) + c;
        ImList<Integer> tempList = this.list.set(index, elem);

        return new Grid2D(tempList, this.numOfCols);
    }

    @Override
    public String toString() {

        if (this.list.size() == 0) {
            return "{}";
        }

        int count = 1;

        String str = "";

        for (int i = 0; i < list.size(); i++) {
            if (count == numOfCols) {
                str += list.get(i) + ";";
                count = 1;
            } else {
                str += list.get(i) + ",";
                count++;
            }
        }

        str = str.substring(0, str.length() - 1);
        return "{" + str + "}";
    }
}
