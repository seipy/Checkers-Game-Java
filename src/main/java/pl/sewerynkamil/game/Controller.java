package pl.sewerynkamil.game;

import pl.sewerynkamil.board.Board;
import pl.sewerynkamil.moves.MovesCalculator;
import pl.sewerynkamil.pieces.PositionsPieces;

public class Controller {

    private Board board;
    private MovesCalculator movesCalculator;

    public Controller(Board board, MovesCalculator movesCalculator) {
        this.board = board;
        this.movesCalculator = movesCalculator;
    }

    // You can pick black piece if on the checkPosition is any black piece
    public boolean checkCanSelectBlackPiece(PositionsPieces checkPosition){
        return board.getBlackPieces().getBlackPiecesMap().containsKey(checkPosition);
    }

    // You can pick white piece if on the checkPosition is any white piece
    public boolean checkCanSelectWhitePiece(PositionsPieces checkPosition){
        return board.getWhitePieces().getWhitePiecesMap().containsKey(checkPosition);
    }

    // Return true if there is no piece in the newPosition
    public boolean isFieldNull(PositionsPieces newPosition){
        return !board.getBlackPieces().getBlackPiecesMap().containsKey(newPosition) &&
                !board.getWhitePieces().getWhitePiecesMap().containsKey(newPosition);
    }








    /*// Scan board for searching kick possibility for black pieces
    public boolean checkPossibleKickByBlackPiece(){
        boolean isPossibleToKick = movesCalculator.calculateAllPossibleBlackKicks().stream()
                .anyMatch(board.getWhitePieces().getWhitePiecesMap()::containsKey);

        return isPossibleToKick;
    }

    // Scan board for searching kick possibility for white pieces
    public boolean checkPossibleKickByWhitePiece(){
       boolean isPossibleToKick = movesCalculator.calculateAllPossibleWhiteKicks().stream()
               .anyMatch(board.getBlackPieces().getBlackPiecesMap()::containsKey);

       return isPossibleToKick;
    }

    // Scan board for searching move kick possibility for black pieces
    public boolean checkPossibleMoveKickByBlackPiece(){
        for(PositionsPieces possibleBlackKicks : movesCalculator.calculateAllPossibleBlackKicks()){
            if(board.getWhitePieces().getWhitePiecesMap().containsKey(possibleBlackKicks)){
                return true;
            }
        }
        return false;
    }*/
}
