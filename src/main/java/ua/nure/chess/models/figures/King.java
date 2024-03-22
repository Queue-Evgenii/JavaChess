package ua.nure.chess.models.figures;

import ua.nure.chess.models.board.Field;

public class King extends Figure {
    @Override
    public String getSymbol() {
        return "K";
    }
    @Override
    public boolean canAttack(int x, int y, Field defender) {
        return false;
    }
}
