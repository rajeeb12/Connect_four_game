import java.util.HashMap;
import java.util.Scanner;

public class Game {
    static Scanner sc = new Scanner(System.in);
    private Grid grid;

    private Player[] players;
    HashMap<String, Integer> score;
    int connectN;
    int maxScore;


    public Game(int _connectN, int _maxScore, Grid _grid)
    {
        this.connectN = _connectN;
        this.maxScore = _maxScore;
        this.grid = _grid;

        this.players = new Player[]{new Player("player1" , GridPosition.RED), new Player("Player 2",GridPosition.YELLOW)};

        this.score = new HashMap<>();

        for(Player p: players) {
            score.put(p.getName(), 0);
        }
    }

    public void printBoard()
    {
        System.out.println("Board:");
        int [][] grid = this.grid.getGrid();
        for(int i = 0 ; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == GridPosition.EMPTY.ordinal()) {
                    System.out.print("0 ");
                }
                if (grid[i][j] == GridPosition.RED.ordinal()) {
                    System.out.print("1 ");
                }
                if (grid[i][j] == GridPosition.YELLOW.ordinal()) {
                    System.out.print("2 ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
    private int[] playMove(Player player) {
        printBoard();
        System.out.println(player.getName() + "'s turn");
        int colCount = this.grid.getColumnCount();

        System.out.println("Give number between 0 to " + (colCount - 1));
        int moveColumn = sc.nextInt();
        int moveRow = this.grid.placePiece(player.getPiece(), moveColumn);
        return new int[]{moveRow, moveColumn};
    }
    private Player playGround(){
        while(true)
        {
            for(Player player: players)
            {
                int[] pos= playMove(player);
                int row = pos[0];
                int col = pos[1];
                GridPosition piece = player.getPiece();
                if(this.grid.checkWin(this.connectN, row, col, piece)){
                    this.score.put(player.getName(), score.get(player.getName()) + 1);
                    return player;
                }
            }
        }
    }
    public void play()
    {
        int maxscore = 0;
        Player winner = null;

        while(maxscore < this.maxScore)
        {
            winner = playGround();
            System.out.println(winner.getName() + "won the round");
            maxscore = Math.max(maxscore, this.score.get(winner.getName()));
            this.grid.initGrid();
        }
        System.out.println(winner.getName() +"won the game");
    }
}
