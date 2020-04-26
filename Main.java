import java.io.IOException;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws IOException {
        TreeSet<String> isLose = new TreeSet<>();
        Gameplay game = new Gameplay();
        game.printBoard();
        char button;

    while (true) {
        try {
           button = (char) System.in.read();
            if (button == 'w' || button == 'W') {
                isLose.add("up");
                game.moveUp();
                game.printCounter();
                game.generateBlock();
                game.printBoard();
                isLose.remove("up");
            }
            if (button == 'a' || button == 'A') {
                isLose.add("left");
                game.moveLeft();
                game.printCounter();
                game.generateBlock();
                game.printBoard();
                isLose.remove("left");
            }
            if (button == 's' || button == 'S') {
                isLose.add("down");
                game.moveDown();
                game.printCounter();
                game.generateBlock();
                game.printBoard();
                isLose.remove("down");
            }
            if (button == 'd' || button == 'D') {
                isLose.add("right");
                game.moveRight();
                game.printCounter();
                game.generateBlock();
                game.printBoard();
                isLose.remove("right");
            }

            if (game.isWin()) {
                System.out.println(" W I N ");
            }
        }catch (IllegalArgumentException e) {
            if(isLose.contains("up") & isLose.contains("down") & isLose.contains("left") & isLose.contains("right")){
                System.out.println("You lose");
                break;
            }
            System.out.println("Try other move");
            continue;
        }
    }

    }
}
