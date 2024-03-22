package ua.nure.chess.models.board;

import javafx.scene.control.Button;
import ua.nure.chess.models.FigureAttachment;
import ua.nure.chess.models.figures.Empty;
import ua.nure.chess.models.figures.Figure;

public class Field extends Button {
    private int x, y;
    public static final int CELL_SIZE  = 50;
    private final Figure figure;

    public Field(int x, int y, FigureAttachment attachment) {
        this.figure = new Empty();
        this.figure.setAttachment(attachment);
        this.setText(this.figure.getSymbol());
        this.createUI(x, y);
    }
    public Field(Figure figure, int x, int y, FigureAttachment attachment) {
        this.figure = figure;
        this.figure.setAttachment(attachment);
        this.setText(this.figure.getSymbol());
        this.createUI(x, y);
    }
    private void createUI(int x, int y) {
        this.setPosition(x, y);
        this.setColor(x, y);
        this.setSize();
    }

    private void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
    private void setSize() {
        this.setMinWidth(CELL_SIZE);
        this.setMinHeight(CELL_SIZE);
    }
    private void setColor(int x, int y) {
        boolean condition = (x % 2 == 0 && y % 2 == 0) || (x % 2 != 0 && y % 2 != 0);
        String style = "-fx-font-weight: bold; -fx-font-size: 18px; ";
        style += condition ? "-fx-background-color: #f1f1f1; " : "-fx-background-color: #c0c0c0; ";
        style += figure.getAttachment() == FigureAttachment.WHITE ? "-fx-text-fill: #66cc00;" : "-fx-text-fill: #cc0000;";

        this.setStyle(style);
    }

    public boolean canAttack(Field defender) {
        return figure.canAttack(x, y, defender);
    }
    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }
    public FigureAttachment getAttachment() {
        return this.figure.getAttachment();
    }

    public Figure getFigure() {
        return figure;
    }
}
