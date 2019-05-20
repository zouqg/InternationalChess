package sample.entity;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import sample.entity.strategy.BishopStrategy;
import sample.entity.strategy.MoveStrategy;

public class chessPiece {
    //棋子坐标
    private int x;
    private int y;

    private double cellLen = 60;

    //棋子类型,记录了对应图标的绝对路径
    private chessType chessType;

    //该棋子是否被选中
    private boolean selected;

    //棋子移动的策略
    private MoveStrategy moveStrategy;

    private ImageView imageView;

    public chessPiece(int x, int y, sample.entity.chessType chessType, MoveStrategy moveStrategy) {
        this.x = x;
        this.y = y;
        this.chessType = chessType;
        this.moveStrategy = moveStrategy;
        Image image = new Image(chessType.getPath());
        imageView = new ImageView(image);
    }

    /**
     * 依靠MoveStrategy 进行移动
     * @param x
     * @param y
     */
    public void move(int x,int y){
        this.x = x;
        this.y = y;
        this.imageView.setX(x*cellLen);
        this.imageView.setY(y*cellLen);
        this.setSelected(false);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public sample.entity.chessType getChessType() {
        return chessType;
    }

    public boolean isSelected() {
        return selected;
    }

    public MoveStrategy getMoveStrategy() {
        return moveStrategy;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public ImageView getImageView() {
        return imageView;
    }

    @Override
    public String toString() {
        return "chessPiece{" +
                "chessType=" + chessType +
                '}';
    }
}
