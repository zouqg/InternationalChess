package sample.entity.strategy;

import sample.entity.chessPiece;

public class BishopStrategy implements MoveStrategy {
    @Override
    public boolean move(chessPiece currentChessPiece,int[][] chess,int x,int y){
        int ax = currentChessPiece.getX();
        int ay = currentChessPiece.getY();
        if(Math.abs(ax-x)!=Math.abs(ay-y) || !isEmpty(ax,ay,x,y,chess))
            return false;

        //进行移动或者吃子
        currentChessPiece.move(x,y);
        System.out.println(ax+" "+ay+" "+x+" "+y);
        return true;

    }

    //判断两个点的连线上是否有棋子
    public boolean isEmpty(int x,int y,int x1,int y1,int[][] chess){
        if(x<x1&&y<y1){
            for(int i=1;i<(x1-x);i++)
                if(chess[y+i][x+i]!=0)
                    return false;
        }
        else if(x<x1&&y>y1){
            for(int i=1;i<(x1-x);i++)
                if(chess[y-i][x+i]!=0)
                    return false;
        }
        else if(x>x1&&y<y1){
            for(int i=1;i<(x-x1);i++)
                if(chess[y+i][x-i]!=0)
                    return false;
        }
        else if  (x>x1&&y>y1){
            for(int i=1;i<(x-x1);i++)
                if(chess[y-i][x-i]!=0)
                    return false;
        }
        return true;
    }
}
