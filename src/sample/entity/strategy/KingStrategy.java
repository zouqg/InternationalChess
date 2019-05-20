package sample.entity.strategy;

import sample.entity.chessPiece;

public class KingStrategy implements MoveStrategy{
    @Override
    public boolean move(chessPiece currentChessPiece,int[][] chess,int x,int y){
        //进行移动
        if(Math.abs(x-currentChessPiece.getX())<=1 && Math.abs(y-currentChessPiece.getY())<=1){
            currentChessPiece.move(x,y);
            return true;
        }
        return false;
    }
}
