package sample.entity;

public enum chessType{

    //黑方棋子及其图片路径
    blackBishop("file:D:\\Java\\作业\\国际象棋\\images\\blackBishop.png"),
    blackKing("file:D:\\Java\\作业\\国际象棋\\images\\blackKing.png"),
    blackKnight("file:D:\\Java\\作业\\国际象棋\\images\\blackKnight.png"),
    blackPawn("file:D:\\Java\\作业\\国际象棋\\images\\blackPawn.png"),
    blackQueue("file:D:\\Java\\作业\\国际象棋\\images\\blackQueen.png"),
    blackRook("file:D:\\Java\\作业\\国际象棋\\images\\blackRook.png"),

    //白方棋子及其图片路径
    whiteBishop("file:D:\\Java\\作业\\国际象棋\\images\\whiteBishop.png"),
    whiteKing("file:D:\\Java\\作业\\国际象棋\\images\\whiteKing.png"),
    whiteKnight("file:D:\\Java\\作业\\国际象棋\\images\\whiteKnight.png"),
    whitePawn("file:D:\\Java\\作业\\国际象棋\\images\\whitePawn.png"),
    whiteQueen("file:D:\\Java\\作业\\国际象棋\\images\\whiteQueen.png"),
    whiteRook("file:D:\\Java\\作业\\国际象棋\\images\\whiteRook.png");

    //
    private String path;

    private chessType(String s){
        this.path = s;
    }

    public String getPath() {
        return path;
    }

}
