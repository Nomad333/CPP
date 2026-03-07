package lab1.game2048.main;

import lab1.game2048.color.ConsoleColor;
import lab1.game2048.color.StringWrapper;
import lab1.game2048.game.Game;
import lab1.game2048.game.Game2048;

import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Game game2048 = new Game2048(4, 4);
        Scanner scanner = new Scanner(System.in);

        List<Runnable> gameMethods = List.of(
                game2048::moveDown,
                game2048::moveUp,
                game2048::moveLeft,
                game2048::moveRight
        );

        int indexMethod = 0;
        boolean end = false;
        boolean auto = false;

        do {
            game2048.print();
            if (game2048.isGameEnded()) {
                System.out.println(StringWrapper.str("Game ended", ConsoleColor.RED_BOLD));
            }
            if (auto && !game2048.isGameEnded()){
                gameMethods.get(indexMethod).run();
                indexMethod = (indexMethod + 1) % gameMethods.size();
                Thread.sleep(100);
            } else {
                auto = false;
                System.out.println("A/W/S/D - move cells, R - new game, AUTO - auto game, E - exit");
                var nextCommand = scanner.nextLine().toUpperCase(Locale.ROOT);
                switch (nextCommand) {
                    case "A":
                        game2048.moveLeft();
                        break;
                    case "W":
                        game2048.moveUp();
                        break;
                    case "S":
                        game2048.moveDown();
                        break;
                    case "D":
                        game2048.moveRight();
                        break;
                    case "R":
                        game2048.newGame(4, 4);
                        break;
                    case "E":
                        end = true;
                        break;
                    case "AUTO":
                        auto = true;
                        break;
                    default:
                        System.out.println("invalid command");
                        Thread.sleep(500);
                }
            }

        } while (!end);
    }
}
