package ua.nure.chess.models.figures;

import ua.nure.chess.models.FigureAttachment;
import ua.nure.chess.models.board.Field;

public abstract class Figure {
    public abstract String getSymbol();
    public abstract boolean canAttack(int x, int y, Field defender);
    protected FigureAttachment attachment;

    public void setAttachment(FigureAttachment attachment) {
        this.attachment = attachment;
    }

    public FigureAttachment getAttachment() {
        return attachment;
    }
}
