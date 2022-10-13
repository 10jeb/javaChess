import java.util.*;

public class King extends Piece {
    public King(Color c) { color = c; }
    // implement appropriate methods

    public String toString() {
        String shade = null;
        String pieceType = "k";
        if (color == Color.BLACK){
            shade = "b";
        } else {
            shade = "w";
        }
        return (shade + pieceType);
    }

    public List<String> moves(Board b, String loc) {
        List<String> possibleMoves = new ArrayList<String>();
        int letterPos = (Character.getNumericValue(loc.charAt(0)) + 87); 
        int numberPos = (Character.getNumericValue(loc.charAt(1)));

        if (letterPos + 1 <= 104){
            if (((b.getPiece(b.coordsToLoc(letterPos+1, numberPos)) != null) && (b.getPiece(b.coordsToLoc(letterPos+1, numberPos)).color() != this.color())) || (b.getPiece(b.coordsToLoc(letterPos+1, numberPos)) == null)){
                possibleMoves.add(b.coordsToLoc(letterPos+1, numberPos));
            }
        }
        if (letterPos - 1 >= 97){
            if (((b.getPiece(b.coordsToLoc(letterPos-1, numberPos)) != null) && (b.getPiece(b.coordsToLoc(letterPos-1, numberPos)).color() != this.color())) || (b.getPiece(b.coordsToLoc(letterPos-1, numberPos)) == null)){
                possibleMoves.add(b.coordsToLoc(letterPos-1, numberPos));
            }
        }
        if (numberPos + 1 <= 8){
            if (((b.getPiece(b.coordsToLoc(letterPos, numberPos+1)) != null) && (b.getPiece(b.coordsToLoc(letterPos, numberPos+1)).color() != this.color())) || (b.getPiece(b.coordsToLoc(letterPos, numberPos+1)) == null)){
                possibleMoves.add(b.coordsToLoc(letterPos, numberPos+1));
            }
        }
        if (numberPos - 1 >= 1){
            if (((b.getPiece(b.coordsToLoc(letterPos, numberPos-1)) != null) && (b.getPiece(b.coordsToLoc(letterPos, numberPos-1)).color() != this.color())) || (b.getPiece(b.coordsToLoc(letterPos, numberPos-1)) == null)){
                possibleMoves.add(b.coordsToLoc(letterPos, numberPos-1));
            }
        }
        if ((numberPos - 1 >= 1) && (letterPos + 1 <= 104)){
            if ((((b.getPiece(b.coordsToLoc(letterPos+1, numberPos-1)) != null) && (b.getPiece(b.coordsToLoc(letterPos+1, numberPos-1)).color() != this.color())) || (b.getPiece(b.coordsToLoc(letterPos+1, numberPos-1)) == null))){
                possibleMoves.add(b.coordsToLoc(letterPos+1, numberPos-1));
            }
        }
        if ((numberPos + 1 <= 8) && (letterPos + 1 <= 104)){
            if ((((b.getPiece(b.coordsToLoc(letterPos+1, numberPos+1)) != null) && (b.getPiece(b.coordsToLoc(letterPos+1, numberPos+1)).color() != this.color())) || (b.getPiece(b.coordsToLoc(letterPos+1, numberPos+1)) == null))){
                possibleMoves.add(b.coordsToLoc(letterPos+1, numberPos+1));
            }
        }
        if ((numberPos - 1 >= 1) && (letterPos - 1 >= 97)){
            if ((((b.getPiece(b.coordsToLoc(letterPos-1, numberPos-1)) != null) && (b.getPiece(b.coordsToLoc(letterPos-1, numberPos-1)).color() != this.color())) || (b.getPiece(b.coordsToLoc(letterPos-1, numberPos-1)) == null))){
                possibleMoves.add(b.coordsToLoc(letterPos-1, numberPos-1));
            }
        }
        if ((numberPos + 1 <= 8) && (letterPos - 1 >= 97)){
            if ((((b.getPiece(b.coordsToLoc(letterPos-1, numberPos+1)) != null) && (b.getPiece(b.coordsToLoc(letterPos-1, numberPos+1)).color() != this.color())) || (b.getPiece(b.coordsToLoc(letterPos-1, numberPos+1)) == null))){
                possibleMoves.add(b.coordsToLoc(letterPos-1, numberPos+1));
            }
        }
        return possibleMoves;
    }

}