package sample.view;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import sample.entity.chessPiece;
import sample.entity.chessType;
import sample.entity.strategy.*;


import java.util.ArrayList;

public class broadPane extends Pane {
    //棋子列表
    private ArrayList whiteChessList = new ArrayList<chessPiece>();
    private ArrayList blackChessList = new ArrayList<chessPiece>();

    //目前持方,对棋子进行操作，初始为白方先走
    private String currentSide = "W";

    private Canvas canvas;
    private GraphicsContext gc;
    private double cellLen;

    //生成国际象棋对象
    public broadPane(double cellLen) {
        //初始化画布，背景
        this.canvas = new Canvas(10*cellLen,10*cellLen);
        this.gc = canvas.getGraphicsContext2D();
        this.cellLen = cellLen;
        getChildren().add(canvas);

        //初始化国际象棋
        initChess();
    }

    /**
     * 初始化国际象棋：
     * 1、绘制棋盘背景
     * 2、创建棋子列表
     */
    public void initChess(){
        drawBackground();
        initChessPiece();

    }

    /**
     * 初始化棋子
     */
    public void initChessPiece(){
        //初始化黑色棋子
        blackPawn();
        blackKing();
        blackQueue();
        blackBishop();
        blackKnight();
        blackRook();

        //初始化白色棋子
        whitePawn();
        whiteKing();
        whiteQueue();
        whiteBishop();
        whiteKnight();
        whiteRook();


    }

    //对图标的位置和形状进行裁剪放置
    public void reshapeImageView(int x,int y,chessPiece piece){
        piece.getImageView().setX(x*cellLen);
        piece.getImageView().setY(y*cellLen);
        piece.getImageView().setFitHeight(cellLen);
        piece.getImageView().setFitWidth(cellLen);
    }

    //初始化8个黑色士兵
    public void blackPawn(){
        for(int i=0;i<8;i++){
            chessPiece piece = new chessPiece(i,1, chessType.blackPawn,new blackPawnStrategy());
            blackChessList.add(piece);
            reshapeImageView(i,1,piece);
            getChildren().add(piece.getImageView());
        }
    }

    //初始化黑国王
    public void blackKing(){
        chessPiece piece = new chessPiece(4,0,chessType.blackKing,new KingStrategy());
        blackChessList.add(piece);
        reshapeImageView(4,0,piece);
        blackChessList.add(piece);
        getChildren().add(piece.getImageView());
    }

    //初始化黑色皇后
    public void blackQueue(){
        chessPiece piece = new chessPiece(3,0,chessType.blackQueue,new QueenStrategy());
        blackChessList.add(piece);
        reshapeImageView(3,0,piece);
        getChildren().add(piece.getImageView());
    }

    //初始化黑色的马
    public void blackKnight(){
        chessPiece piece = new chessPiece(1,0,chessType.blackKnight,new KnightStrategy());
        blackChessList.add(piece);
        reshapeImageView(1,0,piece);
        getChildren().add(piece.getImageView());
        chessPiece piece1 = new chessPiece(6,0,chessType.blackKnight,new KnightStrategy());
        blackChessList.add(piece1);
        reshapeImageView(6,0,piece1);
        getChildren().add(piece1.getImageView());
    }

    //初始化黑色的象
    public void blackBishop(){
        chessPiece piece = new chessPiece(2,0,chessType.blackBishop,new BishopStrategy());
        blackChessList.add(piece);
        reshapeImageView(2,0,piece);
        getChildren().add(piece.getImageView());
        chessPiece piece1 = new chessPiece(5,0,chessType.blackBishop,new BishopStrategy());
        blackChessList.add(piece1);
        reshapeImageView(5,0,piece1);
        getChildren().add(piece1.getImageView());
    }

    //初始化黑色的车
    public void blackRook(){
        chessPiece piece = new chessPiece(0,0,chessType.blackRook,new RookStrategy());
        blackChessList.add(piece);
        reshapeImageView(0,0,piece);
        getChildren().add(piece.getImageView());
        chessPiece piece1 = new chessPiece(7,0,chessType.blackRook,new RookStrategy());
        blackChessList.add(piece1);
        reshapeImageView(7,0,piece1);
        getChildren().add(piece1.getImageView());
    }

    //初始化8个白色士兵
    public void whitePawn(){
        for(int i=0;i<8;i++){
            chessPiece piece = new chessPiece(i,6, chessType.whitePawn,new whitePawnStrategy());
            whiteChessList.add(piece);
            reshapeImageView(i,6,piece);
            getChildren().add(piece.getImageView());
        }
    }

    //初始化白国王
    public void whiteKing(){
        chessPiece piece = new chessPiece(4,7,chessType.whiteKing,new KingStrategy());
        whiteChessList.add(piece);
        reshapeImageView(4,7,piece);
        getChildren().add(piece.getImageView());
    }

    //初始化白色皇后
    public void whiteQueue(){
        chessPiece piece = new chessPiece(3,7,chessType.whiteQueen,new QueenStrategy());
        whiteChessList.add(piece);
        reshapeImageView(3,7,piece);
        getChildren().add(piece.getImageView());
    }

    //初始化白色的马
    public void whiteKnight(){
        chessPiece piece = new chessPiece(1,7,chessType.whiteKnight,new KnightStrategy());
        whiteChessList.add(piece);
        reshapeImageView(1,7,piece);
        getChildren().add(piece.getImageView());
        chessPiece piece1 = new chessPiece(6,7,chessType.whiteKnight,new KnightStrategy());
        whiteChessList.add(piece1);
        reshapeImageView(6,7,piece1);
        getChildren().add(piece1.getImageView());
    }

    //初始化白色的象
    public void whiteBishop(){
        chessPiece piece = new chessPiece(2,7,chessType.whiteBishop,new BishopStrategy());
        whiteChessList.add(piece);
        reshapeImageView(2,7,piece);
        getChildren().add(piece.getImageView());
        chessPiece piece1 = new chessPiece(5,7,chessType.whiteBishop,new BishopStrategy());
        whiteChessList.add(piece1);
        reshapeImageView(5,7,piece1);
        getChildren().add(piece1.getImageView());
    }

    //初始化白色的车
    public void whiteRook(){
        chessPiece piece = new chessPiece(0,7,chessType.whiteRook,new RookStrategy());
        whiteChessList.add(piece);
        reshapeImageView(0,7,piece);
        getChildren().add(piece.getImageView());
        chessPiece piece1 = new chessPiece(7,7,chessType.whiteRook,new RookStrategy());
        whiteChessList.add(piece1);
        reshapeImageView(7,7,piece1);
        getChildren().add(piece1.getImageView());
    }



    /**
     * 绘制国际象棋背景
     */
    public void drawBackground(){
        //棋盘颜色设置
        Color a = new Color(181/255.0,136/255.0,99/255.0,1);
        Color b = new Color(240/255.0,217/255.0,181/255.0,1);
        for (int i=0;i<8;i++)
            for(int j=0;j<8;j++) {
                if((i+j)%2==0)
                    gc.setFill(b);
                else
                    gc.setFill(a);
                gc.fillRect(i*cellLen,j*cellLen,cellLen,cellLen);
            }
    }

    public ArrayList getWhiteChessList() {
        return whiteChessList;
    }

    public ArrayList getBlackChessList() {
        return blackChessList;
    }

    public double getCellLen() {
        return cellLen;
    }

    public String getCurrentSide() {
        return currentSide;
    }

    public void setCurrentSide(String currentSide) {
        this.currentSide = currentSide;
    }


}
