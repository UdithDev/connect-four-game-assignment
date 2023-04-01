package lk.ijse.dep.service;

public class BoardImpl implements Board {

    public static Piece [] [] pieces;
    final BoardUI boardUI;

    static {
        System.out.println("BoardImpl class loaded");
    }

    public BoardImpl(BoardUI boardUI) {
        this.boardUI = boardUI;
        pieces = new Piece[NUM_OF_COLS][NUM_OF_ROWS];
        setArrayValues();
        System.out.println("Array initialized");
    }
    public void setArrayValues(){
        for (int i = 0; i<NUM_OF_COLS; i++){
            for (int j=0; j< NUM_OF_ROWS; j++){
                pieces[i][j] = Piece.EMPTY;
            }
        }
        System.out.println("Values set to Piece.Empty");
    }

    @Override
    public boolean isLegalMoves(int col) {
        System.out.println("in islegalMove method");
        for (int i = 0; i<NUM_OF_ROWS; i++ ){
            if(pieces[col][i].equals(Piece.EMPTY)) {
                System.out.println("legal move");
                return true;
            }
        }
        System.out.println("illegal move");
        return false;
    }

    @Override
    public int findNextAvailableSpot(int col) {
        System.out.println("in findNextAvailableSpot method");
        for (int i = 0; i<pieces[col].length; i++){
            if(pieces[col][i].equals(Piece.EMPTY)) return i;
        }
        System.out.println("no any available spot");
        return -1;
    }

    @Override
    public BoardUI getBoardUi() {
        return boardUI;
    }

    @Override
    public boolean existLegalMoves() {
        //  System.out.print("existsLegalMove method:  ");
        for (Piece [] elementGroup : pieces){
            for (Piece ele: elementGroup){
                if(ele.equals(Piece.EMPTY)) {
                    //    System.out.println("move exists");
                    return false;
                }
            }
        }
        System.out.println("move not exists");
        return true;
    }

    @Override
    public void updateMove(int col, Piece move) {
        pieces[col][findNextAvailableSpot(col)] = move;
        System.out.println("Array updated");
        boardUI.update(col, !move.equals(Piece.GREEN));
        System.out.println("UI updated\n");
    }

    @Override
    public Winner findWinner(){
    }
}