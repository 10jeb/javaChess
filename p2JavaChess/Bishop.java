import java.util.*;

public class Bishop extends Piece {
    public Bishop(Color c) { color = c; }

    public String toString() {
        String shade = null;
        String pieceType = "b";
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

        while (((numberPos + i) <= 8) && ((letterPos + i) <= 104)){
            int fartherX = letterPos + i;
            int fartherY = numberPos + i;
            if ((b.getPiece(b.coordsToLoc(fartherX, fartherY)) != null) && (b.getPiece(b.coordsToLoc(fartherX, fartherY)).color() != this.color())){
                break;
            }
            if ((fartherX <= 104) && (fartherY <= 8)){
                possibleMoves.add(b.coordsToLoc(fartherX, fartherY));
            }
            i++;
        }
        while (((numberPos + k) <= 8) && ((letterPos - k) >= 97)){
            int fartherY = numberPos + k;
            int lesserX = letterPos - k;
            if ((b.getPiece(b.coordsToLoc(lesserX, fartherY)) != null) && (b.getPiece(b.coordsToLoc(lesserX, fartherY)).color() != this.color())){
                break;
            }
            if ((lesserX >= 97) && (fartherY <= 8)){
                possibleMoves.add(b.coordsToLoc(lesserX, fartherY));
            }
            k++;
        }
        while (((numberPos - j) >= 1) && ((letterPos + j) <= 104)){
            int moreX = letterPos + j;
            int lesserY = numberPos - j;
            if ((b.getPiece(b.coordsToLoc(moreX, lesserY)) != null) && (b.getPiece(b.coordsToLoc(moreX, lesserY)).color() != this.color())){
                break;
            }
            if ((moreX <= 104) && (lesserY >= 1)){
                possibleMoves.add(b.coordsToLoc(moreX, lesserY));
            }
            j++;
        }
        while (((numberPos - l) >= 1) && ((letterPos - l) >= 97)){
            int lesserY = numberPos - l;
            int lessX = letterPos - l;
            if ((b.getPiece(b.coordsToLoc(lessX, lesserY)) != null) && (b.getPiece(b.coordsToLoc(lessX, lesserY)).color() != this.color())){
                break;
            }
            if ((lessX >= 97) && (lesserY >= 1)){
                possibleMoves.add(b.coordsToLoc(lessX, lesserY));
            }
            l++;
        }
        return possibleMoves;
    }
}
