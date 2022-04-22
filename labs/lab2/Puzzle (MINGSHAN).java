import java.util.List;
import java.util.ArrayList;

class Puzzle {
    private final Grid2D grid;
    private final int numOfCols;
    
    Puzzle(int n) {
        ImList<Integer> tempList = new ImList<Integer>();
        for (int i = 1; i < n * n; i++) {
            tempList = tempList.add(i);
        }
        //take blank tile to be 0;
        tempList = tempList.add(0);
        this.grid = new Grid2D(tempList, n);
        this.numOfCols = n;
    }

    Puzzle(Grid2D grid, int numOfCols) {
        this.grid = grid;
        this.numOfCols = numOfCols;
    }


    public Puzzle move(int num) {
        int blankTileRowIndex = this.grid.rowIndex(0);
        int blankTileColIndex = this.grid.colIndex(0);
        int numRowIndex = this.grid.rowIndex(num);
        int numColIndex = this.grid.colIndex(num);

        if (blankTileRowIndex == -1 || blankTileColIndex == -1 ||
            numRowIndex == -1 || numColIndex == -1) {
            return this;
        }

        if (numRowIndex == blankTileRowIndex &&
                Math.abs(numColIndex - blankTileColIndex) == 1) {
            Grid2D tempGrid = this.grid.set(blankTileRowIndex, blankTileColIndex, num)
                .set(numRowIndex, numColIndex, 0);
            return new Puzzle(tempGrid, this.numOfCols);
        }

        if (numColIndex == blankTileColIndex &&
                Math.abs(numRowIndex - blankTileRowIndex) == 1) {
            Grid2D tempGrid = this.grid.set(blankTileRowIndex, blankTileColIndex, num)
                .set(numRowIndex, numColIndex, 0);
            return new Puzzle(tempGrid, this.numOfCols);
        }
        return this;
    }
    
    public boolean isSolved() {
        Puzzle solvedPuzzle = new Puzzle(this.numOfCols);
        return this.toString().equals(solvedPuzzle.toString());
    }

    @Override
    public String toString() {
        try {
            String result = "\n";
            int count = 1;
            for (int i = 0; i < this.numOfCols * this.numOfCols - 1; i++) {
                int currentTile = this.grid.get(Math.floorDiv(i, this.numOfCols),
                        i % numOfCols);
                if (currentTile == 0) {
                    if (count == this.numOfCols) {
                        result += String.format("%4s", ".");
                        count = 1;
                        result += "\n";
                    } else {
                        result += String.format("%4s", ".");
                        count++;
                    }
                } else {
                    if (count == this.numOfCols) {
                        result += String.format("%4d", currentTile);
                        count = 1;
                        result += "\n";
                    } else {
                        result += String.format("%4d", currentTile);
                        count++;
                    }
                }   
            }

            int lastTile = this.grid.get(this.numOfCols - 1, this.numOfCols - 1);
            if (lastTile == 0) {
                result += String.format("%4s", ".");
            } else {
                result += String.format("%4d", lastTile);
            }

            return result;
        } catch (Exception e) {
            System.out.println(e);
            return "e";
        }
    }

}
