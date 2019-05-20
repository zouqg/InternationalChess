package sample.entity.strategy;

import sample.entity.chessPiece;

public class KnightStrategy implements MoveStrategy {
    @Override
    public boolean move(chessPiece currentChessPiece,int[][] chess,int x,int y){
        //进行移动
        int sum = Math.abs(currentChessPiece.getX()-x) + Math.abs(currentChessPiece.getY()-y);
        if(sum==3){
            currentChessPiece.move(x,y);
            return true;
        }
        return false;
    }
}
