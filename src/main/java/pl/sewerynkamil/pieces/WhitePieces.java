package pl.sewerynkamil.pieces;

import javafx.scene.image.Image;
import pl.sewerynkamil.board.Board;

import java.util.HashMap;
import java.util.Map;

public class WhitePieces {

    private Image whitePieceImage = new Image("file:resources/white-piece.png");
    private Image whiteLightPieceImage = new Image("file:resources/white-piece-light.png");

    private Map<PositionsPieces, Piece> whitePiecesMap = new HashMap<>();

    public boolean isFieldNotNull(PositionsPieces position){
        return whitePiecesMap.get(position) != null;
    }

    public void addWhitePieceToMap(PositionsPieces position, Piece piece){
        whitePiecesMap.put(position, piece);
    }

    public void removeWhitePieceFromMap(PositionsPieces position){
        whitePiecesMap.remove(position);
    }

    public void setUpWhitePieces(Board board){
        whitePiecesMap.put(new PositionsPieces(1,5), new Piece(Piece.Color.WHITE));
        whitePiecesMap.put(new PositionsPieces(3,5), new Piece(Piece.Color.WHITE));
        whitePiecesMap.put(new PositionsPieces(5,5), new Piece(Piece.Color.WHITE));
        whitePiecesMap.put(new PositionsPieces(7,5), new Piece(Piece.Color.WHITE));

        whitePiecesMap.put(new PositionsPieces(0,6), new Piece(Piece.Color.WHITE));
        whitePiecesMap.put(new PositionsPieces(2,6), new Piece(Piece.Color.WHITE));
        whitePiecesMap.put(new PositionsPieces(4,6), new Piece(Piece.Color.WHITE));
        whitePiecesMap.put(new PositionsPieces(6,6), new Piece(Piece.Color.WHITE));

        whitePiecesMap.put(new PositionsPieces(1,7), new Piece(Piece.Color.WHITE));
        whitePiecesMap.put(new PositionsPieces(3,7), new Piece(Piece.Color.WHITE));
        whitePiecesMap.put(new PositionsPieces(5,7), new Piece(Piece.Color.WHITE));
        whitePiecesMap.put(new PositionsPieces(7,7), new Piece(Piece.Color.WHITE));

        for(Map.Entry<PositionsPieces, Piece> whitePiece : whitePiecesMap.entrySet()){
            board.addPieceOnBoard(whitePiece.getKey(), whitePieceImage);
        }
    }

    public Image getWhitePieceImage() {
        return whitePieceImage;
    }

    public Image getWhiteLightPieceImage() {
        return whiteLightPieceImage;
    }

    public Map<PositionsPieces, Piece> getWhitePiecesMap() {
        return whitePiecesMap;
    }
}
