package lk.ijse.dep.service;

import java.util.Random;

public class AiPlayer extends Player{
    public AiPlayer(Board board) {
        super(board);
    }

    @Override
    public void movePiece(int col){
        Random input = new Random();
        boolean flag=true;/* what is the flag ?*/
        do {
            col = (getCol()!=-1) ? getCol() : input.nextInt(6);
            if(board.isLegalMoves(col)){
                board.updateMove(col,Piece.GREEN);
                board.findWinner();
                flag=false;
            }
        }while (flag);
    }


    public int getCol() {
        for (int i = 0; i < 5; i++) {
            int countHuman = 0;
            for (int j = 0; j < 4; j++) {
                if (BoardImpl.pieces[j][i] == Piece.BLUE) {
                    countHuman++;
                }
            }
            if (countHuman == 3 & BoardImpl.pieces[3][i] == Piece.EMPTY) {
                return 3;
            } else {
                for (int x = 0; x < 5; x++) {
                    int countHuman1 = 0;
                    for (int y = 1; y < 5; y++) {
                        if (BoardImpl.pieces[y][x] == Piece.BLUE) {
                            countHuman1++;
                        }
                    }
                    if (countHuman1 == 3 & BoardImpl.pieces[4][x] == Piece.EMPTY) {
                        return 4;
                    } else {
                        for (int m = 0; m < 5; m++) {
                            int countHuman11 = 0;
                            for (int l = 2; l < 6; l++) {
                                if (BoardImpl.pieces[l][m] == Piece.BLUE) {
                                    countHuman11++;
                                }
                            }
                            if (countHuman11 == 3 & BoardImpl.pieces[5][m] == Piece.EMPTY) {
                                return 5;
                            }
                        }
                    }
                }
            }
        }

        for (int i = 0; i < 6; i++) {
            int countHuman1 = 0;
            for (int j = 0; j < 4; j++) {
                if (BoardImpl.pieces[i][j] == Piece.BLUE) {
                    countHuman1++;
                }
                if (countHuman1 == 3 & BoardImpl.pieces[i][3] == Piece.EMPTY) {
                    return i;
                }
                else {
                    for (int x = 0; x < 6; x++) {
                        int countHuman11 = 0;
                        for (int y = 1; y < 5; y++) {
                            if (BoardImpl.pieces[x][y] == Piece.BLUE) {
                                countHuman11++;
                            }
                            if (countHuman11 == 3 & BoardImpl.pieces[i][3] == Piece.EMPTY) {
                                return i;
                            }
                        }
                    }
                }
            }
        }
        return -1;
    }
}


