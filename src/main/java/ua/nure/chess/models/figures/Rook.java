package ua.nure.chess.models.figures;

import ua.nure.chess.models.board.Field;

public class Rook extends Figure {
    @Override
    public String getSymbol() {
        return "R";
    }
    @Override
    public boolean canAttack(int x, int y, Field defender) {
        return false;
    }
}
