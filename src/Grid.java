public class Grid {
    private int grid[][];
    private int row;
    private int col;
    public Grid(int _r,int _c)
    {
        this.row = _r;
        this.col = _c;
        this.initGrid();
    }

    public void initGrid()
    {
        grid = new int[this.row][this.col];
        for(int i = 0 ; i < this.row; i++)
        {
            for(int j = 0 ; j < col ; j++) {
                grid[i][j] = GridPosition.EMPTY.ordinal();
            }
        }
    }
    public int[][] getGrid() {
        return this.grid;
    }
    public int getColumnCount()
    {
        return this.col;
    }
    public int placePiece(GridPosition piece,int column)
    {
        if(column < 0 || column > this.col)
        {
            throw new Error("Invalid column");
        }
        if(piece.ordinal() == GridPosition.EMPTY.ordinal())
        {
            throw new Error("Give Either Red or Yellow");
        }
        for(int row = this.row - 1; row >= 0; row--)
        {
            if(grid[row][column] == GridPosition.EMPTY.ordinal())
            {
                grid[row][column] = piece.ordinal();
                return row;
            }
        }
        return - 1;
    }
    public boolean checkWin(int connectN, int row,int col, GridPosition piece)
    {
        int count = 0;
        // horizontal
        for(int i = 0; i < this.row; i++)
        {
            if(grid[i][col] == piece.ordinal())
            {
                count++;
            }
            else{
                count = 0;
            }
            if(count == connectN)
            {
                return true;
            }
        }
        // vertical
        count = 0;
        for(int j = 0; j < this.col; j++)
        {
            if(grid[row][j] == piece.ordinal())
            {
                count++;
            }else{
                count = 0;
            }
            if(count == connectN)
            {
                return true;
            }
        }
        count = 0;
        int i = row, j = col;
        while(i < this.row && col >= 0)
        {
            if(grid[i][j] == piece.ordinal())
            {
                count++;
            }else{
                count = 0;
            }
            if(count == connectN)
            {
                return true;
            }
            i++;
            col--;
        }
        i = row; j = col;
        while(i < this.row && j < this.col)
        {
            if(grid[i][j] == piece.ordinal())
            {
                count++;
            }else{
                count = 0;
            }
            if(count == connectN)
            {
                return true;
            }
            i++;
            col++;
        }
        return false;
    }
}
