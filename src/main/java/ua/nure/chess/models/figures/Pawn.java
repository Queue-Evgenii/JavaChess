package ua.nure.chess.models.figures;

import ua.nure.chess.models.FigureAttachment;
import ua.nure.chess.models.board.Field;

public class Pawn extends Figure {
    @Override
    public String getSymbol() {
        return "p";
    }

    @Override
    public boolean canAttack(int x, int y, Field defender) {
        boolean conditionY = attachment == FigureAttachment.WHITE ? (y - 1 == defender.getY()) : (y + 1 == defender.getY());

        Figure figure = defender.getFigure();
        if (figure instanceof Empty && x == defender.getX() && conditionY) return true;
        if (figure.getAttachment() == attachment) return false;

        boolean conditionX = (x + 1 == defender.getX() || x - 1 == defender.getX());
        return conditionX && conditionY;
    }
}
