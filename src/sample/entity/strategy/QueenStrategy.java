package sample.entity.strategy;

import sample.entity.chessPiece;

public class QueenStrategy implements MoveStrategy {
    @Override
    public boolean move(chessPiece currentChessPiece,int[][] chess,int x,int y){
        //进行移动
        int x1 = currentChessPiece.getX();
        int y1 = currentChessPiece.getY();
        if(x==x1 || y==y1 || Math.abs(x-x1)==(Math.abs(y-y1))){
            if(isEmpty(x1,y1,x,y,chess)){
                currentChessPiece.move(x,y);
                return true;
            }
        }
        return false;
    }

    //判断两个点的连线上是否有棋子
    public boolean isEmpty(int x,int y,int x1,int y1,int[][] chess){
        if(x<x1&&y<y1){
            for(int i=1;i<(x1-x);i++)
                if(chess[y+i][x+i]!=0)
                    return false;
        }
        else if(x==x1&&y<y1){
            for(int i=1;i<(x1-x);i++)
                if(chess[y+i][x]!=0)
                    return false;
        }
        else if(x<x1&&y>y1){
            for(int i=1;i<(x1-x);i++)
                if(chess[y-i][x+i]!=0)
                    return false;
        }
        else if(x==x1&&y>y1){
            for(int i=1;i<(x1-x);i++)
                if(chess[y-i][x]!=0)
                    return false;
        }
        else if(x>x1&&y<y1){
            for(int i=1;i<(x-x1);i++)
                if(chess[y+i][x-i]!=0)
                    return false;
        }
        else if(x>x1&&y==y1){
            for(int i=1;i<(x-x1);i++)
                if(chess[y][x-i]!=0)
                    return false;
        }
        else if  (x>x1&&y>y1){
            for(int i=1;i<(x-x1);i++)
                if(chess[y-i][x-i]!=0)
                    return false;
        }
        else if  (x>x1&&y==y1){
            for(int i=1;i<(x-x1);i++)
                if(chess[y][x-i]!=0)
                    return false;
        }
        return true;
    }
}

