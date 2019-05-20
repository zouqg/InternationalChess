package sample.entity.strategy;

import sample.entity.chessPiece;

public interface MoveStrategy {
    public boolean move(chessPiece currentChessPiece,int[][] chess,int x,int y);
}
