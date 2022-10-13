import java.util.*;

public class Rook extends Piece {
    public Rook(Color c) { color = c; }
    // implement appropriate methods

    public String toString() {
        String shade = null;
        String pieceType = "r";
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
        int i = 1;
        int j = 1;
        int k = 1;
        int l = 1;

        while ((numberPos + i) <= 8){
            int fartherY = numberPos + i;
            if ((b.getPiece(b.coordsToLoc(letterPos, fartherY)) != null) && (b.getPiece(b.coordsToLoc(letterPos, fartherY)).color() != this.color())){
                break;
            }
            if ((letterPos <= 104) && (fartherY <= 8)){
                possibleMoves.add(b.coordsToLoc(letterPos, fartherY));
            }
            i++;
        }
        while ((letterPos + k) <= 104){
            int fartherX = letterPos + k;
            if ((b.getPiece(b.coordsToLoc(fartherX, numberPos)) != null) && (b.getPiece(b.coordsToLoc(fartherX, numberPos)).color() != this.color())){
                break;
            }
            if ((fartherX <= 104) && (numberPos <= 8)){
                possibleMoves.add(b.coordsToLoc(fartherX, numberPos));
            }
            k++;
        }
        while ((numberPos - j) >= 1){
            int lesserY = numberPos - j;
            if ((b.getPiece(b.coordsToLoc(letterPos, lesserY)) != null) && (b.getPiece(b.coordsToLoc(letterPos, lesserY)).color() != this.color())){
                break;
            }
            if ((letterPos >= 97) && (lesserY >= 1)){
                possibleMoves.add(b.coordsToLoc(letterPos, lesserY));
            }
            j++;
        }
        while ((letterPos - l) >= 97){
            int lesserX = letterPos - l;
            if ((b.getPiece(b.coordsToLoc(lesserX, numberPos)) != null) && (b.getPiece(b.coordsToLoc(lesserX, numberPos)).color() != this.color())){
                break;
            }
            if ((lesserX >= 97) && (numberPos >= 1)){
                possibleMoves.add(b.coordsToLoc(lesserX, numberPos));
            }
            l++;
        }
        return possibleMoves;
    }

}