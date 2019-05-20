package pl.sewerynkamil.moves;

import pl.sewerynkamil.board.Board;
import pl.sewerynkamil.game.Controller;
import pl.sewerynkamil.pieces.PositionsPieces;

import java.util.HashSet;
import java.util.Set;

public class PieceMoves {

    private KickScanner kickScanner;
    private Controller controller;
    private Board board;

    private Set<PositionsPieces> possibleBlackPieceMoves = new HashSet<>();
    private Set<PositionsPieces> possibleWhitePieceMoves = new HashSet<>();

    private Set<PositionsPieces> possibleBlackPieceMovesAfterKick = new HashSet<>();
    private Set<PositionsPieces> possibleWhitePieceMovesAfterKick = new HashSet<>();

    private Set<PositionsPieces> possibleMoves = new HashSet<>();

    public PieceMoves(Board board, KickScanner kickScanner, Controller controller){
        this.board = board;
        this.kickScanner = kickScanner;
        this.controller = controller;
    }

    public Set<PositionsPieces> moveBlack(PositionsPieces actualPosition) {
        possibleBlackPieceMoves.clear();
        move(actualPosition, possibleBlackPieceMoves, true);
        return possibleBlackPieceMoves;
    }

    public Set<PositionsPieces> moveWhite(PositionsPieces actualPosition){
        possibleWhitePieceMoves.clear();
        move(actualPosition, possibleWhitePieceMoves, false);
        return possibleWhitePieceMoves;
    }

    private void move(PositionsPieces actualPosition, Set<PositionsPieces> positionsPieces, boolean up) {
        int direction = up ? 1 : -1;

        PositionsPieces left = new PositionsPieces(actualPosition.getCol() - 1, actualPosition.getRow() + direction);
        PositionsPieces right = new PositionsPieces(actualPosition.getCol() + 1, actualPosition.getRow() + direction);

        // Move forward-left
        if (left.isValidPosition() && controller.isFieldNull(left)) {
            positionsPieces.add(left);
        }
        // Move forward-right
        if (right.isValidPosition() && controller.isFieldNull(right)) {
            positionsPieces.add(right);
        }
    }

    public Set<PositionsPieces> moveAfterKick(PositionsPieces position){
        possibleMoves.clear();

        if(!board.getBlackPieces().isFieldNotNull(new PositionsPieces(position.getCol() - 1, position.getRow() - 1))
                && board.getWhitePieces().isFieldNotNull(new PositionsPieces(position.getCol() - 1, position.getRow() - 1))
                && new PositionsPieces(position.getCol() - 1, position.getRow() - 1).isValidPosition()){

            possibleMoves.add(new PositionsPieces(position.getCol() - 2, position.getRow() - 2));
        }

        if(!board.getBlackPieces().isFieldNotNull(new PositionsPieces(position.getCol() + 1, position.getRow() - 1))
                && board.getWhitePieces().isFieldNotNull(new PositionsPieces(position.getCol() + 1, position.getRow() - 1))
                && new PositionsPieces(position.getCol() + 1, position.getRow() - 1).isValidPosition()){

            possibleMoves.add(new PositionsPieces(position.getCol() + 2, position.getRow() - 2));
        }

        if(!board.getBlackPieces().isFieldNotNull(new PositionsPieces(position.getCol() - 1, position.getRow() + 1))
                && board.getWhitePieces().isFieldNotNull(new PositionsPieces(position.getCol() - 1, position.getRow() + 1))
                && new PositionsPieces(position.getCol() - 1, position.getRow() + 1).isValidPosition()){

            possibleMoves.add(new PositionsPieces(position.getCol() - 2, position.getRow() + 2));
        }

        if(!board.getBlackPieces().isFieldNotNull(new PositionsPieces(position.getCol() + 1, position.getRow() + 1))
                && board.getWhitePieces().isFieldNotNull(new PositionsPieces(position.getCol() + 1, position.getRow() + 1))
                && new PositionsPieces(position.getCol() + 1, position.getRow() + 1).isValidPosition()){

            possibleMoves.add(new PositionsPieces(position.getCol() + 2, position.getRow() + 2));
        }

        return possibleMoves;
    }

    public Set<PositionsPieces> moveBlackKick(PositionsPieces actualPosition) {
        possibleBlackPieceMovesAfterKick.clear();
        moveAfterKick(actualPosition, possibleBlackPieceMovesAfterKick, true);
        return possibleBlackPieceMovesAfterKick;
    }

    public Set<PositionsPieces> moveWhiteKick(PositionsPieces actualPosition){
        possibleWhitePieceMovesAfterKick.clear();
        moveAfterKick(actualPosition, possibleWhitePieceMovesAfterKick, false);
        return possibleWhitePieceMovesAfterKick;
    }

    private void moveAfterKick(PositionsPieces actualPosition, Set<PositionsPieces> positionsPieces, boolean up) {
        int direction = up ? 2 : -2;

        PositionsPieces forwardLeft = new PositionsPieces(actualPosition.getCol() - 2, actualPosition.getRow() + direction);
        PositionsPieces forwardRight = new PositionsPieces(actualPosition.getCol() + 2, actualPosition.getRow() + direction);
        PositionsPieces backwardLeft = new PositionsPieces(actualPosition.getCol() - 2, actualPosition.getRow() - direction);
        PositionsPieces backwardRight = new PositionsPieces(actualPosition.getCol() + 2, actualPosition.getRow() - direction);

        // Move forward-left
        if (forwardLeft.isValidPosition() &&
                !board.getBlackPieces().isFieldNotNull(forwardLeft) &&
                !board.getWhitePieces().isFieldNotNull(forwardLeft)) {
            positionsPieces.add(forwardLeft);
        }
        // Move forward-right
        if (forwardRight.isValidPosition() && !board.getBlackPieces().isFieldNotNull(forwardRight) && !board.getWhitePieces().isFieldNotNull(forwardRight)) {
            positionsPieces.add(forwardRight);
        }
        // Move backward-left
        if (backwardLeft.isValidPosition() && !board.getBlackPieces().isFieldNotNull(backwardLeft) && !board.getWhitePieces().isFieldNotNull(backwardLeft)) {
            positionsPieces.add(backwardLeft);
        }
        // Move backward-right
        if (backwardRight.isValidPosition() && !board.getBlackPieces().isFieldNotNull(backwardRight) && !board.getWhitePieces().isFieldNotNull(backwardRight)) {
            positionsPieces.add(backwardRight);
        }
    }

    // King moves - later

    public Set<PositionsPieces> getPossibleBlackPieceMoves() {
        return possibleBlackPieceMoves;
    }

    public Set<PositionsPieces> getPossibleWhitePieceMoves() {
        return possibleWhitePieceMoves;
    }

    public Set<PositionsPieces> getPossibleBlackPieceMovesAfterKick() {
        return possibleBlackPieceMovesAfterKick;
    }

    public Set<PositionsPieces> getPossibleWhitePieceMovesAfterKick() {
        return possibleWhitePieceMovesAfterKick;
    }

    public Set<PositionsPieces> getPossibleMoves() {
        return possibleMoves;
    }
}

