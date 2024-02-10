
public class Main {
    public static void main(String[] args) {
        Grid grid = new Grid(4,4);
        Game game = new Game(2,1, grid);
        game.play();
    }
}