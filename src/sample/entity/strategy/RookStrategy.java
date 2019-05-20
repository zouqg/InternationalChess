package sample.entity.strategy;

import sample.entity.chessPiece;

public class RookStrategy implements MoveStrategy {
    @Override
    public boolean move(chessPiece currentChessPiece,int[][] chess,int x,int y){

        int ax = currentChessPiece.getX();
        int ay = currentChessPiece.getY();
        //进行移动
        if((x==ax && isEmptyColumn(ax,ay,x,y,chess)) || (y==ay && isEmptyRow(ax,ay,x,y,chess))){
            currentChessPiece.move(x,y);
            return true;
        }
        return false;
    }

    public Boolean isEmptyRow(int x,int y,int x1,int y1,int[][] chess){
        if(x<x1){
            for(int i=1;i<Math.abs(x-x1);i++)
                if(chess[y][x+i]!=0)
                    return false;
        }
        else{
            for(int i=1;i<Math.abs(x-x1);i++)
                if(chess[y][x-i]!=0)
                    return false;
        }
        return true;
    }

    public Boolean isEmptyColumn(int x,int y,int x1,int y1,int[][] chess){
        if(y<y1){
            for(int i=1;i<Math.abs(x-x1);i++)
                if(chess[y+i][x]!=0)
                    return false;
        }
        else{
            for(int i=1;i<Math.abs(x-x1);i++)
                if(chess[y+i][x]!=0)
                    return false;
        }
        return true;
    }
}
