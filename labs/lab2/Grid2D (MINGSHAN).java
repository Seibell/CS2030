import java.util.List;
import java.util.ArrayList;

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
        return this.list.get((r * this.numOfCols) + c);
    }

    public Grid2D set(int r, int c, int elem) {
        ImList<Integer> tempList = this.list.set((r * this.numOfCols) + c, elem);
        return new Grid2D(tempList, this.numOfCols);
    }

    @Override
    public String toString() {
        if (this.list.size() == 0) {
            return "{}";
        }
        try {
            String result = "{";
            int count = 1;
            for (int i = 0; i < list.size() - 1; i++) {
                if (count == numOfCols) {
                    result += String.format("%d;", list.get(i));
                    count = 1;
                } else {
                    result += String.format("%d,", list.get(i));
                    count++;
                }
            }   
            result += String.format("%d}", list.get(list.size() - 1));
            return result;
        } catch (Exception e) {
            System.out.println(e);
            return "e";
        }
    }
       



}
