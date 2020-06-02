package SpaceWars;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Game extends Application {

    public int counter;

    private boolean running = false;

    private Board enemyBoard, playerBoard;

    private int shipsToPlace = 5;

    private boolean enemyTurn = false;

    private Random random = new Random();

    public static Stage passStage = new Stage();

    File file = new File("src/images/wins.txt");

    Scanner scanner = new Scanner(file);

    public Game() throws FileNotFoundException {
    }

    private Parent createContent() {
        BorderPane root = new BorderPane();
        root.setPrefSize(600, 800);

        root.setRight(new Text("RIGHT SIDEBAR - CONTROLS\n         CLICK TO WIN!\n           PLACEMENT:\n     Right Click=Horizontal\n    Left Click=Vertical\nWhen you hit an enemy ship \nthe square turns red! "));


        enemyBoard = new Board(true, event -> {
            if (!running)
                return;

            Board.Cell cell = (Board.Cell) event.getSource();
            if (cell.wasShot)
                return;

            enemyTurn = !cell.shoot();

            if (enemyBoard.ships == 0) {
                System.out.println("YOU WIN");
                counter++;
                System.out.println("number of wins = " +counter);
                num_of_wins();
                System.exit(0);
            }

            if (enemyTurn)
                enemyMove();
        });

        playerBoard = new Board(false, event -> {
            if (running)
                return;

            Board.Cell cell = (Board.Cell) event.getSource();
            if (playerBoard.placeShip(new Ship(shipsToPlace, event.getButton() == MouseButton.PRIMARY), cell.x, cell.y)) {
                if (--shipsToPlace == 0) {
                    startGame();
                }
            }
        });

        VBox vbox = new VBox(50, enemyBoard, playerBoard);
        vbox.setAlignment(Pos.CENTER);

        root.setCenter(vbox);

        return root;
    }

    private void enemyMove() {
        while (enemyTurn) {
            int x = random.nextInt(10);
            int y = random.nextInt(10);

            Board.Cell cell = playerBoard.getCell(x, y);
            if (cell.wasShot)
                continue;

            enemyTurn = cell.shoot();

            if (playerBoard.ships == 0) {
                System.out.println("YOU LOSE");
                System.exit(0);
            }
        }
    }

    public void startGame() {
        // topothetisi plion exthrou
        int type = 5;

        while (type > 0) {
            int x = random.nextInt(10);
            int y = random.nextInt(10);

            if (enemyBoard.placeShip(new Ship(type, Math.random() < 0.5), x, y)) {
                type--;
            }
        }

        running = true;
    }
    private void num_of_wins() {
        try(FileWriter fileWriter = new FileWriter(file)) {
            while (scanner.hasNextLine()){
                counter = Integer.valueOf(scanner.findInLine("0")) + 1;
        }
            System.out.println("counter ap thn getCounter " + counter);
            System.out.println("new counter ="+counter);
            fileWriter.write(String.valueOf(counter));
            System.out.println("egrafh sto arxeio");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(createContent());
        primaryStage.setTitle("Space Wars");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
        passStage = primaryStage;
    }



}
