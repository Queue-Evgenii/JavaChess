package ua.nure.chess.models.board;

import javafx.scene.layout.GridPane;
import ua.nure.chess.models.FigureAttachment;
import ua.nure.chess.models.figures.*;

public class Board extends GridPane {
    public static final int SIZE = 8;
    private Field[][] grid;
    private Field attacker = null;

    public Board() {
        this.create();
        System.out.println("Hello");
    }

    public void create() {
        this.grid = new Field[SIZE][SIZE];

        for (int i = 0; i < SIZE; ++i)
            for (int j = 0; j < SIZE; ++j) {
                setCell(i, j);

                int finalI = i, finalJ = j;

                this.grid[i][j].setOnAction(event -> {
                    if (attacker == null) {
                        attacker = grid[finalI][finalJ];
                        return;
                    }
                    if (attacker == grid[finalI][finalJ]) {
                        attacker = null;
                        return;
                    }
                    if (attacker != grid[finalI][finalJ]) {
                        this.attack(attacker, grid[finalI][finalJ]);
                        attacker = null;
                    }
                });
            }

        setGrid();
        this.setStyle("-fx-border-color: black; -fx-border-width: 2px;");
    }

    private void setCell(int i, int j) {
        FigureAttachment color = (j >= SIZE / 2 ? FigureAttachment.WHITE : FigureAttachment.BLACK);
        if (i == 4 && (j == 0 || j == SIZE - 1)) {
            this.grid[i][j] = new Field(new King(), i, j, color);
            return;
        }
        if (i == 3 && (j == 0 || j == SIZE - 1)) {
            this.grid[i][j] = new Field(new Queen(), i, j, color);
            return;
        }
        if ((i == 2 || i == SIZE - 3) && (j == 0 || j == SIZE - 1)) {
            this.grid[i][j] = new Field(new Bishop(), i, j, color);
            return;
        }
        if ((i == 1 || i == SIZE - 2) && (j == 0 || j == SIZE - 1)) {
            this.grid[i][j] = new Field(new Knight(), i, j, color);
            return;
        }
        if ((i == 0 || i == SIZE - 1) && (j == 0 || j == SIZE - 1)) {
            this.grid[i][j] = new Field(new Rook(), i, j, color);
            return;
        }
        if (j == 1 || j == SIZE - 2) {
            this.grid[i][j] = new Field(new Pawn(), i, j, color);
            return;
        }
        this.grid[i][j] = new Field(i, j, color);

    }
    private void setGrid() {
        getChildren().clear();
        for (int i = 0; i < SIZE; ++i)
            for (int j = 0; j < SIZE; ++j)
                add(this.grid[i][j], i, j);
    }

    private void attack(Field attacker, Field defender) {
        System.out.println(attacker.canAttack(defender));
        if (!attacker.canAttack(defender)) {
            return;
        }
        grid[defender.getX()][defender.getY()] = new Field(attacker.getFigure(), defender.getX(), defender.getY(), attacker.getAttachment());
        grid[attacker.getX()][attacker.getY()] = new Field(defender.getFigure(), attacker.getX(), attacker.getY(), defender.getAttachment());
        setGrid();
    }

}
