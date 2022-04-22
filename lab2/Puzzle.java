import java.util.List;

class Puzzle {
    private final int n;
    private final ImList<Integer> list;

    Puzzle(int n) {
        this.n = n;

        ImList<Integer> tempList = new ImList<Integer>();

        int count = 1;
        int zero = 0;

        for (int i = 0; i < n * n - 1; i++) {
            tempList = tempList.add(count);
            count++;
        }

        //let empty space be 0 instead
        tempList = tempList.add(zero);

        list = tempList;
        
    }

    Puzzle(ImList<Integer> list, int n) {
        this.list = list;
        this.n = n;
    }

    public int get(int index) {
        return this.list.get(index);
    }

    Puzzle move(int num) {
        int idx = -1;
        int zeroIdx = -1;

        for (int i = 0; i < this.list.size(); i++) {
            if (this.list.get(i) == num) {
                idx = i;
            }
            if (this.list.get(i) == 0) {
                zeroIdx = i;
            }
        }

        if (Math.abs(idx - zeroIdx) == this.n || Math.abs(idx - zeroIdx) == 1) {
            if ((idx % this.n == 0 && idx - zeroIdx == 1) ||
                    (zeroIdx % this.n == 0 && zeroIdx - idx == 1)) {

                return new Puzzle(this.list, this.n);

            }
            int temp = this.list.get(idx);

            ImList<Integer> tempList =
                this.list.set(idx, this.list.get(zeroIdx)).set(zeroIdx, temp);

            return new Puzzle(tempList, this.n);
        }

        return new Puzzle(this.list, this.n);
    }

    public boolean isSolved() {
        for (int i = 0; i < this.list.size() - 2; i++) {
            if (this.list.get(i) - this.list.get(i + 1) != -1) {
                return false;
            } 
        }
        return true;
    }

    public String toString() {
       
        String solution = "\n";
        int count = 1;

        for (int i = 0; i < list.size() - 1; i++)  {
            if (list.get(i) != 0) {
                if (count == this.n) {
                    solution += String.format("%4d", list.get(i));
                    solution += "\n";
                    count = 1;
                } else {
                    solution += String.format("%4d", list.get(i));
                    count++;
                }
            } else {
                if (count == this.n) {
                    solution += String.format("%4s", ".");
                    solution += "\n";
                    count = 1;
                } else {
                    solution += String.format("%4s", ".");
                    count++;
                }
            }
        }

        if (list.get(list.size() - 1) == 0) {
            solution += String.format("%4s", ".");
        } else {
            solution += String.format("%4d", list.get(list.size() - 1));
        }

        return solution;
    }
}
