import java.util.*;

public class Knight extends Piece {
    public Knight(Color c) { color = c; }

    public String toString() {
        String shade = null;
        String pieceType = "n";
        if (color == Color.BLACK){
            shade = "b";
        } else {
            shade = "w";
        }
        return (shade + pieceType);
    }

    public List<String> moves(Board b, String loc) {
        List<String> possibleMoves = new ArrayList<String>();
        int letterPos = (Character.getNumericValue(loc.charAt(0)) + 87); //104 & 97
        int numberPos = (Character.getNumericValue(loc.charAt(1)));

        //moving east then north or south
        if (letterPos + 2 <= 104){
            if ((numberPos + 1) <= 8) {
                if (((b.getPiece(b.coordsToLoc(letterPos+2, numberPos+1)) != null) && (b.getPiece(b.coordsToLoc(letterPos+2, numberPos+1)).color() != this.color())) || (b.getPiece(b.coordsToLoc(letterPos+2, numberPos+1)) == null)) {
                    possibleMoves.add(b.coordsToLoc(letterPos+2, numberPos+1));
                }
            }
            if ((numberPos - 1) >= 1) {
                if (((b.getPiece(b.coordsToLoc(letterPos+2, numberPos-1)) != null) && (b.getPiece(b.coordsToLoc(letterPos+2, numberPos-1)).color() != this.color())) || (b.getPiece(b.coordsToLoc(letterPos+2, numberPos-1)) == null)) {
                    possibleMoves.add(b.coordsToLoc(letterPos+2, numberPos-1));
                }
            }
        }
        //moving west then north or south
        if (letterPos - 2 >= 97){
            if ((numberPos + 1) <= 8) {
                if (((b.getPiece(b.coordsToLoc(letterPos-2, numberPos+1)) != null) && (b.getPiece(b.coordsToLoc(letterPos-2, numberPos+1)).color() != this.color())) || (b.getPiece(b.coordsToLoc(letterPos-2, numberPos+1)) == null)) {
                    possibleMoves.add(b.coordsToLoc(letterPos-2, numberPos+1));
                }
            }
            if ((numberPos - 1) >= 1) {
                if (((b.getPiece(b.coordsToLoc(letterPos-2, numberPos-1)) != null) && (b.getPiece(b.coordsToLoc(letterPos-2, numberPos-1)).color() != this.color())) || (b.getPiece(b.coordsToLoc(letterPos-2, numberPos-1)) == null)) {
                    possibleMoves.add(b.coordsToLoc(letterPos-2, numberPos-1));
                }
            }
        }
        //move south then east or west
        if (numberPos - 2 >= 1){
            if ((letterPos + 1) <= 104) {
                if (((b.getPiece(b.coordsToLoc(letterPos+1, numberPos-2)) != null) && (b.getPiece(b.coordsToLoc(letterPos+1, numberPos-2)).color() != this.color())) || (b.getPiece(b.coordsToLoc(letterPos+1, numberPos-2)) == null)) {
                    possibleMoves.add(b.coordsToLoc(letterPos+1, numberPos-2));
                }
            }
            if ((letterPos - 1) >= 97) {
                if (((b.getPiece(b.coordsToLoc(letterPos-1, numberPos-2)) != null) && (b.getPiece(b.coordsToLoc(letterPos-1, numberPos-2)).color() != this.color())) || (b.getPiece(b.coordsToLoc(letterPos-1, numberPos-2)) == null)) {
                    possibleMoves.add(b.coordsToLoc(letterPos-1, numberPos-2));
                }
            }
        }
        //move north then east or west
        if (numberPos + 2 <= 8){
            if ((letterPos + 1) <= 104) {
                if (((b.getPiece(b.coordsToLoc(letterPos+1, numberPos+2)) != null) && (b.getPiece(b.coordsToLoc(letterPos+1, numberPos+2)).color() != this.color())) || (b.getPiece(b.coordsToLoc(letterPos+1, numberPos+2)) == null)) {
                    possibleMoves.add(b.coordsToLoc(letterPos+1, numberPos+2));
                }
            }
            if ((letterPos - 1) >= 97) {
                if (((b.getPiece(b.coordsToLoc(letterPos-1, numberPos+2)) != null) && (b.getPiece(b.coordsToLoc(letterPos-1, numberPos+2)).color() != this.color())) || (b.getPiece(b.coordsToLoc(letterPos-1, numberPos+2)) == null)) {
                    possibleMoves.add(b.coordsToLoc(letterPos-1, numberPos+2));
                }
            }
        }
        return possibleMoves;
    }

}