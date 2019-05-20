package sample;

import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import sample.entity.chessPiece;
import sample.entity.chessType;
import sample.entity.strategy.MoveStrategy;
import sample.view.broadPane;

public class Controller implements EventHandler<MouseEvent>{
    private broadPane broadPane;
    private int[][] chess = new int[8][8];

    public Controller(sample.view.broadPane broadPane) {
        this.broadPane = broadPane;
    }

    @Override
    public void handle(MouseEvent event) {

        refresh();

        //获取鼠标单击坐标，转化为格子的坐标
        int x = (int)(event.getX()/broadPane.getCellLen());
        int y = (int)(event.getY()/broadPane.getCellLen());

        //点击位置超出了棋盘的范围，不进行响应
        if(x>7||y>7)
            return ;

        //如果没有选中棋子，进行棋子选择
        if(isSelected()==null){
            chessPiece piece = isEmpty(x,y);
            //该座标无棋子
            if(piece==null)
                return;
            //将该棋子设为选中
            piece.setSelected(true);
            piece.getImageView().setSmooth(true);
        }
        //否则进行移动，或重选需要的移动棋子
        else{
            chessPiece currentPiece = isSelected();
            chessPiece newPiece = isEmpty(x,y);
            //持方没有重选棋子，进行移动判断
            if(newPiece==null){
                //点击坐标的棋子
                chessPiece nextPiece = getPiece(x,y);
                //使用移动策略进行移动或吃子
                MoveStrategy moveStrategy = currentPiece.getMoveStrategy();
                if(moveStrategy.move(currentPiece,chess,x,y)){
                    //如果成功吃子或者移动，则更换持方
                    if(broadPane.getCurrentSide().equals("W"))
                        broadPane.setCurrentSide("B");
                    else
                        broadPane.setCurrentSide("W");
                    //如果是吃子，则nextPiece存在，需要将其移出棋子列表，并去除其图像
                    if(nextPiece!=null){
                        isGameOver(nextPiece);
                        remove(nextPiece);
                    }
                }
            }
            //重选了棋子
            else{
                currentPiece.setSelected(false);
                newPiece.setSelected(true);
            }
        }
    }

    /**
     * 持放是否已经选择了一个棋子
     * 如果当前持放是白方，返回白方是否选中了一个需要进行移动的棋子
     * @return 返回被选中的棋子，如果没有则返回null
     */
    public chessPiece isSelected(){
        if(broadPane.getCurrentSide().equals("W")){
            for(int i=0;i<broadPane.getWhiteChessList().size();i++){
                chessPiece piece = (chessPiece) broadPane.getWhiteChessList().get(i);
                if(piece.isSelected())
                    return piece;
            }
        }
        else{
            for(int i=0;i<broadPane.getBlackChessList().size();i++){
                chessPiece piece = (chessPiece) broadPane.getBlackChessList().get(i);
                if(piece.isSelected())
                    return piece;
            }
        }
        return null;
    }

    /**
     * 返回当前持放在x，y的棋子
     * @param x
     * @param y
     * @return
     */
    public chessPiece isEmpty(int x, int y){
        //如果当前持放是白方，返回该座标是否有白方棋子
       if(broadPane.getCurrentSide().equals("W")){
           for(int i=0;i<broadPane.getWhiteChessList().size();i++){
               chessPiece piece = (chessPiece) broadPane.getWhiteChessList().get(i);
               if(piece.getX()==x && piece.getY()==y)
                   return piece;
           }
       }
       //如果当前持放是黑方，返回该座标是否有黑方棋子
       else{
           for(int i=0;i<broadPane.getBlackChessList().size();i++){
               chessPiece piece = (chessPiece) broadPane.getBlackChessList().get(i);
               if(piece.getX()==x && piece.getY()==y)
                   return piece;
           }
       }
       return null;
    }

    /**
     * 获得棋盘上坐标x，y上的棋子，如果不存在棋子，则返回null
     * @param x
     * @param y
     * @return
     */
    public chessPiece getPiece(int x, int y){
        for(int i=0;i<broadPane.getWhiteChessList().size();i++){
            chessPiece piece = (chessPiece) broadPane.getWhiteChessList().get(i);
            if(piece.getX()==x && piece.getY()==y)
                return piece;
        }
        for(int i=0;i<broadPane.getBlackChessList().size();i++){
            chessPiece piece = (chessPiece) broadPane.getBlackChessList().get(i);
            if(piece.getX()==x && piece.getY()==y)
                return piece;
        }
        return null;
    }

    public void remove(chessPiece piece){
        piece.getImageView().setImage(null);
        if(broadPane.getCurrentSide().equals("B")){
            for(int i=0;i<broadPane.getBlackChessList().size();i++){
                chessPiece piece1 = (chessPiece) broadPane.getBlackChessList().get(i);
                if(piece.equals(piece1)){
                    broadPane.getBlackChessList().remove(i);
                    break;
                }
            }
        }
        else{
            for(int i=0;i<broadPane.getWhiteChessList().size();i++){
                chessPiece piece1 = (chessPiece) broadPane.getWhiteChessList().get(i);
                if(piece.equals(piece1)){
                    broadPane.getWhiteChessList().remove(i);
                    break;
                }
            }
        }
    }

    //更新棋盘数组
    public void refresh(){
        //初始化棋盘数组
        for(int i=0;i<8;i++)
            for(int j=0;j<8;j++){
                chess[i][j] = 0;
            }
        for(int i=0;i<broadPane.getWhiteChessList().size();i++){
            chessPiece piece = (chessPiece) broadPane.getWhiteChessList().get(i);
            chess[piece.getY()][piece.getX()] = 1;
        }
        for(int i=0;i<broadPane.getBlackChessList().size();i++){
            chessPiece piece = (chessPiece) broadPane.getBlackChessList().get(i);
            chess[piece.getY()][piece.getX()] = 2;
        }
    }

    //判断游戏是否结束
    public void isGameOver(chessPiece piece){
        if(piece.getChessType().equals(chessType.blackKing) || piece.getChessType().equals(chessType.whiteKing )){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("游戏结束！！");
            String content = broadPane.getCurrentSide().equals("W")? "获胜者为黑方！！！":"获胜者为白方！！！";
            alert.setContentText(content);
            alert.show();
        }
    }
}
