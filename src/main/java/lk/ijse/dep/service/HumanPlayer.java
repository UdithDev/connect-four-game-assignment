package lk.ijse.dep.service;

public class HumanPlayer extends Player{
     public HumanPlayer(Board board) {
         super(board);
    }

    @Override
    public void movePiece(int col){
         if(board.isLegalMoves(col)){
             board.updateMove(col,Piece.BLUE);
             board.findWinner();
         }
    }
}
