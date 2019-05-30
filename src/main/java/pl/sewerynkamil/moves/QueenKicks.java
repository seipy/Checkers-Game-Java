package pl.sewerynkamil.moves;

import pl.sewerynkamil.board.Board;
import pl.sewerynkamil.pieces.PositionsPieces;

import java.util.HashSet;
import java.util.Set;

public class QueenKicks {

    private Board board;

    private Set<PositionsPieces> possibleKickMoves = new HashSet<>();
    private Set<PositionsPieces> possibleKicks = new HashSet<>();

    public QueenKicks(Board board) {
        this.board = board;
    }

    public void calculateAllPossibleQueenKicks(PositionsPieces position){
        possibleKickMoves.clear();

        for(int i = 1; i < 8; i++){
            PositionsPieces upLeft = new PositionsPieces(position.getCol() - i, position.getRow() - i);

            if(calculatePossibleKick(position, upLeft, - 1, - 1)){
                for(int j = 1; j < 8; j ++){

                    if(board.isFieldNull(new PositionsPieces(upLeft.getCol() - j, upLeft.getRow() - j))){
                        if(new PositionsPieces(upLeft.getCol() - j, upLeft.getRow() - j).isValidPosition()){
                            possibleKickMoves.add(new PositionsPieces(upLeft.getCol() - j, upLeft.getRow() - j));
                        }
                    } else {
                        break;
                    }
                }
            }
        }

        for(int i = 1; i < 8; i++){
            PositionsPieces upLeft = new PositionsPieces(position.getCol() - i, position.getRow() + i);

            if(calculatePossibleKick(position, upLeft, - 1, + 1)){
                for(int j = 1; j < 8; j ++){

                    if(board.isFieldNull(new PositionsPieces(upLeft.getCol() - j, upLeft.getRow() + j))){
                        if(new PositionsPieces(upLeft.getCol() - j, upLeft.getRow() + j).isValidPosition()){
                            possibleKickMoves.add(new PositionsPieces(upLeft.getCol() - j, upLeft.getRow() + j));
                        }
                    } else {
                        break;
                    }
                }
            }
        }

        for(int i = 1; i < 8; i++){
            PositionsPieces upLeft = new PositionsPieces(position.getCol() + i, position.getRow() - i);

            if(calculatePossibleKick(position, upLeft, + 1, - 1)){
                for(int j = 1; j < 8; j ++){

                    if(board.isFieldNull(new PositionsPieces(upLeft.getCol() + j, upLeft.getRow() - j))){
                        if(new PositionsPieces(upLeft.getCol() + j, upLeft.getRow() - j).isValidPosition()){
                            possibleKickMoves.add(new PositionsPieces(upLeft.getCol() + j, upLeft.getRow() - j));
                        }
                    } else {
                        break;
                    }
                }
            }
        }

        for(int i = 1; i < 8; i++){
            PositionsPieces upLeft = new PositionsPieces(position.getCol() + i, position.getRow() + i);

            if(calculatePossibleKick(position, upLeft, + 1, + 1)){
                for(int j = 1; j < 8; j ++){

                    if(board.isFieldNull(new PositionsPieces(upLeft.getCol() + j, upLeft.getRow() + j))){
                        if(new PositionsPieces(upLeft.getCol() + j, upLeft.getRow() + j).isValidPosition()){
                            possibleKickMoves.add(new PositionsPieces(upLeft.getCol() + j, upLeft.getRow() + j));
                        }
                    } else {
                        break;
                    }
                }
            }
        }
    }

    private boolean calculatePossibleKick(PositionsPieces actualPosition, PositionsPieces checkPosition, int col, int row) {
        if (checkPosition.isValidPosition() && !board.isFieldNull(checkPosition)) {
            if (board.getPiece(actualPosition).getPieceColor() != board.getPiece(checkPosition).getPieceColor()
                    && board.isFieldNull(new PositionsPieces(checkPosition.getCol() + col, checkPosition.getRow() + row))) {
                return true;
            }
        }
        return false;
    }

    public Set<PositionsPieces> getPossibleKicks() {
        return possibleKicks;
    }

    public Set<PositionsPieces> getPossibleKickMoves() {
        return possibleKickMoves;
    }
}