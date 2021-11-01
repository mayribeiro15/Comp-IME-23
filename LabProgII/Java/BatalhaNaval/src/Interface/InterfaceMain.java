package Interface;

import java.util.Random;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import Interface.Tabuleiro.Cell;

public class InterfaceMain extends Application {

    private boolean running = false;
    private Tabuleiro campoAdversario, campoJogador;

    private int shipsToPlace = 5;

    private boolean enemyTurn = false;

    private Random random = new Random();

    private Parent createContent() {
        BorderPane root = new BorderPane();
        root.setPrefSize(600, 700);

        root.setTop(new Text("Batalha Naval"));

        campoAdversario = new Tabuleiro(true, event -> {
            if (!running)
                return;

            Cell cell = (Cell) event.getSource();
            if (cell.wasShot)
                return;

            enemyTurn = !cell.shoot();

            if (campoAdversario.ships == 0) {
                System.out.println("YOU WIN");
                System.exit(0);
            }

            if (enemyTurn)
                enemyMove();
        });

        campoJogador = new Tabuleiro(false, event -> {
            if (running)
                return;

            Cell cell = (Cell) event.getSource();
            if (campoJogador.placeShip(new Navio(shipsToPlace, event.getButton() == MouseButton.PRIMARY), cell.x, cell.y)) {
                if (--shipsToPlace == 0) {
                    startGame();
                }
            }
        });

        VBox vbox = new VBox(50, campoAdversario, campoJogador);
        vbox.setAlignment(Pos.CENTER);

        root.setCenter(vbox);

        return root;
    }

    private void enemyMove() {
        while (enemyTurn) {
            int x = random.nextInt(10);
            int y = random.nextInt(10);

            Cell cell = campoJogador.getCell(x, y);
            if (cell.wasShot)
                continue;

            enemyTurn = cell.shoot();

            if (campoJogador.ships == 0) {
                System.out.println("YOU LOSE");
                System.exit(0);
            }
        }
    }

    private void startGame() {
        // place enemy ships
        int type = 5;

        while (type > 0) {
            int x = random.nextInt(10);
            int y = random.nextInt(10);

            if (campoAdversario.placeShip(new Navio(type, Math.random() < 0.5), x, y)) {
                type--;
            }
        }

        running = true;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(createContent());
        primaryStage.setTitle("Battleship");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}