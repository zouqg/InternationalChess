package sample.entity.strategy;

import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Dialog;
import sample.entity.chessPiece;

public class whitePawnStrategy implements MoveStrategy {
    //移动次数
    private int moveTimes = 0;

    @Override
    public boolean move(chessPiece currentChessPiece, int[][] chess,int x,int y) {
        //下一个坐标无棋子，进行移动
        if(chess[y][x]!=2){
            //第一次移动
            if(moveTimes==0){
                if(currentChessPiece.getX()==x && currentChessPiece.getY()-y<=2){
                    currentChessPiece.move(x,y);
                    moveTimes++;
                    return true;
                }
            }
            else{
                if(currentChessPiece.getX()==x && currentChessPiece.getY()-y==1){
                    currentChessPiece.move(x,y);
                    //到达底部，升级
                    System.out.println("fasd");
                    if(y==0)
                        changeType(currentChessPiece);
                    return true;
                }
            }
        }
        //下一个坐标有棋子，吃子
        else{
            //符合吃子位置
            if((Math.abs(x-currentChessPiece.getX())==1 && currentChessPiece.getY()-y==1)
            ||(Math.abs(x-currentChessPiece.getX())==1 && currentChessPiece.getY()-y==2 &&moveTimes ==0)){
                currentChessPiece.move(x,y);
                if(y==0)
                    changeType(currentChessPiece);
                //返回成功吃到子
                return true;
            }
        }
        return false;
    }

    public void changeType(chessPiece piece){
        ChoiceDialog choiceDialog = new ChoiceDialog("afd");
        choiceDialog.show();
    }
}
