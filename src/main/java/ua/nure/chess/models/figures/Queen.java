package ua.nure.chess.models.figures;

import ua.nure.chess.models.board.Field;

public class Queen extends Figure {
    @Override
    public String getSymbol() {
        return "Q";
    }
    @Override
    public boolean canAttack(int x, int y, Field defender) {
        return false;
    }
}
